package io.github.emm035.openapi.immutables.v3.references.refs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.google.common.base.Preconditions;
import io.github.emm035.openapi.immutables.v3.callbacks.Callback;
import org.immutables.value.Value;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Lazy;
import org.immutables.value.Value.Parameter;

import static io.github.emm035.openapi.immutables.v3.references.refs.Patterns.REF_PATTERN;

public interface Ref {

  @JsonIgnore
  String getType();

  @JsonIgnore
  @Parameter(order = 1)
  String getName();

  @Lazy
  @JsonProperty("$ref")
  default String getRef() {
    return "#/components/" + getType() + "/" + getName();
  }

  @JsonCreator
  static Ref fromReferenceString(@JsonProperty("$ref") String ref) {
    final var matcher = REF_PATTERN.matcher(ref);
    Preconditions.checkArgument(matcher.matches(), "'%s' is an invalid reference.", ref);
    if (matcher.group("type") != null) {
      switch (matcher.group("type")) {
        case "schemas":
          return SchemaRef.of(matcher.group("name"));
        case "responses":
          return ResponseRef.of(matcher.group("name"));
        case "parameters":
          return ParameterRef.of(matcher.group("name"));
        case "headers":
          return HeaderRef.of(matcher.group("name"));
        case "examples":
          return ExampleRef.of(matcher.group("name"));
        case "requestBodies":
          return RequestBodyRef.of(matcher.group("name"));
        case "links":
          return LinkRef.of(matcher.group("name"));
        case "callbacks":
          return CallbackRef.of(matcher.group("name"));
        case "securitySchemes":
          return SecuritySchemeRef.of(matcher.group("name"));
      }
    } else {
      return UnknownTypeRef.of(ref);
    }
    throw new IllegalStateException(String.format("'%s' does not reference a valid component type ('%s')", ref, matcher.group("type")));
  }

  public static Ref toSchema(String name) {
    return SchemaRef.of(name);
  }

  public static Ref toResponse(String name) {
    return ResponseRef.of(name);
  }

  public static Ref toParameter(String name) {
    return ParameterRef.of(name);
  }

  public static Ref toHeader(String name) {
    return HeaderRef.of(name);
  }

  public static Ref toExample(String name) {
    return ExampleRef.of(name);
  }

  public static Ref toRequestBody(String name) {
    return RequestBodyRef.of(name);
  }

  public static Ref toLink(String name) {
    return LinkRef.of(name);
  }

  public static Ref toCallback(String name) {
    return CallbackRef.of(name);
  }

  public static Ref toSecuritySchemes(String name) {
    return SecuritySchemeRef.of(name);
  }
}
