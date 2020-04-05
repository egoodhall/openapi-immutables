package io.github.emm035.openapi.immutables.v3.components.content;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.base.WithMultipleExamples;
import io.github.emm035.openapi.immutables.v3.components.schemas.Schema;
import org.immutables.value.Value.Immutable;


@Immutable
@OpenApiStyle
public interface MediaTypeIF extends WithMultipleExamples, Extensible {
  RefOr<Schema> getSchema();
}
