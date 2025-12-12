package okhttp3.internal.http;

import ah.c;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.protocol.HTTP;
import ig.l;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.ByteString;
import zf.i;

/* compiled from: HttpHeaders.kt */
/* loaded from: classes2.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.a aVar = ByteString.f17101o;
        QUOTED_STRING_DELIMITERS = aVar.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
        TOKEN_DELIMITERS = aVar.encodeUtf8("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        i.checkNotNullParameter(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        i.checkNotNullParameter(headers, "<this>");
        i.checkNotNullParameter(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (l.equals(str, headers.name(i10), true)) {
                try {
                    readChallengeHeader(new c().writeUtf8(headers.value(i10)), arrayList);
                } catch (EOFException e10) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e10);
                }
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        i.checkNotNullParameter(response, "<this>");
        if (i.areEqual(response.request().method(), "HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && Util.headersContentLength(response) == -1 && !l.equals(HTTP.CHUNK_CODING, Response.header$default(response, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x007a, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007a, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void readChallengeHeader(ah.c r7, java.util.List<okhttp3.Challenge> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            skipCommasAndWhitespace(r7)
            java.lang.String r1 = readToken(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = skipCommasAndWhitespace(r7)
            java.lang.String r3 = readToken(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.exhausted()
            if (r7 != 0) goto L1f
            return
        L1f:
            okhttp3.Challenge r7 = new okhttp3.Challenge
            java.util.Map r0 = kotlin.collections.a.emptyMap()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
            boolean r6 = skipCommasAndWhitespace(r7)
            if (r2 != 0) goto L5c
            if (r6 != 0) goto L40
            boolean r2 = r7.exhausted()
            if (r2 == 0) goto L5c
        L40:
            okhttp3.Challenge r2 = new okhttp3.Challenge
            java.lang.String r4 = "="
            java.lang.String r4 = ig.l.repeat(r4, r5)
            java.lang.String r3 = zf.i.stringPlus(r3, r4)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            zf.i.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5c:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = okhttp3.internal.Util.skipAll(r7, r4)
            int r6 = r6 + r5
        L66:
            if (r3 != 0) goto L78
            java.lang.String r3 = readToken(r7)
            boolean r5 = skipCommasAndWhitespace(r7)
            if (r5 == 0) goto L73
            goto L7a
        L73:
            int r5 = okhttp3.internal.Util.skipAll(r7, r4)
            r6 = r5
        L78:
            if (r6 != 0) goto L85
        L7a:
            okhttp3.Challenge r4 = new okhttp3.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L85:
            r5 = 1
            if (r6 <= r5) goto L89
            return
        L89:
            boolean r5 = skipCommasAndWhitespace(r7)
            if (r5 == 0) goto L90
            return
        L90:
            r5 = 34
            boolean r5 = startsWith(r7, r5)
            if (r5 == 0) goto L9d
            java.lang.String r5 = readQuotedString(r7)
            goto La1
        L9d:
            java.lang.String r5 = readToken(r7)
        La1:
            if (r5 != 0) goto La4
            return
        La4:
            java.lang.Object r3 = r2.put(r3, r5)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lad
            return
        Lad:
            boolean r3 = skipCommasAndWhitespace(r7)
            if (r3 != 0) goto Lba
            boolean r3 = r7.exhausted()
            if (r3 != 0) goto Lba
            return
        Lba:
            r3 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(ah.c, java.util.List):void");
    }

    private static final String readQuotedString(c cVar) throws EOFException {
        if (!(cVar.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        c cVar2 = new c();
        while (true) {
            long jIndexOfElement = cVar.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (cVar.getByte(jIndexOfElement) == 34) {
                cVar2.write(cVar, jIndexOfElement);
                cVar.readByte();
                return cVar2.readUtf8();
            }
            if (cVar.size() == jIndexOfElement + 1) {
                return null;
            }
            cVar2.write(cVar, jIndexOfElement);
            cVar.readByte();
            cVar2.write(cVar, 1L);
        }
    }

    private static final String readToken(c cVar) {
        long jIndexOfElement = cVar.indexOfElement(TOKEN_DELIMITERS);
        if (jIndexOfElement == -1) {
            jIndexOfElement = cVar.size();
        }
        if (jIndexOfElement != 0) {
            return cVar.readUtf8(jIndexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        i.checkNotNullParameter(cookieJar, "<this>");
        i.checkNotNullParameter(httpUrl, "url");
        i.checkNotNullParameter(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static final boolean skipCommasAndWhitespace(c cVar) throws EOFException {
        boolean z10 = false;
        while (!cVar.exhausted()) {
            byte b10 = cVar.getByte(0L);
            boolean z11 = true;
            if (b10 != 44) {
                if (b10 != 32 && b10 != 9) {
                    z11 = false;
                }
                if (!z11) {
                    break;
                }
                cVar.readByte();
            } else {
                cVar.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    private static final boolean startsWith(c cVar, byte b10) {
        return !cVar.exhausted() && cVar.getByte(0L) == b10;
    }
}
