package g;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import org.koin.core.scope.Scope;

/* loaded from: classes2.dex */
public final class g extends Lambda implements yf.p {
    public g() {
        super(2);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        Scope scope = (Scope) obj;
        zf.i.checkNotNullParameter(scope, "$this$single");
        zf.i.checkNotNullParameter((sh.a) obj2, "it");
        return new p000if.b((Context) scope.get(zf.k.getOrCreateKotlinClass(Context.class), null, null), (p000if.a) scope.get(zf.k.getOrCreateKotlinClass(p000if.a.class), null, null));
    }
}
