package l5;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l5.h;
import l6.l;
import l6.u;

/* compiled from: FlacReader.java */
/* loaded from: classes.dex */
public final class b extends h {

    /* renamed from: n, reason: collision with root package name */
    public l6.f f15784n;

    /* renamed from: o, reason: collision with root package name */
    public a f15785o;

    public static boolean verifyBitstreamType(l lVar) {
        return lVar.bytesLeft() >= 5 && lVar.readUnsignedByte() == 127 && lVar.readUnsignedInt() == 1179402563;
    }

    @Override // l5.h
    public long preparePayload(l lVar) {
        int i10;
        int i11;
        byte[] bArr = lVar.f15881a;
        int i12 = -1;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i13 = (bArr[2] & 255) >> 4;
        switch (i13) {
            case 1:
                i12 = 192;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                i10 = i13 - 2;
                i11 = 576;
                i12 = i11 << i10;
                break;
            case 6:
            case 7:
                lVar.skipBytes(4);
                lVar.readUtf8EncodedLong();
                int unsignedByte = i13 == 6 ? lVar.readUnsignedByte() : lVar.readUnsignedShort();
                lVar.setPosition(0);
                i12 = unsignedByte + 1;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i10 = i13 - 8;
                i11 = 256;
                i12 = i11 << i10;
                break;
        }
        return i12;
    }

    @Override // l5.h
    public boolean readHeaders(l lVar, long j10, h.a aVar) throws InterruptedException, IOException {
        byte[] bArr = lVar.f15881a;
        if (this.f15784n == null) {
            this.f15784n = new l6.f(bArr, 17);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 9, lVar.limit());
            bArrCopyOfRange[4] = -128;
            List listSingletonList = Collections.singletonList(bArrCopyOfRange);
            int iBitRate = this.f15784n.bitRate();
            l6.f fVar = this.f15784n;
            aVar.f15823a = c5.i.createAudioSampleFormat(null, "audio/flac", null, -1, iBitRate, fVar.f15855b, fVar.f15854a, listSingletonList, null, 0, null);
        } else {
            byte b10 = bArr[0];
            if ((b10 & 127) == 3) {
                a aVar2 = new a();
                this.f15785o = aVar2;
                aVar2.parseSeekTable(lVar);
            } else {
                if (b10 == -1) {
                    a aVar3 = this.f15785o;
                    if (aVar3 != null) {
                        aVar3.setFirstFrameOffset(j10);
                        aVar.f15824b = this.f15785o;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // l5.h
    public void reset(boolean z10) {
        super.reset(z10);
        if (z10) {
            this.f15784n = null;
            this.f15785o = null;
        }
    }

    /* compiled from: FlacReader.java */
    public class a implements f, g5.l {

        /* renamed from: a, reason: collision with root package name */
        public long[] f15786a;

        /* renamed from: b, reason: collision with root package name */
        public long[] f15787b;

        /* renamed from: c, reason: collision with root package name */
        public long f15788c = -1;

        /* renamed from: d, reason: collision with root package name */
        public long f15789d = -1;

        public a() {
        }

        @Override // g5.l
        public long getDurationUs() {
            return b.this.f15784n.durationUs();
        }

        @Override // g5.l
        public long getPosition(long j10) {
            return this.f15788c + this.f15787b[u.binarySearchFloor(this.f15786a, b.this.convertTimeToGranule(j10), true, true)];
        }

        @Override // g5.l
        public boolean isSeekable() {
            return true;
        }

        public void parseSeekTable(l lVar) {
            lVar.skipBytes(1);
            int unsignedInt24 = lVar.readUnsignedInt24() / 18;
            this.f15786a = new long[unsignedInt24];
            this.f15787b = new long[unsignedInt24];
            for (int i10 = 0; i10 < unsignedInt24; i10++) {
                this.f15786a[i10] = lVar.readLong();
                this.f15787b[i10] = lVar.readLong();
                lVar.skipBytes(2);
            }
        }

        @Override // l5.f
        public long read(g5.f fVar) throws InterruptedException, IOException {
            long j10 = this.f15789d;
            if (j10 < 0) {
                return -1L;
            }
            long j11 = -(j10 + 2);
            this.f15789d = -1L;
            return j11;
        }

        public void setFirstFrameOffset(long j10) {
            this.f15788c = j10;
        }

        @Override // l5.f
        public long startSeek(long j10) {
            long jConvertTimeToGranule = b.this.convertTimeToGranule(j10);
            this.f15789d = this.f15786a[u.binarySearchFloor(this.f15786a, jConvertTimeToGranule, true, true)];
            return jConvertTimeToGranule;
        }

        @Override // l5.f
        public g5.l createSeekMap() {
            return this;
        }
    }
}
