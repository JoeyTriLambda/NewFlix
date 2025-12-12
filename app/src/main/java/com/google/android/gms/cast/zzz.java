package com.google.android.gms.cast;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzz implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        com.google.android.gms.internal.cast.zzdo zzdoVar = (com.google.android.gms.internal.cast.zzdo) obj;
        new Bundle().putInt("configuration", 0);
        new zzac(null, (TaskCompletionSource) obj2, zzdoVar, null);
        throw null;
    }
}
