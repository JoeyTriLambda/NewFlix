package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import zf.f;
import zf.i;

/* compiled from: SavedStateRegistry.kt */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public boolean f4315b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f4316c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4317d;

    /* renamed from: e, reason: collision with root package name */
    public Recreator.b f4318e;

    /* renamed from: a, reason: collision with root package name */
    public final z.b<String, c> f4314a = new z.b<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f4319f = true;

    /* compiled from: SavedStateRegistry.kt */
    /* renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0042a {
        void onRecreated(j2.c cVar);
    }

    /* compiled from: SavedStateRegistry.kt */
    public static final class b {
        public b(f fVar) {
        }
    }

    /* compiled from: SavedStateRegistry.kt */
    public interface c {
        Bundle saveState();
    }

    static {
        new b(null);
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        i.checkNotNullParameter(str, "key");
        if (!this.f4317d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f4316c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f4316c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f4316c;
        boolean z10 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z10 = true;
        }
        if (!z10) {
            this.f4316c = null;
        }
        return bundle2;
    }

    public final c getSavedStateProvider(String str) {
        i.checkNotNullParameter(str, "key");
        Iterator<Map.Entry<String, c>> it = this.f4314a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            i.checkNotNullExpressionValue(next, "components");
            String key = next.getKey();
            c value = next.getValue();
            if (i.areEqual(key, str)) {
                return value;
            }
        }
        return null;
    }

    public final void performAttach$savedstate_release(Lifecycle lifecycle) {
        i.checkNotNullParameter(lifecycle, "lifecycle");
        if (!(!this.f4315b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.addObserver(new j() { // from class: j2.a
            @Override // androidx.lifecycle.j
            public final void onStateChanged(l lVar, Lifecycle.Event event) {
                androidx.savedstate.a aVar = this.f14577b;
                i.checkNotNullParameter(aVar, "this$0");
                i.checkNotNullParameter(lVar, "<anonymous parameter 0>");
                i.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_START) {
                    aVar.f4319f = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    aVar.f4319f = false;
                }
            }
        });
        this.f4315b = true;
    }

    public final void performRestore$savedstate_release(Bundle bundle) {
        if (!this.f4315b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f4317d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f4316c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f4317d = true;
    }

    public final void performSave(Bundle bundle) {
        i.checkNotNullParameter(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4316c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        z.b<String, c>.d dVarIteratorWithAdditions = this.f4314a.iteratorWithAdditions();
        i.checkNotNullExpressionValue(dVarIteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (dVarIteratorWithAdditions.hasNext()) {
            Map.Entry next = dVarIteratorWithAdditions.next();
            bundle2.putBundle((String) next.getKey(), ((c) next.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void registerSavedStateProvider(String str, c cVar) {
        i.checkNotNullParameter(str, "key");
        i.checkNotNullParameter(cVar, "provider");
        if (!(this.f4314a.putIfAbsent(str, cVar) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void runOnNextRecreation(Class<? extends InterfaceC0042a> cls) throws NoSuchMethodException, SecurityException {
        i.checkNotNullParameter(cls, "clazz");
        if (!this.f4319f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.f4318e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f4318e = bVar;
        try {
            cls.getDeclaredConstructor(new Class[0]);
            Recreator.b bVar2 = this.f4318e;
            if (bVar2 != null) {
                String name = cls.getName();
                i.checkNotNullExpressionValue(name, "clazz.name");
                bVar2.add(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
