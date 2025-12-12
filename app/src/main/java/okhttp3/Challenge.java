package okhttp3;

import ac.c;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.a;
import zf.i;

/* compiled from: Challenge.kt */
/* loaded from: classes2.dex */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        i.checkNotNullParameter(str, "scheme");
        i.checkNotNullParameter(map, "authParams");
        this.scheme = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                lowerCase = null;
            } else {
                Locale locale = Locale.US;
                i.checkNotNullExpressionValue(locale, "US");
                lowerCase = key.toLowerCase(locale);
                i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        i.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = mapUnmodifiableMap;
    }

    /* renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m111deprecated_authParams() {
        return this.authParams;
    }

    /* renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m112deprecated_charset() {
        return charset();
    }

    /* renamed from: -deprecated_realm, reason: not valid java name */
    public final String m113deprecated_realm() {
        return realm();
    }

    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m114deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                i.checkNotNullExpressionValue(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        i.checkNotNullExpressionValue(charset, "ISO_8859_1");
        return charset;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (i.areEqual(challenge.scheme, this.scheme) && i.areEqual(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.authParams.hashCode() + c.b(this.scheme, 899, 31);
    }

    public final String realm() {
        return this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset charset) {
        i.checkNotNullParameter(charset, "charset");
        Map mutableMap = a.toMutableMap(this.authParams);
        String strName = charset.name();
        i.checkNotNullExpressionValue(strName, "charset.name()");
        mutableMap.put("charset", strName);
        return new Challenge(this.scheme, (Map<String, String>) mutableMap);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Challenge(String str, String str2) {
        i.checkNotNullParameter(str, "scheme");
        i.checkNotNullParameter(str2, "realm");
        Map mapSingletonMap = Collections.singletonMap("realm", str2);
        i.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(\"realm\", realm)");
        this(str, (Map<String, String>) mapSingletonMap);
    }
}
