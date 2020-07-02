package io.github.emm035.openapi.immutables.v3.servers;

import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
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
  protected AbstractServer normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return Server.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
