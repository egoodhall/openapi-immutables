package io.github.emm035.openapi.immutables.v3.components;

import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import io.github.emm035.openapi.immutables.v3.components.callbacks.Callback;
import io.github.emm035.openapi.immutables.v3.components.content.Header;
import io.github.emm035.openapi.immutables.v3.components.content.RequestBody;
import io.github.emm035.openapi.immutables.v3.components.content.Response;
import io.github.emm035.openapi.immutables.v3.components.examples.base.Example;
import io.github.emm035.openapi.immutables.v3.components.links.Link;
import io.github.emm035.openapi.immutables.v3.components.parameters.base.Parameter;
import io.github.emm035.openapi.immutables.v3.components.schemas.base.Schema;
import io.github.emm035.openapi.immutables.v3.components.security.base.SecurityScheme;
import org.immutables.value.Value.Immutable;

import java.util.Map;

@OpenApiStyle
@Immutable
public abstract class AbstractComponents {
  public abstract Map<String, RefOr<Schema>> getSchemas();
  public abstract Map<String, RefOr<Response>> getResponses();
  public abstract Map<String, RefOr<Parameter>> getParameters();
  public abstract Map<String, RefOr<RequestBody>> getRequestBodies();
  public abstract Map<String, RefOr<Example>> getExamples();
  public abstract Map<String, RefOr<SecurityScheme>> getSecuritySchemes();
  public abstract Map<String, RefOr<Header>> getHeaders();
  public abstract Map<String, RefOr<Link>> getLinks();
  public abstract Map<String, RefOr<Callback>> getCallbacks();
}
