package io.github.emm035.openapi.immutables.v3.content;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.references.RefOr;
import io.github.emm035.openapi.immutables.v3.references.refs.Ref;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.schemas.Schema;
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
