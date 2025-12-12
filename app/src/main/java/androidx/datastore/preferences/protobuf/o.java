package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.s;
import androidx.datastore.preferences.protobuf.s.a;
import java.io.IOException;
import java.util.Map;

/* compiled from: ExtensionSchema.java */
/* loaded from: classes.dex */
public abstract class o<T extends s.a<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract GeneratedMessageLite.e b(n nVar, k0 k0Var, int i10);

    public abstract s<T> c(Object obj);

    public abstract s<T> d(Object obj);

    public abstract boolean e(k0 k0Var);

    public abstract void f(Object obj);

    public abstract Object g(Object obj) throws IOException;

    public abstract void h(x0 x0Var, Object obj, n nVar, s<T> sVar) throws IOException;

    public abstract void i(ByteString byteString, Object obj, n nVar, s<T> sVar) throws IOException;

    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
