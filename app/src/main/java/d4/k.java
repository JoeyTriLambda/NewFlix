package d4;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: NetworkUtility.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: NetworkUtility.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10843a;

        /* renamed from: b, reason: collision with root package name */
        public final VolleyError f10844b;

        public a(String str, VolleyError volleyError) {
            this.f10843a = str;
            this.f10844b = volleyError;
        }
    }

    public static NetworkResponse a(Request<?> request, long j10, List<Header> list) {
        Cache.Entry cacheEntry = request.getCacheEntry();
        if (cacheEntry == null) {
            return new NetworkResponse(HttpStatus.SC_NOT_MODIFIED, (byte[]) null, true, j10, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<Header> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = cacheEntry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header : cacheEntry.allResponseHeaders) {
                    if (!treeSet.contains(header.getName())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!cacheEntry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry : cacheEntry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
        }
        return new NetworkResponse(HttpStatus.SC_NOT_MODIFIED, cacheEntry.data, true, j10, (List<Header>) arrayList);
    }

    public static byte[] b(InputStream inputStream, int i10, c cVar) throws Throwable {
        byte[] buf;
        l lVar = new l(cVar, i10);
        try {
            buf = cVar.getBuf(1024);
            while (true) {
                try {
                    int i11 = inputStream.read(buf);
                    if (i11 == -1) {
                        break;
                    }
                    lVar.write(buf, 0, i11);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                    cVar.returnBuf(buf);
                    lVar.close();
                    throw th;
                }
            }
            byte[] byteArray = lVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            cVar.returnBuf(buf);
            lVar.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            buf = null;
        }
    }

    public static void c(long j10, Request<?> request, byte[] bArr, int i10) {
        if (VolleyLog.DEBUG || j10 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j10);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i10);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }
}
