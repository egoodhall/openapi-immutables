package io.github.emm035.openapi.immutables.v3.components.schemas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.CaseFormat;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;

import java.util.Optional;


@OpenApiStyle
@Immutable
public abstract class AbstractNumberSchema implements NumericSchema<Double> {
  @Override
  @Derived
  public Type getType() {
    return Type.NUMBER;
  }

  public abstract Optional<Format> getFormat();

  public static enum Format {
    FLOAT,
    DOUBLE;

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
  private NumberSchema normalizeExtensions(NumberSchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return NumberSchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
