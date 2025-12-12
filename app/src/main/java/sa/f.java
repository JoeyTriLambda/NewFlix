package sa;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream.java */
/* loaded from: classes2.dex */
public final class f extends InputStream {

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f19188b;

    /* renamed from: m, reason: collision with root package name */
    public long f19189m;

    /* renamed from: n, reason: collision with root package name */
    public long f19190n;

    /* renamed from: o, reason: collision with root package name */
    public long f19191o;

    /* renamed from: p, reason: collision with root package name */
    public long f19192p = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19193q = true;

    /* renamed from: r, reason: collision with root package name */
    public final int f19194r;

    public f(InputStream inputStream) {
        this.f19194r = -1;
        this.f19188b = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, 4096);
        this.f19194r = 1024;
    }

    public final void a(long j10) throws IOException {
        try {
            long j11 = this.f19190n;
            long j12 = this.f19189m;
            InputStream inputStream = this.f19188b;
            if (j11 >= j12 || j12 > this.f19191o) {
                this.f19190n = j12;
                inputStream.mark((int) (j10 - j12));
            } else {
                inputStream.reset();
                inputStream.mark((int) (j10 - this.f19190n));
                b(this.f19190n, this.f19189m);
            }
            this.f19191o = j10;
        } catch (IOException e10) {
            throw new IllegalStateException("Unable to mark: " + e10);
        }
    }

    public void allowMarksToExpire(boolean z10) {
        this.f19193q = z10;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f19188b.available();
    }

    public final void b(long j10, long j11) throws IOException {
        while (j10 < j11) {
            long jSkip = this.f19188b.skip(j11 - j10);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j10 += jSkip;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f19188b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f19192p = savePosition(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f19188b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.f19193q) {
            long j10 = this.f19189m + 1;
            long j11 = this.f19191o;
            if (j10 > j11) {
                a(j11 + this.f19194r);
            }
        }
        int i10 = this.f19188b.read();
        if (i10 != -1) {
            this.f19189m++;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        reset(this.f19192p);
    }

    public long savePosition(int i10) throws IOException {
        long j10 = this.f19189m + i10;
        if (this.f19191o < j10) {
            a(j10);
        }
        return this.f19189m;
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        if (!this.f19193q) {
            long j11 = this.f19189m;
            if (j11 + j10 > this.f19191o) {
                a(j11 + j10 + this.f19194r);
            }
        }
        long jSkip = this.f19188b.skip(j10);
        this.f19189m += jSkip;
        return jSkip;
    }

    public void reset(long j10) throws IOException {
        if (this.f19189m > this.f19191o || j10 < this.f19190n) {
            throw new IOException("Cannot reset");
        }
        this.f19188b.reset();
        b(this.f19190n, j10);
        this.f19189m = j10;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (!this.f19193q) {
            long j10 = this.f19189m;
            if (bArr.length + j10 > this.f19191o) {
                a(j10 + bArr.length + this.f19194r);
            }
        }
        int i10 = this.f19188b.read(bArr);
        if (i10 != -1) {
            this.f19189m += i10;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.f19193q) {
            long j10 = this.f19189m;
            long j11 = i11;
            if (j10 + j11 > this.f19191o) {
                a(j10 + j11 + this.f19194r);
            }
        }
        int i12 = this.f19188b.read(bArr, i10, i11);
        if (i12 != -1) {
            this.f19189m += i12;
        }
        return i12;
    }
}
