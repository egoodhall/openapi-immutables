package io.github.emm035.openapi.immutables.v3.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.content.Content;
import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.WithMultipleExamples;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
@JsonDeserialize
public interface RequestBodyIF extends Describable, Extensible, WithMultipleExamples, Referenceable<RequestBody> {
  Optional<Boolean> getRequired();
  Content getContent();
}
