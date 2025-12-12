package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f2854b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f2855m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Rect f2856n;

    public j(k0 k0Var, View view, Rect rect) {
        this.f2854b = k0Var;
        this.f2855m = view;
        this.f2856n = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2854b.getBoundsOnScreen(this.f2855m, this.f2856n);
    }
}
