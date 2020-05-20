package io.github.emm035.openapi.immutables.v3.servers;

import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
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
  AbstractServerVariable normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return ServerVariable.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
