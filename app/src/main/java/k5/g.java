package k5;

import java.io.IOException;
import java.util.Stack;
import k5.a;
import l6.u;

/* compiled from: Mp4Extractor.java */
/* loaded from: classes.dex */
public final class g implements g5.e, g5.l {

    /* renamed from: q, reason: collision with root package name */
    public static final int f14890q = u.getIntegerCodeForString("qt  ");

    /* renamed from: a, reason: collision with root package name */
    public final int f14891a;

    /* renamed from: f, reason: collision with root package name */
    public int f14896f;

    /* renamed from: g, reason: collision with root package name */
    public int f14897g;

    /* renamed from: h, reason: collision with root package name */
    public long f14898h;

    /* renamed from: i, reason: collision with root package name */
    public int f14899i;

    /* renamed from: j, reason: collision with root package name */
    public l6.l f14900j;

    /* renamed from: k, reason: collision with root package name */
    public int f14901k;

    /* renamed from: l, reason: collision with root package name */
    public int f14902l;

    /* renamed from: m, reason: collision with root package name */
    public g5.g f14903m;

    /* renamed from: n, reason: collision with root package name */
    public a[] f14904n;

    /* renamed from: o, reason: collision with root package name */
    public long f14905o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f14906p;

    /* renamed from: d, reason: collision with root package name */
    public final l6.l f14894d = new l6.l(16);

    /* renamed from: e, reason: collision with root package name */
    public final Stack<a.C0177a> f14895e = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    public final l6.l f14892b = new l6.l(l6.j.f15860a);

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f14893c = new l6.l(4);

    /* compiled from: Mp4Extractor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final j f14907a;

        /* renamed from: b, reason: collision with root package name */
        public final m f14908b;

        /* renamed from: c, reason: collision with root package name */
        public final g5.m f14909c;

        /* renamed from: d, reason: collision with root package name */
        public int f14910d;

        public a(j jVar, m mVar, g5.m mVar2) {
            this.f14907a = jVar;
            this.f14908b = mVar;
            this.f14909c = mVar2;
        }
    }

    public g(int i10) {
        this.f14891a = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r22) throws com.google.android.exoplayer2.ParserException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.g.a(long):void");
    }

    @Override // g5.l
    public long getDurationUs() {
        return this.f14905o;
    }

    @Override // g5.l
    public long getPosition(long j10) {
        long j11 = Long.MAX_VALUE;
        for (a aVar : this.f14904n) {
            m mVar = aVar.f14908b;
            int indexOfEarlierOrEqualSynchronizationSample = mVar.getIndexOfEarlierOrEqualSynchronizationSample(j10);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = mVar.getIndexOfLaterOrEqualSynchronizationSample(j10);
            }
            long j12 = mVar.f14946b[indexOfEarlierOrEqualSynchronizationSample];
            if (j12 < j11) {
                j11 = j12;
            }
        }
        return j11;
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f14903m = gVar;
    }

    @Override // g5.l
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0205  */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(g5.f r24, g5.k r25) throws java.lang.InterruptedException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.g.read(g5.f, g5.k):int");
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f14895e.clear();
        this.f14899i = 0;
        this.f14901k = 0;
        this.f14902l = 0;
        if (j10 == 0) {
            this.f14896f = 0;
            this.f14899i = 0;
            return;
        }
        a[] aVarArr = this.f14904n;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                m mVar = aVar.f14908b;
                int indexOfEarlierOrEqualSynchronizationSample = mVar.getIndexOfEarlierOrEqualSynchronizationSample(j11);
                if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                    indexOfEarlierOrEqualSynchronizationSample = mVar.getIndexOfLaterOrEqualSynchronizationSample(j11);
                }
                aVar.f14910d = indexOfEarlierOrEqualSynchronizationSample;
            }
        }
    }

    @Override // g5.e
    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        return i.sniffUnfragmented(fVar);
    }

    @Override // g5.e
    public void release() {
    }
}
