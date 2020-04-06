package io.github.emm035.openapi.immutables.v3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.DiffFlags;
import com.flipkart.zjsonpatch.JsonDiff;
import com.google.common.collect.Streams;
import com.google.common.io.ByteStreams;
import io.github.emm035.openapi.immutables.v3.jackson.Json;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenApiTest {

  private static final ObjectMapper om = Json.OBJECT_MAPPER;

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

      onlyRemovedEmptyNodes(readFromFile, reparsed);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onlyRemovedEmptyNodes(JsonNode source, JsonNode target) {
    JsonNode diff = JsonDiff.asJson(source, target, EnumSet.noneOf(DiffFlags.class));

    boolean onlyRemovedEmptyContent = Streams.stream(diff.iterator())
      .map(node -> node.get("op").asText().equals("remove")
        && node.get("value").isContainerNode()
        && node.get("value").size() == 0)
      .reduce(true, (l, r) -> l && r);

    // Uncomment to log json
    if (!onlyRemovedEmptyContent) {
      System.out.println(source.toString());
      System.out.println(target.toString());
      System.out.println(diff);
    }
    assertThat(onlyRemovedEmptyContent).isTrue();
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
