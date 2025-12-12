package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.g;
import androidx.savedstate.a;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: LegacySavedStateHandleController.kt */
/* loaded from: classes.dex */
public final class g {

    /* compiled from: LegacySavedStateHandleController.kt */
    public static final class a implements a.InterfaceC0042a {
        @Override // androidx.savedstate.a.InterfaceC0042a
        public void onRecreated(j2.c cVar) throws NoSuchMethodException, SecurityException {
            zf.i.checkNotNullParameter(cVar, "owner");
            if (!(cVar instanceof e0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            d0 viewModelStore = ((e0) cVar).getViewModelStore();
            androidx.savedstate.a savedStateRegistry = cVar.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.keys().iterator();
            while (it.hasNext()) {
                z zVar = viewModelStore.get(it.next());
                zf.i.checkNotNull(zVar);
                g.attachHandleIfNeeded(zVar, savedStateRegistry, cVar.getLifecycle());
            }
            if (!viewModelStore.keys().isEmpty()) {
                savedStateRegistry.runOnNextRecreation(a.class);
            }
        }
    }

    public static final void attachHandleIfNeeded(z zVar, final androidx.savedstate.a aVar, final Lifecycle lifecycle) throws NoSuchMethodException, SecurityException {
        Object obj;
        zf.i.checkNotNullParameter(zVar, "viewModel");
        zf.i.checkNotNullParameter(aVar, "registry");
        zf.i.checkNotNullParameter(lifecycle, "lifecycle");
        HashMap map = zVar.f3533a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = zVar.f3533a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.isAttached()) {
            return;
        }
        savedStateHandleController.attachToLifecycle(aVar, lifecycle);
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            aVar.runOnNextRecreation(a.class);
        } else {
            lifecycle.addObserver(new j() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.j
                public void onStateChanged(l lVar, Lifecycle.Event event) throws NoSuchMethodException, SecurityException {
                    zf.i.checkNotNullParameter(lVar, "source");
                    zf.i.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        lifecycle.removeObserver(this);
                        aVar.runOnNextRecreation(g.a.class);
                    }
                }
            });
        }
    }
}
