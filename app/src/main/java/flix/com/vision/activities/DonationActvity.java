package flix.com.vision.activities;

import android.os.Bundle;
import android.widget.Button;
import flix.com.vision.R;
import r.j;

/* loaded from: classes2.dex */
public class DonationActvity extends j {
    public static final /* synthetic */ int K = 0;

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_donation_actvity);
        ((Button) findViewById(R.id.mail_open)).setOnClickListener(new androidx.mediarouter.app.b(this, 7));
    }
}
