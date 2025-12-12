package flix.com.vision.api.alldebrid;

import a2.x;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import bc.a;
import c1.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.api.alldebrid.AllDebridApiKeyEntryActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import kc.d;
import org.apache.commons.lang3.StringUtils;
import qe.b;
import r.j;
import vb.k;

/* loaded from: classes2.dex */
public class AllDebridApiKeyEntryActivity extends j {
    public static final /* synthetic */ int Q = 0;
    public RelativeLayout K;
    public RelativeLayout L;
    public RelativeLayout M;
    public EditText N;
    public b O;
    public d P = null;

    public static String getDate(long j10) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(j10 * 1000));
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public final void d() {
        String string = this.N.getText().toString();
        if (string.contains(StringUtils.SPACE)) {
            Toast.makeText(getBaseContext(), "API Key cannot contain blank space", 1).show();
            return;
        }
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, false);
        this.P = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.P.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        b bVar = this.O;
        if (bVar != null) {
            bVar.dispose();
        }
        this.O = a.getAllDebridUserAccount(string).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new x(7, this, string), new c(this, 24));
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.all_debrid_apikey_entry_activity);
        this.M = (RelativeLayout) findViewById(R.id.main_relative_view);
        this.L = (RelativeLayout) findViewById(R.id.confirm_pin_button);
        this.K = (RelativeLayout) findViewById(R.id.cancel_button);
        this.N = (EditText) findViewById(R.id.edit_text_enter_pin);
        App.extractDominantColor(this.M);
        final int i10 = 1;
        this.N.setOnEditorActionListener(new k(this, 1));
        final int i11 = 0;
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: cc.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AllDebridApiKeyEntryActivity f5262m;

            {
                this.f5262m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i11;
                AllDebridApiKeyEntryActivity allDebridApiKeyEntryActivity = this.f5262m;
                switch (i12) {
                    case 0:
                        int i13 = AllDebridApiKeyEntryActivity.Q;
                        allDebridApiKeyEntryActivity.finish();
                        break;
                    default:
                        int i14 = AllDebridApiKeyEntryActivity.Q;
                        allDebridApiKeyEntryActivity.d();
                        break;
                }
            }
        });
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: cc.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AllDebridApiKeyEntryActivity f5262m;

            {
                this.f5262m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i10;
                AllDebridApiKeyEntryActivity allDebridApiKeyEntryActivity = this.f5262m;
                switch (i12) {
                    case 0:
                        int i13 = AllDebridApiKeyEntryActivity.Q;
                        allDebridApiKeyEntryActivity.finish();
                        break;
                    default:
                        int i14 = AllDebridApiKeyEntryActivity.Q;
                        allDebridApiKeyEntryActivity.d();
                        break;
                }
            }
        });
    }
}
