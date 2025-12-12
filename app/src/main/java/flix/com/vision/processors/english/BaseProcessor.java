package flix.com.vision.processors.english;

import a2.x;
import ac.c;
import android.annotation.SuppressLint;
import android.content.Context;
import bd.b;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import d4.m;
import flix.com.vision.App;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import gd.f;
import hd.o;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import qd.e;

/* loaded from: classes2.dex */
public abstract class BaseProcessor {

    /* renamed from: b, reason: collision with root package name */
    public f f12431b;

    /* renamed from: c, reason: collision with root package name */
    public Context f12432c;

    /* renamed from: a, reason: collision with root package name */
    public int f12430a = 5;

    /* renamed from: d, reason: collision with root package name */
    public String f12433d = "";

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque<Integer> f12434e = new ArrayDeque<>();

    public enum TorrentServiceType {
        REAL_DEBRID,
        PREMIUMIZE,
        ALL_DEBRID
    }

    public class a extends m {

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f12439n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, x xVar, pd.a aVar, String str2) {
            super(1, str, xVar, aVar);
            this.f12439n = str2;
        }

        @Override // com.android.volley.Request
        public String getBodyContentType() {
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            return c.w("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getParams() {
            HashMap map = new HashMap();
            map.put("src", this.f12439n);
            return map;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isEnglishlang(java.lang.String r9, java.lang.String r10) {
        /*
            r0 = 1
            if (r9 == 0) goto L74
            int r1 = r9.length()
            r2 = 10
            if (r1 >= r2) goto Lc
            goto L74
        Lc:
            java.lang.String r9 = r9.toLowerCase()
            java.lang.String[] r1 = flix.com.vision.helpers.Constants.f12325g
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L15:
            if (r4 >= r2) goto L74
            r5 = r1[r4]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "."
            r6.<init>(r7)
            r6.append(r5)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            boolean r6 = r9.contains(r6)
            java.lang.String r7 = " "
            if (r6 != 0) goto L4b
            java.lang.String r6 = r9.toLowerCase()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r5)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            boolean r6 = r6.contains(r8)
            if (r6 == 0) goto L71
        L4b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            r6.append(r5)
            r6.append(r7)
            java.lang.String r5 = r6.toString()
            boolean r5 = r10.contains(r5)
            if (r5 != 0) goto L71
            java.lang.String r5 = "eng"
            boolean r5 = r9.contains(r5)
            if (r5 != 0) goto L71
            java.lang.String r5 = "english"
            boolean r5 = r9.contains(r5)
            if (r5 != 0) goto L71
            return r3
        L71:
            int r4 = r4 + 1
            goto L15
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.processors.english.BaseProcessor.isEnglishlang(java.lang.String, java.lang.String):boolean");
    }

    public static String removeSpecialCharsOld(String str) {
        return str.replaceAll("[-+.^:,]", "");
    }

    public final void a(int i10) {
        bc.a.getMagnetStatusAllDebrid(i10 + "").observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new r7.f(this, i10), new o1.a(i10));
    }

    public void addLink(o oVar) {
        if (oVar.f13044t && oVar.f13036b == null) {
            oVar.f13036b = getOriginalName(oVar.D);
        }
        if (oVar.f13044t || !(oVar.D.contains("streamango") || oVar.D.contains("rapidvideo") || oVar.D.contains("vidcloud") || oVar.D.contains("loadvid") || oVar.C.toLowerCase().contains("hydrax"))) {
            String str = oVar.D;
            if (str != null && str.contains("mixdrop")) {
                oVar.f13044t = true;
            }
            if (!oVar.f13047w && oVar.isDoodlink()) {
                new b(this.f12432c, this.f12431b).fetchLinks(oVar);
                return;
            }
            if (!oVar.f13047w && oVar.isFileMoonlink()) {
                new bd.c(this.f12432c, this.f12431b).fetchLinks(oVar);
                return;
            }
            if (oVar.F) {
                oVar.C = c.o(new StringBuilder(), oVar.C, "- [EMBED]");
                if (oVar.f13046v) {
                    oVar.C = c.o(new StringBuilder(), oVar.C, "- [HINDI]");
                }
                this.f12431b.OnSuccess(oVar);
                return;
            }
            if (oVar.D.contains("openload") || oVar.D.contains("oload.")) {
                oVar.F = true;
                oVar.C = c.o(new StringBuilder(), oVar.C, "- [EMBED]");
            } else if (oVar.D.contains("embed") || oVar.D.contains("viduplayer")) {
                oVar.F = true;
                oVar.C = c.o(new StringBuilder(), oVar.C, "- [EMBED]");
                this.f12431b.OnSuccess(oVar);
                return;
            }
            this.f12431b.OnSuccess(oVar);
        }
    }

    @SuppressLint({"CheckResult"})
    public void addMagnetsAllDebrid(List<String> list) {
        bc.a.addMagnetAllDebrid(list).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new e(this, 0), new pd.a(2));
    }

    public String checkLinkLabel(String str) {
        String strB;
        String domainName = getDomainName(str);
        int iNextInt = new Random().nextInt(10);
        if (iNextInt == 1) {
            try {
                strB = "480p - [" + domainName + "]";
            } catch (Exception e10) {
                e10.printStackTrace();
                strB = "480p - [" + domainName + "]";
            }
        } else if (iNextInt > 3) {
            try {
                strB = "720p - [" + domainName + "]";
            } catch (Exception e11) {
                e11.printStackTrace();
                strB = "720p - [" + domainName + "]";
            }
        } else {
            try {
                strB = "1080p - [" + domainName + "]";
            } catch (Exception e12) {
                e12.printStackTrace();
                strB = "1080p - [" + domainName + "]";
            }
        }
        if (str.contains(".m3u8")) {
            strB = c.B(strB, "[HLS]");
        }
        return strB.replace("OPENLOAD", "OLOAD");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getDomainName(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "google"
            boolean r1 = r5.contains(r1)
            if (r1 != 0) goto L5f
            java.lang.String r1 = "blogspot"
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L13
            goto L5f
        L13:
            r1 = 2
            java.net.URI r2 = new java.net.URI     // Catch: java.lang.Exception -> L2d
            r2.<init>(r5)     // Catch: java.lang.Exception -> L2d
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
            java.lang.String[] r5 = r5.split(r3)     // Catch: java.lang.Exception -> L3b
            r2 = r5[r1]     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r5 = move-exception
            r5.printStackTrace()
        L3f:
            if (r2 != 0) goto L42
            goto L43
        L42:
            r0 = r2
        L43:
            java.lang.String r5 = "."
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L5a
            java.lang.String r5 = "\\."
            java.lang.String[] r5 = r0.split(r5)     // Catch: java.lang.Exception -> L56
            int r2 = r5.length     // Catch: java.lang.Exception -> L56
            int r2 = r2 - r1
            r0 = r5[r2]     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r5 = move-exception
            r5.printStackTrace()
        L5a:
            java.lang.String r5 = r0.toUpperCase()
            return r5
        L5f:
            java.lang.String r5 = "GOOGLEVIDEO"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.processors.english.BaseProcessor.getDomainName(java.lang.String):java.lang.String");
    }

    public String getEvalScriptFromHTML(Document document) {
        try {
            Elements elementsByTag = document.getElementsByTag("SCRIPT");
            for (int i10 = 0; i10 < elementsByTag.size(); i10++) {
                String string = elementsByTag.get(i10).toString();
                if (string.contains("function(p,a,c,k,e,d)")) {
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void getMagnetPrem(String str) {
        App.getInstance().getRequestQueue().add(new a(c.j("https://www.premiumize.me/api/transfer/directdl?apikey=", PremiumizeCommon.f12046m), new x(11, this, str), new pd.a(1), str));
    }

    public String getOriginalName(String str) {
        try {
            String str2 = str.split("/")[r4.length - 1];
            if (!str2.contains("magnet")) {
                return str2;
            }
            String[] strArrSplit = str2.split("=");
            return strArrSplit.length > 2 ? strArrSplit[2].replace("&tr", "") : str2;
        } catch (Exception unused) {
            return null;
        }
    }

    public String removeSpecialChars(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    public void unlockLinkAllRebrid(String str) {
        bc.a.unlockLinkAllDebrid(str).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new e(this, 1), new pd.a(3));
    }
}
