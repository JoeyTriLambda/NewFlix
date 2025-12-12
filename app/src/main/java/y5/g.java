package y5;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import u5.a;
import u5.g;
import u5.n;
import u5.o;
import y5.j;

/* compiled from: HlsMediaPeriod.java */
/* loaded from: classes.dex */
public final class g implements u5.g, j.b, HlsPlaylistTracker.b {

    /* renamed from: b, reason: collision with root package name */
    public final HlsPlaylistTracker f21957b;

    /* renamed from: m, reason: collision with root package name */
    public final d f21958m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21959n;

    /* renamed from: o, reason: collision with root package name */
    public final a.C0284a f21960o;

    /* renamed from: p, reason: collision with root package name */
    public final k6.b f21961p;

    /* renamed from: t, reason: collision with root package name */
    public g.a f21965t;

    /* renamed from: u, reason: collision with root package name */
    public int f21966u;

    /* renamed from: v, reason: collision with root package name */
    public o f21967v;

    /* renamed from: y, reason: collision with root package name */
    public u5.c f21970y;

    /* renamed from: q, reason: collision with root package name */
    public final IdentityHashMap<u5.k, Integer> f21962q = new IdentityHashMap<>();

    /* renamed from: r, reason: collision with root package name */
    public final k f21963r = new k();

    /* renamed from: s, reason: collision with root package name */
    public final Handler f21964s = new Handler();

    /* renamed from: w, reason: collision with root package name */
    public j[] f21968w = new j[0];

    /* renamed from: x, reason: collision with root package name */
    public j[] f21969x = new j[0];

    public g(HlsPlaylistTracker hlsPlaylistTracker, d dVar, int i10, a.C0284a c0284a, k6.b bVar) {
        this.f21957b = hlsPlaylistTracker;
        this.f21958m = dVar;
        this.f21959n = i10;
        this.f21960o = c0284a;
        this.f21961p = bVar;
    }

    public static boolean b(a.C0072a c0072a, String str) {
        String str2 = c0072a.f5912b.f5117n;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (str3.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public final j a(int i10, a.C0072a[] c0072aArr, c5.i iVar, List<c5.i> list, long j10) {
        return new j(i10, this, new c(this.f21957b, c0072aArr, this.f21958m, this.f21963r, list), this.f21961p, j10, iVar, this.f21959n, this.f21960o);
    }

    @Override // u5.g, u5.l
    public boolean continueLoading(long j10) {
        return this.f21970y.continueLoading(j10);
    }

    @Override // u5.g
    public void discardBuffer(long j10) {
        for (j jVar : this.f21969x) {
            jVar.discardBuffer(j10);
        }
    }

    @Override // u5.g, u5.l
    public long getBufferedPositionUs() {
        return this.f21970y.getBufferedPositionUs();
    }

    @Override // u5.g, u5.l
    public long getNextLoadPositionUs() {
        return this.f21970y.getNextLoadPositionUs();
    }

    @Override // u5.g
    public o getTrackGroups() {
        return this.f21967v;
    }

    @Override // u5.g
    public void maybeThrowPrepareError() throws IOException {
        for (j jVar : this.f21968w) {
            jVar.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void onPlaylistBlacklisted(a.C0072a c0072a, long j10) {
        for (j jVar : this.f21968w) {
            jVar.onPlaylistBlacklisted(c0072a, j10);
        }
        if (this.f21967v != null) {
            this.f21965t.onContinueLoadingRequested(this);
            return;
        }
        for (j jVar2 : this.f21968w) {
            jVar2.continuePreparing();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void onPlaylistChanged() {
        if (this.f21967v != null) {
            this.f21965t.onContinueLoadingRequested(this);
            return;
        }
        for (j jVar : this.f21968w) {
            jVar.continuePreparing();
        }
    }

    public void onPlaylistRefreshRequired(a.C0072a c0072a) {
        this.f21957b.refreshPlaylist(c0072a);
    }

    public void onPrepared() {
        int i10 = this.f21966u - 1;
        this.f21966u = i10;
        if (i10 > 0) {
            return;
        }
        int i11 = 0;
        for (j jVar : this.f21968w) {
            i11 += jVar.getTrackGroups().f20111a;
        }
        n[] nVarArr = new n[i11];
        int i12 = 0;
        for (j jVar2 : this.f21968w) {
            int i13 = jVar2.getTrackGroups().f20111a;
            int i14 = 0;
            while (i14 < i13) {
                nVarArr[i12] = jVar2.getTrackGroups().get(i14);
                i14++;
                i12++;
            }
        }
        this.f21967v = new o(nVarArr);
        this.f21965t.onPrepared(this);
    }

    @Override // u5.g
    public void prepare(g.a aVar, long j10) {
        this.f21965t = aVar;
        HlsPlaylistTracker hlsPlaylistTracker = this.f21957b;
        hlsPlaylistTracker.addListener(this);
        com.google.android.exoplayer2.source.hls.playlist.a masterPlaylist = hlsPlaylistTracker.getMasterPlaylist();
        ArrayList arrayList = new ArrayList(masterPlaylist.f5906c);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            a.C0072a c0072a = (a.C0072a) arrayList.get(i10);
            if (c0072a.f5912b.f5125v > 0 || b(c0072a, "avc")) {
                arrayList2.add(c0072a);
            } else if (b(c0072a, "mp4a")) {
                arrayList3.add(c0072a);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List<a.C0072a> list = masterPlaylist.f5907d;
        int size = list.size() + 1;
        List<a.C0072a> list2 = masterPlaylist.f5908e;
        int size2 = list2.size() + size;
        this.f21968w = new j[size2];
        this.f21966u = size2;
        l6.a.checkArgument(!arrayList.isEmpty());
        a.C0072a[] c0072aArr = new a.C0072a[arrayList.size()];
        arrayList.toArray(c0072aArr);
        j jVarA = a(0, c0072aArr, masterPlaylist.f5909f, masterPlaylist.f5910g, j10);
        this.f21968w[0] = jVarA;
        jVarA.setIsTimestampMaster(true);
        jVarA.continuePreparing();
        int i11 = 0;
        int i12 = 1;
        while (i11 < list.size()) {
            j jVarA2 = a(1, new a.C0072a[]{list.get(i11)}, null, Collections.emptyList(), j10);
            this.f21968w[i12] = jVarA2;
            jVarA2.continuePreparing();
            i11++;
            i12++;
        }
        int i13 = 0;
        while (i13 < list2.size()) {
            a.C0072a c0072a2 = list2.get(i13);
            j jVarA3 = a(3, new a.C0072a[]{c0072a2}, null, Collections.emptyList(), j10);
            jVarA3.prepareSingleTrack(c0072a2.f5912b);
            this.f21968w[i12] = jVarA3;
            i13++;
            i12++;
        }
        this.f21969x = this.f21968w;
    }

    @Override // u5.g
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void release() {
        this.f21957b.removeListener(this);
        this.f21964s.removeCallbacksAndMessages(null);
        for (j jVar : this.f21968w) {
            jVar.release();
        }
    }

    @Override // u5.g
    public long seekToUs(long j10) {
        j[] jVarArr = this.f21969x;
        if (jVarArr.length > 0) {
            boolean zSeekToUs = jVarArr[0].seekToUs(j10, false);
            int i10 = 1;
            while (true) {
                j[] jVarArr2 = this.f21969x;
                if (i10 >= jVarArr2.length) {
                    break;
                }
                jVarArr2[i10].seekToUs(j10, zSeekToUs);
                i10++;
            }
            if (zSeekToUs) {
                this.f21963r.reset();
            }
        }
        return j10;
    }

    @Override // u5.g
    public long selectTracks(j6.f[] fVarArr, boolean[] zArr, u5.k[] kVarArr, boolean[] zArr2, long j10) {
        IdentityHashMap<u5.k, Integer> identityHashMap;
        j[] jVarArr;
        g gVar = this;
        u5.k[] kVarArr2 = kVarArr;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        int i10 = 0;
        while (true) {
            int length = fVarArr.length;
            identityHashMap = gVar.f21962q;
            if (i10 >= length) {
                break;
            }
            u5.k kVar = kVarArr2[i10];
            iArr[i10] = kVar == null ? -1 : identityHashMap.get(kVar).intValue();
            iArr2[i10] = -1;
            j6.f fVar = fVarArr[i10];
            if (fVar != null) {
                n trackGroup = fVar.getTrackGroup();
                int i11 = 0;
                while (true) {
                    j[] jVarArr2 = gVar.f21968w;
                    if (i11 >= jVarArr2.length) {
                        break;
                    }
                    if (jVarArr2[i11].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i10] = i11;
                        break;
                    }
                    i11++;
                }
            }
            i10++;
        }
        identityHashMap.clear();
        int length2 = fVarArr.length;
        u5.k[] kVarArr3 = new u5.k[length2];
        u5.k[] kVarArr4 = new u5.k[fVarArr.length];
        j6.f[] fVarArr2 = new j6.f[fVarArr.length];
        j[] jVarArr3 = new j[gVar.f21968w.length];
        int i12 = 0;
        int i13 = 0;
        boolean z10 = false;
        while (i13 < gVar.f21968w.length) {
            for (int i14 = 0; i14 < fVarArr.length; i14++) {
                j6.f fVar2 = null;
                kVarArr4[i14] = iArr[i14] == i13 ? kVarArr2[i14] : null;
                if (iArr2[i14] == i13) {
                    fVar2 = fVarArr[i14];
                }
                fVarArr2[i14] = fVar2;
            }
            j jVar = gVar.f21968w[i13];
            int i15 = i12;
            int i16 = length2;
            int i17 = i13;
            j[] jVarArr4 = jVarArr3;
            j6.f[] fVarArr3 = fVarArr2;
            boolean zSelectTracks = jVar.selectTracks(fVarArr2, zArr, kVarArr4, zArr2, j10, z10);
            int i18 = 0;
            boolean z11 = false;
            while (true) {
                if (i18 >= fVarArr.length) {
                    break;
                }
                if (iArr2[i18] == i17) {
                    l6.a.checkState(kVarArr4[i18] != null);
                    kVarArr3[i18] = kVarArr4[i18];
                    identityHashMap.put(kVarArr4[i18], Integer.valueOf(i17));
                    z11 = true;
                } else if (iArr[i18] == i17) {
                    l6.a.checkState(kVarArr4[i18] == null);
                }
                i18++;
            }
            if (z11) {
                jVarArr4[i15] = jVar;
                i12 = i15 + 1;
                if (i15 == 0) {
                    jVar.setIsTimestampMaster(true);
                    if (zSelectTracks) {
                        jVarArr = jVarArr4;
                        gVar = this;
                    } else {
                        jVarArr = jVarArr4;
                        gVar = this;
                        j[] jVarArr5 = gVar.f21969x;
                        if (jVarArr5.length == 0 || jVar != jVarArr5[0]) {
                        }
                    }
                    gVar.f21963r.reset();
                    z10 = true;
                } else {
                    jVarArr = jVarArr4;
                    gVar = this;
                    jVar.setIsTimestampMaster(false);
                }
            } else {
                jVarArr = jVarArr4;
                gVar = this;
                i12 = i15;
            }
            i13 = i17 + 1;
            kVarArr2 = kVarArr;
            jVarArr3 = jVarArr;
            length2 = i16;
            fVarArr2 = fVarArr3;
        }
        System.arraycopy(kVarArr3, 0, kVarArr2, 0, length2);
        j[] jVarArr6 = (j[]) Arrays.copyOf(jVarArr3, i12);
        gVar.f21969x = jVarArr6;
        gVar.f21970y = new u5.c(jVarArr6);
        return j10;
    }

    @Override // u5.l.a
    public void onContinueLoadingRequested(j jVar) {
        if (this.f21967v == null) {
            return;
        }
        this.f21965t.onContinueLoadingRequested(this);
    }
}
