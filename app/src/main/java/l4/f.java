package l4;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* compiled from: Sprite.java */
/* loaded from: classes.dex */
public abstract class f extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    public static final Rect D = new Rect();
    public static final c E = new c();
    public static final d F = new d();
    public static final e G = new e();
    public static final h H;
    public static final i I;
    public static final k J;
    public static final a K;
    public static final b L;

    /* renamed from: o, reason: collision with root package name */
    public float f15759o;

    /* renamed from: p, reason: collision with root package name */
    public float f15760p;

    /* renamed from: q, reason: collision with root package name */
    public int f15761q;

    /* renamed from: r, reason: collision with root package name */
    public int f15762r;

    /* renamed from: s, reason: collision with root package name */
    public int f15763s;

    /* renamed from: t, reason: collision with root package name */
    public int f15764t;

    /* renamed from: u, reason: collision with root package name */
    public int f15765u;

    /* renamed from: v, reason: collision with root package name */
    public int f15766v;

    /* renamed from: w, reason: collision with root package name */
    public float f15767w;

    /* renamed from: x, reason: collision with root package name */
    public float f15768x;

    /* renamed from: y, reason: collision with root package name */
    public ValueAnimator f15769y;

    /* renamed from: b, reason: collision with root package name */
    public float f15756b = 1.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f15757m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f15758n = 1.0f;

    /* renamed from: z, reason: collision with root package name */
    public int f15770z = 255;
    public Rect A = D;
    public final Camera B = new Camera();
    public final Matrix C = new Matrix();

    /* compiled from: Sprite.java */
    public static class a extends j4.b<f> {
        public a() {
            super("scale");
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.getScale());
        }

        @Override // j4.b
        public void setValue(f fVar, float f10) {
            fVar.setScale(f10);
        }
    }

    /* compiled from: Sprite.java */
    public static class b extends j4.c<f> {
        public b() {
            super("alpha");
        }

        @Override // android.util.Property
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getAlpha());
        }

        @Override // j4.c
        public void setValue(f fVar, int i10) {
            fVar.setAlpha(i10);
        }
    }

    /* compiled from: Sprite.java */
    public static class c extends j4.c<f> {
        public c() {
            super("rotateX");
        }

        @Override // android.util.Property
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getRotateX());
        }

        @Override // j4.c
        public void setValue(f fVar, int i10) {
            fVar.setRotateX(i10);
        }
    }

    /* compiled from: Sprite.java */
    public static class d extends j4.c<f> {
        public d() {
            super("rotate");
        }

        @Override // android.util.Property
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getRotate());
        }

        @Override // j4.c
        public void setValue(f fVar, int i10) {
            fVar.setRotate(i10);
        }
    }

    /* compiled from: Sprite.java */
    public static class e extends j4.c<f> {
        public e() {
            super("rotateY");
        }

        @Override // android.util.Property
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getRotateY());
        }

        @Override // j4.c
        public void setValue(f fVar, int i10) {
            fVar.setRotateY(i10);
        }
    }

    /* compiled from: Sprite.java */
    /* renamed from: l4.f$f, reason: collision with other inner class name */
    public static class C0187f extends j4.c<f> {
        public C0187f() {
            super("translateX");
        }

        @Override // android.util.Property
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getTranslateX());
        }

        @Override // j4.c
        public void setValue(f fVar, int i10) {
            fVar.setTranslateX(i10);
        }
    }

    /* compiled from: Sprite.java */
    public static class g extends j4.c<f> {
        public g() {
            super("translateY");
        }

        @Override // android.util.Property
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getTranslateY());
        }

        @Override // j4.c
        public void setValue(f fVar, int i10) {
            fVar.setTranslateY(i10);
        }
    }

    /* compiled from: Sprite.java */
    public static class h extends j4.b<f> {
        public h() {
            super("translateXPercentage");
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.getTranslateXPercentage());
        }

        @Override // j4.b
        public void setValue(f fVar, float f10) {
            fVar.setTranslateXPercentage(f10);
        }
    }

    /* compiled from: Sprite.java */
    public static class i extends j4.b<f> {
        public i() {
            super("translateYPercentage");
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.getTranslateYPercentage());
        }

        @Override // j4.b
        public void setValue(f fVar, float f10) {
            fVar.setTranslateYPercentage(f10);
        }
    }

    /* compiled from: Sprite.java */
    public static class j extends j4.b<f> {
        public j() {
            super("scaleX");
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.getScaleX());
        }

        @Override // j4.b
        public void setValue(f fVar, float f10) {
            fVar.setScaleX(f10);
        }
    }

    /* compiled from: Sprite.java */
    public static class k extends j4.b<f> {
        public k() {
            super("scaleY");
        }

        @Override // android.util.Property
        public Float get(f fVar) {
            return Float.valueOf(fVar.getScaleY());
        }

        @Override // j4.b
        public void setValue(f fVar, float f10) {
            fVar.setScaleY(f10);
        }
    }

    static {
        new C0187f();
        new g();
        H = new h();
        I = new i();
        new j();
        J = new k();
        K = new a();
        L = new b();
    }

    public Rect clipSquare(Rect rect) {
        int iMin = Math.min(rect.width(), rect.height());
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        int i10 = iMin / 2;
        return new Rect(iCenterX - i10, iCenterY - i10, iCenterX + i10, iCenterY + i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int translateX = getTranslateX();
        if (translateX == 0) {
            translateX = (int) (getTranslateXPercentage() * getBounds().width());
        }
        int translateY = getTranslateY();
        if (translateY == 0) {
            translateY = (int) (getTranslateYPercentage() * getBounds().height());
        }
        canvas.translate(translateX, translateY);
        canvas.scale(getScaleX(), getScaleY(), getPivotX(), getPivotY());
        canvas.rotate(getRotate(), getPivotX(), getPivotY());
        if (getRotateX() != 0 || getRotateY() != 0) {
            Camera camera = this.B;
            camera.save();
            camera.rotateX(getRotateX());
            camera.rotateY(getRotateY());
            Matrix matrix = this.C;
            camera.getMatrix(matrix);
            matrix.preTranslate(-getPivotX(), -getPivotY());
            matrix.postTranslate(getPivotX(), getPivotY());
            camera.restore();
            canvas.concat(matrix);
        }
        drawSelf(canvas);
    }

    public abstract void drawSelf(Canvas canvas);

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f15770z;
    }

    public abstract int getColor();

    public Rect getDrawBounds() {
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getPivotX() {
        return this.f15759o;
    }

    public float getPivotY() {
        return this.f15760p;
    }

    public int getRotate() {
        return this.f15766v;
    }

    public int getRotateX() {
        return this.f15762r;
    }

    public int getRotateY() {
        return this.f15763s;
    }

    public float getScale() {
        return this.f15756b;
    }

    public float getScaleX() {
        return this.f15757m;
    }

    public float getScaleY() {
        return this.f15758n;
    }

    public int getTranslateX() {
        return this.f15764t;
    }

    public float getTranslateXPercentage() {
        return this.f15767w;
    }

    public int getTranslateY() {
        return this.f15765u;
    }

    public float getTranslateYPercentage() {
        return this.f15768x;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return j4.a.isRunning(this.f15769y);
    }

    public ValueAnimator obtainAnimation() {
        if (this.f15769y == null) {
            this.f15769y = onCreateAnimation();
        }
        ValueAnimator valueAnimator = this.f15769y;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(this);
            this.f15769y.setStartDelay(this.f15761q);
        }
        return this.f15769y;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setDrawBounds(rect);
    }

    public abstract ValueAnimator onCreateAnimation();

    public void reset() {
        this.f15756b = 1.0f;
        this.f15762r = 0;
        this.f15763s = 0;
        this.f15764t = 0;
        this.f15765u = 0;
        this.f15766v = 0;
        this.f15767w = 0.0f;
        this.f15768x = 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f15770z = i10;
    }

    public f setAnimationDelay(int i10) {
        this.f15761q = i10;
        return this;
    }

    public abstract void setColor(int i10);

    public void setDrawBounds(Rect rect) {
        setDrawBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setPivotX(float f10) {
        this.f15759o = f10;
    }

    public void setPivotY(float f10) {
        this.f15760p = f10;
    }

    public void setRotate(int i10) {
        this.f15766v = i10;
    }

    public void setRotateX(int i10) {
        this.f15762r = i10;
    }

    public void setRotateY(int i10) {
        this.f15763s = i10;
    }

    public void setScale(float f10) {
        this.f15756b = f10;
        setScaleX(f10);
        setScaleY(f10);
    }

    public void setScaleX(float f10) {
        this.f15757m = f10;
    }

    public void setScaleY(float f10) {
        this.f15758n = f10;
    }

    public void setTranslateX(int i10) {
        this.f15764t = i10;
    }

    public void setTranslateXPercentage(float f10) {
        this.f15767w = f10;
    }

    public void setTranslateY(int i10) {
        this.f15765u = i10;
    }

    public void setTranslateYPercentage(float f10) {
        this.f15768x = f10;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (j4.a.isStarted(this.f15769y)) {
            return;
        }
        ValueAnimator valueAnimatorObtainAnimation = obtainAnimation();
        this.f15769y = valueAnimatorObtainAnimation;
        if (valueAnimatorObtainAnimation == null) {
            return;
        }
        j4.a.start(valueAnimatorObtainAnimation);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (j4.a.isStarted(this.f15769y)) {
            this.f15769y.removeAllUpdateListeners();
            this.f15769y.end();
            reset();
        }
    }

    public void setDrawBounds(int i10, int i11, int i12, int i13) {
        this.A = new Rect(i10, i11, i12, i13);
        setPivotX(getDrawBounds().centerX());
        setPivotY(getDrawBounds().centerY());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
    }
}
