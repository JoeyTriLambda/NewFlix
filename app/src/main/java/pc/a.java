package pc;

import ad.c;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import b6.i;
import c5.d;
import c5.m;
import c5.n;
import c5.o;
import c5.r;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import j6.a;
import j6.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import m6.g;
import q5.e;
import u5.h;

/* compiled from: ExoMediaPlayer.java */
/* loaded from: classes2.dex */
public final class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17647a;

    /* renamed from: b, reason: collision with root package name */
    public final c5.d f17648b;

    /* renamed from: c, reason: collision with root package name */
    public final j6.c f17649c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f17650d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<qc.a> f17651e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f17652f = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    public boolean f17653g = false;

    /* renamed from: h, reason: collision with root package name */
    public final e f17654h = new e();

    /* renamed from: i, reason: collision with root package name */
    public final ad.c f17655i;

    /* renamed from: j, reason: collision with root package name */
    public Surface f17656j;

    /* renamed from: k, reason: collision with root package name */
    public f f17657k;

    /* renamed from: l, reason: collision with root package name */
    public h f17658l;

    /* renamed from: m, reason: collision with root package name */
    public final List<o> f17659m;

    /* renamed from: n, reason: collision with root package name */
    public final sc.a f17660n;

    /* renamed from: o, reason: collision with root package name */
    public final k6.h f17661o;

    /* renamed from: p, reason: collision with root package name */
    public qc.b f17662p;

    /* renamed from: q, reason: collision with root package name */
    public xc.a f17663q;

    /* renamed from: r, reason: collision with root package name */
    public final b f17664r;

    /* compiled from: ExoMediaPlayer.java */
    /* renamed from: pc.a$a, reason: collision with other inner class name */
    public class C0223a implements c.b {
        public C0223a() {
        }

        @Override // ad.c.b
        public void onRepeat() {
            a aVar = a.this;
            xc.a aVar2 = aVar.f17663q;
            if (aVar2 != null) {
                aVar2.onBufferingUpdate(aVar.getBufferedPercentage());
            }
        }
    }

    /* compiled from: ExoMediaPlayer.java */
    public class d implements f {
        public d() {
        }

        public byte[] executeKeyRequest(UUID uuid, d.a aVar) throws Exception {
            f fVar = a.this.f17657k;
            return fVar != null ? ((d) fVar).executeKeyRequest(uuid, aVar) : new byte[0];
        }

        public byte[] executeProvisionRequest(UUID uuid, d.c cVar) throws Exception {
            f fVar = a.this.f17657k;
            return fVar != null ? ((d) fVar).executeProvisionRequest(uuid, cVar) : new byte[0];
        }
    }

    /* compiled from: ExoMediaPlayer.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f17669a = {1, 1, 1, 1};

        public int getMostRecentState() {
            return this.f17669a[3];
        }

        public int getState(boolean z10, int i10) {
            return (z10 ? -268435456 : 0) | i10;
        }

        public boolean isLastReportedPlayWhenReady() {
            return (this.f17669a[3] & (-268435456)) != 0;
        }

        public boolean matchesHistory(int[] iArr, boolean z10) {
            int i10 = z10 ? 268435455 : -1;
            int[] iArr2 = this.f17669a;
            int length = iArr2.length - iArr.length;
            boolean z11 = true;
            for (int i11 = length; i11 < iArr2.length; i11++) {
                z11 &= (iArr2[i11] & i10) == (iArr[i11 - length] & i10);
            }
            return z11;
        }

        public void reset() {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f17669a;
                if (i10 >= iArr.length) {
                    return;
                }
                iArr[i10] = 1;
                i10++;
            }
        }

        public void setMostRecentState(boolean z10, int i10) {
            int state = getState(z10, i10);
            int[] iArr = this.f17669a;
            int i11 = iArr[3];
            if (i11 == state) {
                return;
            }
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = i11;
            iArr[3] = i10;
        }
    }

    public a(Context context) {
        ad.c cVar = new ad.c();
        this.f17655i = cVar;
        this.f17659m = new LinkedList();
        this.f17660n = new sc.a();
        k6.h hVar = new k6.h();
        this.f17661o = hVar;
        this.f17664r = new b();
        this.f17647a = context;
        cVar.setRepeaterDelay(1000);
        cVar.setRepeatListener(new C0223a());
        Handler handler = new Handler();
        this.f17650d = handler;
        c cVar2 = new c();
        rc.a aVar = new rc.a(context, handler, cVar2, cVar2, cVar2, cVar2);
        aVar.setDrmSessionManager(generateDrmSessionManager());
        List<o> listGenerate = aVar.generate();
        this.f17659m = listGenerate;
        j6.c cVar3 = new j6.c(new a.C0169a(hVar));
        this.f17649c = cVar3;
        HashMap map = mc.a.f16262a;
        c5.d dVarNewInstance = c5.e.newInstance((o[]) listGenerate.toArray(new o[listGenerate.size()]), cVar3, new c5.c());
        this.f17648b = dVarNewInstance;
        ((c5.f) dVarNewInstance).addListener(this);
    }

    public final void a(boolean z10) {
        ad.c cVar = this.f17655i;
        if (!z10 || this.f17663q == null) {
            cVar.stop();
        } else {
            cVar.start();
        }
    }

    public void addListener(qc.a aVar) {
        if (aVar != null) {
            this.f17651e.add(aVar);
        }
    }

    public void blockingClearSurface() {
        Surface surface = this.f17656j;
        if (surface != null) {
            surface.release();
        }
        this.f17656j = null;
        sendMessage(2, 1, null, true);
    }

    public void forcePrepare() {
        this.f17653g = false;
    }

    public f5.a<f5.c> generateDrmSessionManager() {
        UUID uuid = c5.b.f5034d;
        try {
            return new com.google.android.exoplayer2.drm.a(uuid, com.google.android.exoplayer2.drm.e.newInstance(uuid), new d(), null, this.f17650d, this.f17664r);
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<ExoMedia$RendererType, u5.o> getAvailableTracks() {
        if (getPlaybackState() == 1) {
            return null;
        }
        b0.b bVar = new b0.b();
        e.a currentMappedTrackInfo = this.f17649c.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            return bVar;
        }
        ExoMedia$RendererType[] exoMedia$RendererTypeArr = {ExoMedia$RendererType.AUDIO, ExoMedia$RendererType.VIDEO, ExoMedia$RendererType.CLOSED_CAPTION, ExoMedia$RendererType.METADATA};
        for (int i10 = 0; i10 < 4; i10++) {
            ExoMedia$RendererType exoMedia$RendererType = exoMedia$RendererTypeArr[i10];
            int exoPlayerTrackType = getExoPlayerTrackType(exoMedia$RendererType);
            if (currentMappedTrackInfo.f14663a > exoPlayerTrackType) {
                bVar.put(exoMedia$RendererType, currentMappedTrackInfo.getTrackGroups(exoPlayerTrackType));
            }
        }
        return bVar;
    }

    public int getBufferedPercentage() {
        return ((c5.f) this.f17648b).getBufferedPercentage();
    }

    public long getCurrentPosition() {
        return ((c5.f) this.f17648b).getCurrentPosition();
    }

    public long getDuration() {
        return ((c5.f) this.f17648b).getDuration();
    }

    public int getExoPlayerTrackType(ExoMedia$RendererType exoMedia$RendererType) {
        int iOrdinal = exoMedia$RendererType.ordinal();
        if (iOrdinal == 0) {
            return 1;
        }
        if (iOrdinal == 1) {
            return 2;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? -1 : 4;
        }
        return 3;
    }

    public boolean getPlayWhenReady() {
        return ((c5.f) this.f17648b).getPlayWhenReady();
    }

    public int getPlaybackState() {
        return ((c5.f) this.f17648b).getPlaybackState();
    }

    @Override // c5.n
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Iterator<qc.a> it = this.f17651e.iterator();
        while (it.hasNext()) {
            it.next().onError(this, exoPlaybackException);
        }
    }

    @Override // c5.n
    public void onPlayerStateChanged(boolean z10, int i10) {
        boolean playWhenReady = ((c5.f) this.f17648b).getPlayWhenReady();
        int playbackState = getPlaybackState();
        e eVar = this.f17654h;
        int state = eVar.getState(playWhenReady, playbackState);
        if (state != eVar.getMostRecentState()) {
            eVar.setMostRecentState(playWhenReady, playbackState);
            if (state == 3) {
                a(true);
            } else if (state == 1 || state == 4) {
                a(false);
            }
            boolean zMatchesHistory = eVar.matchesHistory(new int[]{100, 3, 2, 3}, true) | eVar.matchesHistory(new int[]{100, 2, 3}, true) | eVar.matchesHistory(new int[]{2, 100, 3}, true);
            Iterator<qc.a> it = this.f17651e.iterator();
            while (it.hasNext()) {
                qc.a next = it.next();
                next.onStateChanged(playWhenReady, playbackState);
                if (zMatchesHistory) {
                    next.onSeekComplete();
                }
            }
        }
    }

    public void prepare() {
        if (this.f17653g || this.f17658l == null) {
            return;
        }
        boolean zIsEmpty = this.f17659m.isEmpty();
        c5.d dVar = this.f17648b;
        if (!zIsEmpty) {
            ((c5.f) dVar).stop();
        }
        this.f17654h.reset();
        ((c5.f) dVar).prepare(this.f17658l);
        this.f17653g = true;
        this.f17652f.set(false);
    }

    public void release() {
        a(false);
        this.f17651e.clear();
        this.f17656j = null;
        ((c5.f) this.f17648b).release();
        stayAwake(false);
    }

    public void removeListener(qc.a aVar) {
        if (aVar != null) {
            this.f17651e.remove(aVar);
        }
    }

    public void seekTo(long j10) {
        ((c5.f) this.f17648b).seekTo(j10);
        e eVar = this.f17654h;
        eVar.setMostRecentState(eVar.isLastReportedPlayWhenReady(), 100);
    }

    public void sendMessage(int i10, int i11, Object obj) {
        sendMessage(i10, i11, obj, false);
    }

    public void setBufferUpdateListener(xc.a aVar) {
        this.f17663q = aVar;
        a(aVar != null);
    }

    public void setDrmCallback(f fVar) {
        this.f17657k = fVar;
    }

    public void setMediaSource(h hVar) {
        this.f17658l = hVar;
        this.f17653g = false;
        prepare();
    }

    public void setMetadataListener(qc.b bVar) {
        this.f17662p = bVar;
    }

    public void setPlayWhenReady(boolean z10) {
        ((c5.f) this.f17648b).setPlayWhenReady(z10);
        stayAwake(z10);
    }

    public void setSurface(Surface surface) {
        this.f17656j = surface;
        sendMessage(2, 1, surface, false);
    }

    public void setUri(Uri uri) {
        h hVarGenerate;
        if (uri != null) {
            hVarGenerate = this.f17660n.generate(this.f17647a, this.f17650d, uri, this.f17661o);
        } else {
            hVarGenerate = null;
        }
        setMediaSource(hVarGenerate);
    }

    public void setVolume(float f10) {
        sendMessage(1, 2, Float.valueOf(f10));
    }

    public void stop() {
        if (this.f17652f.getAndSet(true)) {
            return;
        }
        c5.d dVar = this.f17648b;
        ((c5.f) dVar).setPlayWhenReady(false);
        ((c5.f) dVar).stop();
    }

    public void sendMessage(int i10, int i11, Object obj, boolean z10) {
        List<o> list = this.f17659m;
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (o oVar : list) {
            if (oVar.getTrackType() == i10) {
                arrayList.add(new d.b(oVar, i11, obj));
            }
        }
        c5.d dVar = this.f17648b;
        if (z10) {
            ((c5.f) dVar).blockingSendMessages((d.b[]) arrayList.toArray(new d.b[arrayList.size()]));
        } else {
            ((c5.f) dVar).sendMessages((d.b[]) arrayList.toArray(new d.b[arrayList.size()]));
        }
    }

    /* compiled from: ExoMediaPlayer.java */
    public class b implements a.c {
        public b() {
        }

        public void onDrmSessionManagerError(Exception exc) {
            a.this.getClass();
        }

        public void onDrmKeysLoaded() {
        }

        public void onDrmKeysRestored() {
        }
    }

    @Override // c5.n
    public void onPositionDiscontinuity() {
    }

    /* compiled from: ExoMediaPlayer.java */
    public class c implements g, com.google.android.exoplayer2.audio.a, i.a, e.a {
        public c() {
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onAudioDisabled(e5.d dVar) {
            a.this.getClass();
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onAudioSessionId(int i10) {
            a.this.getClass();
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onAudioTrackUnderrun(int i10, long j10, long j11) {
            a.this.getClass();
        }

        @Override // b6.i.a
        public void onCues(List<b6.a> list) {
            a.this.getClass();
        }

        @Override // q5.e.a
        public void onMetadata(q5.a aVar) {
            qc.b bVar = a.this.f17662p;
            if (bVar != null) {
                bVar.onMetadata(aVar);
            }
        }

        @Override // m6.g
        public void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
            Iterator<qc.a> it = a.this.f17651e.iterator();
            while (it.hasNext()) {
                it.next().onVideoSizeChanged(i10, i11, i12, f10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onAudioEnabled(e5.d dVar) {
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onAudioInputFormatChanged(c5.i iVar) {
        }

        @Override // m6.g
        public void onRenderedFirstFrame(Surface surface) {
        }

        @Override // m6.g
        public void onVideoDisabled(e5.d dVar) {
        }

        @Override // m6.g
        public void onVideoEnabled(e5.d dVar) {
        }

        @Override // m6.g
        public void onVideoInputFormatChanged(c5.i iVar) {
        }

        @Override // m6.g
        public void onDroppedFrames(int i10, long j10) {
        }

        @Override // com.google.android.exoplayer2.audio.a
        public void onAudioDecoderInitialized(String str, long j10, long j11) {
        }

        @Override // m6.g
        public void onVideoDecoderInitialized(String str, long j10, long j11) {
        }
    }

    @Override // c5.n
    public void onLoadingChanged(boolean z10) {
    }

    @Override // c5.n
    public void onPlaybackParametersChanged(m mVar) {
    }

    public void stayAwake(boolean z10) {
    }

    @Override // c5.n
    public void onTimelineChanged(r rVar, Object obj) {
    }

    @Override // c5.n
    public void onTracksChanged(u5.o oVar, j6.g gVar) {
    }
}
