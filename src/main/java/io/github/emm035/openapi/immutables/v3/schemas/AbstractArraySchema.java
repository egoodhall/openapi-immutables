package io.github.emm035.openapi.immutables.v3.schemas;

import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
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
  public abstract Referenceable<Schema> getItems();

  public abstract Optional<Boolean> getUniqueItems();
  public abstract Optional<Integer> getMinItems();
  public abstract Optional<Integer> getMaxItems();

  @Check
  AbstractArraySchema normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return ArraySchema.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
