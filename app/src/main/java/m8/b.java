package m8;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import m8.f;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements f.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16206b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f16207m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Runnable f16208n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f16209o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f16210p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f16211q;

    public /* synthetic */ b(e eVar, Runnable runnable, long j10, long j11, TimeUnit timeUnit, int i10) {
        this.f16206b = i10;
        this.f16207m = eVar;
        this.f16208n = runnable;
        this.f16209o = j10;
        this.f16210p = j11;
        this.f16211q = timeUnit;
    }

    @Override // m8.f.c
    public final ScheduledFuture addCompleter(f.b bVar) {
        int i10 = this.f16206b;
        Runnable runnable = this.f16208n;
        e eVar = this.f16207m;
        switch (i10) {
            case 0:
                return eVar.f16220m.scheduleWithFixedDelay(new c(eVar, runnable, bVar, 1), this.f16209o, this.f16210p, this.f16211q);
            default:
                return eVar.f16220m.scheduleAtFixedRate(new c(eVar, runnable, bVar, 0), this.f16209o, this.f16210p, this.f16211q);
        }
    }
}
