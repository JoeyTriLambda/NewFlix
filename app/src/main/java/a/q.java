package a;

import kotlin.jvm.internal.Lambda;
import lh.b;
import qb.h;
import yf.a;

/* loaded from: classes.dex */
public final class q extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f17b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ m f18m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(lh.a aVar, m mVar) {
        super(0);
        this.f17b = aVar;
        this.f18m = mVar;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f17b;
        boolean z10 = aVar instanceof b;
        m mVar = this.f18m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(h.class), null, mVar) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(h.class), null, mVar);
    }
}
