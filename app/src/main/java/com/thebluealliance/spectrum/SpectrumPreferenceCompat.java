package com.thebluealliance.spectrum;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.DialogPreference;

/* loaded from: classes2.dex */
public class SpectrumPreferenceCompat extends DialogPreference {
    public SpectrumPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SpectrumPreference, 0, 0);
        try {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SpectrumPreference_spectrum_colors, 0);
            if (resourceId != 0) {
                getContext().getResources().getIntArray(resourceId);
            }
            typedArrayObtainStyledAttributes.getBoolean(R.styleable.SpectrumPreference_spectrum_closeOnSelected, true);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SpectrumPalette_spectrum_outlineWidth, 0);
            typedArrayObtainStyledAttributes.getInt(R.styleable.SpectrumPalette_spectrum_columnCount, -1);
            typedArrayObtainStyledAttributes.recycle();
            setDialogLayoutResource(R.layout.dialog_color_picker);
            setWidgetLayoutResource(R.layout.color_preference_widget);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // androidx.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInteger(i10, -16777216));
    }
}
