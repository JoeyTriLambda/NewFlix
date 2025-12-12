package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;

/* compiled from: YearGridAdapter.java */
/* loaded from: classes.dex */
public final class b0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9043b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c0 f9044m;

    public b0(c0 c0Var, int i10) {
        this.f9044m = c0Var;
        this.f9043b = i10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c0 c0Var = this.f9044m;
        t tVarA = t.a(this.f9043b, c0Var.f9053d.f9007m0.f9089m);
        a aVar = c0Var.f9053d.f9005k0;
        t tVar = aVar.f9022b;
        if (tVarA.compareTo(tVar) < 0) {
            tVarA = tVar;
        } else {
            t tVar2 = aVar.f9023m;
            if (tVarA.compareTo(tVar2) > 0) {
                tVarA = tVar2;
            }
        }
        c0Var.f9053d.o(tVarA);
        c0Var.f9053d.p(MaterialCalendar.CalendarSelector.DAY);
    }
}
