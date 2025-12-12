package okhttp3;

import com.fasterxml.jackson.core.JsonPointer;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.HttpHost;
import fg.a;
import fg.h;
import ig.l;
import ig.m;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mf.k;
import mf.z;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import tf.c;
import zf.f;
import zf.i;

/* compiled from: HttpUrl.kt */
/* loaded from: classes2.dex */
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: HttpUrl.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        /* compiled from: HttpUrl.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i10, int i11) throws NumberFormatException {
                try {
                    int i12 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i10, i11, "", false, false, false, false, null, 248, null));
                    boolean z10 = false;
                    if (1 <= i12 && i12 < 65536) {
                        z10 = true;
                    }
                    if (z10) {
                        return i12;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i10, int i11) {
                while (i10 < i11) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt == '[') {
                        do {
                            i10++;
                            if (i10 < i11) {
                            }
                        } while (str.charAt(i10) != ']');
                    } else if (cCharAt == ':') {
                        return i10;
                    }
                    i10++;
                }
                return i11;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i10, int i11) {
                if (i11 - i10 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i10);
                if ((i.compare((int) cCharAt, 97) < 0 || i.compare((int) cCharAt, 122) > 0) && (i.compare((int) cCharAt, 65) < 0 || i.compare((int) cCharAt, 90) > 0)) {
                    return -1;
                }
                int i12 = i10 + 1;
                while (i12 < i11) {
                    int i13 = i12 + 1;
                    char cCharAt2 = str.charAt(i12);
                    if (!(((((('a' <= cCharAt2 && cCharAt2 < '{') || ('A' <= cCharAt2 && cCharAt2 < '[')) || ('0' <= cCharAt2 && cCharAt2 < ':')) || cCharAt2 == '+') || cCharAt2 == '-') || cCharAt2 == '.')) {
                        if (cCharAt2 == ':') {
                            return i12;
                        }
                        return -1;
                    }
                    i12 = i13;
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    int i13 = i10 + 1;
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i12++;
                    i10 = i13;
                }
                return i12;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i10 = this.port;
            if (i10 != -1) {
                return i10;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            i.checkNotNull(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return i.areEqual(str, ".") || l.equals(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return i.areEqual(str, "..") || l.equals(str, "%2e.", true) || l.equals(str, ".%2e", true) || l.equals(str, "%2e%2e", true);
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void push(String str, int i10, int i11, boolean z10, boolean z11) {
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i10, i11, HttpUrl.PATH_SEGMENT_ENCODE_SET, z11, false, false, false, null, 240, null);
            if (isDot(strCanonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$okhttp$default);
            }
            if (z10) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            i.checkNotNull(list);
            int size = list.size() - 2;
            int progressionLastElement = c.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > size) {
                return;
            }
            while (true) {
                int i10 = size - 2;
                List<String> list2 = this.encodedQueryNamesAndValues;
                i.checkNotNull(list2);
                if (i.areEqual(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    i.checkNotNull(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    i.checkNotNull(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    i.checkNotNull(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == progressionLastElement) {
                    return;
                } else {
                    size = i10;
                }
            }
        }

        private final void resolvePath(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i10++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                while (i12 < i11) {
                    i10 = Util.delimiterOffset(str, "/\\", i12, i11);
                    boolean z10 = i10 < i11;
                    push(str, i12, i10, z10, true);
                    if (z10) {
                        i12 = i10 + 1;
                    }
                }
                return;
            }
        }

        public final Builder addEncodedPathSegment(String str) {
            i.checkNotNullParameter(str, "encodedPathSegment");
            push(str, 0, str.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String str) {
            i.checkNotNullParameter(str, "encodedPathSegments");
            return addPathSegments(str, true);
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            i.checkNotNullParameter(str, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            i.checkNotNull(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.Companion;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            i.checkNotNull(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(str2 == null ? null : Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder addPathSegment(String str) {
            i.checkNotNullParameter(str, "pathSegment");
            push(str, 0, str.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String str) {
            i.checkNotNullParameter(str, "pathSegments");
            return addPathSegments(str, false);
        }

        public final Builder addQueryParameter(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            i.checkNotNull(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.Companion;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            i.checkNotNull(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(str2 == null ? null : Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(mf.l.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 == null) {
                arrayList = null;
            } else {
                List<String> list3 = list2;
                arrayList = new ArrayList(mf.l.collectionSizeOrDefault(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null));
                }
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList2, arrayList, str4 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null), toString());
        }

        public final Builder encodedFragment(String str) {
            setEncodedFragment$okhttp(str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null));
            return this;
        }

        public final Builder encodedPassword(String str) {
            i.checkNotNullParameter(str, "encodedPassword");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        public final Builder encodedPath(String str) {
            i.checkNotNullParameter(str, "encodedPath");
            if (!l.startsWith$default(str, "/", false, 2, null)) {
                throw new IllegalArgumentException(i.stringPlus("unexpected encodedPath: ", str).toString());
            }
            resolvePath(str, 0, str.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            List<String> queryNamesAndValues$okhttp = null;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(queryNamesAndValues$okhttp);
            return this;
        }

        public final Builder encodedUsername(String str) {
            i.checkNotNullParameter(str, "encodedUsername");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null));
            return this;
        }

        public final Builder fragment(String str) {
            setEncodedFragment$okhttp(str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null));
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String str) {
            i.checkNotNullParameter(str, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException(i.stringPlus("unexpected host: ", str));
            }
            setHost$okhttp(canonicalHost);
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) throws NumberFormatException {
            int iDelimiterOffset;
            int i10;
            String str2;
            int i11;
            int i12;
            String str3;
            String strStringPlus = str;
            i.checkNotNullParameter(strStringPlus, "input");
            int iIndexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(strStringPlus, 0, 0, 3, null);
            int iIndexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(strStringPlus, iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int iSchemeDelimiterOffset = companion.schemeDelimiterOffset(strStringPlus, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            String str4 = "this as java.lang.String…ing(startIndex, endIndex)";
            char c10 = 65535;
            if (iSchemeDelimiterOffset != -1) {
                if (l.startsWith(strStringPlus, "https:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!l.startsWith(strStringPlus, "http:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb2 = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = strStringPlus.substring(0, iSchemeDelimiterOffset);
                        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(strSubstring);
                        sb2.append('\'');
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    if (str.length() > 6) {
                        strStringPlus = i.stringPlus(m.take(strStringPlus, 6), "...");
                    }
                    throw new IllegalArgumentException(i.stringPlus("Expected URL scheme 'http' or 'https' but no scheme was found for ", strStringPlus));
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = companion.slashCount(strStringPlus, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            char c11 = '?';
            char c12 = '#';
            if (iSlashCount >= 2 || httpUrl == null || !i.areEqual(httpUrl.scheme(), this.scheme)) {
                int i13 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(strStringPlus, "@/\\?#", i13, iIndexOfLastNonAsciiWhitespace$default);
                    char cCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default ? strStringPlus.charAt(iDelimiterOffset) : (char) 65535;
                    if (cCharAt == c10 || cCharAt == c12 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c11) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (z10) {
                            i11 = iIndexOfLastNonAsciiWhitespace$default;
                            i12 = iDelimiterOffset;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.encodedPassword);
                            sb3.append("%40");
                            str3 = str4;
                            sb3.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i13, i12, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb3.toString();
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(strStringPlus, ':', i13, iDelimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            i11 = iIndexOfLastNonAsciiWhitespace$default;
                            i12 = iDelimiterOffset;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, str, i13, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z11) {
                                strCanonicalize$okhttp$default = ac.c.p(new StringBuilder(), this.encodedUsername, "%40", strCanonicalize$okhttp$default);
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != i12) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, str, iDelimiterOffset2 + 1, i12, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z10 = true;
                            }
                            str3 = str4;
                            z11 = true;
                        }
                        i13 = i12 + 1;
                        c12 = '#';
                        c11 = '?';
                        c10 = 65535;
                        str4 = str3;
                        iIndexOfLastNonAsciiWhitespace$default = i11;
                    }
                }
                i10 = iIndexOfLastNonAsciiWhitespace$default;
                String str5 = str4;
                Companion companion3 = Companion;
                int iPortColonOffset = companion3.portColonOffset(strStringPlus, i13, iDelimiterOffset);
                int i14 = iPortColonOffset + 1;
                if (i14 < iDelimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, str, i13, iPortColonOffset, false, 4, null));
                    int port = companion3.parsePort(strStringPlus, i14, iDelimiterOffset);
                    this.port = port;
                    if (!(port != -1)) {
                        StringBuilder sb4 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = strStringPlus.substring(i14, iDelimiterOffset);
                        i.checkNotNullExpressionValue(strSubstring2, str5);
                        sb4.append(strSubstring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                    str2 = str5;
                } else {
                    str2 = str5;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, str, i13, iPortColonOffset, false, 4, null));
                    String str6 = this.scheme;
                    i.checkNotNull(str6);
                    this.port = companion4.defaultPort(str6);
                }
                if (!(this.host != null)) {
                    StringBuilder sb5 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = strStringPlus.substring(i13, iPortColonOffset);
                    i.checkNotNullExpressionValue(strSubstring3, str2);
                    sb5.append(strSubstring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default || strStringPlus.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i10 = iIndexOfLastNonAsciiWhitespace$default;
            }
            int i15 = i10;
            int iDelimiterOffset3 = Util.delimiterOffset(strStringPlus, "?#", iIndexOfFirstNonAsciiWhitespace$default, i15);
            resolvePath(strStringPlus, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 < i15 && strStringPlus.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(strStringPlus, '#', iDelimiterOffset3, i15);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, str, iDelimiterOffset3 + 1, iDelimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < i15 && strStringPlus.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, iDelimiterOffset3 + 1, i15, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String str) {
            i.checkNotNullParameter(str, "password");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final Builder port(int i10) {
            boolean z10 = false;
            if (1 <= i10 && i10 < 65536) {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException(i.stringPlus("unexpected port: ", Integer.valueOf(i10)).toString());
            }
            setPort$okhttp(i10);
            return this;
        }

        public final Builder query(String str) {
            List<String> queryNamesAndValues$okhttp = null;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(queryNamesAndValues$okhttp);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String host$okhttp = getHost$okhttp();
            setHost$okhttp(host$okhttp == null ? null : new Regex("[\"<>^`{|}]").replace(host$okhttp, ""));
            int size = getEncodedPathSegments$okhttp().size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                getEncodedPathSegments$okhttp().set(i11, Companion.canonicalize$okhttp$default(HttpUrl.Companion, getEncodedPathSegments$okhttp().get(i11), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            if (encodedQueryNamesAndValues$okhttp != null) {
                int size2 = encodedQueryNamesAndValues$okhttp.size();
                while (i10 < size2) {
                    int i12 = i10 + 1;
                    String str = encodedQueryNamesAndValues$okhttp.get(i10);
                    encodedQueryNamesAndValues$okhttp.set(i10, str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null));
                    i10 = i12;
                }
            }
            String encodedFragment$okhttp = getEncodedFragment$okhttp();
            setEncodedFragment$okhttp(encodedFragment$okhttp != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment$okhttp, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null);
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            i.checkNotNullParameter(str, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i10) {
            getEncodedPathSegments$okhttp().remove(i10);
            if (getEncodedPathSegments$okhttp().isEmpty()) {
                getEncodedPathSegments$okhttp().add("");
            }
            return this;
        }

        public final Builder scheme(String str) {
            i.checkNotNullParameter(str, "scheme");
            if (l.equals(str, HttpHost.DEFAULT_SCHEME_NAME, true)) {
                setScheme$okhttp(HttpHost.DEFAULT_SCHEME_NAME);
            } else {
                if (!l.equals(str, "https", true)) {
                    throw new IllegalArgumentException(i.stringPlus("unexpected scheme: ", str));
                }
                setScheme$okhttp("https");
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            i.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i10, String str) {
            i.checkNotNullParameter(str, "encodedPathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            getEncodedPathSegments$okhttp().set(i10, strCanonicalize$okhttp$default);
            if ((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(i.stringPlus("unexpected path segment: ", str).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            i.checkNotNullParameter(str, "encodedName");
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            i.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i10, String str) {
            i.checkNotNullParameter(str, "pathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true)) {
                throw new IllegalArgumentException(i.stringPlus("unexpected path segment: ", str).toString());
            }
            getEncodedPathSegments$okhttp().set(i10, strCanonicalize$okhttp$default);
            return this;
        }

        public final void setPort$okhttp(int i10) {
            this.port = i10;
        }

        public final Builder setQueryParameter(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.getScheme$okhttp()
                if (r1 == 0) goto L18
                java.lang.String r1 = r6.getScheme$okhttp()
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L1d
            L18:
                java.lang.String r1 = "//"
                r0.append(r1)
            L1d:
                java.lang.String r1 = r6.getEncodedUsername$okhttp()
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L2b
                r1 = 1
                goto L2c
            L2b:
                r1 = 0
            L2c:
                r4 = 58
                if (r1 != 0) goto L3f
                java.lang.String r1 = r6.getEncodedPassword$okhttp()
                int r1 = r1.length()
                if (r1 <= 0) goto L3c
                r1 = 1
                goto L3d
            L3c:
                r1 = 0
            L3d:
                if (r1 == 0) goto L63
            L3f:
                java.lang.String r1 = r6.getEncodedUsername$okhttp()
                r0.append(r1)
                java.lang.String r1 = r6.getEncodedPassword$okhttp()
                int r1 = r1.length()
                if (r1 <= 0) goto L51
                goto L52
            L51:
                r2 = 0
            L52:
                if (r2 == 0) goto L5e
                r0.append(r4)
                java.lang.String r1 = r6.getEncodedPassword$okhttp()
                r0.append(r1)
            L5e:
                r1 = 64
                r0.append(r1)
            L63:
                java.lang.String r1 = r6.getHost$okhttp()
                if (r1 == 0) goto L91
                java.lang.String r1 = r6.getHost$okhttp()
                zf.i.checkNotNull(r1)
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L8a
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.getHost$okhttp()
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L91
            L8a:
                java.lang.String r1 = r6.getHost$okhttp()
                r0.append(r1)
            L91:
                int r1 = r6.getPort$okhttp()
                r2 = -1
                if (r1 != r2) goto L9e
                java.lang.String r1 = r6.getScheme$okhttp()
                if (r1 == 0) goto Lbd
            L9e:
                int r1 = r6.effectivePort()
                java.lang.String r2 = r6.getScheme$okhttp()
                if (r2 == 0) goto Lb7
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion
                java.lang.String r3 = r6.getScheme$okhttp()
                zf.i.checkNotNull(r3)
                int r2 = r2.defaultPort(r3)
                if (r1 == r2) goto Lbd
            Lb7:
                r0.append(r4)
                r0.append(r1)
            Lbd:
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List r2 = r6.getEncodedPathSegments$okhttp()
                r1.toPathString$okhttp(r2, r0)
                java.util.List r2 = r6.getEncodedQueryNamesAndValues$okhttp()
                if (r2 == 0) goto Ldb
                r2 = 63
                r0.append(r2)
                java.util.List r2 = r6.getEncodedQueryNamesAndValues$okhttp()
                zf.i.checkNotNull(r2)
                r1.toQueryString$okhttp(r2, r0)
            Ldb:
                java.lang.String r1 = r6.getEncodedFragment$okhttp()
                if (r1 == 0) goto Led
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.getEncodedFragment$okhttp()
                r0.append(r1)
            Led:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                zf.i.checkNotNullExpressionValue(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        public final Builder username(String str) {
            i.checkNotNullParameter(str, "username");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        private final Builder addPathSegments(String str, boolean z10) {
            int i10 = 0;
            do {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i10, str.length());
                push(str, i10, iDelimiterOffset, iDelimiterOffset < str.length(), z10);
                i10 = iDelimiterOffset + 1;
            } while (i10 <= str.length());
            return this;
        }
    }

    /* compiled from: HttpUrl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            return companion.canonicalize$okhttp(str, (i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? str.length() : i11, str2, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? false : z11, (i12 & 32) != 0 ? false : z12, (i12 & 64) != 0 ? false : z13, (i12 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i10, int i11) {
            int i12 = i10 + 2;
            return i12 < i11 && str.charAt(i10) == '%' && Util.parseHexDigit(str.charAt(i10 + 1)) != -1 && Util.parseHexDigit(str.charAt(i12)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return companion.percentDecode$okhttp(str, i10, i11, z10);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0090 A[LOOP:1: B:49:0x008a->B:51:0x0090, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void writeCanonicalized(ah.c r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lb9
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L28
                r8 = 9
                if (r7 == r8) goto L23
                r8 = 10
                if (r7 == r8) goto L23
                r8 = 12
                if (r7 == r8) goto L23
                r8 = 13
                if (r7 != r8) goto L28
            L23:
                r8 = r14
                r12 = r19
                goto Lb2
            L28:
                r8 = 43
                if (r7 != r8) goto L39
                if (r22 == 0) goto L39
                if (r20 == 0) goto L33
                java.lang.String r8 = "+"
                goto L35
            L33:
                java.lang.String r8 = "%2B"
            L35:
                r15.writeUtf8(r8)
                goto L23
            L39:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L69
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L69
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L49
                if (r23 == 0) goto L69
            L49:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L67
                if (r7 != r9) goto L62
                if (r20 == 0) goto L67
                if (r21 == 0) goto L62
                r8 = r14
                boolean r10 = r14.isPercentEncoded(r1, r5, r2)
                if (r10 != 0) goto L63
                goto L6c
            L62:
                r8 = r14
            L63:
                r15.writeUtf8CodePoint(r7)
                goto Lb2
            L67:
                r8 = r14
                goto L6c
            L69:
                r8 = r14
                r12 = r19
            L6c:
                if (r6 != 0) goto L73
                ah.c r6 = new ah.c
                r6.<init>()
            L73:
                if (r3 == 0) goto L87
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = zf.i.areEqual(r3, r10)
                if (r10 == 0) goto L7e
                goto L87
            L7e:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.writeString(r1, r5, r10, r3)
                goto L8a
            L87:
                r6.writeUtf8CodePoint(r7)
            L8a:
                boolean r10 = r6.exhausted()
                if (r10 != 0) goto Lb2
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = okhttp3.HttpUrl.access$getHEX_DIGITS$cp()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8a
            Lb2:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lb9:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.writeCanonicalized(ah.c, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        private final void writePercentDecoded(ah.c cVar, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                int iCodePointAt = str.codePointAt(i10);
                if (iCodePointAt == 37 && (i12 = i10 + 2) < i11) {
                    int hexDigit = Util.parseHexDigit(str.charAt(i10 + 1));
                    int hexDigit2 = Util.parseHexDigit(str.charAt(i12));
                    if (hexDigit == -1 || hexDigit2 == -1) {
                        cVar.writeUtf8CodePoint(iCodePointAt);
                        i10 += Character.charCount(iCodePointAt);
                    } else {
                        cVar.writeByte((hexDigit << 4) + hexDigit2);
                        i10 = Character.charCount(iCodePointAt) + i12;
                    }
                } else if (iCodePointAt == 43 && z10) {
                    cVar.writeByte(32);
                    i10++;
                } else {
                    cVar.writeUtf8CodePoint(iCodePointAt);
                    i10 += Character.charCount(iCodePointAt);
                }
            }
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m159deprecated_get(String str) {
            i.checkNotNullParameter(str, "url");
            return get(str);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m162deprecated_parse(String str) {
            i.checkNotNullParameter(str, "url");
            return parse(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String canonicalize$okhttp(java.lang.String r14, int r15, int r16, java.lang.String r17, boolean r18, boolean r19, boolean r20, boolean r21, java.nio.charset.Charset r22) {
            /*
                r13 = this;
                r2 = r14
                r4 = r16
                r5 = r17
                java.lang.String r0 = "<this>"
                zf.i.checkNotNullParameter(r14, r0)
                java.lang.String r0 = "encodeSet"
                zf.i.checkNotNullParameter(r5, r0)
                r3 = r15
            L10:
                if (r3 >= r4) goto L6f
                int r0 = r14.codePointAt(r3)
                r1 = 32
                if (r0 < r1) goto L4c
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == r1) goto L4c
                r1 = 128(0x80, float:1.8E-43)
                if (r0 < r1) goto L24
                if (r21 == 0) goto L4c
            L24:
                char r1 = (char) r0
                r6 = 2
                r7 = 0
                r8 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default(r5, r1, r8, r6, r7)
                if (r1 != 0) goto L4c
                r1 = 37
                if (r0 != r1) goto L3e
                if (r18 == 0) goto L4c
                if (r19 == 0) goto L3e
                r11 = r13
                boolean r1 = r13.isPercentEncoded(r14, r3, r4)
                if (r1 == 0) goto L4d
                goto L3f
            L3e:
                r11 = r13
            L3f:
                r1 = 43
                if (r0 != r1) goto L46
                if (r20 == 0) goto L46
                goto L4d
            L46:
                int r0 = java.lang.Character.charCount(r0)
                int r3 = r3 + r0
                goto L10
            L4c:
                r11 = r13
            L4d:
                ah.c r12 = new ah.c
                r12.<init>()
                r0 = r15
                r12.writeUtf8(r14, r15, r3)
                r0 = r13
                r1 = r12
                r2 = r14
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r0.writeCanonicalized(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r0 = r12.readUtf8()
                return r0
            L6f:
                r11 = r13
                r0 = r15
                java.lang.String r0 = r14.substring(r15, r16)
                java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
                zf.i.checkNotNullExpressionValue(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Companion.canonicalize$okhttp(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):java.lang.String");
        }

        public final int defaultPort(String str) {
            i.checkNotNullParameter(str, "scheme");
            if (i.areEqual(str, HttpHost.DEFAULT_SCHEME_NAME)) {
                return 80;
            }
            return i.areEqual(str, "https") ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            i.checkNotNullParameter(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            i.checkNotNullParameter(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i10, int i11, boolean z10) {
            i.checkNotNullParameter(str, "<this>");
            int i12 = i10;
            while (i12 < i11) {
                int i13 = i12 + 1;
                char cCharAt = str.charAt(i12);
                if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                    ah.c cVar = new ah.c();
                    cVar.writeUtf8(str, i10, i12);
                    writePercentDecoded(cVar, str, i12, i11, z10);
                    return cVar.readUtf8();
                }
                i12 = i13;
            }
            String strSubstring = str.substring(i10, i11);
            i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder sb2) {
            i.checkNotNullParameter(list, "<this>");
            i.checkNotNullParameter(sb2, "out");
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(JsonPointer.SEPARATOR);
                sb2.append(list.get(i10));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            i.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '&', i10, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int i11 = iIndexOf$default;
                int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '=', i10, false, 4, (Object) null);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > i11) {
                    String strSubstring = str.substring(i10, i11);
                    i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i10, iIndexOf$default2);
                    i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iIndexOf$default2 + 1, i11);
                    i.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i10 = i11 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder sb2) {
            i.checkNotNullParameter(list, "<this>");
            i.checkNotNullParameter(sb2, "out");
            a aVarStep = h.step(h.until(0, list.size()), 2);
            int first = aVarStep.getFirst();
            int last = aVarStep.getLast();
            int step = aVarStep.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return;
            }
            while (true) {
                int i10 = first + step;
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    sb2.append('&');
                }
                sb2.append(str);
                if (str2 != null) {
                    sb2.append('=');
                    sb2.append(str2);
                }
                if (first == last) {
                    return;
                } else {
                    first = i10;
                }
            }
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m161deprecated_get(URL url) {
            i.checkNotNullParameter(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL url) {
            i.checkNotNullParameter(url, "<this>");
            String string = url.toString();
            i.checkNotNullExpressionValue(string, "toString()");
            return parse(string);
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m160deprecated_get(URI uri) {
            i.checkNotNullParameter(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            i.checkNotNullParameter(uri, "<this>");
            String string = uri.toString();
            i.checkNotNullExpressionValue(string, "toString()");
            return parse(string);
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i10, List<String> list, List<String> list2, String str5, String str6) {
        i.checkNotNullParameter(str, "scheme");
        i.checkNotNullParameter(str2, "username");
        i.checkNotNullParameter(str3, "password");
        i.checkNotNullParameter(str4, "host");
        i.checkNotNullParameter(list, "pathSegments");
        i.checkNotNullParameter(str6, "url");
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i10;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = i.areEqual(str, "https");
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m140deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m141deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m142deprecated_encodedPath() {
        return encodedPath();
    }

    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m143deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m144deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m145deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m146deprecated_fragment() {
        return this.fragment;
    }

    /* renamed from: -deprecated_host, reason: not valid java name */
    public final String m147deprecated_host() {
        return this.host;
    }

    /* renamed from: -deprecated_password, reason: not valid java name */
    public final String m148deprecated_password() {
        return this.password;
    }

    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m149deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m150deprecated_pathSize() {
        return pathSize();
    }

    /* renamed from: -deprecated_port, reason: not valid java name */
    public final int m151deprecated_port() {
        return this.port;
    }

    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m152deprecated_query() {
        return query();
    }

    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m153deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m154deprecated_querySize() {
        return querySize();
    }

    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m155deprecated_scheme() {
        return this.scheme;
    }

    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m156deprecated_uri() {
        return uri();
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m157deprecated_url() {
        return url();
    }

    /* renamed from: -deprecated_username, reason: not valid java name */
    public final String m158deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1);
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(StringsKt__StringsKt.indexOf$default((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null));
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedPath() {
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, JsonPointer.SEPARATOR, this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        String strSubstring = this.url.substring(iIndexOf$default, Util.delimiterOffset(str, "?#", iIndexOf$default, str.length()));
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> encodedPathSegments() {
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, JsonPointer.SEPARATOR, this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iDelimiterOffset) {
            int i10 = iIndexOf$default + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, JsonPointer.SEPARATOR, i10, iDelimiterOffset);
            String strSubstring = this.url.substring(i10, iDelimiterOffset2);
            i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iIndexOf$default, Util.delimiterOffset(str, '#', iIndexOf$default, str.length()));
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && i.areEqual(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String queryParameter(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        a aVarStep = h.step(h.until(0, list.size()), 2);
        int first = aVarStep.getFirst();
        int last = aVarStep.getLast();
        int step = aVarStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int i10 = first + step;
                if (i.areEqual(str, this.queryNamesAndValues.get(first))) {
                    return this.queryNamesAndValues.get(first + 1);
                }
                if (first == last) {
                    break;
                }
                first = i10;
            }
        }
        return null;
    }

    public final String queryParameterName(int i10) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i10 * 2);
        i.checkNotNull(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return z.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a aVarStep = h.step(h.until(0, this.queryNamesAndValues.size()), 2);
        int first = aVarStep.getFirst();
        int last = aVarStep.getLast();
        int step = aVarStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int i10 = first + step;
                String str = this.queryNamesAndValues.get(first);
                i.checkNotNull(str);
                linkedHashSet.add(str);
                if (first == last) {
                    break;
                }
                first = i10;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        i.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final String queryParameterValue(int i10) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i10 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        if (this.queryNamesAndValues == null) {
            return k.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        a aVarStep = h.step(h.until(0, this.queryNamesAndValues.size()), 2);
        int first = aVarStep.getFirst();
        int last = aVarStep.getLast();
        int step = aVarStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int i10 = first + step;
                if (i.areEqual(str, this.queryNamesAndValues.get(first))) {
                    arrayList.add(this.queryNamesAndValues.get(first + 1));
                }
                if (first == last) {
                    break;
                }
                first = i10;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        i.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        i.checkNotNull(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String str) {
        i.checkNotNullParameter(str, "link");
        Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder == null) {
            return null;
        }
        return builderNewBuilder.build();
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String string = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                i.checkNotNullExpressionValue(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final String username() {
        return this.username;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String str) {
        i.checkNotNullParameter(str, "link");
        try {
            return new Builder().parse$okhttp(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
