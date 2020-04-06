package io.github.emm035.openapi.immutables.v3.schemas;

import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.Map;


@Immutable
@OpenApiStyle
public interface DiscriminatorIF {
  String getPropertyName();
  Map<String, String> getMappings();
}
