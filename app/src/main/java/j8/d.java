package j8;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import i8.a;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final a.b f14679a;

    public d(AppMeasurementSdk appMeasurementSdk, a.b bVar) {
        this.f14679a = bVar;
        appMeasurementSdk.registerOnMeasurementEventListener(new f(this));
    }
}
