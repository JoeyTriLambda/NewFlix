package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzgw;
import t1.a;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends a implements zzgw.zza {

    /* renamed from: c, reason: collision with root package name */
    public zzgw f7607c;

    @Override // com.google.android.gms.measurement.internal.zzgw.zza
    public final void doStartService(Context context, Intent intent) {
        a.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws IllegalStateException {
        if (this.f7607c == null) {
            this.f7607c = new zzgw(this);
        }
        this.f7607c.zza(context, intent);
    }
}
