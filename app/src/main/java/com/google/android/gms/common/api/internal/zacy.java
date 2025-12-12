package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zacy implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Result f7244b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zada f7245m;

    public zacy(zada zadaVar, Result result) {
        this.f7245m = zadaVar;
        this.f7244b = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result result = this.f7244b;
        zada zadaVar = this.f7245m;
        try {
            try {
                ThreadLocal<Boolean> threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                PendingResult pendingResultOnSuccess = ((ResultTransform) Preconditions.checkNotNull(zadaVar.f7248a)).onSuccess(result);
                zacz zaczVar = zadaVar.f7254g;
                zaczVar.sendMessage(zaczVar.obtainMessage(0, pendingResultOnSuccess));
                threadLocal.set(Boolean.FALSE);
                zada.d(result);
                GoogleApiClient googleApiClient = zadaVar.f7253f.get();
                if (googleApiClient != null) {
                    googleApiClient.zap(zadaVar);
                }
            } catch (RuntimeException e10) {
                zacz zaczVar2 = zadaVar.f7254g;
                zaczVar2.sendMessage(zaczVar2.obtainMessage(1, e10));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zada.d(result);
                GoogleApiClient googleApiClient2 = zadaVar.f7253f.get();
                if (googleApiClient2 != null) {
                    googleApiClient2.zap(zadaVar);
                }
            }
        } catch (Throwable th2) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.d(result);
            GoogleApiClient googleApiClient3 = zadaVar.f7253f.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zap(zadaVar);
            }
            throw th2;
        }
    }
}
