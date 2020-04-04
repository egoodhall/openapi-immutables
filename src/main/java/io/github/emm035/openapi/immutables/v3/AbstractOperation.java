package io.github.emm035.openapi.immutables.v3;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.base.Deprecatable;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.base.Summarizable;
import io.github.emm035.openapi.immutables.v3.components.content.RequestBody;
import io.github.emm035.openapi.immutables.v3.components.content.Responses;
import io.github.emm035.openapi.immutables.v3.components.parameters.base.Parameter;
import io.github.emm035.openapi.immutables.v3.metadata.ExternalDocumentation;
import io.github.emm035.openapi.immutables.v3.security.SecurityRequirement;
import io.github.emm035.openapi.immutables.v3.servers.Server;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractOperation implements Summarizable, Describable, Extensible, Deprecatable {
  public abstract Responses getResponses();
  public abstract Optional<RefOr<RequestBody>> getRequestBody();
  public abstract Optional<ExternalDocumentation> getExternalDocs();
  public abstract Optional<String> getOperationId();
  public abstract List<String> getTags();
  public abstract List<RefOr<Parameter>> getParameters();
  public abstract List<Server> getServers();
  public abstract List<SecurityRequirement> getSecurity();
  // TODO: - Callbacks
  public abstract Map<String, Object> getCallbacks();

  @Check
  private Operation normalizeExtensions(Operation extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return Operation.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
