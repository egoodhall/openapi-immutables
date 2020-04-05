package io.github.emm035.openapi.immutables.v3.components.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.parameters.base.Parameter;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Derived;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

import static org.immutables.value.Value.Check;


@OpenApiStyle
@Immutable
public abstract class AbstractPathParameter implements Parameter {
  @Override
  @Derived
  public Location getIn() {
    return Location.PATH;
  }

  @Override
  @Derived
  public Optional<Boolean> getRequired() {
    return Optional.of(true);
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
    SIMPLE,
    LABEL,
    MATRIX;

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
  private PathParameter normalizeExtensions(PathParameter pathParameter) {
    if (pathParameter.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return pathParameter;
    }
    PathParameter.Builder newPathParameter = PathParameter.builder()
      .from(pathParameter);
    pathParameter.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newPathParameter.putExtensions(e.getKey(), e.getValue()));
    return newPathParameter.build();
  }
}
