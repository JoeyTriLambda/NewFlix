package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: h, reason: collision with root package name */
    public static final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> f7235h = com.google.android.gms.signin.zad.f8656a;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7236a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f7237b;

    /* renamed from: c, reason: collision with root package name */
    public final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> f7238c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<Scope> f7239d;

    /* renamed from: e, reason: collision with root package name */
    public final ClientSettings f7240e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.gms.signin.zae f7241f;

    /* renamed from: g, reason: collision with root package name */
    public zacs f7242g;

    public zact(Context context, Handler handler, ClientSettings clientSettings) {
        Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = f7235h;
        this.f7236a = context;
        this.f7237b = handler;
        this.f7240e = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.f7239d = clientSettings.getRequiredScopes();
        this.f7238c = abstractClientBuilder;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f7241f.zad(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f7242g.zae(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i10) {
        this.f7241f.disconnect();
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        this.f7237b.post(new zacr(this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    public final void zae(zacs zacsVar) {
        com.google.android.gms.signin.zae zaeVar = this.f7241f;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
        Integer numValueOf = Integer.valueOf(System.identityHashCode(this));
        ClientSettings clientSettings = this.f7240e;
        clientSettings.zae(numValueOf);
        Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = this.f7238c;
        Context context = this.f7236a;
        Handler handler = this.f7237b;
        this.f7241f = abstractClientBuilder.buildClient(context, handler.getLooper(), clientSettings, (ClientSettings) clientSettings.zaa(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.f7242g = zacsVar;
        Set<Scope> set = this.f7239d;
        if (set == null || set.isEmpty()) {
            handler.post(new zacq(this));
        } else {
            this.f7241f.zab();
        }
    }

    public final void zaf() {
        com.google.android.gms.signin.zae zaeVar = this.f7241f;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
    }
}
