package io.github.emm035.openapi.immutables.v3.components.schemas;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.schemas.base.Schema;
import io.github.emm035.openapi.immutables.v3.components.schemas.base.TypedSchema;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import java.util.Optional;

import static org.immutables.value.Value.Default;


@OpenApiStyle
@Immutable
public abstract class AbstractArraySchema implements TypedSchema {
  @Override
  @Default
  public Type getType() {
    return Type.ARRAY;
  }
  @Parameter
  public abstract RefOr<Schema> getItems();

  public abstract Optional<Boolean> getUniqueItems();
  public abstract Optional<Integer> getMinItems();
  public abstract Optional<Integer> getMaxItems();

  @Check
  private ArraySchema normalizeExtensions(ArraySchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return ArraySchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
