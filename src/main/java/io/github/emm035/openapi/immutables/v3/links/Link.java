package io.github.emm035.openapi.immutables.v3.links;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.references.Referenceable;

@JsonDeserialize(using = LinkDeserializer.class)
public interface Link extends Referenceable<Link> {
}
