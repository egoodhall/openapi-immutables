package io.github.emm035.openapi.immutables.v3.servers;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;

import java.util.List;
import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractServerVariable implements Extensible {
  public abstract List<String> getEnum();
  public abstract String getDefault();
  public abstract Optional<String> getDescription();

  @Value.Check
  private ServerVariable normalizeExtensions(ServerVariable extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return ServerVariable.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
