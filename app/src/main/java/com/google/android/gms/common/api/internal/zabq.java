package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import b0.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zabq<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {

    /* renamed from: b, reason: collision with root package name */
    public final Api.Client f7185b;

    /* renamed from: c, reason: collision with root package name */
    public final ApiKey<O> f7186c;

    /* renamed from: d, reason: collision with root package name */
    public final zaad f7187d;

    /* renamed from: g, reason: collision with root package name */
    public final int f7190g;

    /* renamed from: h, reason: collision with root package name */
    public final zact f7191h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7192i;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ GoogleApiManager f7196m;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f7184a = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f7188e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f7189f = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7193j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ConnectionResult f7194k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f7195l = 0;

    public zabq(GoogleApiManager googleApiManager, GoogleApi<O> googleApi) {
        this.f7196m = googleApiManager;
        Api.Client clientZab = googleApi.zab(googleApiManager.f7101y.getLooper(), this);
        this.f7185b = clientZab;
        this.f7186c = googleApi.getApiKey();
        this.f7187d = new zaad();
        this.f7190g = googleApi.zaa();
        if (!clientZab.requiresSignIn()) {
            this.f7191h = null;
        } else {
            this.f7191h = googleApi.zac(googleApiManager.f7092p, googleApiManager.f7101y);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Feature a(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.f7185b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            b bVar = new b(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                bVar.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l10 = (Long) bVar.get(feature2.getName());
                if (l10 == null || l10.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void b(ConnectionResult connectionResult) {
        HashSet hashSet = this.f7188e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((zal) it.next()).zac(this.f7186c, connectionResult, Objects.equal(connectionResult, ConnectionResult.f7014p) ? this.f7185b.getEndpointPackageName() : null);
        }
        hashSet.clear();
    }

    public final void c(Status status) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        d(status, null, false);
    }

    public final void d(Status status, Exception exc, boolean z10) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f7184a.iterator();
        while (it.hasNext()) {
            zai zaiVar = (zai) it.next();
            if (!z10 || zaiVar.f7263a == 2) {
                if (status != null) {
                    zaiVar.zad(status);
                } else {
                    zaiVar.zae(exc);
                }
                it.remove();
            }
        }
    }

    public final void e() {
        LinkedList linkedList = this.f7184a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zai zaiVar = (zai) arrayList.get(i10);
            if (!this.f7185b.isConnected()) {
                return;
            }
            if (i(zaiVar)) {
                linkedList.remove(zaiVar);
            }
        }
    }

    public final void f() {
        Api.Client client = this.f7185b;
        zan();
        b(ConnectionResult.f7014p);
        if (this.f7192i) {
            GoogleApiManager googleApiManager = this.f7196m;
            com.google.android.gms.internal.base.zaq zaqVar = googleApiManager.f7101y;
            ApiKey<O> apiKey = this.f7186c;
            zaqVar.removeMessages(11, apiKey);
            googleApiManager.f7101y.removeMessages(9, apiKey);
            this.f7192i = false;
        }
        Iterator it = this.f7189f.values().iterator();
        while (it.hasNext()) {
            zaci zaciVar = (zaci) it.next();
            if (a(zaciVar.f7225a.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    zaciVar.f7225a.registerListener(client, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    client.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        e();
        h();
    }

    public final void g(int i10) {
        zan();
        this.f7192i = true;
        String lastDisconnectMessage = this.f7185b.getLastDisconnectMessage();
        zaad zaadVar = this.f7187d;
        zaadVar.getClass();
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(lastDisconnectMessage);
        }
        zaadVar.a(true, new Status(20, sb2.toString()));
        GoogleApiManager googleApiManager = this.f7196m;
        com.google.android.gms.internal.base.zaq zaqVar = googleApiManager.f7101y;
        ApiKey<O> apiKey = this.f7186c;
        zaqVar.sendMessageDelayed(Message.obtain(zaqVar, 9, apiKey), 5000L);
        com.google.android.gms.internal.base.zaq zaqVar2 = googleApiManager.f7101y;
        zaqVar2.sendMessageDelayed(Message.obtain(zaqVar2, 11, apiKey), 120000L);
        googleApiManager.f7094r.zac();
        Iterator it = this.f7189f.values().iterator();
        while (it.hasNext()) {
            ((zaci) it.next()).f7227c.run();
        }
    }

    public final void h() {
        GoogleApiManager googleApiManager = this.f7196m;
        com.google.android.gms.internal.base.zaq zaqVar = googleApiManager.f7101y;
        ApiKey<O> apiKey = this.f7186c;
        zaqVar.removeMessages(12, apiKey);
        com.google.android.gms.internal.base.zaq zaqVar2 = googleApiManager.f7101y;
        zaqVar2.sendMessageDelayed(zaqVar2.obtainMessage(12, apiKey), googleApiManager.f7088b);
    }

    public final boolean i(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            zaiVar.zag(this.f7187d, zaz());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f7185b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature featureA = a(zacVar.zab(this));
        if (featureA == null) {
            zaiVar.zag(this.f7187d, zaz());
            try {
                zaiVar.zaf(this);
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                this.f7185b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        String name = this.f7185b.getClass().getName();
        String name2 = featureA.getName();
        long version = featureA.getVersion();
        StringBuilder sb2 = new StringBuilder(name.length() + 77 + String.valueOf(name2).length());
        sb2.append(name);
        sb2.append(" could not execute call because it requires feature (");
        sb2.append(name2);
        sb2.append(", ");
        sb2.append(version);
        sb2.append(").");
        Log.w("GoogleApiManager", sb2.toString());
        if (!this.f7196m.f7102z || !zacVar.zaa(this)) {
            zacVar.zae(new UnsupportedApiCallException(featureA));
            return true;
        }
        zabs zabsVar = new zabs(this.f7186c, featureA);
        int iIndexOf = this.f7193j.indexOf(zabsVar);
        if (iIndexOf >= 0) {
            zabs zabsVar2 = (zabs) this.f7193j.get(iIndexOf);
            this.f7196m.f7101y.removeMessages(15, zabsVar2);
            com.google.android.gms.internal.base.zaq zaqVar = this.f7196m.f7101y;
            Message messageObtain = Message.obtain(zaqVar, 15, zabsVar2);
            this.f7196m.getClass();
            zaqVar.sendMessageDelayed(messageObtain, 5000L);
            return false;
        }
        this.f7193j.add(zabsVar);
        com.google.android.gms.internal.base.zaq zaqVar2 = this.f7196m.f7101y;
        Message messageObtain2 = Message.obtain(zaqVar2, 15, zabsVar);
        this.f7196m.getClass();
        zaqVar2.sendMessageDelayed(messageObtain2, 5000L);
        com.google.android.gms.internal.base.zaq zaqVar3 = this.f7196m.f7101y;
        Message messageObtain3 = Message.obtain(zaqVar3, 16, zabsVar);
        this.f7196m.getClass();
        zaqVar3.sendMessageDelayed(messageObtain3, 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (j(connectionResult)) {
            return false;
        }
        GoogleApiManager googleApiManager = this.f7196m;
        googleApiManager.f7093q.zah(googleApiManager.f7092p, connectionResult, this.f7190g);
        return false;
    }

    public final boolean j(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.C) {
            GoogleApiManager googleApiManager = this.f7196m;
            if (googleApiManager.f7098v == null || !googleApiManager.f7099w.contains(this.f7186c)) {
                return false;
            }
            this.f7196m.f7098v.zah(connectionResult, this.f7190g);
            return true;
        }
    }

    public final boolean k(boolean z10) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        Api.Client client = this.f7185b;
        if (!client.isConnected() || this.f7189f.size() != 0) {
            return false;
        }
        zaad zaadVar = this.f7187d;
        if (!((zaadVar.f7139a.isEmpty() && zaadVar.f7140b.isEmpty()) ? false : true)) {
            client.disconnect("Timing out service connection.");
            return true;
        }
        if (z10) {
            h();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Looper looperMyLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.f7196m;
        if (looperMyLooper == googleApiManager.f7101y.getLooper()) {
            f();
        } else {
            googleApiManager.f7101y.post(new zabm(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i10) {
        Looper looperMyLooper = Looper.myLooper();
        GoogleApiManager googleApiManager = this.f7196m;
        if (looperMyLooper == googleApiManager.f7101y.getLooper()) {
            g(i10);
        } else {
            googleApiManager.f7101y.post(new zabn(this, i10));
        }
    }

    public final boolean zaA() {
        return k(true);
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z10) {
        throw null;
    }

    public final int zab() {
        return this.f7190g;
    }

    public final ConnectionResult zad() {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        return this.f7194k;
    }

    public final Api.Client zaf() {
        return this.f7185b;
    }

    public final Map<ListenerHolder.ListenerKey<?>, zaci> zah() {
        return this.f7189f;
    }

    public final void zan() {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        this.f7194k = null;
    }

    public final void zao() {
        GoogleApiManager googleApiManager = this.f7196m;
        Preconditions.checkHandlerThread(googleApiManager.f7101y);
        Api.Client client = this.f7185b;
        if (client.isConnected() || client.isConnecting()) {
            return;
        }
        try {
            int iZab = googleApiManager.f7094r.zab(googleApiManager.f7092p, client);
            if (iZab == 0) {
                zabu zabuVar = new zabu(googleApiManager, client, this.f7186c);
                if (client.requiresSignIn()) {
                    ((zact) Preconditions.checkNotNull(this.f7191h)).zae(zabuVar);
                }
                try {
                    client.connect(zabuVar);
                    return;
                } catch (SecurityException e10) {
                    zar(new ConnectionResult(10), e10);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iZab, null);
            String name = client.getClass().getName();
            String string = connectionResult.toString();
            StringBuilder sb2 = new StringBuilder(name.length() + 35 + string.length());
            sb2.append("The service for ");
            sb2.append(name);
            sb2.append(" is not available: ");
            sb2.append(string);
            Log.w("GoogleApiManager", sb2.toString());
            zar(connectionResult, null);
        } catch (IllegalStateException e11) {
            zar(new ConnectionResult(10), e11);
        }
    }

    public final void zap(zai zaiVar) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        boolean zIsConnected = this.f7185b.isConnected();
        LinkedList linkedList = this.f7184a;
        if (zIsConnected) {
            if (i(zaiVar)) {
                h();
                return;
            } else {
                linkedList.add(zaiVar);
                return;
            }
        }
        linkedList.add(zaiVar);
        ConnectionResult connectionResult = this.f7194k;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            zao();
        } else {
            zar(this.f7194k, null);
        }
    }

    public final void zar(ConnectionResult connectionResult, Exception exc) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        zact zactVar = this.f7191h;
        if (zactVar != null) {
            zactVar.zaf();
        }
        zan();
        this.f7196m.f7094r.zac();
        b(connectionResult);
        if ((this.f7185b instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.getErrorCode() != 24) {
            GoogleApiManager googleApiManager = this.f7196m;
            googleApiManager.f7089m = true;
            com.google.android.gms.internal.base.zaq zaqVar = googleApiManager.f7101y;
            zaqVar.sendMessageDelayed(zaqVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            c(GoogleApiManager.B);
            return;
        }
        if (this.f7184a.isEmpty()) {
            this.f7194k = connectionResult;
            return;
        }
        if (exc != null) {
            Preconditions.checkHandlerThread(this.f7196m.f7101y);
            d(null, exc, false);
            return;
        }
        if (!this.f7196m.f7102z) {
            c(GoogleApiManager.b(this.f7186c, connectionResult));
            return;
        }
        d(GoogleApiManager.b(this.f7186c, connectionResult), null, true);
        if (this.f7184a.isEmpty() || j(connectionResult)) {
            return;
        }
        GoogleApiManager googleApiManager2 = this.f7196m;
        if (googleApiManager2.f7093q.zah(googleApiManager2.f7092p, connectionResult, this.f7190g)) {
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            this.f7192i = true;
        }
        if (!this.f7192i) {
            c(GoogleApiManager.b(this.f7186c, connectionResult));
            return;
        }
        com.google.android.gms.internal.base.zaq zaqVar2 = this.f7196m.f7101y;
        Message messageObtain = Message.obtain(zaqVar2, 9, this.f7186c);
        this.f7196m.getClass();
        zaqVar2.sendMessageDelayed(messageObtain, 5000L);
    }

    public final void zas(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        Api.Client client = this.f7185b;
        String name = client.getClass().getName();
        String strValueOf = String.valueOf(connectionResult);
        StringBuilder sb2 = new StringBuilder(name.length() + 25 + strValueOf.length());
        sb2.append("onSignInFailed for ");
        sb2.append(name);
        sb2.append(" with ");
        sb2.append(strValueOf);
        client.disconnect(sb2.toString());
        zar(connectionResult, null);
    }

    public final void zat(zal zalVar) {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        this.f7188e.add(zalVar);
    }

    public final void zau() {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        if (this.f7192i) {
            zao();
        }
    }

    public final void zav() {
        Preconditions.checkHandlerThread(this.f7196m.f7101y);
        c(GoogleApiManager.A);
        this.f7187d.zaf();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.f7189f.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(listenerKey, new TaskCompletionSource()));
        }
        b(new ConnectionResult(4));
        Api.Client client = this.f7185b;
        if (client.isConnected()) {
            client.onUserSignOut(new zabp(this));
        }
    }

    public final void zaw() {
        GoogleApiManager googleApiManager = this.f7196m;
        Preconditions.checkHandlerThread(googleApiManager.f7101y);
        boolean z10 = this.f7192i;
        if (z10) {
            if (z10) {
                com.google.android.gms.internal.base.zaq zaqVar = googleApiManager.f7101y;
                ApiKey<O> apiKey = this.f7186c;
                zaqVar.removeMessages(11, apiKey);
                googleApiManager.f7101y.removeMessages(9, apiKey);
                this.f7192i = false;
            }
            c(googleApiManager.f7093q.isGooglePlayServicesAvailable(googleApiManager.f7092p) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f7185b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean zaz() {
        return this.f7185b.requiresSignIn();
    }
}
