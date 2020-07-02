package io.github.emm035.openapi.immutables.v3.references;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.emm035.openapi.immutables.v3.jackson.Json;
import io.github.emm035.openapi.immutables.v3.schemas.Schema;
import org.junit.Test;

import java.io.IOException;

public class RefTest {
  @Test
  public void deserialize_ref_deserailzesCorrectly() throws IOException {
    var ref = Json.MAPPER.readValue("{ \"$ref\": \"#/definitions/schemas/Test\"}", new TypeReference<Referenceable<Schema>>() {});
    var schema = Json.MAPPER.readValue("{ \"type\": \"string\" }", new TypeReference<Referenceable<Schema>>() {});
    System.out.println(ref + " | " + schema);
  }
}
