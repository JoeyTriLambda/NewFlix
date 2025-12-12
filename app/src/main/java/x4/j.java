package x4;

import java.util.concurrent.Executor;

/* compiled from: WorkInitializer.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f21549a;

    /* renamed from: b, reason: collision with root package name */
    public final y4.d f21550b;

    /* renamed from: c, reason: collision with root package name */
    public final l f21551c;

    /* renamed from: d, reason: collision with root package name */
    public final z4.a f21552d;

    public j(Executor executor, y4.d dVar, l lVar, z4.a aVar) {
        this.f21549a = executor;
        this.f21550b = dVar;
        this.f21551c = lVar;
        this.f21552d = aVar;
    }

    public void ensureContextsScheduled() {
        this.f21549a.execute(new androidx.activity.d(this, 10));
    }
}
