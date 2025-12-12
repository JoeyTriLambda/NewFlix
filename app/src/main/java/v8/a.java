package v8;

import com.loopj.android.http.AsyncHttpClient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import o8.e;

/* compiled from: HttpGetRequest.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f20619a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, String> f20620b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f20621c = new HashMap();

    public a(String str, Map<String, String> map) {
        this.f20619a = str;
        this.f20620b = map;
    }

    public static String a(String str, Map map) throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb2.append((String) entry.getKey());
        sb2.append("=");
        sb2.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), "UTF-8") : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb2.append("&");
            sb2.append((String) entry2.getKey());
            sb2.append("=");
            sb2.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), "UTF-8") : "");
        }
        String string = sb2.toString();
        if (string.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return ac.c.C(str, "?", string);
        }
        if (!str.endsWith("&")) {
            string = "&".concat(string);
        }
        return ac.c.B(str, string);
    }

    public c execute() throws Throwable {
        Throwable th2;
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream = null;
        String string = null;
        inputStream = null;
        try {
            String strA = a(this.f20619a, this.f20620b);
            e.getLogger().v("GET Request URL: " + strA);
            httpsURLConnection = (HttpsURLConnection) new URL(strA).openConnection();
            try {
                httpsURLConnection.setReadTimeout(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
                httpsURLConnection.setConnectTimeout(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry entry : this.f20621c.entrySet()) {
                    httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                        char[] cArr = new char[8192];
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            int i10 = bufferedReader.read(cArr);
                            if (i10 == -1) {
                                break;
                            }
                            sb2.append(cArr, 0, i10);
                        }
                        string = sb2.toString();
                    } catch (Throwable th3) {
                        th2 = th3;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th2;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new c(responseCode, string);
            } catch (Throwable th4) {
                th2 = th4;
            }
        } catch (Throwable th5) {
            th2 = th5;
            httpsURLConnection = null;
        }
    }

    public a header(String str, String str2) {
        this.f20621c.put(str, str2);
        return this;
    }
}
