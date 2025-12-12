package n5;

import java.util.Arrays;

/* compiled from: NalUnitTargetBuffer.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f16658a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16659b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16660c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f16661d;

    /* renamed from: e, reason: collision with root package name */
    public int f16662e;

    public n(int i10, int i11) {
        this.f16658a = i10;
        byte[] bArr = new byte[i11 + 3];
        this.f16661d = bArr;
        bArr[2] = 1;
    }

    public void appendToNalUnit(byte[] bArr, int i10, int i11) {
        if (this.f16659b) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f16661d;
            int length = bArr2.length;
            int i13 = this.f16662e;
            if (length < i13 + i12) {
                this.f16661d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.f16661d, this.f16662e, i12);
            this.f16662e += i12;
        }
    }

    public boolean endNalUnit(int i10) {
        if (!this.f16659b) {
            return false;
        }
        this.f16662e -= i10;
        this.f16659b = false;
        this.f16660c = true;
        return true;
    }

    public boolean isCompleted() {
        return this.f16660c;
    }

    public void reset() {
        this.f16659b = false;
        this.f16660c = false;
    }

    public void startNalUnit(int i10) {
        l6.a.checkState(!this.f16659b);
        boolean z10 = i10 == this.f16658a;
        this.f16659b = z10;
        if (z10) {
            this.f16662e = 3;
            this.f16660c = false;
        }
    }
}
