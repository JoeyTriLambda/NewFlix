package io.reactivex.internal.queue;

import cf.i;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import ve.e;

/* loaded from: classes2.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements e<E> {

    /* renamed from: q, reason: collision with root package name */
    public static final Integer f14503q = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* renamed from: b, reason: collision with root package name */
    public final int f14504b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicLong f14505m;

    /* renamed from: n, reason: collision with root package name */
    public long f14506n;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicLong f14507o;

    /* renamed from: p, reason: collision with root package name */
    public final int f14508p;

    public SpscArrayQueue(int i10) {
        super(i.roundToPowerOfTwo(i10));
        this.f14504b = length() - 1;
        this.f14505m = new AtomicLong();
        this.f14507o = new AtomicLong();
        this.f14508p = Math.min(i10 / 4, f14503q.intValue());
    }

    @Override // ve.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // ve.f
    public boolean isEmpty() {
        return this.f14505m.get() == this.f14507o.get();
    }

    @Override // ve.f
    public boolean offer(E e10) {
        if (e10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicLong atomicLong = this.f14505m;
        long j10 = atomicLong.get();
        int i10 = this.f14504b;
        int i11 = ((int) j10) & i10;
        if (j10 >= this.f14506n) {
            long j11 = this.f14508p + j10;
            if (get(i10 & ((int) j11)) == null) {
                this.f14506n = j11;
            } else if (get(i11) != null) {
                return false;
            }
        }
        lazySet(i11, e10);
        atomicLong.lazySet(j10 + 1);
        return true;
    }

    @Override // ve.e, ve.f
    public E poll() {
        AtomicLong atomicLong = this.f14507o;
        long j10 = atomicLong.get();
        int i10 = ((int) j10) & this.f14504b;
        E e10 = get(i10);
        if (e10 == null) {
            return null;
        }
        atomicLong.lazySet(j10 + 1);
        lazySet(i10, null);
        return e10;
    }
}
