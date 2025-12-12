package w7;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import n7.b;
import n7.c;

/* compiled from: MaterialTextView.java */
/* loaded from: classes.dex */
public final class a extends AppCompatTextView {
    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public final void m(int i10, Resources.Theme theme) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i10, com.google.android.material.R.styleable.MaterialTextAppearance);
        Context context = getContext();
        int[] iArr = {com.google.android.material.R.styleable.MaterialTextAppearance_android_lineHeight, com.google.android.material.R.styleable.MaterialTextAppearance_lineHeight};
        int dimensionPixelSize = -1;
        for (int i11 = 0; i11 < 2 && dimensionPixelSize < 0; i11++) {
            dimensionPixelSize = c.getDimensionPixelSize(context, typedArrayObtainStyledAttributes, iArr[i11], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (dimensionPixelSize >= 0) {
            setLineHeight(dimensionPixelSize);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i10) throws Resources.NotFoundException {
        super.setTextAppearance(context, i10);
        if (b.resolveBoolean(context, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true)) {
            m(i10, context.getTheme());
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(x7.a.wrap(context, attributeSet, i10, 0), attributeSet, i10);
        Context context2 = getContext();
        if (b.resolveBoolean(context2, com.google.android.material.R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = com.google.android.material.R.styleable.MaterialTextView;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i10, 0);
            int[] iArr2 = {com.google.android.material.R.styleable.MaterialTextView_android_lineHeight, com.google.android.material.R.styleable.MaterialTextView_lineHeight};
            int dimensionPixelSize = -1;
            for (int i11 = 0; i11 < 2 && dimensionPixelSize < 0; i11++) {
                dimensionPixelSize = c.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, iArr2[i11], -1);
            }
            typedArrayObtainStyledAttributes.recycle();
            if (dimensionPixelSize != -1) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, i10, 0);
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(com.google.android.material.R.styleable.MaterialTextView_android_textAppearance, -1);
            typedArrayObtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                m(resourceId, theme);
            }
        }
    }
}
