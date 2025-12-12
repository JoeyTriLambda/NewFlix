package ub;

import android.os.CountDownTimer;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.activities.TraktSignInActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TraktSignInActivity.java */
/* loaded from: classes2.dex */
public final class s2 extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TraktSignInActivity f20273a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(TraktSignInActivity traktSignInActivity, long j10) {
        super(j10, 1000L);
        this.f20273a = traktSignInActivity;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        JSONObject jSONObject;
        TraktSignInActivity traktSignInActivity = this.f20273a;
        int i10 = 1;
        if (!traktSignInActivity.Y) {
            try {
                jSONObject = new JSONObject(ac.c.o(new StringBuilder("{\n    \"code\": \""), traktSignInActivity.N, "\",\n    \"client_id\": \"39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c\",\n    \"client_secret\": \"86227e303a08cf769cd77dc1691477f3e24a65f890431115c71369becdfe85b6\"\n}"));
            } catch (JSONException e10) {
                e10.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                App.getInstance().getRequestQueue().add(new q2(jSONObject, new n2(traktSignInActivity, i10), new p2()));
            }
        }
        int i11 = traktSignInActivity.P - (traktSignInActivity.Q * 1000);
        traktSignInActivity.P = i11;
        if (i11 >= 0) {
            traktSignInActivity.M.start();
            return;
        }
        traktSignInActivity.M.cancel();
        Toast.makeText(traktSignInActivity.getBaseContext(), "Time out", 1).show();
        traktSignInActivity.finish();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j10) {
    }
}
