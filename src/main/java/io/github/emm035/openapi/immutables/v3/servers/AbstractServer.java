package io.github.emm035.openapi.immutables.v3.servers;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.util.Map;
import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractServer implements Extensible {
  @Parameter
  public abstract String getUrl();
  public abstract Optional<String> getDescription();
  public abstract Map<String, ServerVariable> getVariables();

  @Check
  private Server normalizeExtensions(Server extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return Server.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
