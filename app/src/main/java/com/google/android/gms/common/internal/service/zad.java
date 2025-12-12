package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zad extends zaa {

    /* renamed from: a, reason: collision with root package name */
    public final BaseImplementation.ResultHolder<Status> f7369a;

    public zad(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f7369a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zak
    public final void zab(int i10) throws RemoteException {
        this.f7369a.setResult(new Status(i10));
    }
}
