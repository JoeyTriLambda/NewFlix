package flix.com.vision.tv;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import c4.a;
import com.unity3d.ads.metadata.MediationMetaData;
import com.uwetrottmann.trakt5.TraktV2;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.tv.M3UImportActivity;
import flix.com.vision.tv.MyImportActivity;
import flix.com.vision.tv.TVCategoriesActivity2;
import org.apache.commons.lang3.StringUtils;
import r.j;

/* loaded from: classes2.dex */
public class M3UImportActivity extends j {
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
        setContentView(R.layout.activity_m3u_import);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.L = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.K = new a();
        this.R = (RelativeLayout) findViewById(R.id.main_relative_view);
        this.O = (TextView) findViewById(R.id.m3u_import_label);
        this.Q = (RelativeLayout) findViewById(R.id.save_and_open_button);
        this.P = (RelativeLayout) findViewById(R.id.save_button);
        this.S = (EditText) findViewById(R.id.edit_text_url);
        this.T = (EditText) findViewById(R.id.edit_text_name);
        this.M = (TextView) findViewById(R.id.save_open_label);
        this.N = (TextView) findViewById(R.id.save_label);
        App.extractDominantColor(this.R);
        final int i10 = 0;
        this.P.setOnClickListener(new View.OnClickListener(this) { // from class: ae.d

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ M3UImportActivity f644m;

            {
                this.f644m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                M3UImportActivity m3UImportActivity = this.f644m;
                switch (i11) {
                    case 0:
                        String strTrim = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                        if (!strTrim.contains("http://") && !strTrim.contains("https://")) {
                            Toast.makeText(m3UImportActivity.getBaseContext(), "url not valid. should start with http:// or https://", 0).show();
                            break;
                        } else {
                            String string = m3UImportActivity.T.getText().toString();
                            if (!string.isEmpty() && string.length() >= 2) {
                                String strTrim2 = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                                String string2 = m3UImportActivity.T.getText().toString();
                                hd.h hVar = new hd.h();
                                hVar.f13009m = string2;
                                hVar.f13008b = strTrim2;
                                hVar.f13010n = TraktV2.API_VERSION;
                                App.getInstance().f11573u.addHistoryIPTV(hVar);
                                m3UImportActivity.startActivity(new Intent(m3UImportActivity, (Class<?>) MyImportActivity.class));
                                m3UImportActivity.finish();
                                break;
                            } else {
                                Toast.makeText(m3UImportActivity.getBaseContext(), "Please enter playlist name", 0).show();
                                break;
                            }
                        }
                        break;
                    default:
                        String strTrim3 = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                        if (!strTrim3.contains("http://") && !strTrim3.contains("https://")) {
                            Toast.makeText(m3UImportActivity.getBaseContext(), "url not valid", 0).show();
                            break;
                        } else {
                            String string3 = m3UImportActivity.T.getText().toString();
                            if (!string3.isEmpty() && string3.length() >= 2) {
                                String strTrim4 = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                                String string4 = m3UImportActivity.T.getText().toString();
                                hd.h hVar2 = new hd.h();
                                hVar2.f13009m = string4;
                                hVar2.f13008b = strTrim4;
                                hVar2.f13010n = TraktV2.API_VERSION;
                                App.getInstance().f11573u.addHistoryIPTV(hVar2);
                                Intent intent = new Intent(m3UImportActivity, (Class<?>) TVCategoriesActivity2.class);
                                intent.putExtra("is_file", false);
                                intent.putExtra("url", strTrim4.replace(StringUtils.SPACE, "").trim());
                                intent.putExtra(MediationMetaData.KEY_NAME, m3UImportActivity.T.getText().toString());
                                m3UImportActivity.startActivity(intent);
                                App.getInstance().f11573u.addHistoryIPTV(hVar2);
                                m3UImportActivity.finish();
                                break;
                            } else {
                                Toast.makeText(m3UImportActivity.getBaseContext(), "Please enter playlist name", 0).show();
                                break;
                            }
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        this.Q.setOnClickListener(new View.OnClickListener(this) { // from class: ae.d

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ M3UImportActivity f644m;

            {
                this.f644m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                M3UImportActivity m3UImportActivity = this.f644m;
                switch (i112) {
                    case 0:
                        String strTrim = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                        if (!strTrim.contains("http://") && !strTrim.contains("https://")) {
                            Toast.makeText(m3UImportActivity.getBaseContext(), "url not valid. should start with http:// or https://", 0).show();
                            break;
                        } else {
                            String string = m3UImportActivity.T.getText().toString();
                            if (!string.isEmpty() && string.length() >= 2) {
                                String strTrim2 = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                                String string2 = m3UImportActivity.T.getText().toString();
                                hd.h hVar = new hd.h();
                                hVar.f13009m = string2;
                                hVar.f13008b = strTrim2;
                                hVar.f13010n = TraktV2.API_VERSION;
                                App.getInstance().f11573u.addHistoryIPTV(hVar);
                                m3UImportActivity.startActivity(new Intent(m3UImportActivity, (Class<?>) MyImportActivity.class));
                                m3UImportActivity.finish();
                                break;
                            } else {
                                Toast.makeText(m3UImportActivity.getBaseContext(), "Please enter playlist name", 0).show();
                                break;
                            }
                        }
                        break;
                    default:
                        String strTrim3 = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                        if (!strTrim3.contains("http://") && !strTrim3.contains("https://")) {
                            Toast.makeText(m3UImportActivity.getBaseContext(), "url not valid", 0).show();
                            break;
                        } else {
                            String string3 = m3UImportActivity.T.getText().toString();
                            if (!string3.isEmpty() && string3.length() >= 2) {
                                String strTrim4 = m3UImportActivity.S.getText().toString().replace(StringUtils.SPACE, "").trim();
                                String string4 = m3UImportActivity.T.getText().toString();
                                hd.h hVar2 = new hd.h();
                                hVar2.f13009m = string4;
                                hVar2.f13008b = strTrim4;
                                hVar2.f13010n = TraktV2.API_VERSION;
                                App.getInstance().f11573u.addHistoryIPTV(hVar2);
                                Intent intent = new Intent(m3UImportActivity, (Class<?>) TVCategoriesActivity2.class);
                                intent.putExtra("is_file", false);
                                intent.putExtra("url", strTrim4.replace(StringUtils.SPACE, "").trim());
                                intent.putExtra(MediationMetaData.KEY_NAME, m3UImportActivity.T.getText().toString());
                                m3UImportActivity.startActivity(intent);
                                App.getInstance().f11573u.addHistoryIPTV(hVar2);
                                m3UImportActivity.finish();
                                break;
                            } else {
                                Toast.makeText(m3UImportActivity.getBaseContext(), "Please enter playlist name", 0).show();
                                break;
                            }
                        }
                        break;
                }
            }
        });
        this.K.applyFontToView(this.M, this.L);
        this.K.applyFontToView(this.N, this.L);
        this.K.applyFontToView(this.S, this.L);
        this.K.applyFontToView(this.T, this.L);
        this.K.applyFontToView(this.O, this.L);
        String stringExtra = getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("label");
        if (stringExtra != null) {
            this.S.setText(stringExtra);
        }
        if (stringExtra2 != null) {
            this.T.setText(stringExtra2);
        }
    }
}
