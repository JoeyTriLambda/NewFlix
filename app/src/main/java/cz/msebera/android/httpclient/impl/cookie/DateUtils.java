package cz.msebera.android.httpclient.impl.cookie;

import ac.c;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

@Deprecated
/* loaded from: classes2.dex */
public final class DateUtils {
    public static final TimeZone GMT = TimeZone.getTimeZone(TimeZones.GMT_ID);
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateUtils() {
    }

    public static String formatDate(Date date) {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(date);
    }

    public static Date parseDate(String str) throws DateParseException {
        return parseDate(str, null, null);
    }

    public static String formatDate(Date date, String str) {
        return cz.msebera.android.httpclient.client.utils.DateUtils.formatDate(date, str);
    }

    public static Date parseDate(String str, String[] strArr) throws DateParseException {
        return parseDate(str, strArr, null);
    }

    public static Date parseDate(String str, String[] strArr, Date date) throws DateParseException {
        Date date2 = cz.msebera.android.httpclient.client.utils.DateUtils.parseDate(str, strArr, date);
        if (date2 != null) {
            return date2;
        }
        throw new DateParseException(c.j("Unable to parse the date ", str));
    }
}
