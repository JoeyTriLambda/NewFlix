package i6;

import android.text.TextUtils;
import android.util.Log;
import i6.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.l;
import org.apache.commons.lang3.StringUtils;

/* compiled from: WebvttCueParser.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f13248b = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f13249c = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f13250a = new StringBuilder();

    /* compiled from: WebvttCueParser.java */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f13251e = new String[0];

        /* renamed from: a, reason: collision with root package name */
        public final String f13252a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13253b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13254c;

        /* renamed from: d, reason: collision with root package name */
        public final String[] f13255d;

        public a(String str, int i10, String str2, String[] strArr) {
            this.f13253b = i10;
            this.f13252a = str;
            this.f13254c = str2;
            this.f13255d = strArr;
        }

        public static a buildStartTag(String str, int i10) {
            String str2;
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return null;
            }
            int iIndexOf = strTrim.indexOf(StringUtils.SPACE);
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrSplit = strTrim.split("\\.");
            return new a(strArrSplit[0], i10, str2, strArrSplit.length > 1 ? (String[]) Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length) : f13251e);
        }

        public static a buildWholeCueVirtualTag() {
            return new a("", 0, "", new String[0]);
        }
    }

    /* compiled from: WebvttCueParser.java */
    public static final class b implements Comparable<b> {

        /* renamed from: b, reason: collision with root package name */
        public final int f13256b;

        /* renamed from: m, reason: collision with root package name */
        public final d f13257m;

        public b(int i10, d dVar) {
            this.f13256b = i10;
            this.f13257m = dVar;
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            return this.f13256b - bVar.f13256b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r16, i6.f.a r17, android.text.SpannableStringBuilder r18, java.util.List r19, java.util.ArrayList r20) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.f.a(java.lang.String, i6.f$a, android.text.SpannableStringBuilder, java.util.List, java.util.ArrayList):void");
    }

    public static boolean b(String str, Matcher matcher, l lVar, e.b bVar, StringBuilder sb2, ArrayList arrayList) throws NumberFormatException {
        try {
            bVar.setStartTime(h.parseTimestampUs(matcher.group(1))).setEndTime(h.parseTimestampUs(matcher.group(2)));
            c(matcher.group(3), bVar);
            sb2.setLength(0);
            while (true) {
                String line = lVar.readLine();
                if (TextUtils.isEmpty(line)) {
                    d(str, sb2.toString(), bVar, arrayList);
                    return true;
                }
                if (sb2.length() > 0) {
                    sb2.append(StringUtils.LF);
                }
                sb2.append(line.trim());
            }
        } catch (NumberFormatException unused) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r10, i6.e.b r11) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.f.c(java.lang.String, i6.e$b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(java.lang.String r16, java.lang.String r17, i6.e.b r18, java.util.List<i6.d> r19) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.f.d(java.lang.String, java.lang.String, i6.e$b, java.util.List):void");
    }

    public static int e(String str) {
        str.getClass();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                Log.w("WebvttCueParser", "Invalid anchor value: ".concat(str));
                return Integer.MIN_VALUE;
        }
    }
}
