package io.github.emm035.openapi.immutables.v3.components.security;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.security.base.SecurityScheme;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public abstract class AbstractOpenIdConnectScheme implements SecurityScheme {

  @Override
  @Value.Derived
  public SecurityScheme.Type getType() {
    return SecurityScheme.Type.OPEN_ID_CONNECT;
  }

  @Value.Check
  private OpenIdConnectScheme normalizeExtensions(OpenIdConnectScheme securityScheme) {
    if (securityScheme.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return securityScheme;
    }
    OpenIdConnectScheme.Builder newSecurityScheme = OpenIdConnectScheme.builder()
      .from(securityScheme);
    securityScheme.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newSecurityScheme.putExtensions(e.getKey(), e.getValue()));
    return newSecurityScheme.build();
  }
}
