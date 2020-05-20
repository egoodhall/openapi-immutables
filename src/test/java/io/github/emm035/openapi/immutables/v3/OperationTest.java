package io.github.emm035.openapi.immutables.v3;

import io.github.emm035.openapi.immutables.v3.BasicJsonTest;


public class OperationTest extends BasicJsonTest<Operation> {

  public Class<Operation> getModelClass() {
    return Operation.class;
  }

  public Operation getInstance() {
    return Operation.builder()
      .setDeprecated(false)
      .setOperationId("item-create")
      .setSummary("Create an item")
      .setDescription("Create an item from the information supplied in the request body")
      .addParameters()
      .build();
  }

}
