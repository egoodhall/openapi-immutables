package io.github.emm035.openapi.immutables.v3.components.security.flows;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.Map;
import java.util.Optional;


@OpenApiStyle
@Immutable
public interface AuthorizationCodeFlowIF extends Flow {
  String getAuthorizationUrl();
  String getTokenUrl();
  Optional<String> getRefreshUrl();
  Map<String, String> getScopes();
}
