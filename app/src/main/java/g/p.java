package g;

import de.f;
import kotlin.jvm.internal.Lambda;
import org.koin.core.scope.Scope;
import xg.d0;

/* loaded from: classes2.dex */
public final class p extends Lambda implements yf.p {
    public p() {
        super(2);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        zf.i.checkNotNullParameter(scope, "$this$single");
        zf.i.checkNotNullParameter((sh.a) obj2, "it");
        return new d0((f) scope.get(zf.k.getOrCreateKotlinClass(f.class), null, null), (p000if.b) scope.get(zf.k.getOrCreateKotlinClass(p000if.b.class), null, null));
    }
}
