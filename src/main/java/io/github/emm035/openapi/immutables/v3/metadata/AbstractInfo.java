package io.github.emm035.openapi.immutables.v3.metadata;

import io.github.emm035.openapi.immutables.v3.base.Extensible;
import io.github.emm035.openapi.immutables.v3.base.OpenApiStyle;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Immutable;

import java.util.Optional;

@Immutable
@OpenApiStyle
public abstract class AbstractInfo implements Extensible {
  public abstract String getTitle();
  public abstract Optional<String> getDescription();
  public abstract Optional<String> getTermsOfService();
  public abstract Optional<Contact> getContact();
  public abstract Optional<License> getLicense();
  public abstract String getVersion();

  @Check
  private Info normalizeExtensions(Info extensible) {
    if (Checks.allValid(extensible)) {
      return extensible;
    }
    return Info.builder()
      .from(extensible)
      .setExtensions(Checks.validExtensions(extensible))
      .build();
  }
}
