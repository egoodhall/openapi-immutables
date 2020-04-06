package io.github.emm035.openapi.immutables.v3.schemas;

import io.github.emm035.openapi.immutables.v3.shared.Enumerated;

import java.util.Optional;

public interface NumericSchema<T extends Number> extends TypedSchema, Enumerated<T> {
  Optional<T> getMinimum();
  Optional<T> getMaximum();
  Optional<T> getMultipleOf();
  Optional<Boolean> getExclusiveMinimum();
  Optional<Boolean> getExclusiveMaximum();
}
