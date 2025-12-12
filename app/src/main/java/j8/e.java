package j8;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class e implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f14680a;

    public e(b bVar) {
        this.f14680a = bVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzix
    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        b bVar = this.f14680a;
        if (bVar.f14673a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", c.zza(str2));
            ((n8.c) bVar.f14674b).onMessageTriggered(2, bundle2);
        }
    }
}
