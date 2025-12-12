package g;

import kotlin.jvm.internal.Lambda;
import org.koin.core.scope.Scope;

/* loaded from: classes2.dex */
public final class m extends Lambda implements yf.p {
    public m() {
        super(2);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        zf.i.checkNotNullParameter((Scope) obj, "$this$single");
        zf.i.checkNotNullParameter((sh.a) obj2, "it");
        return new yg.b();
    }
}
