package wg;

import java.io.IOException;
import kg.e0;
import kotlin.coroutines.CoroutineContext;
import rb.p;

/* loaded from: classes2.dex */
public final class h extends qf.a implements e0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21176b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f21177m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e0.b bVar, int i10, c cVar) {
        super(bVar);
        this.f21176b = i10;
        this.f21177m = cVar;
    }

    @Override // kg.e0
    public final void handleException(CoroutineContext coroutineContext, Throwable th2) {
        boolean z10 = th2 instanceof IOException;
        int i10 = this.f21176b;
        if (!z10 || !zf.i.areEqual(th2.getMessage(), "EndOfStream")) {
            ng.g gVar = k.c.f14701a;
            k.c.a("UdpProxySession", "[" + i10 + "] error: " + th2.getMessage(), th2);
        }
        ((p) this.f21177m).a(i10, th2);
    }
}
