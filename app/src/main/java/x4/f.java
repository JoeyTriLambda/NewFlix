package x4;

import h9.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import m8.f;
import q4.o;
import t8.g0;
import x2.p;
import z4.a;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements a.InterfaceC0331a, f.c, a.InterfaceC0161a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21523b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f21524m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f21525n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f21526o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f21527p;

    public /* synthetic */ f(Object obj, Object obj2, long j10, Object obj3, int i10) {
        this.f21523b = i10;
        this.f21525n = obj;
        this.f21526o = obj2;
        this.f21524m = j10;
        this.f21527p = obj3;
    }

    @Override // m8.f.c
    public final ScheduledFuture addCompleter(f.b bVar) {
        int i10 = this.f21523b;
        long j10 = this.f21524m;
        Object obj = this.f21527p;
        Object obj2 = this.f21526o;
        Object obj3 = this.f21525n;
        switch (i10) {
            case 1:
                m8.e eVar = (m8.e) obj3;
                eVar.getClass();
                p pVar = new p(1, eVar, (Callable) obj2, bVar);
                return eVar.f16220m.schedule(pVar, j10, (TimeUnit) obj);
            default:
                m8.e eVar2 = (m8.e) obj3;
                eVar2.getClass();
                m8.c cVar = new m8.c(eVar2, (Runnable) obj2, bVar, 2);
                return eVar2.f16220m.schedule(cVar, j10, (TimeUnit) obj);
        }
    }

    @Override // z4.a.InterfaceC0331a
    public final Object execute() {
        h hVar = (h) this.f21525n;
        Iterable<y4.j> iterable = (Iterable) this.f21526o;
        o oVar = (o) this.f21527p;
        y4.d dVar = hVar.f21533c;
        dVar.recordFailure(iterable);
        dVar.recordNextCallTime(oVar, hVar.f21537g.getTime() + this.f21524m);
        return null;
    }

    @Override // h9.a.InterfaceC0161a
    public final void handle(h9.b bVar) {
        ((o8.a) bVar.get()).prepareNativeSession((String) this.f21525n, (String) this.f21526o, this.f21524m, (g0) this.f21527p);
    }

    public /* synthetic */ f(h hVar, Iterable iterable, o oVar, long j10) {
        this.f21523b = 0;
        this.f21525n = hVar;
        this.f21526o = iterable;
        this.f21527p = oVar;
        this.f21524m = j10;
    }
}
