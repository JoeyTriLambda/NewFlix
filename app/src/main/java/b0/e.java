package b0;

/* compiled from: CircularArray.java */
/* loaded from: classes.dex */
public final class e<E> {

    /* renamed from: a, reason: collision with root package name */
    public E[] f4659a;

    /* renamed from: b, reason: collision with root package name */
    public int f4660b;

    /* renamed from: c, reason: collision with root package name */
    public int f4661c;

    /* renamed from: d, reason: collision with root package name */
    public int f4662d;

    public e(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i10 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
        this.f4662d = i10 - 1;
        this.f4659a = (E[]) new Object[i10];
    }

    public final void a() {
        E[] eArr = this.f4659a;
        int length = eArr.length;
        int i10 = this.f4660b;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i12];
        System.arraycopy(eArr, i10, eArr2, 0, i11);
        System.arraycopy(this.f4659a, 0, eArr2, i11, this.f4660b);
        this.f4659a = eArr2;
        this.f4660b = 0;
        this.f4661c = length;
        this.f4662d = i12 - 1;
    }

    public void addFirst(E e10) {
        int i10 = (this.f4660b - 1) & this.f4662d;
        this.f4660b = i10;
        this.f4659a[i10] = e10;
        if (i10 == this.f4661c) {
            a();
        }
    }

    public void addLast(E e10) {
        E[] eArr = this.f4659a;
        int i10 = this.f4661c;
        eArr[i10] = e10;
        int i11 = this.f4662d & (i10 + 1);
        this.f4661c = i11;
        if (i11 == this.f4660b) {
            a();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i10) {
        if (i10 < 0 || i10 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f4659a[this.f4662d & (this.f4660b + i10)];
    }

    public void removeFromEnd(int i10) {
        int i11;
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f4661c;
        int i13 = i10 < i12 ? i12 - i10 : 0;
        int i14 = i13;
        while (true) {
            i11 = this.f4661c;
            if (i14 >= i11) {
                break;
            }
            this.f4659a[i14] = null;
            i14++;
        }
        int i15 = i11 - i13;
        int i16 = i10 - i15;
        this.f4661c = i11 - i15;
        if (i16 > 0) {
            int length = this.f4659a.length;
            this.f4661c = length;
            int i17 = length - i16;
            for (int i18 = i17; i18 < this.f4661c; i18++) {
                this.f4659a[i18] = null;
            }
            this.f4661c = i17;
        }
    }

    public void removeFromStart(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.f4659a.length;
        int i11 = this.f4660b;
        if (i10 < length - i11) {
            length = i11 + i10;
        }
        while (i11 < length) {
            this.f4659a[i11] = null;
            i11++;
        }
        int i12 = this.f4660b;
        int i13 = length - i12;
        int i14 = i10 - i13;
        this.f4660b = this.f4662d & (i12 + i13);
        if (i14 > 0) {
            for (int i15 = 0; i15 < i14; i15++) {
                this.f4659a[i15] = null;
            }
            this.f4660b = i14;
        }
    }

    public int size() {
        return (this.f4661c - this.f4660b) & this.f4662d;
    }
}
