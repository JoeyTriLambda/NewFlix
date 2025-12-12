package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzl extends com.google.android.gms.cast.internal.zzad {
    @Override // com.google.android.gms.cast.internal.zzad, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* renamed from: zza */
    public final void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        if (TextUtils.isEmpty(null)) {
            setResult((zzl) new Status(2001, "IllegalArgument: sessionId cannot be null or empty", (PendingIntent) null));
            return;
        }
        try {
            zzwVar.zzV(null, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
