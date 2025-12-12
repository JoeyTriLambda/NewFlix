package i8;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import g8.f;
import i8.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class b implements i8.a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f13332c;

    /* renamed from: a, reason: collision with root package name */
    public final AppMeasurementSdk f13333a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f13334b;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
    public class a implements a.InterfaceC0166a {
    }

    public b(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f13333a = appMeasurementSdk;
        this.f13334b = new ConcurrentHashMap();
    }

    @KeepForSdk
    public static i8.a getInstance(f fVar, Context context, f9.d dVar) {
        Preconditions.checkNotNull(fVar);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dVar);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f13332c == null) {
            synchronized (b.class) {
                if (f13332c == null) {
                    Bundle bundle = new Bundle(1);
                    if (fVar.isDefaultApp()) {
                        dVar.subscribe(g8.b.class, new Executor() { // from class: i8.d
                            @Override // java.util.concurrent.Executor
                            public final void execute(Runnable runnable) {
                                runnable.run();
                            }
                        }, new f9.b() { // from class: i8.c
                            @Override // f9.b
                            public final void handle(f9.a aVar) {
                                ((g8.b) aVar.getPayload()).getClass();
                                synchronized (b.class) {
                                    ((b) Preconditions.checkNotNull(b.f13332c)).f13333a.zza(false);
                                }
                            }
                        });
                        bundle.putBoolean("dataCollectionDefaultEnabled", fVar.isDataCollectionDefaultEnabled());
                    }
                    f13332c = new b(zzds.zza(context, (String) null, (String) null, (String) null, bundle).zzb());
                }
            }
        }
        return f13332c;
    }

    @Override // i8.a
    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (j8.c.zzf(str) && j8.c.zza(str2, bundle) && j8.c.zzb(str, str2, bundle)) {
            j8.c.zza(str, str2, bundle);
            this.f13333a.logEvent(str, str2, bundle);
        }
    }

    @Override // i8.a
    @KeepForSdk
    public a.InterfaceC0166a registerAnalyticsConnectorListener(String str, a.b bVar) {
        Preconditions.checkNotNull(bVar);
        if (!j8.c.zzf(str)) {
            return null;
        }
        boolean zIsEmpty = str.isEmpty();
        ConcurrentHashMap concurrentHashMap = this.f13334b;
        if ((zIsEmpty || !concurrentHashMap.containsKey(str) || concurrentHashMap.get(str) == null) ? false : true) {
            return null;
        }
        boolean zEquals = "fiam".equals(str);
        AppMeasurementSdk appMeasurementSdk = this.f13333a;
        Object bVar2 = zEquals ? new j8.b(appMeasurementSdk, bVar) : "clx".equals(str) ? new j8.d(appMeasurementSdk, bVar) : null;
        if (bVar2 == null) {
            return null;
        }
        concurrentHashMap.put(str, bVar2);
        return new a();
    }
}
