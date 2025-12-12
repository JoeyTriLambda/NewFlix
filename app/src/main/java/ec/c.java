package ec;

import android.os.Handler;
import android.os.Looper;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.api.realdebrid.RealDebridLoginActivity;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RealDebridLoginActivity.java */
/* loaded from: classes2.dex */
public final class c implements Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealDebridLoginActivity f11201a;

    public c(RealDebridLoginActivity realDebridLoginActivity) {
        this.f11201a = realDebridLoginActivity;
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IllegalAccessException, JSONException, IOException, IllegalArgumentException, InvocationTargetException {
        boolean zIsSuccessful = response.isSuccessful();
        RealDebridLoginActivity realDebridLoginActivity = this.f11201a;
        if (!zIsSuccessful) {
            int i10 = RealDebridLoginActivity.R;
            realDebridLoginActivity.getClass();
            new Handler(Looper.getMainLooper()).postDelayed(new a(realDebridLoginActivity, 1), 5000L);
            return;
        }
        ResponseBody responseBodyBody = response.body();
        Objects.requireNonNull(responseBodyBody);
        String strString = responseBodyBody.string();
        StringBuilder sb2 = new StringBuilder("{\n  \"results\": [");
        String str = RealDebridCommon.f12047b;
        try {
            JSONArray jSONArray = new JSONObject(ac.c.o(sb2, strString, "]\n}")).getJSONArray("results");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                realDebridLoginActivity.O = jSONObject.getString("client_id");
                realDebridLoginActivity.P = jSONObject.getString("client_secret");
                realDebridLoginActivity.Q.edit().putString("CLIENT_ID", realDebridLoginActivity.O).apply();
                realDebridLoginActivity.Q.edit().putString("CLIENT_SECRET", realDebridLoginActivity.P).apply();
                realDebridLoginActivity.Q.edit().putString("DEVICE_CODE", realDebridLoginActivity.M).apply();
            }
            int i12 = RealDebridLoginActivity.R;
            realDebridLoginActivity.getClass();
            new Handler(Looper.getMainLooper()).post(new a(realDebridLoginActivity, 2));
        } catch (Exception unused) {
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
    }
}
