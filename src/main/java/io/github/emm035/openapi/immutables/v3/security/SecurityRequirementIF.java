package io.github.emm035.openapi.immutables.v3.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.List;

@Immutable
@OpenApiStyle
@JsonSerialize(using = SecurityRequirementSerializer.class)
@JsonDeserialize(using = SecurityRequirementDeserializer.class)
public interface SecurityRequirementIF {
  String getName();
  List<String> getScopes();
}
