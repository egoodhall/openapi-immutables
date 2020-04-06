package io.github.emm035.openapi.immutables.v3.schemas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.references.RefOr;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.List;


@OpenApiStyle
@Immutable
// Necessary to override deserializer for io.github.emm035.open.api.core.v3.components.schemas.Schema
@JsonDeserialize
public abstract class AbstractAnyOfSchema implements Schema {
  public abstract List<RefOr<Schema>> getAnyOf();

  public static AnyOfSchema of(RefOr<Schema>... schemas) {
    return AnyOfSchema.builder()
      .addAnyOf(schemas)
      .build();
  }

  @Check
  private AnyOfSchema normalizeExtensions(AnyOfSchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return AnyOfSchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
