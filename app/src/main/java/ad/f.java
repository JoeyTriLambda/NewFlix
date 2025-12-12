package ad;

import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: TimeFormatUtil.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f632a;

    /* renamed from: b, reason: collision with root package name */
    public static final Formatter f633b;

    static {
        StringBuilder sb2 = new StringBuilder();
        f632a = sb2;
        f633b = new Formatter(sb2, Locale.getDefault());
    }

    public static String formatMs(long j10) {
        if (j10 < 0) {
            return "--:--";
        }
        long j11 = (j10 % DateUtils.MILLIS_PER_MINUTE) / 1000;
        long j12 = (j10 % DateUtils.MILLIS_PER_HOUR) / DateUtils.MILLIS_PER_MINUTE;
        long j13 = (j10 % DateUtils.MILLIS_PER_DAY) / DateUtils.MILLIS_PER_HOUR;
        f632a.setLength(0);
        Formatter formatter = f633b;
        return j13 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j13), Long.valueOf(j12), Long.valueOf(j11)).toString() : formatter.format("%02d:%02d", Long.valueOf(j12), Long.valueOf(j11)).toString();
    }
}
