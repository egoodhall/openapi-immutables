package io.github.emm035.openapi.immutables.v3.components.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.CaseFormat;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.parameters.base.Parameter;
import org.immutables.value.Value;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Derived;

import java.util.Optional;


@OpenApiStyle
@Value.Immutable
public abstract class AbstractQueryParameter implements Parameter {
  @Override
  @Derived
  public Location getIn() {
    return Location.QUERY;
  }
  @Default
  public Style getStyle() {
    return Style.FORM;
  }
  @Default
  public boolean getExplode() {
    return true;
  }
  public abstract Optional<Boolean> getAllowReserved();
  public abstract Optional<Boolean> getAllowEmptyValue();

  public static enum Style {
    FORM,
    SPACE_DELIMITED,
    PIPE_DELIMITED,
    DEEP_OBJECT;

    @JsonCreator
    private static Style fromString(@JsonProperty String rawValue) {
      return valueOf(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, rawValue));
    }

    @Override
    @JsonValue
    public String toString() {
      return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name());
    }
  }

  @Check
  private QueryParameter normalizeExtensions(QueryParameter queryParameter) {
    if (queryParameter.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return queryParameter;
    }
    QueryParameter.Builder newQueryParameter = QueryParameter.builder()
      .from(queryParameter);
    queryParameter.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newQueryParameter.putExtensions(e.getKey(), e.getValue()));
    return newQueryParameter.build();
  }
}
