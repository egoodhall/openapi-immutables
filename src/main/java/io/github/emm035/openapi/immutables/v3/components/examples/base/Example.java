package io.github.emm035.openapi.immutables.v3.components.examples.base;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import io.github.emm035.openapi.immutables.v3.components.base.NullTypeIdResolver;
import io.github.emm035.openapi.immutables.v3.components.examples.BasicExample;
import io.github.emm035.openapi.immutables.v3.components.examples.ExternalExample;
import io.github.emm035.openapi.immutables.v3.components.examples.SummarizableExample;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CUSTOM;

@JsonTypeInfo(use = CUSTOM, defaultImpl = BasicExample.class)
@JsonTypeIdResolver(NullTypeIdResolver.class)
@JsonSubTypes({
  @Type(ExternalExample.class),
  @Type(SummarizableExample.class),
  @Type(BasicExample.class)
})
public interface Example {
}
