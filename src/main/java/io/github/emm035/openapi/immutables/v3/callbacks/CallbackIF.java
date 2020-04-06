package io.github.emm035.openapi.immutables.v3.callbacks;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.emm035.openapi.immutables.v3.PathItem;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

@Immutable
@OpenApiStyle
@JsonSerialize(using = CallbackSerializer.class)
@JsonDeserialize(using = CallbackDeserializer.class)
public abstract class CallbackIF implements Extensible {
  public abstract String getExpression();
  public abstract PathItem getPathItem();

  @Check
  private Callback normalizeExtensions(Callback extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return Callback.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
