package d4;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import cz.msebera.android.httpclient.client.methods.HttpPatch;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack.java */
/* loaded from: classes.dex */
public final class g extends d4.a {

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f10837a;

    /* compiled from: HurlStack.java */
    public static class a extends FilterInputStream {

        /* renamed from: b, reason: collision with root package name */
        public final HttpURLConnection f10838b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(HttpURLConnection httpURLConnection) throws IOException {
            InputStream errorStream;
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            super(errorStream);
            this.f10838b = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f10838b.disconnect();
        }
    }

    /* compiled from: HurlStack.java */
    public interface b {
    }

    public g() {
        this(null);
    }

    public static ArrayList b(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new Header((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public final void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(createOutputStream(request, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public final void c(Request request, HttpURLConnection httpURLConnection) throws IOException, AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection, request, postBody);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                byte[] body = request.getBody();
                if (body != null) {
                    a(httpURLConnection, request, body);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                byte[] body2 = request.getBody();
                if (body2 != null) {
                    a(httpURLConnection, request, body2);
                    return;
                }
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod(HttpPatch.METHOD_NAME);
                byte[] body3 = request.getBody();
                if (body3 != null) {
                    a(httpURLConnection, request, body3);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public InputStream createInputStream(Request<?> request, HttpURLConnection httpURLConnection) {
        return new a(httpURLConnection);
    }

    public OutputStream createOutputStream(Request<?> request, HttpURLConnection httpURLConnection, int i10) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // d4.a
    public f executeRequest(Request<?> request, Map<String, String> map) throws Throwable {
        SSLSocketFactory sSLSocketFactory;
        String url = request.getUrl();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(request.getHeaders());
        URL url2 = new URL(url);
        HttpURLConnection httpURLConnectionCreateConnection = createConnection(url2);
        int timeoutMs = request.getTimeoutMs();
        httpURLConnectionCreateConnection.setConnectTimeout(timeoutMs);
        httpURLConnectionCreateConnection.setReadTimeout(timeoutMs);
        boolean z10 = false;
        httpURLConnectionCreateConnection.setUseCaches(false);
        httpURLConnectionCreateConnection.setDoInput(true);
        if ("https".equals(url2.getProtocol()) && (sSLSocketFactory = this.f10837a) != null) {
            ((HttpsURLConnection) httpURLConnectionCreateConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (String str : map2.keySet()) {
                httpURLConnectionCreateConnection.setRequestProperty(str, (String) map2.get(str));
            }
            c(request, httpURLConnectionCreateConnection);
            int responseCode = httpURLConnectionCreateConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (!((request.getMethod() == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                f fVar = new f(responseCode, b(httpURLConnectionCreateConnection.getHeaderFields()));
                httpURLConnectionCreateConnection.disconnect();
                return fVar;
            }
            try {
                return new f(responseCode, b(httpURLConnectionCreateConnection.getHeaderFields()), httpURLConnectionCreateConnection.getContentLength(), createInputStream(request, httpURLConnectionCreateConnection));
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                if (!z10) {
                    httpURLConnectionCreateConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public g(b bVar) {
        this(bVar, null);
    }

    public g(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f10837a = sSLSocketFactory;
    }
}
