package io.github.emm035.openapi.immutables.v3.security;

import com.google.common.base.Preconditions;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractHttpScheme implements SecurityScheme {

  public abstract String getScheme();
  public abstract Optional<String> getBearerFormat();

  @Override
  @Derived
  public Type getType() {
    return Type.HTTP;
  }

  @Check
  private HttpScheme normalizeExtensions(HttpScheme securityScheme) {
    Preconditions.checkState(!getScheme().equals("bearer") || getBearerFormat().isPresent(), "'bearerFormat' is required for scheme 'bearer'");

    if (securityScheme.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return securityScheme;
    }
    HttpScheme.Builder newSecurityScheme = HttpScheme.builder()
      .from(securityScheme);
    securityScheme.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newSecurityScheme.putExtensions(e.getKey(), e.getValue()));
    return newSecurityScheme.build();
  }
}
