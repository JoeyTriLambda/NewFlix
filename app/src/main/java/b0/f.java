package b0;

/* compiled from: CircularIntArray.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int[] f4663a;

    /* renamed from: b, reason: collision with root package name */
    public int f4664b;

    /* renamed from: c, reason: collision with root package name */
    public int f4665c;

    public f() {
        this(8);
    }

    public void addLast(int i10) {
        int[] iArr = this.f4663a;
        int i11 = this.f4664b;
        iArr[i11] = i10;
        int i12 = this.f4665c & (i11 + 1);
        this.f4664b = i12;
        if (i12 == 0) {
            int length = iArr.length;
            int i13 = length + 0;
            int i14 = length << 1;
            if (i14 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i14];
            System.arraycopy(iArr, 0, iArr2, 0, i13);
            System.arraycopy(this.f4663a, 0, iArr2, i13, 0);
            this.f4663a = iArr2;
            this.f4664b = length;
            this.f4665c = i14 - 1;
        }
    }

    public void clear() {
        this.f4664b = 0;
    }

    public int get(int i10) {
        if (i10 < 0 || i10 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f4663a[this.f4665c & (0 + i10)];
    }

    public int getLast() {
        int i10 = this.f4664b;
        if (i10 != 0) {
            return this.f4663a[(i10 - 1) & this.f4665c];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i10 = this.f4664b;
        if (i10 == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = (i10 - 1) & this.f4665c;
        int i12 = this.f4663a[i11];
        this.f4664b = i11;
        return i12;
    }

    public int size() {
        return (this.f4664b + 0) & this.f4665c;
    }

    public f(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i10 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
        this.f4665c = i10 - 1;
        this.f4663a = new int[i10];
    }
}
