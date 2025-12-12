package f;

import kg.g0;
import kg.h0;
import kotlin.jvm.internal.Lambda;
import lf.h;

/* loaded from: classes2.dex */
public final class x extends Lambda implements yf.l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sb.p f11375b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(sb.p pVar) {
        super(1);
        this.f11375b = pVar;
    }

    @Override // yf.l
    public final Object invoke(Object obj) {
        g0 g0Var = this.f11375b.f19243x;
        if (g0Var != null) {
            h0.cancel$default(g0Var, null, 1, null);
        }
        return h.f16056a;
    }
}
