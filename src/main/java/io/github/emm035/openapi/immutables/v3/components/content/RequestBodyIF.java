package io.github.emm035.openapi.immutables.v3.components.content;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.components.Ref;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.base.WithMultipleExamples;
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
