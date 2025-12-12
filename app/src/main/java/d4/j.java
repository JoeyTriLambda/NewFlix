package d4;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* compiled from: JsonRequest.java */
/* loaded from: classes.dex */
public abstract class j<T> extends Request<T> {

    /* renamed from: o, reason: collision with root package name */
    public static final String f10839o = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: b, reason: collision with root package name */
    public final Object f10840b;

    /* renamed from: m, reason: collision with root package name */
    public Response.Listener<T> f10841m;

    /* renamed from: n, reason: collision with root package name */
    public final String f10842n;

    public j(int i10, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i10, str, errorListener);
        this.f10840b = new Object();
        this.f10841m = listener;
        this.f10842n = str2;
    }

    @Override // com.android.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f10840b) {
            this.f10841m = null;
        }
    }

    @Override // com.android.volley.Request
    public void deliverResponse(T t10) {
        Response.Listener<T> listener;
        synchronized (this.f10840b) {
            listener = this.f10841m;
        }
        if (listener != null) {
            listener.onResponse(t10);
        }
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        String str = this.f10842n;
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", str, "utf-8");
            return null;
        }
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return f10839o;
    }

    @Override // com.android.volley.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.android.volley.Request
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }
}
