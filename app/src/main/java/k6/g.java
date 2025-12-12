package k6;

import java.util.Arrays;
import l6.u;

/* compiled from: DefaultAllocator.java */
/* loaded from: classes.dex */
public final class g implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14966a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14967b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f14968c;

    /* renamed from: d, reason: collision with root package name */
    public final a[] f14969d;

    /* renamed from: e, reason: collision with root package name */
    public int f14970e;

    /* renamed from: f, reason: collision with root package name */
    public int f14971f;

    /* renamed from: g, reason: collision with root package name */
    public int f14972g;

    /* renamed from: h, reason: collision with root package name */
    public a[] f14973h;

    public g(boolean z10, int i10) {
        this(z10, i10, 0);
    }

    public synchronized a allocate() {
        a aVar;
        this.f14971f++;
        int i10 = this.f14972g;
        if (i10 > 0) {
            a[] aVarArr = this.f14973h;
            int i11 = i10 - 1;
            this.f14972g = i11;
            aVar = aVarArr[i11];
            aVarArr[i11] = null;
        } else {
            aVar = new a(new byte[this.f14967b], 0);
        }
        return aVar;
    }

    public int getIndividualAllocationLength() {
        return this.f14967b;
    }

    public synchronized int getTotalBytesAllocated() {
        return this.f14971f * this.f14967b;
    }

    public synchronized void release(a aVar) {
        a[] aVarArr = this.f14969d;
        aVarArr[0] = aVar;
        release(aVarArr);
    }

    public synchronized void reset() {
        if (this.f14966a) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i10) {
        boolean z10 = i10 < this.f14970e;
        this.f14970e = i10;
        if (z10) {
            trim();
        }
    }

    public synchronized void trim() {
        int i10 = 0;
        int iMax = Math.max(0, u.ceilDivide(this.f14970e, this.f14967b) - this.f14971f);
        int i11 = this.f14972g;
        if (iMax >= i11) {
            return;
        }
        if (this.f14968c != null) {
            int i12 = i11 - 1;
            while (i10 <= i12) {
                a[] aVarArr = this.f14973h;
                a aVar = aVarArr[i10];
                byte[] bArr = aVar.f14951a;
                byte[] bArr2 = this.f14968c;
                if (bArr == bArr2) {
                    i10++;
                } else {
                    a aVar2 = aVarArr[i12];
                    if (aVar2.f14951a != bArr2) {
                        i12--;
                    } else {
                        aVarArr[i10] = aVar2;
                        aVarArr[i12] = aVar;
                        i12--;
                        i10++;
                    }
                }
            }
            iMax = Math.max(iMax, i10);
            if (iMax >= this.f14972g) {
                return;
            }
        }
        Arrays.fill(this.f14973h, iMax, this.f14972g, (Object) null);
        this.f14972g = iMax;
    }

    public g(boolean z10, int i10, int i11) {
        l6.a.checkArgument(i10 > 0);
        l6.a.checkArgument(i11 >= 0);
        this.f14966a = z10;
        this.f14967b = i10;
        this.f14972g = i11;
        this.f14973h = new a[i11 + 100];
        if (i11 > 0) {
            this.f14968c = new byte[i11 * i10];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f14973h[i12] = new a(this.f14968c, i12 * i10);
            }
        } else {
            this.f14968c = null;
        }
        this.f14969d = new a[1];
    }

    public synchronized void release(a[] aVarArr) {
        int i10 = this.f14972g;
        int length = aVarArr.length + i10;
        a[] aVarArr2 = this.f14973h;
        if (length >= aVarArr2.length) {
            this.f14973h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i10 + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            byte[] bArr = aVar.f14951a;
            l6.a.checkArgument(bArr == this.f14968c || bArr.length == this.f14967b);
            a[] aVarArr3 = this.f14973h;
            int i11 = this.f14972g;
            this.f14972g = i11 + 1;
            aVarArr3[i11] = aVar;
        }
        this.f14971f -= aVarArr.length;
        notifyAll();
    }
}
