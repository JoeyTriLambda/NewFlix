package ub;

import android.os.AsyncTask;
import com.uwetrottmann.trakt5.TraktV2;
import com.uwetrottmann.trakt5.entities.User;
import com.uwetrottmann.trakt5.entities.UserSlug;
import com.uwetrottmann.trakt5.enums.Extended;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.TraktSignInActivity;
import flix.com.vision.helpers.Constants;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Response;

/* compiled from: TraktSignInActivity.java */
/* loaded from: classes2.dex */
public final class r2 extends AsyncTask<String, String, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f20263a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TraktSignInActivity f20264b;

    public r2(TraktSignInActivity traktSignInActivity, JSONObject jSONObject) {
        this.f20264b = traktSignInActivity;
        this.f20263a = jSONObject;
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(String... strArr) throws JSONException {
        JSONObject jSONObject = this.f20263a;
        TraktSignInActivity traktSignInActivity = this.f20264b;
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("refresh_token");
            App.getInstance().f11574v.edit().putString("trakt_access_token", string).apply();
            App.getInstance().f11574v.edit().putString("trakt_refresh_token", string2).apply();
            TraktV2 traktV2 = new TraktV2(traktSignInActivity.getString(R.string.trakt_client_id));
            traktV2.accessToken(string);
            traktV2.refreshToken(string2);
            traktV2.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
            Response<User> responseExecute = traktV2.users().profile(UserSlug.ME, Extended.FULL).execute();
            if (responseExecute.isSuccessful()) {
                String str = responseExecute.body().username;
                String str2 = responseExecute.body().images.avatar.full;
                App.getInstance().f11574v.edit().putString("trakt_user_name", str).apply();
                App.getInstance().f11574v.edit().putString("trakt_avatar", str2).apply();
                App.getInstance().f11574v.edit().putBoolean("trakt_user_logged_in", true).apply();
                EventBus.getDefault().post(Constants.TRAKT_TV_EVENT.USER_LOGGED_IN);
                traktSignInActivity.Y = true;
                traktSignInActivity.finish();
                traktSignInActivity.M.cancel();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return Boolean.TRUE;
    }
}
