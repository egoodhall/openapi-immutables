package io.github.emm035.openapi.immutables.v3.components.schemas;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;


@OpenApiStyle
@Immutable
public abstract class AbstractBooleanSchema implements TypedSchema {
  @Override
  @Default
  public Type getType() {
    return Type.BOOLEAN;
  }

  public static BooleanSchema of() {
    return BooleanSchema.builder().build();
  }

  public static BooleanSchema withDefault(boolean defaultValue) {
    return BooleanSchema.builder()
      .setDefault(defaultValue)
      .build();
  }

  @Check
  private BooleanSchema normalizeExtensions(BooleanSchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return BooleanSchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
