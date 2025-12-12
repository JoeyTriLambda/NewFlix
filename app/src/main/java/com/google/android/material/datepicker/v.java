package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import x0.j0;

/* compiled from: MonthsPagerAdapter.java */
/* loaded from: classes.dex */
public final class v extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.material.datepicker.a f9103d;

    /* renamed from: e, reason: collision with root package name */
    public final d<?> f9104e;

    /* renamed from: f, reason: collision with root package name */
    public final f f9105f;

    /* renamed from: g, reason: collision with root package name */
    public final MaterialCalendar.d f9106g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9107h;

    /* compiled from: MonthsPagerAdapter.java */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f9108b;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f9108b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            MaterialCalendarGridView materialCalendarGridView = this.f9108b;
            u adapter = materialCalendarGridView.getAdapter();
            if (i10 >= adapter.a() && i10 <= (adapter.a() + adapter.f9097b.f9092p) + (-1)) {
                ((MaterialCalendar.c) v.this.f9106g).onDayClick(materialCalendarGridView.getAdapter().getItem(i10).longValue());
            }
        }
    }

    /* compiled from: MonthsPagerAdapter.java */
    public static class b extends RecyclerView.z {

        /* renamed from: u, reason: collision with root package name */
        public final TextView f9110u;

        /* renamed from: v, reason: collision with root package name */
        public final MaterialCalendarGridView f9111v;

        public b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f9110u = textView;
            j0.setAccessibilityHeading(textView, true);
            this.f9111v = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z10) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public v(ContextThemeWrapper contextThemeWrapper, d dVar, com.google.android.material.datepicker.a aVar, f fVar, MaterialCalendar.c cVar) {
        t tVar = aVar.f9022b;
        t tVar2 = aVar.f9025o;
        if (tVar.compareTo(tVar2) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (tVar2.compareTo(aVar.f9023m) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int i10 = u.f9095r;
        int i11 = MaterialCalendar.f9002v0;
        Resources resources = contextThemeWrapper.getResources();
        int i12 = R.dimen.mtrl_calendar_day_height;
        this.f9107h = (resources.getDimensionPixelSize(i12) * i10) + (p.q(contextThemeWrapper) ? contextThemeWrapper.getResources().getDimensionPixelSize(i12) : 0);
        this.f9103d = aVar;
        this.f9104e = dVar;
        this.f9105f = fVar;
        this.f9106g = cVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9103d.f9028r;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        Calendar calendarC = a0.c(this.f9103d.f9022b.f9088b);
        calendarC.add(2, i10);
        return new t(calendarC).f9088b.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b bVar, int i10) {
        com.google.android.material.datepicker.a aVar = this.f9103d;
        Calendar calendarC = a0.c(aVar.f9022b.f9088b);
        calendarC.add(2, i10);
        t tVar = new t(calendarC);
        bVar.f9110u.setText(tVar.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f9111v.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !tVar.equals(materialCalendarGridView.getAdapter().f9097b)) {
            u uVar = new u(tVar, this.f9104e, aVar, this.f9105f);
            materialCalendarGridView.setNumColumns(tVar.f9091o);
            materialCalendarGridView.setAdapter((ListAdapter) uVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().updateSelectedStates(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!p.q(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.m(-1, this.f9107h));
        return new b(linearLayout, true);
    }
}
