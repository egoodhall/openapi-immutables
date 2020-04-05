package io.github.emm035.openapi.immutables.v3.components.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.parameters.base.Parameter;
import org.immutables.value.Value;
import org.immutables.value.Value.Check;


@OpenApiStyle
@Value.Immutable
public abstract class AbstractCookieParameter implements Parameter {
  @Override
  @Value.Derived
  public Location getIn() {
    return Location.COOKIE;
  }

  public Style getStyle() {
    return Style.FORM;
  }

  @Value.Default
  public boolean getExplode() {
    return true;
  }

  public static enum Style {
    FORM;

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
  private CookieParameter normalizeExtensions(CookieParameter cookieParameter) {
    if (cookieParameter.getExtensions().keySet().stream().allMatch(s -> s.startsWith("x-"))) {
      return cookieParameter;
    }
    CookieParameter.Builder newCookieParameter = CookieParameter.builder()
      .from(cookieParameter);
    cookieParameter.getExtensions().entrySet().stream()
      .filter(e -> e.getKey().startsWith("x-"))
      .forEach(e -> newCookieParameter.putExtensions(e.getKey(), e.getValue()));
    return newCookieParameter.build();
  }
}
