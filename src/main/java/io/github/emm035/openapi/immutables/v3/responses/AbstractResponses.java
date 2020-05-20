package io.github.emm035.openapi.immutables.v3.responses;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import io.github.emm035.openapi.immutables.v3.references.RefOr;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Map;
import java.util.Optional;


@OpenApiStyle
@Immutable
@JsonDeserialize(using = ResponsesDeserializer.class)
@JsonSerialize(using = ResponsesSerializer.class)
public abstract class AbstractResponses implements Extensible {
  public abstract Optional<RefOr<Response>> getDefault();
  @JsonUnwrapped
  public abstract Map<Integer, RefOr<Response>> getResponses();

  @Check
  protected AbstractResponses normalizeExtensions() {
    Preconditions.checkState(getDefault().isPresent() || !getResponses().isEmpty(), "At least one response must be specified");

    if (Checks.allValid(this)) {
      return this;
    }
    return Responses.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
