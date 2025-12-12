package u1;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.z;
import zf.i;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class b implements a0.b {

    /* renamed from: a, reason: collision with root package name */
    public final e<?>[] f19973a;

    public b(e<?>... eVarArr) {
        i.checkNotNullParameter(eVarArr, "initializers");
        this.f19973a = eVarArr;
    }

    @Override // androidx.lifecycle.a0.b
    public final /* synthetic */ z create(Class cls) {
        return b0.a(this, cls);
    }

    @Override // androidx.lifecycle.a0.b
    public <T extends z> T create(Class<T> cls, a aVar) {
        i.checkNotNullParameter(cls, "modelClass");
        i.checkNotNullParameter(aVar, "extras");
        T t10 = null;
        for (e<?> eVar : this.f19973a) {
            if (i.areEqual(eVar.getClazz$lifecycle_viewmodel_release(), cls)) {
                T tInvoke = eVar.getInitializer$lifecycle_viewmodel_release().invoke(aVar);
                t10 = tInvoke instanceof z ? tInvoke : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
