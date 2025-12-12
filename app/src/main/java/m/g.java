package m;

import kotlin.jvm.internal.Lambda;
import wg.c;

/* loaded from: classes2.dex */
public final class g extends Lambda implements yf.l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wg.e f16069b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(wg.e eVar) {
        super(1);
        this.f16069b = eVar;
    }

    @Override // yf.l
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        wg.e eVar = this.f16069b;
        c cVar = eVar.f21152d;
        rb.p pVar = (rb.p) cVar;
        kg.h.launch$default(pVar.f18916x, null, null, new e.g(pVar, eVar.f21149a, jLongValue, null), 3, null);
        return lf.h.f16056a;
    }
}
