package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zah extends zad<Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public final ListenerHolder.ListenerKey<?> f7262c;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f7262c = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq<?> zabqVar) {
        zaci zaciVar = zabqVar.zah().get(this.f7262c);
        return zaciVar != null && zaciVar.f7225a.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq<?> zabqVar) {
        zaci zaciVar = zabqVar.zah().get(this.f7262c);
        if (zaciVar == null) {
            return null;
        }
        return zaciVar.f7225a.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(zabq<?> zabqVar) throws RemoteException {
        zaci zaciVarRemove = zabqVar.zah().remove(this.f7262c);
        TaskCompletionSource<T> taskCompletionSource = this.f7247b;
        if (zaciVarRemove == null) {
            taskCompletionSource.trySetResult(Boolean.FALSE);
        } else {
            zaciVarRemove.f7226b.unregisterListener(zabqVar.zaf(), taskCompletionSource);
            zaciVarRemove.f7225a.clearListener();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zag(zaad zaadVar, boolean z10) {
    }
}
