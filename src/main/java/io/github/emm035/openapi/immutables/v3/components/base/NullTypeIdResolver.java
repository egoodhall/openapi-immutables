package io.github.emm035.openapi.immutables.v3.components.base;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class NullTypeIdResolver extends TypeIdResolverBase {
  @Override
  public String idFromValue(Object value) {
    return null;
  }

  @Override
  public String idFromValueAndType(Object value, Class<?> suggestedType) {
    return null;
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return null;
  }
}
