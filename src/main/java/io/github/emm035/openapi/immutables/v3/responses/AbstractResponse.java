package io.github.emm035.openapi.immutables.v3.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.emm035.openapi.immutables.v3.content.Content;
import io.github.emm035.openapi.immutables.v3.content.Header;
import io.github.emm035.openapi.immutables.v3.references.Ref;
import io.github.emm035.openapi.immutables.v3.references.RefOr;
import io.github.emm035.openapi.immutables.v3.schemas.Schema;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Map;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;

@Immutable
@OpenApiStyle
public abstract class AbstractResponse implements Describable, Extensible {
  @JsonInclude(ALWAYS)
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
