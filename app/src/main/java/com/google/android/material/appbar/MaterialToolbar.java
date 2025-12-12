package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import i7.r;
import i7.s;
import q7.g;
import q7.i;
import x0.j0;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: n0, reason: collision with root package name */
    public static final int f8766n0 = R.style.Widget_MaterialComponents_Toolbar;

    /* renamed from: o0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f8767o0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: i0, reason: collision with root package name */
    public Integer f8768i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f8769j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f8770k0;

    /* renamed from: l0, reason: collision with root package name */
    public ImageView.ScaleType f8771l0;

    /* renamed from: m0, reason: collision with root package name */
    public Boolean f8772m0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f8771l0;
    }

    public Integer getNavigationIconTint() {
        return this.f8768i0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i10) {
        Menu menu = getMenu();
        boolean z10 = menu instanceof e;
        if (z10) {
            ((e) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i10);
        if (z10) {
            ((e) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.setParentAbsoluteElevation(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f8769j0 || this.f8770k0) {
            TextView titleTextView = s.getTitleTextView(this);
            TextView subtitleTextView = s.getSubtitleTextView(this);
            if (titleTextView != null || subtitleTextView != null) {
                int measuredWidth = getMeasuredWidth();
                int i14 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt = getChildAt(i15);
                    if (childAt.getVisibility() != 8 && childAt != titleTextView && childAt != subtitleTextView) {
                        if (childAt.getRight() < i14 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i14 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f8769j0 && titleTextView != null) {
                    q(titleTextView, pair);
                }
                if (this.f8770k0 && subtitleTextView != null) {
                    q(subtitleTextView, pair);
                }
            }
        }
        ImageView logoImageView = s.getLogoImageView(this);
        if (logoImageView != null) {
            Boolean bool = this.f8772m0;
            if (bool != null) {
                logoImageView.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f8771l0;
            if (scaleType != null) {
                logoImageView.setScaleType(scaleType);
            }
        }
    }

    public final void q(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i10 += iMax;
            i11 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i10, textView.getTop(), i11, textView.getBottom());
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        i.setElevation(this, f10);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f8772m0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f8772m0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f8771l0 != scaleType) {
            this.f8771l0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f8768i0 != null) {
            drawable = p0.a.wrap(drawable.mutate());
            p0.a.setTint(drawable, this.f8768i0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i10) {
        this.f8768i0 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f8770k0 != z10) {
            this.f8770k0 = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f8769j0 != z10) {
            this.f8769j0 = z10;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8766n0;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialToolbar, i10, i11, new int[0]);
        int i12 = R.styleable.MaterialToolbar_navigationIconTint;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            setNavigationIconTint(typedArrayObtainStyledAttributes.getColor(i12, -1));
        }
        this.f8769j0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.f8770k0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.MaterialToolbar_logoScaleType, -1);
        if (i13 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f8767o0;
            if (i13 < scaleTypeArr.length) {
                this.f8771l0 = scaleTypeArr[i13];
            }
        }
        int i14 = R.styleable.MaterialToolbar_logoAdjustViewBounds;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f8772m0 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(i14, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : e7.a.getColorStateListOrNull(background);
        if (colorStateListValueOf != null) {
            g gVar = new g();
            gVar.setFillColor(colorStateListValueOf);
            gVar.initializeElevationOverlay(context2);
            gVar.setElevation(j0.getElevation(this));
            j0.setBackground(this, gVar);
        }
    }
}
