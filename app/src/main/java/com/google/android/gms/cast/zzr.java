package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@ShowFirstParty
/* loaded from: classes.dex */
public interface zzr extends HasApiKey {
    Task zze();

    Task zzf();

    Task zzg(String str);

    Task zzh(String str, String str2);

    Task zzi(String str, Cast.MessageReceivedCallback messageReceivedCallback);

    void zzk(zzq zzqVar);

    boolean zzl();

    boolean zzm();
}
