package g;

import kotlin.jvm.internal.Lambda;
import org.koin.core.scope.Scope;
import xg.d0;

/* loaded from: classes2.dex */
public final class d extends Lambda implements yf.p {
    public d() {
        super(2);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        zf.i.checkNotNullParameter(scope, "$this$single");
        zf.i.checkNotNullParameter((sh.a) obj2, "it");
        Object obj3 = scope.get(zf.k.getOrCreateKotlinClass(sb.p.class), null, null);
        Object obj4 = scope.get(zf.k.getOrCreateKotlinClass(d0.class), null, null);
        return new rb.p((sb.p) obj3, (d0) obj4, (wg.b) scope.get(zf.k.getOrCreateKotlinClass(wg.b.class), null, null), (p000if.b) scope.get(zf.k.getOrCreateKotlinClass(p000if.b.class), null, null));
    }
}
