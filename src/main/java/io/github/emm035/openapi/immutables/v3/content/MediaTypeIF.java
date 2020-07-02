package io.github.emm035.openapi.immutables.v3.content;

import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.schemas.Schema;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.WithMultipleExamples;
import org.immutables.value.Value.Immutable;


@Immutable
@OpenApiStyle
public interface MediaTypeIF extends WithMultipleExamples, Extensible {
  Referenceable<Schema> getSchema();
}
