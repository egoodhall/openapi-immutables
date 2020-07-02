package io.github.emm035.openapi.immutables.v3.content;

import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.schemas.Schema;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public interface HeaderIF extends Describable {
  Referenceable<Schema> getSchema();

  public static Header.Builder builder() {
    return Header.builder();
  }
}
