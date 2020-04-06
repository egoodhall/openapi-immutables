package io.github.emm035.openapi.immutables.v3.links;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Map;
import java.util.Optional;


@OpenApiStyle
@Immutable
@JsonDeserialize
public abstract class AbstractIdLink implements Link, Extensible, Describable {
  public abstract String getOperationId();
  public abstract Map<String, Object> getParameters();
  public abstract Optional<Object> getRequestBody();

  @Check
  private IdLink normalizeExtensions(IdLink extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return IdLink.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
