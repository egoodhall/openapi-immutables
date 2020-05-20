package io.github.emm035.openapi.immutables.v3.schemas;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
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
  AbstractBooleanSchema normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return BooleanSchema.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
