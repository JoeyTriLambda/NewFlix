package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.a0;

/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public final class l0 implements androidx.lifecycle.f, j2.c, androidx.lifecycle.e0 {

    /* renamed from: b, reason: collision with root package name */
    public final Fragment f2865b;

    /* renamed from: m, reason: collision with root package name */
    public final androidx.lifecycle.d0 f2866m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.lifecycle.m f2867n = null;

    /* renamed from: o, reason: collision with root package name */
    public j2.b f2868o = null;

    public l0(Fragment fragment, androidx.lifecycle.d0 d0Var) {
        this.f2865b = fragment;
        this.f2866m = d0Var;
    }

    public final void a(Lifecycle.Event event) {
        this.f2867n.handleLifecycleEvent(event);
    }

    public final void b() {
        if (this.f2867n == null) {
            this.f2867n = new androidx.lifecycle.m(this);
            j2.b bVarCreate = j2.b.create(this);
            this.f2868o = bVarCreate;
            bVarCreate.performAttach();
        }
    }

    @Override // androidx.lifecycle.f
    public u1.a getDefaultViewModelCreationExtras() {
        Application application;
        Fragment fragment = this.f2865b;
        Context applicationContext = fragment.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        u1.d dVar = new u1.d();
        if (application != null) {
            dVar.set(a0.a.f3485b, application);
        }
        dVar.set(SavedStateHandleSupport.f3465a, fragment);
        dVar.set(SavedStateHandleSupport.f3466b, this);
        if (fragment.getArguments() != null) {
            dVar.set(SavedStateHandleSupport.f3467c, fragment.getArguments());
        }
        return dVar;
    }

    @Override // androidx.lifecycle.l
    public Lifecycle getLifecycle() {
        b();
        return this.f2867n;
    }

    @Override // j2.c
    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f2868o.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.e0
    public androidx.lifecycle.d0 getViewModelStore() {
        b();
        return this.f2866m;
    }
}
