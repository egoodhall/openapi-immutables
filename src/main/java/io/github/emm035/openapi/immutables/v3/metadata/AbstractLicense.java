package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractLicense implements Extensible {
  @Parameter
  public abstract String getName();
  @Parameter
  public abstract Optional<String> getUrl();

  @Check
  private License normalizeExtensions(License extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return License.builder()
      .from(extensible)
      .setExtensions(Extensible.Checks.validExtensions(extensible))
      .build();
  }
}
