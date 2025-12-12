package wg;

import java.io.IOException;
import kg.e0;
import kotlin.coroutines.CoroutineContext;
import rb.p;

/* loaded from: classes2.dex */
public final class d extends qf.a implements e0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21155b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f21156m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e0.b bVar, int i10, c cVar) {
        super(bVar);
        this.f21155b = i10;
        this.f21156m = cVar;
    }

    @Override // kg.e0
    public final void handleException(CoroutineContext coroutineContext, Throwable th2) {
        boolean z10 = th2 instanceof IOException;
        int i10 = this.f21155b;
        if (!z10 || !zf.i.areEqual(th2.getMessage(), "EndOfStream")) {
            ng.g gVar = k.c.f14701a;
            k.c.a("TcpProxySession", "[" + i10 + "] error: " + th2.getMessage(), th2);
        }
        ((p) this.f21156m).a(i10, th2);
    }
}
