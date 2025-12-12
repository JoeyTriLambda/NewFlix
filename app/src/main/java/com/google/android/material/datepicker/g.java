package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: DaysOfWeekAdapter.java */
/* loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* renamed from: o, reason: collision with root package name */
    public static final int f9056o;

    /* renamed from: b, reason: collision with root package name */
    public final Calendar f9057b;

    /* renamed from: m, reason: collision with root package name */
    public final int f9058m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9059n;

    static {
        f9056o = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar calendarE = a0.e(null);
        this.f9057b = calendarE;
        this.f9058m = calendarE.getMaximum(7);
        this.f9059n = calendarE.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9058m;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i11 = i10 + this.f9059n;
        int i12 = this.f9058m;
        if (i11 > i12) {
            i11 -= i12;
        }
        Calendar calendar = this.f9057b;
        calendar.set(7, i11);
        textView.setText(calendar.getDisplayName(7, f9056o, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    @Override // android.widget.Adapter
    public Integer getItem(int i10) {
        int i11 = this.f9058m;
        if (i10 >= i11) {
            return null;
        }
        int i12 = i10 + this.f9059n;
        if (i12 > i11) {
            i12 -= i11;
        }
        return Integer.valueOf(i12);
    }

    public g(int i10) {
        Calendar calendarE = a0.e(null);
        this.f9057b = calendarE;
        this.f9058m = calendarE.getMaximum(7);
        this.f9059n = i10;
    }
}
