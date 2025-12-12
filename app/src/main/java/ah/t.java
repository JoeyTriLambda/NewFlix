package ah;

import android.support.v4.media.session.PlaybackStateCompat;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes2.dex */
public final class t implements e {

    /* renamed from: b, reason: collision with root package name */
    public final y f719b;

    /* renamed from: m, reason: collision with root package name */
    public final c f720m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f721n;

    public t(y yVar) {
        zf.i.checkNotNullParameter(yVar, "source");
        this.f719b = yVar;
        this.f720m = new c();
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f721n) {
            return;
        }
        this.f721n = true;
        this.f719b.close();
        this.f720m.clear();
    }

    @Override // ah.e
    public boolean exhausted() {
        if (!(!this.f721n)) {
            throw new IllegalStateException("closed".toString());
        }
        c cVar = this.f720m;
        return cVar.exhausted() && this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // ah.e, ah.d
    public c getBuffer() {
        return this.f720m;
    }

    public long indexOf(byte b10) {
        return indexOf(b10, 0L, Long.MAX_VALUE);
    }

    @Override // ah.e
    public long indexOfElement(ByteString byteString) {
        zf.i.checkNotNullParameter(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // ah.e
    public InputStream inputStream() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f721n;
    }

    @Override // ah.e
    public e peek() {
        return m.buffer(new r(this));
    }

    @Override // ah.e
    public boolean rangeEquals(long j10, ByteString byteString) {
        zf.i.checkNotNullParameter(byteString, "bytes");
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        zf.i.checkNotNullParameter(byteBuffer, "sink");
        c cVar = this.f720m;
        if (cVar.size() == 0 && this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return cVar.read(byteBuffer);
    }

    @Override // ah.e
    public long readAll(w wVar) throws IOException {
        c cVar;
        zf.i.checkNotNullParameter(wVar, "sink");
        long j10 = 0;
        while (true) {
            y yVar = this.f719b;
            cVar = this.f720m;
            if (yVar.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            long jCompleteSegmentByteCount = cVar.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j10 += jCompleteSegmentByteCount;
                wVar.write(cVar, jCompleteSegmentByteCount);
            }
        }
        if (cVar.size() <= 0) {
            return j10;
        }
        long size = j10 + cVar.size();
        wVar.write(cVar, cVar.size());
        return size;
    }

    @Override // ah.e
    public byte readByte() throws EOFException {
        require(1L);
        return this.f720m.readByte();
    }

    @Override // ah.e
    public byte[] readByteArray() throws IOException {
        y yVar = this.f719b;
        c cVar = this.f720m;
        cVar.writeAll(yVar);
        return cVar.readByteArray();
    }

    @Override // ah.e
    public ByteString readByteString() throws IOException {
        y yVar = this.f719b;
        c cVar = this.f720m;
        cVar.writeAll(yVar);
        return cVar.readByteString();
    }

    @Override // ah.e
    public long readDecimalLong() throws EOFException {
        c cVar;
        byte b10;
        require(1L);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            boolean zRequest = request(j11);
            cVar = this.f720m;
            if (!zRequest) {
                break;
            }
            b10 = cVar.getByte(j10);
            if ((b10 < ((byte) 48) || b10 > ((byte) 57)) && !(j10 == 0 && b10 == ((byte) 45))) {
                break;
            }
            j10 = j11;
        }
        if (j10 == 0) {
            String string = Integer.toString(b10, ig.a.checkRadix(ig.a.checkRadix(16)));
            zf.i.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(zf.i.stringPlus("Expected a digit or '-' but was 0x", string));
        }
        return cVar.readDecimalLong();
    }

    @Override // ah.e
    public void readFully(byte[] bArr) throws EOFException {
        c cVar = this.f720m;
        zf.i.checkNotNullParameter(bArr, "sink");
        try {
            require(bArr.length);
            cVar.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (cVar.size() > 0) {
                int i11 = cVar.read(bArr, i10, (int) cVar.size());
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
            throw e10;
        }
    }

    @Override // ah.e
    public long readHexadecimalUnsignedLong() throws EOFException {
        c cVar;
        byte b10;
        require(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            boolean zRequest = request(i11);
            cVar = this.f720m;
            if (!zRequest) {
                break;
            }
            b10 = cVar.getByte(i10);
            if ((b10 < ((byte) 48) || b10 > ((byte) 57)) && ((b10 < ((byte) 97) || b10 > ((byte) 102)) && (b10 < ((byte) 65) || b10 > ((byte) 70)))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            String string = Integer.toString(b10, ig.a.checkRadix(ig.a.checkRadix(16)));
            zf.i.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(zf.i.stringPlus("Expected leading [0-9a-fA-F] character but was 0x", string));
        }
        return cVar.readHexadecimalUnsignedLong();
    }

    @Override // ah.e
    public int readInt() throws EOFException {
        require(4L);
        return this.f720m.readInt();
    }

    public int readIntLe() throws EOFException {
        require(4L);
        return this.f720m.readIntLe();
    }

    @Override // ah.e
    public long readLong() throws EOFException {
        require(8L);
        return this.f720m.readLong();
    }

    @Override // ah.e
    public short readShort() throws EOFException {
        require(2L);
        return this.f720m.readShort();
    }

    public short readShortLe() throws EOFException {
        require(2L);
        return this.f720m.readShortLe();
    }

    @Override // ah.e
    public String readString(Charset charset) throws IOException {
        zf.i.checkNotNullParameter(charset, "charset");
        y yVar = this.f719b;
        c cVar = this.f720m;
        cVar.writeAll(yVar);
        return cVar.readString(charset);
    }

    @Override // ah.e
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // ah.e
    public boolean request(long j10) {
        c cVar;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(!this.f721n)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            cVar = this.f720m;
            if (cVar.size() >= j10) {
                return true;
            }
        } while (this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // ah.e
    public void require(long j10) throws EOFException {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override // ah.e
    public int select(p pVar) throws EOFException {
        zf.i.checkNotNullParameter(pVar, "options");
        if (!(!this.f721n)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            c cVar = this.f720m;
            int iSelectPrefix = bh.a.selectPrefix(cVar, pVar, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix != -1) {
                    cVar.skip(pVar.getByteStrings$okio()[iSelectPrefix].size());
                    return iSelectPrefix;
                }
            } else if (this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // ah.e
    public void skip(long j10) throws EOFException {
        if (!(!this.f721n)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            c cVar = this.f720m;
            if (cVar.size() == 0 && this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, cVar.size());
            cVar.skip(jMin);
            j10 -= jMin;
        }
    }

    @Override // ah.y
    public z timeout() {
        return this.f719b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f719b + ')';
    }

    public long indexOf(byte b10, long j10, long j11) {
        if (!(!this.f721n)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j10 && j10 <= j11)) {
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        while (j10 < j11) {
            long jIndexOf = this.f720m.indexOf(b10, j10, j11);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            c cVar = this.f720m;
            long size = cVar.size();
            if (size >= j11 || this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, size);
        }
        return -1L;
    }

    public long indexOfElement(ByteString byteString, long j10) {
        zf.i.checkNotNullParameter(byteString, "targetBytes");
        if (!(!this.f721n)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            c cVar = this.f720m;
            long jIndexOfElement = cVar.indexOfElement(byteString, j10);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = cVar.size();
            if (this.f719b.read(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, size);
        }
    }

    @Override // ah.e
    public String readUtf8LineStrict(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("limit < 0: ", Long.valueOf(j10)).toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        byte b10 = (byte) 10;
        long jIndexOf = indexOf(b10, 0L, j11);
        c cVar = this.f720m;
        if (jIndexOf != -1) {
            return bh.a.readUtf8Line(cVar, jIndexOf);
        }
        if (j11 < Long.MAX_VALUE && request(j11) && cVar.getByte(j11 - 1) == ((byte) 13) && request(1 + j11) && cVar.getByte(j11) == b10) {
            return bh.a.readUtf8Line(cVar, j11);
        }
        c cVar2 = new c();
        c cVar3 = this.f720m;
        cVar3.copyTo(cVar2, 0L, Math.min(32, cVar3.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(cVar.size(), j10) + " content=" + cVar2.readByteString().hex() + (char) 8230);
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        zf.i.checkNotNullParameter(byteString, "bytes");
        if (!this.f721n) {
            if (j10 >= 0 && i10 >= 0 && i11 >= 0 && byteString.size() - i10 >= i11) {
                if (i11 <= 0) {
                    return true;
                }
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    long j11 = i12 + j10;
                    if (!request(1 + j11) || this.f720m.getByte(j11) != byteString.getByte(i12 + i10)) {
                        break;
                    }
                    if (i13 >= i11) {
                        return true;
                    }
                    i12 = i13;
                }
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // ah.e
    public byte[] readByteArray(long j10) throws EOFException {
        require(j10);
        return this.f720m.readByteArray(j10);
    }

    @Override // ah.e
    public ByteString readByteString(long j10) throws EOFException {
        require(j10);
        return this.f720m.readByteString(j10);
    }

    @Override // ah.y
    public long read(c cVar, long j10) {
        zf.i.checkNotNullParameter(cVar, "sink");
        if (j10 >= 0) {
            if (true ^ this.f721n) {
                c cVar2 = this.f720m;
                if (cVar2.size() == 0 && this.f719b.read(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1L;
                }
                return cVar2.read(cVar, Math.min(j10, cVar2.size()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
    }

    @Override // ah.e
    public void readFully(c cVar, long j10) throws IOException {
        c cVar2 = this.f720m;
        zf.i.checkNotNullParameter(cVar, "sink");
        try {
            require(j10);
            cVar2.readFully(cVar, j10);
        } catch (EOFException e10) {
            cVar.writeAll(cVar2);
            throw e10;
        }
    }

    /* compiled from: RealBufferedSource.kt */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            t tVar = t.this;
            if (tVar.f721n) {
                throw new IOException("closed");
            }
            return (int) Math.min(tVar.f720m.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            t.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            t tVar = t.this;
            if (tVar.f721n) {
                throw new IOException("closed");
            }
            if (tVar.f720m.size() == 0 && tVar.f719b.read(tVar.f720m, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return tVar.f720m.readByte() & 255;
        }

        public String toString() {
            return t.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            zf.i.checkNotNullParameter(bArr, JsonStorageKeyNames.DATA_KEY);
            t tVar = t.this;
            if (!tVar.f721n) {
                d0.checkOffsetAndCount(bArr.length, i10, i11);
                if (tVar.f720m.size() == 0 && tVar.f719b.read(tVar.f720m, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return tVar.f720m.read(bArr, i10, i11);
            }
            throw new IOException("closed");
        }
    }
}
