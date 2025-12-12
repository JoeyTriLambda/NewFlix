package androidx.leanback.widget.picker;

import android.content.res.Resources;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: PickerUtility.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: PickerUtility.java */
    /* renamed from: androidx.leanback.widget.picker.a$a, reason: collision with other inner class name */
    public static class C0029a {

        /* renamed from: a, reason: collision with root package name */
        public final Locale f3321a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f3322b;

        public C0029a(Locale locale) {
            this.f3321a = locale;
            this.f3322b = DateFormatSymbols.getInstance(locale).getShortMonths();
            Calendar calendar = Calendar.getInstance(locale);
            a.createStringIntArrays(calendar.getMinimum(5), calendar.getMaximum(5), "%02d");
        }
    }

    public static String[] createStringIntArrays(int i10, int i11, String str) {
        String[] strArr = new String[(i11 - i10) + 1];
        for (int i12 = i10; i12 <= i11; i12++) {
            if (str != null) {
                strArr[i12 - i10] = String.format(str, Integer.valueOf(i12));
            } else {
                strArr[i12 - i10] = String.valueOf(i12);
            }
        }
        return strArr;
    }

    public static Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public static C0029a getDateConstantInstance(Locale locale, Resources resources) {
        return new C0029a(locale);
    }
}
