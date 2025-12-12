package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: Schema.java */
/* loaded from: classes.dex */
public interface y0<T> {
    boolean equals(T t10, T t11);

    int getSerializedSize(T t10);

    int hashCode(T t10);

    boolean isInitialized(T t10);

    void makeImmutable(T t10);

    void mergeFrom(T t10, x0 x0Var, n nVar) throws IOException;

    void mergeFrom(T t10, T t11);

    T newInstance();

    void writeTo(T t10, Writer writer) throws IOException;
}
