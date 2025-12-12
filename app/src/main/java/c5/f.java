package c5;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c5.d;
import c5.g;
import c5.r;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import l6.u;
import u5.h;

/* compiled from: ExoPlayerImpl.java */
/* loaded from: classes.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public final o[] f5046a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.h f5047b;

    /* renamed from: c, reason: collision with root package name */
    public final j6.g f5048c;

    /* renamed from: d, reason: collision with root package name */
    public final a f5049d;

    /* renamed from: e, reason: collision with root package name */
    public final g f5050e;

    /* renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<n> f5051f;

    /* renamed from: g, reason: collision with root package name */
    public final r.c f5052g;

    /* renamed from: h, reason: collision with root package name */
    public final r.b f5053h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5054i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5055j;

    /* renamed from: k, reason: collision with root package name */
    public int f5056k;

    /* renamed from: l, reason: collision with root package name */
    public int f5057l;

    /* renamed from: m, reason: collision with root package name */
    public int f5058m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5059n;

    /* renamed from: o, reason: collision with root package name */
    public r f5060o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5061p;

    /* renamed from: q, reason: collision with root package name */
    public u5.o f5062q;

    /* renamed from: r, reason: collision with root package name */
    public j6.g f5063r;

    /* renamed from: s, reason: collision with root package name */
    public m f5064s;

    /* renamed from: t, reason: collision with root package name */
    public g.b f5065t;

    /* renamed from: u, reason: collision with root package name */
    public int f5066u;

    /* renamed from: v, reason: collision with root package name */
    public long f5067v;

    /* compiled from: ExoPlayerImpl.java */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar = f.this;
            fVar.getClass();
            int i10 = message.what;
            CopyOnWriteArraySet<n> copyOnWriteArraySet = fVar.f5051f;
            switch (i10) {
                case 0:
                    fVar.f5058m--;
                    return;
                case 1:
                    fVar.f5056k = message.arg1;
                    Iterator<n> it = copyOnWriteArraySet.iterator();
                    while (it.hasNext()) {
                        it.next().onPlayerStateChanged(fVar.f5055j, fVar.f5056k);
                    }
                    return;
                case 2:
                    fVar.f5059n = message.arg1 != 0;
                    Iterator<n> it2 = copyOnWriteArraySet.iterator();
                    while (it2.hasNext()) {
                        it2.next().onLoadingChanged(fVar.f5059n);
                    }
                    return;
                case 3:
                    if (fVar.f5058m == 0) {
                        j6.i iVar = (j6.i) message.obj;
                        fVar.f5054i = true;
                        fVar.f5062q = iVar.f14668a;
                        fVar.f5063r = iVar.f14669b;
                        fVar.f5047b.onSelectionActivated(iVar.f14670c);
                        Iterator<n> it3 = copyOnWriteArraySet.iterator();
                        while (it3.hasNext()) {
                            it3.next().onTracksChanged(fVar.f5062q, fVar.f5063r);
                        }
                        return;
                    }
                    return;
                case 4:
                    int i11 = fVar.f5057l - 1;
                    fVar.f5057l = i11;
                    if (i11 == 0) {
                        fVar.f5065t = (g.b) message.obj;
                        if (fVar.f5060o.isEmpty()) {
                            fVar.f5066u = 0;
                            fVar.f5067v = 0L;
                        }
                        if (message.arg1 != 0) {
                            Iterator<n> it4 = copyOnWriteArraySet.iterator();
                            while (it4.hasNext()) {
                                it4.next().onPositionDiscontinuity();
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (fVar.f5057l == 0) {
                        fVar.f5065t = (g.b) message.obj;
                        Iterator<n> it5 = copyOnWriteArraySet.iterator();
                        while (it5.hasNext()) {
                            it5.next().onPositionDiscontinuity();
                        }
                        return;
                    }
                    return;
                case 6:
                    g.d dVar = (g.d) message.obj;
                    int i12 = fVar.f5057l - dVar.f5112d;
                    fVar.f5057l = i12;
                    if (fVar.f5058m == 0) {
                        r rVar = dVar.f5109a;
                        fVar.f5060o = rVar;
                        fVar.f5061p = dVar.f5110b;
                        fVar.f5065t = dVar.f5111c;
                        if (i12 == 0 && rVar.isEmpty()) {
                            fVar.f5066u = 0;
                            fVar.f5067v = 0L;
                        }
                        Iterator<n> it6 = copyOnWriteArraySet.iterator();
                        while (it6.hasNext()) {
                            it6.next().onTimelineChanged(fVar.f5060o, fVar.f5061p);
                        }
                        return;
                    }
                    return;
                case 7:
                    m mVar = (m) message.obj;
                    if (fVar.f5064s.equals(mVar)) {
                        return;
                    }
                    fVar.f5064s = mVar;
                    Iterator<n> it7 = copyOnWriteArraySet.iterator();
                    while (it7.hasNext()) {
                        it7.next().onPlaybackParametersChanged(mVar);
                    }
                    return;
                case 8:
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                    Iterator<n> it8 = copyOnWriteArraySet.iterator();
                    while (it8.hasNext()) {
                        it8.next().onPlayerError(exoPlaybackException);
                    }
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public f(o[] oVarArr, j6.h hVar, k kVar) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.5.4] [" + u.f15911e + "]");
        l6.a.checkState(oVarArr.length > 0);
        this.f5046a = (o[]) l6.a.checkNotNull(oVarArr);
        this.f5047b = (j6.h) l6.a.checkNotNull(hVar);
        this.f5055j = false;
        this.f5056k = 1;
        this.f5051f = new CopyOnWriteArraySet<>();
        j6.g gVar = new j6.g(new j6.f[oVarArr.length]);
        this.f5048c = gVar;
        this.f5060o = r.f5148a;
        this.f5052g = new r.c();
        this.f5053h = new r.b();
        this.f5062q = u5.o.f20110d;
        this.f5063r = gVar;
        this.f5064s = m.f5142d;
        a aVar = new a(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.f5049d = aVar;
        g.b bVar = new g.b(0, 0L);
        this.f5065t = bVar;
        this.f5050e = new g(oVarArr, hVar, kVar, this.f5055j, 0, aVar, bVar, this);
    }

    public final long a(long j10) {
        long jUsToMs = b.usToMs(j10);
        if (this.f5065t.f5101a.isAd()) {
            return jUsToMs;
        }
        r rVar = this.f5060o;
        int i10 = this.f5065t.f5101a.f20054a;
        r.b bVar = this.f5053h;
        rVar.getPeriod(i10, bVar);
        return jUsToMs + bVar.getPositionInWindowMs();
    }

    public void addListener(n nVar) {
        this.f5051f.add(nVar);
    }

    public void blockingSendMessages(d.b... bVarArr) {
        this.f5050e.blockingSendMessages(bVarArr);
    }

    public int getBufferedPercentage() {
        if (this.f5060o.isEmpty()) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return u.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public long getBufferedPosition() {
        return (this.f5060o.isEmpty() || this.f5057l > 0) ? this.f5067v : a(this.f5065t.f5105e);
    }

    public long getCurrentPosition() {
        return (this.f5060o.isEmpty() || this.f5057l > 0) ? this.f5067v : a(this.f5065t.f5104d);
    }

    public int getCurrentWindowIndex() {
        return (this.f5060o.isEmpty() || this.f5057l > 0) ? this.f5066u : this.f5060o.getPeriod(this.f5065t.f5101a.f20054a, this.f5053h).f5151c;
    }

    public long getDuration() {
        if (this.f5060o.isEmpty()) {
            return -9223372036854775807L;
        }
        if (!isPlayingAd()) {
            return this.f5060o.getWindow(getCurrentWindowIndex(), this.f5052g).getDurationMs();
        }
        h.b bVar = this.f5065t.f5101a;
        r rVar = this.f5060o;
        int i10 = bVar.f20054a;
        r.b bVar2 = this.f5053h;
        rVar.getPeriod(i10, bVar2);
        return b.usToMs(bVar2.getAdDurationUs(bVar.f20055b, bVar.f20056c));
    }

    public boolean getPlayWhenReady() {
        return this.f5055j;
    }

    public int getPlaybackState() {
        return this.f5056k;
    }

    public boolean isPlayingAd() {
        return !this.f5060o.isEmpty() && this.f5057l == 0 && this.f5065t.f5101a.isAd();
    }

    public void prepare(u5.h hVar) {
        prepare(hVar, true, true);
    }

    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.5.4] [" + u.f15911e + "] [" + h.registeredModules() + "]");
        this.f5050e.release();
        this.f5049d.removeCallbacksAndMessages(null);
    }

    public void seekTo(long j10) {
        seekTo(getCurrentWindowIndex(), j10);
    }

    public void sendMessages(d.b... bVarArr) {
        this.f5050e.sendMessages(bVarArr);
    }

    public void setPlayWhenReady(boolean z10) {
        if (this.f5055j != z10) {
            this.f5055j = z10;
            this.f5050e.setPlayWhenReady(z10);
            Iterator<n> it = this.f5051f.iterator();
            while (it.hasNext()) {
                it.next().onPlayerStateChanged(z10, this.f5056k);
            }
        }
    }

    public void stop() {
        this.f5050e.stop();
    }

    public void prepare(u5.h hVar, boolean z10, boolean z11) {
        if (z11) {
            boolean zIsEmpty = this.f5060o.isEmpty();
            CopyOnWriteArraySet<n> copyOnWriteArraySet = this.f5051f;
            if (!zIsEmpty || this.f5061p != null) {
                this.f5060o = r.f5148a;
                this.f5061p = null;
                Iterator<n> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    it.next().onTimelineChanged(this.f5060o, this.f5061p);
                }
            }
            if (this.f5054i) {
                this.f5054i = false;
                this.f5062q = u5.o.f20110d;
                this.f5063r = this.f5048c;
                this.f5047b.onSelectionActivated(null);
                Iterator<n> it2 = copyOnWriteArraySet.iterator();
                while (it2.hasNext()) {
                    it2.next().onTracksChanged(this.f5062q, this.f5063r);
                }
            }
        }
        this.f5058m++;
        this.f5050e.prepare(hVar, z10);
    }

    public void seekTo(int i10, long j10) {
        if (i10 < 0 || (!this.f5060o.isEmpty() && i10 >= this.f5060o.getWindowCount())) {
            throw new IllegalSeekPositionException(this.f5060o, i10, j10);
        }
        this.f5057l++;
        this.f5066u = i10;
        if (!this.f5060o.isEmpty()) {
            r rVar = this.f5060o;
            r.c cVar = this.f5052g;
            rVar.getWindow(i10, cVar);
            long defaultPositionUs = j10 == -9223372036854775807L ? cVar.getDefaultPositionUs() : b.msToUs(j10);
            int i11 = cVar.f5162c;
            long positionInFirstPeriodUs = cVar.getPositionInFirstPeriodUs() + defaultPositionUs;
            r rVar2 = this.f5060o;
            r.b bVar = this.f5053h;
            long durationUs = rVar2.getPeriod(i11, bVar).getDurationUs();
            while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i11 < cVar.f5163d) {
                positionInFirstPeriodUs -= durationUs;
                i11++;
                durationUs = this.f5060o.getPeriod(i11, bVar).getDurationUs();
            }
        }
        g gVar = this.f5050e;
        if (j10 == -9223372036854775807L) {
            this.f5067v = 0L;
            gVar.seekTo(this.f5060o, i10, -9223372036854775807L);
            return;
        }
        this.f5067v = j10;
        gVar.seekTo(this.f5060o, i10, b.msToUs(j10));
        Iterator<n> it = this.f5051f.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity();
        }
    }
}
