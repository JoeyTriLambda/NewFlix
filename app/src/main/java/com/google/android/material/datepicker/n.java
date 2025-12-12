package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class n implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9071b;

    public n(MaterialCalendar materialCalendar) {
        this.f9071b = materialCalendar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MaterialCalendar materialCalendar = this.f9071b;
        MaterialCalendar.CalendarSelector calendarSelector = materialCalendar.f9008n0;
        MaterialCalendar.CalendarSelector calendarSelector2 = MaterialCalendar.CalendarSelector.YEAR;
        MaterialCalendar.CalendarSelector calendarSelector3 = MaterialCalendar.CalendarSelector.DAY;
        if (calendarSelector == calendarSelector2) {
            materialCalendar.p(calendarSelector3);
        } else if (calendarSelector == calendarSelector3) {
            materialCalendar.p(calendarSelector2);
        }
    }
}
