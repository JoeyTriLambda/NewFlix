package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zag<ResultT> extends zac {

    /* renamed from: b, reason: collision with root package name */
    public final TaskApiCall<Api.AnyClient, ResultT> f7259b;

    /* renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource<ResultT> f7260c;

    /* renamed from: d, reason: collision with root package name */
    public final StatusExceptionMapper f7261d;

    public zag(int i10, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i10);
        this.f7260c = taskCompletionSource;
        this.f7259b = taskApiCall;
        this.f7261d = statusExceptionMapper;
        if (i10 == 2 && taskApiCall.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq<?> zabqVar) {
        return this.f7259b.shouldAutoResolveMissingFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq<?> zabqVar) {
        return this.f7259b.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        this.f7260c.trySetException(this.f7261d.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        this.f7260c.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq<?> zabqVar) throws DeadObjectException {
        TaskCompletionSource<ResultT> taskCompletionSource = this.f7260c;
        try {
            this.f7259b.doExecute(zabqVar.zaf(), taskCompletionSource);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            zad(zai.a(e11));
        } catch (RuntimeException e12) {
            taskCompletionSource.trySetException(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(zaad zaadVar, boolean z10) {
        Map<TaskCompletionSource<?>, Boolean> map = zaadVar.f7140b;
        Boolean boolValueOf = Boolean.valueOf(z10);
        TaskCompletionSource<ResultT> taskCompletionSource = this.f7260c;
        map.put(taskCompletionSource, boolValueOf);
        taskCompletionSource.getTask().addOnCompleteListener(new zaac(zaadVar, taskCompletionSource));
    }
}
