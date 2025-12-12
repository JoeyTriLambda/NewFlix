package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.k0;
import androidx.transition.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
/* loaded from: classes.dex */
public class c extends k0 {

    /* compiled from: FragmentTransitionSupport.java */
    public class a extends e.d {
    }

    /* compiled from: FragmentTransitionSupport.java */
    public class b implements e.InterfaceC0045e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4386b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4387m;

        public b(View view, ArrayList arrayList) {
            this.f4386b = view;
            this.f4387m = arrayList;
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionEnd(androidx.transition.e eVar, boolean z10) {
            q2.f.a(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionStart(androidx.transition.e eVar, boolean z10) {
            q2.f.b(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(androidx.transition.e eVar) {
            eVar.removeListener(this);
            this.f4386b.setVisibility(8);
            ArrayList arrayList = this.f4387m;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) arrayList.get(i10)).setVisibility(0);
            }
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(androidx.transition.e eVar) {
            eVar.removeListener(this);
            eVar.addListener(this);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionCancel(androidx.transition.e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionPause(androidx.transition.e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionResume(androidx.transition.e eVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: androidx.transition.c$c, reason: collision with other inner class name */
    public class C0044c extends f {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4388b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4389m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Object f4390n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4391o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ Object f4392p;

        /* renamed from: q, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4393q;

        public C0044c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f4388b = obj;
            this.f4389m = arrayList;
            this.f4390n = obj2;
            this.f4391o = arrayList2;
            this.f4392p = obj3;
            this.f4393q = arrayList3;
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(androidx.transition.e eVar) {
            eVar.removeListener(this);
        }

        @Override // androidx.transition.f, androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(androidx.transition.e eVar) {
            c cVar = c.this;
            Object obj = this.f4388b;
            if (obj != null) {
                cVar.replaceTargets(obj, this.f4389m, null);
            }
            Object obj2 = this.f4390n;
            if (obj2 != null) {
                cVar.replaceTargets(obj2, this.f4391o, null);
            }
            Object obj3 = this.f4392p;
            if (obj3 != null) {
                cVar.replaceTargets(obj3, this.f4393q, null);
            }
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    public class d implements e.InterfaceC0045e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f4395b;

        public d(Runnable runnable) {
            this.f4395b = runnable;
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionEnd(androidx.transition.e eVar, boolean z10) {
            q2.f.a(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(androidx.transition.e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(androidx.transition.e eVar) {
            this.f4395b.run();
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionStart(androidx.transition.e eVar, boolean z10) {
            q2.f.b(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionCancel(androidx.transition.e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionPause(androidx.transition.e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionResume(androidx.transition.e eVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    public class e extends e.d {
    }

    public static boolean a(androidx.transition.e eVar) {
        return (k0.isNullOrEmpty(eVar.getTargetIds()) && k0.isNullOrEmpty(eVar.getTargetNames()) && k0.isNullOrEmpty(eVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.k0
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((androidx.transition.e) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.k0
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        androidx.transition.e eVar = (androidx.transition.e) obj;
        if (eVar == null) {
            return;
        }
        int i10 = 0;
        if (eVar instanceof h) {
            h hVar = (h) eVar;
            int transitionCount = hVar.getTransitionCount();
            while (i10 < transitionCount) {
                addTargets(hVar.getTransitionAt(i10), arrayList);
                i10++;
            }
            return;
        }
        if (a(eVar) || !k0.isNullOrEmpty(eVar.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            eVar.addTarget(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.k0
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        g.beginDelayedTransition(viewGroup, (androidx.transition.e) obj);
    }

    @Override // androidx.fragment.app.k0
    public boolean canHandle(Object obj) {
        return obj instanceof androidx.transition.e;
    }

    @Override // androidx.fragment.app.k0
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((androidx.transition.e) obj).mo10clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.k0
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        androidx.transition.e ordering = (androidx.transition.e) obj;
        androidx.transition.e eVar = (androidx.transition.e) obj2;
        androidx.transition.e eVar2 = (androidx.transition.e) obj3;
        if (ordering != null && eVar != null) {
            ordering = new h().addTransition(ordering).addTransition(eVar).setOrdering(1);
        } else if (ordering == null) {
            ordering = eVar != null ? eVar : null;
        }
        if (eVar2 == null) {
            return ordering;
        }
        h hVar = new h();
        if (ordering != null) {
            hVar.addTransition(ordering);
        }
        hVar.addTransition(eVar2);
        return hVar;
    }

    @Override // androidx.fragment.app.k0
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        h hVar = new h();
        if (obj != null) {
            hVar.addTransition((androidx.transition.e) obj);
        }
        if (obj2 != null) {
            hVar.addTransition((androidx.transition.e) obj2);
        }
        if (obj3 != null) {
            hVar.addTransition((androidx.transition.e) obj3);
        }
        return hVar;
    }

    public void replaceTargets(Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        androidx.transition.e eVar = (androidx.transition.e) obj;
        int i10 = 0;
        if (eVar instanceof h) {
            h hVar = (h) eVar;
            int transitionCount = hVar.getTransitionCount();
            while (i10 < transitionCount) {
                replaceTargets(hVar.getTransitionAt(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (a(eVar)) {
            return;
        }
        List<View> targets = eVar.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                eVar.addTarget(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                eVar.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.k0
    public void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((androidx.transition.e) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.k0
    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((androidx.transition.e) obj).addListener(new C0044c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.k0
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            getBoundsOnScreen(view, new Rect());
            ((androidx.transition.e) obj).setEpicenterCallback(new a());
        }
    }

    @Override // androidx.fragment.app.k0
    public void setListenerForTransitionEnd(Fragment fragment, Object obj, t0.d dVar, Runnable runnable) {
        setListenerForTransitionEnd(fragment, obj, dVar, null, runnable);
    }

    @Override // androidx.fragment.app.k0
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        h hVar = (h) obj;
        List<View> targets = hVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k0.bfsAddViewChildren(targets, arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(hVar, arrayList);
    }

    @Override // androidx.fragment.app.k0
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        h hVar = (h) obj;
        if (hVar != null) {
            hVar.getTargets().clear();
            hVar.getTargets().addAll(arrayList2);
            replaceTargets(hVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.k0
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        h hVar = new h();
        hVar.addTransition((androidx.transition.e) obj);
        return hVar;
    }

    public void setListenerForTransitionEnd(Fragment fragment, Object obj, t0.d dVar, Runnable runnable, Runnable runnable2) {
        androidx.transition.e eVar = (androidx.transition.e) obj;
        dVar.setOnCancelListener(new q2.b(runnable, eVar, runnable2));
        eVar.addListener(new d(runnable2));
    }

    @Override // androidx.fragment.app.k0
    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((androidx.transition.e) obj).setEpicenterCallback(new e());
        }
    }
}
