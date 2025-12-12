package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zal {

    /* renamed from: a, reason: collision with root package name */
    public final SparseIntArray f7382a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleApiAvailabilityLight f7383b;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, int i10) {
        return this.f7382a.get(i10, -1);
    }

    public final int zab(Context context, Api.Client client) {
        SparseIntArray sparseIntArray;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i10 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int iZaa = zaa(context, minApkVersion);
        if (iZaa == -1) {
            int i11 = 0;
            while (true) {
                sparseIntArray = this.f7382a;
                if (i11 >= sparseIntArray.size()) {
                    i10 = -1;
                    break;
                }
                int iKeyAt = sparseIntArray.keyAt(i11);
                if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                    break;
                }
                i11++;
            }
            iZaa = i10 == -1 ? this.f7383b.isGooglePlayServicesAvailable(context, minApkVersion) : i10;
            sparseIntArray.put(minApkVersion, iZaa);
        }
        return iZaa;
    }

    public final void zac() {
        this.f7382a.clear();
    }

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f7382a = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.f7383b = googleApiAvailabilityLight;
    }
}
