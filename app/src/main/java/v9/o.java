package v9;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class o implements u<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Type f20637a;

    public o(Type type) {
        this.f20637a = type;
    }

    @Override // v9.u
    public Object construct() {
        Type type = this.f20637a;
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumMap type: " + type.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return new EnumMap((Class) type2);
        }
        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
    }
}
