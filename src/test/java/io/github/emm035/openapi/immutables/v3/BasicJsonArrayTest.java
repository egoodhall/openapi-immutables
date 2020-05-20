package io.github.emm035.openapi.immutables.v3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.io.ByteStreams;
import io.github.emm035.openapi.immutables.v3.jackson.Json;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BasicJsonArrayTest<T> {

  public abstract Class<T> getModelClass();

  public abstract List<T> getInstances();

  @Test
  public void fromJson_deserializesToExpectedFields() {
    Collection<T> loadedObject = load(getModelClass());
    assertThat(loadedObject).containsExactlyElementsOf(getInstances());
  }

  @Test
  public void toJson_serializesToExpectedFields() throws JsonProcessingException {
    var loadedJson = load(JsonNode.class);
    var serialized = Json.toTree(getInstances());
    assertThat(serialized).isEqualTo(loadedJson);
  }

  private <T> Collection<T> load(Class<T> clazz) {
    try {
      var arrayType = Json.MAPPER.getTypeFactory().constructArrayType(clazz);
      var stream = BasicJsonArrayTest.class.getClassLoader().getResourceAsStream(getModelClass().getSimpleName() + ".json");
      var jsonNode = Json.MAPPER.readTree(new String(ByteStreams.toByteArray(stream)));
      return ImmutableList.copyOf(Iterators.toArray(Json.MAPPER.readValues(Json.MAPPER.treeAsTokens(jsonNode), clazz), clazz));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
