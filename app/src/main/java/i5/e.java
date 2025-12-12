package i5;

import java.io.IOException;
import l6.l;

/* compiled from: Sniffer.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final l f13206a = new l(8);

    /* renamed from: b, reason: collision with root package name */
    public int f13207b;

    public final long a(g5.f fVar) throws InterruptedException, IOException {
        l lVar = this.f13206a;
        g5.b bVar = (g5.b) fVar;
        int i10 = 0;
        bVar.peekFully(lVar.f15881a, 0, 1);
        int i11 = lVar.f15881a[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (~i12);
        bVar.peekFully(lVar.f15881a, 1, i13);
        while (i10 < i13) {
            i10++;
            i14 = (lVar.f15881a[i10] & 255) + (i14 << 8);
        }
        this.f13207b = i13 + 1 + this.f13207b;
        return i14;
    }

    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        g5.b bVar = (g5.b) fVar;
        long length = bVar.getLength();
        long j10 = 1024;
        if (length != -1 && length <= 1024) {
            j10 = length;
        }
        int i10 = (int) j10;
        l lVar = this.f13206a;
        bVar.peekFully(lVar.f15881a, 0, 4);
        this.f13207b = 4;
        for (long unsignedInt = lVar.readUnsignedInt(); unsignedInt != 440786851; unsignedInt = ((unsignedInt << 8) & (-256)) | (lVar.f15881a[0] & 255)) {
            int i11 = this.f13207b + 1;
            this.f13207b = i11;
            if (i11 == i10) {
                return false;
            }
            bVar.peekFully(lVar.f15881a, 0, 1);
        }
        long jA = a(bVar);
        long j11 = this.f13207b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j11 + jA >= length) {
            return false;
        }
        while (true) {
            int i12 = this.f13207b;
            long j12 = j11 + jA;
            if (i12 >= j12) {
                return ((long) i12) == j12;
            }
            if (a(bVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(bVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                break;
            }
            if (jA2 != 0) {
                bVar.advancePeekPosition((int) jA2);
                this.f13207b = (int) (this.f13207b + jA2);
            }
        }
        return false;
    }
}
