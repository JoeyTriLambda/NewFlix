package u1;

import androidx.lifecycle.z;
import yf.l;
import zf.i;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class e<T extends z> {

    /* renamed from: a, reason: collision with root package name */
    public final Class<T> f19975a;

    /* renamed from: b, reason: collision with root package name */
    public final l<a, T> f19976b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Class<T> cls, l<? super a, ? extends T> lVar) {
        i.checkNotNullParameter(cls, "clazz");
        i.checkNotNullParameter(lVar, "initializer");
        this.f19975a = cls;
        this.f19976b = lVar;
    }

    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.f19975a;
    }

    public final l<a, T> getInitializer$lifecycle_viewmodel_release() {
        return this.f19976b;
    }
}
