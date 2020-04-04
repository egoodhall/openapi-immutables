package io.github.emm035.openapi.immutables.v3.components.schemas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.CaseFormat;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.schemas.base.NumericSchema;
import io.github.emm035.openapi.immutables.v3.components.schemas.base.TypedSchema;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;

import java.util.Optional;


@OpenApiStyle
@Immutable
public abstract class AbstractIntegerSchema implements TypedSchema, NumericSchema<Long> {
  @Override
  @Derived
  public Type getType() {
    return Type.INTEGER;
  }

  public abstract Optional<Format> getFormat();

  public static enum Format {
    INT32,
    INT64;

    @JsonCreator
    private static Format fromString(@JsonProperty String rawValue) {
      return valueOf(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, rawValue));
    }

    @Override
    @JsonValue
    public String toString() {
      return name().toLowerCase();
    }
  }

  @Check
  private IntegerSchema normalizeExtensions(IntegerSchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return IntegerSchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
