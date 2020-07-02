package io.github.emm035.openapi.immutables.v3.examples;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.shared.Describable;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.Summarizable;

@JsonDeserialize
public interface Example extends Summarizable, Describable, Extensible, Referenceable<Example> {

}
