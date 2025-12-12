package j2;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import zf.f;
import zf.i;

/* compiled from: SavedStateRegistryController.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f14578d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final c f14579a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.savedstate.a f14580b = new androidx.savedstate.a();

    /* renamed from: c, reason: collision with root package name */
    public boolean f14581c;

    /* compiled from: SavedStateRegistryController.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final b create(c cVar) {
            i.checkNotNullParameter(cVar, "owner");
            return new b(cVar, null);
        }
    }

    public b(c cVar, f fVar) {
        this.f14579a = cVar;
    }

    public static final b create(c cVar) {
        return f14578d.create(cVar);
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.f14580b;
    }

    public final void performAttach() {
        c cVar = this.f14579a;
        Lifecycle lifecycle = cVar.getLifecycle();
        if (!(lifecycle.getCurrentState() == Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.addObserver(new Recreator(cVar));
        this.f14580b.performAttach$savedstate_release(lifecycle);
        this.f14581c = true;
    }

    public final void performRestore(Bundle bundle) {
        if (!this.f14581c) {
            performAttach();
        }
        Lifecycle lifecycle = this.f14579a.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            this.f14580b.performRestore$savedstate_release(bundle);
        } else {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.getCurrentState()).toString());
        }
    }

    public final void performSave(Bundle bundle) {
        i.checkNotNullParameter(bundle, "outBundle");
        this.f14580b.performSave(bundle);
    }
}
