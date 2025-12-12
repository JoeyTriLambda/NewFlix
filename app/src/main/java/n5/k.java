package n5;

import n5.v;

/* compiled from: H265Reader.java */
/* loaded from: classes.dex */
public final class k implements h {

    /* renamed from: a, reason: collision with root package name */
    public final s f16613a;

    /* renamed from: b, reason: collision with root package name */
    public String f16614b;

    /* renamed from: c, reason: collision with root package name */
    public g5.m f16615c;

    /* renamed from: d, reason: collision with root package name */
    public a f16616d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16617e;

    /* renamed from: l, reason: collision with root package name */
    public long f16624l;

    /* renamed from: m, reason: collision with root package name */
    public long f16625m;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f16618f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    public final n f16619g = new n(32, 128);

    /* renamed from: h, reason: collision with root package name */
    public final n f16620h = new n(33, 128);

    /* renamed from: i, reason: collision with root package name */
    public final n f16621i = new n(34, 128);

    /* renamed from: j, reason: collision with root package name */
    public final n f16622j = new n(39, 128);

    /* renamed from: k, reason: collision with root package name */
    public final n f16623k = new n(40, 128);

    /* renamed from: n, reason: collision with root package name */
    public final l6.l f16626n = new l6.l();

    /* compiled from: H265Reader.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final g5.m f16627a;

        /* renamed from: b, reason: collision with root package name */
        public long f16628b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16629c;

        /* renamed from: d, reason: collision with root package name */
        public int f16630d;

        /* renamed from: e, reason: collision with root package name */
        public long f16631e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f16632f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16633g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f16634h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f16635i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f16636j;

        /* renamed from: k, reason: collision with root package name */
        public long f16637k;

        /* renamed from: l, reason: collision with root package name */
        public long f16638l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f16639m;

        public a(g5.m mVar) {
            this.f16627a = mVar;
        }

        public void endNalUnit(long j10, int i10) {
            if (this.f16636j && this.f16633g) {
                this.f16639m = this.f16629c;
                this.f16636j = false;
                return;
            }
            if (this.f16634h || this.f16633g) {
                if (this.f16635i) {
                    long j11 = this.f16628b;
                    boolean z10 = this.f16639m;
                    int i11 = (int) (j11 - this.f16637k);
                    this.f16627a.sampleMetadata(this.f16638l, z10 ? 1 : 0, i11, i10 + ((int) (j10 - j11)), null);
                }
                this.f16637k = this.f16628b;
                this.f16638l = this.f16631e;
                this.f16635i = true;
                this.f16639m = this.f16629c;
            }
        }

        public void readNalUnitData(byte[] bArr, int i10, int i11) {
            if (this.f16632f) {
                int i12 = this.f16630d;
                int i13 = (i10 + 2) - i12;
                if (i13 >= i11) {
                    this.f16630d = (i11 - i10) + i12;
                } else {
                    this.f16633g = (bArr[i13] & 128) != 0;
                    this.f16632f = false;
                }
            }
        }

        public void reset() {
            this.f16632f = false;
            this.f16633g = false;
            this.f16634h = false;
            this.f16635i = false;
            this.f16636j = false;
        }

        public void startNalUnit(long j10, int i10, int i11, long j11) {
            this.f16633g = false;
            this.f16634h = false;
            this.f16631e = j11;
            this.f16630d = 0;
            this.f16628b = j10;
            if (i11 >= 32) {
                if (!this.f16636j && this.f16635i) {
                    this.f16627a.sampleMetadata(this.f16638l, this.f16639m ? 1 : 0, (int) (j10 - this.f16637k), i10, null);
                    this.f16635i = false;
                }
                if (i11 <= 34) {
                    this.f16634h = !this.f16636j;
                    this.f16636j = true;
                }
            }
            boolean z10 = i11 >= 16 && i11 <= 21;
            this.f16629c = z10;
            this.f16632f = z10 || i11 <= 9;
        }
    }

    public k(s sVar) {
        this.f16613a = sVar;
    }

    public final void a(int i10, byte[] bArr, int i11) {
        if (this.f16617e) {
            this.f16616d.readNalUnitData(bArr, i10, i11);
        } else {
            this.f16619g.appendToNalUnit(bArr, i10, i11);
            this.f16620h.appendToNalUnit(bArr, i10, i11);
            this.f16621i.appendToNalUnit(bArr, i10, i11);
        }
        this.f16622j.appendToNalUnit(bArr, i10, i11);
        this.f16623k.appendToNalUnit(bArr, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x030a  */
    @Override // n5.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consume(l6.l r37) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.k.consume(l6.l):void");
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16614b = dVar.getFormatId();
        g5.m mVarTrack = gVar.track(dVar.getTrackId(), 2);
        this.f16615c = mVarTrack;
        this.f16616d = new a(mVarTrack);
        this.f16613a.createTracks(gVar, dVar);
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16625m = j10;
    }

    @Override // n5.h
    public void seek() {
        l6.j.clearPrefixFlags(this.f16618f);
        this.f16619g.reset();
        this.f16620h.reset();
        this.f16621i.reset();
        this.f16622j.reset();
        this.f16623k.reset();
        this.f16616d.reset();
        this.f16624l = 0L;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
