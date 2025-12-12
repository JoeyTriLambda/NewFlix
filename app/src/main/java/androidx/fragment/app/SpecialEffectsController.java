package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import t0.d;

/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f2710a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Operation> f2711b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Operation> f2712c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2713d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2714e = false;

    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f2732b;

        public a(c cVar) {
            this.f2732b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<Operation> arrayList = SpecialEffectsController.this.f2711b;
            c cVar = this.f2732b;
            if (arrayList.contains(cVar)) {
                cVar.getFinalState().a(cVar.getFragment().S);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f2734b;

        public b(c cVar) {
            this.f2734b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialEffectsController specialEffectsController = SpecialEffectsController.this;
            ArrayList<Operation> arrayList = specialEffectsController.f2711b;
            c cVar = this.f2734b;
            arrayList.remove(cVar);
            specialEffectsController.f2712c.remove(cVar);
        }
    }

    public static class c extends Operation {

        /* renamed from: h, reason: collision with root package name */
        public final e0 f2736h;

        public c(Operation.State state, Operation.LifecycleImpact lifecycleImpact, e0 e0Var, t0.d dVar) {
            super(state, lifecycleImpact, e0Var.f2794c, dVar);
            this.f2736h = e0Var;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public final void c() {
            Operation.LifecycleImpact lifecycleImpact = this.f2716b;
            Operation.LifecycleImpact lifecycleImpact2 = Operation.LifecycleImpact.ADDING;
            e0 e0Var = this.f2736h;
            if (lifecycleImpact != lifecycleImpact2) {
                if (lifecycleImpact == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragment = e0Var.f2794c;
                    View viewRequireView = fragment.requireView();
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragment);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragment2 = e0Var.f2794c;
            View viewFindFocus = fragment2.S.findFocus();
            if (viewFindFocus != null) {
                fragment2.b().f2704m = viewFindFocus;
                if (y.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment2);
                }
            }
            View viewRequireView2 = getFragment().requireView();
            if (viewRequireView2.getParent() == null) {
                e0Var.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            Fragment.c cVar = fragment2.V;
            viewRequireView2.setAlpha(cVar == null ? 1.0f : cVar.f2703l);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.f2736h.k();
        }
    }

    public SpecialEffectsController(ViewGroup viewGroup) {
        this.f2710a = viewGroup;
    }

    public static SpecialEffectsController f(ViewGroup viewGroup, y yVar) {
        return g(viewGroup, yVar.B());
    }

    public static SpecialEffectsController g(ViewGroup viewGroup, n0 n0Var) {
        int i10 = R.id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController specialEffectsControllerCreateController = ((y.e) n0Var).createController(viewGroup);
        viewGroup.setTag(i10, specialEffectsControllerCreateController);
        return specialEffectsControllerCreateController;
    }

    public final void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, e0 e0Var) {
        synchronized (this.f2711b) {
            t0.d dVar = new t0.d();
            Operation operationD = d(e0Var.f2794c);
            if (operationD != null) {
                operationD.b(state, lifecycleImpact);
                return;
            }
            c cVar = new c(state, lifecycleImpact, e0Var, dVar);
            this.f2711b.add(cVar);
            cVar.f2718d.add(new a(cVar));
            cVar.f2718d.add(new b(cVar));
        }
    }

    public abstract void b(ArrayList arrayList, boolean z10);

    public final void c() {
        if (this.f2714e) {
            return;
        }
        if (!x0.j0.isAttachedToWindow(this.f2710a)) {
            e();
            this.f2713d = false;
            return;
        }
        synchronized (this.f2711b) {
            if (!this.f2711b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f2712c);
                this.f2712c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Operation operation = (Operation) it.next();
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                    }
                    operation.a();
                    if (!operation.f2721g) {
                        this.f2712c.add(operation);
                    }
                }
                i();
                ArrayList arrayList2 = new ArrayList(this.f2711b);
                this.f2711b.clear();
                this.f2712c.addAll(arrayList2);
                if (y.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).c();
                }
                b(arrayList2, this.f2713d);
                this.f2713d = false;
                if (y.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                }
            }
        }
    }

    public final Operation d(Fragment fragment) {
        Iterator<Operation> it = this.f2711b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.f2720f) {
                return next;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = x0.j0.isAttachedToWindow(this.f2710a);
        synchronized (this.f2711b) {
            i();
            Iterator<Operation> it = this.f2711b.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            Iterator it2 = new ArrayList(this.f2712c).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (y.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (zIsAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f2710a + " is not attached to window. ";
                    }
                    sb2.append(str2);
                    sb2.append("Cancelling running operation ");
                    sb2.append(operation);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation.a();
            }
            Iterator it3 = new ArrayList(this.f2711b).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (y.isLoggingEnabled(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (zIsAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.f2710a + " is not attached to window. ";
                    }
                    sb3.append(str);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(operation2);
                    Log.v("FragmentManager", sb3.toString());
                }
                operation2.a();
            }
        }
    }

    public ViewGroup getContainer() {
        return this.f2710a;
    }

    public final void h() {
        synchronized (this.f2711b) {
            i();
            this.f2714e = false;
            int size = this.f2711b.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Operation operation = this.f2711b.get(size);
                Operation.State stateC = Operation.State.c(operation.getFragment().S);
                Operation.State finalState = operation.getFinalState();
                Operation.State state = Operation.State.VISIBLE;
                if (finalState == state && stateC != state) {
                    Fragment.c cVar = operation.getFragment().V;
                    this.f2714e = false;
                    break;
                }
            }
        }
    }

    public final void i() {
        Iterator<Operation> it = this.f2711b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f2716b == Operation.LifecycleImpact.ADDING) {
                next.b(Operation.State.b(next.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        public State f2715a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleImpact f2716b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f2717c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f2718d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final HashSet<t0.d> f2719e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        public boolean f2720f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2721g = false;

        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static State b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(ac.c.f("Unknown visibility ", i10));
            }

            public static State c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            public final void a(View view) {
                int iOrdinal = ordinal();
                if (iOrdinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (y.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (iOrdinal == 1) {
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (iOrdinal == 2) {
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (iOrdinal != 3) {
                    return;
                }
                if (y.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public class a implements d.a {
            public a() {
            }

            @Override // t0.d.a
            public void onCancel() {
                Operation.this.a();
            }
        }

        public Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, t0.d dVar) {
            this.f2715a = state;
            this.f2716b = lifecycleImpact;
            this.f2717c = fragment;
            dVar.setOnCancelListener(new a());
        }

        public final void a() {
            if (this.f2720f) {
                return;
            }
            this.f2720f = true;
            HashSet<t0.d> hashSet = this.f2719e;
            if (hashSet.isEmpty()) {
                complete();
                return;
            }
            Iterator it = new ArrayList(hashSet).iterator();
            while (it.hasNext()) {
                ((t0.d) it.next()).cancel();
            }
        }

        public final void b(State state, LifecycleImpact lifecycleImpact) {
            int iOrdinal = lifecycleImpact.ordinal();
            State state2 = State.REMOVED;
            Fragment fragment = this.f2717c;
            if (iOrdinal == 0) {
                if (this.f2715a != state2) {
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f2715a + " -> " + state + ". ");
                    }
                    this.f2715a = state;
                    return;
                }
                return;
            }
            if (iOrdinal == 1) {
                if (this.f2715a == state2) {
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2716b + " to ADDING.");
                    }
                    this.f2715a = State.VISIBLE;
                    this.f2716b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f2715a + " -> REMOVED. mLifecycleImpact  = " + this.f2716b + " to REMOVING.");
            }
            this.f2715a = state2;
            this.f2716b = LifecycleImpact.REMOVING;
        }

        public void complete() {
            if (this.f2721g) {
                return;
            }
            if (y.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f2721g = true;
            Iterator it = this.f2718d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void completeSpecialEffect(t0.d dVar) {
            HashSet<t0.d> hashSet = this.f2719e;
            if (hashSet.remove(dVar) && hashSet.isEmpty()) {
                complete();
            }
        }

        public State getFinalState() {
            return this.f2715a;
        }

        public final Fragment getFragment() {
            return this.f2717c;
        }

        public final void markStartedSpecialEffect(t0.d dVar) {
            c();
            this.f2719e.add(dVar);
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2715a + "} {mLifecycleImpact = " + this.f2716b + "} {mFragment = " + this.f2717c + "}";
        }

        public void c() {
        }
    }
}
