package io.github.emm035.openapi.immutables.v3;

import io.github.emm035.openapi.immutables.v3.metadata.ExternalDocumentation;
import io.github.emm035.openapi.immutables.v3.parameters.Parameter;
import io.github.emm035.openapi.immutables.v3.references.RefOr;
import io.github.emm035.openapi.immutables.v3.requests.RequestBody;
import io.github.emm035.openapi.immutables.v3.responses.Responses;
import io.github.emm035.openapi.immutables.v3.security.SecurityRequirement;
import io.github.emm035.openapi.immutables.v3.servers.Server;
import io.github.emm035.openapi.immutables.v3.shared.Deprecatable;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.Summarizable;
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
  AbstractOperation normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return Operation.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
