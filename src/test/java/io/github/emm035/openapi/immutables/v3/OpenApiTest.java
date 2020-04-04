package io.github.emm035.openapi.immutables.v3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.flipkart.zjsonpatch.JsonDiff;
import com.google.common.io.ByteStreams;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenApiTest {

  ObjectMapper om = new ObjectMapper()
    .registerModule(new Jdk8Module())
    .registerModule(new GuavaModule())
    .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

  @Test
  public void testWithHubspotCrmCardsSpec() throws IOException {
    testSwagger("hs-crm-cards.json");
  }

  @Test
  public void testWithHubspotPropertiesSpec() throws IOException {
    testSwagger("hs-properties.json");
  }

  @Test
  public void testWithHubspotTimelineSpec() throws IOException {
    testSwagger("hs-timeline.json");
  }

  private void testSwagger(String filename) {
    try {
      String jsonString = loadResourceFileAsString(filename);
      JsonNode readFromFile = om.readTree(jsonString);
      JsonNode reparsed = om.valueToTree(om.treeToValue(readFromFile, OpenApi.class));

      JsonNode node = JsonDiff.asJson(readFromFile, reparsed);
      if (node.size() != 0) {
        System.out.println(readFromFile.toString());
        System.out.println(reparsed.toString());
      }
      assertThat(node).isEmpty();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private String loadResourceFileAsString(String fileName) {
    InputStream resourceAsStream = OpenApiTest.class.getClassLoader().getResourceAsStream(fileName);
    try {
      return new String(ByteStreams.toByteArray(resourceAsStream));
    } catch (IOException e) {
      throw new RuntimeException("Unable to load resource '" + fileName + "'", e);
    }
  }
}
