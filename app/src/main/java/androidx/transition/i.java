package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.e;
import java.util.HashMap;
import q2.j;
import q2.k;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class i extends e {
    public static final String[] N = {"android:visibility:visibility", "android:visibility:parent"};
    public int M = 3;

    /* compiled from: Visibility.java */
    public static class a extends AnimatorListenerAdapter implements e.InterfaceC0045e {

        /* renamed from: b, reason: collision with root package name */
        public final View f4432b;

        /* renamed from: m, reason: collision with root package name */
        public final int f4433m;

        /* renamed from: n, reason: collision with root package name */
        public final ViewGroup f4434n;

        /* renamed from: p, reason: collision with root package name */
        public boolean f4436p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f4437q = false;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f4435o = true;

        public a(View view, int i10) {
            this.f4432b = view;
            this.f4433m = i10;
            this.f4434n = (ViewGroup) view.getParent();
            a(true);
        }

        public final void a(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f4435o || this.f4436p == z10 || (viewGroup = this.f4434n) == null) {
                return;
            }
            this.f4436p = z10;
            j.a(viewGroup, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4437q = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (!this.f4437q) {
                k.b(this.f4432b, this.f4433m);
                ViewGroup viewGroup = this.f4434n;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionEnd(e eVar, boolean z10) {
            q2.f.a(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionPause(e eVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            a(false);
            if (this.f4437q) {
                return;
            }
            k.b(this.f4432b, this.f4433m);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionResume(e eVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            a(true);
            if (this.f4437q) {
                return;
            }
            k.b(this.f4432b, 0);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(e eVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z10) {
                k.b(this.f4432b, 0);
                ViewGroup viewGroup = this.f4434n;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(e eVar) {
            eVar.removeListener(this);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionStart(e eVar, boolean z10) {
            q2.f.b(this, eVar, z10);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (z10) {
                return;
            }
            if (!this.f4437q) {
                k.b(this.f4432b, this.f4433m);
                ViewGroup viewGroup = this.f4434n;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionCancel(e eVar) {
        }
    }

    /* compiled from: Visibility.java */
    public class b extends AnimatorListenerAdapter implements e.InterfaceC0045e {

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f4438b;

        /* renamed from: m, reason: collision with root package name */
        public final View f4439m;

        /* renamed from: n, reason: collision with root package name */
        public final View f4440n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f4441o = true;

        public b(ViewGroup viewGroup, View view, View view2) {
            this.f4438b = viewGroup;
            this.f4439m = view;
            this.f4440n = view2;
        }

        public final void a() {
            this.f4440n.setTag(R.id.save_overlay_view, null);
            this.f4438b.getOverlay().remove(this.f4439m);
            this.f4441o = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f4438b.getOverlay().remove(this.f4439m);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            View view = this.f4439m;
            if (view.getParent() == null) {
                this.f4438b.getOverlay().add(view);
            } else {
                i.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                View view = this.f4440n;
                int i10 = R.id.save_overlay_view;
                View view2 = this.f4439m;
                view.setTag(i10, view2);
                this.f4438b.getOverlay().add(view2);
                this.f4441o = true;
            }
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionCancel(e eVar) {
            if (this.f4441o) {
                a();
            }
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionEnd(e eVar, boolean z10) {
            q2.f.a(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(e eVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            a();
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(e eVar) {
            eVar.removeListener(this);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public final /* synthetic */ void onTransitionStart(e eVar, boolean z10) {
            q2.f.b(this, eVar, z10);
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionPause(e eVar) {
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionResume(e eVar) {
        }
    }

    /* compiled from: Visibility.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4443a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4444b;

        /* renamed from: c, reason: collision with root package name */
        public int f4445c;

        /* renamed from: d, reason: collision with root package name */
        public int f4446d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f4447e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f4448f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.transition.i.c n(q2.i r8, q2.i r9) {
        /*
            androidx.transition.i$c r0 = new androidx.transition.i$c
            r0.<init>()
            r1 = 0
            r0.f4443a = r1
            r0.f4444b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f17785a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f4445c = r7
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f4447e = r6
            goto L33
        L2f:
            r0.f4445c = r4
            r0.f4447e = r3
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f17785a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r3 = r6.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f4446d = r3
            java.lang.Object r2 = r6.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f4448f = r2
            goto L56
        L52:
            r0.f4446d = r4
            r0.f4448f = r3
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f4445c
            int r9 = r0.f4446d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f4447e
            android.view.ViewGroup r4 = r0.f4448f
            if (r3 != r4) goto L68
            return r0
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f4444b = r1
            r0.f4443a = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.f4444b = r2
            r0.f4443a = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.f4448f
            if (r8 != 0) goto L81
            r0.f4444b = r1
            r0.f4443a = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.f4447e
            if (r8 != 0) goto L9f
            r0.f4444b = r2
            r0.f4443a = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f4446d
            if (r8 != 0) goto L95
            r0.f4444b = r2
            r0.f4443a = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f4445c
            if (r8 != 0) goto L9f
            r0.f4444b = r1
            r0.f4443a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.i.n(q2.i, q2.i):androidx.transition.i$c");
    }

    @Override // androidx.transition.e
    public void captureEndValues(q2.i iVar) {
        m(iVar);
    }

    @Override // androidx.transition.e
    public void captureStartValues(q2.i iVar) {
        m(iVar);
    }

    @Override // androidx.transition.e
    public Animator createAnimator(ViewGroup viewGroup, q2.i iVar, q2.i iVar2) {
        c cVarN = n(iVar, iVar2);
        if (!cVarN.f4443a) {
            return null;
        }
        if (cVarN.f4447e == null && cVarN.f4448f == null) {
            return null;
        }
        return cVarN.f4444b ? onAppear(viewGroup, iVar, cVarN.f4445c, iVar2, cVarN.f4446d) : onDisappear(viewGroup, iVar, cVarN.f4445c, iVar2, cVarN.f4446d);
    }

    @Override // androidx.transition.e
    public String[] getTransitionProperties() {
        return N;
    }

    @Override // androidx.transition.e
    public boolean isTransitionRequired(q2.i iVar, q2.i iVar2) {
        if (iVar == null && iVar2 == null) {
            return false;
        }
        if (iVar != null && iVar2 != null && iVar2.f17785a.containsKey("android:visibility:visibility") != iVar.f17785a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarN = n(iVar, iVar2);
        if (cVarN.f4443a) {
            return cVarN.f4445c == 0 || cVarN.f4446d == 0;
        }
        return false;
    }

    public final void m(q2.i iVar) {
        int visibility = iVar.f17786b.getVisibility();
        HashMap map = iVar.f17785a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = iVar.f17786b;
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public abstract Animator onAppear(ViewGroup viewGroup, View view, q2.i iVar, q2.i iVar2);

    public Animator onAppear(ViewGroup viewGroup, q2.i iVar, int i10, q2.i iVar2, int i11) {
        if ((this.M & 1) != 1 || iVar2 == null) {
            return null;
        }
        View view = iVar2.f17786b;
        if (iVar == null) {
            View view2 = (View) view.getParent();
            if (n(g(view2, false), getTransitionValues(view2, false)).f4443a) {
                return null;
            }
        }
        return onAppear(viewGroup, view, iVar, iVar2);
    }

    public abstract Animator onDisappear(ViewGroup viewGroup, View view, q2.i iVar, q2.i iVar2);

    /* JADX WARN: Removed duplicated region for block: B:57:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator onDisappear(android.view.ViewGroup r21, q2.i r22, int r23, q2.i r24, int r25) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.i.onDisappear(android.view.ViewGroup, q2.i, int, q2.i, int):android.animation.Animator");
    }

    public void setMode(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.M = i10;
    }
}
