package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public final class NonGmsServiceBrokerClient implements Api.Client, ServiceConnection {
    @Override // com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Thread.currentThread();
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        Thread.currentThread();
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final String getEndpointPackageName() {
        Preconditions.checkNotNull(null);
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final String getLastDisconnectMessage() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean isConnected() {
        Thread.currentThread();
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean isConnecting() {
        Thread.currentThread();
        throw null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        new Runnable() { // from class: com.google.android.gms.common.api.internal.zacg
            @Override // java.lang.Runnable
            public final void run() {
                NonGmsServiceBrokerClient nonGmsServiceBrokerClient = this.f7220b;
                nonGmsServiceBrokerClient.getClass();
                IBinder iBinder2 = iBinder;
                nonGmsServiceBrokerClient.getClass();
                String.valueOf(iBinder2);
                new Bundle();
                throw null;
            }
        };
        throw null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        new Runnable() { // from class: com.google.android.gms.common.api.internal.zacf
            @Override // java.lang.Runnable
            public final void run() {
                NonGmsServiceBrokerClient nonGmsServiceBrokerClient = this.f7219b;
                nonGmsServiceBrokerClient.getClass();
                nonGmsServiceBrokerClient.getClass();
                throw null;
            }
        };
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void disconnect(String str) {
        Thread.currentThread();
        throw null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    public final void zac(String str) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
    }
}
