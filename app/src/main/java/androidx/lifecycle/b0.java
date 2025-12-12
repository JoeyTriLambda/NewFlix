package androidx.lifecycle;

import androidx.lifecycle.a0;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 {
    public static z a(a0.b bVar, Class cls) {
        zf.i.checkNotNullParameter(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static z b(a0.b bVar, Class cls, u1.a aVar) {
        zf.i.checkNotNullParameter(cls, "modelClass");
        zf.i.checkNotNullParameter(aVar, "extras");
        return bVar.create(cls);
    }
}
