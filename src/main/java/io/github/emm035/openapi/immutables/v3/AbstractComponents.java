package io.github.emm035.openapi.immutables.v3;

import io.github.emm035.openapi.immutables.v3.callbacks.Callback;
import io.github.emm035.openapi.immutables.v3.content.Header;
import io.github.emm035.openapi.immutables.v3.examples.Example;
import io.github.emm035.openapi.immutables.v3.links.Link;
import io.github.emm035.openapi.immutables.v3.parameters.Parameter;
import io.github.emm035.openapi.immutables.v3.references.Referenceable;
import io.github.emm035.openapi.immutables.v3.requests.RequestBody;
import io.github.emm035.openapi.immutables.v3.responses.Response;
import io.github.emm035.openapi.immutables.v3.schemas.Schema;
import io.github.emm035.openapi.immutables.v3.security.SecurityScheme;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Immutable;

import java.util.Map;

@OpenApiStyle
@Immutable
public abstract class AbstractComponents {
  public abstract Map<String, Referenceable<Schema>> getSchemas();
  public abstract Map<String, Referenceable<Response>> getResponses();
  public abstract Map<String, Referenceable<Parameter>> getParameters();
  public abstract Map<String, Referenceable<RequestBody>> getRequestBodies();
  public abstract Map<String, Referenceable<Example>> getExamples();
  public abstract Map<String, Referenceable<SecurityScheme>> getSecuritySchemes();
  public abstract Map<String, Referenceable<Header>> getHeaders();
  public abstract Map<String, Referenceable<Link>> getLinks();
  public abstract Map<String, Referenceable<Callback>> getCallbacks();
}
