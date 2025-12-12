package flix.com.vision.activities.adult;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import c4.a;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.adult.AdultPINSetupActivity;
import flix.com.vision.tv.Constant;
import r.j;

/* loaded from: classes2.dex */
public class AdultPINSetupActivity extends j {
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
    public EditText T;

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_adult_pin_setup);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.L = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.K = new a();
        this.R = (RelativeLayout) findViewById(R.id.main_relative_view);
        this.O = (TextView) findViewById(R.id.adult_pin_set_title);
        this.Q = (RelativeLayout) findViewById(R.id.save_button);
        this.P = (RelativeLayout) findViewById(R.id.cancel_button);
        this.S = (EditText) findViewById(R.id.edit_text_enter_pin);
        this.T = (EditText) findViewById(R.id.edit_text_repeat_pin);
        this.M = (TextView) findViewById(R.id.save_open_label);
        this.N = (TextView) findViewById(R.id.save_label);
        App.extractDominantColor(this.R);
        this.S.clearFocus();
        final int i10 = 0;
        this.P.setOnClickListener(new View.OnClickListener(this) { // from class: vb.f

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultPINSetupActivity f20661m;

            {
                this.f20661m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                AdultPINSetupActivity adultPINSetupActivity = this.f20661m;
                switch (i11) {
                    case 0:
                        int i12 = AdultPINSetupActivity.U;
                        adultPINSetupActivity.finish();
                        break;
                    default:
                        String string = adultPINSetupActivity.S.getText().toString();
                        if (!string.equalsIgnoreCase(adultPINSetupActivity.T.getText().toString())) {
                            Toast.makeText(adultPINSetupActivity.getBaseContext(), "Please repeat same PIN", 1).show();
                            break;
                        } else {
                            App.getInstance().f11574v.edit().putBoolean("pref_adult_zone_pin_set", true).apply();
                            App.getInstance().f11574v.edit().putString("pref_adult_zone_pin", string).apply();
                            Toast.makeText(adultPINSetupActivity.getBaseContext(), "PIN Successfully Saved", 1).show();
                            adultPINSetupActivity.finish();
                            break;
                        }
                }
            }
        });
        final int i11 = 1;
        this.Q.setOnClickListener(new View.OnClickListener(this) { // from class: vb.f

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultPINSetupActivity f20661m;

            {
                this.f20661m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                AdultPINSetupActivity adultPINSetupActivity = this.f20661m;
                switch (i112) {
                    case 0:
                        int i12 = AdultPINSetupActivity.U;
                        adultPINSetupActivity.finish();
                        break;
                    default:
                        String string = adultPINSetupActivity.S.getText().toString();
                        if (!string.equalsIgnoreCase(adultPINSetupActivity.T.getText().toString())) {
                            Toast.makeText(adultPINSetupActivity.getBaseContext(), "Please repeat same PIN", 1).show();
                            break;
                        } else {
                            App.getInstance().f11574v.edit().putBoolean("pref_adult_zone_pin_set", true).apply();
                            App.getInstance().f11574v.edit().putString("pref_adult_zone_pin", string).apply();
                            Toast.makeText(adultPINSetupActivity.getBaseContext(), "PIN Successfully Saved", 1).show();
                            adultPINSetupActivity.finish();
                            break;
                        }
                }
            }
        });
        this.K.applyFontToView(this.M, this.L);
        this.K.applyFontToView(this.O, this.L);
        this.K.applyFontToView(this.N, this.L);
        this.K.applyFontToView(this.S, this.L);
        this.K.applyFontToView(this.T, this.L);
    }
}
