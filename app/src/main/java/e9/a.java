package e9;

import java.io.OutputStream;

/* compiled from: LengthCountingOutputStream.java */
/* loaded from: classes.dex */
public final class a extends OutputStream {

    /* renamed from: b, reason: collision with root package name */
    public long f11171b = 0;

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f11171b++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f11171b += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) <= bArr.length && i12 >= 0) {
            this.f11171b += i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
