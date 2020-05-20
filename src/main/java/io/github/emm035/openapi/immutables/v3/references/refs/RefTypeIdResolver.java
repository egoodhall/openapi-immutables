package io.github.emm035.openapi.immutables.v3.references.refs;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

import static io.github.emm035.openapi.immutables.v3.references.refs.Patterns.REF_PATTERN;

public class RefTypeIdResolver extends TypeIdResolverBase {

  @Override
  public String idFromValue(Object o) {
    return REF_PATTERN.matcher(((Ref) o).getRef()).group("type");
  }

  @Override
  public String idFromValueAndType(Object o, Class<?> aClass) {
    return idFromValue(o);
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return JsonTypeInfo.Id.NAME;
  }
}
