package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MonthAdapter.java */
/* loaded from: classes.dex */
public final class u extends BaseAdapter {

    /* renamed from: r, reason: collision with root package name */
    public static final int f9095r = a0.e(null).getMaximum(4);

    /* renamed from: s, reason: collision with root package name */
    public static final int f9096s = (a0.e(null).getMaximum(7) + a0.e(null).getMaximum(5)) - 1;

    /* renamed from: b, reason: collision with root package name */
    public final t f9097b;

    /* renamed from: m, reason: collision with root package name */
    public final d<?> f9098m;

    /* renamed from: n, reason: collision with root package name */
    public Collection<Long> f9099n;

    /* renamed from: o, reason: collision with root package name */
    public c f9100o;

    /* renamed from: p, reason: collision with root package name */
    public final a f9101p;

    /* renamed from: q, reason: collision with root package name */
    public final f f9102q;

    public u(t tVar, d<?> dVar, a aVar, f fVar) {
        this.f9097b = tVar;
        this.f9098m = dVar;
        this.f9101p = aVar;
        this.f9102q = fVar;
        this.f9099n = dVar.getSelectedDays();
    }

    public final int a() {
        int firstDayOfWeek = this.f9101p.f9026p;
        t tVar = this.f9097b;
        Calendar calendar = tVar.f9088b;
        int i10 = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i11 = i10 - firstDayOfWeek;
        return i11 < 0 ? i11 + tVar.f9091o : i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.widget.TextView r19, long r20, int r22) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.u.b(android.widget.TextView, long, int):void");
    }

    public final void c(MaterialCalendarGridView materialCalendarGridView, long j10) {
        t tVarB = t.b(j10);
        t tVar = this.f9097b;
        if (tVarB.equals(tVar)) {
            Calendar calendarC = a0.c(tVar.f9088b);
            calendarC.setTimeInMillis(j10);
            int i10 = calendarC.get(5);
            b((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.getAdapter().a() + (i10 - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j10, i10);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f9096s;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f9097b.f9091o;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f9099n.iterator();
        while (it.hasNext()) {
            c(materialCalendarGridView, it.next().longValue());
        }
        d<?> dVar = this.f9098m;
        if (dVar != null) {
            Iterator<Long> it2 = dVar.getSelectedDays().iterator();
            while (it2.hasNext()) {
                c(materialCalendarGridView, it2.next().longValue());
            }
            this.f9099n = dVar.getSelectedDays();
        }
    }

    @Override // android.widget.Adapter
    public Long getItem(int i10) {
        if (i10 < a()) {
            return null;
        }
        int iA = a();
        t tVar = this.f9097b;
        if (i10 > (iA + tVar.f9092p) - 1) {
            return null;
        }
        int iA2 = (i10 - a()) + 1;
        Calendar calendarC = a0.c(tVar.f9088b);
        calendarC.set(5, iA2);
        return Long.valueOf(calendarC.getTimeInMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            com.google.android.material.datepicker.c r1 = r5.f9100o
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.c r1 = new com.google.android.material.datepicker.c
            r1.<init>(r0)
            r5.f9100o = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L26
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L26:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L5c
            com.google.android.material.datepicker.t r8 = r5.f9097b
            int r2 = r8.f9092p
            if (r7 < r2) goto L35
            goto L5c
        L35:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L65
        L5c:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L65:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6c
            return r0
        L6c:
            long r1 = r6.longValue()
            r5.b(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.u.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }
}
