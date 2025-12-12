package ah;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: GzipSource.kt */
/* loaded from: classes2.dex */
public final class j implements y {

    /* renamed from: b, reason: collision with root package name */
    public byte f693b;

    /* renamed from: m, reason: collision with root package name */
    public final t f694m;

    /* renamed from: n, reason: collision with root package name */
    public final Inflater f695n;

    /* renamed from: o, reason: collision with root package name */
    public final k f696o;

    /* renamed from: p, reason: collision with root package name */
    public final CRC32 f697p;

    public j(y yVar) {
        zf.i.checkNotNullParameter(yVar, "source");
        t tVar = new t(yVar);
        this.f694m = tVar;
        Inflater inflater = new Inflater(true);
        this.f695n = inflater;
        this.f696o = new k((e) tVar, inflater);
        this.f697p = new CRC32();
    }

    public static void a(int i10, int i11, String str) throws IOException {
        if (i11 == i10) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
        zf.i.checkNotNullExpressionValue(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    public final void b(c cVar, long j10, long j11) {
        u uVar = cVar.f676b;
        zf.i.checkNotNull(uVar);
        while (true) {
            int i10 = uVar.f725c;
            int i11 = uVar.f724b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(uVar.f725c - r7, j11);
            this.f697p.update(uVar.f723a, (int) (uVar.f724b + j10), iMin);
            j11 -= iMin;
            uVar = uVar.f728f;
            zf.i.checkNotNull(uVar);
            j10 = 0;
        }
    }

    @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f696o.close();
    }

    @Override // ah.y
    public long read(c cVar, long j10) throws DataFormatException, IOException {
        c cVar2;
        long j11;
        zf.i.checkNotNullParameter(cVar, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        byte b10 = this.f693b;
        CRC32 crc32 = this.f697p;
        t tVar = this.f694m;
        if (b10 == 0) {
            tVar.require(10L);
            c cVar3 = tVar.f720m;
            byte b11 = cVar3.getByte(3L);
            boolean z10 = ((b11 >> 1) & 1) == 1;
            if (z10) {
                cVar2 = cVar3;
                b(tVar.f720m, 0L, 10L);
            } else {
                cVar2 = cVar3;
            }
            a(8075, tVar.readShort(), "ID1ID2");
            tVar.skip(8L);
            if (((b11 >> 2) & 1) == 1) {
                tVar.require(2L);
                if (z10) {
                    b(tVar.f720m, 0L, 2L);
                }
                long shortLe = cVar2.readShortLe();
                tVar.require(shortLe);
                if (z10) {
                    b(tVar.f720m, 0L, shortLe);
                    j11 = shortLe;
                } else {
                    j11 = shortLe;
                }
                tVar.skip(j11);
            }
            if (((b11 >> 3) & 1) == 1) {
                long jIndexOf = tVar.indexOf((byte) 0);
                if (jIndexOf == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    b(tVar.f720m, 0L, jIndexOf + 1);
                }
                tVar.skip(jIndexOf + 1);
            }
            if (((b11 >> 4) & 1) == 1) {
                long jIndexOf2 = tVar.indexOf((byte) 0);
                if (jIndexOf2 == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    b(tVar.f720m, 0L, jIndexOf2 + 1);
                }
                tVar.skip(jIndexOf2 + 1);
            }
            if (z10) {
                a(tVar.readShortLe(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            this.f693b = (byte) 1;
        }
        if (this.f693b == 1) {
            long size = cVar.size();
            long j12 = this.f696o.read(cVar, j10);
            if (j12 != -1) {
                b(cVar, size, j12);
                return j12;
            }
            this.f693b = (byte) 2;
        }
        if (this.f693b == 2) {
            a(tVar.readIntLe(), (int) crc32.getValue(), "CRC");
            a(tVar.readIntLe(), (int) this.f695n.getBytesWritten(), "ISIZE");
            this.f693b = (byte) 3;
            if (!tVar.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // ah.y
    public z timeout() {
        return this.f694m.timeout();
    }
}
