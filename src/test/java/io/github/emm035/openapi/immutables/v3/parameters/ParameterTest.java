package io.github.emm035.openapi.immutables.v3.parameters;

import com.google.common.collect.ImmutableList;
import io.github.emm035.openapi.immutables.v3.BasicJsonArrayTest;
import io.github.emm035.openapi.immutables.v3.references.RefOr;
import io.github.emm035.openapi.immutables.v3.schemas.StringSchema;

import java.util.List;

public class ParameterTest extends BasicJsonArrayTest<Parameter> {
  @Override
  public Class<Parameter> getModelClass() {
    return Parameter.class;
  }

  @Override
  public List<Parameter> getInstances() {
    return ImmutableList.of(
      QueryParameter.builder()
        .setName("queryParam")
        .setRequired(true)
        .setSchema(RefOr.concrete(StringSchema.builder().build()))
        .putExtensions("x-param", "test")
        .build(),
      CookieParameter.builder()
        .setName("cookieParam")
        .setRequired(true)
        .setSchema(RefOr.concrete(StringSchema.builder().build()))
        .putExtensions("x-param", "test")
        .build(),
      PathParameter.builder()
        .setName("pathParam")
        .setSchema(RefOr.concrete(StringSchema.builder().build()))
        .putExtensions("x-param", "test")
        .build(),
      HeaderParameter.builder()
        .setName("headerParam")
        .setRequired(true)
        .setSchema(RefOr.concrete(StringSchema.builder().build()))
        .putExtensions("x-param", "test")
        .build()
    );
  }
}
