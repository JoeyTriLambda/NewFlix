package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaan extends zabg {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f7148b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaan(zaaw zaawVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zaawVar);
        this.f7148b = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void zaa() {
        this.f7148b.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
