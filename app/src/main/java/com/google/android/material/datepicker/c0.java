package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: YearGridAdapter.java */
/* loaded from: classes.dex */
public final class c0 extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name */
    public final MaterialCalendar<?> f9053d;

    /* compiled from: YearGridAdapter.java */
    public static class a extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final TextView f9054u;

        public a(TextView textView) {
            super(textView);
            this.f9054u = textView;
        }
    }

    public c0(MaterialCalendar<?> materialCalendar) {
        this.f9053d = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9053d.f9005k0.f9027q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i10) {
        MaterialCalendar<?> materialCalendar = this.f9053d;
        int i11 = materialCalendar.f9005k0.f9022b.f9090n + i10;
        aVar.f9054u.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i11)));
        TextView textView = aVar.f9054u;
        Context context = textView.getContext();
        textView.setContentDescription(a0.d().get(1) == i11 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i11)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i11)));
        c cVar = materialCalendar.f9009o0;
        Calendar calendarD = a0.d();
        b bVar = calendarD.get(1) == i11 ? cVar.f9050f : cVar.f9048d;
        Iterator<Long> it = materialCalendar.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarD.setTimeInMillis(it.next().longValue());
            if (calendarD.get(1) == i11) {
                bVar = cVar.f9049e;
            }
        }
        bVar.b(textView, null, null);
        textView.setOnClickListener(new b0(this, i11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
