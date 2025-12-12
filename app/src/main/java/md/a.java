package md;

import ac.c;
import d4.i;
import flix.com.vision.App;
import java.util.Random;
import ub.n0;

/* compiled from: hub.java */
/* loaded from: classes2.dex */
public final class a {
    public static String checkLinkLabel(String str) {
        String strB;
        String domainName = getDomainName(str);
        if (hasMultiRes(str)) {
            return c.j("1080p - 720p - 480p - ", domainName);
        }
        if (new Random().nextInt(10) > 2) {
            try {
                strB = "720p - [" + domainName + "]";
            } catch (Exception e10) {
                e10.printStackTrace();
                strB = "720p - [" + domainName + "]";
            }
        } else {
            try {
                strB = "1080p - [" + domainName + "]";
            } catch (Exception e11) {
                e11.printStackTrace();
                strB = "1080p - [" + domainName + "]";
            }
        }
        if (str.contains(".m3u8")) {
            strB = c.B(strB, "[HLS]");
        }
        return strB.replace("OPENLOAD", "OLOAD");
    }

    public static void fetchTMDBAPI() {
        if (App.getInstance().f11574v.getString("tmdb_base_url", null) == null) {
            App.getInstance().f11574v.edit().putString("tmdb_base_url", "http://image.tmdb.org/t/p/").apply();
        }
        App.getInstance().addToRequestQueue(new i(0, "https://api.themoviedb.org/3/configuration?api_key=2f3cb5763db1117fcba3948632f8aad9", null, new n0(27), new n0(28)), "TMDBAPIREQ");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDomainName(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "google"
            boolean r1 = r4.contains(r1)
            if (r1 != 0) goto L5f
            java.lang.String r1 = "blogspot"
            boolean r1 = r4.contains(r1)
            if (r1 == 0) goto L13
            goto L5f
        L13:
            r1 = 2
            java.net.URI r2 = new java.net.URI     // Catch: java.lang.Exception -> L2d
            r2.<init>(r4)     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = r2.getHost()     // Catch: java.lang.Exception -> L2d
            java.lang.String r3 = "www."
            boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Exception -> L2b
            if (r3 == 0) goto L3f
            r3 = 4
            java.lang.String r2 = r2.substring(r3)     // Catch: java.lang.Exception -> L2b
            goto L3f
        L2b:
            r3 = move-exception
            goto L2f
        L2d:
            r3 = move-exception
            r2 = r0
        L2f:
            r3.printStackTrace()
            java.lang.String r3 = "/"
            java.lang.String[] r4 = r4.split(r3)     // Catch: java.lang.Exception -> L3b
            r2 = r4[r1]     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r4 = move-exception
            r4.printStackTrace()
        L3f:
            if (r2 != 0) goto L42
            goto L43
        L42:
            r0 = r2
        L43:
            java.lang.String r4 = "."
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L5a
            java.lang.String r4 = "\\."
            java.lang.String[] r4 = r0.split(r4)     // Catch: java.lang.Exception -> L56
            int r2 = r4.length     // Catch: java.lang.Exception -> L56
            int r2 = r2 - r1
            r0 = r4[r2]     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r4 = move-exception
            r4.printStackTrace()
        L5a:
            java.lang.String r4 = r0.toUpperCase()
            return r4
        L5f:
            java.lang.String r4 = "GOOGLEVIDEO"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: md.a.getDomainName(java.lang.String):java.lang.String");
    }

    public static boolean hasMultiRes(String str) {
        return str != null && str.toLowerCase().contains("2embed");
    }
}
