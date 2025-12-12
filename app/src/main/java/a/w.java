package a;

import kotlin.jvm.internal.Lambda;
import lh.b;
import yf.a;

/* loaded from: classes.dex */
public final class w extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f24b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ t f25m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(lh.a aVar, t tVar) {
        super(0);
        this.f24b = aVar;
        this.f25m = tVar;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f24b;
        boolean z10 = aVar instanceof b;
        t tVar = this.f25m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(p000if.b.class), null, tVar) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(p000if.b.class), null, tVar);
    }
}
