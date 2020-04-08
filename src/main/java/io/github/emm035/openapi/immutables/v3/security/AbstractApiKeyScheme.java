package io.github.emm035.openapi.immutables.v3.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public abstract class AbstractApiKeyScheme implements SecurityScheme {

  public abstract String getName();
  public abstract Location getIn();

  @Value.Derived
  public Type getType() {
    return Type.API_KEY;
  }

  static enum Location {
    QUERY,
    HEADER,
    COOKIE;

    @JsonCreator
    static Location fromString(@JsonProperty String rawValue) {
      return valueOf(rawValue.toUpperCase());
    }

    @Override
    @JsonValue
    public String toString() {
      return name().toLowerCase();
    }
  }

  @Check
  private ApiKeyScheme normalizeExtensions(ApiKeyScheme securityScheme) {
    if (securityScheme.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return securityScheme;
    }
    ApiKeyScheme.Builder newSecurityScheme = ApiKeyScheme.builder()
      .from(securityScheme);
    securityScheme.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newSecurityScheme.putExtensions(e.getKey(), e.getValue()));
    return newSecurityScheme.build();
  }
}
