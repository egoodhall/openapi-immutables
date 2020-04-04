package io.github.emm035.openapi.immutables.v3.components.schemas;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.Optional;


@Immutable
@OpenApiStyle
public interface XmlObjectIF {
  String getName();
  Optional<String> getNamespace();
  Optional<String> getPrefix();
  Optional<Boolean> isAttribute();
  Optional<Boolean> isWrapped();
}
