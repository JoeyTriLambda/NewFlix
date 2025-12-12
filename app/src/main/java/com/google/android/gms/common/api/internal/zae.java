package com.google.android.gms.common.api.internal;

import ac.c;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zai {

    /* renamed from: b, reason: collision with root package name */
    public final A f7257b;

    public zae(int i10, A a10) {
        super(i10);
        this.f7257b = (A) Preconditions.checkNotNull(a10, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        try {
            this.f7257b.setFailedResult(status);
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.f7257b.setFailedResult(new Status(10, c.p(new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length()), simpleName, ": ", localizedMessage)));
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq<?> zabqVar) throws DeadObjectException {
        try {
            this.f7257b.run(zabqVar.zaf());
        } catch (RuntimeException e10) {
            zae(e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(zaad zaadVar, boolean z10) {
        Map<BasePendingResult<?>, Boolean> map = zaadVar.f7139a;
        Boolean boolValueOf = Boolean.valueOf(z10);
        A a10 = this.f7257b;
        map.put(a10, boolValueOf);
        a10.addStatusListener(new zaab(zaadVar, a10));
    }
}
