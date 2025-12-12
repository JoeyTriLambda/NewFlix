package x0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import x0.y0;

/* compiled from: WindowInsetsAnimationCompat.java */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final e f21307a;

    /* compiled from: WindowInsetsAnimationCompat.java */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public WindowInsets f21310a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21311b;

        public b(int i10) {
            this.f21311b = i10;
        }

        public final int getDispatchMode() {
            return this.f21311b;
        }

        public abstract void onEnd(x0 x0Var);

        public abstract void onPrepare(x0 x0Var);

        public abstract y0 onProgress(y0 y0Var, List<x0> list);

        public abstract a onStart(x0 x0Var, a aVar);
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    public static class c extends e {

        /* renamed from: e, reason: collision with root package name */
        public static final PathInterpolator f21312e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* renamed from: f, reason: collision with root package name */
        public static final p1.a f21313f = new p1.a();

        /* renamed from: g, reason: collision with root package name */
        public static final DecelerateInterpolator f21314g = new DecelerateInterpolator();

        /* compiled from: WindowInsetsAnimationCompat.java */
        public static class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public final b f21315a;

            /* renamed from: b, reason: collision with root package name */
            public y0 f21316b;

            /* compiled from: WindowInsetsAnimationCompat.java */
            /* renamed from: x0.x0$c$a$a, reason: collision with other inner class name */
            public class C0312a implements ValueAnimator.AnimatorUpdateListener {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ x0 f21317b;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ y0 f21318m;

                /* renamed from: n, reason: collision with root package name */
                public final /* synthetic */ y0 f21319n;

                /* renamed from: o, reason: collision with root package name */
                public final /* synthetic */ int f21320o;

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ View f21321p;

                public C0312a(x0 x0Var, y0 y0Var, y0 y0Var2, int i10, View view) {
                    this.f21317b = x0Var;
                    this.f21318m = y0Var;
                    this.f21319n = y0Var2;
                    this.f21320o = i10;
                    this.f21321p = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    x0 x0Var = this.f21317b;
                    x0Var.setFraction(animatedFraction);
                    float interpolatedFraction = x0Var.getInterpolatedFraction();
                    PathInterpolator pathInterpolator = c.f21312e;
                    y0 y0Var = this.f21318m;
                    y0.b bVar = new y0.b(y0Var);
                    for (int i10 = 1; i10 <= 256; i10 <<= 1) {
                        if ((this.f21320o & i10) == 0) {
                            bVar.setInsets(i10, y0Var.getInsets(i10));
                        } else {
                            o0.b insets = y0Var.getInsets(i10);
                            o0.b insets2 = this.f21319n.getInsets(i10);
                            float f10 = 1.0f - interpolatedFraction;
                            bVar.setInsets(i10, y0.a(insets, (int) (((insets.f16884a - insets2.f16884a) * f10) + 0.5d), (int) (((insets.f16885b - insets2.f16885b) * f10) + 0.5d), (int) (((insets.f16886c - insets2.f16886c) * f10) + 0.5d), (int) (((insets.f16887d - insets2.f16887d) * f10) + 0.5d)));
                        }
                    }
                    c.c(this.f21321p, bVar.build(), Collections.singletonList(x0Var));
                }
            }

            /* compiled from: WindowInsetsAnimationCompat.java */
            public class b extends AnimatorListenerAdapter {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ x0 f21322b;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ View f21323m;

                public b(x0 x0Var, View view) {
                    this.f21322b = x0Var;
                    this.f21323m = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    x0 x0Var = this.f21322b;
                    x0Var.setFraction(1.0f);
                    c.a(this.f21323m, x0Var);
                }
            }

            /* compiled from: WindowInsetsAnimationCompat.java */
            /* renamed from: x0.x0$c$a$c, reason: collision with other inner class name */
            public class RunnableC0313c implements Runnable {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ View f21324b;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ x0 f21325m;

                /* renamed from: n, reason: collision with root package name */
                public final /* synthetic */ a f21326n;

                /* renamed from: o, reason: collision with root package name */
                public final /* synthetic */ ValueAnimator f21327o;

                public RunnableC0313c(View view, x0 x0Var, a aVar, ValueAnimator valueAnimator) {
                    this.f21324b = view;
                    this.f21325m = x0Var;
                    this.f21326n = aVar;
                    this.f21327o = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.d(this.f21324b, this.f21325m, this.f21326n);
                    this.f21327o.start();
                }
            }

            public a(View view, b bVar) {
                this.f21315a = bVar;
                y0 rootWindowInsets = j0.getRootWindowInsets(view);
                this.f21316b = rootWindowInsets != null ? new y0.b(rootWindowInsets).build() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f21316b = y0.toWindowInsetsCompat(windowInsets, view);
                    return c.e(view, windowInsets);
                }
                y0 windowInsetsCompat = y0.toWindowInsetsCompat(windowInsets, view);
                if (this.f21316b == null) {
                    this.f21316b = j0.getRootWindowInsets(view);
                }
                if (this.f21316b == null) {
                    this.f21316b = windowInsetsCompat;
                    return c.e(view, windowInsets);
                }
                b bVarF = c.f(view);
                if (bVarF != null && Objects.equals(bVarF.f21310a, windowInsets)) {
                    return c.e(view, windowInsets);
                }
                y0 y0Var = this.f21316b;
                int i10 = 0;
                for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                    if (!windowInsetsCompat.getInsets(i11).equals(y0Var.getInsets(i11))) {
                        i10 |= i11;
                    }
                }
                if (i10 == 0) {
                    return c.e(view, windowInsets);
                }
                y0 y0Var2 = this.f21316b;
                x0 x0Var = new x0(i10, (i10 & 8) != 0 ? windowInsetsCompat.getInsets(y0.m.ime()).f16887d > y0Var2.getInsets(y0.m.ime()).f16887d ? c.f21312e : c.f21313f : c.f21314g, 160L);
                x0Var.setFraction(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(x0Var.getDurationMillis());
                o0.b insets = windowInsetsCompat.getInsets(i10);
                o0.b insets2 = y0Var2.getInsets(i10);
                int iMin = Math.min(insets.f16884a, insets2.f16884a);
                int i12 = insets.f16885b;
                int i13 = insets2.f16885b;
                int iMin2 = Math.min(i12, i13);
                int i14 = insets.f16886c;
                int i15 = insets2.f16886c;
                int iMin3 = Math.min(i14, i15);
                int i16 = insets.f16887d;
                int i17 = i10;
                int i18 = insets2.f16887d;
                a aVar = new a(o0.b.of(iMin, iMin2, iMin3, Math.min(i16, i18)), o0.b.of(Math.max(insets.f16884a, insets2.f16884a), Math.max(i12, i13), Math.max(i14, i15), Math.max(i16, i18)));
                c.b(view, x0Var, windowInsets, false);
                duration.addUpdateListener(new C0312a(x0Var, windowInsetsCompat, y0Var2, i17, view));
                duration.addListener(new b(x0Var, view));
                y.add(view, new RunnableC0313c(view, x0Var, aVar, duration));
                this.f21316b = windowInsetsCompat;
                return c.e(view, windowInsets);
            }
        }

        public c(int i10, Interpolator interpolator, long j10) {
            super(i10, interpolator, j10);
        }

        public static void a(View view, x0 x0Var) {
            b bVarF = f(view);
            if (bVarF != null) {
                bVarF.onEnd(x0Var);
                if (bVarF.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    a(viewGroup.getChildAt(i10), x0Var);
                }
            }
        }

        public static void b(View view, x0 x0Var, WindowInsets windowInsets, boolean z10) {
            b bVarF = f(view);
            if (bVarF != null) {
                bVarF.f21310a = windowInsets;
                if (!z10) {
                    bVarF.onPrepare(x0Var);
                    z10 = bVarF.getDispatchMode() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    b(viewGroup.getChildAt(i10), x0Var, windowInsets, z10);
                }
            }
        }

        public static void c(View view, y0 y0Var, List<x0> list) {
            b bVarF = f(view);
            if (bVarF != null) {
                y0Var = bVarF.onProgress(y0Var, list);
                if (bVarF.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    c(viewGroup.getChildAt(i10), y0Var, list);
                }
            }
        }

        public static void d(View view, x0 x0Var, a aVar) {
            b bVarF = f(view);
            if (bVarF != null) {
                bVarF.onStart(x0Var, aVar);
                if (bVarF.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    d(viewGroup.getChildAt(i10), x0Var, aVar);
                }
            }
        }

        public static WindowInsets e(View view, WindowInsets windowInsets) {
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        public static b f(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).f21315a;
            }
            return null;
        }
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f21333a;

        /* renamed from: b, reason: collision with root package name */
        public float f21334b;

        /* renamed from: c, reason: collision with root package name */
        public final Interpolator f21335c;

        /* renamed from: d, reason: collision with root package name */
        public final long f21336d;

        public e(int i10, Interpolator interpolator, long j10) {
            this.f21333a = i10;
            this.f21335c = interpolator;
            this.f21336d = j10;
        }

        public long getDurationMillis() {
            return this.f21336d;
        }

        public float getInterpolatedFraction() {
            Interpolator interpolator = this.f21335c;
            return interpolator != null ? interpolator.getInterpolation(this.f21334b) : this.f21334b;
        }

        public int getTypeMask() {
            return this.f21333a;
        }

        public void setFraction(float f10) {
            this.f21334b = f10;
        }
    }

    public x0(int i10, Interpolator interpolator, long j10) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f21307a = new d(i10, interpolator, j10);
        } else {
            this.f21307a = new c(i10, interpolator, j10);
        }
    }

    public long getDurationMillis() {
        return this.f21307a.getDurationMillis();
    }

    public float getInterpolatedFraction() {
        return this.f21307a.getInterpolatedFraction();
    }

    public int getTypeMask() {
        return this.f21307a.getTypeMask();
    }

    public void setFraction(float f10) {
        this.f21307a.setFraction(f10);
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    public static class d extends e {

        /* renamed from: e, reason: collision with root package name */
        public final WindowInsetsAnimation f21328e;

        /* compiled from: WindowInsetsAnimationCompat.java */
        public static class a extends WindowInsetsAnimation.Callback {

            /* renamed from: a, reason: collision with root package name */
            public final b f21329a;

            /* renamed from: b, reason: collision with root package name */
            public List<x0> f21330b;

            /* renamed from: c, reason: collision with root package name */
            public ArrayList<x0> f21331c;

            /* renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, x0> f21332d;

            public a(b bVar) {
                super(bVar.getDispatchMode());
                this.f21332d = new HashMap<>();
                this.f21329a = bVar;
            }

            public final x0 a(WindowInsetsAnimation windowInsetsAnimation) {
                x0 x0Var = this.f21332d.get(windowInsetsAnimation);
                if (x0Var != null) {
                    return x0Var;
                }
                x0 x0Var2 = new x0(windowInsetsAnimation);
                this.f21332d.put(windowInsetsAnimation, x0Var2);
                return x0Var2;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f21329a.onEnd(a(windowInsetsAnimation));
                this.f21332d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f21329a.onPrepare(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<x0> arrayList = this.f21331c;
                if (arrayList == null) {
                    ArrayList<x0> arrayList2 = new ArrayList<>(list.size());
                    this.f21331c = arrayList2;
                    this.f21330b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    x0 x0VarA = a(windowInsetsAnimation);
                    x0VarA.setFraction(windowInsetsAnimation.getFraction());
                    this.f21331c.add(x0VarA);
                }
                return this.f21329a.onProgress(y0.toWindowInsetsCompat(windowInsets), this.f21330b).toWindowInsets();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f21329a.onStart(a(windowInsetsAnimation), a.toBoundsCompat(bounds)).toBounds();
            }
        }

        public d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f21328e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds createPlatformBounds(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.getLowerBound().toPlatformInsets(), aVar.getUpperBound().toPlatformInsets());
        }

        public static o0.b getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
            return o0.b.toCompatInsets(bounds.getUpperBound());
        }

        public static o0.b getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
            return o0.b.toCompatInsets(bounds.getLowerBound());
        }

        public static void setCallback(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // x0.x0.e
        public long getDurationMillis() {
            return this.f21328e.getDurationMillis();
        }

        @Override // x0.x0.e
        public float getInterpolatedFraction() {
            return this.f21328e.getInterpolatedFraction();
        }

        @Override // x0.x0.e
        public int getTypeMask() {
            return this.f21328e.getTypeMask();
        }

        @Override // x0.x0.e
        public void setFraction(float f10) {
            this.f21328e.setFraction(f10);
        }

        public d(int i10, Interpolator interpolator, long j10) {
            this(new WindowInsetsAnimation(i10, interpolator, j10));
        }
    }

    /* compiled from: WindowInsetsAnimationCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final o0.b f21308a;

        /* renamed from: b, reason: collision with root package name */
        public final o0.b f21309b;

        public a(o0.b bVar, o0.b bVar2) {
            this.f21308a = bVar;
            this.f21309b = bVar2;
        }

        public static a toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public o0.b getLowerBound() {
            return this.f21308a;
        }

        public o0.b getUpperBound() {
            return this.f21309b;
        }

        public WindowInsetsAnimation.Bounds toBounds() {
            return d.createPlatformBounds(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f21308a + " upper=" + this.f21309b + "}";
        }

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.f21308a = d.getLowerBounds(bounds);
            this.f21309b = d.getHigherBounds(bounds);
        }
    }

    public x0(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f21307a = new d(windowInsetsAnimation);
        }
    }
}
