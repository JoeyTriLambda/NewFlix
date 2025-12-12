package u5;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import l6.u;
import u5.f;
import u5.g;
import u5.j;

/* compiled from: ExtractorMediaPeriod.java */
/* loaded from: classes.dex */
public final class e implements g, g5.g, Loader.a<c>, Loader.d, j.b {
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public o H;
    public long I;
    public boolean[] J;
    public boolean[] K;
    public boolean L;
    public long N;
    public int P;
    public boolean Q;
    public boolean R;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f20012b;

    /* renamed from: m, reason: collision with root package name */
    public final k6.d f20013m;

    /* renamed from: n, reason: collision with root package name */
    public final int f20014n;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC0285e f20015o;

    /* renamed from: p, reason: collision with root package name */
    public final k6.b f20016p;

    /* renamed from: q, reason: collision with root package name */
    public final String f20017q;

    /* renamed from: r, reason: collision with root package name */
    public final long f20018r;

    /* renamed from: t, reason: collision with root package name */
    public final d f20020t;

    /* renamed from: y, reason: collision with root package name */
    public g.a f20025y;

    /* renamed from: z, reason: collision with root package name */
    public g5.l f20026z;

    /* renamed from: s, reason: collision with root package name */
    public final Loader f20019s = new Loader("Loader:ExtractorMediaPeriod");

    /* renamed from: u, reason: collision with root package name */
    public final l6.e f20021u = new l6.e();

    /* renamed from: v, reason: collision with root package name */
    public final a f20022v = new a();

    /* renamed from: w, reason: collision with root package name */
    public final b f20023w = new b();

    /* renamed from: x, reason: collision with root package name */
    public final Handler f20024x = new Handler();
    public int[] B = new int[0];
    public j[] A = new j[0];
    public long O = -9223372036854775807L;
    public long M = -1;

    /* compiled from: ExtractorMediaPeriod.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.R || eVar.D || eVar.f20026z == null || !eVar.C) {
                return;
            }
            for (j jVar : eVar.A) {
                if (jVar.getUpstreamFormat() == null) {
                    return;
                }
            }
            eVar.f20021u.close();
            int length = eVar.A.length;
            n[] nVarArr = new n[length];
            eVar.K = new boolean[length];
            eVar.J = new boolean[length];
            eVar.I = eVar.f20026z.getDurationUs();
            int i10 = 0;
            while (true) {
                boolean z10 = true;
                if (i10 >= length) {
                    eVar.H = new o(nVarArr);
                    eVar.D = true;
                    ((u5.f) eVar.f20015o).onSourceInfoRefreshed(eVar.I, eVar.f20026z.isSeekable());
                    eVar.f20025y.onPrepared(eVar);
                    return;
                }
                c5.i upstreamFormat = eVar.A[i10].getUpstreamFormat();
                nVarArr[i10] = new n(upstreamFormat);
                String str = upstreamFormat.f5120q;
                if (!l6.i.isVideo(str) && !l6.i.isAudio(str)) {
                    z10 = false;
                }
                eVar.K[i10] = z10;
                eVar.L = z10 | eVar.L;
                i10++;
            }
        }
    }

    /* compiled from: ExtractorMediaPeriod.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.R) {
                return;
            }
            eVar.f20025y.onContinueLoadingRequested(eVar);
        }
    }

    /* compiled from: ExtractorMediaPeriod.java */
    public final class c implements Loader.c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f20029a;

        /* renamed from: b, reason: collision with root package name */
        public final k6.d f20030b;

        /* renamed from: c, reason: collision with root package name */
        public final d f20031c;

        /* renamed from: d, reason: collision with root package name */
        public final l6.e f20032d;

        /* renamed from: f, reason: collision with root package name */
        public volatile boolean f20034f;

        /* renamed from: h, reason: collision with root package name */
        public long f20036h;

        /* renamed from: e, reason: collision with root package name */
        public final g5.k f20033e = new g5.k();

        /* renamed from: g, reason: collision with root package name */
        public boolean f20035g = true;

        /* renamed from: i, reason: collision with root package name */
        public long f20037i = -1;

        public c(Uri uri, k6.d dVar, d dVar2, l6.e eVar) {
            this.f20029a = (Uri) l6.a.checkNotNull(uri);
            this.f20030b = (k6.d) l6.a.checkNotNull(dVar);
            this.f20031c = (d) l6.a.checkNotNull(dVar2);
            this.f20032d = eVar;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.f20034f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean isLoadCanceled() {
            return this.f20034f;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws Throwable {
            g5.b bVar;
            long position;
            int i10 = 0;
            while (i10 == 0 && !this.f20034f) {
                try {
                    position = this.f20033e.f12726a;
                    long jOpen = this.f20030b.open(new k6.f(this.f20029a, position, -1L, e.this.f20017q));
                    this.f20037i = jOpen;
                    if (jOpen != -1) {
                        this.f20037i = jOpen + position;
                    }
                    bVar = new g5.b(this.f20030b, position, this.f20037i);
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                }
                try {
                    g5.e eVarSelectExtractor = this.f20031c.selectExtractor(bVar, this.f20030b.getUri());
                    if (this.f20035g) {
                        eVarSelectExtractor.seek(position, this.f20036h);
                        this.f20035g = false;
                    }
                    while (i10 == 0 && !this.f20034f) {
                        this.f20032d.block();
                        i10 = eVarSelectExtractor.read(bVar, this.f20033e);
                        if (bVar.getPosition() > e.this.f20018r + position) {
                            position = bVar.getPosition();
                            this.f20032d.close();
                            e eVar = e.this;
                            eVar.f20024x.post(eVar.f20023w);
                        }
                    }
                    if (i10 == 1) {
                        i10 = 0;
                    } else {
                        this.f20033e.f12726a = bVar.getPosition();
                    }
                    u.closeQuietly(this.f20030b);
                } catch (Throwable th3) {
                    th = th3;
                    if (i10 != 1 && bVar != null) {
                        this.f20033e.f12726a = bVar.getPosition();
                    }
                    u.closeQuietly(this.f20030b);
                    throw th;
                }
            }
        }

        public void setLoadPosition(long j10, long j11) {
            this.f20033e.f12726a = j10;
            this.f20036h = j11;
            this.f20035g = true;
        }
    }

    /* compiled from: ExtractorMediaPeriod.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final g5.e[] f20039a;

        /* renamed from: b, reason: collision with root package name */
        public final g5.g f20040b;

        /* renamed from: c, reason: collision with root package name */
        public g5.e f20041c;

        public d(g5.e[] eVarArr, g5.g gVar) {
            this.f20039a = eVarArr;
            this.f20040b = gVar;
        }

        public void release() {
            g5.e eVar = this.f20041c;
            if (eVar != null) {
                eVar.release();
                this.f20041c = null;
            }
        }

        public g5.e selectExtractor(g5.f fVar, Uri uri) throws InterruptedException, IOException {
            g5.e eVar = this.f20041c;
            if (eVar != null) {
                return eVar;
            }
            g5.e[] eVarArr = this.f20039a;
            int length = eVarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                g5.e eVar2 = eVarArr[i10];
                try {
                } catch (EOFException unused) {
                } catch (Throwable th2) {
                    ((g5.b) fVar).resetPeekPosition();
                    throw th2;
                }
                if (eVar2.sniff(fVar)) {
                    this.f20041c = eVar2;
                    ((g5.b) fVar).resetPeekPosition();
                    break;
                }
                continue;
                ((g5.b) fVar).resetPeekPosition();
                i10++;
            }
            g5.e eVar3 = this.f20041c;
            if (eVar3 == null) {
                throw new UnrecognizedInputFormatException(ac.c.o(new StringBuilder("None of the available extractors ("), u.getCommaDelimitedSimpleClassNames(eVarArr), ") could read the stream."), uri);
            }
            eVar3.init(this.f20040b);
            return this.f20041c;
        }
    }

    /* compiled from: ExtractorMediaPeriod.java */
    /* renamed from: u5.e$e, reason: collision with other inner class name */
    public interface InterfaceC0285e {
    }

    /* compiled from: ExtractorMediaPeriod.java */
    public final class f implements k {

        /* renamed from: b, reason: collision with root package name */
        public final int f20042b;

        public f(int i10) {
            this.f20042b = i10;
        }

        @Override // u5.k
        public boolean isReady() {
            e eVar = e.this;
            return eVar.Q || (!eVar.b() && eVar.A[this.f20042b].hasNextSample());
        }

        @Override // u5.k
        public void maybeThrowError() throws IOException {
            e.this.f20019s.maybeThrowError();
        }

        @Override // u5.k
        public int readData(c5.j jVar, e5.e eVar, boolean z10) {
            e eVar2 = e.this;
            if (eVar2.F || eVar2.b()) {
                return -3;
            }
            return eVar2.A[this.f20042b].read(jVar, eVar, z10, eVar2.Q, eVar2.N);
        }

        @Override // u5.k
        public void skipData(long j10) {
            e eVar = e.this;
            j jVar = eVar.A[this.f20042b];
            if (!eVar.Q || j10 <= jVar.getLargestQueuedTimestampUs()) {
                jVar.advanceTo(j10, true, true);
            } else {
                jVar.advanceToEnd();
            }
        }
    }

    public e(Uri uri, k6.d dVar, g5.e[] eVarArr, int i10, Handler handler, f.a aVar, InterfaceC0285e interfaceC0285e, k6.b bVar, String str, int i11) {
        this.f20012b = uri;
        this.f20013m = dVar;
        this.f20014n = i10;
        this.f20015o = interfaceC0285e;
        this.f20016p = bVar;
        this.f20017q = str;
        this.f20018r = i11;
        this.f20020t = new d(eVarArr, this);
    }

    public final int a() {
        int writeIndex = 0;
        for (j jVar : this.A) {
            writeIndex += jVar.getWriteIndex();
        }
        return writeIndex;
    }

    public final boolean b() {
        return this.O != -9223372036854775807L;
    }

    public final void c() {
        g5.l lVar;
        c cVar = new c(this.f20012b, this.f20013m, this.f20020t, this.f20021u);
        if (this.D) {
            l6.a.checkState(b());
            long j10 = this.I;
            if (j10 != -9223372036854775807L && this.O >= j10) {
                this.Q = true;
                this.O = -9223372036854775807L;
                return;
            } else {
                cVar.setLoadPosition(this.f20026z.getPosition(this.O), this.O);
                this.O = -9223372036854775807L;
            }
        }
        this.P = a();
        int i10 = this.f20014n;
        if (i10 == -1) {
            i10 = (this.D && this.M == -1 && ((lVar = this.f20026z) == null || lVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.f20019s.startLoading(cVar, this, i10);
    }

    @Override // u5.g, u5.l
    public boolean continueLoading(long j10) {
        if (this.Q) {
            return false;
        }
        if (this.D && this.G == 0) {
            return false;
        }
        boolean zOpen = this.f20021u.open();
        if (this.f20019s.isLoading()) {
            return zOpen;
        }
        c();
        return true;
    }

    @Override // u5.g
    public void discardBuffer(long j10) {
        int length = this.A.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.A[i10].discardTo(j10, false, this.J[i10]);
        }
    }

    @Override // g5.g
    public void endTracks() {
        this.C = true;
        this.f20024x.post(this.f20022v);
    }

    @Override // u5.g, u5.l
    public long getBufferedPositionUs() {
        long jMin;
        if (this.Q) {
            return Long.MIN_VALUE;
        }
        if (b()) {
            return this.O;
        }
        int i10 = 0;
        if (this.L) {
            int length = this.A.length;
            jMin = Long.MAX_VALUE;
            while (i10 < length) {
                if (this.K[i10]) {
                    jMin = Math.min(jMin, this.A[i10].getLargestQueuedTimestampUs());
                }
                i10++;
            }
        } else {
            j[] jVarArr = this.A;
            int length2 = jVarArr.length;
            long jMax = Long.MIN_VALUE;
            while (i10 < length2) {
                jMax = Math.max(jMax, jVarArr[i10].getLargestQueuedTimestampUs());
                i10++;
            }
            jMin = jMax;
        }
        return jMin == Long.MIN_VALUE ? this.N : jMin;
    }

    @Override // u5.g, u5.l
    public long getNextLoadPositionUs() {
        if (this.G == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    @Override // u5.g
    public o getTrackGroups() {
        return this.H;
    }

    @Override // u5.g
    public void maybeThrowPrepareError() throws IOException {
        this.f20019s.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void onLoaderReleased() {
        this.f20020t.release();
        for (j jVar : this.A) {
            jVar.reset();
        }
    }

    @Override // u5.j.b
    public void onUpstreamFormatChanged(c5.i iVar) {
        this.f20024x.post(this.f20022v);
    }

    @Override // u5.g
    public void prepare(g.a aVar, long j10) {
        this.f20025y = aVar;
        this.f20021u.open();
        c();
    }

    @Override // u5.g
    public long readDiscontinuity() {
        if (!this.F) {
            return -9223372036854775807L;
        }
        this.F = false;
        return this.N;
    }

    public void release() {
        boolean zRelease = this.f20019s.release(this);
        if (this.D && !zRelease) {
            for (j jVar : this.A) {
                jVar.discardToEnd();
            }
        }
        this.f20024x.removeCallbacksAndMessages(null);
        this.R = true;
    }

    @Override // g5.g
    public void seekMap(g5.l lVar) {
        this.f20026z = lVar;
        this.f20024x.post(this.f20022v);
    }

    @Override // u5.g
    public long seekToUs(long j10) {
        boolean z10;
        if (!this.f20026z.isSeekable()) {
            j10 = 0;
        }
        this.N = j10;
        this.F = false;
        if (!b()) {
            int length = this.A.length;
            int i10 = 0;
            while (true) {
                z10 = true;
                if (i10 >= length) {
                    break;
                }
                j jVar = this.A[i10];
                jVar.rewind();
                if (!jVar.advanceTo(j10, true, false) && (this.K[i10] || !this.L)) {
                    break;
                }
                jVar.discardToRead();
                i10++;
            }
            z10 = false;
            if (z10) {
                return j10;
            }
        }
        this.O = j10;
        this.Q = false;
        Loader loader = this.f20019s;
        if (loader.isLoading()) {
            loader.cancelLoading();
        } else {
            for (j jVar2 : this.A) {
                jVar2.reset();
            }
        }
        return j10;
    }

    @Override // u5.g
    public long selectTracks(j6.f[] fVarArr, boolean[] zArr, k[] kVarArr, boolean[] zArr2, long j10) {
        j6.f fVar;
        l6.a.checkState(this.D);
        int i10 = this.G;
        int i11 = 0;
        for (int i12 = 0; i12 < fVarArr.length; i12++) {
            k kVar = kVarArr[i12];
            if (kVar != null && (fVarArr[i12] == null || !zArr[i12])) {
                int i13 = ((f) kVar).f20042b;
                l6.a.checkState(this.J[i13]);
                this.G--;
                this.J[i13] = false;
                kVarArr[i12] = null;
            }
        }
        boolean z10 = !this.E ? j10 == 0 : i10 != 0;
        for (int i14 = 0; i14 < fVarArr.length; i14++) {
            if (kVarArr[i14] == null && (fVar = fVarArr[i14]) != null) {
                l6.a.checkState(fVar.length() == 1);
                l6.a.checkState(fVar.getIndexInTrackGroup(0) == 0);
                int iIndexOf = this.H.indexOf(fVar.getTrackGroup());
                l6.a.checkState(!this.J[iIndexOf]);
                this.G++;
                this.J[iIndexOf] = true;
                kVarArr[i14] = new f(iIndexOf);
                zArr2[i14] = true;
                if (!z10) {
                    j jVar = this.A[iIndexOf];
                    jVar.rewind();
                    z10 = (jVar.advanceTo(j10, true, true) || jVar.getReadIndex() == 0) ? false : true;
                }
            }
        }
        if (this.G == 0) {
            this.F = false;
            Loader loader = this.f20019s;
            if (loader.isLoading()) {
                j[] jVarArr = this.A;
                int length = jVarArr.length;
                while (i11 < length) {
                    jVarArr[i11].discardToEnd();
                    i11++;
                }
                loader.cancelLoading();
            } else {
                j[] jVarArr2 = this.A;
                int length2 = jVarArr2.length;
                while (i11 < length2) {
                    jVarArr2[i11].reset();
                    i11++;
                }
            }
        } else if (z10) {
            j10 = seekToUs(j10);
            while (i11 < kVarArr.length) {
                if (kVarArr[i11] != null) {
                    zArr2[i11] = true;
                }
                i11++;
            }
        }
        this.E = true;
        return j10;
    }

    @Override // g5.g
    public g5.m track(int i10, int i11) {
        int length = this.A.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.B[i12] == i10) {
                return this.A[i12];
            }
        }
        j jVar = new j(this.f20016p);
        jVar.setUpstreamFormatChangeListener(this);
        int i13 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.B, i13);
        this.B = iArrCopyOf;
        iArrCopyOf[length] = i10;
        j[] jVarArr = (j[]) Arrays.copyOf(this.A, i13);
        this.A = jVarArr;
        jVarArr[length] = jVar;
        return jVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCanceled(c cVar, long j10, long j11, boolean z10) {
        if (z10) {
            return;
        }
        if (this.M == -1) {
            this.M = cVar.f20037i;
        }
        for (j jVar : this.A) {
            jVar.reset();
        }
        if (this.G > 0) {
            this.f20025y.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCompleted(c cVar, long j10, long j11) {
        if (this.M == -1) {
            this.M = cVar.f20037i;
        }
        this.Q = true;
        if (this.I == -9223372036854775807L) {
            long jMax = Long.MIN_VALUE;
            for (j jVar : this.A) {
                jMax = Math.max(jMax, jVar.getLargestQueuedTimestampUs());
            }
            long j12 = jMax == Long.MIN_VALUE ? 0L : 10000 + jMax;
            this.I = j12;
            ((u5.f) this.f20015o).onSourceInfoRefreshed(j12, this.f20026z.isSeekable());
        }
        this.f20025y.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int onLoadError(c cVar, long j10, long j11, IOException iOException) {
        g5.l lVar;
        if (this.M == -1) {
            this.M = cVar.f20037i;
        }
        if (iOException instanceof UnrecognizedInputFormatException) {
            return 3;
        }
        int i10 = a() > this.P ? 1 : 0;
        if (this.M == -1 && ((lVar = this.f20026z) == null || lVar.getDurationUs() == -9223372036854775807L)) {
            this.N = 0L;
            this.F = this.D;
            for (j jVar : this.A) {
                jVar.reset();
            }
            cVar.setLoadPosition(0L, 0L);
        }
        this.P = a();
        return i10;
    }
}
