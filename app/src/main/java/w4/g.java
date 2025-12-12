package w4;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import x4.l;

/* compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* loaded from: classes.dex */
public final class g implements s4.b<l> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<Context> f20949a;

    /* renamed from: b, reason: collision with root package name */
    public final jf.a<y4.d> f20950b;

    /* renamed from: c, reason: collision with root package name */
    public final jf.a<SchedulerConfig> f20951c;

    /* renamed from: d, reason: collision with root package name */
    public final jf.a<a5.a> f20952d;

    public g(jf.a<Context> aVar, jf.a<y4.d> aVar2, jf.a<SchedulerConfig> aVar3, jf.a<a5.a> aVar4) {
        this.f20949a = aVar;
        this.f20950b = aVar2;
        this.f20951c = aVar3;
        this.f20952d = aVar4;
    }

    public static g create(jf.a<Context> aVar, jf.a<y4.d> aVar2, jf.a<SchedulerConfig> aVar3, jf.a<a5.a> aVar4) {
        return new g(aVar, aVar2, aVar3, aVar4);
    }

    public static l workScheduler(Context context, y4.d dVar, SchedulerConfig schedulerConfig, a5.a aVar) {
        return (l) s4.d.checkNotNull(new x4.b(context, dVar, schedulerConfig), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // jf.a
    public l get() {
        return workScheduler(this.f20949a.get(), this.f20950b.get(), this.f20951c.get(), this.f20952d.get());
    }
}
