package io.github.emm035.openapi.immutables.v3.callbacks;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

class CallbackSerializer extends JsonSerializer<Callback> {
  @Override
  public void serialize(Callback value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
    gen.writeStartObject();
    gen.writeObjectField(value.getExpression(), value.getPathItem());
    gen.writeEndObject();
  }
}
