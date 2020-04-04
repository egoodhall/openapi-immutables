package io.github.emm035.openapi.immutables.v3.components.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.github.emm035.openapi.immutables.v3.components.examples.base.Example;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.DELEGATING;

public class BasicExample implements Example {
  private Object example;

  private BasicExample(Object example) {
    this.example = example;
  }

  @JsonGetter("example")
  @JsonUnwrapped
  public Object getExample() {
    return example;
  }

  @JsonCreator(mode = DELEGATING)
  public static BasicExample of(Object value) {
    return BasicExample.builder()
      .setExample(value)
      .build();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Object example;

    public Builder setExample(Object value) {
      example = value;
      return this;
    }

    public BasicExample build() {
      return new BasicExample(example);
    }
  }
}
