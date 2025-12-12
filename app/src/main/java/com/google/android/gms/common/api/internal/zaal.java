package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<zaaw> f7143a;

    /* renamed from: b, reason: collision with root package name */
    public final Api<?> f7144b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7145c;

    public zaal(zaaw zaawVar, Api<?> api, boolean z10) {
        this.f7143a = new WeakReference<>(zaawVar);
        this.f7144b = api;
        this.f7145c = z10;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zaaw zaawVar = this.f7143a.get();
        if (zaawVar == null) {
            return;
        }
        Looper.myLooper();
        zaawVar.getClass();
        throw null;
    }
}
