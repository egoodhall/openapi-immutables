package io.github.emm035.openapi.immutables.v3.components.base;

import io.github.emm035.openapi.immutables.v3.components.examples.Example;

import java.util.Map;

public interface WithMultipleExamples {
  Map<String, Example> getExamples();
}
