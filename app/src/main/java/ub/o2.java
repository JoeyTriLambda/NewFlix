package ub;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: TraktSignInActivity.java */
/* loaded from: classes2.dex */
public final class o2 extends d4.i {
    public o2(JSONObject jSONObject, n2 n2Var, n0 n0Var) {
        super(1, "https://api.trakt.tv/oauth/device/code", jSONObject, n2Var, n0Var);
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() {
        return ac.c.w("Content-Type", "application/json");
    }
}
