package io.github.emm035.openapi.immutables.v3.references;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
public abstract class AbstractRef {
  @JsonProperty("$ref")
  public abstract String getRef();

  public static Ref toSchema(String name) {
    return of("#/components/schemas/" + name);
  }

  public static Ref toResponse(String name) {
    return of("#/components/responses/" + name);
  }

  public static Ref toParameter(String name) {
    return of("#/components/parameters/" + name);
  }

  public static Ref toHeader(String name) {
    return of("#/components/headers/" + name);
  }

  public static Ref toExample(String name) {
    return of("#/components/examples/" + name);
  }

  public static Ref toRequestBody(String name) {
    return of("#/components/requestBodies/" + name);
  }

  public static Ref toLink(String name) {
    return of("#/components/links/" + name);
  }

  public static Ref toCallback(String name) {
    return of("#/components/callbacks/" + name);
  }

  public static Ref toSecuritySchemes(String name) {
    return of("#/components/securitySchemes/" + name);
  }

  public static Ref of(String ref) {
    return Ref.builder()
      .setRef(ref)
      .build();
  }
}
