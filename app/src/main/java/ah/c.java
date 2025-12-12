package ah;

import android.support.v4.media.session.PlaybackStateCompat;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;

/* compiled from: Buffer.kt */
/* loaded from: classes2.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: b, reason: collision with root package name */
    public u f676b;

    /* renamed from: m, reason: collision with root package name */
    public long f677m;

    /* compiled from: Buffer.kt */
    public static final class a implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        public c f678b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f679m;

        /* renamed from: n, reason: collision with root package name */
        public u f680n;

        /* renamed from: p, reason: collision with root package name */
        public byte[] f682p;

        /* renamed from: o, reason: collision with root package name */
        public long f681o = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f683q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f684r = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f678b != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f678b = null;
            setSegment$okio(null);
            this.f681o = -1L;
            this.f682p = null;
            this.f683q = -1;
            this.f684r = -1;
        }

        public final u getSegment$okio() {
            return this.f680n;
        }

        public final int next() {
            long j10 = this.f681o;
            c cVar = this.f678b;
            zf.i.checkNotNull(cVar);
            if (!(j10 != cVar.size())) {
                throw new IllegalStateException("no more bytes".toString());
            }
            long j11 = this.f681o;
            return seek(j11 == -1 ? 0L : j11 + (this.f684r - this.f683q));
        }

        public final long resizeBuffer(long j10) {
            c cVar = this.f678b;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f679m) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long size = cVar.size();
            int i10 = 1;
            if (j10 <= size) {
                if (!(j10 >= 0)) {
                    throw new IllegalArgumentException(zf.i.stringPlus("newSize < 0: ", Long.valueOf(j10)).toString());
                }
                long j11 = size - j10;
                while (true) {
                    if (j11 <= 0) {
                        break;
                    }
                    u uVar = cVar.f676b;
                    zf.i.checkNotNull(uVar);
                    u uVar2 = uVar.f729g;
                    zf.i.checkNotNull(uVar2);
                    int i11 = uVar2.f725c;
                    long j12 = i11 - uVar2.f724b;
                    if (j12 > j11) {
                        uVar2.f725c = i11 - ((int) j11);
                        break;
                    }
                    cVar.f676b = uVar2.pop();
                    v.recycle(uVar2);
                    j11 -= j12;
                }
                setSegment$okio(null);
                this.f681o = j10;
                this.f682p = null;
                this.f683q = -1;
                this.f684r = -1;
            } else if (j10 > size) {
                long j13 = j10 - size;
                boolean z10 = true;
                while (j13 > 0) {
                    u uVarWritableSegment$okio = cVar.writableSegment$okio(i10);
                    int iMin = (int) Math.min(j13, 8192 - uVarWritableSegment$okio.f725c);
                    uVarWritableSegment$okio.f725c += iMin;
                    j13 -= iMin;
                    if (z10) {
                        setSegment$okio(uVarWritableSegment$okio);
                        this.f681o = size;
                        this.f682p = uVarWritableSegment$okio.f723a;
                        int i12 = uVarWritableSegment$okio.f725c;
                        this.f683q = i12 - iMin;
                        this.f684r = i12;
                        i10 = 1;
                        z10 = false;
                    } else {
                        i10 = 1;
                    }
                }
            }
            cVar.setSize$okio(j10);
            return size;
        }

        public final int seek(long j10) {
            u uVarPush;
            c cVar = this.f678b;
            if (cVar == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j10 < -1 || j10 > cVar.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j10 + " > size=" + cVar.size());
            }
            if (j10 == -1 || j10 == cVar.size()) {
                setSegment$okio(null);
                this.f681o = j10;
                this.f682p = null;
                this.f683q = -1;
                this.f684r = -1;
                return -1;
            }
            long size = cVar.size();
            u segment$okio = cVar.f676b;
            long j11 = 0;
            if (getSegment$okio() != null) {
                long j12 = this.f681o;
                int i10 = this.f683q;
                zf.i.checkNotNull(getSegment$okio());
                long j13 = j12 - (i10 - r9.f724b);
                if (j13 > j10) {
                    uVarPush = segment$okio;
                    segment$okio = getSegment$okio();
                    size = j13;
                } else {
                    uVarPush = getSegment$okio();
                    j11 = j13;
                }
            } else {
                uVarPush = segment$okio;
            }
            if (size - j10 > j10 - j11) {
                while (true) {
                    zf.i.checkNotNull(uVarPush);
                    int i11 = uVarPush.f725c;
                    int i12 = uVarPush.f724b;
                    if (j10 < (i11 - i12) + j11) {
                        break;
                    }
                    j11 += i11 - i12;
                    uVarPush = uVarPush.f728f;
                }
            } else {
                while (size > j10) {
                    zf.i.checkNotNull(segment$okio);
                    segment$okio = segment$okio.f729g;
                    zf.i.checkNotNull(segment$okio);
                    size -= segment$okio.f725c - segment$okio.f724b;
                }
                j11 = size;
                uVarPush = segment$okio;
            }
            if (this.f679m) {
                zf.i.checkNotNull(uVarPush);
                if (uVarPush.f726d) {
                    u uVarUnsharedCopy = uVarPush.unsharedCopy();
                    if (cVar.f676b == uVarPush) {
                        cVar.f676b = uVarUnsharedCopy;
                    }
                    uVarPush = uVarPush.push(uVarUnsharedCopy);
                    u uVar = uVarPush.f729g;
                    zf.i.checkNotNull(uVar);
                    uVar.pop();
                }
            }
            setSegment$okio(uVarPush);
            this.f681o = j10;
            zf.i.checkNotNull(uVarPush);
            this.f682p = uVarPush.f723a;
            int i13 = uVarPush.f724b + ((int) (j10 - j11));
            this.f683q = i13;
            int i14 = uVarPush.f725c;
            this.f684r = i14;
            return i14 - i13;
        }

        public final void setSegment$okio(u uVar) {
            this.f680n = uVar;
        }
    }

    /* compiled from: Buffer.kt */
    /* renamed from: ah.c$c, reason: collision with other inner class name */
    public static final class C0011c extends OutputStream {
        public C0011c() {
        }

        public String toString() {
            return c.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            c.this.writeByte(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            zf.i.checkNotNullParameter(bArr, JsonStorageKeyNames.DATA_KEY);
            c.this.write(bArr, i10, i11);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }
    }

    public static /* synthetic */ a readAndWriteUnsafe$default(c cVar, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = d0.getDEFAULT__new_UnsafeCursor();
        }
        return cVar.readAndWriteUnsafe(aVar);
    }

    public final void clear() throws EOFException {
        skip(size());
    }

    public final long completeSegmentByteCount() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        u uVar = this.f676b;
        zf.i.checkNotNull(uVar);
        u uVar2 = uVar.f729g;
        zf.i.checkNotNull(uVar2);
        if (uVar2.f725c < 8192 && uVar2.f727e) {
            size -= r3 - uVar2.f724b;
        }
        return size;
    }

    public final c copy() {
        c cVar = new c();
        if (size() != 0) {
            u uVar = this.f676b;
            zf.i.checkNotNull(uVar);
            u uVarSharedCopy = uVar.sharedCopy();
            cVar.f676b = uVarSharedCopy;
            uVarSharedCopy.f729g = uVarSharedCopy;
            uVarSharedCopy.f728f = uVarSharedCopy;
            for (u uVar2 = uVar.f728f; uVar2 != uVar; uVar2 = uVar2.f728f) {
                u uVar3 = uVarSharedCopy.f729g;
                zf.i.checkNotNull(uVar3);
                zf.i.checkNotNull(uVar2);
                uVar3.push(uVar2.sharedCopy());
            }
            cVar.setSize$okio(size());
        }
        return cVar;
    }

    public final c copyTo(c cVar, long j10, long j11) {
        zf.i.checkNotNullParameter(cVar, "out");
        d0.checkOffsetAndCount(size(), j10, j11);
        if (j11 != 0) {
            cVar.setSize$okio(cVar.size() + j11);
            u uVar = this.f676b;
            while (true) {
                zf.i.checkNotNull(uVar);
                int i10 = uVar.f725c;
                int i11 = uVar.f724b;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= i10 - i11;
                uVar = uVar.f728f;
            }
            while (j11 > 0) {
                zf.i.checkNotNull(uVar);
                u uVarSharedCopy = uVar.sharedCopy();
                int i12 = uVarSharedCopy.f724b + ((int) j10);
                uVarSharedCopy.f724b = i12;
                uVarSharedCopy.f725c = Math.min(i12 + ((int) j11), uVarSharedCopy.f725c);
                u uVar2 = cVar.f676b;
                if (uVar2 == null) {
                    uVarSharedCopy.f729g = uVarSharedCopy;
                    uVarSharedCopy.f728f = uVarSharedCopy;
                    cVar.f676b = uVarSharedCopy;
                } else {
                    zf.i.checkNotNull(uVar2);
                    u uVar3 = uVar2.f729g;
                    zf.i.checkNotNull(uVar3);
                    uVar3.push(uVarSharedCopy);
                }
                j11 -= uVarSharedCopy.f725c - uVarSharedCopy.f724b;
                uVar = uVar.f728f;
                j10 = 0;
            }
        }
        return this;
    }

    @Override // ah.d
    public c emit() {
        return this;
    }

    @Override // ah.d
    public c emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (size() == cVar.size()) {
                    if (size() != 0) {
                        u uVar = this.f676b;
                        zf.i.checkNotNull(uVar);
                        u uVar2 = cVar.f676b;
                        zf.i.checkNotNull(uVar2);
                        int i10 = uVar.f724b;
                        int i11 = uVar2.f724b;
                        long j10 = 0;
                        while (j10 < size()) {
                            long jMin = Math.min(uVar.f725c - i10, uVar2.f725c - i11);
                            if (0 < jMin) {
                                long j11 = 0;
                                do {
                                    j11++;
                                    int i12 = i10 + 1;
                                    byte b10 = uVar.f723a[i10];
                                    int i13 = i11 + 1;
                                    if (b10 == uVar2.f723a[i11]) {
                                        i11 = i13;
                                        i10 = i12;
                                    }
                                } while (j11 < jMin);
                            }
                            if (i10 == uVar.f725c) {
                                u uVar3 = uVar.f728f;
                                zf.i.checkNotNull(uVar3);
                                i10 = uVar3.f724b;
                                uVar = uVar3;
                            }
                            if (i11 == uVar2.f725c) {
                                uVar2 = uVar2.f728f;
                                zf.i.checkNotNull(uVar2);
                                i11 = uVar2.f724b;
                            }
                            j10 += jMin;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // ah.e
    public boolean exhausted() {
        return this.f677m == 0;
    }

    public final byte getByte(long j10) {
        d0.checkOffsetAndCount(size(), j10, 1L);
        u uVar = this.f676b;
        if (uVar == null) {
            zf.i.checkNotNull(null);
            throw null;
        }
        if (size() - j10 < j10) {
            long size = size();
            while (size > j10) {
                uVar = uVar.f729g;
                zf.i.checkNotNull(uVar);
                size -= uVar.f725c - uVar.f724b;
            }
            zf.i.checkNotNull(uVar);
            return uVar.f723a[(int) ((uVar.f724b + j10) - size)];
        }
        long j11 = 0;
        while (true) {
            long j12 = (uVar.f725c - uVar.f724b) + j11;
            if (j12 > j10) {
                zf.i.checkNotNull(uVar);
                return uVar.f723a[(int) ((uVar.f724b + j10) - j11)];
            }
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
            j11 = j12;
        }
    }

    public int hashCode() {
        u uVar = this.f676b;
        if (uVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = uVar.f725c;
            for (int i12 = uVar.f724b; i12 < i11; i12++) {
                i10 = (i10 * 31) + uVar.f723a[i12];
            }
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
        } while (uVar != this.f676b);
        return i10;
    }

    public long indexOf(ByteString byteString) throws IOException {
        zf.i.checkNotNullParameter(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override // ah.e
    public long indexOfElement(ByteString byteString) {
        zf.i.checkNotNullParameter(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // ah.e
    public InputStream inputStream() {
        return new b();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public OutputStream outputStream() {
        return new C0011c();
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
    public int read(ByteBuffer byteBuffer) throws IOException {
        zf.i.checkNotNullParameter(byteBuffer, "sink");
        u uVar = this.f676b;
        if (uVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), uVar.f725c - uVar.f724b);
        byteBuffer.put(uVar.f723a, uVar.f724b, iMin);
        int i10 = uVar.f724b + iMin;
        uVar.f724b = i10;
        this.f677m -= iMin;
        if (i10 == uVar.f725c) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        }
        return iMin;
    }

    @Override // ah.e
    public long readAll(w wVar) throws IOException {
        zf.i.checkNotNullParameter(wVar, "sink");
        long size = size();
        if (size > 0) {
            wVar.write(this, size);
        }
        return size;
    }

    public final a readAndWriteUnsafe(a aVar) {
        zf.i.checkNotNullParameter(aVar, "unsafeCursor");
        return bh.a.commonReadAndWriteUnsafe(this, aVar);
    }

    @Override // ah.e
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        u uVar = this.f676b;
        zf.i.checkNotNull(uVar);
        int i10 = uVar.f724b;
        int i11 = uVar.f725c;
        int i12 = i10 + 1;
        byte b10 = uVar.f723a[i10];
        setSize$okio(size() - 1);
        if (i12 == i11) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        } else {
            uVar.f724b = i12;
        }
        return b10;
    }

    @Override // ah.e
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // ah.e
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // ah.e
    public long readDecimalLong() throws EOFException {
        long j10 = 0;
        if (size() == 0) {
            throw new EOFException();
        }
        int i10 = 0;
        long j11 = -7;
        boolean z10 = false;
        boolean z11 = false;
        do {
            u uVar = this.f676b;
            zf.i.checkNotNull(uVar);
            byte[] bArr = uVar.f723a;
            int i11 = uVar.f724b;
            int i12 = uVar.f725c;
            while (i11 < i12) {
                byte b10 = bArr[i11];
                byte b11 = (byte) 48;
                if (b10 >= b11 && b10 <= ((byte) 57)) {
                    int i13 = b11 - b10;
                    if (j10 < -922337203685477580L || (j10 == -922337203685477580L && i13 < j11)) {
                        c cVarWriteByte = new c().writeDecimalLong(j10).writeByte((int) b10);
                        if (!z10) {
                            cVarWriteByte.readByte();
                        }
                        throw new NumberFormatException(zf.i.stringPlus("Number too large: ", cVarWriteByte.readUtf8()));
                    }
                    j10 = (j10 * 10) + i13;
                } else {
                    if (b10 != ((byte) 45) || i10 != 0) {
                        z11 = true;
                        break;
                    }
                    j11--;
                    z10 = true;
                }
                i11++;
                i10++;
            }
            if (i11 == i12) {
                this.f676b = uVar.pop();
                v.recycle(uVar);
            } else {
                uVar.f724b = i11;
            }
            if (z11) {
                break;
            }
        } while (this.f676b != null);
        setSize$okio(size() - i10);
        if (i10 >= (z10 ? 2 : 1)) {
            return z10 ? j10 : -j10;
        }
        if (size() == 0) {
            throw new EOFException();
        }
        StringBuilder sbU = ac.c.u(z10 ? "Expected a digit" : "Expected a digit or '-'", " but was 0x");
        sbU.append(d0.toHexString(getByte(0L)));
        throw new NumberFormatException(sbU.toString());
    }

    @Override // ah.e
    public void readFully(c cVar, long j10) throws EOFException {
        zf.i.checkNotNullParameter(cVar, "sink");
        if (size() >= j10) {
            cVar.write(this, j10);
        } else {
            cVar.write(this, size());
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098 A[EDGE_INSN: B:43:0x0098->B:37:0x0098 BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override // ah.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La2
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            ah.u r6 = r15.f676b
            zf.i.checkNotNull(r6)
            byte[] r7 = r6.f723a
            int r8 = r6.f724b
            int r9 = r6.f725c
        L18:
            if (r8 >= r9) goto L84
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L70
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L70
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            ah.c r0 = new ah.c
            r0.<init>()
            ah.c r0 = r0.writeHexadecimalUnsignedLong(r4)
            ah.c r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r0.readUtf8()
            java.lang.String r0 = zf.i.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L84
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r2 = ah.d0.toHexString(r10)
            java.lang.String r1 = zf.i.stringPlus(r1, r2)
            r0.<init>(r1)
            throw r0
        L84:
            if (r8 != r9) goto L90
            ah.u r7 = r6.pop()
            r15.f676b = r7
            ah.v.recycle(r6)
            goto L92
        L90:
            r6.f724b = r8
        L92:
            if (r1 != 0) goto L98
            ah.u r6 = r15.f676b
            if (r6 != 0) goto Ld
        L98:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        La2:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ah.c.readHexadecimalUnsignedLong():long");
    }

    @Override // ah.e
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        u uVar = this.f676b;
        zf.i.checkNotNull(uVar);
        int i10 = uVar.f724b;
        int i11 = uVar.f725c;
        if (i11 - i10 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        int i12 = i10 + 1;
        byte[] bArr = uVar.f723a;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = i16 | (bArr[i15] & 255);
        setSize$okio(size() - 4);
        if (i17 == i11) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        } else {
            uVar.f724b = i17;
        }
        return i18;
    }

    public int readIntLe() throws EOFException {
        return d0.reverseBytes(readInt());
    }

    @Override // ah.e
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        u uVar = this.f676b;
        zf.i.checkNotNull(uVar);
        int i10 = uVar.f724b;
        int i11 = uVar.f725c;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = uVar.f723a;
        long j10 = (bArr[i10] & 255) << 56;
        long j11 = j10 | ((bArr[r5] & 255) << 48);
        long j12 = j11 | ((bArr[r1] & 255) << 40);
        long j13 = j12 | ((bArr[r5] & 255) << 32);
        long j14 = j13 | ((bArr[r1] & 255) << 24);
        long j15 = j14 | ((bArr[r5] & 255) << 16);
        long j16 = j15 | ((bArr[r1] & 255) << 8);
        int i12 = i10 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j17 = (bArr[r5] & 255) | j16;
        setSize$okio(size() - 8);
        if (i12 == i11) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        } else {
            uVar.f724b = i12;
        }
        return j17;
    }

    @Override // ah.e
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        u uVar = this.f676b;
        zf.i.checkNotNull(uVar);
        int i10 = uVar.f724b;
        int i11 = uVar.f725c;
        if (i11 - i10 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        int i12 = i10 + 1;
        byte[] bArr = uVar.f723a;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        setSize$okio(size() - 2);
        if (i13 == i11) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        } else {
            uVar.f724b = i13;
        }
        return (short) i14;
    }

    public short readShortLe() throws EOFException {
        return d0.reverseBytes(readShort());
    }

    @Override // ah.e
    public String readString(Charset charset) {
        zf.i.checkNotNullParameter(charset, "charset");
        return readString(this.f677m, charset);
    }

    public String readUtf8() {
        return readString(this.f677m, ig.c.f13440b);
    }

    public int readUtf8CodePoint() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (size() == 0) {
            throw new EOFException();
        }
        byte b10 = getByte(0L);
        boolean z10 = false;
        if ((b10 & 128) == 0) {
            i10 = b10 & 127;
            i11 = 1;
            i12 = 0;
        } else if ((b10 & 224) == 192) {
            i10 = b10 & 31;
            i11 = 2;
            i12 = 128;
        } else if ((b10 & 240) == 224) {
            i10 = b10 & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((b10 & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i10 = b10 & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (size() < j10) {
            StringBuilder sbS = ac.c.s("size < ", i11, ": ");
            sbS.append(size());
            sbS.append(" (to read code point prefixed 0x");
            sbS.append(d0.toHexString(b10));
            sbS.append(')');
            throw new EOFException(sbS.toString());
        }
        if (1 < i11) {
            int i13 = 1;
            while (true) {
                int i14 = i13 + 1;
                long j11 = i13;
                byte b11 = getByte(j11);
                if ((b11 & 192) != 128) {
                    skip(j11);
                    return 65533;
                }
                i10 = (i10 << 6) | (b11 & 63);
                if (i14 >= i11) {
                    break;
                }
                i13 = i14;
            }
        }
        skip(j10);
        if (i10 > 1114111) {
            return 65533;
        }
        if (55296 <= i10 && i10 <= 57343) {
            z10 = true;
        }
        if (!z10 && i10 >= i12) {
            return i10;
        }
        return 65533;
    }

    @Override // ah.e
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // ah.e
    public boolean request(long j10) {
        return this.f677m >= j10;
    }

    @Override // ah.e
    public void require(long j10) throws EOFException {
        if (this.f677m < j10) {
            throw new EOFException();
        }
    }

    @Override // ah.e
    public int select(p pVar) throws EOFException {
        zf.i.checkNotNullParameter(pVar, "options");
        int iSelectPrefix$default = bh.a.selectPrefix$default(this, pVar, false, 2, null);
        if (iSelectPrefix$default == -1) {
            return -1;
        }
        skip(pVar.getByteStrings$okio()[iSelectPrefix$default].size());
        return iSelectPrefix$default;
    }

    public final void setSize$okio(long j10) {
        this.f677m = j10;
    }

    public final long size() {
        return this.f677m;
    }

    @Override // ah.e
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            u uVar = this.f676b;
            if (uVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, uVar.f725c - uVar.f724b);
            long j11 = iMin;
            setSize$okio(size() - j11);
            j10 -= j11;
            int i10 = uVar.f724b + iMin;
            uVar.f724b = i10;
            if (i10 == uVar.f725c) {
                this.f676b = uVar.pop();
                v.recycle(uVar);
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(zf.i.stringPlus("size > Int.MAX_VALUE: ", Long.valueOf(size())).toString());
    }

    @Override // ah.y
    public z timeout() {
        return z.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final u writableSegment$okio(int i10) {
        if (!(i10 >= 1 && i10 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        u uVar = this.f676b;
        if (uVar != null) {
            zf.i.checkNotNull(uVar);
            u uVar2 = uVar.f729g;
            zf.i.checkNotNull(uVar2);
            return (uVar2.f725c + i10 > 8192 || !uVar2.f727e) ? uVar2.push(v.take()) : uVar2;
        }
        u uVarTake = v.take();
        this.f676b = uVarTake;
        uVarTake.f729g = uVarTake;
        uVarTake.f728f = uVarTake;
        return uVarTake;
    }

    @Override // ah.d
    public long writeAll(y yVar) throws IOException {
        zf.i.checkNotNullParameter(yVar, "source");
        long j10 = 0;
        while (true) {
            long j11 = yVar.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    public c writeLong(long j10) {
        u uVarWritableSegment$okio = writableSegment$okio(8);
        byte[] bArr = uVarWritableSegment$okio.f723a;
        int i10 = uVarWritableSegment$okio.f725c;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j10 >>> 48) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j10 >>> 40) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j10 >>> 32) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((j10 >>> 24) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((j10 >>> 16) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j10 >>> 8) & 255);
        bArr[i17] = (byte) (j10 & 255);
        uVarWritableSegment$okio.f725c = i17 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    public c writeString(String str, Charset charset) {
        zf.i.checkNotNullParameter(str, "string");
        zf.i.checkNotNullParameter(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    public c writeUtf8CodePoint(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            u uVarWritableSegment$okio = writableSegment$okio(2);
            byte[] bArr = uVarWritableSegment$okio.f723a;
            int i11 = uVarWritableSegment$okio.f725c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            uVarWritableSegment$okio.f725c = i11 + 2;
            setSize$okio(size() + 2);
        } else {
            boolean z10 = false;
            if (55296 <= i10 && i10 <= 57343) {
                z10 = true;
            }
            if (z10) {
                writeByte(63);
            } else if (i10 < 65536) {
                u uVarWritableSegment$okio2 = writableSegment$okio(3);
                byte[] bArr2 = uVarWritableSegment$okio2.f723a;
                int i12 = uVarWritableSegment$okio2.f725c;
                bArr2[i12] = (byte) ((i10 >> 12) | 224);
                bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
                uVarWritableSegment$okio2.f725c = i12 + 3;
                setSize$okio(size() + 3);
            } else {
                if (i10 > 1114111) {
                    throw new IllegalArgumentException(zf.i.stringPlus("Unexpected code point: 0x", d0.toHexString(i10)));
                }
                u uVarWritableSegment$okio3 = writableSegment$okio(4);
                byte[] bArr3 = uVarWritableSegment$okio3.f723a;
                int i13 = uVarWritableSegment$okio3.f725c;
                bArr3[i13] = (byte) ((i10 >> 18) | 240);
                bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
                uVarWritableSegment$okio3.f725c = i13 + 4;
                setSize$okio(size() + 4);
            }
        }
        return this;
    }

    /* compiled from: Buffer.kt */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.size() > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            zf.i.checkNotNullParameter(bArr, "sink");
            return c.this.read(bArr, i10, i11);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c m0clone() {
        return copy();
    }

    public long indexOf(byte b10, long j10, long j11) {
        u uVar;
        int i10;
        long j12 = j10;
        long size = j11;
        boolean z10 = false;
        long size2 = 0;
        if (0 <= j12 && j12 <= size) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j12 + " toIndex=" + size).toString());
        }
        if (size > size()) {
            size = size();
        }
        long j13 = size;
        if (j12 == j13 || (uVar = this.f676b) == null) {
            return -1L;
        }
        if (size() - j12 < j12) {
            size2 = size();
            while (size2 > j12) {
                uVar = uVar.f729g;
                zf.i.checkNotNull(uVar);
                size2 -= uVar.f725c - uVar.f724b;
            }
            while (size2 < j13) {
                byte[] bArr = uVar.f723a;
                int iMin = (int) Math.min(uVar.f725c, (uVar.f724b + j13) - size2);
                i10 = (int) ((uVar.f724b + j12) - size2);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                size2 += uVar.f725c - uVar.f724b;
                uVar = uVar.f728f;
                zf.i.checkNotNull(uVar);
                j12 = size2;
            }
            return -1L;
        }
        while (true) {
            long j14 = (uVar.f725c - uVar.f724b) + size2;
            if (j14 > j12) {
                break;
            }
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
            size2 = j14;
        }
        while (size2 < j13) {
            byte[] bArr2 = uVar.f723a;
            int iMin2 = (int) Math.min(uVar.f725c, (uVar.f724b + j13) - size2);
            i10 = (int) ((uVar.f724b + j12) - size2);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            size2 += uVar.f725c - uVar.f724b;
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
            j12 = size2;
        }
        return -1L;
        return (i10 - uVar.f724b) + size2;
    }

    public long indexOfElement(ByteString byteString, long j10) {
        int i10;
        int i11;
        zf.i.checkNotNullParameter(byteString, "targetBytes");
        long size = 0;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("fromIndex < 0: ", Long.valueOf(j10)).toString());
        }
        u uVar = this.f676b;
        if (uVar == null) {
            return -1L;
        }
        if (size() - j10 < j10) {
            size = size();
            while (size > j10) {
                uVar = uVar.f729g;
                zf.i.checkNotNull(uVar);
                size -= uVar.f725c - uVar.f724b;
            }
            if (byteString.size() == 2) {
                byte b10 = byteString.getByte(0);
                byte b11 = byteString.getByte(1);
                while (size < size()) {
                    byte[] bArr = uVar.f723a;
                    i10 = (int) ((uVar.f724b + j10) - size);
                    int i12 = uVar.f725c;
                    while (i10 < i12) {
                        byte b12 = bArr[i10];
                        if (b12 == b10 || b12 == b11) {
                            i11 = uVar.f724b;
                        } else {
                            i10++;
                        }
                    }
                    size += uVar.f725c - uVar.f724b;
                    uVar = uVar.f728f;
                    zf.i.checkNotNull(uVar);
                    j10 = size;
                }
                return -1L;
            }
            byte[] bArrInternalArray$okio = byteString.internalArray$okio();
            while (size < size()) {
                byte[] bArr2 = uVar.f723a;
                i10 = (int) ((uVar.f724b + j10) - size);
                int i13 = uVar.f725c;
                while (i10 < i13) {
                    byte b13 = bArr2[i10];
                    int length = bArrInternalArray$okio.length;
                    int i14 = 0;
                    while (i14 < length) {
                        byte b14 = bArrInternalArray$okio[i14];
                        i14++;
                        if (b13 == b14) {
                            i11 = uVar.f724b;
                        }
                    }
                    i10++;
                }
                size += uVar.f725c - uVar.f724b;
                uVar = uVar.f728f;
                zf.i.checkNotNull(uVar);
                j10 = size;
            }
            return -1L;
        }
        while (true) {
            long j11 = (uVar.f725c - uVar.f724b) + size;
            if (j11 > j10) {
                break;
            }
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
            size = j11;
        }
        if (byteString.size() == 2) {
            byte b15 = byteString.getByte(0);
            byte b16 = byteString.getByte(1);
            while (size < size()) {
                byte[] bArr3 = uVar.f723a;
                i10 = (int) ((uVar.f724b + j10) - size);
                int i15 = uVar.f725c;
                while (i10 < i15) {
                    byte b17 = bArr3[i10];
                    if (b17 == b15 || b17 == b16) {
                        i11 = uVar.f724b;
                    } else {
                        i10++;
                    }
                }
                size += uVar.f725c - uVar.f724b;
                uVar = uVar.f728f;
                zf.i.checkNotNull(uVar);
                j10 = size;
            }
            return -1L;
        }
        byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
        while (size < size()) {
            byte[] bArr4 = uVar.f723a;
            i10 = (int) ((uVar.f724b + j10) - size);
            int i16 = uVar.f725c;
            while (i10 < i16) {
                byte b18 = bArr4[i10];
                int length2 = bArrInternalArray$okio2.length;
                int i17 = 0;
                while (i17 < length2) {
                    byte b19 = bArrInternalArray$okio2[i17];
                    i17++;
                    if (b18 == b19) {
                        i11 = uVar.f724b;
                    }
                }
                i10++;
            }
            size += uVar.f725c - uVar.f724b;
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
            j10 = size;
        }
        return -1L;
        return (i10 - i11) + size;
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        zf.i.checkNotNullParameter(byteString, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || size() - j10 < i11 || byteString.size() - i10 < i11) {
            return false;
        }
        if (i11 > 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (getByte(i12 + j10) != byteString.getByte(i12 + i10)) {
                    return false;
                }
                if (i13 >= i11) {
                    break;
                }
                i12 = i13;
            }
        }
        return true;
    }

    @Override // ah.e
    public byte[] readByteArray(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    @Override // ah.e
    public ByteString readByteString(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (size() < j10) {
            throw new EOFException();
        }
        if (j10 < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new ByteString(readByteArray(j10));
        }
        ByteString byteStringSnapshot = snapshot((int) j10);
        skip(j10);
        return byteStringSnapshot;
    }

    public String readString(long j10, Charset charset) throws EOFException {
        zf.i.checkNotNullParameter(charset, "charset");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (this.f677m < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        u uVar = this.f676b;
        zf.i.checkNotNull(uVar);
        int i10 = uVar.f724b;
        if (i10 + j10 > uVar.f725c) {
            return new String(readByteArray(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(uVar.f723a, i10, i11, charset);
        int i12 = uVar.f724b + i11;
        uVar.f724b = i12;
        this.f677m -= j10;
        if (i12 == uVar.f725c) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        }
        return str;
    }

    public String readUtf8(long j10) throws EOFException {
        return readString(j10, ig.c.f13440b);
    }

    @Override // ah.e
    public String readUtf8LineStrict(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("limit < 0: ", Long.valueOf(j10)).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        byte b10 = (byte) 10;
        long jIndexOf = indexOf(b10, 0L, j11);
        if (jIndexOf != -1) {
            return bh.a.readUtf8Line(this, jIndexOf);
        }
        if (j11 < size() && getByte(j11 - 1) == ((byte) 13) && getByte(j11) == b10) {
            return bh.a.readUtf8Line(this, j11);
        }
        c cVar = new c();
        copyTo(cVar, 0L, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + cVar.readByteString().hex() + (char) 8230);
    }

    @Override // ah.d
    public c writeByte(int i10) {
        u uVarWritableSegment$okio = writableSegment$okio(1);
        byte[] bArr = uVarWritableSegment$okio.f723a;
        int i11 = uVarWritableSegment$okio.f725c;
        uVarWritableSegment$okio.f725c = i11 + 1;
        bArr[i11] = (byte) i10;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // ah.d
    public c writeDecimalLong(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        u uVarWritableSegment$okio = writableSegment$okio(i10);
        byte[] bArr = uVarWritableSegment$okio.f723a;
        int i11 = uVarWritableSegment$okio.f725c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = bh.a.getHEX_DIGIT_BYTES()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = (byte) 45;
        }
        uVarWritableSegment$okio.f725c += i10;
        setSize$okio(size() + i10);
        return this;
    }

    @Override // ah.d
    public c writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        u uVarWritableSegment$okio = writableSegment$okio(i10);
        byte[] bArr = uVarWritableSegment$okio.f723a;
        int i11 = uVarWritableSegment$okio.f725c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = bh.a.getHEX_DIGIT_BYTES()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        uVarWritableSegment$okio.f725c += i10;
        setSize$okio(size() + i10);
        return this;
    }

    @Override // ah.d
    public c writeInt(int i10) {
        u uVarWritableSegment$okio = writableSegment$okio(4);
        byte[] bArr = uVarWritableSegment$okio.f723a;
        int i11 = uVarWritableSegment$okio.f725c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        uVarWritableSegment$okio.f725c = i14 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // ah.d
    public c writeShort(int i10) {
        u uVarWritableSegment$okio = writableSegment$okio(2);
        byte[] bArr = uVarWritableSegment$okio.f723a;
        int i11 = uVarWritableSegment$okio.f725c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        uVarWritableSegment$okio.f725c = i12 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    public c writeString(String str, int i10, int i11, Charset charset) {
        zf.i.checkNotNullParameter(str, "string");
        zf.i.checkNotNullParameter(charset, "charset");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (i11 >= i10) {
            if (i11 <= str.length()) {
                if (zf.i.areEqual(charset, ig.c.f13440b)) {
                    return writeUtf8(str, i10, i11);
                }
                String strSubstring = str.substring(i10, i11);
                zf.i.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (strSubstring != null) {
                    byte[] bytes = strSubstring.getBytes(charset);
                    zf.i.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            StringBuilder sbS = ac.c.s("endIndex > string.length: ", i11, " > ");
            sbS.append(str.length());
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        throw new IllegalArgumentException(ac.c.g("endIndex < beginIndex: ", i11, " < ", i10).toString());
    }

    @Override // ah.d
    public c writeUtf8(String str) {
        zf.i.checkNotNullParameter(str, "string");
        return writeUtf8(str, 0, str.length());
    }

    public final ByteString snapshot(int i10) {
        if (i10 == 0) {
            return ByteString.f17102p;
        }
        d0.checkOffsetAndCount(size(), 0L, i10);
        u uVar = this.f676b;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            zf.i.checkNotNull(uVar);
            int i14 = uVar.f725c;
            int i15 = uVar.f724b;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                uVar = uVar.f728f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        u uVar2 = this.f676b;
        int i16 = 0;
        while (i11 < i10) {
            zf.i.checkNotNull(uVar2);
            bArr[i16] = uVar2.f723a;
            i11 += uVar2.f725c - uVar2.f724b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = uVar2.f724b;
            uVar2.f726d = true;
            i16++;
            uVar2 = uVar2.f728f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        zf.i.checkNotNullParameter(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            u uVarWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i10, 8192 - uVarWritableSegment$okio.f725c);
            byteBuffer.get(uVarWritableSegment$okio.f723a, uVarWritableSegment$okio.f725c, iMin);
            i10 -= iMin;
            uVarWritableSegment$okio.f725c += iMin;
        }
        this.f677m += iRemaining;
        return iRemaining;
    }

    @Override // ah.d
    public c writeUtf8(String str, int i10, int i11) {
        char cCharAt;
        zf.i.checkNotNullParameter(str, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (i11 >= i10) {
            if (!(i11 <= str.length())) {
                StringBuilder sbS = ac.c.s("endIndex > string.length: ", i11, " > ");
                sbS.append(str.length());
                throw new IllegalArgumentException(sbS.toString().toString());
            }
            while (i10 < i11) {
                char cCharAt2 = str.charAt(i10);
                if (cCharAt2 < 128) {
                    u uVarWritableSegment$okio = writableSegment$okio(1);
                    byte[] bArr = uVarWritableSegment$okio.f723a;
                    int i12 = uVarWritableSegment$okio.f725c - i10;
                    int iMin = Math.min(i11, 8192 - i12);
                    int i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt2;
                    while (true) {
                        i10 = i13;
                        if (i10 >= iMin || (cCharAt = str.charAt(i10)) >= 128) {
                            break;
                        }
                        i13 = i10 + 1;
                        bArr[i10 + i12] = (byte) cCharAt;
                    }
                    int i14 = uVarWritableSegment$okio.f725c;
                    int i15 = (i12 + i10) - i14;
                    uVarWritableSegment$okio.f725c = i14 + i15;
                    setSize$okio(size() + i15);
                } else {
                    if (cCharAt2 < 2048) {
                        u uVarWritableSegment$okio2 = writableSegment$okio(2);
                        byte[] bArr2 = uVarWritableSegment$okio2.f723a;
                        int i16 = uVarWritableSegment$okio2.f725c;
                        bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                        bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                        uVarWritableSegment$okio2.f725c = i16 + 2;
                        setSize$okio(size() + 2);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i17 = i10 + 1;
                        char cCharAt3 = i17 < i11 ? str.charAt(i17) : (char) 0;
                        if (cCharAt2 <= 56319) {
                            if (56320 <= cCharAt3 && cCharAt3 <= 57343) {
                                int i18 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                                u uVarWritableSegment$okio3 = writableSegment$okio(4);
                                byte[] bArr3 = uVarWritableSegment$okio3.f723a;
                                int i19 = uVarWritableSegment$okio3.f725c;
                                bArr3[i19] = (byte) ((i18 >> 18) | 240);
                                bArr3[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                                bArr3[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                                bArr3[i19 + 3] = (byte) ((i18 & 63) | 128);
                                uVarWritableSegment$okio3.f725c = i19 + 4;
                                setSize$okio(size() + 4);
                                i10 += 2;
                            }
                        }
                        writeByte(63);
                        i10 = i17;
                    } else {
                        u uVarWritableSegment$okio4 = writableSegment$okio(3);
                        byte[] bArr4 = uVarWritableSegment$okio4.f723a;
                        int i20 = uVarWritableSegment$okio4.f725c;
                        bArr4[i20] = (byte) ((cCharAt2 >> '\f') | 224);
                        bArr4[i20 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                        bArr4[i20 + 2] = (byte) ((cCharAt2 & '?') | 128);
                        uVarWritableSegment$okio4.f725c = i20 + 3;
                        setSize$okio(size() + 3);
                    }
                    i10++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(ac.c.g("endIndex < beginIndex: ", i11, " < ", i10).toString());
    }

    @Override // ah.e
    public void readFully(byte[] bArr) throws EOFException {
        zf.i.checkNotNullParameter(bArr, "sink");
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = read(bArr, i10, bArr.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    public int read(byte[] bArr, int i10, int i11) {
        zf.i.checkNotNullParameter(bArr, "sink");
        d0.checkOffsetAndCount(bArr.length, i10, i11);
        u uVar = this.f676b;
        if (uVar == null) {
            return -1;
        }
        int iMin = Math.min(i11, uVar.f725c - uVar.f724b);
        int i12 = uVar.f724b;
        mf.h.copyInto(uVar.f723a, bArr, i10, i12, i12 + iMin);
        uVar.f724b += iMin;
        setSize$okio(size() - iMin);
        if (uVar.f724b == uVar.f725c) {
            this.f676b = uVar.pop();
            v.recycle(uVar);
        }
        return iMin;
    }

    @Override // ah.d
    public c write(ByteString byteString) {
        zf.i.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // ah.d
    public c write(byte[] bArr) {
        zf.i.checkNotNullParameter(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // ah.d
    public c write(byte[] bArr, int i10, int i11) {
        zf.i.checkNotNullParameter(bArr, "source");
        long j10 = i11;
        d0.checkOffsetAndCount(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            u uVarWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i12 - i10, 8192 - uVarWritableSegment$okio.f725c);
            int i13 = i10 + iMin;
            mf.h.copyInto(bArr, uVarWritableSegment$okio.f723a, uVarWritableSegment$okio.f725c, i10, i13);
            uVarWritableSegment$okio.f725c += iMin;
            i10 = i13;
        }
        setSize$okio(size() + j10);
        return this;
    }

    @Override // ah.y
    public long read(c cVar, long j10) {
        zf.i.checkNotNullParameter(cVar, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (size() == 0) {
            return -1L;
        }
        if (j10 > size()) {
            j10 = size();
        }
        cVar.write(this, j10);
        return j10;
    }

    public c write(y yVar, long j10) throws IOException {
        zf.i.checkNotNullParameter(yVar, "source");
        while (j10 > 0) {
            long j11 = yVar.read(this, j10);
            if (j11 == -1) {
                throw new EOFException();
            }
            j10 -= j11;
        }
        return this;
    }

    @Override // ah.w
    public void write(c cVar, long j10) {
        u uVar;
        zf.i.checkNotNullParameter(cVar, "source");
        if (cVar != this) {
            d0.checkOffsetAndCount(cVar.size(), 0L, j10);
            while (j10 > 0) {
                u uVar2 = cVar.f676b;
                zf.i.checkNotNull(uVar2);
                int i10 = uVar2.f725c;
                zf.i.checkNotNull(cVar.f676b);
                if (j10 < i10 - r2.f724b) {
                    u uVar3 = this.f676b;
                    if (uVar3 != null) {
                        zf.i.checkNotNull(uVar3);
                        uVar = uVar3.f729g;
                    } else {
                        uVar = null;
                    }
                    if (uVar != null && uVar.f727e) {
                        if ((uVar.f725c + j10) - (uVar.f726d ? 0 : uVar.f724b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            u uVar4 = cVar.f676b;
                            zf.i.checkNotNull(uVar4);
                            uVar4.writeTo(uVar, (int) j10);
                            cVar.setSize$okio(cVar.size() - j10);
                            setSize$okio(size() + j10);
                            return;
                        }
                    }
                    u uVar5 = cVar.f676b;
                    zf.i.checkNotNull(uVar5);
                    cVar.f676b = uVar5.split((int) j10);
                }
                u uVar6 = cVar.f676b;
                zf.i.checkNotNull(uVar6);
                long j11 = uVar6.f725c - uVar6.f724b;
                cVar.f676b = uVar6.pop();
                u uVar7 = this.f676b;
                if (uVar7 == null) {
                    this.f676b = uVar6;
                    uVar6.f729g = uVar6;
                    uVar6.f728f = uVar6;
                } else {
                    zf.i.checkNotNull(uVar7);
                    u uVar8 = uVar7.f729g;
                    zf.i.checkNotNull(uVar8);
                    uVar8.push(uVar6).compact();
                }
                cVar.setSize$okio(cVar.size() - j11);
                setSize$okio(size() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public long indexOf(ByteString byteString, long j10) throws IOException {
        zf.i.checkNotNullParameter(byteString, "bytes");
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j11 = 0;
        if (j10 >= 0) {
            u uVar = this.f676b;
            if (uVar != null) {
                if (size() - j10 < j10) {
                    long size = size();
                    while (size > j10) {
                        uVar = uVar.f729g;
                        zf.i.checkNotNull(uVar);
                        size -= uVar.f725c - uVar.f724b;
                    }
                    byte[] bArrInternalArray$okio = byteString.internalArray$okio();
                    byte b10 = bArrInternalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (size() - size2) + 1;
                    u uVar2 = uVar;
                    long j12 = size;
                    long j13 = j10;
                    while (j12 < size3) {
                        byte[] bArr = uVar2.f723a;
                        long j14 = j13;
                        int iMin = (int) Math.min(uVar2.f725c, (uVar2.f724b + size3) - j12);
                        int i10 = (int) ((uVar2.f724b + j14) - j12);
                        if (i10 < iMin) {
                            while (true) {
                                int i11 = i10 + 1;
                                if (bArr[i10] == b10 && bh.a.rangeEquals(uVar2, i11, bArrInternalArray$okio, 1, size2)) {
                                    return (i10 - uVar2.f724b) + j12;
                                }
                                if (i11 >= iMin) {
                                    break;
                                }
                                i10 = i11;
                            }
                        }
                        j12 += uVar2.f725c - uVar2.f724b;
                        uVar2 = uVar2.f728f;
                        zf.i.checkNotNull(uVar2);
                        j13 = j12;
                    }
                } else {
                    while (true) {
                        long j15 = (uVar.f725c - uVar.f724b) + j11;
                        if (j15 > j10) {
                            break;
                        }
                        uVar = uVar.f728f;
                        zf.i.checkNotNull(uVar);
                        j11 = j15;
                    }
                    byte[] bArrInternalArray$okio2 = byteString.internalArray$okio();
                    byte b11 = bArrInternalArray$okio2[0];
                    int size4 = byteString.size();
                    long size5 = (size() - size4) + 1;
                    long j16 = j11;
                    long j17 = j10;
                    while (j16 < size5) {
                        byte[] bArr2 = uVar.f723a;
                        long j18 = size5;
                        int iMin2 = (int) Math.min(uVar.f725c, (uVar.f724b + size5) - j16);
                        int i12 = (int) ((uVar.f724b + j17) - j16);
                        if (i12 < iMin2) {
                            while (true) {
                                int i13 = i12 + 1;
                                if (bArr2[i12] == b11 && bh.a.rangeEquals(uVar, i13, bArrInternalArray$okio2, 1, size4)) {
                                    return (i12 - uVar.f724b) + j16;
                                }
                                if (i13 >= iMin2) {
                                    break;
                                }
                                i12 = i13;
                            }
                        }
                        j16 += uVar.f725c - uVar.f724b;
                        uVar = uVar.f728f;
                        zf.i.checkNotNull(uVar);
                        j17 = j16;
                        size5 = j18;
                    }
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(zf.i.stringPlus("fromIndex < 0: ", Long.valueOf(j10)).toString());
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // ah.d, ah.w, java.io.Flushable
    public void flush() {
    }

    @Override // ah.e, ah.d
    public c getBuffer() {
        return this;
    }
}
