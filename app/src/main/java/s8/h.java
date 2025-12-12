package s8;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile.java */
/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: r, reason: collision with root package name */
    public static final Logger f19139r = Logger.getLogger(h.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public final RandomAccessFile f19140b;

    /* renamed from: m, reason: collision with root package name */
    public int f19141m;

    /* renamed from: n, reason: collision with root package name */
    public int f19142n;

    /* renamed from: o, reason: collision with root package name */
    public b f19143o;

    /* renamed from: p, reason: collision with root package name */
    public b f19144p;

    /* renamed from: q, reason: collision with root package name */
    public final byte[] f19145q;

    /* compiled from: QueueFile.java */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19146a = true;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f19147b;

        public a(StringBuilder sb2) {
            this.f19147b = sb2;
        }

        @Override // s8.h.d
        public void read(InputStream inputStream, int i10) throws IOException {
            boolean z10 = this.f19146a;
            StringBuilder sb2 = this.f19147b;
            if (z10) {
                this.f19146a = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(i10);
        }
    }

    /* compiled from: QueueFile.java */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f19148c = new b(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final int f19149a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19150b;

        public b(int i10, int i11) {
            this.f19149a = i10;
            this.f19150b = i11;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.class.getSimpleName());
            sb2.append("[position = ");
            sb2.append(this.f19149a);
            sb2.append(", length = ");
            return ac.c.m(sb2, this.f19150b, "]");
        }
    }

    /* compiled from: QueueFile.java */
    public interface d {
        void read(InputStream inputStream, int i10) throws IOException;
    }

    public h(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.f19145q = bArr;
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                randomAccessFile.seek(0L);
                byte[] bArr2 = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 4; i10 < i12; i12 = 4) {
                    int i13 = iArr[i10];
                    bArr2[i11] = (byte) (i13 >> 24);
                    bArr2[i11 + 1] = (byte) (i13 >> 16);
                    bArr2[i11 + 2] = (byte) (i13 >> 8);
                    bArr2[i11 + 3] = (byte) i13;
                    i11 += 4;
                    i10++;
                }
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th2) {
                randomAccessFile.close();
                throw th2;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.f19140b = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int iC = c(0, bArr);
        this.f19141m = iC;
        if (iC > randomAccessFile2.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f19141m + ", Actual length: " + randomAccessFile2.length());
        }
        this.f19142n = c(4, bArr);
        int iC2 = c(8, bArr);
        int iC3 = c(12, bArr);
        this.f19143o = b(iC2);
        this.f19144p = b(iC3);
    }

    public static int c(int i10, byte[] bArr) {
        return ((bArr[i10] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + (bArr[i10 + 3] & 255);
    }

    public final void a(int i10) throws IOException {
        int i11 = i10 + 4;
        int iUsedBytes = this.f19141m - usedBytes();
        if (iUsedBytes >= i11) {
            return;
        }
        int i12 = this.f19141m;
        do {
            iUsedBytes += i12;
            i12 <<= 1;
        } while (iUsedBytes < i11);
        RandomAccessFile randomAccessFile = this.f19140b;
        randomAccessFile.setLength(i12);
        randomAccessFile.getChannel().force(true);
        b bVar = this.f19144p;
        int iF = f(bVar.f19149a + 4 + bVar.f19150b);
        if (iF < this.f19143o.f19149a) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.f19141m);
            long j10 = iF - 4;
            if (channel.transferTo(16L, j10, channel) != j10) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i13 = this.f19144p.f19149a;
        int i14 = this.f19143o.f19149a;
        if (i13 < i14) {
            int i15 = (this.f19141m + i13) - 16;
            g(i12, this.f19142n, i14, i15);
            this.f19144p = new b(i15, this.f19144p.f19150b);
        } else {
            g(i12, this.f19142n, i14, i13);
        }
        this.f19141m = i12;
    }

    public void add(byte[] bArr) throws IOException {
        add(bArr, 0, bArr.length);
    }

    public final b b(int i10) throws IOException {
        if (i10 == 0) {
            return b.f19148c;
        }
        RandomAccessFile randomAccessFile = this.f19140b;
        randomAccessFile.seek(i10);
        return new b(i10, randomAccessFile.readInt());
    }

    public synchronized void clear() throws IOException {
        g(4096, 0, 0, 0);
        this.f19142n = 0;
        b bVar = b.f19148c;
        this.f19143o = bVar;
        this.f19144p = bVar;
        if (this.f19141m > 4096) {
            RandomAccessFile randomAccessFile = this.f19140b;
            randomAccessFile.setLength(4096);
            randomAccessFile.getChannel().force(true);
        }
        this.f19141m = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f19140b.close();
    }

    public final void d(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iF = f(i10);
        int i13 = iF + i12;
        int i14 = this.f19141m;
        RandomAccessFile randomAccessFile = this.f19140b;
        if (i13 <= i14) {
            randomAccessFile.seek(iF);
            randomAccessFile.readFully(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iF;
        randomAccessFile.seek(iF);
        randomAccessFile.readFully(bArr, i11, i15);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, i11 + i15, i12 - i15);
    }

    public final void e(int i10, byte[] bArr, int i11, int i12) throws IOException {
        int iF = f(i10);
        int i13 = iF + i12;
        int i14 = this.f19141m;
        RandomAccessFile randomAccessFile = this.f19140b;
        if (i13 <= i14) {
            randomAccessFile.seek(iF);
            randomAccessFile.write(bArr, i11, i12);
            return;
        }
        int i15 = i14 - iF;
        randomAccessFile.seek(iF);
        randomAccessFile.write(bArr, i11, i15);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, i11 + i15, i12 - i15);
    }

    public final int f(int i10) {
        int i11 = this.f19141m;
        return i10 < i11 ? i10 : (i10 + 16) - i11;
    }

    public synchronized void forEach(d dVar) throws IOException {
        int iF = this.f19143o.f19149a;
        for (int i10 = 0; i10 < this.f19142n; i10++) {
            b bVarB = b(iF);
            dVar.read(new c(bVarB), bVarB.f19150b);
            iF = f(bVarB.f19149a + 4 + bVarB.f19150b);
        }
    }

    public final void g(int i10, int i11, int i12, int i13) throws IOException {
        int i14 = 0;
        int[] iArr = {i10, i11, i12, i13};
        int i15 = 0;
        while (true) {
            byte[] bArr = this.f19145q;
            if (i14 >= 4) {
                RandomAccessFile randomAccessFile = this.f19140b;
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                return;
            } else {
                int i16 = iArr[i14];
                bArr[i15] = (byte) (i16 >> 24);
                bArr[i15 + 1] = (byte) (i16 >> 16);
                bArr[i15 + 2] = (byte) (i16 >> 8);
                bArr[i15 + 3] = (byte) i16;
                i15 += 4;
                i14++;
            }
        }
    }

    public synchronized boolean isEmpty() {
        return this.f19142n == 0;
    }

    public synchronized void remove() throws IOException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (this.f19142n == 1) {
            clear();
        } else {
            b bVar = this.f19143o;
            int iF = f(bVar.f19149a + 4 + bVar.f19150b);
            d(iF, this.f19145q, 0, 4);
            int iC = c(0, this.f19145q);
            g(this.f19141m, this.f19142n - 1, iF, this.f19144p.f19149a);
            this.f19142n--;
            this.f19143o = new b(iF, iC);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(h.class.getSimpleName());
        sb2.append("[fileLength=");
        sb2.append(this.f19141m);
        sb2.append(", size=");
        sb2.append(this.f19142n);
        sb2.append(", first=");
        sb2.append(this.f19143o);
        sb2.append(", last=");
        sb2.append(this.f19144p);
        sb2.append(", element lengths=[");
        try {
            forEach(new a(sb2));
        } catch (IOException e10) {
            f19139r.log(Level.WARNING, "read error", (Throwable) e10);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public int usedBytes() {
        if (this.f19142n == 0) {
            return 16;
        }
        b bVar = this.f19144p;
        int i10 = bVar.f19149a;
        int i11 = this.f19143o.f19149a;
        return i10 >= i11 ? (i10 - i11) + 4 + bVar.f19150b + 16 : (((i10 + 4) + bVar.f19150b) + this.f19141m) - i11;
    }

    public synchronized void add(byte[] bArr, int i10, int i11) throws IOException {
        int iF;
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
            throw new IndexOutOfBoundsException();
        }
        a(i11);
        boolean zIsEmpty = isEmpty();
        if (zIsEmpty) {
            iF = 16;
        } else {
            b bVar = this.f19144p;
            iF = f(bVar.f19149a + 4 + bVar.f19150b);
        }
        b bVar2 = new b(iF, i11);
        byte[] bArr2 = this.f19145q;
        bArr2[0] = (byte) (i11 >> 24);
        bArr2[1] = (byte) (i11 >> 16);
        bArr2[2] = (byte) (i11 >> 8);
        bArr2[3] = (byte) i11;
        e(iF, bArr2, 0, 4);
        e(iF + 4, bArr, i10, i11);
        g(this.f19141m, this.f19142n + 1, zIsEmpty ? iF : this.f19143o.f19149a, iF);
        this.f19144p = bVar2;
        this.f19142n++;
        if (zIsEmpty) {
            this.f19143o = bVar2;
        }
    }

    /* compiled from: QueueFile.java */
    public final class c extends InputStream {

        /* renamed from: b, reason: collision with root package name */
        public int f19151b;

        /* renamed from: m, reason: collision with root package name */
        public int f19152m;

        public c(b bVar) {
            this.f19151b = h.this.f(bVar.f19149a + 4);
            this.f19152m = bVar.f19150b;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = this.f19152m;
            if (i12 <= 0) {
                return -1;
            }
            if (i11 > i12) {
                i11 = i12;
            }
            int i13 = this.f19151b;
            h hVar = h.this;
            hVar.d(i13, bArr, i10, i11);
            this.f19151b = hVar.f(this.f19151b + i11);
            this.f19152m -= i11;
            return i11;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f19152m == 0) {
                return -1;
            }
            h hVar = h.this;
            hVar.f19140b.seek(this.f19151b);
            int i10 = hVar.f19140b.read();
            this.f19151b = hVar.f(this.f19151b + 1);
            this.f19152m--;
            return i10;
        }
    }
}
