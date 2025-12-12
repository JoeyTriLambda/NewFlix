package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements a.c {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.savedstate.a f3469a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3470b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f3471c;

    /* renamed from: d, reason: collision with root package name */
    public final lf.e f3472d;

    public SavedStateHandlesProvider(androidx.savedstate.a aVar, final e0 e0Var) {
        zf.i.checkNotNullParameter(aVar, "savedStateRegistry");
        zf.i.checkNotNullParameter(e0Var, "viewModelStoreOwner");
        this.f3469a = aVar;
        this.f3472d = kotlin.a.lazy(new yf.a<x>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // yf.a
            public final x invoke() {
                return SavedStateHandleSupport.getSavedStateHandlesVM(e0Var);
            }
        });
    }

    public final void performRestore() {
        if (this.f3470b) {
            return;
        }
        Bundle bundleConsumeRestoredStateForKey = this.f3469a.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3471c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleConsumeRestoredStateForKey != null) {
            bundle.putAll(bundleConsumeRestoredStateForKey);
        }
        this.f3471c = bundle;
        this.f3470b = true;
    }

    @Override // androidx.savedstate.a.c
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3471c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, w> entry : ((x) this.f3472d.getValue()).getHandles().entrySet()) {
            String key = entry.getKey();
            Bundle bundleSaveState = entry.getValue().savedStateProvider().saveState();
            if (!zf.i.areEqual(bundleSaveState, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleSaveState);
            }
        }
        this.f3470b = false;
        return bundle;
    }
}
