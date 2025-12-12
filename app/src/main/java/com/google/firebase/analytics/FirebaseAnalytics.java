package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.tasks.Tasks;
import h8.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f9736b;

    /* renamed from: a, reason: collision with root package name */
    public final zzds f9737a;

    public FirebaseAnalytics(zzds zzdsVar) {
        Preconditions.checkNotNull(zzdsVar);
        this.f9737a = zzdsVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f9736b == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f9736b == null) {
                    f9736b = new FirebaseAnalytics(zzds.zza(context));
                }
            }
        }
        return f9736b;
    }

    @Keep
    public static zzkn getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzds zzdsVarZza = zzds.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zzdsVarZza == null) {
            return null;
        }
        return new a(zzdsVarZza);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(com.google.firebase.installations.a.getInstance().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.f9737a.zza(activity, str, str2);
    }
}
