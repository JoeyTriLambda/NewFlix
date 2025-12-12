package n5;

import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;
import n5.v;

/* compiled from: AdtsReader.java */
/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: r, reason: collision with root package name */
    public static final byte[] f16509r = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f16510a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.k f16511b;

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f16512c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16513d;

    /* renamed from: e, reason: collision with root package name */
    public String f16514e;

    /* renamed from: f, reason: collision with root package name */
    public g5.m f16515f;

    /* renamed from: g, reason: collision with root package name */
    public g5.m f16516g;

    /* renamed from: h, reason: collision with root package name */
    public int f16517h;

    /* renamed from: i, reason: collision with root package name */
    public int f16518i;

    /* renamed from: j, reason: collision with root package name */
    public int f16519j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16520k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16521l;

    /* renamed from: m, reason: collision with root package name */
    public long f16522m;

    /* renamed from: n, reason: collision with root package name */
    public int f16523n;

    /* renamed from: o, reason: collision with root package name */
    public long f16524o;

    /* renamed from: p, reason: collision with root package name */
    public g5.m f16525p;

    /* renamed from: q, reason: collision with root package name */
    public long f16526q;

    public d(boolean z10) {
        this(z10, null);
    }

    @Override // n5.h
    public void consume(l6.l lVar) {
        while (lVar.bytesLeft() > 0) {
            int i10 = this.f16517h;
            l6.l lVar2 = this.f16512c;
            if (i10 == 0) {
                byte[] bArr = lVar.f15881a;
                int position = lVar.getPosition();
                int iLimit = lVar.limit();
                while (true) {
                    if (position >= iLimit) {
                        lVar.setPosition(position);
                        break;
                    }
                    int i11 = position + 1;
                    int i12 = bArr[position] & 255;
                    int i13 = this.f16519j;
                    if (i13 != 512 || i12 < 240 || i12 == 255) {
                        int i14 = i12 | i13;
                        if (i14 == 329) {
                            this.f16519j = 768;
                        } else if (i14 == 511) {
                            this.f16519j = 512;
                        } else if (i14 == 836) {
                            this.f16519j = 1024;
                        } else {
                            if (i14 == 1075) {
                                this.f16517h = 1;
                                this.f16518i = 3;
                                this.f16523n = 0;
                                lVar2.setPosition(0);
                                lVar.setPosition(i11);
                                break;
                            }
                            if (i13 != 256) {
                                this.f16519j = 256;
                                i11--;
                            }
                        }
                        position = i11;
                    } else {
                        this.f16520k = (i12 & 1) == 0;
                        this.f16517h = 2;
                        this.f16518i = 0;
                        lVar.setPosition(i11);
                    }
                }
            } else if (i10 == 1) {
                byte[] bArr2 = lVar2.f15881a;
                int iMin = Math.min(lVar.bytesLeft(), 10 - this.f16518i);
                lVar.readBytes(bArr2, this.f16518i, iMin);
                int i15 = this.f16518i + iMin;
                this.f16518i = i15;
                if (i15 == 10) {
                    this.f16516g.sampleData(lVar2, 10);
                    lVar2.setPosition(6);
                    g5.m mVar = this.f16516g;
                    int synchSafeInt = lVar2.readSynchSafeInt() + 10;
                    this.f16517h = 3;
                    this.f16518i = 10;
                    this.f16525p = mVar;
                    this.f16526q = 0L;
                    this.f16523n = synchSafeInt;
                }
            } else if (i10 == 2) {
                int i16 = this.f16520k ? 7 : 5;
                l6.k kVar = this.f16511b;
                byte[] bArr3 = kVar.f15877a;
                int iMin2 = Math.min(lVar.bytesLeft(), i16 - this.f16518i);
                lVar.readBytes(bArr3, this.f16518i, iMin2);
                int i17 = this.f16518i + iMin2;
                this.f16518i = i17;
                if (i17 == i16) {
                    kVar.setPosition(0);
                    if (this.f16521l) {
                        kVar.skipBits(10);
                    } else {
                        int bits = kVar.readBits(2) + 1;
                        if (bits != 2) {
                            Log.w("AdtsReader", "Detected audio object type: " + bits + ", but assuming AAC LC.");
                            bits = 2;
                        }
                        int bits2 = kVar.readBits(4);
                        kVar.skipBits(1);
                        byte[] bArrBuildAacAudioSpecificConfig = l6.c.buildAacAudioSpecificConfig(bits, bits2, kVar.readBits(3));
                        Pair<Integer, Integer> aacAudioSpecificConfig = l6.c.parseAacAudioSpecificConfig(bArrBuildAacAudioSpecificConfig);
                        c5.i iVarCreateAudioSampleFormat = c5.i.createAudioSampleFormat(this.f16514e, "audio/mp4a-latm", null, -1, -1, ((Integer) aacAudioSpecificConfig.second).intValue(), ((Integer) aacAudioSpecificConfig.first).intValue(), Collections.singletonList(bArrBuildAacAudioSpecificConfig), null, 0, this.f16513d);
                        this.f16522m = 1024000000 / iVarCreateAudioSampleFormat.D;
                        this.f16515f.format(iVarCreateAudioSampleFormat);
                        this.f16521l = true;
                    }
                    kVar.skipBits(4);
                    int bits3 = (kVar.readBits(13) - 2) - 5;
                    if (this.f16520k) {
                        bits3 -= 2;
                    }
                    g5.m mVar2 = this.f16515f;
                    long j10 = this.f16522m;
                    this.f16517h = 3;
                    this.f16518i = 0;
                    this.f16525p = mVar2;
                    this.f16526q = j10;
                    this.f16523n = bits3;
                }
            } else if (i10 == 3) {
                int iMin3 = Math.min(lVar.bytesLeft(), this.f16523n - this.f16518i);
                this.f16525p.sampleData(lVar, iMin3);
                int i18 = this.f16518i + iMin3;
                this.f16518i = i18;
                int i19 = this.f16523n;
                if (i18 == i19) {
                    this.f16525p.sampleMetadata(this.f16524o, 1, i19, 0, null);
                    this.f16524o += this.f16526q;
                    this.f16517h = 0;
                    this.f16518i = 0;
                    this.f16519j = 256;
                }
            }
        }
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16514e = dVar.getFormatId();
        this.f16515f = gVar.track(dVar.getTrackId(), 1);
        if (!this.f16510a) {
            this.f16516g = new g5.d();
            return;
        }
        dVar.generateNewId();
        g5.m mVarTrack = gVar.track(dVar.getTrackId(), 4);
        this.f16516g = mVarTrack;
        mVarTrack.format(c5.i.createSampleFormat(dVar.getFormatId(), "application/id3", null, -1, null));
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16524o = j10;
    }

    @Override // n5.h
    public void seek() {
        this.f16517h = 0;
        this.f16518i = 0;
        this.f16519j = 256;
    }

    public d(boolean z10, String str) {
        this.f16511b = new l6.k(new byte[7]);
        this.f16512c = new l6.l(Arrays.copyOf(f16509r, 10));
        this.f16517h = 0;
        this.f16518i = 0;
        this.f16519j = 256;
        this.f16510a = z10;
        this.f16513d = str;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
