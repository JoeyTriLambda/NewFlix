package d4;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.ClientError;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import d4.k;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: BasicNetwork.java */
/* loaded from: classes.dex */
public final class b implements Network {

    /* renamed from: a, reason: collision with root package name */
    public final a f10812a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10813b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws IOException, VolleyError {
        byte[] bArr;
        IOException e10;
        k.a aVar;
        k.a aVar2;
        String str;
        int timeoutMs;
        Map<String, String> mapEmptyMap;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            f fVar = null;
            try {
                Cache.Entry cacheEntry = request.getCacheEntry();
                if (cacheEntry == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str2 = cacheEntry.etag;
                    if (str2 != null) {
                        map.put("If-None-Match", str2);
                    }
                    long j10 = cacheEntry.lastModified;
                    if (j10 > 0) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
                        map.put("If-Modified-Since", simpleDateFormat.format(new Date(j10)));
                    }
                    mapEmptyMap = map;
                }
                f fVarExecuteRequest = this.f10812a.executeRequest(request, mapEmptyMap);
                try {
                    int statusCode = fVarExecuteRequest.getStatusCode();
                    List<Header> headers = fVarExecuteRequest.getHeaders();
                    if (statusCode == 304) {
                        return k.a(request, SystemClock.elapsedRealtime() - jElapsedRealtime, headers);
                    }
                    InputStream content = fVarExecuteRequest.getContent();
                    byte[] bArrB = content != null ? k.b(content, fVarExecuteRequest.getContentLength(), this.f10813b) : new byte[0];
                    k.c(SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArrB, statusCode);
                    if (statusCode < 200 || statusCode > 299) {
                        throw new IOException();
                    }
                    return new NetworkResponse(statusCode, bArrB, false, SystemClock.elapsedRealtime() - jElapsedRealtime, headers);
                } catch (IOException e11) {
                    e10 = e11;
                    bArr = null;
                    fVar = fVarExecuteRequest;
                    if (e10 instanceof SocketTimeoutException) {
                        aVar = new k.a("socket", new TimeoutError());
                    } else {
                        if (e10 instanceof MalformedURLException) {
                            throw new RuntimeException("Bad URL " + request.getUrl(), e10);
                        }
                        if (fVar != null) {
                            int statusCode2 = fVar.getStatusCode();
                            VolleyLog.e("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                            if (bArr != null) {
                                NetworkResponse networkResponse = new NetworkResponse(statusCode2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, fVar.getHeaders());
                                if (statusCode2 == 401 || statusCode2 == 403) {
                                    aVar2 = new k.a("auth", new AuthFailureError(networkResponse));
                                } else {
                                    if (statusCode2 >= 400 && statusCode2 <= 499) {
                                        throw new ClientError(networkResponse);
                                    }
                                    if (statusCode2 < 500 || statusCode2 > 599 || !request.shouldRetryServerErrors()) {
                                        throw new ServerError(networkResponse);
                                    }
                                    aVar2 = new k.a("server", new ServerError(networkResponse));
                                }
                                aVar = aVar2;
                            } else {
                                aVar = new k.a("network", new NetworkError());
                            }
                        } else {
                            if (!request.shouldRetryConnectionErrors()) {
                                throw new NoConnectionError(e10);
                            }
                            aVar = new k.a("connection", new NoConnectionError());
                        }
                    }
                    str = aVar.f10843a;
                    RetryPolicy retryPolicy = request.getRetryPolicy();
                    timeoutMs = request.getTimeoutMs();
                    try {
                        retryPolicy.retry(aVar.f10844b);
                        request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
                    } catch (VolleyError e12) {
                        request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
                        throw e12;
                    }
                }
            } catch (IOException e13) {
                bArr = null;
                e10 = e13;
            }
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        }
    }

    public b(a aVar, c cVar) {
        this.f10812a = aVar;
        this.f10813b = cVar;
    }
}
