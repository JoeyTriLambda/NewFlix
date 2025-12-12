package y5;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import u5.a;
import u5.j;
import u5.l;
import u5.n;
import u5.o;
import y5.c;

/* compiled from: HlsSampleStreamWrapper.java */
/* loaded from: classes.dex */
public final class j implements Loader.a<v5.c>, Loader.d, u5.l, g5.g, j.b {
    public boolean A;
    public int B;
    public c5.i C;
    public boolean D;
    public o E;
    public int F;
    public boolean G;
    public boolean[] H;
    public boolean[] I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    public boolean N;

    /* renamed from: b, reason: collision with root package name */
    public final int f21980b;

    /* renamed from: m, reason: collision with root package name */
    public final b f21981m;

    /* renamed from: n, reason: collision with root package name */
    public final c f21982n;

    /* renamed from: o, reason: collision with root package name */
    public final k6.b f21983o;

    /* renamed from: p, reason: collision with root package name */
    public final c5.i f21984p;

    /* renamed from: q, reason: collision with root package name */
    public final int f21985q;

    /* renamed from: s, reason: collision with root package name */
    public final a.C0284a f21987s;

    /* renamed from: z, reason: collision with root package name */
    public boolean f21994z;

    /* renamed from: r, reason: collision with root package name */
    public final Loader f21986r = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: t, reason: collision with root package name */
    public final c.b f21988t = new c.b();

    /* renamed from: y, reason: collision with root package name */
    public int[] f21993y = new int[0];

    /* renamed from: x, reason: collision with root package name */
    public u5.j[] f21992x = new u5.j[0];

    /* renamed from: u, reason: collision with root package name */
    public final LinkedList<f> f21989u = new LinkedList<>();

    /* renamed from: v, reason: collision with root package name */
    public final a f21990v = new a();

    /* renamed from: w, reason: collision with root package name */
    public final Handler f21991w = new Handler();

    /* compiled from: HlsSampleStreamWrapper.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.d();
        }
    }

    /* compiled from: HlsSampleStreamWrapper.java */
    public interface b extends l.a<j> {
    }

    public j(int i10, b bVar, c cVar, k6.b bVar2, long j10, c5.i iVar, int i11, a.C0284a c0284a) {
        this.f21980b = i10;
        this.f21981m = bVar;
        this.f21982n = cVar;
        this.f21983o = bVar2;
        this.f21984p = iVar;
        this.f21985q = i11;
        this.f21987s = c0284a;
        this.J = j10;
        this.K = j10;
    }

    public static c5.i a(c5.i iVar, c5.i iVar2) {
        if (iVar == null) {
            return iVar2;
        }
        int trackType = l6.i.getTrackType(iVar2.f5120q);
        String str = iVar.f5117n;
        return iVar2.copyWithContainerInfo(iVar.f5115b, trackType == 1 ? b(1, str) : trackType == 2 ? b(2, str) : null, iVar.f5116m, iVar.f5124u, iVar.f5125v, iVar.I, iVar.J);
    }

    public static String b(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (i10 == l6.i.getTrackTypeOfCodec(str2)) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public final boolean c() {
        return this.K != -9223372036854775807L;
    }

    @Override // u5.l
    public boolean continueLoading(long j10) {
        if (!this.N) {
            Loader loader = this.f21986r;
            if (!loader.isLoading()) {
                LinkedList<f> linkedList = this.f21989u;
                f last = linkedList.isEmpty() ? null : linkedList.getLast();
                long j11 = this.K;
                if (j11 == -9223372036854775807L) {
                    j11 = j10;
                }
                c cVar = this.f21982n;
                c.b bVar = this.f21988t;
                cVar.getNextChunk(last, j11, bVar);
                boolean z10 = bVar.f21935b;
                v5.c cVar2 = bVar.f21934a;
                a.C0072a c0072a = bVar.f21936c;
                bVar.clear();
                if (z10) {
                    this.K = -9223372036854775807L;
                    this.N = true;
                    return true;
                }
                if (cVar2 == null) {
                    if (c0072a != null) {
                        ((g) this.f21981m).onPlaylistRefreshRequired(c0072a);
                    }
                    return false;
                }
                if (cVar2 instanceof f) {
                    this.K = -9223372036854775807L;
                    f fVar = (f) cVar2;
                    fVar.init(this);
                    linkedList.add(fVar);
                }
                this.f21987s.loadStarted(cVar2.f20466a, cVar2.f20467b, this.f21980b, cVar2.f20468c, cVar2.f20469d, cVar2.f20470e, cVar2.f20471f, cVar2.f20472g, loader.startLoading(cVar2, this, this.f21985q));
                return true;
            }
        }
        return false;
    }

    public void continuePreparing() {
        if (this.A) {
            return;
        }
        continueLoading(this.J);
    }

    public final void d() {
        if (this.D || this.A || !this.f21994z) {
            return;
        }
        for (u5.j jVar : this.f21992x) {
            if (jVar.getUpstreamFormat() == null) {
                return;
            }
        }
        int length = this.f21992x.length;
        int i10 = 0;
        char c10 = 0;
        int i11 = -1;
        while (true) {
            char c11 = 1;
            if (i10 >= length) {
                break;
            }
            String str = this.f21992x[i10].getUpstreamFormat().f5120q;
            if (l6.i.isVideo(str)) {
                c11 = 3;
            } else if (l6.i.isAudio(str)) {
                c11 = 2;
            } else if (!l6.i.isText(str)) {
                c11 = 0;
            }
            if (c11 > c10) {
                i11 = i10;
                c10 = c11;
            } else if (c11 == c10 && i11 != -1) {
                i11 = -1;
            }
            i10++;
        }
        n trackGroup = this.f21982n.getTrackGroup();
        int i12 = trackGroup.f20107a;
        this.F = -1;
        this.H = new boolean[length];
        this.I = new boolean[length];
        n[] nVarArr = new n[length];
        for (int i13 = 0; i13 < length; i13++) {
            c5.i upstreamFormat = this.f21992x[i13].getUpstreamFormat();
            String str2 = upstreamFormat.f5120q;
            boolean z10 = l6.i.isVideo(str2) || l6.i.isAudio(str2);
            this.I[i13] = z10;
            this.G = z10 | this.G;
            if (i13 == i11) {
                c5.i[] iVarArr = new c5.i[i12];
                for (int i14 = 0; i14 < i12; i14++) {
                    iVarArr[i14] = a(trackGroup.getFormat(i14), upstreamFormat);
                }
                nVarArr[i13] = new n(iVarArr);
                this.F = i13;
            } else {
                nVarArr[i13] = new n(a((c10 == 3 && l6.i.isAudio(upstreamFormat.f5120q)) ? this.f21984p : null, upstreamFormat));
            }
        }
        this.E = new o(nVarArr);
        this.A = true;
        ((g) this.f21981m).onPrepared();
    }

    public void discardBuffer(long j10) {
        int length = this.f21992x.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f21992x[i10].discardTo(j10, false, this.H[i10]);
        }
    }

    public final void e() {
        for (u5.j jVar : this.f21992x) {
            jVar.reset(this.L);
        }
        this.L = false;
    }

    @Override // g5.g
    public void endTracks() {
        this.f21994z = true;
        this.f21991w.post(this.f21990v);
    }

    @Override // u5.l
    public long getBufferedPositionUs() {
        if (this.N) {
            return Long.MIN_VALUE;
        }
        if (c()) {
            return this.K;
        }
        long jMax = this.J;
        LinkedList<f> linkedList = this.f21989u;
        f last = linkedList.getLast();
        if (!last.isLoadCompleted()) {
            last = linkedList.size() > 1 ? linkedList.get(linkedList.size() - 2) : null;
        }
        if (last != null) {
            jMax = Math.max(jMax, last.f20472g);
        }
        for (u5.j jVar : this.f21992x) {
            jMax = Math.max(jMax, jVar.getLargestQueuedTimestampUs());
        }
        return jMax;
    }

    @Override // u5.l
    public long getNextLoadPositionUs() {
        if (c()) {
            return this.K;
        }
        if (this.N) {
            return Long.MIN_VALUE;
        }
        return this.f21989u.getLast().f20472g;
    }

    public o getTrackGroups() {
        return this.E;
    }

    public void init(int i10, boolean z10) {
        for (u5.j jVar : this.f21992x) {
            jVar.sourceId(i10);
        }
        if (z10) {
            for (u5.j jVar2 : this.f21992x) {
                jVar2.splice();
            }
        }
    }

    public void maybeThrowPrepareError() throws IOException {
        this.f21986r.maybeThrowError();
        this.f21982n.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void onLoaderReleased() {
        e();
    }

    public void onPlaylistBlacklisted(a.C0072a c0072a, long j10) {
        this.f21982n.onPlaylistBlacklisted(c0072a, j10);
    }

    @Override // u5.j.b
    public void onUpstreamFormatChanged(c5.i iVar) {
        this.f21991w.post(this.f21990v);
    }

    public void prepareSingleTrack(c5.i iVar) {
        track(0, -1).format(iVar);
        this.f21994z = true;
        d();
    }

    public void release() {
        boolean zRelease = this.f21986r.release(this);
        if (this.A && !zRelease) {
            for (u5.j jVar : this.f21992x) {
                jVar.discardToEnd();
            }
        }
        this.f21991w.removeCallbacksAndMessages(null);
        this.D = true;
    }

    public boolean seekToUs(long j10, boolean z10) {
        boolean z11;
        this.J = j10;
        if (!z10 && !c()) {
            int length = this.f21992x.length;
            for (int i10 = 0; i10 < length; i10++) {
                u5.j jVar = this.f21992x[i10];
                jVar.rewind();
                if (!jVar.advanceTo(j10, true, false) && (this.I[i10] || !this.G)) {
                    z11 = false;
                    break;
                }
                jVar.discardToRead();
            }
            z11 = true;
            if (z11) {
                return false;
            }
        }
        this.K = j10;
        this.N = false;
        this.f21989u.clear();
        Loader loader = this.f21986r;
        if (loader.isLoading()) {
            loader.cancelLoading();
        } else {
            e();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean selectTracks(j6.f[] r17, boolean[] r18, u5.k[] r19, boolean[] r20, long r21, boolean r23) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.j.selectTracks(j6.f[], boolean[], u5.k[], boolean[], long, boolean):boolean");
    }

    public void setIsTimestampMaster(boolean z10) {
        this.f21982n.setIsTimestampMaster(z10);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCanceled(v5.c cVar, long j10, long j11, boolean z10) {
        this.f21987s.loadCanceled(cVar.f20466a, cVar.f20467b, this.f21980b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, j10, j11, cVar.bytesLoaded());
        if (z10) {
            return;
        }
        e();
        if (this.B > 0) {
            ((g) this.f21981m).onContinueLoadingRequested((u5.l) this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCompleted(v5.c cVar, long j10, long j11) {
        this.f21982n.onChunkLoadCompleted(cVar);
        this.f21987s.loadCompleted(cVar.f20466a, cVar.f20467b, this.f21980b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, j10, j11, cVar.bytesLoaded());
        if (this.A) {
            ((g) this.f21981m).onContinueLoadingRequested((u5.l) this);
        } else {
            continueLoading(this.J);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int onLoadError(v5.c cVar, long j10, long j11, IOException iOException) {
        boolean z10 = cVar instanceof f;
        boolean z11 = true;
        if (!this.f21982n.onChunkLoadError(cVar, !z10 || cVar.bytesLoaded() == 0, iOException)) {
            z11 = false;
        } else if (z10) {
            LinkedList<f> linkedList = this.f21989u;
            l6.a.checkState(linkedList.removeLast() == cVar);
            if (linkedList.isEmpty()) {
                this.K = this.J;
            }
        }
        this.f21987s.loadError(cVar.f20466a, cVar.f20467b, this.f21980b, cVar.f20468c, cVar.f20469d, cVar.f20470e, cVar.f20471f, cVar.f20472g, j10, j11, cVar.bytesLoaded(), iOException, z11);
        if (!z11) {
            return 0;
        }
        if (this.A) {
            ((g) this.f21981m).onContinueLoadingRequested((u5.l) this);
            return 2;
        }
        continueLoading(this.J);
        return 2;
    }

    @Override // g5.g
    public u5.j track(int i10, int i11) {
        int length = this.f21992x.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.f21993y[i12] == i10) {
                return this.f21992x[i12];
            }
        }
        u5.j jVar = new u5.j(this.f21983o);
        jVar.setUpstreamFormatChangeListener(this);
        int i13 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.f21993y, i13);
        this.f21993y = iArrCopyOf;
        iArrCopyOf[length] = i10;
        u5.j[] jVarArr = (u5.j[]) Arrays.copyOf(this.f21992x, i13);
        this.f21992x = jVarArr;
        jVarArr[length] = jVar;
        return jVar;
    }

    @Override // g5.g
    public void seekMap(g5.l lVar) {
    }
}
