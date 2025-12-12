package f4;

import android.animation.ArgbEvaluator;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import com.devpaul.materialfabmenu.R;
import x0.p;

/* compiled from: ShadowSelectorGenerator.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: q, reason: collision with root package name */
    public static final OvershootInterpolator f11495q = new OvershootInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public final View f11496a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11497b;

    /* renamed from: c, reason: collision with root package name */
    public int f11498c;

    /* renamed from: d, reason: collision with root package name */
    public int f11499d;

    /* renamed from: e, reason: collision with root package name */
    public int f11500e;

    /* renamed from: f, reason: collision with root package name */
    public int f11501f;

    /* renamed from: g, reason: collision with root package name */
    public int f11502g;

    /* renamed from: h, reason: collision with root package name */
    public final ArgbEvaluator f11503h;

    /* renamed from: i, reason: collision with root package name */
    public float f11504i;

    /* renamed from: j, reason: collision with root package name */
    public float f11505j;

    /* renamed from: k, reason: collision with root package name */
    public float f11506k;

    /* renamed from: l, reason: collision with root package name */
    public float f11507l;

    /* renamed from: m, reason: collision with root package name */
    public float f11508m;

    /* renamed from: n, reason: collision with root package name */
    public float f11509n;

    /* renamed from: o, reason: collision with root package name */
    public float f11510o;

    /* renamed from: p, reason: collision with root package name */
    public final AnimationSet f11511p;

    static {
        new AccelerateDecelerateInterpolator();
    }

    public g(View view, Paint paint) {
        a aVar = new a();
        this.f11496a = view;
        this.f11497b = paint;
        Resources resources = view.getResources();
        view.setLayerType(1, paint);
        AnimationSet animationSet = new AnimationSet(true);
        this.f11511p = animationSet;
        animationSet.setInterpolator(f11495q);
        this.f11503h = new ArgbEvaluator();
        float dimension = resources.getDimension(R.dimen.mat_fab_shadow_offset) * 1.5f;
        this.f11507l = dimension;
        this.f11506k = dimension / 1.5f;
        this.f11509n = resources.getDimension(R.dimen.mat_fab_shadow_max_radius);
        this.f11510o = resources.getDimension(R.dimen.mat_fab_shadow_min_radius) / 2.0f;
        this.f11498c = -16777216;
        this.f11499d = f4.a.getNewColorAlpha(-16777216, 0.1f);
        this.f11504i = 0.2f;
        float f10 = this.f11509n;
        float f11 = this.f11510o;
        this.f11505j = o1.a.a(f10, f11, 0.2173913f, f11);
        float f12 = this.f11507l;
        float f13 = this.f11506k;
        this.f11508m = o1.a.a(f12, f13, 0.2173913f, f13);
        this.f11499d = f4.a.getNewColorAlpha(this.f11498c, 0.4652174f);
        view.addOnAttachStateChangeListener(aVar);
    }

    public final void a(float f10) {
        if (f10 == 0.0f) {
            f10 += 0.0f;
        } else if (f10 > 0.92f) {
            f10 = 0.92f;
        }
        this.f11504i = f10;
        float f11 = f10 / 0.92f;
        float f12 = this.f11509n;
        float f13 = this.f11510o;
        this.f11505j = o1.a.a(f12, f13, f11, f13);
        float f14 = this.f11507l;
        float f15 = this.f11506k;
        this.f11508m = o1.a.a(f14, f15, f11, f15);
        this.f11499d = f4.a.getNewColorAlpha(this.f11498c, (0.3f * f11) + 0.4f);
    }

    public void onDraw(Paint paint) {
        float f10 = this.f11505j;
        float f11 = this.f11508m;
        int i10 = this.f11499d;
        Paint paint2 = this.f11497b;
        paint2.setShadowLayer(f10, 0.0f, f11, i10);
        paint2.setColor(this.f11502g);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = p.getActionMasked(motionEvent);
        View view = this.f11496a;
        AnimationSet animationSet = this.f11511p;
        if (actionMasked == 0) {
            k kVar = new k(new h(this));
            animationSet.cancel();
            animationSet.getAnimations().clear();
            animationSet.addAnimation(kVar);
            view.startAnimation(animationSet);
            return true;
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return false;
        }
        k kVar2 = new k(new i(this));
        kVar2.setAnimationListener(new j(this));
        animationSet.cancel();
        animationSet.getAnimations().clear();
        animationSet.addAnimation(kVar2);
        view.startAnimation(animationSet);
        return true;
    }

    public void setAnimationDuration(long j10) {
        this.f11511p.setDuration(j10);
    }

    public void setNormalColor(int i10) {
        this.f11500e = i10;
        this.f11502g = i10;
    }

    public void setPressedColor(int i10) {
        this.f11501f = i10;
    }

    public void setShadowLimits(float f10, float f11, float f12, float f13) {
        this.f11506k = f10;
        this.f11508m = f10;
        this.f11509n = f13;
        this.f11510o = f12;
        this.f11507l = f11;
        a(0.2f);
        this.f11496a.invalidate();
    }

    /* compiled from: ShadowSelectorGenerator.java */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            g gVar = g.this;
            gVar.a(gVar.f11504i);
            gVar.f11496a.invalidate();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
