package io.github.emm035.openapi.immutables.v3.components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class RefOrSerializer<T> extends JsonSerializer<RefOr<T>> {

  @Override
  public void serialize(RefOr<T> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    if (value.isReferential()) {
      // Write ref
      gen.writeObject(value.getRef());
    } else {
      // Write concrete object
      gen.writeObject(value.getConcrete());
    }
  }
}
