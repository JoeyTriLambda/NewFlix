package androidx.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.p;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements p.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f811a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f812b;

    public /* synthetic */ g(ComponentActivity componentActivity, int i10) {
        this.f811a = i10;
        this.f812b = componentActivity;
    }

    @Override // p.b
    public final void onContextAvailable(Context context) {
        int i10 = this.f811a;
        ComponentActivity componentActivity = this.f812b;
        switch (i10) {
            case 0:
                Bundle bundleConsumeRestoredStateForKey = componentActivity.getSavedStateRegistry().consumeRestoredStateForKey("android:support:activity-result");
                if (bundleConsumeRestoredStateForKey != null) {
                    componentActivity.f747u.onRestoreInstanceState(bundleConsumeRestoredStateForKey);
                    break;
                }
                break;
            default:
                ((p) componentActivity).C.attachHost(null);
                break;
        }
    }
}
