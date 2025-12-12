package com.google.android.material.datepicker;

import android.view.View;
import x0.y0;

/* compiled from: MaterialDatePicker.java */
/* loaded from: classes.dex */
public final class q implements x0.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9081a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9082b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9083c;

    public q(int i10, View view, int i11) {
        this.f9081a = i10;
        this.f9082b = view;
        this.f9083c = i11;
    }

    @Override // x0.v
    public y0 onApplyWindowInsets(View view, y0 y0Var) {
        int i10 = y0Var.getInsets(y0.m.systemBars()).f16885b;
        View view2 = this.f9082b;
        int i11 = this.f9081a;
        if (i11 >= 0) {
            view2.getLayoutParams().height = i11 + i10;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.f9083c + i10, view2.getPaddingRight(), view2.getPaddingBottom());
        return y0Var;
    }
}
