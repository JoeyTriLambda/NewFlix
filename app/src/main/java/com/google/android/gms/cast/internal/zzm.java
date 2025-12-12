package com.google.android.gms.cast.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzm extends zzae {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6861a;

    public zzm(TaskCompletionSource taskCompletionSource) {
        this.f6861a = taskCompletionSource;
    }

    @Override // com.google.android.gms.cast.internal.zzaf
    public final void zzb(Bundle bundle) {
        this.f6861a.setResult(bundle);
    }
}
