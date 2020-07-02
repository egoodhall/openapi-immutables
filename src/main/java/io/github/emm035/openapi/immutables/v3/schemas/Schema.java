package io.github.emm035.openapi.immutables.v3.schemas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.WithSingleExample;

import java.util.Optional;

/**
 * Overall schema type.
 *
 * All direct subclasses should be handled in {@link SchemaDeserializer}
 * and annotated with {@link JsonDeserialize} to override the custom
 * deserialization behavior
 */
@JsonDeserialize(using = SchemaDeserializer.class)
public interface Schema extends Describable, WithSingleExample, Extensible, Referenceable<Schema> {
  Optional<Boolean> isNullable();
  Optional<String> getTitle();
  Optional<Object> getDefault();
  Optional<XmlObject> getXml();
}
