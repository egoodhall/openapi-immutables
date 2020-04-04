package io.github.emm035.openapi.immutables.v3.components.schemas.base;

import io.github.emm035.openapi.immutables.v3.components.base.Enumerated;

import java.util.Optional;

public interface NumericSchema<T extends Number> extends Enumerated<T> {
  Optional<T> getMinimum();
  Optional<T> getMaximum();
  Optional<T> getMultipleOf();
  Optional<Boolean> getExclusiveMinimum();
  Optional<Boolean> getExclusiveMaximum();
}
