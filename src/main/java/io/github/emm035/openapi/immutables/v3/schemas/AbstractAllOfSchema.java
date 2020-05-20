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
public abstract class AbstractAllOfSchema implements Schema {
  public abstract List<RefOr<Schema>> getAllOf();

  public static AllOfSchema of(RefOr<Schema>... schemas) {
    return AllOfSchema.builder()
      .addAllOf(schemas)
      .build();
  }

  @Check
  AbstractAllOfSchema normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return AllOfSchema.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
