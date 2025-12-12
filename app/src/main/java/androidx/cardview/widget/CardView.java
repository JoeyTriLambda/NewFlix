package androidx.cardview.widget;

import a0.b;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f1585q = {R.attr.colorBackground};

    /* renamed from: r, reason: collision with root package name */
    public static final a0.a f1586r;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1587b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1588m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f1589n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f1590o;

    /* renamed from: p, reason: collision with root package name */
    public final a f1591p;

    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f1592a;

        public a() {
        }

        public Drawable getCardBackground() {
            return this.f1592a;
        }

        public View getCardView() {
            return CardView.this;
        }

        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        public void setCardBackground(Drawable drawable) {
            this.f1592a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public void setShadowPadding(int i10, int i11, int i12, int i13) {
            CardView cardView = CardView.this;
            cardView.f1590o.set(i10, i11, i12, i13);
            Rect rect = cardView.f1589n;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }
    }

    static {
        a0.a aVar = new a0.a();
        f1586r = aVar;
        aVar.initStatic();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1586r.getBackgroundColor(this.f1591p);
    }

    public float getCardElevation() {
        return f1586r.getElevation(this.f1591p);
    }

    public int getContentPaddingBottom() {
        return this.f1589n.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1589n.left;
    }

    public int getContentPaddingRight() {
        return this.f1589n.right;
    }

    public int getContentPaddingTop() {
        return this.f1589n.top;
    }

    public float getMaxCardElevation() {
        return f1586r.getMaxElevation(this.f1591p);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1588m;
    }

    public float getRadius() {
        return f1586r.getRadius(this.f1591p);
    }

    public boolean getUseCompatPadding() {
        return this.f1587b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f1586r.setBackgroundColor(this.f1591p, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f1586r.setElevation(this.f1591p, f10);
    }

    public void setMaxCardElevation(float f10) {
        f1586r.setMaxElevation(this.f1591p, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        super.setMinimumWidth(i10);
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f1588m) {
            this.f1588m = z10;
            f1586r.onPreventCornerOverlapChanged(this.f1591p);
        }
    }

    public void setRadius(float f10) {
        f1586r.setRadius(this.f1591p, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f1587b != z10) {
            this.f1587b = z10;
            f1586r.onCompatPaddingChanged(this.f1591p);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i10);
        Rect rect = new Rect();
        this.f1589n = rect;
        this.f1590o = new Rect();
        a aVar = new a();
        this.f1591p = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i10, androidx.cardview.R.style.CardView);
        int i11 = androidx.cardview.R.styleable.CardView_cardBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i11);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f1585q);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(androidx.cardview.R.color.cardview_light_background) : getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f1587b = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f1588m = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f1586r.initialize(aVar, context, colorStateList, dimension, dimension2, f10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1586r.setBackgroundColor(this.f1591p, colorStateList);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }
}
