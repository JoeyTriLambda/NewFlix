package ub;

import com.android.volley.AuthFailureError;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: TraktSignInActivity.java */
/* loaded from: classes2.dex */
public final class q2 extends d4.i {
    public q2(JSONObject jSONObject, n2 n2Var, p2 p2Var) {
        super(1, "https://api.trakt.tv/oauth/device/token", jSONObject, n2Var, p2Var);
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        return ac.c.w("Content-Type", "application/json");
    }
}
