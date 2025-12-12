package com.google.android.material.datepicker;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9062b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f9063m;

    public i(MaterialCalendar materialCalendar, int i10) {
        this.f9063m = materialCalendar;
        this.f9062b = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9063m.f9011q0.smoothScrollToPosition(this.f9062b);
    }
}
