package androidx.leanback.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class PagingIndicator extends View {
    public static final DecelerateInterpolator H = new DecelerateInterpolator();
    public static final a I = new a();
    public static final b J = new b();
    public static final c K = new c();
    public int A;
    public final Paint B;
    public final Paint C;
    public Bitmap D;
    public Paint E;
    public final Rect F;
    public final float G;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3078b;

    /* renamed from: m, reason: collision with root package name */
    public final int f3079m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3080n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3081o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3082p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3083q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3084r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3085s;

    /* renamed from: t, reason: collision with root package name */
    public d[] f3086t;

    /* renamed from: u, reason: collision with root package name */
    public int[] f3087u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f3088v;

    /* renamed from: w, reason: collision with root package name */
    public int[] f3089w;

    /* renamed from: x, reason: collision with root package name */
    public int f3090x;

    /* renamed from: y, reason: collision with root package name */
    public int f3091y;

    /* renamed from: z, reason: collision with root package name */
    public int f3092z;

    public static class a extends Property<d, Float> {
        public a() {
            super(Float.class, "alpha");
        }

        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.getAlpha());
        }

        @Override // android.util.Property
        public void set(d dVar, Float f10) {
            dVar.setAlpha(f10.floatValue());
        }
    }

    public static class b extends Property<d, Float> {
        public b() {
            super(Float.class, "diameter");
        }

        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.getDiameter());
        }

        @Override // android.util.Property
        public void set(d dVar, Float f10) {
            dVar.setDiameter(f10.floatValue());
        }
    }

    public static class c extends Property<d, Float> {
        public c() {
            super(Float.class, "translation_x");
        }

        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.getTranslationX());
        }

        @Override // android.util.Property
        public void set(d dVar, Float f10) {
            dVar.setTranslationX(f10.floatValue());
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        public float f3093a;

        /* renamed from: b, reason: collision with root package name */
        public int f3094b;

        /* renamed from: c, reason: collision with root package name */
        public float f3095c;

        /* renamed from: d, reason: collision with root package name */
        public float f3096d;

        /* renamed from: e, reason: collision with root package name */
        public float f3097e;

        /* renamed from: f, reason: collision with root package name */
        public float f3098f;

        /* renamed from: g, reason: collision with root package name */
        public float f3099g;

        /* renamed from: h, reason: collision with root package name */
        public float f3100h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        public float f3101i;

        public d() {
            this.f3101i = PagingIndicator.this.f3078b ? 1.0f : -1.0f;
        }

        public final void a() {
            this.f3095c = 0.0f;
            this.f3096d = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.f3097e = pagingIndicator.f3079m;
            float f10 = pagingIndicator.f3080n;
            this.f3098f = f10;
            this.f3099g = f10 * pagingIndicator.G;
            this.f3093a = 0.0f;
            adjustAlpha();
        }

        public void adjustAlpha() {
            int iRound = Math.round(this.f3093a * 255.0f);
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.f3094b = Color.argb(iRound, Color.red(pagingIndicator.A), Color.green(pagingIndicator.A), Color.blue(pagingIndicator.A));
        }

        public float getAlpha() {
            return this.f3093a;
        }

        public float getDiameter() {
            return this.f3097e;
        }

        public float getTranslationX() {
            return this.f3095c;
        }

        public void setAlpha(float f10) {
            this.f3093a = f10;
            adjustAlpha();
            PagingIndicator.this.invalidate();
        }

        public void setDiameter(float f10) {
            this.f3097e = f10;
            float f11 = f10 / 2.0f;
            this.f3098f = f11;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.f3099g = f11 * pagingIndicator.G;
            pagingIndicator.invalidate();
        }

        public void setTranslationX(float f10) {
            this.f3095c = f10 * this.f3100h * this.f3101i;
            PagingIndicator.this.invalidate();
        }
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + this.f3082p + this.f3085s;
    }

    private int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getRequiredWidth();
    }

    private int getRequiredWidth() {
        return ((this.f3091y - 3) * this.f3081o) + (this.f3084r * 2) + (this.f3080n * 2);
    }

    private void setSelectedPage(int i10) {
        if (i10 == this.f3092z) {
            return;
        }
        this.f3092z = i10;
        a();
    }

    public final void a() {
        int i10;
        int i11 = 0;
        while (true) {
            i10 = this.f3092z;
            if (i11 >= i10) {
                break;
            }
            this.f3086t[i11].a();
            d dVar = this.f3086t[i11];
            if (i11 != 0) {
                f = 1.0f;
            }
            dVar.f3100h = f;
            dVar.f3096d = this.f3088v[i11];
            i11++;
        }
        d dVar2 = this.f3086t[i10];
        dVar2.f3095c = 0.0f;
        dVar2.f3096d = 0.0f;
        PagingIndicator pagingIndicator = PagingIndicator.this;
        dVar2.f3097e = pagingIndicator.f3082p;
        float f10 = pagingIndicator.f3083q;
        dVar2.f3098f = f10;
        dVar2.f3099g = f10 * pagingIndicator.G;
        dVar2.f3093a = 1.0f;
        dVar2.adjustAlpha();
        d[] dVarArr = this.f3086t;
        int i12 = this.f3092z;
        d dVar3 = dVarArr[i12];
        dVar3.f3100h = i12 <= 0 ? 1.0f : -1.0f;
        dVar3.f3096d = this.f3087u[i12];
        while (true) {
            i12++;
            if (i12 >= this.f3091y) {
                return;
            }
            this.f3086t[i12].a();
            d dVar4 = this.f3086t[i12];
            dVar4.f3100h = 1.0f;
            dVar4.f3096d = this.f3089w[i12];
        }
    }

    public final void b() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i10 = (paddingLeft + width) / 2;
        int i11 = this.f3091y;
        int[] iArr = new int[i11];
        this.f3087u = iArr;
        int[] iArr2 = new int[i11];
        this.f3088v = iArr2;
        int[] iArr3 = new int[i11];
        this.f3089w = iArr3;
        boolean z10 = this.f3078b;
        int i12 = this.f3080n;
        int i13 = this.f3084r;
        int i14 = this.f3081o;
        int i15 = 1;
        if (z10) {
            int i16 = i10 - (requiredWidth / 2);
            iArr[0] = ((i16 + i12) - i14) + i13;
            iArr2[0] = i16 + i12;
            iArr3[0] = (i13 * 2) + ((i16 + i12) - (i14 * 2));
            while (i15 < this.f3091y) {
                int[] iArr4 = this.f3087u;
                int[] iArr5 = this.f3088v;
                int i17 = i15 - 1;
                iArr4[i15] = iArr5[i17] + i13;
                iArr5[i15] = iArr5[i17] + i14;
                this.f3089w[i15] = iArr4[i17] + i13;
                i15++;
            }
        } else {
            int i18 = (requiredWidth / 2) + i10;
            iArr[0] = ((i18 - i12) + i14) - i13;
            iArr2[0] = i18 - i12;
            iArr3[0] = ((i14 * 2) + (i18 - i12)) - (i13 * 2);
            while (i15 < this.f3091y) {
                int[] iArr6 = this.f3087u;
                int[] iArr7 = this.f3088v;
                int i19 = i15 - 1;
                iArr6[i15] = iArr7[i19] - i13;
                iArr7[i15] = iArr7[i19] - i14;
                this.f3089w[i15] = iArr6[i19] - i13;
                i15++;
            }
        }
        this.f3090x = paddingTop + this.f3083q;
        a();
    }

    public final ObjectAnimator c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, K, (-this.f3084r) + this.f3081o, 0.0f);
        objectAnimatorOfFloat.setDuration(417L);
        objectAnimatorOfFloat.setInterpolator(H);
        return objectAnimatorOfFloat;
    }

    public final int d(TypedArray typedArray, int i10, int i11) {
        return typedArray.getDimensionPixelOffset(i10, getResources().getDimensionPixelOffset(i11));
    }

    public final Bitmap e() {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lb_ic_nav_arrow);
        if (this.f3078b) {
            return bitmapDecodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, false);
    }

    public int[] getDotSelectedLeftX() {
        return this.f3088v;
    }

    public int[] getDotSelectedRightX() {
        return this.f3089w;
    }

    public int[] getDotSelectedX() {
        return this.f3087u;
    }

    public int getPageCount() {
        return this.f3091y;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f3091y; i10++) {
            d dVar = this.f3086t[i10];
            float f10 = dVar.f3096d + dVar.f3095c;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            canvas.drawCircle(f10, pagingIndicator.f3090x, dVar.f3098f, pagingIndicator.B);
            if (dVar.f3093a > 0.0f) {
                Paint paint = pagingIndicator.C;
                paint.setColor(dVar.f3094b);
                canvas.drawCircle(f10, pagingIndicator.f3090x, dVar.f3098f, paint);
                Bitmap bitmap = pagingIndicator.D;
                float f11 = dVar.f3099g;
                float f12 = pagingIndicator.f3090x;
                canvas.drawBitmap(bitmap, pagingIndicator.F, new Rect((int) (f10 - f11), (int) (f12 - f11), (int) (f10 + f11), (int) (f12 + f11)), pagingIndicator.E);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i11));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i11);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i10);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i10));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i10);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = i10 == 0;
        if (this.f3078b != z10) {
            this.f3078b = z10;
            this.D = e();
            d[] dVarArr = this.f3086t;
            if (dVarArr != null) {
                for (d dVar : dVarArr) {
                    dVar.f3101i = PagingIndicator.this.f3078b ? 1.0f : -1.0f;
                }
            }
            b();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        setMeasuredDimension(i10, i11);
        b();
    }

    public void setArrowBackgroundColor(int i10) {
        this.A = i10;
    }

    public void setArrowColor(int i10) {
        if (this.E == null) {
            this.E = new Paint();
        }
        this.E.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(int i10) {
        this.B.setColor(i10);
    }

    public void setPageCount(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The page count should be a positive integer");
        }
        this.f3091y = i10;
        this.f3086t = new d[i10];
        for (int i11 = 0; i11 < this.f3091y; i11++) {
            this.f3086t[i11] = new d();
        }
        b();
        setSelectedPage(0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagingIndicator, i10, 0);
        int iD = d(typedArrayObtainStyledAttributes, R.styleable.PagingIndicator_lbDotRadius, R.dimen.lb_page_indicator_dot_radius);
        this.f3080n = iD;
        int i11 = iD * 2;
        this.f3079m = i11;
        int iD2 = d(typedArrayObtainStyledAttributes, R.styleable.PagingIndicator_arrowRadius, R.dimen.lb_page_indicator_arrow_radius);
        this.f3083q = iD2;
        int i12 = iD2 * 2;
        this.f3082p = i12;
        this.f3081o = d(typedArrayObtainStyledAttributes, R.styleable.PagingIndicator_dotToDotGap, R.dimen.lb_page_indicator_dot_gap);
        this.f3084r = d(typedArrayObtainStyledAttributes, R.styleable.PagingIndicator_dotToArrowGap, R.dimen.lb_page_indicator_arrow_gap);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.PagingIndicator_dotBgColor, getResources().getColor(R.color.lb_page_indicator_dot));
        Paint paint = new Paint(1);
        this.B = paint;
        paint.setColor(color);
        this.A = typedArrayObtainStyledAttributes.getColor(R.styleable.PagingIndicator_arrowBgColor, getResources().getColor(R.color.lb_page_indicator_arrow_background));
        if (this.E == null) {
            int i13 = R.styleable.PagingIndicator_arrowColor;
            if (typedArrayObtainStyledAttributes.hasValue(i13)) {
                setArrowColor(typedArrayObtainStyledAttributes.getColor(i13, 0));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f3078b = resources.getConfiguration().getLayoutDirection() == 0;
        int color2 = resources.getColor(R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.f3085s = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.C = paint2;
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color2);
        this.D = e();
        this.F = new Rect(0, 0, this.D.getWidth(), this.D.getHeight());
        float f10 = i12;
        this.G = this.D.getWidth() / f10;
        AnimatorSet animatorSet2 = new AnimatorSet();
        a aVar = I;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, aVar, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(167L);
        DecelerateInterpolator decelerateInterpolator = H;
        objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        float f11 = i11;
        b bVar = J;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat((Object) null, bVar, f11, f10);
        objectAnimatorOfFloat2.setDuration(417L);
        objectAnimatorOfFloat2.setInterpolator(decelerateInterpolator);
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, c());
        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat((Object) null, aVar, 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(167L);
        objectAnimatorOfFloat3.setInterpolator(decelerateInterpolator);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat((Object) null, bVar, f10, f11);
        objectAnimatorOfFloat4.setDuration(417L);
        objectAnimatorOfFloat4.setInterpolator(decelerateInterpolator);
        animatorSet3.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, c());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        setLayerType(1, null);
    }
}
