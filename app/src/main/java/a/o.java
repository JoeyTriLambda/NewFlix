package a;

import kotlin.jvm.internal.Lambda;
import lh.b;
import yf.a;

/* loaded from: classes.dex */
public final class o extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f13b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ l f14m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(lh.a aVar, l lVar) {
        super(0);
        this.f13b = aVar;
        this.f14m = lVar;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f13b;
        boolean z10 = aVar instanceof b;
        l lVar = this.f14m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(l3.w.class), null, lVar) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(l3.w.class), null, lVar);
    }
}
