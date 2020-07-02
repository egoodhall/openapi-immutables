package io.github.emm035.openapi.immutables.v3.references;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value;
import org.immutables.value.Value.Parameter;

@Value.Immutable
@OpenApiStyle
public interface RefIF<T> extends Referenceable<T> {

  @JsonIgnore
  @Value.Derived
  default boolean isReferential() {
    return true;
  }

  @JsonProperty("$ref")
  @Parameter
  String getRef();
}
