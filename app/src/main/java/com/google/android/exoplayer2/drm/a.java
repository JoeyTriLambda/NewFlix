package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.drm.d;
import f5.b;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import k5.h;
import l6.u;
import pc.a;

/* compiled from: DefaultDrmSessionManager.java */
@TargetApi(18)
/* loaded from: classes.dex */
public final class a<T extends f5.b> implements f5.a<T>, DrmSession<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f5806a;

    /* renamed from: b, reason: collision with root package name */
    public final c f5807b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.d<T> f5808c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f5809d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.f f5810e;

    /* renamed from: f, reason: collision with root package name */
    public final UUID f5811f;

    /* renamed from: g, reason: collision with root package name */
    public a<T>.e f5812g;

    /* renamed from: h, reason: collision with root package name */
    public a<T>.g f5813h;

    /* renamed from: i, reason: collision with root package name */
    public Looper f5814i;

    /* renamed from: j, reason: collision with root package name */
    public HandlerThread f5815j;

    /* renamed from: k, reason: collision with root package name */
    public f f5816k;

    /* renamed from: l, reason: collision with root package name */
    public int f5817l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5818m;

    /* renamed from: n, reason: collision with root package name */
    public int f5819n;

    /* renamed from: o, reason: collision with root package name */
    public T f5820o;

    /* renamed from: p, reason: collision with root package name */
    public DrmSession.DrmSessionException f5821p;

    /* renamed from: q, reason: collision with root package name */
    public byte[] f5822q;

    /* renamed from: r, reason: collision with root package name */
    public String f5823r;

    /* renamed from: s, reason: collision with root package name */
    public byte[] f5824s;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f5825t;

    /* compiled from: DefaultDrmSessionManager.java */
    /* renamed from: com.google.android.exoplayer2.drm.a$a, reason: collision with other inner class name */
    public class RunnableC0070a implements Runnable {
        public RunnableC0070a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((a.b) a.this.f5807b).onDrmKeysRestored();
        }
    }

    /* compiled from: DefaultDrmSessionManager.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Exception f5827b;

        public b(Exception exc) {
            this.f5827b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((a.b) a.this.f5807b).onDrmSessionManagerError(this.f5827b);
        }
    }

    /* compiled from: DefaultDrmSessionManager.java */
    public interface c {
    }

    /* compiled from: DefaultDrmSessionManager.java */
    public class d implements d.b<T> {
        public d() {
        }

        public void onEvent(com.google.android.exoplayer2.drm.d<? extends T> dVar, byte[] bArr, int i10, int i11, byte[] bArr2) {
            a aVar = a.this;
            aVar.getClass();
            aVar.f5812g.sendEmptyMessage(i10);
        }
    }

    /* compiled from: DefaultDrmSessionManager.java */
    @SuppressLint({"HandlerLeak"})
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws NumberFormatException {
            a aVar = a.this;
            if (aVar.f5817l != 0) {
                int i10 = aVar.f5819n;
                if (i10 == 3 || i10 == 4) {
                    int i11 = message.what;
                    if (i11 == 1) {
                        aVar.f5819n = 3;
                        aVar.e();
                    } else if (i11 == 2) {
                        aVar.a();
                    } else if (i11 == 3 && i10 == 4) {
                        aVar.f5819n = 3;
                        aVar.b(new KeysExpiredException());
                    }
                }
            }
        }
    }

    /* compiled from: DefaultDrmSessionManager.java */
    @SuppressLint({"HandlerLeak"})
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = a.this;
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    e = ((a.d) aVar.f5810e).executeProvisionRequest(aVar.f5811f, (d.c) message.obj);
                } else {
                    if (i10 != 1) {
                        throw new RuntimeException();
                    }
                    e = ((a.d) aVar.f5810e).executeKeyRequest(aVar.f5811f, (d.a) message.obj);
                }
            } catch (Exception e10) {
                e = e10;
            }
            aVar.f5813h.obtainMessage(message.what, e).sendToTarget();
        }
    }

    /* compiled from: DefaultDrmSessionManager.java */
    @SuppressLint({"HandlerLeak"})
    public class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws NumberFormatException {
            int i10 = message.what;
            a aVar = a.this;
            if (i10 == 0) {
                Object obj = message.obj;
                aVar.f5818m = false;
                int i11 = aVar.f5819n;
                if (i11 == 2 || i11 == 3 || i11 == 4) {
                    if (obj instanceof Exception) {
                        aVar.b((Exception) obj);
                        return;
                    }
                    try {
                        ((com.google.android.exoplayer2.drm.e) aVar.f5808c).provideProvisionResponse((byte[]) obj);
                        if (aVar.f5819n == 2) {
                            aVar.c(false);
                        } else {
                            aVar.a();
                        }
                        return;
                    } catch (DeniedByServerException e10) {
                        aVar.b(e10);
                        return;
                    }
                }
                return;
            }
            if (i10 != 1) {
                return;
            }
            Object obj2 = message.obj;
            int i12 = aVar.f5819n;
            if (i12 == 3 || i12 == 4) {
                if (obj2 instanceof Exception) {
                    Exception exc = (Exception) obj2;
                    if (exc instanceof NotProvisionedException) {
                        aVar.e();
                        return;
                    } else {
                        aVar.b(exc);
                        return;
                    }
                }
                try {
                    byte[] bArrProvideKeyResponse = ((com.google.android.exoplayer2.drm.e) aVar.f5808c).provideKeyResponse(aVar.f5824s, (byte[]) obj2);
                    if (aVar.f5825t != null && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                        aVar.f5825t = bArrProvideKeyResponse;
                    }
                    aVar.f5819n = 4;
                    Handler handler = aVar.f5806a;
                    if (handler == null || aVar.f5807b == null) {
                        return;
                    }
                    handler.post(new com.google.android.exoplayer2.drm.b(aVar));
                } catch (Exception e11) {
                    if (e11 instanceof NotProvisionedException) {
                        aVar.e();
                    } else {
                        aVar.b(e11);
                    }
                }
            }
        }
    }

    public a(UUID uuid, com.google.android.exoplayer2.drm.d<T> dVar, com.google.android.exoplayer2.drm.f fVar, HashMap<String, String> map, Handler handler, c cVar) {
        this.f5811f = uuid;
        this.f5808c = dVar;
        this.f5810e = fVar;
        this.f5809d = map;
        this.f5806a = handler;
        this.f5807b = cVar;
        ((com.google.android.exoplayer2.drm.e) dVar).setOnEventListener(new d());
    }

    public final void a() throws NumberFormatException {
        long jMin;
        byte[] bArr = this.f5825t;
        boolean z10 = true;
        if (bArr == null) {
            d(1, this.f5824s);
            return;
        }
        try {
            ((com.google.android.exoplayer2.drm.e) this.f5808c).restoreKeys(this.f5824s, bArr);
        } catch (Exception e10) {
            Log.e("OfflineDrmSessionMngr", "Error trying to restore Widevine keys.", e10);
            b(e10);
            z10 = false;
        }
        if (z10) {
            if (c5.b.f5034d.equals(this.f5811f)) {
                Pair<Long, Long> licenseDurationRemainingSec = f5.d.getLicenseDurationRemainingSec(this);
                jMin = Math.min(((Long) licenseDurationRemainingSec.first).longValue(), ((Long) licenseDurationRemainingSec.second).longValue());
            } else {
                jMin = Long.MAX_VALUE;
            }
            if (jMin <= 60) {
                Log.d("OfflineDrmSessionMngr", "Offline license has expired or will expire soon. Remaining seconds: " + jMin);
                d(2, this.f5824s);
                return;
            }
            if (jMin <= 0) {
                b(new KeysExpiredException());
                return;
            }
            this.f5819n = 4;
            Handler handler = this.f5806a;
            if (handler == null || this.f5807b == null) {
                return;
            }
            handler.post(new RunnableC0070a());
        }
    }

    public DrmSession<T> acquireSession(Looper looper, com.google.android.exoplayer2.drm.c cVar) {
        byte[] schemeSpecificData;
        Looper looper2 = this.f5814i;
        l6.a.checkState(looper2 == null || looper2 == looper);
        int i10 = this.f5817l + 1;
        this.f5817l = i10;
        if (i10 != 1) {
            return this;
        }
        if (this.f5814i == null) {
            this.f5814i = looper;
            this.f5812g = new e(looper);
            this.f5813h = new g(looper);
        }
        HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
        this.f5815j = handlerThread;
        handlerThread.start();
        this.f5816k = new f(this.f5815j.getLooper());
        if (this.f5825t == null) {
            UUID uuid = this.f5811f;
            c.b bVar = cVar.get(uuid);
            if (bVar == null) {
                b(new IllegalStateException("Media does not support uuid: " + uuid));
                return this;
            }
            byte[] bArr = bVar.f5841p;
            this.f5822q = bArr;
            this.f5823r = bVar.f5840o;
            int i11 = u.f15907a;
            if (i11 < 21 && (schemeSpecificData = h.parseSchemeSpecificData(bArr, c5.b.f5034d)) != null) {
                this.f5822q = schemeSpecificData;
            }
            if (i11 < 26 && c5.b.f5033c.equals(uuid) && ("video/mp4".equals(this.f5823r) || "audio/mp4".equals(this.f5823r))) {
                this.f5823r = "cenc";
            }
        }
        this.f5819n = 2;
        c(true);
        return this;
    }

    public final void b(Exception exc) {
        this.f5821p = new DrmSession.DrmSessionException(exc);
        Handler handler = this.f5806a;
        if (handler != null && this.f5807b != null) {
            handler.post(new b(exc));
        }
        if (this.f5819n != 4) {
            this.f5819n = 1;
        }
    }

    public final void c(boolean z10) {
        com.google.android.exoplayer2.drm.d<T> dVar = this.f5808c;
        try {
            byte[] bArrOpenSession = ((com.google.android.exoplayer2.drm.e) dVar).openSession();
            this.f5824s = bArrOpenSession;
            this.f5820o = (T) ((com.google.android.exoplayer2.drm.e) dVar).createMediaCrypto(this.f5811f, bArrOpenSession);
            this.f5819n = 3;
            a();
        } catch (NotProvisionedException e10) {
            if (z10) {
                e();
            } else {
                b(e10);
            }
        } catch (Exception e11) {
            b(e11);
        }
    }

    public boolean canAcquireSession(com.google.android.exoplayer2.drm.c cVar) {
        c.b bVar = cVar.get(this.f5811f);
        if (bVar == null) {
            return false;
        }
        String str = bVar.f5839n;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return !("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) || u.f15907a >= 24;
    }

    public final void d(int i10, byte[] bArr) {
        try {
            this.f5816k.obtainMessage(1, ((com.google.android.exoplayer2.drm.e) this.f5808c).getKeyRequest(bArr, this.f5822q, this.f5823r, i10, this.f5809d)).sendToTarget();
        } catch (Exception e10) {
            if (e10 instanceof NotProvisionedException) {
                e();
            } else {
                b(e10);
            }
        }
    }

    public final void e() {
        if (this.f5818m) {
            return;
        }
        this.f5818m = true;
        this.f5816k.obtainMessage(0, ((com.google.android.exoplayer2.drm.e) this.f5808c).getProvisionRequest()).sendToTarget();
    }

    public final DrmSession.DrmSessionException getError() {
        if (this.f5819n == 1) {
            return this.f5821p;
        }
        return null;
    }

    public final T getMediaCrypto() {
        return this.f5820o;
    }

    public final int getState() {
        return this.f5819n;
    }

    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.f5824s;
        if (bArr == null) {
            return null;
        }
        return ((com.google.android.exoplayer2.drm.e) this.f5808c).queryKeyStatus(bArr);
    }

    public void releaseSession(DrmSession<T> drmSession) {
        int i10 = this.f5817l - 1;
        this.f5817l = i10;
        if (i10 != 0) {
            return;
        }
        this.f5819n = 0;
        this.f5818m = false;
        this.f5812g.removeCallbacksAndMessages(null);
        this.f5813h.removeCallbacksAndMessages(null);
        this.f5816k.removeCallbacksAndMessages(null);
        this.f5816k = null;
        this.f5815j.quit();
        this.f5815j = null;
        this.f5822q = null;
        this.f5823r = null;
        this.f5820o = null;
        this.f5821p = null;
        byte[] bArr = this.f5824s;
        if (bArr != null) {
            ((com.google.android.exoplayer2.drm.e) this.f5808c).closeSession(bArr);
            this.f5824s = null;
        }
    }
}
