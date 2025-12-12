package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzbs {
    public static PendingResult zza(Task task, final zzbr zzbrVar, final zzbr zzbrVar2) {
        final zzbq zzbqVar = new zzbq(zzbrVar2);
        task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.internal.cast.zzbo
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Logger logger = CastSession.f6377n;
                zzbqVar.setResult(new Status(0));
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.cast.zzbp
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Status status = new Status(8, "unknown error");
                if (exc instanceof ApiException) {
                    ApiException apiException = (ApiException) exc;
                    status = new Status(apiException.getStatusCode(), apiException.getMessage());
                }
                zzbq zzbqVar2 = zzbqVar;
                Logger logger = CastSession.f6377n;
                zzbqVar2.setResult(status);
            }
        });
        return zzbqVar;
    }
}
