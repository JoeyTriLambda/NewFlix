package com.google.android.gms.security;

import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zza extends AsyncTask {
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            ProviderInstaller.installIfNeeded(null);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e10) {
            return Integer.valueOf(e10.f7029b);
        } catch (GooglePlayServicesRepairableException e11) {
            return Integer.valueOf(e11.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            throw null;
        }
        ProviderInstaller.f8636a.getErrorResolutionIntent(null, num.intValue(), "pi");
        num.intValue();
        throw null;
    }
}
