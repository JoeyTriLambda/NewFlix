package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: MaxInputValidator.java */
/* loaded from: classes.dex */
public final class b implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final int f9501a;

    public b(int i10) {
        this.f9501a = i10;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        try {
            StringBuilder sb2 = new StringBuilder(spanned);
            sb2.replace(i12, i13, charSequence.subSequence(i10, i11).toString());
            if (Integer.parseInt(sb2.toString()) <= this.f9501a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
