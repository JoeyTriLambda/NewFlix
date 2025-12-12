package androidx.datastore.preferences.protobuf;

import java.io.Serializable;

/* loaded from: classes.dex */
public enum JavaType {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(ByteString.class, ByteString.f2316m),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);


    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f2369b;

    /* renamed from: m, reason: collision with root package name */
    public final Object f2370m;

    JavaType(Class cls, Serializable serializable) {
        this.f2369b = cls;
        this.f2370m = serializable;
    }

    public Class<?> getBoxedType() {
        return this.f2369b;
    }
}
