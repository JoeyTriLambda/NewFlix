package ec;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.o;
import com.google.gson.q;
import flix.com.vision.App;
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
import se.f;

/* compiled from: RealDebridLoginActivity.java */
/* loaded from: classes2.dex */
public final class d implements Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealDebridLoginActivity f11202a;

    public d(RealDebridLoginActivity realDebridLoginActivity) {
        this.f11202a = realDebridLoginActivity;
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IllegalAccessException, JSONException, IOException, IllegalArgumentException, InvocationTargetException {
        boolean zIsSuccessful = response.isSuccessful();
        final RealDebridLoginActivity realDebridLoginActivity = this.f11202a;
        if (!zIsSuccessful) {
            int i10 = RealDebridLoginActivity.R;
            realDebridLoginActivity.getClass();
            new Handler(Looper.getMainLooper()).post(new a(realDebridLoginActivity, 2));
            return;
        }
        ResponseBody responseBodyBody = response.body();
        Objects.requireNonNull(responseBodyBody);
        String strString = responseBodyBody.string();
        StringBuilder sb2 = new StringBuilder("{\n  \"results\": [");
        String str = RealDebridCommon.f12047b;
        try {
            JSONArray jSONArray = new JSONObject(ac.c.o(sb2, strString, "]\n}")).getJSONArray("results");
            final int i11 = 0;
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i12);
                RealDebridCommon.f12047b = jSONObject.getString("access_token");
                RealDebridCommon.f12048m = jSONObject.getString("refresh_token");
                RealDebridCommon.f12049n = jSONObject.getString("token_type");
            }
            realDebridLoginActivity.Q.edit().putString("ACCESS_TOKEN", RealDebridCommon.f12047b).apply();
            realDebridLoginActivity.Q.edit().putString("REFRESH_TOKEN", RealDebridCommon.f12048m).apply();
            realDebridLoginActivity.Q.edit().putString("TOKEN_TYPE", RealDebridCommon.f12049n).apply();
            final int i13 = 1;
            realDebridLoginActivity.Q.edit().putBoolean("IS_RD_LOGGED_IN", true).apply();
            RealDebridCommon.f12051p = true;
            new Handler(Looper.getMainLooper()).post(new vb.d(this, 3));
            bc.a.getRealDebridUserAccount(RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new f() { // from class: ec.b
                @Override // se.f
                public final void accept(Object obj) {
                    int i14 = i11;
                    RealDebridLoginActivity realDebridLoginActivity2 = realDebridLoginActivity;
                    switch (i14) {
                        case 0:
                            int i15 = RealDebridLoginActivity.R;
                            realDebridLoginActivity2.getClass();
                            q asJsonObject = ((o) obj).getAsJsonObject();
                            SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                            String asString = asJsonObject.get("username").getAsString();
                            String asString2 = asJsonObject.get("type").getAsString();
                            String asString3 = asJsonObject.get("expiration").getAsString();
                            editorEdit.putString("REAL_DEBRID_USERNAME", asString);
                            editorEdit.putString("REAL_DEBRID_A_TYPE", asString2);
                            editorEdit.putString("REAL_DEBRID_EXPIRATION", asString3);
                            editorEdit.apply();
                            editorEdit.commit();
                            realDebridLoginActivity2.finish();
                            break;
                        default:
                            int i16 = RealDebridLoginActivity.R;
                            realDebridLoginActivity2.finish();
                            break;
                    }
                }
            }, new f() { // from class: ec.b
                @Override // se.f
                public final void accept(Object obj) {
                    int i14 = i13;
                    RealDebridLoginActivity realDebridLoginActivity2 = realDebridLoginActivity;
                    switch (i14) {
                        case 0:
                            int i15 = RealDebridLoginActivity.R;
                            realDebridLoginActivity2.getClass();
                            q asJsonObject = ((o) obj).getAsJsonObject();
                            SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                            String asString = asJsonObject.get("username").getAsString();
                            String asString2 = asJsonObject.get("type").getAsString();
                            String asString3 = asJsonObject.get("expiration").getAsString();
                            editorEdit.putString("REAL_DEBRID_USERNAME", asString);
                            editorEdit.putString("REAL_DEBRID_A_TYPE", asString2);
                            editorEdit.putString("REAL_DEBRID_EXPIRATION", asString3);
                            editorEdit.apply();
                            editorEdit.commit();
                            realDebridLoginActivity2.finish();
                            break;
                        default:
                            int i16 = RealDebridLoginActivity.R;
                            realDebridLoginActivity2.finish();
                            break;
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
    }
}
