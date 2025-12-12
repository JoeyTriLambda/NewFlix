package kotlinx.coroutines.sync;

import ac.c;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lf.h;
import tg.d;
import yf.l;

/* compiled from: Semaphore.kt */
/* loaded from: classes2.dex */
public class SemaphoreImpl {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15618c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15619d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15620e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15621f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15622g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    private volatile int _availablePermits;

    /* renamed from: a, reason: collision with root package name */
    public final int f15623a;

    /* renamed from: b, reason: collision with root package name */
    public final l<Throwable, h> f15624b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public SemaphoreImpl(int i10, int i11) {
        this.f15623a = i10;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(c.f("Semaphore should have at least 1 permit, but had ", i10).toString());
        }
        if (!(i11 >= 0 && i11 <= i10)) {
            throw new IllegalArgumentException(c.f("The number of acquired permits should be in 0..", i10).toString());
        }
        d dVar = new d(0L, null, 2);
        this.head = dVar;
        this.tail = dVar;
        this._availablePermits = i10 - i11;
        this.f15624b = new l<Throwable, h>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                this.f15626b.release();
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x010f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void acquire(kg.l<? super lf.h> r20) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.acquire(kg.l):void");
    }

    public int getAvailablePermits() {
        return Math.max(f15622g.get(this), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void release() {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.release():void");
    }

    public boolean tryAcquire() {
        int i10;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15622g;
            int i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = this.f15623a;
            if (i11 > i12) {
                do {
                    i10 = atomicIntegerFieldUpdater.get(this);
                    if (i10 > i12) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i12));
            } else {
                if (i11 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i11, i11 - 1)) {
                    return true;
                }
            }
        }
    }
}
