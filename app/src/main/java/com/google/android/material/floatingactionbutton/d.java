package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import i7.n;
import java.util.ArrayList;
import java.util.Iterator;
import q7.l;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public l f9144a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9145b;

    /* renamed from: d, reason: collision with root package name */
    public float f9147d;

    /* renamed from: e, reason: collision with root package name */
    public float f9148e;

    /* renamed from: f, reason: collision with root package name */
    public float f9149f;

    /* renamed from: g, reason: collision with root package name */
    public Animator f9150g;

    /* renamed from: h, reason: collision with root package name */
    public p6.h f9151h;

    /* renamed from: i, reason: collision with root package name */
    public p6.h f9152i;

    /* renamed from: j, reason: collision with root package name */
    public float f9153j;

    /* renamed from: l, reason: collision with root package name */
    public int f9155l;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f9157n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f9158o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<e> f9159p;

    /* renamed from: q, reason: collision with root package name */
    public final FloatingActionButton f9160q;

    /* renamed from: r, reason: collision with root package name */
    public final p7.b f9161r;

    /* renamed from: w, reason: collision with root package name */
    public h7.c f9166w;

    /* renamed from: x, reason: collision with root package name */
    public static final p1.a f9141x = p6.a.f17606c;

    /* renamed from: y, reason: collision with root package name */
    public static final int f9142y = R.attr.motionDurationLong2;

    /* renamed from: z, reason: collision with root package name */
    public static final int f9143z = R.attr.motionEasingEmphasizedInterpolator;
    public static final int A = R.attr.motionDurationMedium1;
    public static final int B = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] C = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static final int[] D = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] E = {android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] F = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    public static final int[] G = {android.R.attr.state_enabled};
    public static final int[] H = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public boolean f9146c = true;

    /* renamed from: k, reason: collision with root package name */
    public float f9154k = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    public int f9156m = 0;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f9162s = new Rect();

    /* renamed from: t, reason: collision with root package name */
    public final RectF f9163t = new RectF();

    /* renamed from: u, reason: collision with root package name */
    public final RectF f9164u = new RectF();

    /* renamed from: v, reason: collision with root package name */
    public final Matrix f9165v = new Matrix();

    /* compiled from: FloatingActionButtonImpl.java */
    public class a extends p6.g {
        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            d.this.f9154k = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class b extends h {
        public b(h7.d dVar) {
            super(dVar);
        }

        @Override // com.google.android.material.floatingactionbutton.d.h
        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class c extends h {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ d f9168n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h7.d dVar) {
            super(dVar);
            this.f9168n = dVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.h
        public float getTargetShadowSize() {
            d dVar = this.f9168n;
            return dVar.f9147d + dVar.f9148e;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    public class C0087d extends h {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ d f9169n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0087d(h7.d dVar) {
            super(dVar);
            this.f9169n = dVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.h
        public float getTargetShadowSize() {
            d dVar = this.f9169n;
            return dVar.f9147d + dVar.f9149f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public interface e {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public interface f {
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class g extends h {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ d f9170n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h7.d dVar) {
            super(dVar);
            this.f9170n = dVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.h
        public float getTargetShadowSize() {
            return this.f9170n.f9147d;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public boolean f9171b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ d f9172m;

        public h(h7.d dVar) {
            this.f9172m = dVar;
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9172m.getClass();
            this.f9171b = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z10 = this.f9171b;
            d dVar = this.f9172m;
            if (!z10) {
                dVar.getClass();
                getTargetShadowSize();
                this.f9171b = true;
            }
            valueAnimator.getAnimatedFraction();
            dVar.getClass();
        }
    }

    public d(FloatingActionButton floatingActionButton, FloatingActionButton.b bVar) {
        this.f9160q = floatingActionButton;
        this.f9161r = bVar;
        n nVar = new n();
        h7.d dVar = (h7.d) this;
        nVar.addState(C, d(new C0087d(dVar)));
        nVar.addState(D, d(new c(dVar)));
        nVar.addState(E, d(new c(dVar)));
        nVar.addState(F, d(new c(dVar)));
        nVar.addState(G, d(new g(dVar)));
        nVar.addState(H, d(new b(dVar)));
        this.f9153j = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f9141x);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f10, Matrix matrix) {
        matrix.reset();
        if (this.f9160q.getDrawable() == null || this.f9155l == 0) {
            return;
        }
        RectF rectF = this.f9163t;
        RectF rectF2 = this.f9164u;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i10 = this.f9155l;
        rectF2.set(0.0f, 0.0f, i10, i10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i11 = this.f9155l;
        matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.f9158o == null) {
            this.f9158o = new ArrayList<>();
        }
        this.f9158o.add(animatorListener);
    }

    public final AnimatorSet b(p6.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f10};
        FloatingActionButton floatingActionButton = this.f9160q;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        hVar.getTiming("opacity").apply(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        hVar.getTiming("scale").apply(objectAnimatorOfFloat2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26) {
            objectAnimatorOfFloat2.setEvaluator(new h7.b());
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        hVar.getTiming("scale").apply(objectAnimatorOfFloat3);
        if (i10 == 26) {
            objectAnimatorOfFloat3.setEvaluator(new h7.b());
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.f9165v;
        a(f12, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new p6.f(), new a(), new Matrix(matrix));
        hVar.getTiming("iconScale").apply(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        p6.b.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(int i10, float f10, float f11, int i11, float f12) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.f9160q;
        valueAnimatorOfFloat.addUpdateListener(new h7.a(this, floatingActionButton.getAlpha(), f10, floatingActionButton.getScaleX(), f11, floatingActionButton.getScaleY(), this.f9154k, f12, new Matrix(this.f9165v)));
        arrayList.add(valueAnimatorOfFloat);
        p6.b.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(k7.g.resolveThemeDuration(floatingActionButton.getContext(), i10, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(k7.g.resolveThemeInterpolator(floatingActionButton.getContext(), i11, p6.a.f17605b));
        return animatorSet;
    }

    public void e(Rect rect) {
        int iMax = this.f9145b ? Math.max((0 - this.f9160q.getSizeDimension()) / 2, 0) : 0;
        int iMax2 = Math.max(iMax, (int) Math.ceil(this.f9146c ? getElevation() + this.f9149f : 0.0f));
        int iMax3 = Math.max(iMax, (int) Math.ceil(r0 * 1.5f));
        rect.set(iMax2, iMax3, iMax2, iMax3);
    }

    public void f() {
        throw null;
    }

    public void g() {
        throw null;
    }

    public float getElevation() {
        throw null;
    }

    public void h(int[] iArr) {
        throw null;
    }

    public void i(float f10, float f11, float f12) {
        throw null;
    }

    public final void j() {
        ArrayList<e> arrayList = this.f9159p;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTranslationChanged();
            }
        }
    }

    public void k() {
        throw null;
    }

    public boolean l() {
        throw null;
    }

    public void m() {
        throw null;
    }

    public final void n() {
        Rect rect = this.f9162s;
        e(rect);
        w0.h.checkNotNull(null, "Didn't initialize content background");
        boolean zL = l();
        p7.b bVar = this.f9161r;
        if (zL) {
            ((FloatingActionButton.b) bVar).setBackgroundDrawable(new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            ((FloatingActionButton.b) bVar).setBackgroundDrawable(null);
        }
        ((FloatingActionButton.b) bVar).setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
