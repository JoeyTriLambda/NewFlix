package pg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kg.z1;
import kotlin.coroutines.CoroutineContext;
import pg.y;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes2.dex */
public abstract class y<S extends y<S>> extends e<S> implements z1 {

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f17733o = AtomicIntegerFieldUpdater.newUpdater(y.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: n, reason: collision with root package name */
    public final long f17734n;

    public y(long j10, S s10, int i10) {
        super(s10);
        this.f17734n = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return f17733o.addAndGet(this, -65536) == getNumberOfSlots() && !isTail();
    }

    public abstract int getNumberOfSlots();

    @Override // pg.e
    public boolean isRemoved() {
        return f17733o.get(this) == getNumberOfSlots() && !isTail();
    }

    public abstract void onCancellation(int i10, Throwable th2, CoroutineContext coroutineContext);

    public final void onSlotCleaned() {
        if (f17733o.incrementAndGet(this) == getNumberOfSlots()) {
            remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f17733o;
            i10 = atomicIntegerFieldUpdater.get(this);
            if (!(i10 != getNumberOfSlots() || isTail())) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
