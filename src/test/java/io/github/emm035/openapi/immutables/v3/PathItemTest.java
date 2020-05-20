package io.github.emm035.openapi.immutables.v3;

public class PathItemTest extends BasicJsonTest<PathItem> {
  @Override
  public Class<PathItem> getModelClass() {
    return PathItem.class;
  }

  @Override
  public PathItem getInstance() {
    return PathItem.builder()
      .setDescription("This is a path")
      .putExtensions("x-path-item", "test")
      .build();
  }
}
