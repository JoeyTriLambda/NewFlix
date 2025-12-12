package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.m;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class g implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2804b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2805m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f2806n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ m.a f2807o;

    /* compiled from: DefaultSpecialEffectsController.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.f2805m.endViewTransition(gVar.f2806n);
            gVar.f2807o.a();
        }
    }

    public g(View view, ViewGroup viewGroup, m.a aVar, SpecialEffectsController.Operation operation) {
        this.f2804b = operation;
        this.f2805m = viewGroup;
        this.f2806n = view;
        this.f2807o = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f2805m.post(new a());
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f2804b + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f2804b + " has reached onAnimationStart.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
