package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public final class m extends SpecialEffectsController {

    /* compiled from: DefaultSpecialEffectsController.java */
    public static class a extends b {

        /* renamed from: c, reason: collision with root package name */
        public final boolean f2869c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2870d;

        /* renamed from: e, reason: collision with root package name */
        public q.a f2871e;

        public a(SpecialEffectsController.Operation operation, t0.d dVar, boolean z10) {
            super(operation, dVar);
            this.f2870d = false;
            this.f2869c = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final androidx.fragment.app.q.a c(android.content.Context r10) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 284
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.a.c(android.content.Context):androidx.fragment.app.q$a");
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final SpecialEffectsController.Operation f2872a;

        /* renamed from: b, reason: collision with root package name */
        public final t0.d f2873b;

        public b(SpecialEffectsController.Operation operation, t0.d dVar) {
            this.f2872a = operation;
            this.f2873b = dVar;
        }

        public final void a() {
            this.f2872a.completeSpecialEffect(this.f2873b);
        }

        public final boolean b() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation operation = this.f2872a;
            SpecialEffectsController.Operation.State stateC = SpecialEffectsController.Operation.State.c(operation.getFragment().S);
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            return stateC == finalState || !(stateC == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    public static class c extends b {

        /* renamed from: c, reason: collision with root package name */
        public final Object f2874c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2875d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f2876e;

        public c(SpecialEffectsController.Operation operation, t0.d dVar, boolean z10, boolean z11) {
            super(operation, dVar);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.f2874c = z10 ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.f2875d = z10 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.f2874c = z10 ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.f2875d = true;
            }
            if (!z11) {
                this.f2876e = null;
            } else if (z10) {
                this.f2876e = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.f2876e = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        public final k0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            i0 i0Var = h0.f2837a;
            if (i0Var != null && i0Var.canHandle(obj)) {
                return i0Var;
            }
            k0 k0Var = h0.f2838b;
            if (k0Var != null && k0Var.canHandle(obj)) {
                return k0Var;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f2872a.getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }

        public Object getSharedElementTransition() {
            return this.f2876e;
        }

        public boolean hasSharedElementTransition() {
            return this.f2876e != null;
        }
    }

    public m(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public static void j(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (x0.n0.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                j(arrayList, childAt);
            }
        }
    }

    public static void k(b0.b bVar, View view) {
        String transitionName = x0.j0.getTransitionName(view);
        if (transitionName != null) {
            bVar.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    k(bVar, childAt);
                }
            }
        }
    }

    public static void l(b0.b bVar, Collection collection) {
        Iterator it = bVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(x0.j0.getTransitionName((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.SpecialEffectsController
    public final void b(ArrayList arrayList, boolean z10) throws Resources.NotFoundException {
        SpecialEffectsController.Operation.State state;
        ArrayList arrayList2;
        HashMap map;
        SpecialEffectsController.Operation operation;
        SpecialEffectsController.Operation operation2;
        String str;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation.State state2;
        SpecialEffectsController.Operation operation4;
        SpecialEffectsController.Operation.State state3;
        String str2;
        b0.b bVar;
        SpecialEffectsController.Operation operation5;
        Object obj;
        SpecialEffectsController.Operation.State state4;
        View view;
        SpecialEffectsController.Operation.State state5;
        View view2;
        SpecialEffectsController.Operation operation6;
        SpecialEffectsController.Operation.State state6;
        String str3;
        ArrayList arrayList3;
        Iterator it;
        HashMap map2;
        ArrayList<String> arrayList4;
        ArrayList<String> arrayList5;
        ArrayList<String> arrayList6;
        ArrayList<String> arrayList7;
        int i10;
        View view3;
        SpecialEffectsController.Operation operation7;
        Iterator it2;
        String str4;
        ArrayList arrayList8;
        Iterator it3 = arrayList.iterator();
        SpecialEffectsController.Operation operation8 = null;
        SpecialEffectsController.Operation operation9 = null;
        while (true) {
            boolean zHasNext = it3.hasNext();
            state = SpecialEffectsController.Operation.State.VISIBLE;
            if (!zHasNext) {
                break;
            }
            SpecialEffectsController.Operation operation10 = (SpecialEffectsController.Operation) it3.next();
            SpecialEffectsController.Operation.State stateC = SpecialEffectsController.Operation.State.c(operation10.getFragment().S);
            int iOrdinal = operation10.getFinalState().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (stateC != state) {
                    operation9 = operation10;
                }
            }
            if (stateC == state && operation8 == null) {
                operation8 = operation10;
            }
        }
        String str5 = " to ";
        String str6 = "FragmentManager";
        if (y.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation8 + " to " + operation9);
        }
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList(arrayList);
        Fragment fragment = ((SpecialEffectsController.Operation) arrayList.get(arrayList.size() - 1)).getFragment();
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            SpecialEffectsController.Operation operation11 = (SpecialEffectsController.Operation) it4.next();
            operation11.getFragment().V.f2693b = fragment.V.f2693b;
            operation11.getFragment().V.f2694c = fragment.V.f2694c;
            operation11.getFragment().V.f2695d = fragment.V.f2695d;
            operation11.getFragment().V.f2696e = fragment.V.f2696e;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            SpecialEffectsController.Operation operation12 = (SpecialEffectsController.Operation) it5.next();
            t0.d dVar = new t0.d();
            operation12.markStartedSpecialEffect(dVar);
            arrayList9.add(new a(operation12, dVar, z10));
            t0.d dVar2 = new t0.d();
            operation12.markStartedSpecialEffect(dVar2);
            arrayList10.add(new c(operation12, dVar2, z10, !z10 ? operation12 != operation9 : operation12 != operation8));
            operation12.f2718d.add(new d(this, arrayList11, operation12));
        }
        HashMap map3 = new HashMap();
        Iterator it6 = arrayList10.iterator();
        k0 k0Var = null;
        while (it6.hasNext()) {
            c cVar = (c) it6.next();
            if (cVar.b()) {
                arrayList8 = arrayList9;
                it2 = it6;
                str4 = str5;
            } else {
                Object obj2 = cVar.f2874c;
                k0 k0VarC = cVar.c(obj2);
                it2 = it6;
                Object obj3 = cVar.f2876e;
                k0 k0VarC2 = cVar.c(obj3);
                str4 = str5;
                arrayList8 = arrayList9;
                SpecialEffectsController.Operation operation13 = cVar.f2872a;
                if (k0VarC != null && k0VarC2 != null && k0VarC != k0VarC2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + operation13.getFragment() + " returned Transition " + obj2 + " which uses a different Transition  type than its shared element transition " + obj3);
                }
                if (k0VarC == null) {
                    k0VarC = k0VarC2;
                }
                if (k0Var == null) {
                    k0Var = k0VarC;
                } else if (k0VarC != null && k0Var != k0VarC) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + operation13.getFragment() + " returned Transition " + obj2 + " which uses a different Transition  type than other Fragments.");
                }
            }
            it6 = it2;
            str5 = str4;
            arrayList9 = arrayList8;
        }
        ArrayList arrayList12 = arrayList9;
        String str7 = str5;
        SpecialEffectsController.Operation.State state7 = SpecialEffectsController.Operation.State.GONE;
        if (k0Var == null) {
            Iterator it7 = arrayList10.iterator();
            while (it7.hasNext()) {
                c cVar2 = (c) it7.next();
                map3.put(cVar2.f2872a, Boolean.FALSE);
                cVar2.a();
            }
            state2 = state7;
            operation = operation8;
            operation3 = operation9;
            str = "FragmentManager";
            arrayList2 = arrayList11;
            map = map3;
        } else {
            View view4 = new View(getContainer().getContext());
            Rect rect = new Rect();
            ArrayList<View> arrayList13 = new ArrayList<>();
            ArrayList<View> arrayList14 = new ArrayList<>();
            b0.b bVar2 = new b0.b();
            Iterator it8 = arrayList10.iterator();
            SpecialEffectsController.Operation operation14 = operation9;
            SpecialEffectsController.Operation.State state8 = state;
            arrayList2 = arrayList11;
            Object obj4 = null;
            View view5 = null;
            boolean z11 = false;
            SpecialEffectsController.Operation operation15 = operation8;
            while (it8.hasNext()) {
                c cVar3 = (c) it8.next();
                if (!cVar3.hasSharedElementTransition() || operation15 == null || operation14 == null) {
                    state6 = state7;
                    str3 = str6;
                    arrayList3 = arrayList10;
                    it = it8;
                    map2 = map3;
                } else {
                    Object objWrapTransitionInSet = k0Var.wrapTransitionInSet(k0Var.cloneTransition(cVar3.getSharedElementTransition()));
                    Fragment.c cVar4 = operation9.getFragment().V;
                    if (cVar4 == null || (arrayList4 = cVar4.f2698g) == null) {
                        arrayList4 = new ArrayList<>();
                    }
                    it = it8;
                    Fragment.c cVar5 = operation8.getFragment().V;
                    if (cVar5 == null || (arrayList5 = cVar5.f2698g) == null) {
                        arrayList5 = new ArrayList<>();
                    }
                    state6 = state7;
                    Fragment.c cVar6 = operation8.getFragment().V;
                    if (cVar6 == null || (arrayList6 = cVar6.f2699h) == null) {
                        arrayList6 = new ArrayList<>();
                    }
                    HashMap map4 = map3;
                    arrayList3 = arrayList10;
                    int i11 = 0;
                    while (i11 < arrayList6.size()) {
                        int iIndexOf = arrayList4.indexOf(arrayList6.get(i11));
                        ArrayList<String> arrayList15 = arrayList6;
                        if (iIndexOf != -1) {
                            arrayList4.set(iIndexOf, arrayList5.get(i11));
                        }
                        i11++;
                        arrayList6 = arrayList15;
                    }
                    Fragment.c cVar7 = operation9.getFragment().V;
                    if (cVar7 == null || (arrayList7 = cVar7.f2699h) == null) {
                        arrayList7 = new ArrayList<>();
                    }
                    if (z10) {
                        operation8.getFragment().getClass();
                        operation9.getFragment().getClass();
                    } else {
                        operation8.getFragment().getClass();
                        operation9.getFragment().getClass();
                    }
                    int i12 = 0;
                    for (int size = arrayList4.size(); i12 < size; size = size) {
                        bVar2.put(arrayList4.get(i12), arrayList7.get(i12));
                        i12++;
                    }
                    if (y.isLoggingEnabled(2)) {
                        Log.v(str6, ">>> entering view names <<<");
                        for (Iterator<String> it9 = arrayList7.iterator(); it9.hasNext(); it9 = it9) {
                            Log.v(str6, "Name: " + it9.next());
                        }
                        Log.v(str6, ">>> exiting view names <<<");
                        for (Iterator<String> it10 = arrayList4.iterator(); it10.hasNext(); it10 = it10) {
                            Log.v(str6, "Name: " + it10.next());
                        }
                    }
                    b0.b bVar3 = new b0.b();
                    k(bVar3, operation8.getFragment().S);
                    bVar3.retainAll(arrayList4);
                    bVar2.retainAll(bVar3.keySet());
                    b0.b bVar4 = new b0.b();
                    k(bVar4, operation9.getFragment().S);
                    bVar4.retainAll(arrayList7);
                    bVar4.retainAll(bVar2.values());
                    i0 i0Var = h0.f2837a;
                    int size2 = bVar2.size() - 1;
                    while (size2 >= 0) {
                        String str8 = str6;
                        if (!bVar4.containsKey((String) bVar2.valueAt(size2))) {
                            bVar2.removeAt(size2);
                        }
                        size2--;
                        str6 = str8;
                    }
                    str3 = str6;
                    l(bVar3, bVar2.keySet());
                    l(bVar4, bVar2.values());
                    if (bVar2.isEmpty()) {
                        arrayList13.clear();
                        arrayList14.clear();
                        operation15 = operation8;
                        operation14 = operation9;
                        map2 = map4;
                        obj4 = null;
                    } else {
                        Fragment fragment2 = operation9.getFragment();
                        Fragment fragment3 = operation8.getFragment();
                        if (z10) {
                            fragment3.getClass();
                        } else {
                            fragment2.getClass();
                        }
                        x0.y.add(getContainer(), new i(operation9, operation8, z10, bVar4));
                        arrayList13.addAll(bVar3.values());
                        if (arrayList4.isEmpty()) {
                            i10 = 0;
                        } else {
                            i10 = 0;
                            View view6 = (View) bVar3.get(arrayList4.get(0));
                            k0Var.setEpicenter(objWrapTransitionInSet, view6);
                            view5 = view6;
                        }
                        arrayList14.addAll(bVar4.values());
                        if (!arrayList7.isEmpty() && (view3 = (View) bVar4.get(arrayList7.get(i10))) != null) {
                            x0.y.add(getContainer(), new j(k0Var, view3, rect));
                            z11 = true;
                        }
                        k0Var.setSharedElementTargets(objWrapTransitionInSet, view4, arrayList13);
                        k0Var.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList14);
                        Boolean bool = Boolean.TRUE;
                        map2 = map4;
                        map2.put(operation8, bool);
                        map2.put(operation9, bool);
                        operation14 = operation9;
                        obj4 = objWrapTransitionInSet;
                        operation15 = operation8;
                    }
                }
                map3 = map2;
                it8 = it;
                state7 = state6;
                arrayList10 = arrayList3;
                str6 = str3;
            }
            SpecialEffectsController.Operation.State state9 = state7;
            String str9 = str6;
            ArrayList arrayList16 = arrayList10;
            map = map3;
            ArrayList arrayList17 = new ArrayList();
            Iterator it11 = arrayList16.iterator();
            SpecialEffectsController.Operation operation16 = operation14;
            Object objMergeTransitionsTogether = null;
            Object objMergeTransitionsTogether2 = null;
            while (it11.hasNext()) {
                Iterator it12 = it11;
                c cVar8 = (c) it11.next();
                boolean zB = cVar8.b();
                SpecialEffectsController.Operation operation17 = operation8;
                SpecialEffectsController.Operation operation18 = cVar8.f2872a;
                if (zB) {
                    bVar = bVar2;
                    map.put(operation18, Boolean.FALSE);
                    cVar8.a();
                    view = view4;
                    operation5 = operation9;
                    obj = obj4;
                    operation6 = operation16;
                    view2 = view5;
                    state5 = state8;
                    state4 = state9;
                } else {
                    bVar = bVar2;
                    Object objCloneTransition = k0Var.cloneTransition(cVar8.f2874c);
                    boolean z12 = obj4 != null && (operation18 == operation15 || operation18 == operation16);
                    if (objCloneTransition == null) {
                        if (!z12) {
                            map.put(operation18, Boolean.FALSE);
                            cVar8.a();
                        }
                        view = view4;
                        operation5 = operation9;
                        obj = obj4;
                        view2 = view5;
                        state5 = state8;
                        state4 = state9;
                    } else {
                        operation5 = operation9;
                        ArrayList<View> arrayList18 = new ArrayList<>();
                        obj = obj4;
                        j(arrayList18, operation18.getFragment().S);
                        if (z12) {
                            if (operation18 == operation15) {
                                arrayList18.removeAll(arrayList13);
                            } else {
                                arrayList18.removeAll(arrayList14);
                            }
                        }
                        if (arrayList18.isEmpty()) {
                            k0Var.addTarget(objCloneTransition, view4);
                            view = view4;
                            state4 = state9;
                        } else {
                            k0Var.addTargets(objCloneTransition, arrayList18);
                            k0Var.scheduleRemoveTargets(objCloneTransition, objCloneTransition, arrayList18, null, null, null, null);
                            state4 = state9;
                            if (operation18.getFinalState() == state4) {
                                arrayList2.remove(operation18);
                                view = view4;
                                ArrayList<View> arrayList19 = new ArrayList<>(arrayList18);
                                arrayList19.remove(operation18.getFragment().S);
                                k0Var.scheduleHideFragmentView(objCloneTransition, operation18.getFragment().S, arrayList19);
                                x0.y.add(getContainer(), new k(arrayList18));
                            } else {
                                view = view4;
                            }
                        }
                        state5 = state8;
                        if (operation18.getFinalState() == state5) {
                            arrayList17.addAll(arrayList18);
                            if (z11) {
                                k0Var.setEpicenter(objCloneTransition, rect);
                            }
                            view2 = view5;
                        } else {
                            view2 = view5;
                            k0Var.setEpicenter(objCloneTransition, view2);
                        }
                        map.put(operation18, Boolean.TRUE);
                        if (cVar8.f2875d) {
                            objMergeTransitionsTogether2 = k0Var.mergeTransitionsTogether(objMergeTransitionsTogether2, objCloneTransition, null);
                        } else {
                            objMergeTransitionsTogether = k0Var.mergeTransitionsTogether(objMergeTransitionsTogether, objCloneTransition, null);
                        }
                    }
                    operation6 = operation5;
                }
                view5 = view2;
                state8 = state5;
                state9 = state4;
                view4 = view;
                operation8 = operation17;
                bVar2 = bVar;
                operation9 = operation5;
                obj4 = obj;
                operation16 = operation6;
                it11 = it12;
            }
            operation = operation8;
            SpecialEffectsController.Operation operation19 = operation9;
            Object obj5 = obj4;
            Map map5 = bVar2;
            SpecialEffectsController.Operation.State state10 = state9;
            Object objMergeTransitionsInSequence = k0Var.mergeTransitionsInSequence(objMergeTransitionsTogether2, objMergeTransitionsTogether, obj5);
            if (objMergeTransitionsInSequence == null) {
                operation2 = operation19;
                str = str9;
            } else {
                Iterator it13 = arrayList16.iterator();
                while (it13.hasNext()) {
                    c cVar9 = (c) it13.next();
                    if (!cVar9.b()) {
                        SpecialEffectsController.Operation operation20 = cVar9.f2872a;
                        SpecialEffectsController.Operation operation21 = operation19;
                        boolean z13 = obj5 != null && (operation20 == operation15 || operation20 == operation21);
                        if (cVar9.f2874c == null && !z13) {
                            str2 = str9;
                        } else if (x0.j0.isLaidOut(getContainer())) {
                            str2 = str9;
                            k0Var.setListenerForTransitionEnd(operation20.getFragment(), objMergeTransitionsInSequence, cVar9.f2873b, new l(cVar9, operation20));
                        } else {
                            if (y.isLoggingEnabled(2)) {
                                str2 = str9;
                                Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation20);
                            } else {
                                str2 = str9;
                            }
                            cVar9.a();
                        }
                        operation19 = operation21;
                        str9 = str2;
                    }
                }
                operation2 = operation19;
                str = str9;
                if (x0.j0.isLaidOut(getContainer())) {
                    h0.a(4, arrayList17);
                    ArrayList arrayList20 = new ArrayList();
                    int size3 = arrayList14.size();
                    for (int i13 = 0; i13 < size3; i13++) {
                        View view7 = arrayList14.get(i13);
                        arrayList20.add(x0.j0.getTransitionName(view7));
                        x0.j0.setTransitionName(view7, null);
                    }
                    if (y.isLoggingEnabled(2)) {
                        Log.v(str, ">>>>> Beginning transition <<<<<");
                        Log.v(str, ">>>>> SharedElementFirstOutViews <<<<<");
                        Iterator<View> it14 = arrayList13.iterator();
                        while (it14.hasNext()) {
                            View next = it14.next();
                            Log.v(str, "View: " + next + " Name: " + x0.j0.getTransitionName(next));
                        }
                        Log.v(str, ">>>>> SharedElementLastInViews <<<<<");
                        Iterator<View> it15 = arrayList14.iterator();
                        while (it15.hasNext()) {
                            View next2 = it15.next();
                            Log.v(str, "View: " + next2 + " Name: " + x0.j0.getTransitionName(next2));
                        }
                    }
                    k0Var.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
                    ViewGroup container = getContainer();
                    int size4 = arrayList14.size();
                    ArrayList arrayList21 = new ArrayList();
                    int i14 = 0;
                    while (i14 < size4) {
                        View view8 = arrayList13.get(i14);
                        String transitionName = x0.j0.getTransitionName(view8);
                        arrayList21.add(transitionName);
                        if (transitionName == null) {
                            operation4 = operation2;
                            state3 = state10;
                        } else {
                            operation4 = operation2;
                            x0.j0.setTransitionName(view8, null);
                            String str10 = (String) map5.get(transitionName);
                            int i15 = 0;
                            while (true) {
                                state3 = state10;
                                if (i15 >= size4) {
                                    break;
                                }
                                if (str10.equals(arrayList20.get(i15))) {
                                    x0.j0.setTransitionName(arrayList14.get(i15), transitionName);
                                    break;
                                } else {
                                    i15++;
                                    state10 = state3;
                                }
                            }
                        }
                        i14++;
                        state10 = state3;
                        operation2 = operation4;
                    }
                    operation3 = operation2;
                    state2 = state10;
                    x0.y.add(container, new j0(size4, arrayList14, arrayList20, arrayList13, arrayList21));
                    h0.a(0, arrayList17);
                    k0Var.swapSharedElementTargets(obj5, arrayList13, arrayList14);
                }
            }
            operation3 = operation2;
            state2 = state10;
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup container2 = getContainer();
        Context context = container2.getContext();
        ArrayList arrayList22 = new ArrayList();
        Iterator it16 = arrayList12.iterator();
        boolean z14 = false;
        while (it16.hasNext()) {
            a aVar = (a) it16.next();
            if (aVar.b()) {
                aVar.a();
            } else {
                q.a aVarC = aVar.c(context);
                if (aVarC == null) {
                    aVar.a();
                } else {
                    Animator animator = aVarC.f2905b;
                    if (animator == null) {
                        arrayList22.add(aVar);
                    } else {
                        SpecialEffectsController.Operation operation22 = aVar.f2872a;
                        Fragment fragment4 = operation22.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation22))) {
                            if (y.isLoggingEnabled(2)) {
                                Log.v(str, "Ignoring Animator set on " + fragment4 + " as this Fragment was involved in a Transition.");
                            }
                            aVar.a();
                        } else {
                            SpecialEffectsController.Operation.State state11 = state2;
                            boolean z15 = operation22.getFinalState() == state11;
                            ArrayList arrayList23 = arrayList2;
                            if (z15) {
                                arrayList23.remove(operation22);
                            }
                            View view9 = fragment4.S;
                            container2.startViewTransition(view9);
                            animator.addListener(new e(container2, view9, z15, operation22, aVar));
                            animator.setTarget(view9);
                            animator.start();
                            if (y.isLoggingEnabled(2)) {
                                StringBuilder sb2 = new StringBuilder("Animator from operation ");
                                operation7 = operation22;
                                sb2.append(operation7);
                                sb2.append(" has started.");
                                Log.v(str, sb2.toString());
                            } else {
                                operation7 = operation22;
                            }
                            aVar.f2873b.setOnCancelListener(new f(animator, operation7));
                            arrayList2 = arrayList23;
                            state2 = state11;
                            z14 = true;
                        }
                    }
                }
            }
        }
        ArrayList arrayList24 = arrayList2;
        Iterator it17 = arrayList22.iterator();
        while (it17.hasNext()) {
            a aVar2 = (a) it17.next();
            SpecialEffectsController.Operation operation23 = aVar2.f2872a;
            Fragment fragment5 = operation23.getFragment();
            if (zContainsValue) {
                if (y.isLoggingEnabled(2)) {
                    Log.v(str, "Ignoring Animation set on " + fragment5 + " as Animations cannot run alongside Transitions.");
                }
                aVar2.a();
            } else if (z14) {
                if (y.isLoggingEnabled(2)) {
                    Log.v(str, "Ignoring Animation set on " + fragment5 + " as Animations cannot run alongside Animators.");
                }
                aVar2.a();
            } else {
                View view10 = fragment5.S;
                Animation animation = (Animation) w0.h.checkNotNull(((q.a) w0.h.checkNotNull(aVar2.c(context))).f2904a);
                if (operation23.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view10.startAnimation(animation);
                    aVar2.a();
                } else {
                    container2.startViewTransition(view10);
                    q.b bVar5 = new q.b(animation, container2, view10);
                    bVar5.setAnimationListener(new g(view10, container2, aVar2, operation23));
                    view10.startAnimation(bVar5);
                    if (y.isLoggingEnabled(2)) {
                        Log.v(str, "Animation from operation " + operation23 + " has started.");
                    }
                }
                aVar2.f2873b.setOnCancelListener(new h(view10, container2, aVar2, operation23));
            }
        }
        Iterator it18 = arrayList24.iterator();
        while (it18.hasNext()) {
            SpecialEffectsController.Operation operation24 = (SpecialEffectsController.Operation) it18.next();
            operation24.getFinalState().a(operation24.getFragment().S);
        }
        arrayList24.clear();
        if (y.isLoggingEnabled(2)) {
            Log.v(str, "Completed executing operations from " + operation + str7 + operation3);
        }
    }
}
