package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

/* compiled from: DayViewDecorator.java */
/* loaded from: classes.dex */
public abstract class f implements Parcelable {
    public ColorStateList getBackgroundColor(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        return null;
    }

    public Drawable getCompoundDrawableBottom(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        return null;
    }

    public Drawable getCompoundDrawableLeft(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        return null;
    }

    public Drawable getCompoundDrawableRight(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        return null;
    }

    public Drawable getCompoundDrawableTop(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        return null;
    }

    public ColorStateList getTextColor(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        return null;
    }

    public void initialize(Context context) {
    }

    public CharSequence getContentDescription(Context context, int i10, int i11, int i12, boolean z10, boolean z11, CharSequence charSequence) {
        return charSequence;
    }
}
