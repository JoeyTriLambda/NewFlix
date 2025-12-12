package bf;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import ne.r;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes2.dex */
public final class d extends r {

    /* renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f4911c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f4912b;

    public d() {
        this(f4911c);
    }

    @Override // ne.r
    public r.c createWorker() {
        return new io.reactivex.internal.schedulers.a(this.f4912b);
    }

    public d(ThreadFactory threadFactory) {
        this.f4912b = threadFactory;
    }
}
