package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f9072b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9073m;

    public o(MaterialCalendar materialCalendar, v vVar) {
        this.f9073m = materialCalendar;
        this.f9072b = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialCalendar materialCalendar = this.f9073m;
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) materialCalendar.f9011q0.getLayoutManager()).findFirstVisibleItemPosition() + 1;
        if (iFindFirstVisibleItemPosition < materialCalendar.f9011q0.getAdapter().getItemCount()) {
            Calendar calendarC = a0.c(this.f9072b.f9103d.f9022b.f9088b);
            calendarC.add(2, iFindFirstVisibleItemPosition);
            materialCalendar.o(new t(calendarC));
        }
    }
}
