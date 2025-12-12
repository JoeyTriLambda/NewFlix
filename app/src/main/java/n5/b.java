package n5;

import d5.a;
import n5.v;

/* compiled from: Ac3Reader.java */
/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l6.k f16492a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.l f16493b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16494c;

    /* renamed from: d, reason: collision with root package name */
    public String f16495d;

    /* renamed from: e, reason: collision with root package name */
    public g5.m f16496e;

    /* renamed from: f, reason: collision with root package name */
    public int f16497f;

    /* renamed from: g, reason: collision with root package name */
    public int f16498g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16499h;

    /* renamed from: i, reason: collision with root package name */
    public long f16500i;

    /* renamed from: j, reason: collision with root package name */
    public c5.i f16501j;

    /* renamed from: k, reason: collision with root package name */
    public int f16502k;

    /* renamed from: l, reason: collision with root package name */
    public long f16503l;

    public b() {
        this(null);
    }

    @Override // n5.h
    public void consume(l6.l lVar) {
        boolean z10;
        while (lVar.bytesLeft() > 0) {
            int i10 = this.f16497f;
            l6.l lVar2 = this.f16493b;
            if (i10 == 0) {
                while (true) {
                    if (lVar.bytesLeft() <= 0) {
                        z10 = false;
                        break;
                    }
                    if (this.f16499h) {
                        int unsignedByte = lVar.readUnsignedByte();
                        if (unsignedByte == 119) {
                            this.f16499h = false;
                            z10 = true;
                            break;
                        }
                        this.f16499h = unsignedByte == 11;
                    } else {
                        this.f16499h = lVar.readUnsignedByte() == 11;
                    }
                }
                if (z10) {
                    this.f16497f = 1;
                    byte[] bArr = lVar2.f15881a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.f16498g = 2;
                }
            } else if (i10 == 1) {
                byte[] bArr2 = lVar2.f15881a;
                int iMin = Math.min(lVar.bytesLeft(), 8 - this.f16498g);
                lVar.readBytes(bArr2, this.f16498g, iMin);
                int i11 = this.f16498g + iMin;
                this.f16498g = i11;
                if (i11 == 8) {
                    l6.k kVar = this.f16492a;
                    kVar.setPosition(0);
                    a.C0125a ac3SyncframeInfo = d5.a.parseAc3SyncframeInfo(kVar);
                    c5.i iVar = this.f16501j;
                    if (iVar == null || ac3SyncframeInfo.f10858c != iVar.C || ac3SyncframeInfo.f10857b != iVar.D || ac3SyncframeInfo.f10856a != iVar.f5120q) {
                        c5.i iVarCreateAudioSampleFormat = c5.i.createAudioSampleFormat(this.f16495d, ac3SyncframeInfo.f10856a, null, -1, -1, ac3SyncframeInfo.f10858c, ac3SyncframeInfo.f10857b, null, null, 0, this.f16494c);
                        this.f16501j = iVarCreateAudioSampleFormat;
                        this.f16496e.format(iVarCreateAudioSampleFormat);
                    }
                    this.f16502k = ac3SyncframeInfo.f10859d;
                    this.f16500i = (ac3SyncframeInfo.f10860e * 1000000) / this.f16501j.D;
                    lVar2.setPosition(0);
                    this.f16496e.sampleData(lVar2, 8);
                    this.f16497f = 2;
                }
            } else if (i10 == 2) {
                int iMin2 = Math.min(lVar.bytesLeft(), this.f16502k - this.f16498g);
                this.f16496e.sampleData(lVar, iMin2);
                int i12 = this.f16498g + iMin2;
                this.f16498g = i12;
                int i13 = this.f16502k;
                if (i12 == i13) {
                    this.f16496e.sampleMetadata(this.f16503l, 1, i13, 0, null);
                    this.f16503l += this.f16500i;
                    this.f16497f = 0;
                }
            }
        }
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16495d = dVar.getFormatId();
        this.f16496e = gVar.track(dVar.getTrackId(), 1);
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16503l = j10;
    }

    @Override // n5.h
    public void seek() {
        this.f16497f = 0;
        this.f16498g = 0;
        this.f16499h = false;
    }

    public b(String str) {
        l6.k kVar = new l6.k(new byte[8]);
        this.f16492a = kVar;
        this.f16493b = new l6.l(kVar.f15877a);
        this.f16497f = 0;
        this.f16494c = str;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
