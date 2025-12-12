package n5;

import n5.v;

/* compiled from: DtsReader.java */
/* loaded from: classes.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l6.l f16529a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16530b;

    /* renamed from: c, reason: collision with root package name */
    public String f16531c;

    /* renamed from: d, reason: collision with root package name */
    public g5.m f16532d;

    /* renamed from: e, reason: collision with root package name */
    public int f16533e;

    /* renamed from: f, reason: collision with root package name */
    public int f16534f;

    /* renamed from: g, reason: collision with root package name */
    public int f16535g;

    /* renamed from: h, reason: collision with root package name */
    public long f16536h;

    /* renamed from: i, reason: collision with root package name */
    public c5.i f16537i;

    /* renamed from: j, reason: collision with root package name */
    public int f16538j;

    /* renamed from: k, reason: collision with root package name */
    public long f16539k;

    public f(String str) {
        l6.l lVar = new l6.l(new byte[15]);
        this.f16529a = lVar;
        byte[] bArr = lVar.f15881a;
        bArr[0] = 127;
        bArr[1] = -2;
        bArr[2] = -128;
        bArr[3] = 1;
        this.f16533e = 0;
        this.f16530b = str;
    }

    @Override // n5.h
    public void consume(l6.l lVar) {
        while (lVar.bytesLeft() > 0) {
            int i10 = this.f16533e;
            boolean z10 = false;
            if (i10 == 0) {
                while (true) {
                    if (lVar.bytesLeft() <= 0) {
                        break;
                    }
                    int i11 = this.f16535g << 8;
                    this.f16535g = i11;
                    int unsignedByte = i11 | lVar.readUnsignedByte();
                    this.f16535g = unsignedByte;
                    if (unsignedByte == 2147385345) {
                        this.f16535g = 0;
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    this.f16534f = 4;
                    this.f16533e = 1;
                }
            } else if (i10 == 1) {
                l6.l lVar2 = this.f16529a;
                byte[] bArr = lVar2.f15881a;
                int iMin = Math.min(lVar.bytesLeft(), 15 - this.f16534f);
                lVar.readBytes(bArr, this.f16534f, iMin);
                int i12 = this.f16534f + iMin;
                this.f16534f = i12;
                if (i12 == 15) {
                    byte[] bArr2 = lVar2.f15881a;
                    if (this.f16537i == null) {
                        c5.i dtsFormat = d5.d.parseDtsFormat(bArr2, this.f16531c, this.f16530b, null);
                        this.f16537i = dtsFormat;
                        this.f16532d.format(dtsFormat);
                    }
                    this.f16538j = d5.d.getDtsFrameSize(bArr2);
                    this.f16536h = (int) ((d5.d.parseDtsAudioSampleCount(bArr2) * 1000000) / this.f16537i.D);
                    lVar2.setPosition(0);
                    this.f16532d.sampleData(lVar2, 15);
                    this.f16533e = 2;
                }
            } else if (i10 == 2) {
                int iMin2 = Math.min(lVar.bytesLeft(), this.f16538j - this.f16534f);
                this.f16532d.sampleData(lVar, iMin2);
                int i13 = this.f16534f + iMin2;
                this.f16534f = i13;
                int i14 = this.f16538j;
                if (i13 == i14) {
                    this.f16532d.sampleMetadata(this.f16539k, 1, i14, 0, null);
                    this.f16539k += this.f16536h;
                    this.f16533e = 0;
                }
            }
        }
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16531c = dVar.getFormatId();
        this.f16532d = gVar.track(dVar.getTrackId(), 1);
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16539k = j10;
    }

    @Override // n5.h
    public void seek() {
        this.f16533e = 0;
        this.f16534f = 0;
        this.f16535g = 0;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
