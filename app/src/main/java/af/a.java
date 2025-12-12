package af;

import cf.i;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import ve.e;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes2.dex */
public final class a<T> implements e<T> {

    /* renamed from: t, reason: collision with root package name */
    public static final int f661t = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: u, reason: collision with root package name */
    public static final Object f662u = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f663b;

    /* renamed from: m, reason: collision with root package name */
    public int f664m;

    /* renamed from: n, reason: collision with root package name */
    public long f665n;

    /* renamed from: o, reason: collision with root package name */
    public final int f666o;

    /* renamed from: p, reason: collision with root package name */
    public AtomicReferenceArray<Object> f667p;

    /* renamed from: q, reason: collision with root package name */
    public final int f668q;

    /* renamed from: r, reason: collision with root package name */
    public AtomicReferenceArray<Object> f669r;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicLong f670s;

    public a(int i10) {
        AtomicLong atomicLong = new AtomicLong();
        this.f663b = atomicLong;
        this.f670s = new AtomicLong();
        int iRoundToPowerOfTwo = i.roundToPowerOfTwo(Math.max(8, i10));
        int i11 = iRoundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iRoundToPowerOfTwo + 1);
        this.f667p = atomicReferenceArray;
        this.f666o = i11;
        this.f664m = Math.min(iRoundToPowerOfTwo / 4, f661t);
        this.f669r = atomicReferenceArray;
        this.f668q = i11;
        this.f665n = i11 - 1;
        atomicLong.lazySet(0L);
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
        return this.f663b.get() == this.f670s.get();
    }

    @Override // ve.f
    public boolean offer(T t10) {
        if (t10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f667p;
        AtomicLong atomicLong = this.f663b;
        long j10 = atomicLong.get();
        int i10 = this.f666o;
        int i11 = ((int) j10) & i10;
        if (j10 < this.f665n) {
            atomicReferenceArray.lazySet(i11, t10);
            atomicLong.lazySet(j10 + 1);
            return true;
        }
        long j11 = this.f664m + j10;
        if (atomicReferenceArray.get(((int) j11) & i10) == null) {
            this.f665n = j11 - 1;
            atomicReferenceArray.lazySet(i11, t10);
            atomicLong.lazySet(j10 + 1);
            return true;
        }
        long j12 = j10 + 1;
        if (atomicReferenceArray.get(((int) j12) & i10) == null) {
            atomicReferenceArray.lazySet(i11, t10);
            atomicLong.lazySet(j12);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f667p = atomicReferenceArray2;
        this.f665n = (i10 + j10) - 1;
        atomicReferenceArray2.lazySet(i11, t10);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i11, f662u);
        atomicLong.lazySet(j12);
        return true;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f669r;
        int i10 = (int) this.f670s.get();
        int i11 = this.f668q;
        int i12 = i10 & i11;
        T t10 = (T) atomicReferenceArray.get(i12);
        if (t10 != f662u) {
            return t10;
        }
        int i13 = i11 + 1;
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i13);
        atomicReferenceArray.lazySet(i13, null);
        this.f669r = atomicReferenceArray2;
        return (T) atomicReferenceArray2.get(i12);
    }

    @Override // ve.e, ve.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f669r;
        AtomicLong atomicLong = this.f670s;
        long j10 = atomicLong.get();
        int i10 = this.f668q;
        int i11 = ((int) j10) & i10;
        T t10 = (T) atomicReferenceArray.get(i11);
        boolean z10 = t10 == f662u;
        if (t10 != null && !z10) {
            atomicReferenceArray.lazySet(i11, null);
            atomicLong.lazySet(j10 + 1);
            return t10;
        }
        if (!z10) {
            return null;
        }
        int i12 = i10 + 1;
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i12);
        atomicReferenceArray.lazySet(i12, null);
        this.f669r = atomicReferenceArray2;
        T t11 = (T) atomicReferenceArray2.get(i11);
        if (t11 != null) {
            atomicReferenceArray2.lazySet(i11, null);
            atomicLong.lazySet(j10 + 1);
        }
        return t11;
    }

    public int size() {
        AtomicLong atomicLong = this.f670s;
        long j10 = atomicLong.get();
        while (true) {
            long j11 = this.f663b.get();
            long j12 = atomicLong.get();
            if (j10 == j12) {
                return (int) (j11 - j12);
            }
            j10 = j12;
        }
    }

    public boolean offer(T t10, T t11) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f667p;
        AtomicLong atomicLong = this.f663b;
        long j10 = atomicLong.get();
        long j11 = 2 + j10;
        int i10 = this.f666o;
        if (atomicReferenceArray.get(((int) j11) & i10) == null) {
            int i11 = i10 & ((int) j10);
            atomicReferenceArray.lazySet(i11 + 1, t11);
            atomicReferenceArray.lazySet(i11, t10);
            atomicLong.lazySet(j11);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f667p = atomicReferenceArray2;
        int i12 = i10 & ((int) j10);
        atomicReferenceArray2.lazySet(i12 + 1, t11);
        atomicReferenceArray2.lazySet(i12, t10);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i12, f662u);
        atomicLong.lazySet(j11);
        return true;
    }
}
