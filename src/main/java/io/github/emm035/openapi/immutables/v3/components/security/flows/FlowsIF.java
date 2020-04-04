package io.github.emm035.openapi.immutables.v3.components.security.flows;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.Optional;


@OpenApiStyle
@Immutable
public interface FlowsIF {
  Optional<ImplicitFlow> getImplicit();
  Optional<PasswordFlow> getPassword();
  Optional<ClientCredentialsFlow> getClientCredentials();
  Optional<AuthorizationCodeFlow> getAuthorizationCode();
}
