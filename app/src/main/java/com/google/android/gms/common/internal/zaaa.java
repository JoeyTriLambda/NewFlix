package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.common.util.DeviceProperties;
import p0.a;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    public static final int a(int i10, int i11, int i12, int i13) {
        if (i10 == 0) {
            return i11;
        }
        if (i10 == 1) {
            return i12;
        }
        if (i10 == 2) {
            return i13;
        }
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("Unknown color scheme: ");
        sb2.append(i10);
        throw new IllegalStateException(sb2.toString());
    }

    public final void zaa(Resources resources, int i10, int i11) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i12 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i12);
        setMinWidth(i12);
        int i13 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark;
        int i14 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light;
        int iA = a(i11, i13, i14, i14);
        int i15 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_dark;
        int i16 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_light;
        int iA2 = a(i11, i15, i16, i16);
        if (i10 == 0 || i10 == 1) {
            iA = iA2;
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i10);
            throw new IllegalStateException(sb2.toString());
        }
        Drawable drawableWrap = a.wrap(resources.getDrawable(iA));
        a.setTintList(drawableWrap, resources.getColorStateList(com.google.android.gms.base.R.color.common_google_signin_btn_tint));
        a.setTintMode(drawableWrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawableWrap);
        int i17 = com.google.android.gms.base.R.color.common_google_signin_btn_text_dark;
        int i18 = com.google.android.gms.base.R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(a(i11, i17, i18, i18))));
        if (i10 == 0) {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text));
        } else if (i10 == 1) {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text_long));
        } else {
            if (i10 != 2) {
                StringBuilder sb3 = new StringBuilder(32);
                sb3.append("Unknown button size: ");
                sb3.append(i10);
                throw new IllegalStateException(sb3.toString());
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
