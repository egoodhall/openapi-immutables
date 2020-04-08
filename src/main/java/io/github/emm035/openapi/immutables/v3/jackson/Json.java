package io.github.emm035.openapi.immutables.v3.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

public class Json {
  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
    .registerModule(new Jdk8Module())
    .registerModule(new GuavaModule())
    .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
}
