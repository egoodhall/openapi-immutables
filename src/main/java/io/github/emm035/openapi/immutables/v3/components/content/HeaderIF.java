package io.github.emm035.openapi.immutables.v3.components.content;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.Ref;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.schemas.Schema;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public interface HeaderIF extends Describable {
  RefOr<Schema> getSchema();

  public static Ref ref(String name) {
    return Ref.toHeader(name);
  }

  public static Header.Builder builder() {
    return Header.builder();
  }
}
