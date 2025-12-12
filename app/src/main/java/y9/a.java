package y9;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class<? super T> f22043a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f22044b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22045c;

    public a() {
        Type genericSuperclass = a.class.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                Type typeCanonicalize = C$Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
                this.f22044b = typeCanonicalize;
                this.f22043a = (Class<? super T>) C$Gson$Types.getRawType(typeCanonicalize);
                this.f22045c = typeCanonicalize.hashCode();
                return;
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public static a<?> get(Type type) {
        return new a<>(type);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            if (C$Gson$Types.equals(this.f22044b, ((a) obj).f22044b)) {
                return true;
            }
        }
        return false;
    }

    public final Class<? super T> getRawType() {
        return this.f22043a;
    }

    public final Type getType() {
        return this.f22044b;
    }

    public final int hashCode() {
        return this.f22045c;
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.f22044b);
    }

    public static <T> a<T> get(Class<T> cls) {
        return new a<>(cls);
    }

    public a(Type type) {
        Type typeCanonicalize = C$Gson$Types.canonicalize((Type) v9.a.checkNotNull(type));
        this.f22044b = typeCanonicalize;
        this.f22043a = (Class<? super T>) C$Gson$Types.getRawType(typeCanonicalize);
        this.f22045c = typeCanonicalize.hashCode();
    }
}
