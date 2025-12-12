package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.loopj.android.http.AsyncHttpClient;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: e, reason: collision with root package name */
    public static g f9333e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f9334a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f9335b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    public c f9336c;

    /* renamed from: d, reason: collision with root package name */
    public c f9337d;

    /* compiled from: SnackbarManager.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            g gVar = g.this;
            c cVar = (c) message.obj;
            synchronized (gVar.f9334a) {
                if (gVar.f9336c == cVar || gVar.f9337d == cVar) {
                    gVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    public interface b {
        void dismiss(int i10);

        void show();
    }

    /* compiled from: SnackbarManager.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f9339a;

        /* renamed from: b, reason: collision with root package name */
        public int f9340b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9341c;

        public c(int i10, b bVar) {
            this.f9339a = new WeakReference<>(bVar);
            this.f9340b = i10;
        }
    }

    public static g b() {
        if (f9333e == null) {
            f9333e = new g();
        }
        return f9333e;
    }

    public final boolean a(c cVar, int i10) {
        b bVar = cVar.f9339a.get();
        if (bVar == null) {
            return false;
        }
        this.f9335b.removeCallbacksAndMessages(cVar);
        bVar.dismiss(i10);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.f9336c;
        if (cVar != null) {
            return bVar != null && cVar.f9339a.get() == bVar;
        }
        return false;
    }

    public final void d(c cVar) {
        int i10 = cVar.f9340b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            i10 = i10 == -1 ? AsyncHttpClient.DEFAULT_RETRY_SLEEP_TIME_MILLIS : 2750;
        }
        Handler handler = this.f9335b;
        handler.removeCallbacksAndMessages(cVar);
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    public void dismiss(b bVar, int i10) {
        synchronized (this.f9334a) {
            if (c(bVar)) {
                a(this.f9336c, i10);
            } else {
                c cVar = this.f9337d;
                boolean z10 = false;
                if (cVar != null) {
                    if (bVar != null && cVar.f9339a.get() == bVar) {
                        z10 = true;
                    }
                }
                if (z10) {
                    a(this.f9337d, i10);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isCurrentOrNext(com.google.android.material.snackbar.g.b r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f9334a
            monitor-enter(r0)
            boolean r1 = r4.c(r5)     // Catch: java.lang.Throwable -> L27
            r2 = 1
            if (r1 != 0) goto L25
            com.google.android.material.snackbar.g$c r1 = r4.f9337d     // Catch: java.lang.Throwable -> L27
            r3 = 0
            if (r1 == 0) goto L20
            if (r5 == 0) goto L1b
            java.lang.ref.WeakReference<com.google.android.material.snackbar.g$b> r1 = r1.f9339a     // Catch: java.lang.Throwable -> L27
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L27
            if (r1 != r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r5 == 0) goto L20
            r5 = 1
            goto L21
        L20:
            r5 = 0
        L21:
            if (r5 == 0) goto L24
            goto L25
        L24:
            r2 = 0
        L25:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
            return r2
        L27:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L27
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.g.isCurrentOrNext(com.google.android.material.snackbar.g$b):boolean");
    }

    public void onDismissed(b bVar) {
        synchronized (this.f9334a) {
            if (c(bVar)) {
                this.f9336c = null;
                c cVar = this.f9337d;
                if (cVar != null && cVar != null) {
                    this.f9336c = cVar;
                    this.f9337d = null;
                    b bVar2 = cVar.f9339a.get();
                    if (bVar2 != null) {
                        bVar2.show();
                    } else {
                        this.f9336c = null;
                    }
                }
            }
        }
    }

    public void onShown(b bVar) {
        synchronized (this.f9334a) {
            if (c(bVar)) {
                d(this.f9336c);
            }
        }
    }

    public void pauseTimeout(b bVar) {
        synchronized (this.f9334a) {
            if (c(bVar)) {
                c cVar = this.f9336c;
                if (!cVar.f9341c) {
                    cVar.f9341c = true;
                    this.f9335b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void restoreTimeoutIfPaused(b bVar) {
        synchronized (this.f9334a) {
            if (c(bVar)) {
                c cVar = this.f9336c;
                if (cVar.f9341c) {
                    cVar.f9341c = false;
                    d(cVar);
                }
            }
        }
    }

    public void show(int i10, b bVar) {
        synchronized (this.f9334a) {
            if (c(bVar)) {
                c cVar = this.f9336c;
                cVar.f9340b = i10;
                this.f9335b.removeCallbacksAndMessages(cVar);
                d(this.f9336c);
                return;
            }
            c cVar2 = this.f9337d;
            boolean z10 = false;
            if (cVar2 != null) {
                if (bVar != null && cVar2.f9339a.get() == bVar) {
                    z10 = true;
                }
            }
            if (z10) {
                this.f9337d.f9340b = i10;
            } else {
                this.f9337d = new c(i10, bVar);
            }
            c cVar3 = this.f9336c;
            if (cVar3 == null || !a(cVar3, 4)) {
                this.f9336c = null;
                c cVar4 = this.f9337d;
                if (cVar4 != null) {
                    this.f9336c = cVar4;
                    this.f9337d = null;
                    b bVar2 = cVar4.f9339a.get();
                    if (bVar2 != null) {
                        bVar2.show();
                    } else {
                        this.f9336c = null;
                    }
                }
            }
        }
    }
}
