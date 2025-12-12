package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import l6.t;
import org.apache.commons.lang3.time.DateUtils;
import u5.a;
import y5.d;
import y5.h;

/* loaded from: classes.dex */
public final class HlsPlaylistTracker implements Loader.a<com.google.android.exoplayer2.upstream.a<z5.a>> {

    /* renamed from: b, reason: collision with root package name */
    public final Uri f5881b;

    /* renamed from: m, reason: collision with root package name */
    public final d f5882m;

    /* renamed from: n, reason: collision with root package name */
    public final a.InterfaceC0074a<z5.a> f5883n;

    /* renamed from: o, reason: collision with root package name */
    public final int f5884o;

    /* renamed from: r, reason: collision with root package name */
    public final c f5887r;

    /* renamed from: u, reason: collision with root package name */
    public final a.C0284a f5890u;

    /* renamed from: v, reason: collision with root package name */
    public com.google.android.exoplayer2.source.hls.playlist.a f5891v;

    /* renamed from: w, reason: collision with root package name */
    public a.C0072a f5892w;

    /* renamed from: x, reason: collision with root package name */
    public com.google.android.exoplayer2.source.hls.playlist.b f5893x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f5894y;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f5888s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final Loader f5889t = new Loader("HlsPlaylistTracker:MasterPlaylist");

    /* renamed from: p, reason: collision with root package name */
    public final IdentityHashMap<a.C0072a, a> f5885p = new IdentityHashMap<>();

    /* renamed from: q, reason: collision with root package name */
    public final Handler f5886q = new Handler();

    public static final class PlaylistResetException extends IOException {
    }

    public static final class PlaylistStuckException extends IOException {
    }

    public final class a implements Loader.a<com.google.android.exoplayer2.upstream.a<z5.a>>, Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final a.C0072a f5895b;

        /* renamed from: m, reason: collision with root package name */
        public final Loader f5896m = new Loader("HlsPlaylistTracker:MediaPlaylist");

        /* renamed from: n, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.a<z5.a> f5897n;

        /* renamed from: o, reason: collision with root package name */
        public com.google.android.exoplayer2.source.hls.playlist.b f5898o;

        /* renamed from: p, reason: collision with root package name */
        public long f5899p;

        /* renamed from: q, reason: collision with root package name */
        public long f5900q;

        /* renamed from: r, reason: collision with root package name */
        public long f5901r;

        /* renamed from: s, reason: collision with root package name */
        public long f5902s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f5903t;

        /* renamed from: u, reason: collision with root package name */
        public IOException f5904u;

        public a(a.C0072a c0072a) {
            this.f5895b = c0072a;
            this.f5897n = new com.google.android.exoplayer2.upstream.a<>(((y5.b) HlsPlaylistTracker.this.f5882m).createDataSource(4), t.resolveToUri(HlsPlaylistTracker.this.f5891v.f22611a, c0072a.f5911a), 4, HlsPlaylistTracker.this.f5883n);
        }

        public final boolean a() {
            a.C0072a c0072a;
            boolean z10;
            this.f5902s = SystemClock.elapsedRealtime() + DateUtils.MILLIS_PER_MINUTE;
            HlsPlaylistTracker hlsPlaylistTracker = HlsPlaylistTracker.this;
            ArrayList arrayList = hlsPlaylistTracker.f5888s;
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                c0072a = this.f5895b;
                if (i10 >= size) {
                    break;
                }
                ((b) arrayList.get(i10)).onPlaylistBlacklisted(c0072a, DateUtils.MILLIS_PER_MINUTE);
                i10++;
            }
            if (hlsPlaylistTracker.f5892w != c0072a) {
                return false;
            }
            List<a.C0072a> list = hlsPlaylistTracker.f5891v.f5906c;
            int size2 = list.size();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i11 = 0;
            while (true) {
                if (i11 >= size2) {
                    z10 = false;
                    break;
                }
                a aVar = hlsPlaylistTracker.f5885p.get(list.get(i11));
                if (jElapsedRealtime > aVar.f5902s) {
                    hlsPlaylistTracker.f5892w = aVar.f5895b;
                    aVar.loadPlaylist();
                    z10 = true;
                    break;
                }
                i11++;
            }
            return !z10;
        }

        public final void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            long endTimeUs;
            int i10;
            com.google.android.exoplayer2.source.hls.playlist.b bVarCopyWith;
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.f5898o;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f5899p = jElapsedRealtime;
            HlsPlaylistTracker hlsPlaylistTracker = HlsPlaylistTracker.this;
            hlsPlaylistTracker.getClass();
            boolean zIsNewerThan = bVar.isNewerThan(bVar2);
            List<b.a> list = bVar.f5925o;
            int i11 = bVar.f5918h;
            if (zIsNewerThan) {
                if (bVar.f5923m) {
                    endTimeUs = bVar.f5915e;
                } else {
                    com.google.android.exoplayer2.source.hls.playlist.b bVar3 = hlsPlaylistTracker.f5893x;
                    endTimeUs = bVar3 != null ? bVar3.f5915e : 0L;
                    if (bVar2 != null) {
                        List<b.a> list2 = bVar2.f5925o;
                        int size = list2.size();
                        int i12 = bVar2.f5918h;
                        int i13 = i11 - i12;
                        b.a aVar = i13 < list2.size() ? list2.get(i13) : null;
                        if (aVar != null) {
                            endTimeUs = bVar2.f5915e + aVar.f5930o;
                        } else if (size == i11 - i12) {
                            endTimeUs = bVar2.getEndTimeUs();
                        }
                    }
                }
                if (bVar.f5916f) {
                    i10 = bVar.f5917g;
                } else {
                    com.google.android.exoplayer2.source.hls.playlist.b bVar4 = hlsPlaylistTracker.f5893x;
                    i10 = bVar4 != null ? bVar4.f5917g : 0;
                    if (bVar2 != null) {
                        int i14 = i11 - bVar2.f5918h;
                        List<b.a> list3 = bVar2.f5925o;
                        b.a aVar2 = i14 < list3.size() ? list3.get(i14) : null;
                        if (aVar2 != null) {
                            i10 = (bVar2.f5917g + aVar2.f5929n) - list.get(0).f5929n;
                        }
                    }
                }
                bVarCopyWith = bVar.copyWith(endTimeUs, i10);
            } else {
                bVarCopyWith = bVar.f5922l ? bVar2.copyWithEndTag() : bVar2;
            }
            this.f5898o = bVarCopyWith;
            a.C0072a c0072a = this.f5895b;
            if (bVarCopyWith != bVar2) {
                this.f5904u = null;
                this.f5900q = jElapsedRealtime;
                if (c0072a == hlsPlaylistTracker.f5892w) {
                    if (hlsPlaylistTracker.f5893x == null) {
                        hlsPlaylistTracker.f5894y = !bVarCopyWith.f5922l;
                    }
                    hlsPlaylistTracker.f5893x = bVarCopyWith;
                    ((h) hlsPlaylistTracker.f5887r).onPrimaryPlaylistRefreshed(bVarCopyWith);
                }
                ArrayList arrayList = hlsPlaylistTracker.f5888s;
                int size2 = arrayList.size();
                for (int i15 = 0; i15 < size2; i15++) {
                    ((b) arrayList.get(i15)).onPlaylistChanged();
                }
            } else if (!bVarCopyWith.f5922l) {
                if (list.size() + i11 < this.f5898o.f5918h) {
                    String str = c0072a.f5911a;
                    this.f5904u = new PlaylistResetException();
                } else if (jElapsedRealtime - this.f5900q > c5.b.usToMs(r7.f5920j) * 3.5d) {
                    String str2 = c0072a.f5911a;
                    this.f5904u = new PlaylistStuckException();
                    a();
                }
            }
            com.google.android.exoplayer2.source.hls.playlist.b bVar5 = this.f5898o;
            long j10 = bVar5.f5920j;
            if (bVar5 == bVar2) {
                j10 /= 2;
            }
            this.f5901r = c5.b.usToMs(j10) + jElapsedRealtime;
            if (c0072a != hlsPlaylistTracker.f5892w || this.f5898o.f5922l) {
                return;
            }
            loadPlaylist();
        }

        public com.google.android.exoplayer2.source.hls.playlist.b getPlaylistSnapshot() {
            return this.f5898o;
        }

        public boolean isSnapshotValid() {
            int i10;
            if (this.f5898o == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, c5.b.usToMs(this.f5898o.f5926p));
            com.google.android.exoplayer2.source.hls.playlist.b bVar = this.f5898o;
            return bVar.f5922l || (i10 = bVar.f5913c) == 2 || i10 == 1 || this.f5899p + jMax > jElapsedRealtime;
        }

        public void loadPlaylist() {
            this.f5902s = 0L;
            if (this.f5903t) {
                return;
            }
            Loader loader = this.f5896m;
            if (loader.isLoading()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = this.f5901r;
            HlsPlaylistTracker hlsPlaylistTracker = HlsPlaylistTracker.this;
            if (jElapsedRealtime < j10) {
                this.f5903t = true;
                hlsPlaylistTracker.f5886q.postDelayed(this, j10 - jElapsedRealtime);
            } else {
                loader.startLoading(this.f5897n, this, hlsPlaylistTracker.f5884o);
            }
        }

        public void maybeThrowPlaylistRefreshError() throws IOException {
            this.f5896m.maybeThrowError();
            IOException iOException = this.f5904u;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.a<z5.a> aVar, long j10, long j11, boolean z10) {
            HlsPlaylistTracker.this.f5890u.loadCanceled(aVar.f6042a, 4, j10, j11, aVar.bytesLoaded());
        }

        public void release() {
            this.f5896m.release();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5903t = false;
            this.f5896m.startLoading(this.f5897n, this, HlsPlaylistTracker.this.f5884o);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.a<z5.a> aVar, long j10, long j11) {
            z5.a result = aVar.getResult();
            if (!(result instanceof com.google.android.exoplayer2.source.hls.playlist.b)) {
                this.f5904u = new ParserException("Loaded playlist has unexpected type.");
            } else {
                b((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.f5890u.loadCompleted(aVar.f6042a, 4, j10, j11, aVar.bytesLoaded());
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public int onLoadError(com.google.android.exoplayer2.upstream.a<z5.a> aVar, long j10, long j11, IOException iOException) {
            boolean z10 = iOException instanceof ParserException;
            HlsPlaylistTracker.this.f5890u.loadError(aVar.f6042a, 4, j10, j11, aVar.bytesLoaded(), iOException, z10);
            if (z10) {
                return 3;
            }
            return v5.h.shouldBlacklist(iOException) ? a() : true ? 0 : 2;
        }
    }

    public interface b {
        void onPlaylistBlacklisted(a.C0072a c0072a, long j10);

        void onPlaylistChanged();
    }

    public interface c {
    }

    public HlsPlaylistTracker(Uri uri, d dVar, a.C0284a c0284a, int i10, c cVar, a.InterfaceC0074a<z5.a> interfaceC0074a) {
        this.f5881b = uri;
        this.f5882m = dVar;
        this.f5890u = c0284a;
        this.f5884o = i10;
        this.f5887r = cVar;
        this.f5883n = interfaceC0074a;
    }

    public void addListener(b bVar) {
        this.f5888s.add(bVar);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a getMasterPlaylist() {
        return this.f5891v;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b getPlaylistSnapshot(a.C0072a c0072a) {
        com.google.android.exoplayer2.source.hls.playlist.b bVar;
        IdentityHashMap<a.C0072a, a> identityHashMap = this.f5885p;
        com.google.android.exoplayer2.source.hls.playlist.b playlistSnapshot = identityHashMap.get(c0072a).getPlaylistSnapshot();
        if (playlistSnapshot != null && c0072a != this.f5892w && this.f5891v.f5906c.contains(c0072a) && ((bVar = this.f5893x) == null || !bVar.f5922l)) {
            this.f5892w = c0072a;
            identityHashMap.get(c0072a).loadPlaylist();
        }
        return playlistSnapshot;
    }

    public boolean isLive() {
        return this.f5894y;
    }

    public boolean isSnapshotValid(a.C0072a c0072a) {
        return this.f5885p.get(c0072a).isSnapshotValid();
    }

    public void maybeThrowPlaylistRefreshError(a.C0072a c0072a) throws IOException {
        this.f5885p.get(c0072a).maybeThrowPlaylistRefreshError();
    }

    public void maybeThrowPrimaryPlaylistRefreshError() throws IOException {
        this.f5889t.maybeThrowError();
        a.C0072a c0072a = this.f5892w;
        if (c0072a != null) {
            maybeThrowPlaylistRefreshError(c0072a);
        }
    }

    public void refreshPlaylist(a.C0072a c0072a) {
        this.f5885p.get(c0072a).loadPlaylist();
    }

    public void release() {
        this.f5889t.release();
        IdentityHashMap<a.C0072a, a> identityHashMap = this.f5885p;
        Iterator<a> it = identityHashMap.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.f5886q.removeCallbacksAndMessages(null);
        identityHashMap.clear();
    }

    public void removeListener(b bVar) {
        this.f5888s.remove(bVar);
    }

    public void start() {
        this.f5889t.startLoading(new com.google.android.exoplayer2.upstream.a(((y5.b) this.f5882m).createDataSource(4), this.f5881b, 4, this.f5883n), this, this.f5884o);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCanceled(com.google.android.exoplayer2.upstream.a<z5.a> aVar, long j10, long j11, boolean z10) {
        this.f5890u.loadCanceled(aVar.f6042a, 4, j10, j11, aVar.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void onLoadCompleted(com.google.android.exoplayer2.upstream.a<z5.a> aVar, long j10, long j11) {
        IdentityHashMap<a.C0072a, a> identityHashMap;
        z5.a result = aVar.getResult();
        boolean z10 = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        com.google.android.exoplayer2.source.hls.playlist.a aVarCreateSingleVariantMasterPlaylist = z10 ? com.google.android.exoplayer2.source.hls.playlist.a.createSingleVariantMasterPlaylist(result.f22611a) : (com.google.android.exoplayer2.source.hls.playlist.a) result;
        this.f5891v = aVarCreateSingleVariantMasterPlaylist;
        int i10 = 0;
        this.f5892w = aVarCreateSingleVariantMasterPlaylist.f5906c.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVarCreateSingleVariantMasterPlaylist.f5906c);
        arrayList.addAll(aVarCreateSingleVariantMasterPlaylist.f5907d);
        arrayList.addAll(aVarCreateSingleVariantMasterPlaylist.f5908e);
        int size = arrayList.size();
        while (true) {
            identityHashMap = this.f5885p;
            if (i10 >= size) {
                break;
            }
            a.C0072a c0072a = (a.C0072a) arrayList.get(i10);
            identityHashMap.put(c0072a, new a(c0072a));
            i10++;
        }
        a aVar2 = identityHashMap.get(this.f5892w);
        if (z10) {
            aVar2.b((com.google.android.exoplayer2.source.hls.playlist.b) result);
        } else {
            aVar2.loadPlaylist();
        }
        this.f5890u.loadCompleted(aVar.f6042a, 4, j10, j11, aVar.bytesLoaded());
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int onLoadError(com.google.android.exoplayer2.upstream.a<z5.a> aVar, long j10, long j11, IOException iOException) {
        boolean z10 = iOException instanceof ParserException;
        this.f5890u.loadError(aVar.f6042a, 4, j10, j11, aVar.bytesLoaded(), iOException, z10);
        return z10 ? 3 : 0;
    }
}
