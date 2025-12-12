package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.R;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class l extends x0.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9067d;

    public l(MaterialCalendar materialCalendar) {
        this.f9067d = materialCalendar;
    }

    @Override // x0.a
    public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        MaterialCalendar materialCalendar = this.f9067d;
        dVar.setHintText(materialCalendar.f9015u0.getVisibility() == 0 ? materialCalendar.getString(R.string.mtrl_picker_toggle_to_year_selection) : materialCalendar.getString(R.string.mtrl_picker_toggle_to_day_selection));
    }
}
