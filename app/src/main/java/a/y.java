package a;

import kotlin.jvm.internal.Lambda;
import lh.b;
import xg.d0;
import yf.a;

/* loaded from: classes.dex */
public final class y extends Lambda implements a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ lh.a f28b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ A f29m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(lh.a aVar, A a10) {
        super(0);
        this.f28b = aVar;
        this.f29m = a10;
    }

    @Override // yf.a
    public final Object invoke() {
        lh.a aVar = this.f28b;
        boolean z10 = aVar instanceof b;
        A a10 = this.f29m;
        return z10 ? ((b) aVar).getScope().get(zf.k.getOrCreateKotlinClass(d0.class), null, a10) : aVar.getKoin().getScopeRegistry().getRootScope().get(zf.k.getOrCreateKotlinClass(d0.class), null, a10);
    }
}
