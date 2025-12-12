package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import q2.j;
import q2.k;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public final class a extends androidx.transition.e {
    public static final String[] M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final C0043a N = new C0043a();
    public static final b O = new b();
    public static final c P = new c();
    public static final d Q = new d();
    public static final e R = new e();

    /* compiled from: ChangeBounds.java */
    /* renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    public class C0043a extends Property<h, PointF> {
        public C0043a() {
            super(PointF.class, "topLeft");
        }

        @Override // android.util.Property
        public PointF get(h hVar) {
            return null;
        }

        @Override // android.util.Property
        public void set(h hVar, PointF pointF) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            hVar.getClass();
            hVar.f4377a = Math.round(pointF.x);
            int iRound = Math.round(pointF.y);
            hVar.f4378b = iRound;
            int i10 = hVar.f4382f + 1;
            hVar.f4382f = i10;
            if (i10 == hVar.f4383g) {
                k.a(hVar.f4381e, hVar.f4377a, iRound, hVar.f4379c, hVar.f4380d);
                hVar.f4382f = 0;
                hVar.f4383g = 0;
            }
        }
    }

    /* compiled from: ChangeBounds.java */
    public class b extends Property<h, PointF> {
        public b() {
            super(PointF.class, "bottomRight");
        }

        @Override // android.util.Property
        public PointF get(h hVar) {
            return null;
        }

        @Override // android.util.Property
        public void set(h hVar, PointF pointF) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            hVar.getClass();
            hVar.f4379c = Math.round(pointF.x);
            int iRound = Math.round(pointF.y);
            hVar.f4380d = iRound;
            int i10 = hVar.f4383g + 1;
            hVar.f4383g = i10;
            if (hVar.f4382f == i10) {
                k.a(hVar.f4381e, hVar.f4377a, hVar.f4378b, hVar.f4379c, iRound);
                hVar.f4382f = 0;
                hVar.f4383g = 0;
            }
        }
    }

    /* compiled from: ChangeBounds.java */
    public class c extends Property<View, PointF> {
        public c() {
            super(PointF.class, "bottomRight");
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            k.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    public class d extends Property<View, PointF> {
        public d() {
            super(PointF.class, "topLeft");
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            k.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    public class e extends Property<View, PointF> {
        public e() {
            super(PointF.class, "position");
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            k.a(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* compiled from: ChangeBounds.java */
    public class f extends AnimatorListenerAdapter {
        private final h mViewBounds;

        public f(h hVar) {
            this.mViewBounds = hVar;
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class g extends androidx.transition.f {

        /* renamed from: b, reason: collision with root package name */
        public boolean f4375b = false;

        /* renamed from: m, reason: collision with root package name */
        public final ViewGroup f4376m;

        public g(ViewGroup viewGroup) {
            this.f4376m = viewGroup;
        }

        @Override // androidx.transition.f, androidx.transition.e.InterfaceC0045e
        public void onTransitionCancel(androidx.transition.e eVar) {
            j.a(this.f4376m, false);
            this.f4375b = true;
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(androidx.transition.e eVar) {
            if (!this.f4375b) {
                j.a(this.f4376m, false);
            }
            eVar.removeListener(this);
        }

        @Override // androidx.transition.f, androidx.transition.e.InterfaceC0045e
        public void onTransitionPause(androidx.transition.e eVar) {
            j.a(this.f4376m, false);
        }

        @Override // androidx.transition.f, androidx.transition.e.InterfaceC0045e
        public void onTransitionResume(androidx.transition.e eVar) {
            j.a(this.f4376m, true);
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f4377a;

        /* renamed from: b, reason: collision with root package name */
        public int f4378b;

        /* renamed from: c, reason: collision with root package name */
        public int f4379c;

        /* renamed from: d, reason: collision with root package name */
        public int f4380d;

        /* renamed from: e, reason: collision with root package name */
        public final View f4381e;

        /* renamed from: f, reason: collision with root package name */
        public int f4382f;

        /* renamed from: g, reason: collision with root package name */
        public int f4383g;

        public h(View view) {
            this.f4381e = view;
        }
    }

    @Override // androidx.transition.e
    public void captureEndValues(q2.i iVar) {
        m(iVar);
    }

    @Override // androidx.transition.e
    public void captureStartValues(q2.i iVar) {
        m(iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.e
    public Animator createAnimator(ViewGroup viewGroup, q2.i iVar, q2.i iVar2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10;
        ObjectAnimator objectAnimatorA;
        if (iVar == null || iVar2 == null) {
            return null;
        }
        HashMap map = iVar.f17785a;
        HashMap map2 = iVar2.f17785a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i11 = rect.left;
        int i12 = rect2.left;
        int i13 = rect.top;
        int i14 = rect2.top;
        int i15 = rect.right;
        int i16 = rect2.right;
        int i17 = rect.bottom;
        int i18 = rect2.bottom;
        int i19 = i15 - i11;
        int i20 = i17 - i13;
        int i21 = i16 - i12;
        int i22 = i18 - i14;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i19 == 0 || i20 == 0) && (i21 == 0 || i22 == 0)) {
            i10 = 0;
        } else {
            i10 = (i11 == i12 && i13 == i14) ? 0 : 1;
            if (i15 != i16 || i17 != i18) {
                i10++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i10++;
        }
        int i23 = i10;
        if (i23 <= 0) {
            return null;
        }
        View view = iVar2.f17786b;
        k.a(view, i11, i13, i15, i17);
        if (i23 != 2) {
            objectAnimatorA = (i11 == i12 && i13 == i14) ? q2.c.a(view, P, getPathMotion().getPath(i15, i17, i16, i18)) : q2.c.a(view, Q, getPathMotion().getPath(i11, i13, i12, i14));
        } else if (i19 == i21 && i20 == i22) {
            objectAnimatorA = q2.c.a(view, R, getPathMotion().getPath(i11, i13, i12, i14));
        } else {
            h hVar = new h(view);
            ObjectAnimator objectAnimatorA2 = q2.c.a(hVar, N, getPathMotion().getPath(i11, i13, i12, i14));
            ObjectAnimator objectAnimatorA3 = q2.c.a(hVar, O, getPathMotion().getPath(i15, i17, i16, i18));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
            animatorSet.addListener(new f(hVar));
            objectAnimatorA = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            j.a(viewGroup4, true);
            getRootTransition().addListener(new g(viewGroup4));
        }
        return objectAnimatorA;
    }

    @Override // androidx.transition.e
    public String[] getTransitionProperties() {
        return M;
    }

    public final void m(q2.i iVar) {
        View view = iVar.f17786b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = iVar.f17785a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", iVar.f17786b.getParent());
    }
}
