package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public abstract class zai {

    /* renamed from: a, reason: collision with root package name */
    public final int f7263a;

    public zai(int i10) {
        this.f7263a = i10;
    }

    public static /* bridge */ /* synthetic */ Status a(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq<?> zabqVar) throws DeadObjectException;

    public abstract void zag(zaad zaadVar, boolean z10);
}
