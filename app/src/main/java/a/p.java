package a;

import kotlin.jvm.internal.Lambda;
import lh.b;
import yf.a;

/* loaded from: classes.dex */
public final class p extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f15b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n f16m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(lh.a aVar, n nVar) {
        super(0);
        this.f15b = aVar;
        this.f16m = nVar;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f15b;
        boolean z10 = aVar instanceof b;
        n nVar = this.f16m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(sb.p.class), null, nVar) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(sb.p.class), null, nVar);
    }
}
