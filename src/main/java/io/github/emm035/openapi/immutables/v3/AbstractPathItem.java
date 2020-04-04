package io.github.emm035.openapi.immutables.v3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableMap;
import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.HttpMethod;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.base.Summarizable;
import io.github.emm035.openapi.immutables.v3.components.parameters.base.Parameter;
import io.github.emm035.openapi.immutables.v3.servers.Server;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Lazy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.immutables.value.Value.Check;

@Immutable
@OpenApiStyle
public abstract class AbstractPathItem implements Summarizable, Describable, Extensible {
  public abstract List<Server> getServers();
  public abstract List<RefOr<Parameter>> getParameters();

  public abstract Optional<Operation> getGet();
  public abstract Optional<Operation> getPut();
  public abstract Optional<Operation> getPost();
  public abstract Optional<Operation> getPatch();
  public abstract Optional<Operation> getDelete();
  public abstract Optional<Operation> getOptions();
  public abstract Optional<Operation> getHead();
  public abstract Optional<Operation> getTrace();

  @JsonIgnore
  @Lazy
  public Map<HttpMethod, Operation> getOperations() {
    ImmutableMap.Builder<HttpMethod, Operation> builder = ImmutableMap.builder();

    getGet().ifPresent(op -> builder.put(HttpMethod.GET, op));
    getPut().ifPresent(op -> builder.put(HttpMethod.PUT, op));
    getPost().ifPresent(op -> builder.put(HttpMethod.POST, op));
    getPatch().ifPresent(op -> builder.put(HttpMethod.PATCH, op));
    getDelete().ifPresent(op -> builder.put(HttpMethod.DELETE, op));
    getOptions().ifPresent(op -> builder.put(HttpMethod.OPTIONS, op));
    getHead().ifPresent(op -> builder.put(HttpMethod.HEAD, op));
    getTrace().ifPresent(op -> builder.put(HttpMethod.TRACE, op));

    return builder.build();
  }

  @Check
  private PathItem normalizeExtensions(PathItem extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return PathItem.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
