package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final w f2792a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f2793b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f2794c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2795d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f2796e = -1;

    public e0(w wVar, f0 f0Var, Fragment fragment) {
        this.f2792a = wVar;
        this.f2793b = f0Var;
        this.f2794c = fragment;
    }

    public final void a() {
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        Bundle bundle = fragment.f2675m;
        fragment.F.H();
        fragment.f2669b = 3;
        fragment.Q = false;
        fragment.onActivityCreated(bundle);
        if (!fragment.Q) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onActivityCreated()");
        }
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + fragment);
        }
        View view = fragment.S;
        if (view != null) {
            Bundle bundle2 = fragment.f2675m;
            SparseArray<Parcelable> sparseArray = fragment.f2676n;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                fragment.f2676n = null;
            }
            if (fragment.S != null) {
                fragment.f2670b0.f2868o.performRestore(fragment.f2677o);
                fragment.f2677o = null;
            }
            fragment.Q = false;
            fragment.onViewStateRestored(bundle2);
            if (!fragment.Q) {
                throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onViewStateRestored()");
            }
            if (fragment.S != null) {
                fragment.f2670b0.a(Lifecycle.Event.ON_CREATE);
            }
        }
        fragment.f2675m = null;
        z zVar = fragment.F;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(4);
        this.f2792a.a(false);
    }

    public final void b() {
        View view;
        View view2;
        f0 f0Var = this.f2793b;
        f0Var.getClass();
        Fragment fragment = this.f2794c;
        ViewGroup viewGroup = fragment.R;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) f0Var.f2800a;
            int iIndexOf = arrayList.indexOf(fragment);
            int i10 = iIndexOf - 1;
            while (true) {
                if (i10 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = (Fragment) arrayList.get(iIndexOf);
                        if (fragment2.R == viewGroup && (view = fragment2.S) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = (Fragment) arrayList.get(i10);
                    if (fragment3.R == viewGroup && (view2 = fragment3.S) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i10--;
                }
            }
        }
        fragment.R.addView(fragment.S, iIndexOfChild);
    }

    public final void c() {
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.f2681s;
        e0 e0Var = null;
        f0 f0Var = this.f2793b;
        if (fragment2 != null) {
            e0 e0Var2 = (e0) ((HashMap) f0Var.f2801b).get(fragment2.f2679q);
            if (e0Var2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.f2681s + " that does not belong to this FragmentManager!");
            }
            fragment.f2682t = fragment.f2681s.f2679q;
            fragment.f2681s = null;
            e0Var = e0Var2;
        } else {
            String str = fragment.f2682t;
            if (str != null && (e0Var = (e0) ((HashMap) f0Var.f2801b).get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(fragment);
                sb2.append(" declared target fragment ");
                throw new IllegalStateException(ac.c.o(sb2, fragment.f2682t, " that does not belong to this FragmentManager!"));
            }
        }
        if (e0Var != null) {
            e0Var.k();
        }
        fragment.E = fragment.D.getHost();
        fragment.G = fragment.D.f2960w;
        w wVar = this.f2792a;
        wVar.g(false);
        ArrayList<Fragment.d> arrayList = fragment.f2673e0;
        Iterator<Fragment.d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        arrayList.clear();
        fragment.F.b(fragment.E, fragment.a(), fragment);
        fragment.f2669b = 0;
        fragment.Q = false;
        fragment.onAttach(fragment.E.f2928m);
        if (!fragment.Q) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
        }
        y yVar = fragment.D;
        Iterator<c0> it2 = yVar.f2951n.iterator();
        while (it2.hasNext()) {
            it2.next().onAttachFragment(yVar, fragment);
        }
        z zVar = fragment.F;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(0);
        wVar.b(false);
    }

    public final int d() {
        Fragment fragment = this.f2794c;
        if (fragment.D == null) {
            return fragment.f2669b;
        }
        int iMin = this.f2796e;
        int iOrdinal = fragment.Z.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.f2687y) {
            if (fragment.f2688z) {
                iMin = Math.max(this.f2796e, 2);
                View view = fragment.S;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f2796e < 4 ? Math.min(iMin, fragment.f2669b) : Math.min(iMin, 1);
            }
        }
        if (!fragment.f2685w) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.R;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        SpecialEffectsController.Operation operation = null;
        if (viewGroup != null) {
            SpecialEffectsController specialEffectsControllerF = SpecialEffectsController.f(viewGroup, fragment.getParentFragmentManager());
            specialEffectsControllerF.getClass();
            SpecialEffectsController.Operation operationD = specialEffectsControllerF.d(fragment);
            SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact2 = operationD != null ? operationD.f2716b : null;
            Iterator<SpecialEffectsController.Operation> it = specialEffectsControllerF.f2712c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpecialEffectsController.Operation next = it.next();
                if (next.getFragment().equals(fragment) && !next.f2720f) {
                    operation = next;
                    break;
                }
            }
            lifecycleImpact = (operation == null || !(lifecycleImpact2 == null || lifecycleImpact2 == SpecialEffectsController.Operation.LifecycleImpact.NONE)) ? lifecycleImpact2 : operation.f2716b;
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.f2686x) {
            iMin = fragment.g() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.T && fragment.f2669b < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + fragment);
        }
        return iMin;
    }

    public final void e() {
        Parcelable parcelable;
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        final Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.X) {
            Bundle bundle = fragment.f2675m;
            if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
                fragment.F.M(parcelable);
                z zVar = fragment.F;
                zVar.F = false;
                zVar.G = false;
                zVar.M.f2768h = false;
                zVar.t(1);
            }
            fragment.f2669b = 1;
            return;
        }
        w wVar = this.f2792a;
        wVar.h(false);
        Bundle bundle2 = fragment.f2675m;
        fragment.F.H();
        fragment.f2669b = 1;
        fragment.Q = false;
        fragment.f2668a0.addObserver(new androidx.lifecycle.j() { // from class: androidx.fragment.app.Fragment.6
            public AnonymousClass6() {
            }

            @Override // androidx.lifecycle.j
            public void onStateChanged(androidx.lifecycle.l lVar, Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.S) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        fragment.f2672d0.performRestore(bundle2);
        fragment.onCreate(bundle2);
        fragment.X = true;
        if (fragment.Q) {
            fragment.f2668a0.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            wVar.c(false);
        } else {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onCreate()");
        }
    }

    public final void f() throws Resources.NotFoundException {
        String resourceName;
        Fragment fragment = this.f2794c;
        if (fragment.f2687y) {
            return;
        }
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterOnGetLayoutInflater = fragment.onGetLayoutInflater(fragment.f2675m);
        ViewGroup viewGroup = fragment.R;
        if (viewGroup == null) {
            int i10 = fragment.I;
            if (i10 == 0) {
                viewGroup = null;
            } else {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + fragment + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.D.f2959v.onFindViewById(i10);
                if (viewGroup == null) {
                    if (!fragment.A) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.I);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.I) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.onWrongFragmentContainer(fragment, viewGroup);
                }
            }
        }
        fragment.R = viewGroup;
        fragment.j(layoutInflaterOnGetLayoutInflater, viewGroup, fragment.f2675m);
        View view = fragment.S;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.S.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                b();
            }
            if (fragment.K) {
                fragment.S.setVisibility(8);
            }
            if (x0.j0.isAttachedToWindow(fragment.S)) {
                x0.j0.requestApplyInsets(fragment.S);
            } else {
                View view2 = fragment.S;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            fragment.onViewCreated(fragment.S, fragment.f2675m);
            fragment.F.t(2);
            this.f2792a.m(false);
            int visibility = fragment.S.getVisibility();
            fragment.b().f2703l = fragment.S.getAlpha();
            if (fragment.R != null && visibility == 0) {
                View viewFindFocus = fragment.S.findFocus();
                if (viewFindFocus != null) {
                    fragment.b().f2704m = viewFindFocus;
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.S.setAlpha(0.0f);
            }
        }
        fragment.f2669b = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e0.g():void");
    }

    public final void h() {
        View view;
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.R;
        if (viewGroup != null && (view = fragment.S) != null) {
            viewGroup.removeView(view);
        }
        fragment.F.t(1);
        if (fragment.S != null && fragment.f2670b0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            fragment.f2670b0.a(Lifecycle.Event.ON_DESTROY);
        }
        fragment.f2669b = 1;
        fragment.Q = false;
        fragment.onDestroyView();
        if (!fragment.Q) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDestroyView()");
        }
        v1.a.getInstance(fragment).markForRedelivery();
        fragment.B = false;
        this.f2792a.n(false);
        fragment.R = null;
        fragment.S = null;
        fragment.f2670b0 = null;
        fragment.f2671c0.setValue(null);
        fragment.f2688z = false;
    }

    public final void i() {
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.f2669b = -1;
        boolean z10 = false;
        fragment.Q = false;
        fragment.onDetach();
        if (!fragment.Q) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
        }
        if (!fragment.F.isDestroyed()) {
            fragment.F.k();
            fragment.F = new z();
        }
        this.f2792a.e(false);
        fragment.f2669b = -1;
        fragment.E = null;
        fragment.G = null;
        fragment.D = null;
        boolean z11 = true;
        if (fragment.f2686x && !fragment.g()) {
            z10 = true;
        }
        if (!z10) {
            b0 b0Var = (b0) this.f2793b.f2803d;
            if (b0Var.f2763c.containsKey(fragment.f2679q) && b0Var.f2766f) {
                z11 = b0Var.f2767g;
            }
            if (!z11) {
                return;
            }
        }
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.f();
    }

    public final void j() {
        Fragment fragment = this.f2794c;
        if (fragment.f2687y && fragment.f2688z && !fragment.B) {
            if (y.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.j(fragment.onGetLayoutInflater(fragment.f2675m), null, fragment.f2675m);
            View view = fragment.S;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.S.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.K) {
                    fragment.S.setVisibility(8);
                }
                fragment.onViewCreated(fragment.S, fragment.f2675m);
                fragment.F.t(2);
                this.f2792a.m(false);
                fragment.f2669b = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        f0 f0Var = this.f2793b;
        boolean z10 = this.f2795d;
        Fragment fragment = this.f2794c;
        if (z10) {
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f2795d = true;
            boolean z11 = false;
            while (true) {
                int iD = d();
                int i10 = fragment.f2669b;
                if (iD == i10) {
                    if (!z11 && i10 == -1 && fragment.f2686x && !fragment.g()) {
                        if (y.isLoggingEnabled(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + fragment);
                        }
                        ((b0) f0Var.f2803d).b(fragment);
                        f0Var.i(this);
                        if (y.isLoggingEnabled(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + fragment);
                        }
                        fragment.f();
                    }
                    if (fragment.W) {
                        if (fragment.S != null && (viewGroup = fragment.R) != null) {
                            SpecialEffectsController specialEffectsControllerF = SpecialEffectsController.f(viewGroup, fragment.getParentFragmentManager());
                            boolean z12 = fragment.K;
                            SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = SpecialEffectsController.Operation.LifecycleImpact.NONE;
                            if (z12) {
                                specialEffectsControllerF.getClass();
                                if (y.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                specialEffectsControllerF.a(SpecialEffectsController.Operation.State.GONE, lifecycleImpact, this);
                            } else {
                                specialEffectsControllerF.getClass();
                                if (y.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                specialEffectsControllerF.a(SpecialEffectsController.Operation.State.VISIBLE, lifecycleImpact, this);
                            }
                        }
                        y yVar = fragment.D;
                        if (yVar != null && fragment.f2685w && y.D(fragment)) {
                            yVar.E = true;
                        }
                        fragment.W = false;
                        fragment.onHiddenChanged(fragment.K);
                        fragment.F.n();
                    }
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            fragment.f2669b = 1;
                            break;
                        case 2:
                            fragment.f2688z = false;
                            fragment.f2669b = 2;
                            break;
                        case 3:
                            if (y.isLoggingEnabled(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.S != null && fragment.f2676n == null) {
                                p();
                            }
                            if (fragment.S != null && (viewGroup2 = fragment.R) != null) {
                                SpecialEffectsController specialEffectsControllerF2 = SpecialEffectsController.f(viewGroup2, fragment.getParentFragmentManager());
                                specialEffectsControllerF2.getClass();
                                if (y.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                specialEffectsControllerF2.a(SpecialEffectsController.Operation.State.REMOVED, SpecialEffectsController.Operation.LifecycleImpact.REMOVING, this);
                            }
                            fragment.f2669b = 3;
                            break;
                        case 4:
                            r();
                            break;
                        case 5:
                            fragment.f2669b = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.S != null && (viewGroup3 = fragment.R) != null) {
                                SpecialEffectsController specialEffectsControllerF3 = SpecialEffectsController.f(viewGroup3, fragment.getParentFragmentManager());
                                SpecialEffectsController.Operation.State stateB = SpecialEffectsController.Operation.State.b(fragment.S.getVisibility());
                                specialEffectsControllerF3.getClass();
                                if (y.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                specialEffectsControllerF3.a(stateB, SpecialEffectsController.Operation.LifecycleImpact.ADDING, this);
                            }
                            fragment.f2669b = 4;
                            break;
                        case 5:
                            q();
                            break;
                        case 6:
                            fragment.f2669b = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
                z11 = true;
            }
        } finally {
            this.f2795d = false;
        }
    }

    public final void l() {
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
        }
        fragment.F.t(5);
        if (fragment.S != null) {
            fragment.f2670b0.a(Lifecycle.Event.ON_PAUSE);
        }
        fragment.f2668a0.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        fragment.f2669b = 6;
        fragment.Q = false;
        fragment.onPause();
        if (fragment.Q) {
            this.f2792a.f(false);
            return;
        }
        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onPause()");
    }

    public final void m(ClassLoader classLoader) {
        Fragment fragment = this.f2794c;
        Bundle bundle = fragment.f2675m;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.f2676n = fragment.f2675m.getSparseParcelableArray("android:view_state");
        fragment.f2677o = fragment.f2675m.getBundle("android:view_registry_state");
        fragment.f2682t = fragment.f2675m.getString("android:target_state");
        if (fragment.f2682t != null) {
            fragment.f2683u = fragment.f2675m.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.f2678p;
        if (bool != null) {
            fragment.U = bool.booleanValue();
            fragment.f2678p = null;
        } else {
            fragment.U = fragment.f2675m.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.U) {
            return;
        }
        fragment.T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n() {
        /*
            r9 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.y.isLoggingEnabled(r0)
            java.lang.String r1 = "FragmentManager"
            androidx.fragment.app.Fragment r2 = r9.f2794c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            androidx.fragment.app.Fragment$c r0 = r2.V
            r3 = 0
            if (r0 != 0) goto L23
            r0 = r3
            goto L25
        L23:
            android.view.View r0 = r0.f2704m
        L25:
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L83
            android.view.View r6 = r2.S
            if (r0 != r6) goto L2e
            goto L38
        L2e:
            android.view.ViewParent r6 = r0.getParent()
        L32:
            if (r6 == 0) goto L3f
            android.view.View r7 = r2.S
            if (r6 != r7) goto L3a
        L38:
            r6 = 1
            goto L40
        L3a:
            android.view.ViewParent r6 = r6.getParent()
            goto L32
        L3f:
            r6 = 0
        L40:
            if (r6 == 0) goto L83
            boolean r6 = r0.requestFocus()
            r7 = 2
            boolean r7 = androidx.fragment.app.y.isLoggingEnabled(r7)
            if (r7 == 0) goto L83
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "requestFocus: Restoring focused view "
            r7.<init>(r8)
            r7.append(r0)
            java.lang.String r0 = " "
            r7.append(r0)
            if (r6 == 0) goto L61
            java.lang.String r0 = "succeeded"
            goto L63
        L61:
            java.lang.String r0 = "failed"
        L63:
            r7.append(r0)
            java.lang.String r0 = " on Fragment "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r7.append(r0)
            android.view.View r0 = r2.S
            android.view.View r0 = r0.findFocus()
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            android.util.Log.v(r1, r0)
        L83:
            androidx.fragment.app.Fragment$c r0 = r2.b()
            r0.f2704m = r3
            androidx.fragment.app.z r0 = r2.F
            r0.H()
            androidx.fragment.app.z r0 = r2.F
            r0.w(r4)
            r0 = 7
            r2.f2669b = r0
            r2.Q = r5
            r2.onResume()
            boolean r1 = r2.Q
            if (r1 == 0) goto Lc8
            androidx.lifecycle.m r1 = r2.f2668a0
            androidx.lifecycle.Lifecycle$Event r4 = androidx.lifecycle.Lifecycle.Event.ON_RESUME
            r1.handleLifecycleEvent(r4)
            android.view.View r1 = r2.S
            if (r1 == 0) goto Laf
            androidx.fragment.app.l0 r1 = r2.f2670b0
            r1.a(r4)
        Laf:
            androidx.fragment.app.z r1 = r2.F
            r1.F = r5
            r1.G = r5
            androidx.fragment.app.b0 r4 = r1.M
            r4.f2768h = r5
            r1.t(r0)
            androidx.fragment.app.w r0 = r9.f2792a
            r0.i(r5)
            r2.f2675m = r3
            r2.f2676n = r3
            r2.f2677o = r3
            return
        Lc8:
            androidx.fragment.app.SuperNotCalledException r0 = new androidx.fragment.app.SuperNotCalledException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Fragment "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = " did not call through to super.onResume()"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e0.n():void");
    }

    public final void o() {
        Fragment fragment = this.f2794c;
        d0 d0Var = new d0(fragment);
        if (fragment.f2669b <= -1 || d0Var.f2786x != null) {
            d0Var.f2786x = fragment.f2675m;
        } else {
            Bundle bundle = new Bundle();
            fragment.onSaveInstanceState(bundle);
            fragment.f2672d0.performSave(bundle);
            bundle.putParcelable("android:support:fragments", fragment.F.N());
            this.f2792a.j(false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (fragment.S != null) {
                p();
            }
            if (fragment.f2676n != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", fragment.f2676n);
            }
            if (fragment.f2677o != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", fragment.f2677o);
            }
            if (!fragment.U) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", fragment.U);
            }
            d0Var.f2786x = bundle;
            if (fragment.f2682t != null) {
                if (bundle == null) {
                    d0Var.f2786x = new Bundle();
                }
                d0Var.f2786x.putString("android:target_state", fragment.f2682t);
                int i10 = fragment.f2683u;
                if (i10 != 0) {
                    d0Var.f2786x.putInt("android:target_req_state", i10);
                }
            }
        }
        this.f2793b.j(fragment.f2679q, d0Var);
    }

    public final void p() {
        Fragment fragment = this.f2794c;
        if (fragment.S == null) {
            return;
        }
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + fragment + " with view " + fragment.S);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.S.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.f2676n = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.f2670b0.f2868o.performSave(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.f2677o = bundle;
    }

    public final void q() {
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto STARTED: " + fragment);
        }
        fragment.F.H();
        fragment.F.w(true);
        fragment.f2669b = 5;
        fragment.Q = false;
        fragment.onStart();
        if (!fragment.Q) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onStart()");
        }
        androidx.lifecycle.m mVar = fragment.f2668a0;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        mVar.handleLifecycleEvent(event);
        if (fragment.S != null) {
            fragment.f2670b0.a(event);
        }
        z zVar = fragment.F;
        zVar.F = false;
        zVar.G = false;
        zVar.M.f2768h = false;
        zVar.t(5);
        this.f2792a.k(false);
    }

    public final void r() {
        boolean zIsLoggingEnabled = y.isLoggingEnabled(3);
        Fragment fragment = this.f2794c;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom STARTED: " + fragment);
        }
        z zVar = fragment.F;
        zVar.G = true;
        zVar.M.f2768h = true;
        zVar.t(4);
        if (fragment.S != null) {
            fragment.f2670b0.a(Lifecycle.Event.ON_STOP);
        }
        fragment.f2668a0.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        fragment.f2669b = 4;
        fragment.Q = false;
        fragment.onStop();
        if (fragment.Q) {
            this.f2792a.l(false);
            return;
        }
        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onStop()");
    }

    public e0(w wVar, f0 f0Var, ClassLoader classLoader, t tVar, d0 d0Var) {
        this.f2792a = wVar;
        this.f2793b = f0Var;
        Fragment fragmentInstantiate = tVar.instantiate(classLoader, d0Var.f2774b);
        Bundle bundle = d0Var.f2783u;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle);
        fragmentInstantiate.f2679q = d0Var.f2775m;
        fragmentInstantiate.f2687y = d0Var.f2776n;
        fragmentInstantiate.A = true;
        fragmentInstantiate.H = d0Var.f2777o;
        fragmentInstantiate.I = d0Var.f2778p;
        fragmentInstantiate.J = d0Var.f2779q;
        fragmentInstantiate.M = d0Var.f2780r;
        fragmentInstantiate.f2686x = d0Var.f2781s;
        fragmentInstantiate.L = d0Var.f2782t;
        fragmentInstantiate.K = d0Var.f2784v;
        fragmentInstantiate.Z = Lifecycle.State.values()[d0Var.f2785w];
        Bundle bundle2 = d0Var.f2786x;
        if (bundle2 != null) {
            fragmentInstantiate.f2675m = bundle2;
        } else {
            fragmentInstantiate.f2675m = new Bundle();
        }
        this.f2794c = fragmentInstantiate;
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    /* compiled from: FragmentStateManager.java */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2797b;

        public a(View view) {
            this.f2797b = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            View view2 = this.f2797b;
            view2.removeOnAttachStateChangeListener(this);
            x0.j0.requestApplyInsets(view2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public e0(w wVar, f0 f0Var, Fragment fragment, d0 d0Var) {
        this.f2792a = wVar;
        this.f2793b = f0Var;
        this.f2794c = fragment;
        fragment.f2676n = null;
        fragment.f2677o = null;
        fragment.C = 0;
        fragment.f2688z = false;
        fragment.f2685w = false;
        Fragment fragment2 = fragment.f2681s;
        fragment.f2682t = fragment2 != null ? fragment2.f2679q : null;
        fragment.f2681s = null;
        Bundle bundle = d0Var.f2786x;
        if (bundle != null) {
            fragment.f2675m = bundle;
        } else {
            fragment.f2675m = new Bundle();
        }
    }
}
