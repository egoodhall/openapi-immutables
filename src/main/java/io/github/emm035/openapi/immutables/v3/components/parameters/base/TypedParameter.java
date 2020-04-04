package io.github.emm035.openapi.immutables.v3.components.parameters.base;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.base.Deprecatable;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.base.WithExamples;
import io.github.emm035.openapi.immutables.v3.components.schemas.base.Schema;

import java.util.Optional;

public interface TypedParameter extends Parameter, WithExamples, Deprecatable, Describable, Extensible {
  Location getIn();
  String getName();
  Optional<Boolean> getRequired();
  RefOr<Schema> getSchema();
  Optional<Object> getDefault();
}
