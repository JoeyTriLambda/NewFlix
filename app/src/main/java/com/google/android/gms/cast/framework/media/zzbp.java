package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.internal.cast.zzed;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbp {

    /* renamed from: b, reason: collision with root package name */
    public final long f6752b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6754d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6755e;

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f6751a = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f6753c = new zzbo(this);

    public zzbp(RemoteMediaClient remoteMediaClient, long j10) {
        this.f6755e = remoteMediaClient;
        this.f6752b = j10;
    }

    public final long zzb() {
        return this.f6752b;
    }

    public final void zzd(RemoteMediaClient.ProgressListener progressListener) {
        this.f6751a.add(progressListener);
    }

    public final void zze(RemoteMediaClient.ProgressListener progressListener) {
        this.f6751a.remove(progressListener);
    }

    public final void zzf() {
        RemoteMediaClient remoteMediaClient = this.f6755e;
        zzed zzedVar = remoteMediaClient.f6529b;
        Runnable runnable = this.f6753c;
        zzedVar.removeCallbacks(runnable);
        this.f6754d = true;
        remoteMediaClient.f6529b.postDelayed(runnable, this.f6752b);
    }

    public final void zzg() {
        this.f6755e.f6529b.removeCallbacks(this.f6753c);
        this.f6754d = false;
    }

    public final boolean zzh() {
        return !this.f6751a.isEmpty();
    }

    public final boolean zzi() {
        return this.f6754d;
    }
}
