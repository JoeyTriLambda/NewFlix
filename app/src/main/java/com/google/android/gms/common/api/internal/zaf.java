package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zaf extends zad<Void> {

    /* renamed from: c, reason: collision with root package name */
    public final zaci f7258c;

    public zaf(zaci zaciVar, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f7258c = zaciVar;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq<?> zabqVar) {
        return this.f7258c.f7225a.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq<?> zabqVar) {
        return this.f7258c.f7225a.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(zabq<?> zabqVar) throws RemoteException {
        zaci zaciVar = this.f7258c;
        zaciVar.f7225a.registerListener(zabqVar.zaf(), this.f7247b);
        ListenerHolder.ListenerKey<?> listenerKey = zaciVar.f7225a.getListenerKey();
        if (listenerKey != null) {
            zabqVar.zah().put(listenerKey, zaciVar);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zag(zaad zaadVar, boolean z10) {
    }
}
