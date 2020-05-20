package io.github.emm035.openapi.immutables.v3.references.refs;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;


@OpenApiStyle
@Immutable
public interface UnknownTypeRefIF extends Ref {
  @Override
  @Derived
  default String getType() {
    return "";
  }

  @Override
  @Parameter
  String getName();

  @Override
  default String getRef() {
    return getName();
  }
}
