package qa;

import android.view.View;
import com.skydoves.powerspinner.PowerSpinnerView;

/* compiled from: PowerSpinnerView.kt */
/* loaded from: classes2.dex */
public final class h implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PowerSpinnerView f18050b;

    public h(PowerSpinnerView powerSpinnerView) {
        this.f18050b = powerSpinnerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PowerSpinnerView.showOrDismiss$default(this.f18050b, 0, 0, 3, null);
    }
}
