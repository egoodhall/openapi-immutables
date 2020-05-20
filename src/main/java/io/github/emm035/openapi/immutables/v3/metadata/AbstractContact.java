package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.security.OpenIdConnectScheme;
import io.github.emm035.openapi.immutables.v3.shared.Extensible;
import io.github.emm035.openapi.immutables.v3.shared.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractContact implements Extensible {
  public abstract Optional<String> getName();
  public abstract Optional<String> getUrl();
  public abstract Optional<String> getEmail();

  @Check
  AbstractContact normalizeExtensions(Contact extensible) {
    if (Checks.allValid(this)) {
      return this;
    }
    return Contact.builder()
      .from(this)
      .setExtensions(Checks.validExtensions(this))
      .build();
  }
}
