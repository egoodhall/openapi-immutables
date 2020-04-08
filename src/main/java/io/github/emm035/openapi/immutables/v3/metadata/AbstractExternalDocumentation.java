package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractExternalDocumentation implements Extensible {
  public abstract Optional<String> getDescription();
  public abstract String getUrl();

  @Check
  private ExternalDocumentation normalizeExtensions(ExternalDocumentation extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return ExternalDocumentation.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
