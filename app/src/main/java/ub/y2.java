package ub;

import android.app.FragmentManager;
import android.view.View;
import flix.com.vision.App;
import flix.com.vision.activities.WatchedAcvivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class y2 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20329b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ WatchedAcvivity f20330m;

    public /* synthetic */ y2(WatchedAcvivity watchedAcvivity, int i10) {
        this.f20329b = i10;
        this.f20330m = watchedAcvivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20329b;
        int i11 = 1;
        WatchedAcvivity watchedAcvivity = this.f20330m;
        switch (i10) {
            case 0:
                if (watchedAcvivity.N.isEmpty()) {
                    be.d.makeToast(watchedAcvivity, "Your History is Empty", false);
                    break;
                } else {
                    FragmentManager fragmentManager = watchedAcvivity.getFragmentManager();
                    kc.d dVarNewInstance = kc.d.newInstance(watchedAcvivity, true);
                    dVarNewInstance.setTitle("Clear Watched History");
                    dVarNewInstance.setMessage("Do you really want to Clear your Watched History ?");
                    dVarNewInstance.setButton1("CANCEL", new q0(14));
                    dVarNewInstance.setButton2("YES", new y2(watchedAcvivity, i11));
                    try {
                        dVarNewInstance.show(fragmentManager, "");
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            default:
                int i12 = WatchedAcvivity.P;
                watchedAcvivity.getClass();
                if (!App.getInstance().f11573u.clearHistory()) {
                    be.d.makeToast(watchedAcvivity.getBaseContext(), "An error occurred", true);
                    break;
                } else {
                    be.d.makeToast(watchedAcvivity.getBaseContext(), "History cleared", true);
                    watchedAcvivity.finish();
                    break;
                }
        }
    }
}
