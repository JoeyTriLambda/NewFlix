package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UtcDates.java */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference<z> f9036a = new AtomicReference<>();

    public static long a(long j10) {
        Calendar calendarE = e(null);
        calendarE.setTimeInMillis(j10);
        return c(calendarE).getTimeInMillis();
    }

    @TargetApi(24)
    public static DateFormat b(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    public static Calendar c(Calendar calendar) {
        Calendar calendarE = e(calendar);
        Calendar calendarE2 = e(null);
        calendarE2.set(calendarE.get(1), calendarE.get(2), calendarE.get(5));
        return calendarE2;
    }

    public static Calendar d() {
        z zVar = f9036a.get();
        if (zVar == null) {
            zVar = z.f9113c;
        }
        java.util.TimeZone timeZone = zVar.f9115b;
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = zVar.f9114a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return calendar;
    }

    public static Calendar e(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
