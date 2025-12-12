package uc;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: ResizingSurfaceView.java */
/* loaded from: classes2.dex */
public class b extends SurfaceView implements uc.a {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f20337u = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f20338v = {12440, 2, 12344};

    /* renamed from: b, reason: collision with root package name */
    public final Point f20339b;

    /* renamed from: m, reason: collision with root package name */
    public final Point f20340m;

    /* renamed from: n, reason: collision with root package name */
    public final wc.a f20341n;

    /* renamed from: o, reason: collision with root package name */
    public final a f20342o;

    /* renamed from: p, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0286b f20343p;

    /* renamed from: q, reason: collision with root package name */
    public final ReentrantLock f20344q;

    /* renamed from: r, reason: collision with root package name */
    public int f20345r;

    /* renamed from: s, reason: collision with root package name */
    public int f20346s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20347t;

    /* compiled from: ResizingSurfaceView.java */
    /* renamed from: uc.b$b, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalLayoutListenerC0286b implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC0286b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b bVar = b.this;
            bVar.setScaleType(bVar.f20341n.getCurrentScaleType());
            bVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ResizingSurfaceView.java */
    public interface c {
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20339b = new Point(0, 0);
        this.f20340m = new Point(0, 0);
        this.f20341n = new wc.a();
        this.f20342o = new a();
        this.f20343p = new ViewTreeObserverOnGlobalLayoutListenerC0286b();
        this.f20344q = new ReentrantLock(true);
        this.f20345r = 0;
        this.f20346s = 0;
        this.f20347t = true;
    }

    @Override // uc.a
    public void clearSurface() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eGLDisplayEglGetDisplay, null);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            egl10.eglChooseConfig(eGLDisplayEglGetDisplay, f20337u, eGLConfigArr, 1, new int[1]);
            EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, f20338v);
            EGLSurface eGLSurfaceEglCreateWindowSurface = egl10.eglCreateWindowSurface(eGLDisplayEglGetDisplay, eGLConfigArr[0], this, new int[]{12344});
            egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, eGLContextEglCreateContext);
            egl10.eglSwapBuffers(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
            egl10.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
            egl10.eglTerminate(eGLDisplayEglGetDisplay);
        } catch (Exception e10) {
            Log.e("ResizingSurfaceView", "Error clearing surface", e10);
        }
    }

    public ScaleType getScaleType() {
        return this.f20341n.getCurrentScaleType();
    }

    public void notifyOnSizeChangeListener(int i10, int i11) {
        Point point = this.f20339b;
        if (point.x == i10 && point.y == i11) {
            return;
        }
        point.x = i10;
        point.y = i11;
        updateMatrixOnLayout();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        updateMatrixOnLayout();
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[PHI: r2 r7
  0x007b: PHI (r2v7 int) = (r2v4 int), (r2v4 int), (r2v10 int), (r2v10 int) binds: [B:38:0x008b, B:39:0x008d, B:29:0x0076, B:30:0x0078] A[DONT_GENERATE, DONT_INLINE]
  0x007b: PHI (r7v5 int) = (r7v3 int), (r7v3 int), (r7v1 int), (r7v1 int) binds: [B:38:0x008b, B:39:0x008d, B:29:0x0076, B:30:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            boolean r0 = r5.f20347t
            if (r0 != 0) goto L13
            super.onMeasure(r6, r7)
            int r6 = r5.getMeasuredWidth()
            int r7 = r5.getMeasuredHeight()
            r5.notifyOnSizeChangeListener(r6, r7)
            return
        L13:
            android.graphics.Point r0 = r5.f20340m
            int r1 = r0.x
            int r1 = android.view.View.getDefaultSize(r1, r6)
            int r2 = r0.y
            int r2 = android.view.View.getDefaultSize(r2, r7)
            int r3 = r0.x
            if (r3 <= 0) goto L9a
            int r3 = r0.y
            if (r3 > 0) goto L2b
            goto L9a
        L2b:
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r2 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 != r3) goto L5b
            if (r2 != r3) goto L5b
            int r1 = r0.x
            int r2 = r1 * r7
            int r0 = r0.y
            int r3 = r6 * r0
            if (r2 >= r3) goto L50
            int r1 = r1 * r7
            int r6 = r1 / r0
            goto L93
        L50:
            int r2 = r1 * r7
            int r3 = r6 * r0
            if (r2 <= r3) goto L93
            int r0 = r0 * r6
            int r7 = r0 / r1
            goto L93
        L5b:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r3) goto L6d
            int r1 = r0.y
            int r1 = r1 * r6
            int r0 = r0.x
            int r1 = r1 / r0
            if (r2 != r4) goto L6b
            if (r1 <= r7) goto L6b
            goto L93
        L6b:
            r7 = r1
            goto L93
        L6d:
            if (r2 != r3) goto L7d
            int r2 = r0.x
            int r2 = r2 * r7
            int r0 = r0.y
            int r2 = r2 / r0
            if (r1 != r4) goto L7b
            if (r2 <= r6) goto L7b
            goto L93
        L7b:
            r6 = r2
            goto L93
        L7d:
            int r3 = r0.x
            int r0 = r0.y
            if (r2 != r4) goto L89
            if (r0 <= r7) goto L89
            int r2 = r7 * r3
            int r2 = r2 / r0
            goto L8b
        L89:
            r7 = r0
            r2 = r3
        L8b:
            if (r1 != r4) goto L7b
            if (r2 <= r6) goto L7b
            int r0 = r0 * r6
            int r7 = r0 / r3
        L93:
            r5.setMeasuredDimension(r6, r7)
            r5.notifyOnSizeChangeListener(r6, r7)
            return
        L9a:
            r5.setMeasuredDimension(r1, r2)
            r5.notifyOnSizeChangeListener(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uc.b.onMeasure(int, int):void");
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z10) {
        this.f20347t = z10;
        requestLayout();
    }

    public void setScaleType(ScaleType scaleType) {
        this.f20341n.scale(this, scaleType);
    }

    public void setVideoRotation(int i10, boolean z10) {
        int i11 = z10 ? i10 : this.f20345r;
        if (z10) {
            i10 = this.f20346s;
        }
        setVideoRotation(i11, i10);
    }

    public void updateMatrixOnLayout() {
        ReentrantLock reentrantLock = this.f20344q;
        reentrantLock.lock();
        if (getWindowToken() == null) {
            addOnAttachStateChangeListener(this.f20342o);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f20343p);
        }
        reentrantLock.unlock();
    }

    public boolean updateVideoSize(int i10, int i11) {
        this.f20341n.setIntrinsicVideoSize(i10, i11);
        updateMatrixOnLayout();
        Point point = this.f20340m;
        point.x = i10;
        point.y = i11;
        return (i10 == 0 || i11 == 0) ? false : true;
    }

    public void setVideoRotation(int i10, int i11) {
        this.f20345r = i10;
        this.f20346s = i11;
        this.f20341n.rotate(this, (i10 + i11) % 360);
    }

    /* compiled from: ResizingSurfaceView.java */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b bVar = b.this;
            bVar.f20344q.lock();
            bVar.getViewTreeObserver().addOnGlobalLayoutListener(bVar.f20343p);
            bVar.removeOnAttachStateChangeListener(this);
            bVar.f20344q.unlock();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public void setOnSizeChangeListener(c cVar) {
    }
}
