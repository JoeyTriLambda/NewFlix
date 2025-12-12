package ah;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import okio.ByteString;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes2.dex */
public final class s implements d {

    /* renamed from: b, reason: collision with root package name */
    public final w f716b;

    /* renamed from: m, reason: collision with root package name */
    public final c f717m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f718n;

    public s(w wVar) {
        zf.i.checkNotNullParameter(wVar, "sink");
        this.f716b = wVar;
        this.f717m = new c();
    }

    @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        w wVar = this.f716b;
        c cVar = this.f717m;
        if (this.f718n) {
            return;
        }
        try {
            if (cVar.size() > 0) {
                wVar.write(cVar, cVar.size());
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            wVar.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f718n = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // ah.d
    public d emit() throws IOException {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        c cVar = this.f717m;
        long size = cVar.size();
        if (size > 0) {
            this.f716b.write(cVar, size);
        }
        return this;
    }

    @Override // ah.d
    public d emitCompleteSegments() throws IOException {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        c cVar = this.f717m;
        long jCompleteSegmentByteCount = cVar.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.f716b.write(cVar, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // ah.d, ah.w, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        c cVar = this.f717m;
        long size = cVar.size();
        w wVar = this.f716b;
        if (size > 0) {
            wVar.write(cVar, cVar.size());
        }
        wVar.flush();
    }

    @Override // ah.d
    public c getBuffer() {
        return this.f717m;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f718n;
    }

    @Override // ah.w
    public z timeout() {
        return this.f716b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f716b + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        zf.i.checkNotNullParameter(byteBuffer, "source");
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f717m.write(byteBuffer);
        emitCompleteSegments();
        return iWrite;
    }

    @Override // ah.d
    public long writeAll(y yVar) throws IOException {
        zf.i.checkNotNullParameter(yVar, "source");
        long j10 = 0;
        while (true) {
            long j11 = yVar.read(this.f717m, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            emitCompleteSegments();
        }
    }

    @Override // ah.d
    public d writeByte(int i10) {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f717m.writeByte(i10);
        return emitCompleteSegments();
    }

    @Override // ah.d
    public d writeDecimalLong(long j10) {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f717m.writeDecimalLong(j10);
        return emitCompleteSegments();
    }

    @Override // ah.d
    public d writeHexadecimalUnsignedLong(long j10) {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f717m.writeHexadecimalUnsignedLong(j10);
        return emitCompleteSegments();
    }

    @Override // ah.d
    public d writeInt(int i10) {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f717m.writeInt(i10);
        return emitCompleteSegments();
    }

    @Override // ah.d
    public d writeShort(int i10) {
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f717m.writeShort(i10);
        return emitCompleteSegments();
    }

    @Override // ah.d
    public d writeUtf8(String str) {
        zf.i.checkNotNullParameter(str, "string");
        if (!(!this.f718n)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f717m.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // ah.w
    public void write(c cVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(cVar, "source");
        if (!this.f718n) {
            this.f717m.write(cVar, j10);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ah.d
    public d writeUtf8(String str, int i10, int i11) {
        zf.i.checkNotNullParameter(str, "string");
        if (!this.f718n) {
            this.f717m.writeUtf8(str, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ah.d
    public d write(ByteString byteString) {
        zf.i.checkNotNullParameter(byteString, "byteString");
        if (!this.f718n) {
            this.f717m.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ah.d
    public d write(byte[] bArr) {
        zf.i.checkNotNullParameter(bArr, "source");
        if (!this.f718n) {
            this.f717m.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ah.d
    public d write(byte[] bArr, int i10, int i11) {
        zf.i.checkNotNullParameter(bArr, "source");
        if (!this.f718n) {
            this.f717m.write(bArr, i10, i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }
}
