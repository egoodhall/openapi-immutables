package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractContact implements Extensible {
  public abstract Optional<String> getName();
  public abstract Optional<String> getUrl();
  public abstract Optional<String> getEmail();

  @Check
  private Contact normalizeExtensions(Contact extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return Contact.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}