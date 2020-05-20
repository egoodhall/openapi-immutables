package io.github.emm035.openapi.immutables.v3.servers;

import io.github.emm035.openapi.immutables.v3.BasicJsonTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServerVariableTest extends BasicJsonTest<ServerVariable> {

  @Override
  public Class<ServerVariable> getModelClass() {
    return ServerVariable.class;
  }

  @Override
  public ServerVariable getInstance() {
    return ServerVariable.builder()
      .setDefault("app")
      .addEnum("app", "build", "test")
      .setDescription("The environment to call")
      .putExtensions("x-server-variable", "test")
      .build();
  }
}
