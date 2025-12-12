package u1;

import u1.a;
import zf.f;
import zf.i;

/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public final class d extends a {
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(a.b<T> bVar, T t10) {
        i.checkNotNullParameter(bVar, "key");
        getMap$lifecycle_viewmodel_release().put(bVar, t10);
    }

    public d(a aVar) {
        i.checkNotNullParameter(aVar, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(aVar.getMap$lifecycle_viewmodel_release());
    }

    public /* synthetic */ d(a aVar, int i10, f fVar) {
        this((i10 & 1) != 0 ? a.C0283a.f19972b : aVar);
    }
}
