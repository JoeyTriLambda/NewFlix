package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class l0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final float f1434b;

    /* renamed from: m, reason: collision with root package name */
    public final int f1435m;

    /* renamed from: n, reason: collision with root package name */
    public final int f1436n;

    /* renamed from: o, reason: collision with root package name */
    public final View f1437o;

    /* renamed from: p, reason: collision with root package name */
    public a f1438p;

    /* renamed from: q, reason: collision with root package name */
    public b f1439q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1440r;

    /* renamed from: s, reason: collision with root package name */
    public int f1441s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f1442t = new int[2];

    /* compiled from: ForwardingListener.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = l0.this.f1437o.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0 l0Var = l0.this;
            l0Var.a();
            View view = l0Var.f1437o;
            if (view.isEnabled() && !view.isLongClickable() && l0Var.onForwardingStarted()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                l0Var.f1440r = true;
            }
        }
    }

    public l0(View view) {
        this.f1437o = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1434b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1435m = tapTimeout;
        this.f1436n = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        b bVar = this.f1439q;
        View view = this.f1437o;
        if (bVar != null) {
            view.removeCallbacks(bVar);
        }
        a aVar = this.f1438p;
        if (aVar != null) {
            view.removeCallbacks(aVar);
        }
    }

    public abstract x.f getPopup();

    public abstract boolean onForwardingStarted();

    public boolean onForwardingStopped() {
        x.f popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r13, android.view.MotionEvent r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1440r = false;
        this.f1441s = -1;
        a aVar = this.f1438p;
        if (aVar != null) {
            this.f1437o.removeCallbacks(aVar);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
