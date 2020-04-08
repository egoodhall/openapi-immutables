package io.github.emm035.openapi.immutables.v3.schemas;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.Enumerated;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

import static org.immutables.value.Value.Check;
import static org.immutables.value.Value.Default;

@OpenApiStyle
@Immutable
public abstract class AbstractStringSchema implements TypedSchema, Enumerated<String> {
  @Override
  @Default
  public Type getType() {
    return Type.STRING;
  }
  public abstract Optional<String> getFormat();
  public abstract Optional<String> getPattern();

  public static final class Format {
    public static final String DATE = "date";
    public static final String DATE_TIME = "date-time";
    public static final String PASSWORD = "password";
    public static final String BYTE = "byte";
    public static final String BINARY = "binary";
  }

  @Check
  private StringSchema normalizeExtensions(StringSchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return StringSchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
