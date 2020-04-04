package io.github.emm035.openapi.immutables.v3.components.schemas;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.Map;


@Immutable
@OpenApiStyle
public interface DiscriminatorIF {
  String getPropertyName();
  Map<String, String> getMappings();
}
