package c5;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import c5.d;
import c5.l;
import c5.r;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import j6.h;
import java.io.IOException;
import u5.g;
import u5.h;

/* compiled from: ExoPlayerImplInternal.java */
/* loaded from: classes.dex */
public final class g implements Handler.Callback, g.a, h.a, h.a {
    public l6.h A;
    public u5.h B;
    public o[] C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H = 1;
    public int I;
    public int J;
    public int K;
    public long L;
    public int M;
    public c N;
    public long O;
    public a P;
    public a Q;
    public a R;
    public r S;

    /* renamed from: b, reason: collision with root package name */
    public final o[] f5069b;

    /* renamed from: m, reason: collision with root package name */
    public final p[] f5070m;

    /* renamed from: n, reason: collision with root package name */
    public final j6.h f5071n;

    /* renamed from: o, reason: collision with root package name */
    public final k f5072o;

    /* renamed from: p, reason: collision with root package name */
    public final l6.p f5073p;

    /* renamed from: q, reason: collision with root package name */
    public final Handler f5074q;

    /* renamed from: r, reason: collision with root package name */
    public final HandlerThread f5075r;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f5076s;

    /* renamed from: t, reason: collision with root package name */
    public final c5.d f5077t;

    /* renamed from: u, reason: collision with root package name */
    public final r.c f5078u;

    /* renamed from: v, reason: collision with root package name */
    public final r.b f5079v;

    /* renamed from: w, reason: collision with root package name */
    public final l f5080w;

    /* renamed from: x, reason: collision with root package name */
    public b f5081x;

    /* renamed from: y, reason: collision with root package name */
    public m f5082y;

    /* renamed from: z, reason: collision with root package name */
    public o f5083z;

    /* compiled from: ExoPlayerImplInternal.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final u5.g f5084a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f5085b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5086c;

        /* renamed from: d, reason: collision with root package name */
        public final u5.k[] f5087d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean[] f5088e;

        /* renamed from: f, reason: collision with root package name */
        public final long f5089f;

        /* renamed from: g, reason: collision with root package name */
        public l.a f5090g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f5091h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f5092i;

        /* renamed from: j, reason: collision with root package name */
        public a f5093j;

        /* renamed from: k, reason: collision with root package name */
        public j6.i f5094k;

        /* renamed from: l, reason: collision with root package name */
        public final o[] f5095l;

        /* renamed from: m, reason: collision with root package name */
        public final p[] f5096m;

        /* renamed from: n, reason: collision with root package name */
        public final j6.h f5097n;

        /* renamed from: o, reason: collision with root package name */
        public final k f5098o;

        /* renamed from: p, reason: collision with root package name */
        public final u5.h f5099p;

        /* renamed from: q, reason: collision with root package name */
        public j6.i f5100q;

        public a(o[] oVarArr, p[] pVarArr, long j10, j6.h hVar, k kVar, u5.h hVar2, Object obj, int i10, l.a aVar) {
            this.f5095l = oVarArr;
            this.f5096m = pVarArr;
            this.f5089f = j10;
            this.f5097n = hVar;
            this.f5098o = kVar;
            this.f5099p = hVar2;
            this.f5085b = l6.a.checkNotNull(obj);
            this.f5086c = i10;
            this.f5090g = aVar;
            this.f5087d = new u5.k[oVarArr.length];
            this.f5088e = new boolean[oVarArr.length];
            u5.g gVarCreatePeriod = hVar2.createPeriod(aVar.f5135a, ((c5.c) kVar).getAllocator());
            long j11 = aVar.f5137c;
            if (j11 != Long.MIN_VALUE) {
                u5.b bVar = new u5.b(gVarCreatePeriod, true);
                bVar.setClipping(0L, j11);
                gVarCreatePeriod = bVar;
            }
            this.f5084a = gVarCreatePeriod;
        }

        public void continueLoading(long j10) {
            this.f5084a.continueLoading(toPeriodTime(j10));
        }

        public long getRendererOffset() {
            int i10 = this.f5086c;
            long j10 = this.f5089f;
            return i10 == 0 ? j10 : j10 - this.f5090g.f5136b;
        }

        public void handlePrepared() throws ExoPlaybackException {
            this.f5091h = true;
            selectTracks();
            this.f5090g = this.f5090g.copyWithStartPositionUs(updatePeriodTrackSelection(this.f5090g.f5136b, false));
        }

        public boolean haveSufficientBuffer(boolean z10, long j10) {
            long bufferedPositionUs = !this.f5091h ? this.f5090g.f5136b : this.f5084a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                l.a aVar = this.f5090g;
                if (aVar.f5141g) {
                    return true;
                }
                bufferedPositionUs = aVar.f5139e;
            }
            return ((c5.c) this.f5098o).shouldStartPlayback(bufferedPositionUs - toPeriodTime(j10), z10);
        }

        public boolean isFullyBuffered() {
            return this.f5091h && (!this.f5092i || this.f5084a.getBufferedPositionUs() == Long.MIN_VALUE);
        }

        public void release() {
            try {
                long j10 = this.f5090g.f5137c;
                u5.g gVar = this.f5084a;
                u5.h hVar = this.f5099p;
                if (j10 != Long.MIN_VALUE) {
                    hVar.releasePeriod(((u5.b) gVar).f19999b);
                } else {
                    hVar.releasePeriod(gVar);
                }
            } catch (RuntimeException e10) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e10);
            }
        }

        public boolean selectTracks() throws ExoPlaybackException {
            j6.i iVarSelectTracks = this.f5097n.selectTracks(this.f5096m, this.f5084a.getTrackGroups());
            if (iVarSelectTracks.isEquivalent(this.f5100q)) {
                return false;
            }
            this.f5094k = iVarSelectTracks;
            return true;
        }

        public boolean shouldContinueLoading(long j10) {
            long nextLoadPositionUs = !this.f5091h ? 0L : this.f5084a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return false;
            }
            return ((c5.c) this.f5098o).shouldContinueLoading(nextLoadPositionUs - toPeriodTime(j10));
        }

        public long toPeriodTime(long j10) {
            return j10 - getRendererOffset();
        }

        public long toRendererTime(long j10) {
            return getRendererOffset() + j10;
        }

        public long updatePeriodTrackSelection(long j10, boolean z10) {
            return updatePeriodTrackSelection(j10, z10, new boolean[this.f5095l.length]);
        }

        public long updatePeriodTrackSelection(long j10, boolean z10, boolean[] zArr) {
            j6.g gVar = this.f5094k.f14669b;
            int i10 = 0;
            while (true) {
                boolean z11 = true;
                if (i10 >= gVar.f14665a) {
                    break;
                }
                if (z10 || !this.f5094k.isEquivalent(this.f5100q, i10)) {
                    z11 = false;
                }
                this.f5088e[i10] = z11;
                i10++;
            }
            long jSelectTracks = this.f5084a.selectTracks(gVar.getAll(), this.f5088e, this.f5087d, zArr, j10);
            this.f5100q = this.f5094k;
            this.f5092i = false;
            int i11 = 0;
            while (true) {
                u5.k[] kVarArr = this.f5087d;
                if (i11 >= kVarArr.length) {
                    ((c5.c) this.f5098o).onTracksSelected(this.f5095l, this.f5094k.f14668a, gVar);
                    return jSelectTracks;
                }
                if (kVarArr[i11] != null) {
                    l6.a.checkState(gVar.get(i11) != null);
                    this.f5092i = true;
                } else {
                    l6.a.checkState(gVar.get(i11) == null);
                }
                i11++;
            }
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final h.b f5101a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5102b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5103c;

        /* renamed from: d, reason: collision with root package name */
        public volatile long f5104d;

        /* renamed from: e, reason: collision with root package name */
        public volatile long f5105e;

        public b(int i10, long j10) {
            this(new h.b(i10), j10);
        }

        public b copyWithPeriodIndex(int i10) {
            b bVar = new b(this.f5101a.copyWithPeriodIndex(i10), this.f5102b, this.f5103c);
            bVar.f5104d = this.f5104d;
            bVar.f5105e = this.f5105e;
            return bVar;
        }

        public b(h.b bVar, long j10) {
            this(bVar, j10, -9223372036854775807L);
        }

        public b(h.b bVar, long j10, long j11) {
            this.f5101a = bVar;
            this.f5102b = j10;
            this.f5103c = j11;
            this.f5104d = j10;
            this.f5105e = j10;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final r f5106a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5107b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5108c;

        public c(r rVar, int i10, long j10) {
            this.f5106a = rVar;
            this.f5107b = i10;
            this.f5108c = j10;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final r f5109a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f5110b;

        /* renamed from: c, reason: collision with root package name */
        public final b f5111c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5112d;

        public d(r rVar, Object obj, b bVar, int i10) {
            this.f5109a = rVar;
            this.f5110b = obj;
            this.f5111c = bVar;
            this.f5112d = i10;
        }
    }

    public g(o[] oVarArr, j6.h hVar, k kVar, boolean z10, int i10, Handler handler, b bVar, c5.d dVar) {
        this.f5069b = oVarArr;
        this.f5071n = hVar;
        this.f5072o = kVar;
        this.E = z10;
        this.I = i10;
        this.f5076s = handler;
        this.f5081x = bVar;
        this.f5077t = dVar;
        this.f5070m = new p[oVarArr.length];
        for (int i11 = 0; i11 < oVarArr.length; i11++) {
            oVarArr[i11].setIndex(i11);
            this.f5070m[i11] = oVarArr[i11].getCapabilities();
        }
        this.f5073p = new l6.p();
        this.C = new o[0];
        this.f5078u = new r.c();
        this.f5079v = new r.b();
        this.f5080w = new l();
        hVar.init(this);
        this.f5082y = m.f5142d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f5075r = handlerThread;
        handlerThread.start();
        this.f5074q = new Handler(handlerThread.getLooper(), this);
    }

    public final void A() {
        m(true);
        ((c5.c) this.f5072o).onStopped();
        z(1);
    }

    public final void B() throws ExoPlaybackException {
        this.f5073p.stop();
        for (o oVar : this.C) {
            if (oVar.getState() == 2) {
                oVar.stop();
            }
        }
    }

    public final void C() throws ExoPlaybackException {
        a aVar = this.R;
        if (aVar == null) {
            return;
        }
        long discontinuity = aVar.f5084a.readDiscontinuity();
        if (discontinuity != -9223372036854775807L) {
            n(discontinuity);
        } else {
            o oVar = this.f5083z;
            if (oVar == null || oVar.isEnded()) {
                this.O = this.f5073p.getPositionUs();
            } else {
                long positionUs = this.A.getPositionUs();
                this.O = positionUs;
                this.f5073p.setPositionUs(positionUs);
            }
            discontinuity = this.R.toPeriodTime(this.O);
        }
        this.f5081x.f5104d = discontinuity;
        this.L = SystemClock.elapsedRealtime() * 1000;
        long bufferedPositionUs = this.C.length == 0 ? Long.MIN_VALUE : this.R.f5084a.getBufferedPositionUs();
        b bVar = this.f5081x;
        if (bufferedPositionUs == Long.MIN_VALUE) {
            bufferedPositionUs = this.R.f5090g.f5139e;
        }
        bVar.f5105e = bufferedPositionUs;
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0300 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9 A[LOOP:3: B:49:0x00d9->B:53:0x00e9, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.g.a():void");
    }

    public final void b(boolean[] zArr, int i10) throws ExoPlaybackException {
        this.C = new o[i10];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            o[] oVarArr = this.f5069b;
            if (i11 >= oVarArr.length) {
                return;
            }
            o oVar = oVarArr[i11];
            j6.f fVar = this.R.f5094k.f14669b.get(i11);
            if (fVar != null) {
                int i13 = i12 + 1;
                this.C[i12] = oVar;
                if (oVar.getState() == 0) {
                    q qVar = this.R.f5094k.f14671d[i11];
                    boolean z10 = this.E && this.H == 3;
                    boolean z11 = !zArr[i11] && z10;
                    int length = fVar.length();
                    i[] iVarArr = new i[length];
                    for (int i14 = 0; i14 < length; i14++) {
                        iVarArr[i14] = fVar.getFormat(i14);
                    }
                    a aVar = this.R;
                    oVar.enable(qVar, iVarArr, aVar.f5087d[i11], this.O, z11, aVar.getRendererOffset());
                    l6.h mediaClock = oVar.getMediaClock();
                    if (mediaClock != null) {
                        if (this.A != null) {
                            throw new ExoPlaybackException(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.A = mediaClock;
                        this.f5083z = oVar;
                        mediaClock.setPlaybackParameters(this.f5082y);
                    }
                    if (z10) {
                        oVar.start();
                    }
                }
                i12 = i13;
            }
            i11++;
        }
    }

    public synchronized void blockingSendMessages(d.b... bVarArr) {
        if (this.D) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i10 = this.J;
        this.J = i10 + 1;
        this.f5074q.obtainMessage(11, bVarArr).sendToTarget();
        boolean z10 = false;
        while (this.K <= i10) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public final void c(u5.g gVar) throws ExoPlaybackException {
        a aVar = this.P;
        if (aVar == null || aVar.f5084a != gVar) {
            return;
        }
        aVar.handlePrepared();
        if (this.R == null) {
            a aVar2 = this.P;
            this.Q = aVar2;
            n(aVar2.f5090g.f5136b);
            x(this.Q);
        }
        g();
    }

    public final void d(int i10, Object obj) {
        this.f5081x = new b(0, 0L);
        i(i10, obj);
        this.f5081x = new b(0, -9223372036854775807L);
        z(4);
        m(false);
    }

    public final void e(Pair<r, Object> pair) throws ExoPlaybackException {
        a aVar;
        a aVar2;
        r rVar = this.S;
        r rVar2 = (r) pair.first;
        this.S = rVar2;
        this.f5080w.setTimeline(rVar2);
        Object obj = pair.second;
        if (rVar == null) {
            if (this.M > 0) {
                Pair<Integer, Long> pairO = o(this.N);
                int i10 = this.M;
                this.M = 0;
                this.N = null;
                if (pairO == null) {
                    d(i10, obj);
                    return;
                }
                int iIntValue = ((Integer) pairO.first).intValue();
                long jLongValue = ((Long) pairO.second).longValue();
                h.b bVarResolvePeriodPositionForAds = this.f5080w.resolvePeriodPositionForAds(iIntValue, jLongValue);
                this.f5081x = new b(bVarResolvePeriodPositionForAds, bVarResolvePeriodPositionForAds.isAd() ? 0L : jLongValue, jLongValue);
                i(i10, obj);
                return;
            }
            if (this.f5081x.f5102b != -9223372036854775807L) {
                i(0, obj);
                return;
            }
            if (this.S.isEmpty()) {
                d(0, obj);
                return;
            }
            Pair<Integer, Long> periodPosition = this.S.getPeriodPosition(this.f5078u, this.f5079v, 0, -9223372036854775807L);
            int iIntValue2 = ((Integer) periodPosition.first).intValue();
            long jLongValue2 = ((Long) periodPosition.second).longValue();
            h.b bVarResolvePeriodPositionForAds2 = this.f5080w.resolvePeriodPositionForAds(iIntValue2, jLongValue2);
            this.f5081x = new b(bVarResolvePeriodPositionForAds2, bVarResolvePeriodPositionForAds2.isAd() ? 0L : jLongValue2, jLongValue2);
            i(0, obj);
            return;
        }
        int i11 = this.f5081x.f5101a.f20054a;
        a aVar3 = this.R;
        if (aVar3 == null) {
            aVar3 = this.P;
        }
        if (aVar3 == null && i11 >= rVar.getPeriodCount()) {
            i(0, obj);
            return;
        }
        int indexOfPeriod = this.S.getIndexOfPeriod(aVar3 == null ? rVar.getPeriod(i11, this.f5079v, true).f5150b : aVar3.f5085b);
        if (indexOfPeriod == -1) {
            int iP = p(i11, rVar, this.S);
            if (iP == -1) {
                d(0, obj);
                return;
            }
            Pair<Integer, Long> periodPosition2 = this.S.getPeriodPosition(this.f5078u, this.f5079v, this.S.getPeriod(iP, this.f5079v).f5151c, -9223372036854775807L);
            int iIntValue3 = ((Integer) periodPosition2.first).intValue();
            long jLongValue3 = ((Long) periodPosition2.second).longValue();
            this.S.getPeriod(iIntValue3, this.f5079v, true);
            if (aVar3 != null) {
                Object obj2 = this.f5079v.f5150b;
                aVar3.f5090g = aVar3.f5090g.copyWithPeriodIndex(-1);
                while (true) {
                    aVar3 = aVar3.f5093j;
                    if (aVar3 == null) {
                        break;
                    } else if (aVar3.f5085b.equals(obj2)) {
                        aVar3.f5090g = this.f5080w.getUpdatedMediaPeriodInfo(aVar3.f5090g, iIntValue3);
                    } else {
                        aVar3.f5090g = aVar3.f5090g.copyWithPeriodIndex(-1);
                    }
                }
            }
            h.b bVar = new h.b(iIntValue3);
            this.f5081x = new b(bVar, s(bVar, jLongValue3));
            i(0, obj);
            return;
        }
        if (indexOfPeriod != i11) {
            this.f5081x = this.f5081x.copyWithPeriodIndex(indexOfPeriod);
        }
        if (this.f5081x.f5101a.isAd()) {
            h.b bVarResolvePeriodPositionForAds3 = this.f5080w.resolvePeriodPositionForAds(indexOfPeriod, this.f5081x.f5103c);
            if (!bVarResolvePeriodPositionForAds3.isAd() || bVarResolvePeriodPositionForAds3.f20056c != this.f5081x.f5101a.f20056c) {
                this.f5081x = new b(bVarResolvePeriodPositionForAds3, s(bVarResolvePeriodPositionForAds3, this.f5081x.f5103c), bVarResolvePeriodPositionForAds3.isAd() ? this.f5081x.f5103c : -9223372036854775807L);
                i(0, obj);
                return;
            }
        }
        if (aVar3 == null) {
            i(0, obj);
            return;
        }
        while (true) {
            l.a updatedMediaPeriodInfo = this.f5080w.getUpdatedMediaPeriodInfo(aVar3.f5090g, indexOfPeriod);
            aVar3.f5090g = updatedMediaPeriodInfo;
            if (updatedMediaPeriodInfo.f5140f || (aVar2 = aVar3.f5093j) == null) {
                break;
            } else {
                aVar3 = aVar2;
            }
        }
        while (true) {
            aVar = aVar3.f5093j;
            if (aVar == null) {
                break;
            }
            indexOfPeriod = this.S.getNextPeriodIndex(indexOfPeriod, this.f5079v, this.f5078u, this.I);
            if (indexOfPeriod == -1 || !aVar.f5085b.equals(this.S.getPeriod(indexOfPeriod, this.f5079v, true).f5150b)) {
                break;
            }
            do {
                aVar3 = aVar;
                l.a updatedMediaPeriodInfo2 = this.f5080w.getUpdatedMediaPeriodInfo(aVar3.f5090g, indexOfPeriod);
                aVar3.f5090g = updatedMediaPeriodInfo2;
                if (!updatedMediaPeriodInfo2.f5140f) {
                    aVar = aVar3.f5093j;
                }
            } while (aVar != null);
        }
        a aVar4 = this.Q;
        if (aVar4 != null && aVar4.f5086c < aVar.f5086c) {
            this.P = aVar3;
            aVar3.f5093j = null;
            while (aVar != null) {
                aVar.release();
                aVar = aVar.f5093j;
            }
        } else {
            this.f5081x = new b(this.R.f5090g.f5135a, s(this.R.f5090g.f5135a, this.f5081x.f5104d), this.f5081x.f5103c);
        }
        i(0, obj);
    }

    public final boolean f(long j10) {
        a aVar;
        return j10 == -9223372036854775807L || this.f5081x.f5104d < j10 || ((aVar = this.R.f5093j) != null && (aVar.f5091h || aVar.f5090g.f5135a.isAd()));
    }

    public final void g() {
        boolean zShouldContinueLoading = this.P.shouldContinueLoading(this.O);
        u(zShouldContinueLoading);
        if (zShouldContinueLoading) {
            this.P.continueLoading(this.O);
        }
    }

    public final void h() throws IOException {
        a aVar = this.P;
        if (aVar == null || aVar.f5091h) {
            return;
        }
        a aVar2 = this.Q;
        if (aVar2 == null || aVar2.f5093j == aVar) {
            for (o oVar : this.C) {
                if (!oVar.hasReadStreamToEnd()) {
                    return;
                }
            }
            this.P.f5084a.maybeThrowPrepareError();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler = this.f5076s;
        try {
            switch (message.what) {
                case 0:
                    j((u5.h) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    v(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    r((c) message.obj);
                    return true;
                case 4:
                    w((m) message.obj);
                    return true;
                case 5:
                    A();
                    return true;
                case 6:
                    k();
                    return true;
                case 7:
                    e((Pair) message.obj);
                    return true;
                case 8:
                    c((u5.g) message.obj);
                    return true;
                case 9:
                    u5.g gVar = (u5.g) message.obj;
                    a aVar = this.P;
                    if (aVar != null && aVar.f5084a == gVar) {
                        g();
                    }
                    return true;
                case 10:
                    l();
                    return true;
                case 11:
                    t((d.b[]) message.obj);
                    return true;
                case 12:
                    y(message.arg1);
                    return true;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e10) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e10);
            handler.obtainMessage(8, e10).sendToTarget();
            A();
            return true;
        } catch (IOException e11) {
            Log.e("ExoPlayerImplInternal", "Source error.", e11);
            handler.obtainMessage(8, ExoPlaybackException.createForSource(e11)).sendToTarget();
            A();
            return true;
        } catch (RuntimeException e12) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e12);
            handler.obtainMessage(8, new ExoPlaybackException(e12)).sendToTarget();
            A();
            return true;
        }
    }

    public final void i(int i10, Object obj) {
        this.f5076s.obtainMessage(6, new d(this.S, obj, this.f5081x, i10)).sendToTarget();
    }

    public final void j(u5.h hVar, boolean z10) {
        this.f5076s.sendEmptyMessage(0);
        m(true);
        ((c5.c) this.f5072o).onPrepared();
        if (z10) {
            this.f5081x = new b(0, -9223372036854775807L);
        } else {
            b bVar = this.f5081x;
            this.f5081x = new b(bVar.f5101a, bVar.f5104d, this.f5081x.f5103c);
        }
        this.B = hVar;
        hVar.prepareSource(this.f5077t, true, this);
        z(2);
        this.f5074q.sendEmptyMessage(2);
    }

    public final void k() {
        m(true);
        ((c5.c) this.f5072o).onReleased();
        z(1);
        synchronized (this) {
            this.D = true;
            notifyAll();
        }
    }

    public final void l() throws ExoPlaybackException {
        a aVar = this.R;
        if (aVar == null) {
            return;
        }
        boolean z10 = true;
        while (aVar != null && aVar.f5091h) {
            if (aVar.selectTracks()) {
                if (z10) {
                    a aVar2 = this.Q;
                    a aVar3 = this.R;
                    boolean z11 = aVar2 != aVar3;
                    for (a aVar4 = aVar3.f5093j; aVar4 != null; aVar4 = aVar4.f5093j) {
                        aVar4.release();
                    }
                    a aVar5 = this.R;
                    aVar5.f5093j = null;
                    this.P = aVar5;
                    this.Q = aVar5;
                    boolean[] zArr = new boolean[this.f5069b.length];
                    long jUpdatePeriodTrackSelection = aVar5.updatePeriodTrackSelection(this.f5081x.f5104d, z11, zArr);
                    if (jUpdatePeriodTrackSelection != this.f5081x.f5104d) {
                        this.f5081x.f5104d = jUpdatePeriodTrackSelection;
                        n(jUpdatePeriodTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.f5069b.length];
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        o[] oVarArr = this.f5069b;
                        if (i10 >= oVarArr.length) {
                            break;
                        }
                        o oVar = oVarArr[i10];
                        boolean z12 = oVar.getState() != 0;
                        zArr2[i10] = z12;
                        u5.k kVar = this.R.f5087d[i10];
                        if (kVar != null) {
                            i11++;
                        }
                        if (z12) {
                            if (kVar != oVar.getStream()) {
                                if (oVar == this.f5083z) {
                                    if (kVar == null) {
                                        this.f5073p.synchronize(this.A);
                                    }
                                    this.A = null;
                                    this.f5083z = null;
                                }
                                if (oVar.getState() == 2) {
                                    oVar.stop();
                                }
                                oVar.disable();
                            } else if (zArr[i10]) {
                                oVar.resetPosition(this.O);
                            }
                        }
                        i10++;
                    }
                    this.f5076s.obtainMessage(3, aVar.f5094k).sendToTarget();
                    b(zArr2, i11);
                } else {
                    this.P = aVar;
                    for (a aVar6 = aVar.f5093j; aVar6 != null; aVar6 = aVar6.f5093j) {
                        aVar6.release();
                    }
                    a aVar7 = this.P;
                    aVar7.f5093j = null;
                    if (aVar7.f5091h) {
                        this.P.updatePeriodTrackSelection(Math.max(aVar7.f5090g.f5136b, aVar7.toPeriodTime(this.O)), false);
                    }
                }
                g();
                C();
                this.f5074q.sendEmptyMessage(2);
                return;
            }
            if (aVar == this.Q) {
                z10 = false;
            }
            aVar = aVar.f5093j;
        }
    }

    public final void m(boolean z10) {
        this.f5074q.removeMessages(2);
        this.F = false;
        this.f5073p.stop();
        this.A = null;
        this.f5083z = null;
        this.O = 60000000L;
        for (o oVar : this.C) {
            try {
                if (oVar.getState() == 2) {
                    oVar.stop();
                }
                oVar.disable();
            } catch (ExoPlaybackException e10) {
                e = e10;
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            } catch (RuntimeException e11) {
                e = e11;
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.C = new o[0];
        a aVar = this.R;
        if (aVar == null) {
            aVar = this.P;
        }
        while (aVar != null) {
            aVar.release();
            aVar = aVar.f5093j;
        }
        this.P = null;
        this.Q = null;
        this.R = null;
        u(false);
        if (z10) {
            u5.h hVar = this.B;
            if (hVar != null) {
                hVar.releaseSource();
                this.B = null;
            }
            this.f5080w.setTimeline(null);
            this.S = null;
        }
    }

    public final void n(long j10) throws ExoPlaybackException {
        a aVar = this.R;
        long rendererTime = aVar == null ? j10 + 60000000 : aVar.toRendererTime(j10);
        this.O = rendererTime;
        this.f5073p.setPositionUs(rendererTime);
        for (o oVar : this.C) {
            oVar.resetPosition(this.O);
        }
    }

    public final Pair<Integer, Long> o(c cVar) {
        r rVar = cVar.f5106a;
        if (rVar.isEmpty()) {
            rVar = this.S;
        }
        try {
            Pair<Integer, Long> periodPosition = rVar.getPeriodPosition(this.f5078u, this.f5079v, cVar.f5107b, cVar.f5108c);
            r rVar2 = this.S;
            if (rVar2 == rVar) {
                return periodPosition;
            }
            int iIntValue = ((Integer) periodPosition.first).intValue();
            r.b bVar = this.f5079v;
            int indexOfPeriod = rVar2.getIndexOfPeriod(rVar.getPeriod(iIntValue, bVar, true).f5150b);
            if (indexOfPeriod != -1) {
                return Pair.create(Integer.valueOf(indexOfPeriod), periodPosition.second);
            }
            int iP = p(((Integer) periodPosition.first).intValue(), rVar, this.S);
            if (iP == -1) {
                return null;
            }
            return this.S.getPeriodPosition(this.f5078u, this.f5079v, this.S.getPeriod(iP, bVar).f5151c, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalSeekPositionException(this.S, cVar.f5107b, cVar.f5108c);
        }
    }

    @Override // u5.g.a
    public void onPrepared(u5.g gVar) {
        this.f5074q.obtainMessage(8, gVar).sendToTarget();
    }

    public void onSourceInfoRefreshed(r rVar, Object obj) {
        this.f5074q.obtainMessage(7, Pair.create(rVar, obj)).sendToTarget();
    }

    public final int p(int i10, r rVar, r rVar2) {
        int periodCount = rVar.getPeriodCount();
        int indexOfPeriod = -1;
        for (int i11 = 0; i11 < periodCount && indexOfPeriod == -1; i11++) {
            int i12 = this.I;
            r.b bVar = this.f5079v;
            i10 = rVar.getNextPeriodIndex(i10, bVar, this.f5078u, i12);
            if (i10 == -1) {
                break;
            }
            indexOfPeriod = rVar2.getIndexOfPeriod(rVar.getPeriod(i10, bVar, true).f5150b);
        }
        return indexOfPeriod;
    }

    public void prepare(u5.h hVar, boolean z10) {
        this.f5074q.obtainMessage(0, z10 ? 1 : 0, 0, hVar).sendToTarget();
    }

    public final void q(long j10, long j11) {
        Handler handler = this.f5074q;
        handler.removeMessages(2);
        long jElapsedRealtime = (j10 + j11) - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            handler.sendEmptyMessage(2);
        } else {
            handler.sendEmptyMessageDelayed(2, jElapsedRealtime);
        }
    }

    public final void r(c cVar) throws ExoPlaybackException {
        int i10;
        long j10;
        if (this.S == null) {
            this.M++;
            this.N = cVar;
            return;
        }
        Pair<Integer, Long> pairO = o(cVar);
        if (pairO == null) {
            b bVar = new b(0, 0L);
            this.f5081x = bVar;
            this.f5076s.obtainMessage(4, 1, 0, bVar).sendToTarget();
            this.f5081x = new b(0, -9223372036854775807L);
            z(4);
            m(false);
            return;
        }
        int i11 = cVar.f5108c == -9223372036854775807L ? 1 : 0;
        int iIntValue = ((Integer) pairO.first).intValue();
        long jLongValue = ((Long) pairO.second).longValue();
        h.b bVarResolvePeriodPositionForAds = this.f5080w.resolvePeriodPositionForAds(iIntValue, jLongValue);
        if (bVarResolvePeriodPositionForAds.isAd()) {
            j10 = 0;
            i10 = 1;
        } else {
            i10 = i11;
            j10 = jLongValue;
        }
        try {
            if (bVarResolvePeriodPositionForAds.equals(this.f5081x.f5101a) && j10 / 1000 == this.f5081x.f5104d / 1000) {
                return;
            }
            long jS = s(bVarResolvePeriodPositionForAds, j10);
            int i12 = i10 | (j10 == jS ? 0 : 1);
            b bVar2 = new b(bVarResolvePeriodPositionForAds, jS, jLongValue);
            this.f5081x = bVar2;
            this.f5076s.obtainMessage(4, i12, 0, bVar2).sendToTarget();
        } finally {
            b bVar3 = new b(bVarResolvePeriodPositionForAds, j10, jLongValue);
            this.f5081x = bVar3;
            this.f5076s.obtainMessage(4, i10, 0, bVar3).sendToTarget();
        }
    }

    public synchronized void release() {
        if (this.D) {
            return;
        }
        this.f5074q.sendEmptyMessage(6);
        boolean z10 = false;
        while (!this.D) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        this.f5075r.quit();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long s(u5.h.b r11, long r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r10 = this;
            r10.B()
            r0 = 0
            r10.F = r0
            r1 = 2
            r10.z(r1)
            c5.g$a r2 = r10.R
            r3 = 0
            if (r2 != 0) goto L18
            c5.g$a r11 = r10.P
            if (r11 == 0) goto L16
            r11.release()
        L16:
            r4 = r3
            goto L58
        L18:
            r4 = r3
        L19:
            if (r2 == 0) goto L58
            if (r4 != 0) goto L52
            c5.l$a r5 = r2.f5090g
            u5.h$b r5 = r5.f5135a
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L4d
            boolean r5 = r2.f5091h
            if (r5 == 0) goto L4d
            c5.r r5 = r10.S
            c5.l$a r6 = r2.f5090g
            u5.h$b r6 = r6.f5135a
            int r6 = r6.f20054a
            c5.r$b r7 = r10.f5079v
            r5.getPeriod(r6, r7)
            int r5 = r7.getAdGroupIndexAfterPositionUs(r12)
            r6 = -1
            if (r5 == r6) goto L4b
            long r5 = r7.getAdGroupTimeUs(r5)
            c5.l$a r7 = r2.f5090g
            long r7 = r7.f5137c
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L4d
        L4b:
            r5 = 1
            goto L4e
        L4d:
            r5 = 0
        L4e:
            if (r5 == 0) goto L52
            r4 = r2
            goto L55
        L52:
            r2.release()
        L55:
            c5.g$a r2 = r2.f5093j
            goto L19
        L58:
            c5.g$a r11 = r10.R
            if (r11 != r4) goto L60
            c5.g$a r2 = r10.Q
            if (r11 == r2) goto L78
        L60:
            c5.o[] r11 = r10.C
            int r2 = r11.length
            r5 = 0
        L64:
            if (r5 >= r2) goto L6e
            r6 = r11[r5]
            r6.disable()
            int r5 = r5 + 1
            goto L64
        L6e:
            c5.o[] r11 = new c5.o[r0]
            r10.C = r11
            r10.A = r3
            r10.f5083z = r3
            r10.R = r3
        L78:
            if (r4 == 0) goto L97
            r4.f5093j = r3
            r10.P = r4
            r10.Q = r4
            r10.x(r4)
            c5.g$a r11 = r10.R
            boolean r0 = r11.f5092i
            if (r0 == 0) goto L90
            u5.g r11 = r11.f5084a
            long r11 = r11.seekToUs(r12)
            r12 = r11
        L90:
            r10.n(r12)
            r10.g()
            goto La0
        L97:
            r10.P = r3
            r10.Q = r3
            r10.R = r3
            r10.n(r12)
        La0:
            android.os.Handler r11 = r10.f5074q
            r11.sendEmptyMessage(r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.g.s(u5.h$b, long):long");
    }

    public void seekTo(r rVar, int i10, long j10) {
        this.f5074q.obtainMessage(3, new c(rVar, i10, j10)).sendToTarget();
    }

    public void sendMessages(d.b... bVarArr) {
        if (this.D) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.J++;
            this.f5074q.obtainMessage(11, bVarArr).sendToTarget();
        }
    }

    public void setPlayWhenReady(boolean z10) {
        this.f5074q.obtainMessage(1, z10 ? 1 : 0, 0).sendToTarget();
    }

    public void stop() {
        this.f5074q.sendEmptyMessage(5);
    }

    public final void t(d.b[] bVarArr) throws ExoPlaybackException {
        try {
            for (d.b bVar : bVarArr) {
                bVar.f5043a.handleMessage(bVar.f5044b, bVar.f5045c);
            }
            int i10 = this.H;
            if (i10 == 3 || i10 == 2) {
                this.f5074q.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.K++;
                notifyAll();
            }
        } catch (Throwable th2) {
            synchronized (this) {
                this.K++;
                notifyAll();
                throw th2;
            }
        }
    }

    public final void u(boolean z10) {
        if (this.G != z10) {
            this.G = z10;
            this.f5076s.obtainMessage(2, z10 ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void v(boolean z10) throws ExoPlaybackException {
        this.F = false;
        this.E = z10;
        if (!z10) {
            B();
            C();
            return;
        }
        int i10 = this.H;
        Handler handler = this.f5074q;
        if (i10 != 3) {
            if (i10 == 2) {
                handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.F = false;
        this.f5073p.start();
        for (o oVar : this.C) {
            oVar.start();
        }
        handler.sendEmptyMessage(2);
    }

    public final void w(m mVar) {
        l6.h hVar = this.A;
        m playbackParameters = hVar != null ? hVar.setPlaybackParameters(mVar) : this.f5073p.setPlaybackParameters(mVar);
        this.f5082y = playbackParameters;
        this.f5076s.obtainMessage(7, playbackParameters).sendToTarget();
    }

    public final void x(a aVar) throws ExoPlaybackException {
        if (this.R == aVar) {
            return;
        }
        o[] oVarArr = this.f5069b;
        boolean[] zArr = new boolean[oVarArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < oVarArr.length; i11++) {
            o oVar = oVarArr[i11];
            zArr[i11] = oVar.getState() != 0;
            j6.f fVar = aVar.f5094k.f14669b.get(i11);
            if (fVar != null) {
                i10++;
            }
            if (zArr[i11] && (fVar == null || (oVar.isCurrentStreamFinal() && oVar.getStream() == this.R.f5087d[i11]))) {
                if (oVar == this.f5083z) {
                    this.f5073p.synchronize(this.A);
                    this.A = null;
                    this.f5083z = null;
                }
                if (oVar.getState() == 2) {
                    oVar.stop();
                }
                oVar.disable();
            }
        }
        this.R = aVar;
        this.f5076s.obtainMessage(3, aVar.f5094k).sendToTarget();
        b(zArr, i10);
    }

    public final void y(int i10) throws ExoPlaybackException {
        a aVar;
        a aVar2;
        this.I = i10;
        this.f5080w.setRepeatMode(i10);
        a aVar3 = this.R;
        if (aVar3 == null) {
            aVar3 = this.P;
        }
        if (aVar3 == null) {
            return;
        }
        while (true) {
            int nextPeriodIndex = this.S.getNextPeriodIndex(aVar3.f5090g.f5135a.f20054a, this.f5079v, this.f5078u, i10);
            while (true) {
                aVar = aVar3.f5093j;
                if (aVar == null || aVar3.f5090g.f5140f) {
                    break;
                } else {
                    aVar3 = aVar;
                }
            }
            if (nextPeriodIndex == -1 || aVar == null || aVar.f5090g.f5135a.f20054a != nextPeriodIndex) {
                break;
            } else {
                aVar3 = aVar;
            }
        }
        int i11 = this.P.f5086c;
        a aVar4 = this.Q;
        int i12 = aVar4 != null ? aVar4.f5086c : -1;
        if (aVar != null) {
            while (aVar != null) {
                aVar.release();
                aVar = aVar.f5093j;
            }
            aVar3.f5093j = null;
        }
        aVar3.f5090g = this.f5080w.getUpdatedMediaPeriodInfo(aVar3.f5090g);
        int i13 = aVar3.f5086c;
        boolean z10 = false;
        if (!(i11 <= i13)) {
            this.P = aVar3;
        }
        if (i12 != -1 && i12 <= i13) {
            z10 = true;
        }
        if (z10 || (aVar2 = this.R) == null) {
            return;
        }
        h.b bVar = aVar2.f5090g.f5135a;
        this.f5081x = new b(bVar, s(bVar, this.f5081x.f5104d), this.f5081x.f5103c);
    }

    public final void z(int i10) {
        if (this.H != i10) {
            this.H = i10;
            this.f5076s.obtainMessage(1, i10, 0).sendToTarget();
        }
    }

    @Override // u5.l.a
    public void onContinueLoadingRequested(u5.g gVar) {
        this.f5074q.obtainMessage(9, gVar).sendToTarget();
    }
}
