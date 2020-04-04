package io.github.emm035.openapi.immutables.v3.components;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

import javax.annotation.Nullable;
import java.util.function.Function;

@JsonSerialize(using = RefOrSerializer.class)
@JsonDeserialize(using = RefOrDeserializer.class)
public class RefOr<T> {

  private final T concrete;
  private final Ref ref;

  private RefOr(@Nullable T content, @Nullable Ref ref) {
    Preconditions.checkArgument((content == null) != (ref == null), "Referenceable model must have a concrete value or reference specified");
    this.concrete = content;
    this.ref = ref;
  }

  public boolean isReferential() {
    return ref != null;
  }

  public T getConcrete() {
    Preconditions.checkNotNull(concrete);
    return concrete;
  }

  public Ref getRef() {
    Preconditions.checkNotNull(ref);
    return ref;
  }

  public <U> RefOr<U> mapConcrete(Function<T, U> transform) {
    if (concrete == null) {
      return new RefOr<>(null, ref);
    }
    return new RefOr<>(transform.apply(concrete), ref);
  }

  public static <T> RefOr<T> concrete(T content) {
    return new RefOr<T>(content, null);
  }

  public static <T> RefOr<T> ref(Ref ref) {
    return new RefOr<T>(null, ref);
  }
}
