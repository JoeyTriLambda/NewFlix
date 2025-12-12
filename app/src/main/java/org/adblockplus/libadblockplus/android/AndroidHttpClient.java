package org.adblockplus.libadblockplus.android;

import android.net.TrafficStats;
import bi.a;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.adblockplus.libadblockplus.AdblockPlusException;
import org.adblockplus.libadblockplus.HeaderEntry;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.HttpRequest;
import org.adblockplus.libadblockplus.ServerResponse;

/* loaded from: classes2.dex */
public class AndroidHttpClient extends HttpClient {
    protected static final String ENCODING_GZIP = "gzip";
    protected static final String ENCODING_IDENTITY = "identity";
    protected static final int SOCKET_TAG = 1;
    private final boolean compressedStream;

    public AndroidHttpClient(boolean z10) {
        this.compressedStream = z10;
    }

    private void setGetRequestHeaders(List<HeaderEntry> list, HttpURLConnection httpURLConnection) {
        for (HeaderEntry headerEntry : list) {
            httpURLConnection.setRequestProperty(headerEntry.getKey(), headerEntry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.adblockplus.libadblockplus.HttpClient
    public void request(HttpRequest httpRequest, HttpClient.Callback callback) throws Throwable {
        String str;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        String str2;
        char c10;
        char c11;
        char c12;
        String str3;
        InputStream inputStream;
        char c13;
        Iterator<Map.Entry<String, List<String>>> it;
        String str4 = "WebRequest failed";
        if (!httpRequest.getMethod().equalsIgnoreCase("GET") && !httpRequest.getMethod().equalsIgnoreCase("HEAD")) {
            throw new UnsupportedOperationException("Only GET and HEAD methods are supported");
        }
        ServerResponse serverResponse = new ServerResponse();
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        TrafficStats.setThreadStatsTag(1);
        String str5 = "Socket TAG set to: %s";
        a.d("Socket TAG set to: %s", 1);
        try {
            try {
                URL url = new URL(httpRequest.getUrl());
                a.d("Downloading from: %s, request.getFollowRedirect() = %b", url, Boolean.valueOf(httpRequest.getFollowRedirect()));
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setRequestMethod(httpRequest.getMethod());
                    if (httpRequest.getMethod().equalsIgnoreCase("GET")) {
                        setGetRequestHeaders(httpRequest.getHeaders(), httpURLConnection);
                    }
                    httpURLConnection.setRequestProperty("Accept-Encoding", this.compressedStream ? "gzip" : "identity");
                    httpURLConnection.setInstanceFollowRedirects(httpRequest.getFollowRedirect());
                    a.d("Connecting...", new Object[0]);
                    httpURLConnection.connect();
                    a.d("Connected", new Object[0]);
                    int size = httpURLConnection.getHeaderFields().size();
                    if (size > 0) {
                        a.d("Received header fields", new Object[0]);
                        LinkedList linkedList = new LinkedList();
                        Iterator<Map.Entry<String, List<String>>> it2 = httpURLConnection.getHeaderFields().entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry<String, List<String>> next = it2.next();
                            for (String str6 : next.getValue()) {
                                if (next.getKey() == null || str6 == null) {
                                    str = str4;
                                    it = it2;
                                } else {
                                    it = it2;
                                    str = str4;
                                    try {
                                        linkedList.add(new HeaderEntry(next.getKey().toLowerCase(), str6));
                                    } catch (MalformedURLException e10) {
                                        e = e10;
                                        httpURLConnection2 = httpURLConnection;
                                        str4 = str;
                                        str5 = null;
                                        a.e(e, str4, new Object[0]);
                                        serverResponse.setStatus(ServerResponse.NsStatus.ERROR_MALFORMED_URI);
                                        callback.onFinished(serverResponse);
                                        if (httpRequest.skipInputStreamReading()) {
                                            httpURLConnection2.disconnect();
                                            c12 = 0;
                                            a.d("Disconnected", new Object[0]);
                                            TrafficStats.setThreadStatsTag(threadStatsTag);
                                            Object[] objArr = new Object[1];
                                            objArr[c12] = Integer.valueOf(threadStatsTag);
                                            a.d("Socket TAG reverted to: %d", objArr);
                                        } else {
                                            httpURLConnection2.disconnect();
                                            c12 = 0;
                                            a.d("Disconnected", new Object[0]);
                                            TrafficStats.setThreadStatsTag(threadStatsTag);
                                            Object[] objArr2 = new Object[1];
                                            objArr2[c12] = Integer.valueOf(threadStatsTag);
                                            a.d("Socket TAG reverted to: %d", objArr2);
                                        }
                                    } catch (UnknownHostException e11) {
                                        e = e11;
                                        httpURLConnection2 = httpURLConnection;
                                        str4 = str;
                                        str5 = null;
                                        a.e(e, str4, new Object[0]);
                                        serverResponse.setStatus(ServerResponse.NsStatus.ERROR_UNKNOWN_HOST);
                                        callback.onFinished(serverResponse);
                                        if (httpRequest.skipInputStreamReading()) {
                                            httpURLConnection2.disconnect();
                                            c11 = 0;
                                            a.d("Disconnected", new Object[0]);
                                            TrafficStats.setThreadStatsTag(threadStatsTag);
                                            Object[] objArr3 = new Object[1];
                                            objArr3[c11] = Integer.valueOf(threadStatsTag);
                                            a.d("Socket TAG reverted to: %d", objArr3);
                                        } else {
                                            httpURLConnection2.disconnect();
                                            c11 = 0;
                                            a.d("Disconnected", new Object[0]);
                                            TrafficStats.setThreadStatsTag(threadStatsTag);
                                            Object[] objArr32 = new Object[1];
                                            objArr32[c11] = Integer.valueOf(threadStatsTag);
                                            a.d("Socket TAG reverted to: %d", objArr32);
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str2 = null;
                                        try {
                                            String str7 = str;
                                            a.e(th, str7, new Object[0]);
                                            throw new AdblockPlusException(str7, th);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if ((httpRequest.skipInputStreamReading() || str2 == null) && httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                                c10 = 0;
                                                a.d("Disconnected", new Object[0]);
                                            } else {
                                                c10 = 0;
                                            }
                                            TrafficStats.setThreadStatsTag(threadStatsTag);
                                            Object[] objArr4 = new Object[1];
                                            objArr4[c10] = Integer.valueOf(threadStatsTag);
                                            a.d("Socket TAG reverted to: %d", objArr4);
                                            throw th;
                                        }
                                    }
                                }
                                it2 = it;
                                str4 = str;
                            }
                        }
                        str = str4;
                        serverResponse.setResponseHeaders(linkedList);
                        str3 = linkedList;
                    } else {
                        str = "WebRequest failed";
                        str3 = size;
                    }
                    try {
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            serverResponse.setResponseStatus(responseCode);
                            serverResponse.setStatus((HttpClient.isSuccessCode(responseCode) || HttpClient.isRedirectCode(responseCode)) ? ServerResponse.NsStatus.OK : ServerResponse.NsStatus.ERROR_FAILURE);
                            a.d("responseStatus: %d for url %s", Integer.valueOf(responseCode), url);
                            if (HttpClient.isSuccessCode(responseCode) || HttpClient.isRedirectCode(responseCode)) {
                                a.d("Success responseStatus", new Object[0]);
                                inputStream = httpURLConnection.getInputStream();
                            } else {
                                a.d("inputStream is set to Error stream", new Object[0]);
                                inputStream = httpURLConnection.getErrorStream();
                            }
                            try {
                                if (inputStream != null) {
                                    if (this.compressedStream && "gzip".equals(httpURLConnection.getContentEncoding()) && !HttpClient.isNoContentCode(responseCode)) {
                                        if (httpRequest.getMethod().equalsIgnoreCase("GET")) {
                                            inputStream = new GZIPInputStream(inputStream);
                                        } else if (httpRequest.getMethod().equalsIgnoreCase("HEAD")) {
                                            a.i("A payload body within a HEAD method must be empty.  URL %s", url);
                                        }
                                    }
                                    if (httpRequest.skipInputStreamReading()) {
                                        a.d("response.setInputStream(inputStream)", new Object[0]);
                                        InputStream connectionInputStream = new ConnectionInputStream(inputStream, httpURLConnection);
                                        try {
                                            serverResponse.setInputStream(connectionInputStream);
                                            inputStream = connectionInputStream;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            inputStream = connectionInputStream;
                                            if (!httpRequest.skipInputStreamReading() && inputStream != null) {
                                                a.d("Closing connection input stream", new Object[0]);
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        a.d("readFromInputStream(inputStream)", new Object[0]);
                                        serverResponse.setResponse(Utils.readFromInputStream(inputStream));
                                    }
                                } else {
                                    a.w("inputStream is null", new Object[0]);
                                }
                                if (!url.equals(httpURLConnection.getURL())) {
                                    a.d("Url was redirected, from: %s, to: %s", url, httpURLConnection.getURL());
                                    serverResponse.setFinalUrl(httpURLConnection.getURL().toString());
                                }
                                if (!httpRequest.skipInputStreamReading() && inputStream != null) {
                                    a.d("Closing connection input stream", new Object[0]);
                                    inputStream.close();
                                }
                                a.d("Downloading finished", new Object[0]);
                                callback.onFinished(serverResponse);
                                if (!httpRequest.skipInputStreamReading() || inputStream == null) {
                                    httpURLConnection.disconnect();
                                    c13 = 0;
                                    a.d("Disconnected", new Object[0]);
                                } else {
                                    c13 = 0;
                                }
                                TrafficStats.setThreadStatsTag(threadStatsTag);
                                Object[] objArr5 = new Object[1];
                                objArr5[c13] = Integer.valueOf(threadStatsTag);
                                a.d("Socket TAG reverted to: %d", objArr5);
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (MalformedURLException e12) {
                            e = e12;
                            httpURLConnection2 = httpURLConnection;
                            str4 = str;
                            str5 = str3;
                            a.e(e, str4, new Object[0]);
                            serverResponse.setStatus(ServerResponse.NsStatus.ERROR_MALFORMED_URI);
                            callback.onFinished(serverResponse);
                            if ((httpRequest.skipInputStreamReading() || str5 == null) && httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                c12 = 0;
                                a.d("Disconnected", new Object[0]);
                            } else {
                                c12 = 0;
                            }
                            TrafficStats.setThreadStatsTag(threadStatsTag);
                            Object[] objArr22 = new Object[1];
                            objArr22[c12] = Integer.valueOf(threadStatsTag);
                            a.d("Socket TAG reverted to: %d", objArr22);
                        } catch (UnknownHostException e13) {
                            e = e13;
                            httpURLConnection2 = httpURLConnection;
                            str4 = str;
                            str5 = str3;
                            a.e(e, str4, new Object[0]);
                            serverResponse.setStatus(ServerResponse.NsStatus.ERROR_UNKNOWN_HOST);
                            callback.onFinished(serverResponse);
                            if ((httpRequest.skipInputStreamReading() || str5 == null) && httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                c11 = 0;
                                a.d("Disconnected", new Object[0]);
                            } else {
                                c11 = 0;
                            }
                            TrafficStats.setThreadStatsTag(threadStatsTag);
                            Object[] objArr322 = new Object[1];
                            objArr322[c11] = Integer.valueOf(threadStatsTag);
                            a.d("Socket TAG reverted to: %d", objArr322);
                        } catch (Throwable th6) {
                            th = th6;
                            str2 = str3;
                            String str72 = str;
                            a.e(th, str72, new Object[0]);
                            throw new AdblockPlusException(str72, th);
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream = null;
                    }
                } catch (MalformedURLException e14) {
                    e = e14;
                    httpURLConnection2 = httpURLConnection;
                } catch (UnknownHostException e15) {
                    e = e15;
                    httpURLConnection2 = httpURLConnection;
                } catch (Throwable th8) {
                    th = th8;
                    str = str4;
                }
            } catch (MalformedURLException e16) {
                e = e16;
                str5 = null;
                httpURLConnection2 = null;
            } catch (UnknownHostException e17) {
                e = e17;
                str5 = null;
                httpURLConnection2 = null;
            } catch (Throwable th9) {
                th = th9;
                str = "WebRequest failed";
                httpURLConnection = null;
            }
        } catch (Throwable th10) {
            th = th10;
            HttpURLConnection httpURLConnection3 = httpURLConnection2;
            str2 = str5;
            httpURLConnection = httpURLConnection3;
            if (httpRequest.skipInputStreamReading()) {
                httpURLConnection.disconnect();
                c10 = 0;
                a.d("Disconnected", new Object[0]);
            } else {
                httpURLConnection.disconnect();
                c10 = 0;
                a.d("Disconnected", new Object[0]);
            }
            TrafficStats.setThreadStatsTag(threadStatsTag);
            Object[] objArr42 = new Object[1];
            objArr42[c10] = Integer.valueOf(threadStatsTag);
            a.d("Socket TAG reverted to: %d", objArr42);
            throw th;
        }
    }

    public AndroidHttpClient() {
        this(true);
    }
}
