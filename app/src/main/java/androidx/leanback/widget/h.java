package androidx.leanback.widget;

import android.animation.TimeAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.leanback.R;

/* compiled from: FocusHighlightHelper.java */
/* loaded from: classes.dex */
public final class h {

    /* compiled from: FocusHighlightHelper.java */
    public static class a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final int f3217a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3218b;

        public a(int i10, boolean z10) {
            boolean z11 = true;
            if (i10 != 0) {
                if ((i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? 0 : R.fraction.lb_focus_zoom_factor_xsmall : R.fraction.lb_focus_zoom_factor_large : R.fraction.lb_focus_zoom_factor_medium : R.fraction.lb_focus_zoom_factor_small) <= 0) {
                    z11 = false;
                }
            }
            if (!z11) {
                throw new IllegalArgumentException("Unhandled zoom index");
            }
            this.f3217a = i10;
            this.f3218b = z10;
        }

        public final b a(View view) {
            float fraction;
            int i10 = R.id.lb_focus_animator;
            b bVar = (b) view.getTag(i10);
            if (bVar == null) {
                Resources resources = view.getResources();
                int i11 = this.f3217a;
                if (i11 == 0) {
                    fraction = 1.0f;
                } else {
                    fraction = resources.getFraction(i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? 0 : R.fraction.lb_focus_zoom_factor_xsmall : R.fraction.lb_focus_zoom_factor_large : R.fraction.lb_focus_zoom_factor_medium : R.fraction.lb_focus_zoom_factor_small, 1, 1);
                }
                bVar = new b(view, fraction, this.f3218b);
                view.setTag(i10, bVar);
            }
            return bVar;
        }

        public void onInitializeView(View view) {
            a(view).a(false, true);
        }

        public void onItemFocused(View view, boolean z10) {
            view.setSelected(z10);
            a(view).a(z10, false);
        }
    }

    /* compiled from: FocusHighlightHelper.java */
    public static class b implements TimeAnimator.TimeListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f3219a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3220b;

        /* renamed from: c, reason: collision with root package name */
        public final q0 f3221c;

        /* renamed from: d, reason: collision with root package name */
        public final float f3222d;

        /* renamed from: e, reason: collision with root package name */
        public float f3223e = 0.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f3224f;

        /* renamed from: g, reason: collision with root package name */
        public float f3225g;

        /* renamed from: h, reason: collision with root package name */
        public final TimeAnimator f3226h;

        /* renamed from: i, reason: collision with root package name */
        public final AccelerateDecelerateInterpolator f3227i;

        /* renamed from: j, reason: collision with root package name */
        public final q1.a f3228j;

        public b(View view, float f10, boolean z10) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.f3226h = timeAnimator;
            this.f3227i = new AccelerateDecelerateInterpolator();
            this.f3219a = view;
            this.f3220b = 150;
            this.f3222d = f10 - 1.0f;
            if (view instanceof q0) {
                this.f3221c = (q0) view;
            } else {
                this.f3221c = null;
            }
            timeAnimator.setTimeListener(this);
            if (z10) {
                this.f3228j = q1.a.createDefault(view.getContext());
            } else {
                this.f3228j = null;
            }
        }

        public final void a(boolean z10, boolean z11) {
            TimeAnimator timeAnimator = this.f3226h;
            timeAnimator.end();
            float f10 = z10 ? 1.0f : 0.0f;
            if (z11) {
                b(f10);
                return;
            }
            float f11 = this.f3223e;
            if (f11 != f10) {
                this.f3224f = f11;
                this.f3225g = f10 - f11;
                timeAnimator.start();
            }
        }

        public final void b(float f10) {
            this.f3223e = f10;
            float f11 = (this.f3222d * f10) + 1.0f;
            View view = this.f3219a;
            view.setScaleX(f11);
            view.setScaleY(f11);
            q0 q0Var = this.f3221c;
            if (q0Var != null) {
                q0Var.setShadowFocusLevel(f10);
            } else {
                r0.setNoneWrapperShadowFocusLevel(view, f10);
            }
            q1.a aVar = this.f3228j;
            if (aVar != null) {
                aVar.setActiveLevel(f10);
                int color = aVar.getPaint().getColor();
                if (q0Var != null) {
                    q0Var.setOverlayColor(color);
                } else {
                    r0.setNoneWrapperOverlayColor(view, color);
                }
            }
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j10, long j11) {
            float interpolation;
            int i10 = this.f3220b;
            if (j10 >= i10) {
                this.f3226h.end();
                interpolation = 1.0f;
            } else {
                interpolation = (float) (j10 / i10);
            }
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = this.f3227i;
            if (accelerateDecelerateInterpolator != null) {
                interpolation = accelerateDecelerateInterpolator.getInterpolation(interpolation);
            }
            b((interpolation * this.f3225g) + this.f3224f);
        }
    }

    public static void setupBrowseItemFocusHighlight(s sVar, int i10, boolean z10) {
        sVar.f3358g = new a(i10, z10);
    }
}
