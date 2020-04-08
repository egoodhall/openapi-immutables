package io.github.emm035.openapi.immutables.v3.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;

import static org.immutables.value.Value.Check;
import static org.immutables.value.Value.Default;
import static org.immutables.value.Value.Derived;
import static org.immutables.value.Value.Immutable;


@OpenApiStyle
@Immutable
public abstract class AbstractHeaderParameter implements Parameter {
  @Override
  @Derived
  public Location getIn() {
    return Location.HEADER;
  }

  @Default
  public Style getStyle() {
    return Style.SIMPLE;
  }

  @Default
  public boolean getExplode() {
    return false;
  }

  public static enum Style {
    SIMPLE;

    @JsonCreator
    private static Style fromString(@JsonProperty String rawValue) {
      return valueOf(rawValue.toUpperCase());
    }

    @Override
    @JsonValue
    public String toString() {
      return name().toLowerCase();
    }
  }

  @Check
  private HeaderParameter normalizeExtensions(HeaderParameter headerParameter) {
    if (headerParameter.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return headerParameter;
    }
    HeaderParameter.Builder newHeaderParameter = HeaderParameter.builder()
      .from(headerParameter);
    headerParameter.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newHeaderParameter.putExtensions(e.getKey(), e.getValue()));
    return newHeaderParameter.build();
  }
}