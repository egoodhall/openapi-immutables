package io.github.emm035.openapi.immutables.v3.components;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import io.github.emm035.openapi.immutables.v3.jackson.Types;

import java.io.IOException;

public class RefOrSerializer<T> extends JsonSerializer<RefOr<T>> implements ContextualSerializer {

  private JavaType valueType;

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

  @Override
  public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
    RefOrSerializer<Object> ser = new RefOrSerializer<>();
    ser.valueType = Types.getReferenceableType(property.getType());
    return ser;
  }
}
