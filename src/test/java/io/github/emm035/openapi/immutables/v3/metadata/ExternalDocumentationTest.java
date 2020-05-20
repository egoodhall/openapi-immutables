package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.BasicJsonTest;


public class ExternalDocumentationTest extends BasicJsonTest<ExternalDocumentation> {

  @Override
  public Class<ExternalDocumentation> getModelClass() {
    return ExternalDocumentation.class;
  }

  @Override
  public ExternalDocumentation getInstance() {
    return ExternalDocumentation.builder()
      .setDescription("Some external docs")
      .setUrl("https://example.com/docs")
      .putExtensions("x-external-docs", "test")
      .build();
  }


}
