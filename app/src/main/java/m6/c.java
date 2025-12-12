package m6;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import l6.u;

/* compiled from: DummySurface.java */
@TargetApi(17)
/* loaded from: classes.dex */
public final class c extends Surface {

    /* renamed from: n, reason: collision with root package name */
    public static boolean f16120n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f16121o;

    /* renamed from: b, reason: collision with root package name */
    public final a f16122b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16123m;

    /* compiled from: DummySurface.java */
    public static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        public final int[] f16124b;

        /* renamed from: m, reason: collision with root package name */
        public EGLDisplay f16125m;

        /* renamed from: n, reason: collision with root package name */
        public EGLContext f16126n;

        /* renamed from: o, reason: collision with root package name */
        public EGLSurface f16127o;

        /* renamed from: p, reason: collision with root package name */
        public Handler f16128p;

        /* renamed from: q, reason: collision with root package name */
        public SurfaceTexture f16129q;

        /* renamed from: r, reason: collision with root package name */
        public Error f16130r;

        /* renamed from: s, reason: collision with root package name */
        public RuntimeException f16131s;

        /* renamed from: t, reason: collision with root package name */
        public c f16132t;

        public a() {
            super("dummySurface");
            this.f16124b = new int[1];
        }

        public final void a(boolean z10) {
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            this.f16125m = eGLDisplayEglGetDisplay;
            l6.a.checkState(eGLDisplayEglGetDisplay != null, "eglGetDisplay failed");
            int[] iArr = new int[2];
            l6.a.checkState(EGL14.eglInitialize(this.f16125m, iArr, 0, iArr, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            l6.a.checkState(EGL14.eglChooseConfig(this.f16125m, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f16125m, eGLConfig, EGL14.EGL_NO_CONTEXT, z10 ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
            this.f16126n = eGLContextEglCreateContext;
            l6.a.checkState(eGLContextEglCreateContext != null, "eglCreateContext failed");
            EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f16125m, eGLConfig, z10 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            this.f16127o = eGLSurfaceEglCreatePbufferSurface;
            l6.a.checkState(eGLSurfaceEglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
            EGLDisplay eGLDisplay = this.f16125m;
            EGLSurface eGLSurface = this.f16127o;
            l6.a.checkState(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f16126n), "eglMakeCurrent failed");
            int[] iArr3 = this.f16124b;
            GLES20.glGenTextures(1, iArr3, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(iArr3[0]);
            this.f16129q = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.f16132t = new c(this, this.f16129q);
        }

        public final void b() {
            try {
                SurfaceTexture surfaceTexture = this.f16129q;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.f16124b, 0);
                }
            } finally {
                EGLSurface eGLSurface = this.f16127o;
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(this.f16125m, eGLSurface);
                }
                EGLContext eGLContext = this.f16126n;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.f16125m, eGLContext);
                }
                this.f16127o = null;
                this.f16126n = null;
                this.f16125m = null;
                this.f16132t = null;
                this.f16129q = null;
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            try {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f16129q.updateTexImage();
                        return true;
                    }
                    if (i10 != 3) {
                        return true;
                    }
                    try {
                        b();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    a(message.arg1 != 0);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e10) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e10);
                    this.f16130r = e10;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e11) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e11);
                    this.f16131s = e11;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th2) {
                synchronized (this) {
                    notify();
                    throw th2;
                }
            }
        }

        public c init(boolean z10) {
            boolean z11;
            start();
            this.f16128p = new Handler(getLooper(), this);
            synchronized (this) {
                z11 = false;
                this.f16128p.obtainMessage(1, z10 ? 1 : 0, 0).sendToTarget();
                while (this.f16132t == null && this.f16131s == null && this.f16130r == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z11 = true;
                    }
                }
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f16131s;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f16130r;
            if (error == null) {
                return this.f16132t;
            }
            throw error;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f16128p.sendEmptyMessage(2);
        }

        public void release() {
            this.f16128p.sendEmptyMessage(3);
        }
    }

    public c(a aVar, SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.f16122b = aVar;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        if (!f16121o) {
            int i10 = u.f15907a;
            boolean z10 = false;
            if (i10 >= 24) {
                String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                if (strEglQueryString != null && strEglQueryString.contains("EGL_EXT_protected_content") && !(i10 == 24 && "samsung".equals(u.f15909c)) && (i10 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                    z10 = true;
                }
            }
            f16120n = z10;
            f16121o = true;
        }
        return f16120n;
    }

    public static c newInstanceV17(Context context, boolean z10) {
        if (u.f15907a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        l6.a.checkState(!z10 || isSecureSupported(context));
        return new a().init(z10);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f16122b) {
            if (!this.f16123m) {
                this.f16122b.release();
                this.f16123m = true;
            }
        }
    }
}
