package com.bosphere.fadingedgelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class FadingEdgeLayout extends FrameLayout {
    public static final int[] C = {0, -16777216};
    public static final int[] D = {-16777216, 0};
    public Rect A;
    public int B;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5556b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5557m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5558n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5559o;

    /* renamed from: p, reason: collision with root package name */
    public int f5560p;

    /* renamed from: q, reason: collision with root package name */
    public int f5561q;

    /* renamed from: r, reason: collision with root package name */
    public int f5562r;

    /* renamed from: s, reason: collision with root package name */
    public int f5563s;

    /* renamed from: t, reason: collision with root package name */
    public Paint f5564t;

    /* renamed from: u, reason: collision with root package name */
    public Paint f5565u;

    /* renamed from: v, reason: collision with root package name */
    public Paint f5566v;

    /* renamed from: w, reason: collision with root package name */
    public Paint f5567w;

    /* renamed from: x, reason: collision with root package name */
    public Rect f5568x;

    /* renamed from: y, reason: collision with root package name */
    public Rect f5569y;

    /* renamed from: z, reason: collision with root package name */
    public Rect f5570z;

    public FadingEdgeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.FadingEdgeLayout, 0, 0);
            int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.FadingEdgeLayout_fel_edge, 0);
            this.f5556b = (i10 & 1) == 1;
            this.f5557m = (i10 & 2) == 2;
            this.f5558n = (i10 & 4) == 4;
            this.f5559o = (i10 & 8) == 8;
            this.f5560p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FadingEdgeLayout_fel_size_top, iApplyDimension);
            this.f5561q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FadingEdgeLayout_fel_size_bottom, iApplyDimension);
            this.f5562r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FadingEdgeLayout_fel_size_left, iApplyDimension);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FadingEdgeLayout_fel_size_right, iApplyDimension);
            this.f5563s = dimensionPixelSize;
            if (this.f5556b && this.f5560p > 0) {
                this.B |= 1;
            }
            if (this.f5558n && this.f5562r > 0) {
                this.B |= 4;
            }
            if (this.f5557m && this.f5561q > 0) {
                this.B |= 2;
            }
            if (this.f5559o && dimensionPixelSize > 0) {
                this.B |= 8;
            }
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f5563s = iApplyDimension;
            this.f5562r = iApplyDimension;
            this.f5561q = iApplyDimension;
            this.f5560p = iApplyDimension;
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Paint paint = new Paint(1);
        this.f5564t = paint;
        paint.setXfermode(porterDuffXfermode);
        Paint paint2 = new Paint(1);
        this.f5565u = paint2;
        paint2.setXfermode(porterDuffXfermode);
        Paint paint3 = new Paint(1);
        this.f5566v = paint3;
        paint3.setXfermode(porterDuffXfermode);
        Paint paint4 = new Paint(1);
        this.f5567w = paint4;
        paint4.setXfermode(porterDuffXfermode);
        this.f5568x = new Rect();
        this.f5570z = new Rect();
        this.f5569y = new Rect();
        this.A = new Rect();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        boolean z10 = this.f5556b || this.f5557m || this.f5558n || this.f5559o;
        if (getVisibility() == 8 || width == 0 || height == 0 || !z10) {
            super.dispatchDraw(canvas);
            return;
        }
        int i10 = this.B;
        int i11 = i10 & 1;
        int[] iArr = C;
        if (i11 == 1) {
            this.B = i10 & (-2);
            int iMin = Math.min(this.f5560p, (getHeight() - getPaddingTop()) - getPaddingBottom());
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i12 = iMin + paddingTop;
            this.f5568x.set(paddingLeft, paddingTop, getWidth() - getPaddingRight(), i12);
            float f10 = paddingLeft;
            this.f5564t.setShader(new LinearGradient(f10, paddingTop, f10, i12, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
        int i13 = this.B;
        if ((i13 & 4) == 4) {
            this.B = i13 & (-5);
            int iMin2 = Math.min(this.f5562r, (getWidth() - getPaddingLeft()) - getPaddingRight());
            int paddingLeft2 = getPaddingLeft();
            int paddingTop2 = getPaddingTop();
            int i14 = iMin2 + paddingLeft2;
            this.f5570z.set(paddingLeft2, paddingTop2, i14, getHeight() - getPaddingBottom());
            float f11 = paddingTop2;
            this.f5566v.setShader(new LinearGradient(paddingLeft2, f11, i14, f11, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }
        int i15 = this.B;
        int i16 = i15 & 2;
        int[] iArr2 = D;
        if (i16 == 2) {
            this.B = i15 & (-3);
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int iMin3 = Math.min(this.f5561q, height2);
            int paddingLeft3 = getPaddingLeft();
            int paddingTop3 = (getPaddingTop() + height2) - iMin3;
            int i17 = iMin3 + paddingTop3;
            this.f5569y.set(paddingLeft3, paddingTop3, getWidth() - getPaddingRight(), i17);
            float f12 = paddingLeft3;
            this.f5565u.setShader(new LinearGradient(f12, paddingTop3, f12, i17, iArr2, (float[]) null, Shader.TileMode.CLAMP));
        }
        int i18 = this.B;
        if ((i18 & 8) == 8) {
            this.B = i18 & (-9);
            int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int iMin4 = Math.min(this.f5563s, width2);
            int paddingLeft4 = (getPaddingLeft() + width2) - iMin4;
            int paddingTop4 = getPaddingTop();
            int i19 = iMin4 + paddingLeft4;
            this.A.set(paddingLeft4, paddingTop4, i19, getHeight() - getPaddingBottom());
            float f13 = paddingTop4;
            this.f5567w.setShader(new LinearGradient(paddingLeft4, f13, i19, f13, iArr2, (float[]) null, Shader.TileMode.CLAMP));
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        if (this.f5556b && this.f5560p > 0) {
            canvas.drawRect(this.f5568x, this.f5564t);
        }
        if (this.f5557m && this.f5561q > 0) {
            canvas.drawRect(this.f5569y, this.f5565u);
        }
        if (this.f5558n && this.f5562r > 0) {
            canvas.drawRect(this.f5570z, this.f5566v);
        }
        if (this.f5559o && this.f5563s > 0) {
            canvas.drawRect(this.A, this.f5567w);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.B = this.B | 4 | 8;
        }
        if (i11 != i13) {
            this.B = this.B | 1 | 2;
        }
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        if (getPaddingLeft() != i10) {
            this.B |= 4;
        }
        if (getPaddingTop() != i11) {
            this.B |= 1;
        }
        if (getPaddingRight() != i12) {
            this.B |= 8;
        }
        if (getPaddingBottom() != i13) {
            this.B |= 2;
        }
        super.setPadding(i10, i11, i12, i13);
    }
}
