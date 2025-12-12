package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.m;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m.c f2863b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2864m;

    public l(m.c cVar, SpecialEffectsController.Operation operation) {
        this.f2863b = cVar;
        this.f2864m = operation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2863b.a();
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Transition for operation " + this.f2864m + "has completed");
        }
    }
}
