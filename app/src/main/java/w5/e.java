package w5;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import c5.r;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import k6.d;
import k6.m;
import l6.u;
import u5.a;
import u5.h;
import w5.a;
import x5.k;

/* compiled from: DashMediaSource.java */
/* loaded from: classes.dex */
public final class e implements u5.h {
    public m A;
    public Uri B;
    public long C;
    public long D;
    public x5.b E;
    public Handler F;
    public long G;
    public int H;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20976b;

    /* renamed from: m, reason: collision with root package name */
    public final d.a f20977m;

    /* renamed from: n, reason: collision with root package name */
    public final a.InterfaceC0304a f20978n;

    /* renamed from: o, reason: collision with root package name */
    public final int f20979o;

    /* renamed from: p, reason: collision with root package name */
    public final long f20980p;

    /* renamed from: q, reason: collision with root package name */
    public final a.C0284a f20981q;

    /* renamed from: r, reason: collision with root package name */
    public final a.InterfaceC0074a<? extends x5.b> f20982r;

    /* renamed from: s, reason: collision with root package name */
    public final c f20983s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f20984t;

    /* renamed from: u, reason: collision with root package name */
    public final SparseArray<w5.b> f20985u;

    /* renamed from: v, reason: collision with root package name */
    public final w5.c f20986v;

    /* renamed from: w, reason: collision with root package name */
    public final w5.d f20987w;

    /* renamed from: x, reason: collision with root package name */
    public h.a f20988x;

    /* renamed from: y, reason: collision with root package name */
    public k6.d f20989y;

    /* renamed from: z, reason: collision with root package name */
    public Loader f20990z;

    /* compiled from: DashMediaSource.java */
    public static final class a extends r {

        /* renamed from: b, reason: collision with root package name */
        public final long f20991b;

        /* renamed from: c, reason: collision with root package name */
        public final long f20992c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20993d;

        /* renamed from: e, reason: collision with root package name */
        public final long f20994e;

        /* renamed from: f, reason: collision with root package name */
        public final long f20995f;

        /* renamed from: g, reason: collision with root package name */
        public final long f20996g;

        /* renamed from: h, reason: collision with root package name */
        public final x5.b f20997h;

        public a(long j10, long j11, int i10, long j12, long j13, long j14, x5.b bVar) {
            this.f20991b = j10;
            this.f20992c = j11;
            this.f20993d = i10;
            this.f20994e = j12;
            this.f20995f = j13;
            this.f20996g = j14;
            this.f20997h = bVar;
        }

        @Override // c5.r
        public int getIndexOfPeriod(Object obj) {
            int iIntValue;
            int i10;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue()) >= (i10 = this.f20993d) && iIntValue < getPeriodCount() + i10) {
                return iIntValue - i10;
            }
            return -1;
        }

        @Override // c5.r
        public r.b getPeriod(int i10, r.b bVar, boolean z10) {
            x5.b bVar2 = this.f20997h;
            l6.a.checkIndex(i10, 0, bVar2.getPeriodCount());
            return bVar.set(z10 ? bVar2.getPeriod(i10).f21584a : null, z10 ? Integer.valueOf(l6.a.checkIndex(i10, 0, bVar2.getPeriodCount()) + this.f20993d) : null, 0, bVar2.getPeriodDurationUs(i10), c5.b.msToUs(bVar2.getPeriod(i10).f21585b - bVar2.getPeriod(0).f21585b) - this.f20994e);
        }

        @Override // c5.r
        public int getPeriodCount() {
            return this.f20997h.getPeriodCount();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[PHI: r5
  0x0027: PHI (r5v1 long) = (r5v0 long), (r5v3 long) binds: [B:6:0x0017, B:8:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // c5.r
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c5.r.c getWindow(int r24, c5.r.c r25, boolean r26, long r27) {
            /*
                r23 = this;
                r0 = r23
                r1 = 0
                r2 = 1
                r3 = r24
                l6.a.checkIndex(r3, r1, r2)
                x5.b r3 = r0.f20997h
                boolean r4 = r3.f21564c
                long r5 = r0.f20996g
                if (r4 != 0) goto L13
            L11:
                r15 = r5
                goto L78
            L13:
                r7 = 0
                int r4 = (r27 > r7 ? 1 : (r27 == r7 ? 0 : -1))
                if (r4 <= 0) goto L27
                long r5 = r5 + r27
                long r7 = r0.f20995f
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 <= 0) goto L27
                r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                goto L11
            L27:
                long r7 = r0.f20994e
                long r7 = r7 + r5
                long r9 = r3.getPeriodDurationUs(r1)
                r4 = 0
            L2f:
                int r11 = r3.getPeriodCount()
                r12 = -1
                int r11 = r11 + r12
                if (r4 >= r11) goto L43
                int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r11 < 0) goto L43
                long r7 = r7 - r9
                int r4 = r4 + 1
                long r9 = r3.getPeriodDurationUs(r4)
                goto L2f
            L43:
                x5.e r4 = r3.getPeriod(r4)
                r11 = 2
                int r11 = r4.getAdaptationSetIndex(r11)
                if (r11 != r12) goto L4f
                goto L11
            L4f:
                java.util.List<x5.a> r4 = r4.f21586c
                java.lang.Object r4 = r4.get(r11)
                x5.a r4 = (x5.a) r4
                java.util.List<x5.g> r4 = r4.f21559c
                java.lang.Object r1 = r4.get(r1)
                x5.g r1 = (x5.g) r1
                w5.f r1 = r1.getIndex()
                if (r1 == 0) goto L11
                int r4 = r1.getSegmentCount(r9)
                if (r4 != 0) goto L6c
                goto L11
            L6c:
                int r4 = r1.getSegmentNum(r7, r9)
                long r9 = r1.getTimeUs(r4)
                long r9 = r9 + r5
                long r5 = r9 - r7
                goto L11
            L78:
                r8 = 0
                long r9 = r0.f20991b
                long r11 = r0.f20992c
                r13 = 1
                boolean r14 = r3.f21564c
                long r4 = r0.f20995f
                r19 = 0
                int r1 = r3.getPeriodCount()
                int r20 = r1 + (-1)
                long r1 = r0.f20994e
                r7 = r25
                r17 = r4
                r21 = r1
                c5.r$c r1 = r7.set(r8, r9, r11, r13, r14, r15, r17, r19, r20, r21)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: w5.e.a.getWindow(int, c5.r$c, boolean, long):c5.r$c");
        }

        @Override // c5.r
        public int getWindowCount() {
            return 1;
        }
    }

    /* compiled from: DashMediaSource.java */
    public static final class b implements a.InterfaceC0074a<Long> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0074a
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(line).getTime());
            } catch (ParseException e10) {
                throw new ParserException(e10);
            }
        }
    }

    /* compiled from: DashMediaSource.java */
    public final class c implements Loader.a<com.google.android.exoplayer2.upstream.a<x5.b>> {
        public c() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.a<x5.b> aVar, long j10, long j11, boolean z10) {
            e.this.f20981q.loadCanceled(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded());
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.a<x5.b> aVar, long j10, long j11) {
            e eVar = e.this;
            eVar.f20981q.loadCompleted(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded());
            x5.b result = aVar.getResult();
            x5.b bVar = eVar.E;
            int i10 = 0;
            int periodCount = bVar == null ? 0 : bVar.getPeriodCount();
            long j12 = result.getPeriod(0).f21585b;
            while (i10 < periodCount && eVar.E.getPeriod(i10).f21585b < j12) {
                i10++;
            }
            if (periodCount - i10 > result.getPeriodCount()) {
                Log.w("DashMediaSource", "Out of sync manifest");
                eVar.b();
                return;
            }
            eVar.E = result;
            eVar.C = j10 - j11;
            eVar.D = j10;
            if (result.f21569h != null) {
                synchronized (eVar.f20984t) {
                    if (aVar.f6042a.f14959a == eVar.B) {
                        eVar.B = eVar.E.f21569h;
                    }
                }
            }
            if (periodCount != 0) {
                eVar.H += i10;
                eVar.a(true);
                return;
            }
            k kVar = eVar.E.f21568g;
            if (kVar == null) {
                eVar.a(true);
                return;
            }
            String str = kVar.f21618a;
            if (u.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || u.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
                try {
                    eVar.G = u.parseXsDateTime(kVar.f21619b) - eVar.D;
                    eVar.a(true);
                    return;
                } catch (ParserException e10) {
                    Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", e10);
                    eVar.a(true);
                    return;
                }
            }
            if (u.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || u.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                com.google.android.exoplayer2.upstream.a aVar2 = new com.google.android.exoplayer2.upstream.a(eVar.f20989y, Uri.parse(kVar.f21619b), 5, new b());
                eVar.f20981q.loadStarted(aVar2.f6042a, aVar2.f6043b, eVar.f20990z.startLoading(aVar2, eVar.new C0305e(), 1));
            } else if (u.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || u.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                com.google.android.exoplayer2.upstream.a aVar3 = new com.google.android.exoplayer2.upstream.a(eVar.f20989y, Uri.parse(kVar.f21619b), 5, new f());
                eVar.f20981q.loadStarted(aVar3.f6042a, aVar3.f6043b, eVar.f20990z.startLoading(aVar3, eVar.new C0305e(), 1));
            } else {
                Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", new IOException("Unsupported UTC timing scheme"));
                eVar.a(true);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public int onLoadError(com.google.android.exoplayer2.upstream.a<x5.b> aVar, long j10, long j11, IOException iOException) {
            e eVar = e.this;
            eVar.getClass();
            boolean z10 = iOException instanceof ParserException;
            eVar.f20981q.loadError(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded(), iOException, z10);
            return z10 ? 3 : 0;
        }
    }

    /* compiled from: DashMediaSource.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f20999a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21000b;

        /* renamed from: c, reason: collision with root package name */
        public final long f21001c;

        public d(boolean z10, long j10, long j11) {
            this.f20999a = z10;
            this.f21000b = j10;
            this.f21001c = j11;
        }

        public static d createPeriodSeekInfo(x5.e eVar, long j10) {
            int i10;
            x5.e eVar2 = eVar;
            int size = eVar2.f21586c.size();
            long jMin = Long.MAX_VALUE;
            int i11 = 0;
            boolean z10 = false;
            boolean zIsExplicit = false;
            long jMax = 0;
            while (i11 < size) {
                w5.f index = eVar2.f21586c.get(i11).f21559c.get(0).getIndex();
                if (index == null) {
                    return new d(true, 0L, j10);
                }
                zIsExplicit |= index.isExplicit();
                int segmentCount = index.getSegmentCount(j10);
                if (segmentCount == 0) {
                    i10 = size;
                    z10 = true;
                    jMax = 0;
                    jMin = 0;
                } else if (z10) {
                    i10 = size;
                } else {
                    int firstSegmentNum = index.getFirstSegmentNum();
                    i10 = size;
                    jMax = Math.max(jMax, index.getTimeUs(firstSegmentNum));
                    if (segmentCount != -1) {
                        int i12 = (firstSegmentNum + segmentCount) - 1;
                        jMin = Math.min(jMin, index.getTimeUs(i12) + index.getDurationUs(i12, j10));
                    }
                }
                i11++;
                eVar2 = eVar;
                size = i10;
            }
            return new d(zIsExplicit, jMax, jMin);
        }
    }

    /* compiled from: DashMediaSource.java */
    /* renamed from: w5.e$e, reason: collision with other inner class name */
    public final class C0305e implements Loader.a<com.google.android.exoplayer2.upstream.a<Long>> {
        public C0305e() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.a<Long> aVar, long j10, long j11, boolean z10) {
            e.this.f20981q.loadCanceled(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded());
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.a<Long> aVar, long j10, long j11) {
            e eVar = e.this;
            eVar.f20981q.loadCompleted(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded());
            eVar.G = aVar.getResult().longValue() - j10;
            eVar.a(true);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public int onLoadError(com.google.android.exoplayer2.upstream.a<Long> aVar, long j10, long j11, IOException iOException) {
            e eVar = e.this;
            eVar.f20981q.loadError(aVar.f6042a, aVar.f6043b, j10, j11, aVar.bytesLoaded(), iOException, true);
            Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
            eVar.a(true);
            return 2;
        }
    }

    /* compiled from: DashMediaSource.java */
    public static final class f implements a.InterfaceC0074a<Long> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0074a
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(u.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        c5.h.registerModule("goog.exo.dash");
    }

    public e(Uri uri, d.a aVar, a.InterfaceC0304a interfaceC0304a, Handler handler, u5.a aVar2) {
        this(uri, aVar, interfaceC0304a, 3, -1L, handler, aVar2);
    }

    public final void a(boolean z10) {
        long j10;
        boolean z11;
        int i10 = 0;
        while (true) {
            SparseArray<w5.b> sparseArray = this.f20985u;
            if (i10 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i10);
            if (iKeyAt >= this.H) {
                sparseArray.valueAt(i10).updateManifest(this.E, iKeyAt - this.H);
            }
            i10++;
        }
        int periodCount = this.E.getPeriodCount() - 1;
        d dVarCreatePeriodSeekInfo = d.createPeriodSeekInfo(this.E.getPeriod(0), this.E.getPeriodDurationUs(0));
        d dVarCreatePeriodSeekInfo2 = d.createPeriodSeekInfo(this.E.getPeriod(periodCount), this.E.getPeriodDurationUs(periodCount));
        long jMax = dVarCreatePeriodSeekInfo.f21000b;
        long jMin = dVarCreatePeriodSeekInfo2.f21001c;
        long jMsToUs = 0;
        if (!this.E.f21564c || dVarCreatePeriodSeekInfo2.f20999a) {
            j10 = jMax;
            z11 = false;
        } else {
            jMin = Math.min(((this.G != 0 ? c5.b.msToUs(SystemClock.elapsedRealtime() + this.G) : c5.b.msToUs(System.currentTimeMillis())) - c5.b.msToUs(this.E.f21562a)) - c5.b.msToUs(this.E.getPeriod(periodCount).f21585b), jMin);
            long j11 = this.E.f21566e;
            if (j11 != -9223372036854775807L) {
                long jMsToUs2 = jMin - c5.b.msToUs(j11);
                while (jMsToUs2 < 0 && periodCount > 0) {
                    periodCount--;
                    jMsToUs2 += this.E.getPeriodDurationUs(periodCount);
                }
                jMax = periodCount == 0 ? Math.max(jMax, jMsToUs2) : this.E.getPeriodDurationUs(0);
            }
            j10 = jMax;
            z11 = true;
        }
        long periodDurationUs = jMin - j10;
        for (int i11 = 0; i11 < this.E.getPeriodCount() - 1; i11++) {
            periodDurationUs = this.E.getPeriodDurationUs(i11) + periodDurationUs;
        }
        x5.b bVar = this.E;
        if (bVar.f21564c) {
            long j12 = this.f20980p;
            if (j12 == -1) {
                long j13 = bVar.f21567f;
                if (j13 == -9223372036854775807L) {
                    j13 = 30000;
                }
                j12 = j13;
            }
            jMsToUs = periodDurationUs - c5.b.msToUs(j12);
            if (jMsToUs < 5000000) {
                jMsToUs = Math.min(5000000L, periodDurationUs / 2);
            }
        }
        x5.b bVar2 = this.E;
        long jUsToMs = c5.b.usToMs(j10) + bVar2.f21562a + bVar2.getPeriod(0).f21585b;
        x5.b bVar3 = this.E;
        ((c5.g) this.f20988x).onSourceInfoRefreshed(new a(bVar3.f21562a, jUsToMs, this.H, j10, periodDurationUs, jMsToUs, bVar3), this.E);
        if (this.f20976b) {
            return;
        }
        Handler handler = this.F;
        w5.d dVar = this.f20987w;
        handler.removeCallbacks(dVar);
        if (z11) {
            this.F.postDelayed(dVar, 5000L);
        }
        if (z10) {
            b();
        }
    }

    public final void b() {
        x5.b bVar = this.E;
        if (bVar.f21564c) {
            long j10 = bVar.f21565d;
            if (j10 == 0) {
                j10 = 5000;
            }
            this.F.postDelayed(this.f20986v, Math.max(0L, (this.C + j10) - SystemClock.elapsedRealtime()));
        }
    }

    @Override // u5.h
    public u5.g createPeriod(h.b bVar, k6.b bVar2) {
        int i10 = bVar.f20054a;
        w5.b bVar3 = new w5.b(this.H + i10, this.E, i10, this.f20978n, this.f20979o, this.f20981q.copyWithMediaTimeOffsetMs(this.E.getPeriod(i10).f21585b), this.G, this.A, bVar2);
        this.f20985u.put(bVar3.f20953b, bVar3);
        return bVar3;
    }

    @Override // u5.h
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.A.maybeThrowError();
    }

    @Override // u5.h
    public void prepareSource(c5.d dVar, boolean z10, h.a aVar) {
        Uri uri;
        this.f20988x = aVar;
        if (this.f20976b) {
            this.A = new m.a();
            a(false);
            return;
        }
        this.f20989y = this.f20977m.createDataSource();
        Loader loader = new Loader("Loader:DashMediaSource");
        this.f20990z = loader;
        this.A = loader;
        this.F = new Handler();
        synchronized (this.f20984t) {
            uri = this.B;
        }
        com.google.android.exoplayer2.upstream.a aVar2 = new com.google.android.exoplayer2.upstream.a(this.f20989y, uri, 4, this.f20982r);
        long jStartLoading = this.f20990z.startLoading(aVar2, this.f20983s, this.f20979o);
        this.f20981q.loadStarted(aVar2.f6042a, aVar2.f6043b, jStartLoading);
    }

    @Override // u5.h
    public void releasePeriod(u5.g gVar) {
        w5.b bVar = (w5.b) gVar;
        bVar.release();
        this.f20985u.remove(bVar.f20953b);
    }

    @Override // u5.h
    public void releaseSource() {
        this.f20989y = null;
        this.A = null;
        Loader loader = this.f20990z;
        if (loader != null) {
            loader.release();
            this.f20990z = null;
        }
        this.C = 0L;
        this.D = 0L;
        this.E = null;
        Handler handler = this.F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.F = null;
        }
        this.G = 0L;
        this.f20985u.clear();
    }

    public e(Uri uri, d.a aVar, a.InterfaceC0304a interfaceC0304a, int i10, long j10, Handler handler, u5.a aVar2) {
        this(uri, aVar, new x5.c(), interfaceC0304a, i10, j10, handler, aVar2);
    }

    public e(Uri uri, d.a aVar, a.InterfaceC0074a<? extends x5.b> interfaceC0074a, a.InterfaceC0304a interfaceC0304a, int i10, long j10, Handler handler, u5.a aVar2) {
        this.E = null;
        this.B = uri;
        this.f20977m = aVar;
        this.f20982r = interfaceC0074a;
        this.f20978n = interfaceC0304a;
        this.f20979o = i10;
        this.f20980p = j10;
        this.f20976b = false;
        this.f20981q = new a.C0284a(handler, aVar2);
        this.f20984t = new Object();
        this.f20985u = new SparseArray<>();
        this.f20983s = new c();
        this.f20986v = new w5.c(this);
        this.f20987w = new w5.d(this);
    }
}
