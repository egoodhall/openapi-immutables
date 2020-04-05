package io.github.emm035.openapi.immutables.v3.components.examples;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
@JsonDeserialize
public abstract class AbstractValueExample implements Example {
  public abstract Object getValue();

  @Check
  private ValueExample normalizeExtensions(ValueExample extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return ValueExample.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
