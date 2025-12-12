package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Protobuf.java */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: c, reason: collision with root package name */
    public static final u0 f2537c = new u0();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2539b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final d0 f2538a = new d0();

    public static u0 getInstance() {
        return f2537c;
    }

    public <T> void mergeFrom(T t10, x0 x0Var, n nVar) throws IOException {
        schemaFor((u0) t10).mergeFrom(t10, x0Var, nVar);
    }

    public y0<?> registerSchema(Class<?> cls, y0<?> y0Var) {
        Charset charset = w.f2545a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        if (y0Var != null) {
            return (y0) this.f2539b.putIfAbsent(cls, y0Var);
        }
        throw new NullPointerException("schema");
    }

    public <T> y0<T> schemaFor(Class<T> cls) {
        Charset charset = w.f2545a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        y0<T> y0Var = (y0) this.f2539b.get(cls);
        if (y0Var != null) {
            return y0Var;
        }
        y0<T> y0VarCreateSchema = this.f2538a.createSchema(cls);
        y0<T> y0Var2 = (y0<T>) registerSchema(cls, y0VarCreateSchema);
        return y0Var2 != null ? y0Var2 : y0VarCreateSchema;
    }

    public <T> y0<T> schemaFor(T t10) {
        return schemaFor((Class) t10.getClass());
    }
}
