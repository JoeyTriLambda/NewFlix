package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class m extends RecyclerView.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f9068a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f9069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9070c;

    public m(MaterialCalendar materialCalendar, v vVar, MaterialButton materialButton) {
        this.f9070c = materialCalendar;
        this.f9068a = vVar;
        this.f9069b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if (i10 == 0) {
            recyclerView.announceForAccessibility(this.f9069b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        MaterialCalendar materialCalendar = this.f9070c;
        int iFindFirstVisibleItemPosition = i10 < 0 ? ((LinearLayoutManager) materialCalendar.f9011q0.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) materialCalendar.f9011q0.getLayoutManager()).findLastVisibleItemPosition();
        v vVar = this.f9068a;
        Calendar calendarC = a0.c(vVar.f9103d.f9022b.f9088b);
        calendarC.add(2, iFindFirstVisibleItemPosition);
        materialCalendar.f9007m0 = new t(calendarC);
        Calendar calendarC2 = a0.c(vVar.f9103d.f9022b.f9088b);
        calendarC2.add(2, iFindFirstVisibleItemPosition);
        calendarC2.set(5, 1);
        Calendar calendarC3 = a0.c(calendarC2);
        calendarC3.get(2);
        calendarC3.get(1);
        calendarC3.getMaximum(7);
        calendarC3.getActualMaximum(5);
        calendarC3.getTimeInMillis();
        long timeInMillis = calendarC3.getTimeInMillis();
        this.f9069b.setText(Build.VERSION.SDK_INT >= 24 ? a0.b("yMMMM", Locale.getDefault()).format(new Date(timeInMillis)) : DateUtils.formatDateTime(null, timeInMillis, 8228));
    }
}
