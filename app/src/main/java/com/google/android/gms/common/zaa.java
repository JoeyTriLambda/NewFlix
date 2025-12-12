package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final /* synthetic */ class zaa implements SuccessContinuation {
    static {
        new zaa();
    }

    private /* synthetic */ zaa() {
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        Object obj2 = GoogleApiAvailability.f7025c;
        return Tasks.forResult(null);
    }
}
