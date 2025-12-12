package com.google.android.gms.internal.cast;

import android.view.Display;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzdm implements CastRemoteDisplay.CastRemoteDisplaySessionResult {
    private final Status zza;
    private final Display zzb;

    public zzdm(Status status) {
        this.zza = status;
        this.zzb = null;
    }

    public final Display getPresentationDisplay() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    public zzdm(Display display) {
        this.zza = Status.f7069p;
        this.zzb = display;
    }
}
