package d4;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest.java */
/* loaded from: classes.dex */
public class i extends j<JSONObject> {
    public i(int i10, String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i10, str, jSONObject == null ? null : jSONObject.toString(), listener, errorListener);
    }

    @Override // com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONObject(new String(networkResponse.data, e.parseCharset(networkResponse.headers, "utf-8"))), e.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e10) {
            return Response.error(new ParseError(e10));
        } catch (JSONException e11) {
            return Response.error(new ParseError(e11));
        }
    }
}
