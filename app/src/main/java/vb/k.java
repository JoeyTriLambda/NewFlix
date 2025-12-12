package vb;

import android.view.KeyEvent;
import android.widget.TextView;
import flix.com.vision.activities.adult.AdultZonePINEntryActivity;
import flix.com.vision.api.alldebrid.AllDebridApiKeyEntryActivity;
import flix.com.vision.api.premiumize.PremApiKeyEntryActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20669a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r.j f20670b;

    public /* synthetic */ k(r.j jVar, int i10) {
        this.f20669a = i10;
        this.f20670b = jVar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        int i11 = this.f20669a;
        r.j jVar = this.f20670b;
        switch (i11) {
            case 0:
                AdultZonePINEntryActivity adultZonePINEntryActivity = (AdultZonePINEntryActivity) jVar;
                int i12 = AdultZonePINEntryActivity.U;
                if (i10 != 6) {
                    adultZonePINEntryActivity.getClass();
                    break;
                } else {
                    adultZonePINEntryActivity.d();
                    break;
                }
            case 1:
                AllDebridApiKeyEntryActivity allDebridApiKeyEntryActivity = (AllDebridApiKeyEntryActivity) jVar;
                int i13 = AllDebridApiKeyEntryActivity.Q;
                if (i10 != 6) {
                    allDebridApiKeyEntryActivity.getClass();
                    break;
                } else {
                    allDebridApiKeyEntryActivity.d();
                    break;
                }
            default:
                PremApiKeyEntryActivity premApiKeyEntryActivity = (PremApiKeyEntryActivity) jVar;
                int i14 = PremApiKeyEntryActivity.Q;
                if (i10 != 6) {
                    premApiKeyEntryActivity.getClass();
                    break;
                } else {
                    premApiKeyEntryActivity.d();
                    break;
                }
        }
        return false;
    }
}
