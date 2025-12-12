package k6;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataSourceInputStream.java */
/* loaded from: classes.dex */
public final class e extends InputStream {

    /* renamed from: b, reason: collision with root package name */
    public final d f14953b;

    /* renamed from: m, reason: collision with root package name */
    public final f f14954m;

    /* renamed from: q, reason: collision with root package name */
    public long f14958q;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14956o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14957p = false;

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f14955n = new byte[1];

    public e(d dVar, f fVar) {
        this.f14953b = dVar;
        this.f14954m = fVar;
    }

    public long bytesRead() {
        return this.f14958q;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f14957p) {
            return;
        }
        this.f14953b.close();
        this.f14957p = true;
    }

    public void open() throws IOException {
        if (this.f14956o) {
            return;
        }
        this.f14953b.open(this.f14954m);
        this.f14956o = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.f14955n;
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        l6.a.checkState(!this.f14957p);
        boolean z10 = this.f14956o;
        d dVar = this.f14953b;
        if (!z10) {
            dVar.open(this.f14954m);
            this.f14956o = true;
        }
        int i12 = dVar.read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        this.f14958q += i12;
        return i12;
    }
}
