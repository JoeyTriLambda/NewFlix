package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
abstract class zad<T> extends zac {

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<T> f7247b;

    public zad(int i10, TaskCompletionSource<T> taskCompletionSource) {
        super(i10);
        this.f7247b = taskCompletionSource;
    }

    public abstract void zac(zabq<?> zabqVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        this.f7247b.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        this.f7247b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq<?> zabqVar) throws DeadObjectException {
        try {
            zac(zabqVar);
        } catch (DeadObjectException e10) {
            zad(zai.a(e10));
            throw e10;
        } catch (RemoteException e11) {
            zad(zai.a(e11));
        } catch (RuntimeException e12) {
            this.f7247b.trySetException(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public void zag(zaad zaadVar, boolean z10) {
    }
}
