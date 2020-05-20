package io.github.emm035.openapi.immutables.v3.references.refs;

import java.util.regex.Pattern;

class Patterns {
  static final Pattern REF_PATTERN = Pattern.compile("#/components/(?<type>schemas|responses|parameters|headers|examples|requestBodies|links|callbacks|securitySchemes)/(?<name>\\w+)");
}
