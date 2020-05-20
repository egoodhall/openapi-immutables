package io.github.emm035.openapi.immutables.v3.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;

import java.util.Optional;

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

  public abstract Optional<Style> getStyle();
  public abstract Optional<Boolean> getExplode();

  @Derived
  @JsonIgnore
  public Style getStyleOrDefault() {
    return getStyle().orElse(Style.SIMPLE);
  }

  @Derived
  @JsonIgnore
  public boolean getExplodeOrDefault() {
    return getExplode().orElse(false);
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
  AbstractHeaderParameter normalizeExtensions() {
    if (Checks.allValid(this)) {
      return this;
    }
    return HeaderParameter.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
