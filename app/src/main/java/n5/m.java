package n5;

import n5.v;

/* compiled from: MpegAudioReader.java */
/* loaded from: classes.dex */
public final class m implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l6.l f16646a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.j f16647b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16648c;

    /* renamed from: d, reason: collision with root package name */
    public String f16649d;

    /* renamed from: e, reason: collision with root package name */
    public g5.m f16650e;

    /* renamed from: f, reason: collision with root package name */
    public int f16651f;

    /* renamed from: g, reason: collision with root package name */
    public int f16652g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16653h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16654i;

    /* renamed from: j, reason: collision with root package name */
    public long f16655j;

    /* renamed from: k, reason: collision with root package name */
    public int f16656k;

    /* renamed from: l, reason: collision with root package name */
    public long f16657l;

    public m() {
        this(null);
    }

    @Override // n5.h
    public void consume(l6.l lVar) {
        while (lVar.bytesLeft() > 0) {
            int i10 = this.f16651f;
            l6.l lVar2 = this.f16646a;
            if (i10 == 0) {
                byte[] bArr = lVar.f15881a;
                int position = lVar.getPosition();
                int iLimit = lVar.limit();
                while (true) {
                    if (position >= iLimit) {
                        lVar.setPosition(iLimit);
                        break;
                    }
                    byte b10 = bArr[position];
                    boolean z10 = (b10 & 255) == 255;
                    boolean z11 = this.f16654i && (b10 & 224) == 224;
                    this.f16654i = z10;
                    if (z11) {
                        lVar.setPosition(position + 1);
                        this.f16654i = false;
                        lVar2.f15881a[1] = bArr[position];
                        this.f16652g = 2;
                        this.f16651f = 1;
                        break;
                    }
                    position++;
                }
            } else if (i10 == 1) {
                int iMin = Math.min(lVar.bytesLeft(), 4 - this.f16652g);
                lVar.readBytes(lVar2.f15881a, this.f16652g, iMin);
                int i11 = this.f16652g + iMin;
                this.f16652g = i11;
                if (i11 >= 4) {
                    lVar2.setPosition(0);
                    int i12 = lVar2.readInt();
                    g5.j jVar = this.f16647b;
                    if (g5.j.populateHeader(i12, jVar)) {
                        this.f16656k = jVar.f12721c;
                        if (!this.f16653h) {
                            int i13 = jVar.f12722d;
                            this.f16655j = (jVar.f12725g * 1000000) / i13;
                            this.f16650e.format(c5.i.createAudioSampleFormat(this.f16649d, jVar.f12720b, null, -1, 4096, jVar.f12723e, i13, null, null, 0, this.f16648c));
                            this.f16653h = true;
                        }
                        lVar2.setPosition(0);
                        this.f16650e.sampleData(lVar2, 4);
                        this.f16651f = 2;
                    } else {
                        this.f16652g = 0;
                        this.f16651f = 1;
                    }
                }
            } else if (i10 == 2) {
                int iMin2 = Math.min(lVar.bytesLeft(), this.f16656k - this.f16652g);
                this.f16650e.sampleData(lVar, iMin2);
                int i14 = this.f16652g + iMin2;
                this.f16652g = i14;
                int i15 = this.f16656k;
                if (i14 >= i15) {
                    this.f16650e.sampleMetadata(this.f16657l, 1, i15, 0, null);
                    this.f16657l += this.f16655j;
                    this.f16652g = 0;
                    this.f16651f = 0;
                }
            }
        }
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16649d = dVar.getFormatId();
        this.f16650e = gVar.track(dVar.getTrackId(), 1);
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16657l = j10;
    }

    @Override // n5.h
    public void seek() {
        this.f16651f = 0;
        this.f16652g = 0;
        this.f16654i = false;
    }

    public m(String str) {
        this.f16651f = 0;
        l6.l lVar = new l6.l(4);
        this.f16646a = lVar;
        lVar.f15881a[0] = -1;
        this.f16647b = new g5.j();
        this.f16648c = str;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
