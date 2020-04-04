package io.github.emm035.openapi.immutables.v3.components.examples;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.base.Summarizable;
import io.github.emm035.openapi.immutables.v3.components.examples.base.Example;
import org.immutables.value.Value;

import java.util.Optional;


@OpenApiStyle
@Value.Immutable
public abstract class AbstractExternalExample implements Example, Summarizable {
  public abstract Optional<String> getExternalValue();
}
