package d4;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: HttpHeaderParser.java */
/* loaded from: classes.dex */
public final class e {
    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) throws NumberFormatException {
        boolean z10;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long dateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z10 = false;
            j10 = 0;
            j11 = 0;
            while (i10 < strArrSplit.length) {
                String strTrim = strArrSplit[i10].trim();
                if (strTrim.equals(HeaderConstants.CACHE_CONTROL_NO_CACHE) || strTrim.equals(HeaderConstants.CACHE_CONTROL_NO_STORE)) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j10 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j11 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE) || strTrim.equals(HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE)) {
                    z10 = true;
                }
                i10++;
            }
            i10 = 1;
        } else {
            z10 = false;
            j10 = 0;
            j11 = 0;
        }
        String str3 = map.get("Expires");
        long dateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long dateAsEpoch3 = str4 != null ? parseDateAsEpoch(str4) : 0L;
        String str5 = map.get("ETag");
        if (i10 != 0) {
            j13 = jCurrentTimeMillis + (j10 * 1000);
            if (z10) {
                j14 = j13;
            } else {
                Long.signum(j11);
                j14 = (j11 * 1000) + j13;
            }
            j12 = j14;
        } else {
            j12 = 0;
            if (dateAsEpoch <= 0 || dateAsEpoch2 < dateAsEpoch) {
                j13 = 0;
            } else {
                j13 = jCurrentTimeMillis + (dateAsEpoch2 - dateAsEpoch);
                j12 = j13;
            }
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str5;
        entry.softTtl = j13;
        entry.ttl = j12;
        entry.serverDate = dateAsEpoch;
        entry.lastModified = dateAsEpoch3;
        entry.responseHeaders = map;
        entry.allResponseHeaders = networkResponse.allHeaders;
        return entry;
    }

    public static String parseCharset(Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get("Content-Type")) != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                String[] strArrSplit2 = strArrSplit[i10].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e10) {
            if ("0".equals(str) || "-1".equals(str)) {
                VolleyLog.v("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            VolleyLog.e(e10, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, "ISO-8859-1");
    }
}
