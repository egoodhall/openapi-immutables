package io.github.emm035.openapi.immutables.v3.jackson;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.SimpleType;

public class Types {

  public static JavaType getReferenceableType(JavaType type) {
    if (type instanceof MapType) {
      return getReferenceableType((MapType) type);
    }
    if (type instanceof CollectionType) {
      return getReferenceableType((CollectionType) type);
    }
    if (type instanceof ReferenceType) {
      return getReferenceableType((ReferenceType) type);
    }
    if (type instanceof SimpleType) {
      return getReferenceableType((SimpleType) type);
    }
    throw new IllegalArgumentException("Type " + type.getClass().getSimpleName() + " not supported.");
  }

  private static JavaType getReferenceableType(SimpleType type) {
    return type.getBindings().getBoundType(0);
  }

  private static JavaType getReferenceableType(ReferenceType type) {
    return getReferenceableType(type.getBindings().getBoundType(0));
  }

  private static JavaType getReferenceableType(CollectionType type) {
    return getReferenceableType(type.getBindings().getBoundType(0));
  }

  private static JavaType getReferenceableType(MapType type) {
    return getReferenceableType(type.getBindings().getBoundType(1));
  }
}
