package io.github.emm035.openapi.immutables.v3.components.schemas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import org.immutables.value.Value;
import org.immutables.value.Value.Immutable;

import java.util.List;
import java.util.Optional;


@OpenApiStyle
@Immutable
// Necessary to override deserializer for io.github.emm035.open.api.core.v3.components.schemas.Schema
@JsonDeserialize
public abstract class AbstractOneOfSchema implements Schema {
  public abstract List<RefOr<Schema>> getOneOf();

  public abstract Optional<Discriminator> getDiscriminator();

  public static OneOfSchema of(RefOr<Schema>... schemas) {
    return OneOfSchema.builder()
      .addOneOf(schemas)
      .build();
  }

  @Value.Check
  private OneOfSchema normalizeExtensions(OneOfSchema extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return OneOfSchema.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
