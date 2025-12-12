package flix.com.vision.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.GIFActivity;
import r.j;

/* loaded from: classes2.dex */
public class GIFActivity extends j {
    public static final /* synthetic */ int M = 0;
    public LinearLayout K;
    public LinearLayout L;

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gifactivity);
        this.L = (LinearLayout) findViewById(R.id.install_android);
        this.K = (LinearLayout) findViewById(R.id.install_firetv);
        final int i10 = 0;
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: ub.h0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ GIFActivity f20193m;

            {
                this.f20193m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                GIFActivity gIFActivity = this.f20193m;
                switch (i11) {
                    case 0:
                        int i12 = GIFActivity.M;
                        gIFActivity.getClass();
                        String strO = ac.c.o(new StringBuilder(), App.getInstance().f11578z, "/androidtv.html");
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(strO));
                        gIFActivity.startActivity(intent);
                        break;
                    default:
                        int i13 = GIFActivity.M;
                        gIFActivity.getClass();
                        String strO2 = ac.c.o(new StringBuilder(), App.getInstance().f11578z, "/firetv.html");
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setData(Uri.parse(strO2));
                        gIFActivity.startActivity(intent2);
                        break;
                }
            }
        });
        final int i11 = 1;
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: ub.h0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ GIFActivity f20193m;

            {
                this.f20193m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                GIFActivity gIFActivity = this.f20193m;
                switch (i112) {
                    case 0:
                        int i12 = GIFActivity.M;
                        gIFActivity.getClass();
                        String strO = ac.c.o(new StringBuilder(), App.getInstance().f11578z, "/androidtv.html");
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(strO));
                        gIFActivity.startActivity(intent);
                        break;
                    default:
                        int i13 = GIFActivity.M;
                        gIFActivity.getClass();
                        String strO2 = ac.c.o(new StringBuilder(), App.getInstance().f11578z, "/firetv.html");
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setData(Uri.parse(strO2));
                        gIFActivity.startActivity(intent2);
                        break;
                }
            }
        });
    }
}
