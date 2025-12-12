package flix.com.vision.activities;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.ybq.android.spinkit.SpinKitView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.tv.Constant;
import org.json.JSONException;
import org.json.JSONObject;
import r.j;
import ub.n0;
import ub.n2;
import ub.o2;
import ub.s2;

/* loaded from: classes2.dex */
public class TraktSignInActivity extends j {
    public static final /* synthetic */ int Z = 0;
    public c4.a K;
    public Typeface L;
    public s2 M;
    public String N;
    public String O;
    public int P;
    public int Q;
    public LinearLayout R;
    public SpinKitView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public boolean Y = false;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        try {
            this.M.cancel();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        JSONObject jSONObject;
        super.onCreate(bundle);
        setContentView(R.layout.activity_trakt_activation);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.L = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.K = new c4.a();
        this.R = (LinearLayout) findViewById(R.id.main_content);
        this.S = (SpinKitView) findViewById(R.id.loader);
        this.T = (TextView) findViewById(R.id.activation_code_text);
        this.U = (TextView) findViewById(R.id.trakt_text_1);
        this.V = (TextView) findViewById(R.id.trakt_text_2);
        this.W = (TextView) findViewById(R.id.trakt_text_3);
        this.X = (TextView) findViewById(R.id.trakt_text_4);
        this.K.applyFontToView(this.U, this.L);
        this.K.applyFontToView(this.V, this.L);
        this.K.applyFontToView(this.W, this.L);
        this.K.applyFontToView(this.X, this.L);
        this.K.applyFontToView(this.T, this.L);
        try {
            jSONObject = new JSONObject("{\n    \"client_id\": \"39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c\"\n}");
        } catch (JSONException e10) {
            e10.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        App.getInstance().getRequestQueue().add(new o2(jSONObject, new n2(this, 0), new n0(18)));
    }
}
