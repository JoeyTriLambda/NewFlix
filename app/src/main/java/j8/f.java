package j8;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class f implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f14681a;

    public f(d dVar) {
        this.f14681a = dVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        if (str == null || !c.zze(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediationMetaData.KEY_NAME, str2);
        bundle2.putLong("timestampInMillis", j10);
        bundle2.putBundle("params", bundle);
        ((n8.c) this.f14681a.f14679a).onMessageTriggered(3, bundle2);
    }
}
