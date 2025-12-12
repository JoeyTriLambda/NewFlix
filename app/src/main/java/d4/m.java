package d4;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;

/* compiled from: StringRequest.java */
/* loaded from: classes.dex */
public class m extends Request<String> {

    /* renamed from: b, reason: collision with root package name */
    public final Object f10846b;

    /* renamed from: m, reason: collision with root package name */
    public Response.Listener<String> f10847m;

    public m(int i10, String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i10, str, errorListener);
        this.f10846b = new Object();
        this.f10847m = listener;
    }

    @Override // com.android.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f10846b) {
            this.f10847m = null;
        }
    }

    @Override // com.android.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, e.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return Response.success(str, e.parseCacheHeaders(networkResponse));
    }

    @Override // com.android.volley.Request
    public void deliverResponse(String str) {
        Response.Listener<String> listener;
        synchronized (this.f10846b) {
            listener = this.f10847m;
        }
        if (listener != null) {
            listener.onResponse(str);
        }
    }
}
