package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.Logger;
import java.util.HashSet;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbo extends TimerTask {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbp f6750b;

    public zzbo(zzbp zzbpVar) {
        this.f6750b = zzbpVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        zzbp zzbpVar = this.f6750b;
        RemoteMediaClient remoteMediaClient = zzbpVar.f6755e;
        HashSet hashSet = zzbpVar.f6751a;
        Logger logger = RemoteMediaClient.f6527l;
        remoteMediaClient.b(hashSet);
        zzbpVar.f6755e.f6529b.postDelayed(this, zzbpVar.f6752b);
    }
}
