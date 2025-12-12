package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.m;
import t0.d;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class h implements d.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2833b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2834m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ m.a f2835n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2836o;

    public h(View view, ViewGroup viewGroup, m.a aVar, SpecialEffectsController.Operation operation) {
        this.f2833b = view;
        this.f2834m = viewGroup;
        this.f2835n = aVar;
        this.f2836o = operation;
    }

    @Override // t0.d.a
    public void onCancel() {
        View view = this.f2833b;
        view.clearAnimation();
        this.f2834m.endViewTransition(view);
        this.f2835n.a();
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f2836o + " has been cancelled.");
        }
    }
}
