package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {

    /* renamed from: a, reason: collision with root package name */
    public final Api.Client f7201a;

    /* renamed from: b, reason: collision with root package name */
    public final ApiKey<?> f7202b;

    /* renamed from: c, reason: collision with root package name */
    public IAccountAccessor f7203c = null;

    /* renamed from: d, reason: collision with root package name */
    public Set<Scope> f7204d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7205e = false;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ GoogleApiManager f7206f;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey<?> apiKey) {
        this.f7206f = googleApiManager;
        this.f7201a = client;
        this.f7202b = apiKey;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.f7206f.f7101y.post(new zabt(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.f7206f.f7097u.get(this.f7202b);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zaf(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
            return;
        }
        this.f7203c = iAccountAccessor;
        this.f7204d = set;
        if (this.f7205e) {
            this.f7201a.getRemoteService(iAccountAccessor, set);
        }
    }
}
