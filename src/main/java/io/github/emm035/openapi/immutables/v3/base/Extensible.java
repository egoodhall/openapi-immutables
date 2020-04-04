package io.github.emm035.openapi.immutables.v3.base;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public interface Extensible {
  @JsonAnyGetter
  Map<String, Object> getExtensions();

  class Checks {
    private Checks() {
    }

    public static <T extends Extensible> boolean allValid(T extensible) {
      return extensible.getExtensions().keySet().stream().allMatch(x -> x.startsWith("x-"));
    }

    public static <T extends Extensible> Map<String, Object> validExtensions(T extensible) {
      return extensible.getExtensions().entrySet().stream()
        .filter(Checks::isValid)
        .collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static boolean isValid(Map.Entry<String, ?> entry) {
      return isValid(entry.getKey());
    }

    public static boolean isValid(String key) {
      return key.startsWith("x-");
    }
  }
}
