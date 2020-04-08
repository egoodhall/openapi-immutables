package io.github.emm035.openapi.immutables.v3.security;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public abstract class AbstractOAuth2Scheme implements SecurityScheme {

  @Override
  @Value.Derived
  public Type getType() {
    return Type.OAUTH2;
  }

  @Value.Check
  private OAuth2Scheme normalizeExtensions(OAuth2Scheme securityScheme) {
    if (securityScheme.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return securityScheme;
    }
    OAuth2Scheme.Builder newSecurityScheme = OAuth2Scheme.builder()
      .from(securityScheme);
    securityScheme.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newSecurityScheme.putExtensions(e.getKey(), e.getValue()));
    return newSecurityScheme.build();
  }
}
