package flix.com.vision.api.realdebrid;

import ac.c;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import flix.com.vision.App;
import flix.com.vision.R;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.j;

/* loaded from: classes2.dex */
public class RealDebridLoginActivity extends j {
    public static final /* synthetic */ int R = 0;
    public SpinKitView K;
    public TextView L;
    public String M;
    public String N;
    public String O;
    public String P;
    public SharedPreferences Q;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.real_debrid_activiity);
        try {
            getWindow().addFlags(128);
        } catch (Exception unused) {
        }
        App.getInstance().f11574v.edit().putBoolean("RD_CLEANED", true).apply();
        this.K = (SpinKitView) findViewById(R.id.loader);
        this.L = (TextView) findViewById(R.id.rd_code);
        this.Q = App.getInstance().f11574v;
        new OkHttpClient().newCall(new Request.Builder().header("User-Agent", RealDebridCommon.f12055t).url(RealDebridCommon.f12053r).build()).enqueue(new a());
    }

    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IllegalAccessException, JSONException, IOException, IllegalArgumentException, InvocationTargetException {
            RealDebridLoginActivity realDebridLoginActivity = RealDebridLoginActivity.this;
            if (!response.isSuccessful()) {
                throw new IOException("error " + response);
            }
            ResponseBody responseBodyBody = response.body();
            Objects.requireNonNull(responseBodyBody);
            String strString = responseBodyBody.string();
            StringBuilder sb2 = new StringBuilder("{\n  \"results\": [");
            String str = RealDebridCommon.f12047b;
            try {
                JSONArray jSONArray = new JSONObject(c.o(sb2, strString, "]\n}")).getJSONArray("results");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    realDebridLoginActivity.M = jSONObject.getString("device_code");
                    realDebridLoginActivity.N = jSONObject.getString("user_code");
                    jSONObject.getInt("interval");
                    realDebridLoginActivity.getClass();
                    jSONObject.getInt("expires_in");
                    realDebridLoginActivity.getClass();
                    jSONObject.getString("verification_url");
                    realDebridLoginActivity.getClass();
                }
            } catch (Exception unused) {
            }
            int i11 = RealDebridLoginActivity.R;
            realDebridLoginActivity.getClass();
            new Handler(Looper.getMainLooper()).post(new ec.a(realDebridLoginActivity, 0));
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
        }
    }
}
