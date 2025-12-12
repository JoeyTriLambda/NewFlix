package m7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.u;
import com.google.android.material.R;
import d1.c;
import i7.r;

/* compiled from: MaterialRadioButton.java */
/* loaded from: classes.dex */
public final class a extends u {

    /* renamed from: r, reason: collision with root package name */
    public static final int f16197r = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* renamed from: s, reason: collision with root package name */
    public static final int[][] f16198s = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f16199p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f16200q;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f16199p == null) {
            int color = c7.a.getColor(this, R.attr.colorControlActivated);
            int color2 = c7.a.getColor(this, R.attr.colorOnSurface);
            int color3 = c7.a.getColor(this, R.attr.colorSurface);
            this.f16199p = new ColorStateList(f16198s, new int[]{c7.a.layer(color3, color, 1.0f), c7.a.layer(color3, color2, 0.54f), c7.a.layer(color3, color2, 0.38f), c7.a.layer(color3, color2, 0.38f)});
        }
        return this.f16199p;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16200q && c.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f16200q = z10;
        if (z10) {
            c.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            c.setButtonTintList(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f16197r;
        super(x7.a.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = r.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialRadioButton, i10, i11, new int[0]);
        int i12 = R.styleable.MaterialRadioButton_buttonTint;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            c.setButtonTintList(this, n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, i12));
        }
        this.f16200q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}
