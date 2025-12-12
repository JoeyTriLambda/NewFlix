package na;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: AnimatorProxy.java */
/* loaded from: classes.dex */
public final class a extends Animation {

    /* renamed from: y, reason: collision with root package name */
    public static final boolean f16768y;

    /* renamed from: z, reason: collision with root package name */
    public static final WeakHashMap<View, a> f16769z;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f16770b;

    /* renamed from: o, reason: collision with root package name */
    public float f16773o;

    /* renamed from: p, reason: collision with root package name */
    public float f16774p;

    /* renamed from: q, reason: collision with root package name */
    public float f16775q;

    /* renamed from: t, reason: collision with root package name */
    public float f16778t;

    /* renamed from: u, reason: collision with root package name */
    public float f16779u;

    /* renamed from: m, reason: collision with root package name */
    public final Camera f16771m = new Camera();

    /* renamed from: n, reason: collision with root package name */
    public float f16772n = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    public float f16776r = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    public float f16777s = 1.0f;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f16780v = new RectF();

    /* renamed from: w, reason: collision with root package name */
    public final RectF f16781w = new RectF();

    /* renamed from: x, reason: collision with root package name */
    public final Matrix f16782x = new Matrix();

    static {
        f16768y = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f16769z = new WeakHashMap<>();
    }

    public a(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f16770b = new WeakReference<>(view);
    }

    public static a wrap(View view) {
        WeakHashMap<View, a> weakHashMap = f16769z;
        a aVar = weakHashMap.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        a aVar2 = new a(view);
        weakHashMap.put(view, aVar2);
        return aVar2;
    }

    public final void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f16782x;
        matrix.reset();
        d(view, matrix);
        matrix.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f10 = rectF.right;
        float f11 = rectF.left;
        if (f10 < f11) {
            rectF.right = f11;
            rectF.left = f10;
        }
        float f12 = rectF.bottom;
        float f13 = rectF.top;
        if (f12 < f13) {
            rectF.top = f12;
            rectF.bottom = f13;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        View view = this.f16770b.get();
        if (view != null) {
            transformation.setAlpha(this.f16772n);
            d(view, transformation.getMatrix());
        }
    }

    public final void b() {
        View view = this.f16770b.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f16781w;
        a(view, rectF);
        rectF.union(this.f16780v);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void c() {
        View view = this.f16770b.get();
        if (view != null) {
            a(view, this.f16780v);
        }
    }

    public final void d(View view, Matrix matrix) {
        float width = view.getWidth();
        float height = view.getHeight();
        float f10 = width / 2.0f;
        float f11 = height / 2.0f;
        float f12 = this.f16773o;
        float f13 = this.f16774p;
        float f14 = this.f16775q;
        if (f12 != 0.0f || f13 != 0.0f || f14 != 0.0f) {
            Camera camera = this.f16771m;
            camera.save();
            camera.rotateX(f12);
            camera.rotateY(f13);
            camera.rotateZ(-f14);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f10, -f11);
            matrix.postTranslate(f10, f11);
        }
        float f15 = this.f16776r;
        float f16 = this.f16777s;
        if (f15 != 1.0f || f16 != 1.0f) {
            matrix.postScale(f15, f16);
            matrix.postTranslate(((f15 * width) - width) * (-(f10 / width)), ((f16 * height) - height) * (-(f11 / height)));
        }
        matrix.postTranslate(this.f16778t, this.f16779u);
    }

    public float getAlpha() {
        return this.f16772n;
    }

    public float getRotation() {
        return this.f16775q;
    }

    public float getRotationX() {
        return this.f16773o;
    }

    public float getRotationY() {
        return this.f16774p;
    }

    public float getScaleX() {
        return this.f16776r;
    }

    public float getScaleY() {
        return this.f16777s;
    }

    public float getTranslationX() {
        return this.f16778t;
    }

    public float getTranslationY() {
        return this.f16779u;
    }

    public float getX() {
        if (this.f16770b.get() == null) {
            return 0.0f;
        }
        return r0.getLeft() + this.f16778t;
    }

    public float getY() {
        if (this.f16770b.get() == null) {
            return 0.0f;
        }
        return r0.getTop() + this.f16779u;
    }

    public void setAlpha(float f10) {
        if (this.f16772n != f10) {
            this.f16772n = f10;
            View view = this.f16770b.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void setRotation(float f10) {
        if (this.f16775q != f10) {
            c();
            this.f16775q = f10;
            b();
        }
    }

    public void setRotationX(float f10) {
        if (this.f16773o != f10) {
            c();
            this.f16773o = f10;
            b();
        }
    }

    public void setRotationY(float f10) {
        if (this.f16774p != f10) {
            c();
            this.f16774p = f10;
            b();
        }
    }

    public void setScaleX(float f10) {
        if (this.f16776r != f10) {
            c();
            this.f16776r = f10;
            b();
        }
    }

    public void setScaleY(float f10) {
        if (this.f16777s != f10) {
            c();
            this.f16777s = f10;
            b();
        }
    }

    public void setTranslationX(float f10) {
        if (this.f16778t != f10) {
            c();
            this.f16778t = f10;
            b();
        }
    }

    public void setTranslationY(float f10) {
        if (this.f16779u != f10) {
            c();
            this.f16779u = f10;
            b();
        }
    }

    public void setX(float f10) {
        if (this.f16770b.get() != null) {
            setTranslationX(f10 - r0.getLeft());
        }
    }

    public void setY(float f10) {
        if (this.f16770b.get() != null) {
            setTranslationY(f10 - r0.getTop());
        }
    }
}
