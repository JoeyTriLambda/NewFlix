package k;

import a.k;
import a.l;
import a.m;
import a.n;
import a.o;
import a.q;
import kg.g0;
import kg.s0;
import kotlin.coroutines.CoroutineContext;
import lh.a;
import rb.p;
import zf.i;

/* loaded from: classes.dex */
public final class h implements lh.a, g0 {

    /* renamed from: b, reason: collision with root package name */
    public final p000if.b f14706b;

    /* renamed from: m, reason: collision with root package name */
    public final p f14707m;

    /* renamed from: n, reason: collision with root package name */
    public final lf.e f14708n;

    /* renamed from: o, reason: collision with root package name */
    public final lf.e f14709o;

    /* renamed from: p, reason: collision with root package name */
    public final lf.e f14710p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14711q;

    public h(p000if.b bVar, p pVar) {
        i.checkNotNullParameter(bVar, "configRepository");
        i.checkNotNullParameter(pVar, "proxyBloc");
        this.f14706b = bVar;
        this.f14707m = pVar;
        l lVar = new l(this);
        yh.b bVar2 = yh.b.f22543a;
        this.f14708n = kotlin.a.lazy(bVar2.defaultLazyMode(), new o(this, lVar));
        this.f14709o = kotlin.a.lazy(bVar2.defaultLazyMode(), new a.p(this, new n(this)));
        this.f14710p = kotlin.a.lazy(bVar2.defaultLazyMode(), new q(this, new m(this)));
        kg.h.launch$default(this, null, null, new a.e(this, null), 3, null);
        kg.h.launch$default(this, null, null, new a.g(this, null), 3, null);
        kg.h.launch$default(this, null, null, new a.i(this, null), 3, null);
        kg.h.launch$default(this, null, null, new k(this, null), 3, null);
    }

    @Override // kg.g0
    public final CoroutineContext getCoroutineContext() {
        return s0.getDefault();
    }

    @Override // lh.a
    public final kh.a getKoin() {
        return a.C0191a.getKoin(this);
    }
}
