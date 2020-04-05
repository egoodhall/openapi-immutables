package io.github.emm035.openapi.immutables.v3.components.content;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.Ref;
import io.github.emm035.openapi.immutables.v3.components.RefOr;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.schemas.Schema;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Map;
import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractResponse implements Describable, Extensible {
  public abstract Optional<Content> getContent();
  public abstract Optional<RefOr<Schema>> getSchema();
  public abstract Map<String, Header> getHeaders();

  public static Ref ref(String name) {
    return Ref.toResponse(name);
  }

  public static Response.Builder builder() {
    return Response.builder();
  }

  public static Response empty() {
    return Response.builder().build();
  }

  @Check
  private Response normalizeExtensions(Response response) {
    if (response.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return response;
    }
    Response.Builder newResponse = Response.builder()
      .from(response);
    response.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newResponse.putExtensions(e.getKey(), e.getValue()));
    return newResponse.build();
  }
}
