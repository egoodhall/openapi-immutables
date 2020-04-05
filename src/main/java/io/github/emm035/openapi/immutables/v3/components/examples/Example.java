package io.github.emm035.openapi.immutables.v3.components.examples;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.components.base.Describable;
import io.github.emm035.openapi.immutables.v3.components.base.Summarizable;

@JsonDeserialize
public interface Example extends Summarizable, Describable, Extensible {

}
