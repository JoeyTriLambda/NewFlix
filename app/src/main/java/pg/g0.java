package pg;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pg.h0;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes2.dex */
public class g0<T extends h0 & Comparable<? super T>> {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f17698b = AtomicIntegerFieldUpdater.newUpdater(g0.class, "_size");
    private volatile int _size;

    /* renamed from: a, reason: collision with root package name */
    public T[] f17699a;

    public final void a(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f17699a;
            zf.i.checkNotNull(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            zf.i.checkNotNull(t10);
            T t11 = tArr[i10];
            zf.i.checkNotNull(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            b(i10, i11);
            i10 = i11;
        }
    }

    public final void addImpl(T t10) {
        t10.setHeap(this);
        T[] tArr = this.f17699a;
        if (tArr == null) {
            tArr = (T[]) new h0[4];
            this.f17699a = tArr;
        } else if (getSize() >= tArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(tArr, getSize() * 2);
            zf.i.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            tArr = (T[]) ((h0[]) objArrCopyOf);
            this.f17699a = tArr;
        }
        int size = getSize();
        f17698b.set(this, size + 1);
        tArr[size] = t10;
        t10.setIndex(size);
        a(size);
    }

    public final void b(int i10, int i11) {
        T[] tArr = this.f17699a;
        zf.i.checkNotNull(tArr);
        T t10 = tArr[i11];
        zf.i.checkNotNull(t10);
        T t11 = tArr[i10];
        zf.i.checkNotNull(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.setIndex(i10);
        t11.setIndex(i11);
    }

    public final T firstImpl() {
        T[] tArr = this.f17699a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return f17698b.get(this);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T peek() {
        T t10;
        synchronized (this) {
            t10 = (T) firstImpl();
        }
        return t10;
    }

    public final boolean remove(T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.getHeap() == null) {
                z10 = false;
            } else {
                removeAtImpl(t10.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T removeAtImpl(int r8) {
        /*
            r7 = this;
            T extends pg.h0 & java.lang.Comparable<? super T>[] r0 = r7.f17699a
            zf.i.checkNotNull(r0)
            int r1 = r7.getSize()
            r2 = -1
            int r1 = r1 + r2
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = pg.g0.f17698b
            r3.set(r7, r1)
            int r1 = r7.getSize()
            if (r8 >= r1) goto L7f
            int r1 = r7.getSize()
            r7.b(r8, r1)
            int r1 = r8 + (-1)
            int r1 = r1 / 2
            if (r8 <= 0) goto L3c
            r3 = r0[r8]
            zf.i.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            zf.i.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3c
            r7.b(r8, r1)
            r7.a(r1)
            goto L7f
        L3c:
            int r1 = r8 * 2
            int r1 = r1 + 1
            int r3 = r7.getSize()
            if (r1 < r3) goto L47
            goto L7f
        L47:
            T extends pg.h0 & java.lang.Comparable<? super T>[] r3 = r7.f17699a
            zf.i.checkNotNull(r3)
            int r4 = r1 + 1
            int r5 = r7.getSize()
            if (r4 >= r5) goto L67
            r5 = r3[r4]
            zf.i.checkNotNull(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            r6 = r3[r1]
            zf.i.checkNotNull(r6)
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L67
            r1 = r4
        L67:
            r4 = r3[r8]
            zf.i.checkNotNull(r4)
            java.lang.Comparable r4 = (java.lang.Comparable) r4
            r3 = r3[r1]
            zf.i.checkNotNull(r3)
            int r3 = r4.compareTo(r3)
            if (r3 > 0) goto L7a
            goto L7f
        L7a:
            r7.b(r8, r1)
            r8 = r1
            goto L3c
        L7f:
            int r8 = r7.getSize()
            r8 = r0[r8]
            zf.i.checkNotNull(r8)
            r1 = 0
            r8.setHeap(r1)
            r8.setIndex(r2)
            int r2 = r7.getSize()
            r0[r2] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.g0.removeAtImpl(int):pg.h0");
    }

    public final T removeFirstOrNull() {
        T t10;
        synchronized (this) {
            t10 = getSize() > 0 ? (T) removeAtImpl(0) : null;
        }
        return t10;
    }
}
