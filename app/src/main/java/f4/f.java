package f4;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import com.devpaul.materialfabmenu.R;
import x0.p;

/* compiled from: ShadowRippleGenerator.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: z, reason: collision with root package name */
    public static final OvershootInterpolator f11469z = new OvershootInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public final View f11470a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11471b;

    /* renamed from: c, reason: collision with root package name */
    public int f11472c;

    /* renamed from: d, reason: collision with root package name */
    public int f11473d;

    /* renamed from: e, reason: collision with root package name */
    public int f11474e;

    /* renamed from: f, reason: collision with root package name */
    public int f11475f;

    /* renamed from: g, reason: collision with root package name */
    public int f11476g;

    /* renamed from: h, reason: collision with root package name */
    public float f11477h;

    /* renamed from: i, reason: collision with root package name */
    public float f11478i;

    /* renamed from: j, reason: collision with root package name */
    public final float f11479j;

    /* renamed from: k, reason: collision with root package name */
    public final float f11480k;

    /* renamed from: l, reason: collision with root package name */
    public float f11481l;

    /* renamed from: m, reason: collision with root package name */
    public final float f11482m;

    /* renamed from: n, reason: collision with root package name */
    public final float f11483n;

    /* renamed from: o, reason: collision with root package name */
    public float f11484o;

    /* renamed from: p, reason: collision with root package name */
    public float f11485p;

    /* renamed from: q, reason: collision with root package name */
    public float f11486q;

    /* renamed from: r, reason: collision with root package name */
    public float f11487r;

    /* renamed from: s, reason: collision with root package name */
    public float f11488s;

    /* renamed from: t, reason: collision with root package name */
    public float f11489t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11490u;

    /* renamed from: v, reason: collision with root package name */
    public final AnimationSet f11491v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f11492w = new Paint(1);

    /* renamed from: x, reason: collision with root package name */
    public final Path f11493x = new Path();

    /* renamed from: y, reason: collision with root package name */
    public RectF f11494y;

    static {
        new AccelerateDecelerateInterpolator();
    }

    public f(View view, Paint paint) throws Resources.NotFoundException {
        this.f11470a = view;
        this.f11471b = paint;
        Resources resources = view.getResources();
        view.setLayerType(1, paint);
        AnimationSet animationSet = new AnimationSet(true);
        this.f11491v = animationSet;
        animationSet.setInterpolator(f11469z);
        float dimension = resources.getDimension(R.dimen.mat_fab_shadow_offset) * 1.5f;
        this.f11480k = dimension;
        float f10 = dimension / 1.5f;
        this.f11479j = f10;
        float dimension2 = resources.getDimension(R.dimen.mat_fab_shadow_max_radius);
        this.f11482m = dimension2;
        float dimension3 = resources.getDimension(R.dimen.mat_fab_shadow_min_radius) / 2.0f;
        this.f11483n = dimension3;
        this.f11472c = -16777216;
        this.f11473d = a.getNewColorAlpha(-16777216, 0.1f);
        this.f11477h = 0.2f;
        this.f11478i = o1.a.a(dimension2, dimension3, 0.2173913f, dimension3);
        this.f11481l = o1.a.a(dimension, f10, 0.2173913f, f10);
        this.f11473d = a.getNewColorAlpha(this.f11472c, 0.4652174f);
        view.addOnAttachStateChangeListener(new b(this));
        this.f11475f = 100;
        this.f11485p = 0.0f;
        this.f11494y = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        this.f11490u = false;
        this.f11489t = 0.0f;
    }

    public static void a(f fVar, float f10) {
        fVar.getClass();
        if (f10 == 0.0f) {
            f10 += 0.0f;
        } else if (f10 > 0.92f) {
            f10 = 0.92f;
        }
        fVar.f11477h = f10;
        float f11 = f10 / 0.92f;
        float f12 = fVar.f11482m;
        float f13 = fVar.f11483n;
        fVar.f11478i = o1.a.a(f12, f13, f11, f13);
        float f14 = fVar.f11480k;
        float f15 = fVar.f11479j;
        fVar.f11481l = o1.a.a(f14, f15, f11, f15);
        fVar.f11473d = a.getNewColorAlpha(fVar.f11472c, (0.3f * f11) + 0.4f);
    }

    public void onDrawRipple(Canvas canvas) {
        if (this.f11490u) {
            Path path = this.f11493x;
            path.reset();
            RectF rectF = this.f11494y;
            float f10 = this.f11484o;
            path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawCircle(this.f11487r, this.f11488s, this.f11485p, this.f11492w);
        }
    }

    public void onDrawShadow(Paint paint) {
        this.f11471b.setShadowLayer(this.f11478i, 0.0f, this.f11481l, this.f11473d);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = p.getActionMasked(motionEvent);
        View view = this.f11470a;
        AnimationSet animationSet = this.f11491v;
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 3) {
                return false;
            }
            k kVar = new k(new d(this));
            kVar.setAnimationListener(new e(this));
            animationSet.cancel();
            animationSet.getAnimations().clear();
            animationSet.addAnimation(kVar);
            view.startAnimation(animationSet);
            return true;
        }
        this.f11487r = motionEvent.getX();
        float y10 = motionEvent.getY();
        this.f11488s = y10;
        this.f11490u = this.f11494y.contains(this.f11487r, y10);
        this.f11475f = 100;
        int newColorAlpha = a.getNewColorAlpha(this.f11476g, 100);
        this.f11474e = newColorAlpha;
        this.f11492w.setColor(newColorAlpha);
        k kVar2 = new k(new c(this));
        animationSet.cancel();
        animationSet.getAnimations().clear();
        animationSet.addAnimation(kVar2);
        view.startAnimation(animationSet);
        return true;
    }

    public void setAnimationDuration(long j10) {
        this.f11491v.setDuration(j10);
    }

    public void setBoundingRect(RectF rectF) {
        this.f11494y = rectF;
    }

    public void setClipRadius(float f10) {
        this.f11484o = f10;
    }

    public void setMaxRippleRadius(float f10) {
        this.f11486q = f10;
        this.f11489t = f10 * 2.1f;
    }

    public void setRippleColor(int i10) {
        this.f11474e = a.getNewColorAlpha(i10, this.f11475f);
        this.f11476g = i10;
        this.f11492w.setColor(i10);
    }
}
