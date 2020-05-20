package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.BasicJsonTest;


public class LicenseTest extends BasicJsonTest<License> {

  @Override
  public Class<License> getModelClass() {
    return License.class;
  }

  public License getInstance() {
    return License.builder()
      .setName("MIT")
      .setUrl("https://example.com/license")
      .putExtensions("x-license", "test")
      .build();
  }


}
