package io.github.emm035.openapi.immutables.v3.components.schemas.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.base.WithSingleExample;
import io.github.emm035.openapi.immutables.v3.components.schemas.XmlObject;

import java.util.Optional;

/**
 * Overall schema type.
 *
 * All direct subclasses should be handled in {@link SchemaDeserializer}
 * and annotated with {@link JsonDeserialize} to override the custom
 * deserialization behavior
 */
@JsonDeserialize(using = SchemaDeserializer.class)
public interface Schema extends Describable, WithSingleExample, Extensible {
  Optional<Boolean> isNullable();
  Optional<String> getTitle();
  Optional<Object> getDefault();
  Optional<XmlObject> getXml();
}
