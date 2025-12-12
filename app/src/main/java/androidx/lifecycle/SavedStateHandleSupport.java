package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import u1.a;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3465a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final c f3466b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a f3467c = new a();

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class a implements a.b<Bundle> {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class b implements a.b<j2.c> {
    }

    /* compiled from: SavedStateHandleSupport.kt */
    public static final class c implements a.b<e0> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends j2.c & e0> void enableSavedStateHandles(T t10) {
        zf.i.checkNotNullParameter(t10, "<this>");
        Lifecycle.State currentState = t10.getLifecycle().getCurrentState();
        if (!(currentState == Lifecycle.State.INITIALIZED || currentState == Lifecycle.State.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t10.getSavedStateRegistry().getSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t10.getSavedStateRegistry(), t10);
            t10.getSavedStateRegistry().registerSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t10.getLifecycle().addObserver(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final x getSavedStateHandlesVM(e0 e0Var) {
        zf.i.checkNotNullParameter(e0Var, "<this>");
        u1.c cVar = new u1.c();
        cVar.addInitializer(zf.k.getOrCreateKotlinClass(x.class), new yf.l<u1.a, x>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // yf.l
            public final x invoke(u1.a aVar) {
                zf.i.checkNotNullParameter(aVar, "$this$initializer");
                return new x();
            }
        });
        return (x) new a0(e0Var, cVar.build()).get("androidx.lifecycle.internal.SavedStateHandlesVM", x.class);
    }
}
