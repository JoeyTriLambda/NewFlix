package g;

import kotlin.jvm.internal.Lambda;
import org.koin.core.scope.Scope;

/* loaded from: classes2.dex */
public final class u extends Lambda implements yf.p {
    public u() {
        super(2);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        zf.i.checkNotNullParameter(scope, "$this$single");
        zf.i.checkNotNullParameter((sh.a) obj2, "it");
        return new k.h((p000if.b) scope.get(zf.k.getOrCreateKotlinClass(p000if.b.class), null, null), (rb.p) scope.get(zf.k.getOrCreateKotlinClass(rb.p.class), null, null));
    }
}
