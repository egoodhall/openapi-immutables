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
public abstract class AbstractRefLink implements Link, Extensible, Describable {
  public abstract String getOperationRef();
  public abstract Map<String, Object> getParameters();
  public abstract Optional<Object> getRequestBody();

  @Check
  private RefLink normalizeExtensions(RefLink extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return RefLink.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
