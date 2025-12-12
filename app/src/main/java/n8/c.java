package n8;

import android.os.Bundle;
import com.unity3d.ads.metadata.MediationMetaData;
import i8.a;
import java.util.Locale;

/* compiled from: CrashlyticsAnalyticsListener.java */
/* loaded from: classes.dex */
public final class c implements a.b {

    /* renamed from: a, reason: collision with root package name */
    public p8.b f16759a;

    /* renamed from: b, reason: collision with root package name */
    public p8.b f16760b;

    public void onMessageTriggered(int i10, Bundle bundle) {
        String string;
        o8.e.getLogger().v(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i10), bundle));
        if (bundle == null || (string = bundle.getString(MediationMetaData.KEY_NAME)) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        p8.b bVar = "clx".equals(bundle2.getString("_o")) ? this.f16759a : this.f16760b;
        if (bVar == null) {
            return;
        }
        bVar.onEvent(string, bundle2);
    }

    public void setBreadcrumbEventReceiver(p8.b bVar) {
        this.f16760b = bVar;
    }

    public void setCrashlyticsOriginEventReceiver(p8.b bVar) {
        this.f16759a = bVar;
    }
}
