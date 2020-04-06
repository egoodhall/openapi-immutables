package io.github.emm035.openapi.immutables.v3.examples;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.Summarizable;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Optional;


@Immutable
@OpenApiStyle
@JsonDeserialize
public abstract class AbstractExternalExample implements Example, Summarizable {
  public abstract Optional<String> getExternalValue();

  @Check
  private ExternalExample normalizeExtensions(ExternalExample extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return ExternalExample.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
