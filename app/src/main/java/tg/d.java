package tg;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import pg.y;

/* compiled from: Semaphore.kt */
/* loaded from: classes2.dex */
public final class d extends y<d> {

    /* renamed from: p, reason: collision with root package name */
    public final AtomicReferenceArray f19923p;

    public d(long j10, d dVar, int i10) {
        super(j10, dVar, i10);
        this.f19923p = new AtomicReferenceArray(c.f19922f);
    }

    public final AtomicReferenceArray getAcquirers() {
        return this.f19923p;
    }

    @Override // pg.y
    public int getNumberOfSlots() {
        return c.f19922f;
    }

    @Override // pg.y
    public void onCancellation(int i10, Throwable th2, CoroutineContext coroutineContext) {
        getAcquirers().set(i10, c.f19921e);
        onSlotCleaned();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f17734n + ", hashCode=" + hashCode() + ']';
    }
}
