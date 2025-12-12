package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f9060b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9061m;

    public h(MaterialCalendar materialCalendar, v vVar) {
        this.f9061m = materialCalendar;
        this.f9060b = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialCalendar materialCalendar = this.f9061m;
        int iFindLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.f9011q0.getLayoutManager()).findLastVisibleItemPosition() - 1;
        if (iFindLastVisibleItemPosition >= 0) {
            Calendar calendarC = a0.c(this.f9060b.f9103d.f9022b.f9088b);
            calendarC.add(2, iFindLastVisibleItemPosition);
            materialCalendar.o(new t(calendarC));
        }
    }
}
