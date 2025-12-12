package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final q2.a f4423a = new q2.a();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<WeakReference<b0.b<ViewGroup, ArrayList<e>>>> f4424b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList<ViewGroup> f4425c = new ArrayList<>();

    public static b0.b<ViewGroup, ArrayList<e>> a() {
        b0.b<ViewGroup, ArrayList<e>> bVar;
        ThreadLocal<WeakReference<b0.b<ViewGroup, ArrayList<e>>>> threadLocal = f4424b;
        WeakReference<b0.b<ViewGroup, ArrayList<e>>> weakReference = threadLocal.get();
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            return bVar;
        }
        b0.b<ViewGroup, ArrayList<e>> bVar2 = new b0.b<>();
        threadLocal.set(new WeakReference<>(bVar2));
        return bVar2;
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, e eVar) {
        ArrayList<ViewGroup> arrayList = f4425c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (eVar == null) {
            eVar = f4423a;
        }
        e eVarMo10clone = eVar.mo10clone();
        ArrayList<e> arrayList2 = a().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<e> it = arrayList2.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (eVarMo10clone != null) {
            eVarMo10clone.d(viewGroup, true);
        }
        d currentScene = d.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
        viewGroup.setTag(R.id.transition_current_scene, null);
        if (eVarMo10clone != null) {
            a aVar = new a(viewGroup, eVarMo10clone);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    /* compiled from: TransitionManager.java */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final e f4426b;

        /* renamed from: m, reason: collision with root package name */
        public final ViewGroup f4427m;

        /* compiled from: TransitionManager.java */
        /* renamed from: androidx.transition.g$a$a, reason: collision with other inner class name */
        public class C0046a extends f {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b0.b f4428b;

            public C0046a(b0.b bVar) {
                this.f4428b = bVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.e.InterfaceC0045e
            public void onTransitionEnd(e eVar) {
                ((ArrayList) this.f4428b.get(a.this.f4427m)).remove(eVar);
                eVar.removeListener(this);
            }
        }

        public a(ViewGroup viewGroup, e eVar) {
            this.f4426b = eVar;
            this.f4427m = viewGroup;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:106:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01e2 A[EDGE_INSN: B:137:0x01e2->B:89:0x01e2 BREAK  A[LOOP:1: B:19:0x0086->B:88:0x01da], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01eb  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x020e  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onPreDraw() {
            /*
                Method dump skipped, instructions count: 694
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.g.a.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.f4427m;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            g.f4425c.remove(viewGroup);
            ArrayList<e> arrayList = g.a().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<e> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(viewGroup);
                }
            }
            this.f4426b.e(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
