package hc;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Util.java */
/* loaded from: classes2.dex */
public final class c {
    public static String getDurationString(long j10, boolean z10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j10);
        long minutes = timeUnit.toMinutes(j10);
        long seconds = timeUnit.toSeconds(j10);
        if (hours <= 0) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = z10 ? "-" : "";
            objArr[1] = Long.valueOf(minutes);
            objArr[2] = Long.valueOf(seconds - TimeUnit.MINUTES.toSeconds(minutes));
            return String.format(locale, "%s%02d:%02d", objArr);
        }
        Locale locale2 = Locale.getDefault();
        Object[] objArr2 = new Object[4];
        objArr2[0] = z10 ? "-" : "";
        objArr2[1] = Long.valueOf(hours);
        objArr2[2] = Long.valueOf(minutes - TimeUnit.HOURS.toMinutes(hours));
        objArr2[3] = Long.valueOf(seconds - TimeUnit.MINUTES.toSeconds(minutes));
        return String.format(locale2, "%s%02d:%02d:%02d", objArr2);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static Drawable resolveDrawable(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getDrawable(0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
