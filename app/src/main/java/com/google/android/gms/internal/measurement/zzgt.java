package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzgt extends ContentObserver {
    private final /* synthetic */ zzgr zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgt(zzgr zzgrVar, Handler handler) {
        super(null);
        this.zza = zzgrVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.zza.zzd();
    }
}
