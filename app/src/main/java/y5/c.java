package y5;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import l6.t;
import l6.u;
import u5.n;

/* compiled from: HlsChunkSource.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final k6.d f21915a;

    /* renamed from: b, reason: collision with root package name */
    public final k6.d f21916b;

    /* renamed from: c, reason: collision with root package name */
    public final k f21917c;

    /* renamed from: d, reason: collision with root package name */
    public final a.C0072a[] f21918d;

    /* renamed from: e, reason: collision with root package name */
    public final HlsPlaylistTracker f21919e;

    /* renamed from: f, reason: collision with root package name */
    public final n f21920f;

    /* renamed from: g, reason: collision with root package name */
    public final List<c5.i> f21921g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21922h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f21923i;

    /* renamed from: j, reason: collision with root package name */
    public BehindLiveWindowException f21924j;

    /* renamed from: k, reason: collision with root package name */
    public a.C0072a f21925k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21926l;

    /* renamed from: m, reason: collision with root package name */
    public Uri f21927m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f21928n;

    /* renamed from: o, reason: collision with root package name */
    public String f21929o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f21930p;

    /* renamed from: q, reason: collision with root package name */
    public j6.f f21931q;

    /* compiled from: HlsChunkSource.java */
    public static final class a extends v5.j {

        /* renamed from: l, reason: collision with root package name */
        public final String f21932l;

        /* renamed from: m, reason: collision with root package name */
        public byte[] f21933m;

        public a(k6.d dVar, k6.f fVar, c5.i iVar, int i10, Object obj, byte[] bArr, String str) {
            super(dVar, fVar, 3, iVar, i10, obj, bArr);
            this.f21932l = str;
        }

        @Override // v5.j
        public void consume(byte[] bArr, int i10) throws IOException {
            this.f21933m = Arrays.copyOf(bArr, i10);
        }

        public byte[] getResult() {
            return this.f21933m;
        }
    }

    /* compiled from: HlsChunkSource.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public v5.c f21934a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21935b;

        /* renamed from: c, reason: collision with root package name */
        public a.C0072a f21936c;

        public b() {
            clear();
        }

        public void clear() {
            this.f21934a = null;
            this.f21935b = false;
            this.f21936c = null;
        }
    }

    /* compiled from: HlsChunkSource.java */
    /* renamed from: y5.c$c, reason: collision with other inner class name */
    public static final class C0319c extends j6.b {

        /* renamed from: g, reason: collision with root package name */
        public int f21937g;

        public C0319c(n nVar, int[] iArr) {
            super(nVar, iArr);
            this.f21937g = indexOf(nVar.getFormat(0));
        }

        @Override // j6.f
        public int getSelectedIndex() {
            return this.f21937g;
        }

        @Override // j6.f
        public Object getSelectionData() {
            return null;
        }

        @Override // j6.f
        public int getSelectionReason() {
            return 0;
        }

        @Override // j6.f
        public void updateSelectedTrack(long j10) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isBlacklisted(this.f21937g, jElapsedRealtime)) {
                for (int i10 = this.f14635b - 1; i10 >= 0; i10--) {
                    if (!isBlacklisted(i10, jElapsedRealtime)) {
                        this.f21937g = i10;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    public c(HlsPlaylistTracker hlsPlaylistTracker, a.C0072a[] c0072aArr, d dVar, k kVar, List<c5.i> list) {
        this.f21919e = hlsPlaylistTracker;
        this.f21918d = c0072aArr;
        this.f21917c = kVar;
        this.f21921g = list;
        c5.i[] iVarArr = new c5.i[c0072aArr.length];
        int[] iArr = new int[c0072aArr.length];
        for (int i10 = 0; i10 < c0072aArr.length; i10++) {
            iVarArr[i10] = c0072aArr[i10].f5912b;
            iArr[i10] = i10;
        }
        y5.b bVar = (y5.b) dVar;
        this.f21915a = bVar.createDataSource(1);
        this.f21916b = bVar.createDataSource(3);
        n nVar = new n(iVarArr);
        this.f21920f = nVar;
        this.f21931q = new C0319c(nVar, iArr);
    }

    public final void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(u.toLowerInvariant(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
        this.f21927m = uri;
        this.f21928n = bArr;
        this.f21929o = str;
        this.f21930p = bArr2;
    }

    public void getNextChunk(f fVar, long j10, b bVar) {
        int i10;
        int nextChunkIndex;
        int nextChunkIndex2;
        a.C0072a c0072a;
        k6.f fVar2;
        int iIndexOf = fVar == null ? -1 : this.f21920f.indexOf(fVar.f20468c);
        this.f21925k = null;
        long jMax = 0;
        if (fVar != null) {
            jMax = Math.max(0L, (this.f21926l ? fVar.f20472g : fVar.f20471f) - j10);
        }
        this.f21931q.updateSelectedTrack(jMax);
        int selectedIndexInTrackGroup = this.f21931q.getSelectedIndexInTrackGroup();
        boolean z10 = iIndexOf != selectedIndexInTrackGroup;
        a.C0072a[] c0072aArr = this.f21918d;
        a.C0072a c0072a2 = c0072aArr[selectedIndexInTrackGroup];
        HlsPlaylistTracker hlsPlaylistTracker = this.f21919e;
        if (!hlsPlaylistTracker.isSnapshotValid(c0072a2)) {
            bVar.f21936c = c0072a2;
            this.f21925k = c0072a2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b playlistSnapshot = hlsPlaylistTracker.getPlaylistSnapshot(c0072a2);
        boolean z11 = playlistSnapshot.f5921k;
        this.f21926l = z11;
        if (fVar == null || z10) {
            long j11 = fVar == null ? j10 : z11 ? fVar.f20472g : fVar.f20471f;
            boolean z12 = playlistSnapshot.f5922l;
            int i11 = playlistSnapshot.f5918h;
            List<b.a> list = playlistSnapshot.f5925o;
            if (z12 || j11 < playlistSnapshot.getEndTimeUs()) {
                i10 = selectedIndexInTrackGroup;
                int iBinarySearchFloor = u.binarySearchFloor((List<? extends Comparable<? super Long>>) list, Long.valueOf(j11 - playlistSnapshot.f5915e), true, !hlsPlaylistTracker.isLive() || fVar == null) + i11;
                if (iBinarySearchFloor >= i11 || fVar == null) {
                    nextChunkIndex = iBinarySearchFloor;
                } else {
                    c0072a2 = c0072aArr[iIndexOf];
                    i10 = iIndexOf;
                    playlistSnapshot = hlsPlaylistTracker.getPlaylistSnapshot(c0072a2);
                    nextChunkIndex = fVar.getNextChunkIndex();
                }
            } else {
                nextChunkIndex = list.size() + i11;
                i10 = selectedIndexInTrackGroup;
            }
            nextChunkIndex2 = nextChunkIndex;
            c0072a = c0072a2;
            selectedIndexInTrackGroup = i10;
        } else {
            nextChunkIndex2 = fVar.getNextChunkIndex();
            c0072a = c0072a2;
        }
        int i12 = playlistSnapshot.f5918h;
        if (nextChunkIndex2 < i12) {
            this.f21924j = new BehindLiveWindowException();
            return;
        }
        int i13 = nextChunkIndex2 - i12;
        List<b.a> list2 = playlistSnapshot.f5925o;
        if (i13 >= list2.size()) {
            if (playlistSnapshot.f5922l) {
                bVar.f21935b = true;
                return;
            } else {
                bVar.f21936c = c0072a;
                this.f21925k = c0072a;
                return;
            }
        }
        b.a aVar = list2.get(i13);
        boolean z13 = aVar.f5931p;
        String str = playlistSnapshot.f22611a;
        if (z13) {
            Uri uriResolveToUri = t.resolveToUri(str, aVar.f5932q);
            if (!uriResolveToUri.equals(this.f21927m)) {
                bVar.f21934a = new a(this.f21916b, new k6.f(uriResolveToUri, 0L, -1L, null, 1), c0072aArr[selectedIndexInTrackGroup].f5912b, this.f21931q.getSelectionReason(), this.f21931q.getSelectionData(), this.f21923i, aVar.f5933r);
                return;
            } else {
                String str2 = this.f21929o;
                String str3 = aVar.f5933r;
                if (!u.areEqual(str3, str2)) {
                    a(uriResolveToUri, str3, this.f21928n);
                }
                fVar2 = null;
            }
        } else {
            fVar2 = null;
            this.f21927m = null;
            this.f21928n = null;
            this.f21929o = null;
            this.f21930p = null;
        }
        b.a aVar2 = playlistSnapshot.f5924n;
        if (aVar2 != null) {
            fVar2 = new k6.f(t.resolveToUri(str, aVar2.f5927b), aVar2.f5934s, aVar2.f5935t, null);
        }
        k6.f fVar3 = fVar2;
        long j12 = playlistSnapshot.f5915e + aVar.f5930o;
        int i14 = playlistSnapshot.f5917g + aVar.f5929n;
        bVar.f21934a = new f(this.f21915a, new k6.f(t.resolveToUri(str, aVar.f5927b), aVar.f5934s, aVar.f5935t, null), fVar3, c0072a, this.f21921g, this.f21931q.getSelectionReason(), this.f21931q.getSelectionData(), j12, j12 + aVar.f5928m, nextChunkIndex2, i14, this.f21922h, this.f21917c.getAdjuster(i14), fVar, this.f21928n, this.f21930p);
    }

    public n getTrackGroup() {
        return this.f21920f;
    }

    public j6.f getTrackSelection() {
        return this.f21931q;
    }

    public void maybeThrowError() throws IOException {
        BehindLiveWindowException behindLiveWindowException = this.f21924j;
        if (behindLiveWindowException != null) {
            throw behindLiveWindowException;
        }
        a.C0072a c0072a = this.f21925k;
        if (c0072a != null) {
            this.f21919e.maybeThrowPlaylistRefreshError(c0072a);
        }
    }

    public void onChunkLoadCompleted(v5.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.f21923i = aVar.getDataHolder();
            a(aVar.f20466a.f14959a, aVar.f21932l, aVar.getResult());
        }
    }

    public boolean onChunkLoadError(v5.c cVar, boolean z10, IOException iOException) {
        if (z10) {
            j6.f fVar = this.f21931q;
            if (v5.h.maybeBlacklistTrack(fVar, fVar.indexOf(this.f21920f.indexOf(cVar.f20468c)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public void onPlaylistBlacklisted(a.C0072a c0072a, long j10) {
        int iIndexOf;
        int iIndexOf2 = this.f21920f.indexOf(c0072a.f5912b);
        if (iIndexOf2 == -1 || (iIndexOf = this.f21931q.indexOf(iIndexOf2)) == -1) {
            return;
        }
        this.f21931q.blacklist(iIndexOf, j10);
    }

    public void reset() {
        this.f21924j = null;
    }

    public void selectTracks(j6.f fVar) {
        this.f21931q = fVar;
    }

    public void setIsTimestampMaster(boolean z10) {
        this.f21922h = z10;
    }
}
