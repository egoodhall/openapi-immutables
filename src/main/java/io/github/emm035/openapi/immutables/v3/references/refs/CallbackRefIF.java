package io.github.emm035.openapi.immutables.v3.references.refs;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public interface CallbackRefIF extends Ref {
  @Override
  default String getType() {
    return "examples";
  }
}
