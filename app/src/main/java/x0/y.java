package x0;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class y implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final View f21337b;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver f21338m;

    /* renamed from: n, reason: collision with root package name */
    public final Runnable f21339n;

    public y(View view, Runnable runnable) {
        this.f21337b = view;
        this.f21338m = view.getViewTreeObserver();
        this.f21339n = runnable;
    }

    public static y add(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        y yVar = new y(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(yVar);
        view.addOnAttachStateChangeListener(yVar);
        return yVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.f21339n.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f21338m = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        removeListener();
    }

    public void removeListener() {
        boolean zIsAlive = this.f21338m.isAlive();
        View view = this.f21337b;
        if (zIsAlive) {
            this.f21338m.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
