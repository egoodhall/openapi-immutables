package io.github.emm035.openapi.immutables.v3.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.emm035.openapi.immutables.v3.examples.Example;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

public interface WithMultipleExamples {
  @JsonInclude(NON_EMPTY)
  Map<String, Example> getExamples();
}
