package flix.com.vision.activities.adult;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import c4.a;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.tv.Constant;
import kc.d;
import r.j;
import vb.k;
import vb.l;

/* loaded from: classes2.dex */
public class AdultZonePINEntryActivity extends j {
    public static final /* synthetic */ int U = 0;
    public a K;
    public Typeface L;
    public TextView M;
    public TextView N;
    public TextView O;
    public RelativeLayout P;
    public RelativeLayout Q;
    public RelativeLayout R;
    public EditText S;
    public boolean T = false;

    public final void d() {
        if (!this.S.getText().toString().equalsIgnoreCase(App.getInstance().f11574v.getString("pref_adult_zone_pin", null))) {
            Toast.makeText(getBaseContext(), "Wrong PIN!", 1).show();
            this.S.setText("");
            return;
        }
        if (this.T) {
            App.getInstance().f11574v.edit().putBoolean("pref_adult_zone_pin_set", false).apply();
            startActivity(new Intent(this, (Class<?>) AdultPINSetupActivity.class));
            finish();
            return;
        }
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, false);
        dVarNewInstance.setTitle("Adult Only");
        dVarNewInstance.setMessage("Can you please confirm YOU ARE 18+ ?");
        dVarNewInstance.setButton1("NEVER MIND", new l(this, 2));
        dVarNewInstance.setButton2("YES, I AM", new l(this, 3));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.adult_pin_entry_activity);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.L = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.K = new a();
        int i10 = 0;
        this.T = getIntent().getBooleanExtra("isPINChange", false);
        this.R = (RelativeLayout) findViewById(R.id.main_relative_view);
        this.Q = (RelativeLayout) findViewById(R.id.confirm_pin_button);
        this.P = (RelativeLayout) findViewById(R.id.cancel_button);
        this.S = (EditText) findViewById(R.id.edit_text_enter_pin);
        this.O = (TextView) findViewById(R.id.adult_pin_entry_title);
        this.M = (TextView) findViewById(R.id.confirm_adult_label);
        this.N = (TextView) findViewById(R.id.save_label);
        App.extractDominantColor(this.R);
        this.S.setOnEditorActionListener(new k(this, i10));
        this.P.setOnClickListener(new l(this, i10));
        this.Q.setOnClickListener(new l(this, 1));
        this.K.applyFontToView(this.M, this.L);
        this.K.applyFontToView(this.N, this.L);
        this.K.applyFontToView(this.S, this.L);
        this.K.applyFontToView(this.O, this.L);
    }
}
