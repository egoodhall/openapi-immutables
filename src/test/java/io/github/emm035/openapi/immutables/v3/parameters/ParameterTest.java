package io.github.emm035.openapi.immutables.v3.parameters;

import io.github.emm035.openapi.immutables.v3.BasicJsonTest;
import io.github.emm035.openapi.immutables.v3.schemas.StringSchema;

public class ParameterTest extends BasicJsonTest<Parameter> {
  @Override
  public Class<Parameter> getModelClass() {
    return Parameter.class;
  }

  @Override
  public Parameter getInstance() {
    return Parameter.cookieBuilder()
      .setName("test")
      .setSchema(StringSchema.builder().build())
      .build();
  }
}
