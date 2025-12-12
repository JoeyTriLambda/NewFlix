package okhttp3;

import ac.c;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.SM;
import ig.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mf.k;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import zf.f;
import zf.i;

/* compiled from: Cookie.kt */
/* loaded from: classes2.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: Cookie.kt */
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j10 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j10, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String str) {
            i.checkNotNullParameter(str, ClientCookie.DOMAIN_ATTR);
            return domain(str, false);
        }

        public final Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > DatesKt.MAX_DATE) {
                j10 = 253402300799999L;
            }
            this.expiresAt = j10;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            i.checkNotNullParameter(str, ClientCookie.DOMAIN_ATTR);
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            if (!i.areEqual(StringsKt__StringsKt.trim(str).toString(), str)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.name = str;
            return this;
        }

        public final Builder path(String str) {
            i.checkNotNullParameter(str, ClientCookie.PATH_ATTR);
            if (!l.startsWith$default(str, "/", false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.path = str;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            i.checkNotNullParameter(str, "value");
            if (!i.areEqual(StringsKt__StringsKt.trim(str).toString(), str)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.value = str;
            return this;
        }

        private final Builder domain(String str, boolean z10) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(i.stringPlus("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z10;
            return this;
        }
    }

    /* compiled from: Cookie.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final int dateCharacterOffset(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L0:
                if (r7 >= r8) goto L49
                int r0 = r7 + 1
                char r1 = r6.charAt(r7)
                r2 = 32
                r3 = 1
                if (r1 >= r2) goto L11
                r2 = 9
                if (r1 != r2) goto L41
            L11:
                r2 = 127(0x7f, float:1.78E-43)
                if (r1 >= r2) goto L41
                r2 = 57
                r4 = 0
                if (r1 > r2) goto L20
                r2 = 48
                if (r2 > r1) goto L20
                r2 = 1
                goto L21
            L20:
                r2 = 0
            L21:
                if (r2 != 0) goto L41
                r2 = 122(0x7a, float:1.71E-43)
                if (r1 > r2) goto L2d
                r2 = 97
                if (r2 > r1) goto L2d
                r2 = 1
                goto L2e
            L2d:
                r2 = 0
            L2e:
                if (r2 != 0) goto L41
                r2 = 90
                if (r1 > r2) goto L3a
                r2 = 65
                if (r2 > r1) goto L3a
                r2 = 1
                goto L3b
            L3a:
                r2 = 0
            L3b:
                if (r2 != 0) goto L41
                r2 = 58
                if (r1 != r2) goto L42
            L41:
                r4 = 1
            L42:
                r1 = r9 ^ 1
                if (r4 != r1) goto L47
                return r7
            L47:
                r7 = r0
                goto L0
            L49:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.dateCharacterOffset(java.lang.String, int, int, boolean):int");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (i.areEqual(str, str2)) {
                return true;
            }
            return l.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            if (!(!l.endsWith$default(str, ".", false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.removePrefix(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i10, int i11) throws NumberFormatException {
            int iDateCharacterOffset = dateCharacterOffset(str, i10, i11, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int iIndexOf$default = -1;
            int i15 = -1;
            int i16 = -1;
            while (iDateCharacterOffset < i11) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i11, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i13 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    i.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
                    i13 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    i.checkNotNullExpressionValue(strGroup2, "matcher.group(2)");
                    i15 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    i.checkNotNullExpressionValue(strGroup3, "matcher.group(3)");
                    i16 = Integer.parseInt(strGroup3);
                } else if (i14 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    i.checkNotNullExpressionValue(strGroup4, "matcher.group(1)");
                    i14 = Integer.parseInt(strGroup4);
                } else if (iIndexOf$default == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    i.checkNotNullExpressionValue(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    i.checkNotNullExpressionValue(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    i.checkNotNullExpressionValue(strPattern, "MONTH_PATTERN.pattern()");
                    iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i12 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    i.checkNotNullExpressionValue(strGroup6, "matcher.group(1)");
                    i12 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i11, false);
            }
            if (70 <= i12 && i12 < 100) {
                i12 += 1900;
            }
            if (i12 >= 0 && i12 < 70) {
                i12 += 2000;
            }
            if (!(i12 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iIndexOf$default != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i14 && i14 < 32)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i13 >= 0 && i13 < 24)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i15 >= 0 && i15 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i16 >= 0 && i16 < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i12);
            gregorianCalendar.set(2, iIndexOf$default - 1);
            gregorianCalendar.set(5, i14);
            gregorianCalendar.set(11, i13);
            gregorianCalendar.set(12, i15);
            gregorianCalendar.set(13, i16);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) throws NumberFormatException {
            try {
                long j10 = Long.parseLong(str);
                if (j10 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j10;
            } catch (NumberFormatException e10) {
                if (new Regex("-?\\d+").matches(str)) {
                    return l.startsWith$default(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (i.areEqual(strEncodedPath, str)) {
                return true;
            }
            return l.startsWith$default(strEncodedPath, str, false, 2, null) && (l.endsWith$default(str, "/", false, 2, null) || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            i.checkNotNullParameter(httpUrl, "url");
            i.checkNotNullParameter(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[PHI: r1
  0x00dc: PHI (r1v23 long) = (r1v8 long), (r1v11 long) binds: [B:45:0x00da, B:56:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.Cookie parse$okhttp(long r26, okhttp3.HttpUrl r28, java.lang.String r29) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 369
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            i.checkNotNullParameter(httpUrl, "url");
            i.checkNotNullParameter(headers, "headers");
            List<String> listValues = headers.values(SM.SET_COOKIE);
            int size = listValues.size();
            ArrayList arrayList = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                Cookie cookie = parse(httpUrl, listValues.get(i10));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
                i10 = i11;
            }
            if (arrayList == null) {
                return k.emptyList();
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            i.checkNotNullExpressionValue(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, f fVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m119deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m120deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m121deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m122deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m123deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m124deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m125deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m126deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m127deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (i.areEqual(cookie.name, this.name) && i.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && i.areEqual(cookie.domain, this.domain) && i.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int iB = c.b(this.value, c.b(this.name, 527, 31), 31);
        long j10 = this.expiresAt;
        return ((((((c.b(this.path, c.b(this.domain, (iB + ((int) (j10 ^ (j10 >>> 32)))) * 31, 31), 31) + (this.secure ? 1231 : 1237)) * 31) + (this.httpOnly ? 1231 : 1237)) * 31) + (this.persistent ? 1231 : 1237)) * 31) + (this.hostOnly ? 1231 : 1237);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        i.checkNotNullParameter(httpUrl, "url");
        if ((this.hostOnly ? i.areEqual(httpUrl.host(), this.domain) : Companion.domainMatch(httpUrl.host(), this.domain)) && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name());
        sb2.append('=');
        sb2.append(value());
        if (persistent()) {
            if (expiresAt() == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DatesKt.toHttpDateString(new Date(expiresAt())));
            }
        }
        if (!hostOnly()) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(domain());
        }
        sb2.append("; path=");
        sb2.append(path());
        if (secure()) {
            sb2.append("; secure");
        }
        if (httpOnly()) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "toString()");
        return string;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z10;
        this.httpOnly = z11;
        this.persistent = z12;
        this.hostOnly = z13;
    }
}
