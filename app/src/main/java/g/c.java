package g;

import kotlin.jvm.internal.Lambda;
import l3.w;
import org.koin.core.scope.Scope;
import xg.d0;

/* loaded from: classes2.dex */
public final class c extends Lambda implements yf.p {
    public c() {
        super(2);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        zf.i.checkNotNullParameter(scope, "$this$single");
        zf.i.checkNotNullParameter((sh.a) obj2, "it");
        Object obj3 = scope.get(zf.k.getOrCreateKotlinClass(w.class), null, null);
        Object obj4 = scope.get(zf.k.getOrCreateKotlinClass(qb.h.class), null, null);
        return new sb.p((w) obj3, (qb.h) obj4, (d0) scope.get(zf.k.getOrCreateKotlinClass(d0.class), null, null), (p000if.b) scope.get(zf.k.getOrCreateKotlinClass(p000if.b.class), null, null));
    }
}
