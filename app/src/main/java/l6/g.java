package l6;

import java.util.Arrays;

/* compiled from: LongArray.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f15858a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f15859b;

    public g() {
        this(32);
    }

    public void add(long j10) {
        int i10 = this.f15858a;
        long[] jArr = this.f15859b;
        if (i10 == jArr.length) {
            this.f15859b = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = this.f15859b;
        int i11 = this.f15858a;
        this.f15858a = i11 + 1;
        jArr2[i11] = j10;
    }

    public long get(int i10) {
        if (i10 >= 0 && i10 < this.f15858a) {
            return this.f15859b[i10];
        }
        StringBuilder sbS = ac.c.s("Invalid index ", i10, ", size is ");
        sbS.append(this.f15858a);
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    public int size() {
        return this.f15858a;
    }

    public long[] toArray() {
        return Arrays.copyOf(this.f15859b, this.f15858a);
    }

    public g(int i10) {
        this.f15859b = new long[i10];
    }
}
