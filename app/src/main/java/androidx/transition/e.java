package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.fragment.app.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x0.j0;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class e implements Cloneable {
    public static final Animator[] I = new Animator[0];
    public static final int[] J = {2, 1, 3, 4};
    public static final a K = new a();
    public static final ThreadLocal<b0.b<Animator, c>> L = new ThreadLocal<>();
    public d G;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList<q2.i> f4406v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList<q2.i> f4407w;

    /* renamed from: x, reason: collision with root package name */
    public InterfaceC0045e[] f4408x;

    /* renamed from: b, reason: collision with root package name */
    public final String f4396b = getClass().getName();

    /* renamed from: m, reason: collision with root package name */
    public long f4397m = -1;

    /* renamed from: n, reason: collision with root package name */
    public long f4398n = -1;

    /* renamed from: o, reason: collision with root package name */
    public TimeInterpolator f4399o = null;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList<Integer> f4400p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<View> f4401q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    public f0 f4402r = new f0(1);

    /* renamed from: s, reason: collision with root package name */
    public f0 f4403s = new f0(1);

    /* renamed from: t, reason: collision with root package name */
    public h f4404t = null;

    /* renamed from: u, reason: collision with root package name */
    public final int[] f4405u = J;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList<Animator> f4409y = new ArrayList<>();

    /* renamed from: z, reason: collision with root package name */
    public Animator[] f4410z = I;
    public int A = 0;
    public boolean B = false;
    public boolean C = false;
    public e D = null;
    public ArrayList<InterfaceC0045e> E = null;
    public ArrayList<Animator> F = new ArrayList<>();
    public q2.d H = K;

    /* compiled from: Transition.java */
    public class a extends q2.d {
        @Override // q2.d
        public Path getPath(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* compiled from: Transition.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.end();
            animator.removeListener(this);
        }
    }

    /* compiled from: Transition.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final View f4412a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4413b;

        /* renamed from: c, reason: collision with root package name */
        public final q2.i f4414c;

        /* renamed from: d, reason: collision with root package name */
        public final WindowId f4415d;

        /* renamed from: e, reason: collision with root package name */
        public final e f4416e;

        /* renamed from: f, reason: collision with root package name */
        public final Animator f4417f;

        public c(View view, String str, e eVar, WindowId windowId, q2.i iVar, Animator animator) {
            this.f4412a = view;
            this.f4413b = str;
            this.f4414c = iVar;
            this.f4415d = windowId;
            this.f4416e = eVar;
            this.f4417f = animator;
        }
    }

    /* compiled from: Transition.java */
    public static abstract class d {
    }

    /* compiled from: Transition.java */
    /* renamed from: androidx.transition.e$e, reason: collision with other inner class name */
    public interface InterfaceC0045e {
        void onTransitionCancel(e eVar);

        void onTransitionEnd(e eVar);

        void onTransitionEnd(e eVar, boolean z10);

        void onTransitionPause(e eVar);

        void onTransitionResume(e eVar);

        void onTransitionStart(e eVar);

        void onTransitionStart(e eVar, boolean z10);
    }

    /* compiled from: Transition.java */
    public interface f {

        /* renamed from: a, reason: collision with root package name */
        public static final pd.a f4418a = new pd.a(2);

        /* renamed from: c, reason: collision with root package name */
        public static final pd.a f4419c = new pd.a(3);

        /* renamed from: d, reason: collision with root package name */
        public static final pd.a f4420d = new pd.a(4);

        /* renamed from: e, reason: collision with root package name */
        public static final pd.a f4421e = new pd.a(5);

        /* renamed from: f, reason: collision with root package name */
        public static final pd.a f4422f = new pd.a(6);
    }

    public static void a(f0 f0Var, View view, q2.i iVar) {
        ((b0.b) f0Var.f2800a).put(view, iVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            SparseArray sparseArray = (SparseArray) f0Var.f2801b;
            if (sparseArray.indexOfKey(id2) >= 0) {
                sparseArray.put(id2, null);
            } else {
                sparseArray.put(id2, view);
            }
        }
        String transitionName = j0.getTransitionName(view);
        if (transitionName != null) {
            if (((b0.b) f0Var.f2803d).containsKey(transitionName)) {
                ((b0.b) f0Var.f2803d).put(transitionName, null);
            } else {
                ((b0.b) f0Var.f2803d).put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                b0.h hVar = (b0.h) f0Var.f2802c;
                if (hVar.indexOfKey(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    hVar.put(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) hVar.get(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    hVar.put(itemIdAtPosition, null);
                }
            }
        }
    }

    public static b0.b<Animator, c> h() {
        ThreadLocal<b0.b<Animator, c>> threadLocal = L;
        b0.b<Animator, c> bVar = threadLocal.get();
        if (bVar != null) {
            return bVar;
        }
        b0.b<Animator, c> bVar2 = new b0.b<>();
        threadLocal.set(bVar2);
        return bVar2;
    }

    public static boolean j(q2.i iVar, q2.i iVar2, String str) {
        Object obj = iVar.f17785a.get(str);
        Object obj2 = iVar2.f17785a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public e addListener(InterfaceC0045e interfaceC0045e) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(interfaceC0045e);
        return this;
    }

    public e addTarget(View view) {
        this.f4401q.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(animator.getStartDelay() + getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new b());
        animator.start();
    }

    public final void b(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            q2.i iVar = new q2.i(view);
            if (z10) {
                captureStartValues(iVar);
            } else {
                captureEndValues(iVar);
            }
            iVar.f17787c.add(this);
            c(iVar);
            if (z10) {
                a(this.f4402r, view, iVar);
            } else {
                a(this.f4403s, view, iVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                b(viewGroup.getChildAt(i10), z10);
            }
        }
    }

    public void cancel() {
        ArrayList<Animator> arrayList = this.f4409y;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f4410z);
        this.f4410z = I;
        while (true) {
            size--;
            if (size < 0) {
                this.f4410z = animatorArr;
                k(this, f.f4420d);
                return;
            } else {
                Animator animator = animatorArr[size];
                animatorArr[size] = null;
                animator.cancel();
            }
        }
    }

    public abstract void captureEndValues(q2.i iVar);

    public abstract void captureStartValues(q2.i iVar);

    public Animator createAnimator(ViewGroup viewGroup, q2.i iVar, q2.i iVar2) {
        return null;
    }

    public final void d(ViewGroup viewGroup, boolean z10) {
        e(z10);
        ArrayList<Integer> arrayList = this.f4400p;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.f4401q;
        if (size <= 0 && arrayList2.size() <= 0) {
            b(viewGroup, z10);
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            View viewFindViewById = viewGroup.findViewById(arrayList.get(i10).intValue());
            if (viewFindViewById != null) {
                q2.i iVar = new q2.i(viewFindViewById);
                if (z10) {
                    captureStartValues(iVar);
                } else {
                    captureEndValues(iVar);
                }
                iVar.f17787c.add(this);
                c(iVar);
                if (z10) {
                    a(this.f4402r, viewFindViewById, iVar);
                } else {
                    a(this.f4403s, viewFindViewById, iVar);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            View view = arrayList2.get(i11);
            q2.i iVar2 = new q2.i(view);
            if (z10) {
                captureStartValues(iVar2);
            } else {
                captureEndValues(iVar2);
            }
            iVar2.f17787c.add(this);
            c(iVar2);
            if (z10) {
                a(this.f4402r, view, iVar2);
            } else {
                a(this.f4403s, view, iVar2);
            }
        }
    }

    public final void e(boolean z10) {
        if (z10) {
            ((b0.b) this.f4402r.f2800a).clear();
            ((SparseArray) this.f4402r.f2801b).clear();
            ((b0.h) this.f4402r.f2802c).clear();
        } else {
            ((b0.b) this.f4403s.f2800a).clear();
            ((SparseArray) this.f4403s.f2801b).clear();
            ((b0.h) this.f4403s.f2802c).clear();
        }
    }

    public void end() {
        int i10 = this.A - 1;
        this.A = i10;
        if (i10 == 0) {
            k(this, f.f4419c);
            for (int i11 = 0; i11 < ((b0.h) this.f4402r.f2802c).size(); i11++) {
                View view = (View) ((b0.h) this.f4402r.f2802c).valueAt(i11);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i12 = 0; i12 < ((b0.h) this.f4403s.f2802c).size(); i12++) {
                View view2 = (View) ((b0.h) this.f4403s.f2802c).valueAt(i12);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.C = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(android.view.ViewGroup r19, androidx.fragment.app.f0 r20, androidx.fragment.app.f0 r21, java.util.ArrayList<q2.i> r22, java.util.ArrayList<q2.i> r23) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.e.f(android.view.ViewGroup, androidx.fragment.app.f0, androidx.fragment.app.f0, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f4407w;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f4406v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final q2.i g(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            androidx.transition.h r0 = r5.f4404t
            if (r0 == 0) goto L9
            q2.i r6 = r0.g(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList<q2.i> r0 = r5.f4406v
            goto L10
        Le:
            java.util.ArrayList<q2.i> r0 = r5.f4407w
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            q2.i r4 = (q2.i) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f17786b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList<q2.i> r6 = r5.f4407w
            goto L36
        L34:
            java.util.ArrayList<q2.i> r6 = r5.f4406v
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            q2.i r1 = (q2.i) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.e.g(android.view.View, boolean):q2.i");
    }

    public long getDuration() {
        return this.f4398n;
    }

    public d getEpicenterCallback() {
        return this.G;
    }

    public TimeInterpolator getInterpolator() {
        return this.f4399o;
    }

    public String getName() {
        return this.f4396b;
    }

    public q2.d getPathMotion() {
        return this.H;
    }

    public q2.g getPropagation() {
        return null;
    }

    public final e getRootTransition() {
        h hVar = this.f4404t;
        return hVar != null ? hVar.getRootTransition() : this;
    }

    public long getStartDelay() {
        return this.f4397m;
    }

    public List<Integer> getTargetIds() {
        return this.f4400p;
    }

    public List<String> getTargetNames() {
        return null;
    }

    public List<Class<?>> getTargetTypes() {
        return null;
    }

    public List<View> getTargets() {
        return this.f4401q;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q2.i getTransitionValues(View view, boolean z10) {
        h hVar = this.f4404t;
        if (hVar != null) {
            return hVar.getTransitionValues(view, z10);
        }
        return (q2.i) ((b0.b) (z10 ? this.f4402r : this.f4403s).f2800a).get(view);
    }

    public final boolean i(View view) {
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.f4400p;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.f4401q;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id2)) || arrayList2.contains(view);
    }

    public boolean isTransitionRequired(q2.i iVar, q2.i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties == null) {
            Iterator it = iVar.f17785a.keySet().iterator();
            while (it.hasNext()) {
                if (j(iVar, iVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : transitionProperties) {
            if (!j(iVar, iVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public final void k(e eVar, pd.a aVar) {
        e eVar2 = this.D;
        if (eVar2 != null) {
            eVar2.k(eVar, aVar);
        }
        ArrayList<InterfaceC0045e> arrayList = this.E;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.E.size();
        InterfaceC0045e[] interfaceC0045eArr = this.f4408x;
        if (interfaceC0045eArr == null) {
            interfaceC0045eArr = new InterfaceC0045e[size];
        }
        this.f4408x = null;
        InterfaceC0045e[] interfaceC0045eArr2 = (InterfaceC0045e[]) this.E.toArray(interfaceC0045eArr);
        for (int i10 = 0; i10 < size; i10++) {
            aVar.e(interfaceC0045eArr2[i10], eVar, false);
            interfaceC0045eArr2[i10] = null;
        }
        this.f4408x = interfaceC0045eArr2;
    }

    public String l(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(": ");
        if (this.f4398n != -1) {
            sb2.append("dur(");
            sb2.append(this.f4398n);
            sb2.append(") ");
        }
        if (this.f4397m != -1) {
            sb2.append("dly(");
            sb2.append(this.f4397m);
            sb2.append(") ");
        }
        if (this.f4399o != null) {
            sb2.append("interp(");
            sb2.append(this.f4399o);
            sb2.append(") ");
        }
        ArrayList<Integer> arrayList = this.f4400p;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.f4401q;
        if (size > 0 || arrayList2.size() > 0) {
            sb2.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList.get(i10));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    if (i11 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList2.get(i11));
                }
            }
            sb2.append(")");
        }
        return sb2.toString();
    }

    public void pause(View view) {
        if (this.C) {
            return;
        }
        ArrayList<Animator> arrayList = this.f4409y;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f4410z);
        this.f4410z = I;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animator = animatorArr[i10];
            animatorArr[i10] = null;
            animator.pause();
        }
        this.f4410z = animatorArr;
        k(this, f.f4421e);
        this.B = true;
    }

    public e removeListener(InterfaceC0045e interfaceC0045e) {
        e eVar;
        ArrayList<InterfaceC0045e> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(interfaceC0045e) && (eVar = this.D) != null) {
            eVar.removeListener(interfaceC0045e);
        }
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    public e removeTarget(View view) {
        this.f4401q.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.B) {
            if (!this.C) {
                ArrayList<Animator> arrayList = this.f4409y;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f4410z);
                this.f4410z = I;
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    Animator animator = animatorArr[size];
                    animatorArr[size] = null;
                    animator.resume();
                }
                this.f4410z = animatorArr;
                k(this, f.f4422f);
            }
            this.B = false;
        }
    }

    public void runAnimators() {
        start();
        b0.b<Animator, c> bVarH = h();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (bVarH.containsKey(next)) {
                start();
                if (next != null) {
                    next.addListener(new q2.e(this, bVarH));
                    animate(next);
                }
            }
        }
        this.F.clear();
        end();
    }

    public e setDuration(long j10) {
        this.f4398n = j10;
        return this;
    }

    public void setEpicenterCallback(d dVar) {
        this.G = dVar;
    }

    public e setInterpolator(TimeInterpolator timeInterpolator) {
        this.f4399o = timeInterpolator;
        return this;
    }

    public void setPathMotion(q2.d dVar) {
        if (dVar == null) {
            this.H = K;
        } else {
            this.H = dVar;
        }
    }

    public e setStartDelay(long j10) {
        this.f4397m = j10;
        return this;
    }

    public void start() {
        if (this.A == 0) {
            k(this, f.f4418a);
            this.C = false;
        }
        this.A++;
    }

    public String toString() {
        return l("");
    }

    @Override // 
    /* renamed from: clone */
    public e mo10clone() {
        try {
            e eVar = (e) super.clone();
            eVar.F = new ArrayList<>();
            eVar.f4402r = new f0(1);
            eVar.f4403s = new f0(1);
            eVar.f4406v = null;
            eVar.f4407w = null;
            eVar.D = this;
            eVar.E = null;
            return eVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void c(q2.i iVar) {
    }

    public void setPropagation(q2.g gVar) {
    }
}
