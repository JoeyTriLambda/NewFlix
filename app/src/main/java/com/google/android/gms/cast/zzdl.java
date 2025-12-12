package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzdl implements ResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final long f6999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdm f7000b;

    public zzdl(zzdm zzdmVar, long j10) {
        this.f7000b = zzdmVar;
        this.f6999a = j10;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        if (status.isSuccess()) {
            return;
        }
        this.f7000b.f7002b.f6309b.zzP(this.f6999a, status.getStatusCode());
    }
}
