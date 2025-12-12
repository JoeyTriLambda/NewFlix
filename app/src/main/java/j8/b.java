package j8;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import i8.a;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f14673a;

    /* renamed from: b, reason: collision with root package name */
    public final a.b f14674b;

    public b(AppMeasurementSdk appMeasurementSdk, a.b bVar) {
        this.f14674b = bVar;
        appMeasurementSdk.registerOnMeasurementEventListener(new e(this));
        this.f14673a = new HashSet();
    }
}
