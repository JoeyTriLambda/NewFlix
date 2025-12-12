package org.adblockplus.libadblockplus.android;

import android.content.Context;
import android.text.TextUtils;
import bi.a;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.adblockplus.libadblockplus.Filter;
import org.adblockplus.libadblockplus.FilterEngine;
import org.adblockplus.libadblockplus.HeaderEntry;
import org.adblockplus.libadblockplus.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class Utils {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    public static final Set<String> commaNotMergableHeaders = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpClient.HEADER_SET_COOKIE, HttpClient.HEADER_WWW_AUTHENTICATE, HttpClient.HEADER_PROXY_AUTHENTICATE, "expires", HttpClient.HEADER_DATE, HttpClient.HEADER_RETRY_AFTER, HttpClient.HEADER_LAST_MODIFIED, HttpClient.HEADER_VIA)));
    private static String U2028 = new String(new byte[]{-30, -128, -88});
    private static String U2029 = new String(new byte[]{-30, -128, -87});

    private Utils() {
    }

    public static byte[] byteBufferToByteArray(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static byte[] combineBuffers(Deque<byte[]> deque, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = i10;
        while (i11 > 0) {
            byte[] bArrRemoveFirst = deque.removeFirst();
            int iMin = Math.min(i11, bArrRemoveFirst.length);
            System.arraycopy(bArrRemoveFirst, 0, bArr, i10 - i11, iMin);
            i11 -= iMin;
        }
        return bArr;
    }

    public static Map<String, String> convertHeaderEntriesToMap(List<HeaderEntry> list) {
        HashMap map = new HashMap(list.size());
        for (HeaderEntry headerEntry : list) {
            if (!map.containsKey(headerEntry.getKey())) {
                map.put(headerEntry.getKey(), headerEntry.getValue());
            } else if (commaNotMergableHeaders.contains(headerEntry.getKey())) {
                a.d("convertHeaderEntriesToMap() overwrites value of `%s` header", headerEntry.getKey());
                map.put(headerEntry.getKey(), headerEntry.getValue());
            } else if (((String) map.get(headerEntry.getKey())).equalsIgnoreCase(headerEntry.getValue())) {
                a.d("convertHeaderEntriesToMap() skips duplicated value of `%s` header", headerEntry.getKey());
            } else {
                String str = ((String) map.get(headerEntry.getKey())) + ", " + headerEntry.getValue();
                a.d("convertHeaderEntriesToMap() merges values of `%s` header", headerEntry.getKey());
                map.put(headerEntry.getKey(), str);
            }
        }
        return map;
    }

    public static List<HeaderEntry> convertMapToHeadersList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new HeaderEntry(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Filter createDomainAllowlistingFilter(FilterEngine filterEngine, String str) {
        return filterEngine.getFilter("@@||" + str + "^$document,domain=" + str);
    }

    public static String emulationSelectorListToJsonArray(List<FilterEngine.EmulationSelector> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (FilterEngine.EmulationSelector emulationSelector : list) {
                if (emulationSelector != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("selector", emulationSelector.selector);
                        jSONObject.put("text", emulationSelector.text);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        a.e(e10, "Failed to create JSON object", new Object[0]);
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    public static String escapeJavaScriptString(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"' || cCharAt == '\'' || cCharAt == '\\') {
                sb2.append(TokenParser.ESCAPE);
                sb2.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return sb2.toString().replace(U2028, "\u2028").replace(U2029, "\u2029");
    }

    public static String extractPathWithQuery(String str) throws MalformedURLException {
        URL url = new URL(str);
        StringBuilder sb2 = new StringBuilder(url.getPath());
        if (url.getQuery() != null) {
            sb2.append("?");
            sb2.append(url.getQuery());
        }
        return sb2.toString();
    }

    public static String getAbsoluteUrl(String str, String str2) throws MalformedURLException {
        return new URL(new URL(str), str2).toExternalForm();
    }

    public static String getDomain(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Url can't be null");
        }
        try {
            return new URI(getStringBeforeChar(str, '?')).getHost();
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static String getOrigin(String str) throws MalformedURLException {
        if (str == null) {
            throw new IllegalArgumentException("URL can't be null");
        }
        URL url = new URL(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(url.getProtocol());
        sb2.append("://");
        sb2.append(url.getHost());
        if (url.getPort() != -1) {
            sb2.append(":");
            sb2.append(url.getPort());
        }
        if (!TextUtils.isEmpty(url.getPath()) || !TextUtils.isEmpty(url.getQuery())) {
            sb2.append("/");
        }
        return sb2.toString();
    }

    private static String getStringBeforeChar(String str, char c10) {
        int iIndexOf = str.indexOf(c10);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : str;
    }

    public static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }

    public static String getUrlWithoutFragment(String str) {
        return getStringBeforeChar(str, '#');
    }

    public static String getUrlWithoutParams(String str) {
        if (str != null) {
            return getStringBeforeChar(str, '?');
        }
        throw new IllegalArgumentException("URL can't be null");
    }

    public static boolean isAbsoluteUrl(String str) throws URISyntaxException {
        return new URI(str).isAbsolute();
    }

    public static boolean isFirstPartyCookie(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            throw new IllegalArgumentException("Arguments can't be null");
        }
        String domain = getDomain(str);
        if (domain == null) {
            a.e("isFirstPartyCookie: Failed to getDomain(%s)", str);
            return false;
        }
        try {
            List<HttpCookie> list = HttpCookie.parse(str3);
            String domain2 = list.size() > 0 ? list.get(0).getDomain() : null;
            if ((domain2 == null || domain2.isEmpty()) && ((domain2 = getDomain(str2)) == null || domain2.isEmpty())) {
                a.e("isFirstPartyCookie: Failed to getDomain(%s)", str2);
                return false;
            }
            if (domain2.isEmpty()) {
                return false;
            }
            return HttpCookie.domainMatches(domain2.toLowerCase(), domain.toLowerCase());
        } catch (IllegalArgumentException e10) {
            a.e(e10, "isFirstPartyCookie: Failed call to HttpCookie.parse()", new Object[0]);
            return false;
        }
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isSubdomainOrDomain(String str, String str2) {
        if (str.length() == 0 || str2.length() == 0 || !str.endsWith(str2)) {
            return false;
        }
        String[] strArrSplit = str2.split("\\.");
        String[] strArrSplit2 = str.split("\\.");
        if (strArrSplit2.length < strArrSplit.length) {
            return false;
        }
        int length = strArrSplit.length - 1;
        int length2 = strArrSplit2.length - 1;
        for (int i10 = 0; i10 <= length; i10++) {
            if (!strArrSplit2[length2 - i10].equals(strArrSplit[length - i10])) {
                return false;
            }
        }
        return true;
    }

    public static String readAssetAsString(Context context, String str, String str2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(context.getAssets().open(str));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            String str3 = new String(toByteArray(bufferedInputStream), str2);
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            return str3;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static ByteBuffer readFromInputStream(InputStream inputStream) throws IOException {
        byte[] byteArray = toByteArray(inputStream);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteArray.length);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        byteBufferAllocateDirect.put(byteArray);
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }

    public static String stringListToJsonArray(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (String str : list) {
                if (str != null) {
                    jSONArray.put(str);
                }
            }
        }
        return jSONArray.toString();
    }

    public static ByteBuffer stringToByteBuffer(String str, Charset charset) {
        byte[] bytes = str.getBytes(charset);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytes.length);
        byteBufferAllocateDirect.put(bytes);
        return byteBufferAllocateDirect;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Deque<byte[]> deque, int i10) throws IOException {
        int i11 = 8192;
        while (i10 < MAX_ARRAY_LEN) {
            int iMin = Math.min(i11, MAX_ARRAY_LEN - i10);
            byte[] bArr = new byte[iMin];
            deque.add(bArr);
            int i12 = 0;
            while (i12 < iMin) {
                int i13 = inputStream.read(bArr, i12, iMin - i12);
                if (i13 == -1) {
                    return combineBuffers(deque, i10);
                }
                i12 += i13;
                i10 += i13;
            }
            i11 *= 2;
        }
        if (inputStream.read() == -1) {
            return combineBuffers(deque, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("Input is too large to fit in a byte array");
    }
}
