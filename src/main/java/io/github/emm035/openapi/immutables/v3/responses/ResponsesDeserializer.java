package io.github.emm035.openapi.immutables.v3.responses;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.primitives.Ints;
import io.github.emm035.openapi.immutables.v3.PathItem;
import io.github.emm035.openapi.immutables.v3.references.RefOr;

import java.io.IOException;
import java.util.Iterator;

public class ResponsesDeserializer extends JsonDeserializer<Responses> {
  @Override
  public Responses deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) p.getCodec();
    JsonNode node = mapper.readTree(p);

    Responses.Builder builder = Responses.builder();
    for (Iterator<String> iter = node.fieldNames(); iter.hasNext();) {
      String fieldName = iter.next();
      if (fieldName.startsWith("x-")) {
        builder.putExtensions(fieldName, mapper.treeToValue(node.get(fieldName), Object.class));
      } else if (fieldName.equals("default")) {
        RefOr<Response> defaultResponse = mapper.readValue(mapper.treeAsTokens(node.get(fieldName)), new TypeReference<RefOr<Response>>() {});
        builder.setDefault(defaultResponse);
      } else {
        RefOr<Response> response = mapper.readValue(mapper.treeAsTokens(node.get(fieldName)), new TypeReference<RefOr<Response>>() {});
        builder.putResponses(Ints.tryParse(fieldName), response);
      }
    }
    return builder.build();
  }
}
