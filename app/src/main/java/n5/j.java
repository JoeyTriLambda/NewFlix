package n5;

import android.util.SparseArray;
import l6.j;
import n5.v;

/* compiled from: H264Reader.java */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name */
    public final s f16565a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16566b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16567c;

    /* renamed from: g, reason: collision with root package name */
    public long f16571g;

    /* renamed from: i, reason: collision with root package name */
    public String f16573i;

    /* renamed from: j, reason: collision with root package name */
    public g5.m f16574j;

    /* renamed from: k, reason: collision with root package name */
    public a f16575k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16576l;

    /* renamed from: m, reason: collision with root package name */
    public long f16577m;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f16572h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    public final n f16568d = new n(7, 128);

    /* renamed from: e, reason: collision with root package name */
    public final n f16569e = new n(8, 128);

    /* renamed from: f, reason: collision with root package name */
    public final n f16570f = new n(6, 128);

    /* renamed from: n, reason: collision with root package name */
    public final l6.l f16578n = new l6.l();

    /* compiled from: H264Reader.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final g5.m f16579a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f16580b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16581c;

        /* renamed from: f, reason: collision with root package name */
        public final l6.m f16584f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f16585g;

        /* renamed from: h, reason: collision with root package name */
        public int f16586h;

        /* renamed from: i, reason: collision with root package name */
        public int f16587i;

        /* renamed from: j, reason: collision with root package name */
        public long f16588j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f16589k;

        /* renamed from: l, reason: collision with root package name */
        public long f16590l;

        /* renamed from: o, reason: collision with root package name */
        public boolean f16593o;

        /* renamed from: p, reason: collision with root package name */
        public long f16594p;

        /* renamed from: q, reason: collision with root package name */
        public long f16595q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f16596r;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray<j.b> f16582d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray<j.a> f16583e = new SparseArray<>();

        /* renamed from: m, reason: collision with root package name */
        public C0206a f16591m = new C0206a();

        /* renamed from: n, reason: collision with root package name */
        public C0206a f16592n = new C0206a();

        /* compiled from: H264Reader.java */
        /* renamed from: n5.j$a$a, reason: collision with other inner class name */
        public static final class C0206a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f16597a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f16598b;

            /* renamed from: c, reason: collision with root package name */
            public j.b f16599c;

            /* renamed from: d, reason: collision with root package name */
            public int f16600d;

            /* renamed from: e, reason: collision with root package name */
            public int f16601e;

            /* renamed from: f, reason: collision with root package name */
            public int f16602f;

            /* renamed from: g, reason: collision with root package name */
            public int f16603g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f16604h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f16605i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f16606j;

            /* renamed from: k, reason: collision with root package name */
            public boolean f16607k;

            /* renamed from: l, reason: collision with root package name */
            public int f16608l;

            /* renamed from: m, reason: collision with root package name */
            public int f16609m;

            /* renamed from: n, reason: collision with root package name */
            public int f16610n;

            /* renamed from: o, reason: collision with root package name */
            public int f16611o;

            /* renamed from: p, reason: collision with root package name */
            public int f16612p;

            public void clear() {
                this.f16598b = false;
                this.f16597a = false;
            }

            public boolean isISlice() {
                int i10;
                return this.f16598b && ((i10 = this.f16601e) == 7 || i10 == 2);
            }

            public void setAll(j.b bVar, int i10, int i11, int i12, int i13, boolean z10, boolean z11, boolean z12, boolean z13, int i14, int i15, int i16, int i17, int i18) {
                this.f16599c = bVar;
                this.f16600d = i10;
                this.f16601e = i11;
                this.f16602f = i12;
                this.f16603g = i13;
                this.f16604h = z10;
                this.f16605i = z11;
                this.f16606j = z12;
                this.f16607k = z13;
                this.f16608l = i14;
                this.f16609m = i15;
                this.f16610n = i16;
                this.f16611o = i17;
                this.f16612p = i18;
                this.f16597a = true;
                this.f16598b = true;
            }

            public void setSliceType(int i10) {
                this.f16601e = i10;
                this.f16598b = true;
            }
        }

        public a(g5.m mVar, boolean z10, boolean z11) {
            this.f16579a = mVar;
            this.f16580b = z10;
            this.f16581c = z11;
            byte[] bArr = new byte[128];
            this.f16585g = bArr;
            this.f16584f = new l6.m(bArr, 0, 0);
            reset();
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void appendToNalUnit(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 344
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: n5.j.a.appendToNalUnit(byte[], int, int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void endNalUnit(long r12, int r14) {
            /*
                Method dump skipped, instructions count: 193
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: n5.j.a.endNalUnit(long, int):void");
        }

        public boolean needsSpsPps() {
            return this.f16581c;
        }

        public void putPps(j.a aVar) {
            this.f16583e.append(aVar.f15864a, aVar);
        }

        public void putSps(j.b bVar) {
            this.f16582d.append(bVar.f15867a, bVar);
        }

        public void reset() {
            this.f16589k = false;
            this.f16593o = false;
            this.f16592n.clear();
        }

        public void startNalUnit(long j10, int i10, long j11) {
            this.f16587i = i10;
            this.f16590l = j11;
            this.f16588j = j10;
            if (!this.f16580b || i10 != 1) {
                if (!this.f16581c) {
                    return;
                }
                if (i10 != 5 && i10 != 1 && i10 != 2) {
                    return;
                }
            }
            C0206a c0206a = this.f16591m;
            this.f16591m = this.f16592n;
            this.f16592n = c0206a;
            c0206a.clear();
            this.f16586h = 0;
            this.f16589k = true;
        }
    }

    public j(s sVar, boolean z10, boolean z11) {
        this.f16565a = sVar;
        this.f16566b = z10;
        this.f16567c = z11;
    }

    public final void a(int i10, byte[] bArr, int i11) {
        if (!this.f16576l || this.f16575k.needsSpsPps()) {
            this.f16568d.appendToNalUnit(bArr, i10, i11);
            this.f16569e.appendToNalUnit(bArr, i10, i11);
        }
        this.f16570f.appendToNalUnit(bArr, i10, i11);
        this.f16575k.appendToNalUnit(bArr, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    @Override // n5.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consume(l6.l r33) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.j.consume(l6.l):void");
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        this.f16573i = dVar.getFormatId();
        g5.m mVarTrack = gVar.track(dVar.getTrackId(), 2);
        this.f16574j = mVarTrack;
        this.f16575k = new a(mVarTrack, this.f16566b, this.f16567c);
        this.f16565a.createTracks(gVar, dVar);
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        this.f16577m = j10;
    }

    @Override // n5.h
    public void seek() {
        l6.j.clearPrefixFlags(this.f16572h);
        this.f16568d.reset();
        this.f16569e.reset();
        this.f16570f.reset();
        this.f16575k.reset();
        this.f16571g = 0L;
    }

    @Override // n5.h
    public void packetFinished() {
    }
}
