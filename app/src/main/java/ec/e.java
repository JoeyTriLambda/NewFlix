package ec;

import android.content.Context;
import android.content.SharedPreferences;
import flix.com.vision.App;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RealDebridRefreshModule.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f11203a;

    /* renamed from: b, reason: collision with root package name */
    public static String f11204b;

    /* renamed from: c, reason: collision with root package name */
    public static String f11205c;

    /* renamed from: d, reason: collision with root package name */
    public static String f11206d;

    /* compiled from: RealDebridRefreshModule.java */
    public class a implements Callback {
        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            iOException.printStackTrace();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IllegalAccessException, JSONException, IOException, IllegalArgumentException, InvocationTargetException {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                Objects.requireNonNull(responseBodyBody);
                String strString = responseBodyBody.string();
                StringBuilder sb2 = new StringBuilder("{\n  \"results\": [");
                String str = RealDebridCommon.f12047b;
                try {
                    JSONArray jSONArray = new JSONObject(ac.c.o(sb2, strString, "]\n}")).getJSONArray("results");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        RealDebridCommon.f12047b = jSONObject.getString("access_token");
                        e.f11204b = jSONObject.getString("refresh_token");
                        RealDebridCommon.f12049n = jSONObject.getString("token_type");
                    }
                    e.f11203a.edit().putString("ACCESS_TOKEN", RealDebridCommon.f12047b).apply();
                    e.f11203a.edit().putString("REFRESH_TOKEN", e.f11204b).apply();
                    e.f11203a.edit().putString("TOKEN_TYPE", RealDebridCommon.f12049n).apply();
                    e.f11203a.edit().putBoolean("IS_RD_LOGGED_IN", true).apply();
                    RealDebridCommon.f12051p = true;
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public e(Context context) {
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        f11203a = sharedPreferences;
        f11204b = sharedPreferences.getString("REFRESH_TOKEN", null);
        f11205c = f11203a.getString("CLIENT_ID", null);
        f11206d = f11203a.getString("CLIENT_SECRET", null);
        f11203a.getString("DEVICE_CODE", null);
    }

    public static String Do_Async() {
        new OkHttpClient().newCall(new Request.Builder().header("User-Agent", RealDebridCommon.f12055t).url(RealDebridCommon.f12054s).post(new FormBody.Builder().add("client_id", f11205c).add("client_secret", f11206d).add("code", f11204b).add("grant_type", "http://oauth.net/grant_type/device/1.0").build()).build()).enqueue(new a());
        return RealDebridCommon.f12047b;
    }
}
