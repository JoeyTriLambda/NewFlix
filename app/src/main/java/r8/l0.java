package r8;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OnDemandCounter.java */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f18721a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f18722b = new AtomicInteger();

    public void incrementDroppedOnDemandExceptions() {
        this.f18722b.getAndIncrement();
    }

    public void incrementRecordedOnDemandExceptions() {
        this.f18721a.getAndIncrement();
    }

    public void resetDroppedOnDemandExceptions() {
        this.f18722b.set(0);
    }
}
