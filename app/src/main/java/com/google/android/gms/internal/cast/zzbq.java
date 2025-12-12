package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbq extends BasePendingResult {
    private final zzbr zza;

    public zzbq(zzbr zzbrVar) {
        super((GoogleApiClient) null);
        this.zza = zzbrVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        Logger logger = CastSession.f6377n;
        return status;
    }
}
