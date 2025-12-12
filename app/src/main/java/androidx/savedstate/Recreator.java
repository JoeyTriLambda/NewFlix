package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.savedstate.a;
import j2.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import zf.f;
import zf.i;

/* compiled from: Recreator.kt */
/* loaded from: classes.dex */
public final class Recreator implements j {

    /* renamed from: b, reason: collision with root package name */
    public final c f4312b;

    /* compiled from: Recreator.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: Recreator.kt */
    public static final class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f4313a;

        public b(androidx.savedstate.a aVar) {
            i.checkNotNullParameter(aVar, "registry");
            this.f4313a = new LinkedHashSet();
            aVar.registerSavedStateProvider("androidx.savedstate.Restarter", this);
        }

        public final void add(String str) {
            i.checkNotNullParameter(str, "className");
            this.f4313a.add(str);
        }

        @Override // androidx.savedstate.a.c
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f4313a));
            return bundle;
        }
    }

    static {
        new a(null);
    }

    public Recreator(c cVar) {
        i.checkNotNullParameter(cVar, "owner");
        this.f4312b = cVar;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, Lifecycle.Event event) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(lVar, "source");
        i.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        lVar.getLifecycle().removeObserver(this);
        c cVar = this.f4312b;
        Bundle bundleConsumeRestoredStateForKey = cVar.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
        if (bundleConsumeRestoredStateForKey == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0042a.class);
                i.checkNotNullExpressionValue(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                        i.checkNotNullExpressionValue(objNewInstance, "{\n                constr…wInstance()\n            }");
                        ((a.InterfaceC0042a) objNewInstance).onRecreated(cVar);
                    } catch (Exception e10) {
                        throw new RuntimeException(ac.c.j("Failed to instantiate ", str), e10);
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                }
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException(ac.c.k("Class ", str, " wasn't found"), e12);
            }
        }
    }
}
