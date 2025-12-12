package ub;

import android.util.Log;
import com.android.volley.Response;
import flix.com.vision.activities.TraktSignInActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class n2 implements Response.Listener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20238b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ TraktSignInActivity f20239m;

    public /* synthetic */ n2(TraktSignInActivity traktSignInActivity, int i10) {
        this.f20238b = i10;
        this.f20239m = traktSignInActivity;
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) throws JSONException {
        int i10 = this.f20238b;
        TraktSignInActivity traktSignInActivity = this.f20239m;
        switch (i10) {
            case 0:
                JSONObject jSONObject = (JSONObject) obj;
                int i11 = TraktSignInActivity.Z;
                traktSignInActivity.getClass();
                try {
                    String string = jSONObject.getString("device_code");
                    String string2 = jSONObject.getString("user_code");
                    int i12 = jSONObject.getInt("expires_in");
                    int i13 = jSONObject.getInt("interval");
                    traktSignInActivity.N = string;
                    traktSignInActivity.O = string2;
                    traktSignInActivity.Q = i13;
                    traktSignInActivity.P = i12 * 1000;
                    traktSignInActivity.T.setText(traktSignInActivity.O + "");
                    traktSignInActivity.S.setVisibility(8);
                    traktSignInActivity.R.setVisibility(0);
                    s2 s2Var = new s2(traktSignInActivity, (long) (traktSignInActivity.Q * 1000));
                    traktSignInActivity.M = s2Var;
                    s2Var.start();
                    break;
                } catch (JSONException e10) {
                    e10.printStackTrace();
                } catch (Exception unused) {
                    return;
                }
            default:
                JSONObject jSONObject2 = (JSONObject) obj;
                if (!traktSignInActivity.Y) {
                    try {
                        new r2(traktSignInActivity, jSONObject2).execute(new String[0]);
                        break;
                    } catch (Exception unused2) {
                        Log.d("", "");
                        return;
                    }
                }
                break;
        }
    }
}
