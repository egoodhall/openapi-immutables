package io.github.emm035.openapi.immutables.v3.requests;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.content.Content;
import io.github.emm035.openapi.immutables.v3.references.refs.Ref;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.WithMultipleExamples;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
public interface RequestBodyIF extends Describable, Extensible, WithMultipleExamples {
  Optional<Boolean> getRequired();
  Content getContent();

  public static Ref ref(String name) {
    return Ref.toRequestBody(name);
  }
}
