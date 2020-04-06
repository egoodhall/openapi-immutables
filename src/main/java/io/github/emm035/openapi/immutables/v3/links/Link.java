package io.github.emm035.openapi.immutables.v3.links;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = LinkDeserializer.class)
public interface Link {
}
