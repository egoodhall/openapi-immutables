package io.github.emm035.openapi.immutables.v3.components.parameters.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emm035.openapi.immutables.v3.components.Ref;
import io.github.emm035.openapi.immutables.v3.components.base.Located;
import io.github.emm035.openapi.immutables.v3.components.parameters.CookieParameter;
import io.github.emm035.openapi.immutables.v3.components.parameters.HeaderParameter;
import io.github.emm035.openapi.immutables.v3.components.parameters.PathParameter;
import io.github.emm035.openapi.immutables.v3.components.parameters.QueryParameter;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, property = "in")
@JsonSubTypes({
  @Type(value = PathParameter.class, name = "path"),
  @Type(value = QueryParameter.class, name = "query"),
  @Type(value = HeaderParameter.class, name = "header"),
  @Type(value = CookieParameter.class, name = "cookie")
})
public interface Parameter extends Located<Parameter.Location> {

  static Ref ref(String name) {
    return Ref.toParameter(name);
  }

  static CookieParameter.Builder cookieBuilder() {
    return CookieParameter.builder();
  }

  static PathParameter.Builder pathBuilder() {
    return PathParameter.builder();
  }

  static QueryParameter.Builder queryBuilder() {
    return QueryParameter.builder();
  }

  static HeaderParameter.Builder headerBuilder() {
    return HeaderParameter.builder();
  }

  enum Location {
    QUERY,
    HEADER,
    PATH,
    COOKIE;

    @JsonCreator
    static Location fromString(@JsonProperty String rawValue) {
      return Location.valueOf(rawValue.toUpperCase());
    }

    @Override
    @JsonValue
    public String toString() {
      return name().toLowerCase();
    }
  }
}
