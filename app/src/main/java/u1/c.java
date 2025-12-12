package u1;

import androidx.lifecycle.a0;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Arrays;
import yf.l;
import zf.i;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f19974a = new ArrayList();

    public final <T extends z> void addInitializer(gg.b<T> bVar, l<? super a, ? extends T> lVar) {
        i.checkNotNullParameter(bVar, "clazz");
        i.checkNotNullParameter(lVar, "initializer");
        this.f19974a.add(new e(xf.a.getJavaClass(bVar), lVar));
    }

    public final a0.b build() {
        e[] eVarArr = (e[]) this.f19974a.toArray(new e[0]);
        return new b((e[]) Arrays.copyOf(eVarArr, eVarArr.length));
    }
}
