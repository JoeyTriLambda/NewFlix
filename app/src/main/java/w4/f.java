package w4;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* compiled from: SchedulingConfigModule_ConfigFactory.java */
/* loaded from: classes.dex */
public final class f implements s4.b<SchedulerConfig> {

    /* renamed from: a, reason: collision with root package name */
    public final jf.a<a5.a> f20948a;

    public f(jf.a<a5.a> aVar) {
        this.f20948a = aVar;
    }

    public static SchedulerConfig config(a5.a aVar) {
        return (SchedulerConfig) s4.d.checkNotNull(SchedulerConfig.getDefault(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static f create(jf.a<a5.a> aVar) {
        return new f(aVar);
    }

    @Override // jf.a
    public SchedulerConfig get() {
        return config(this.f20948a.get());
    }
}
