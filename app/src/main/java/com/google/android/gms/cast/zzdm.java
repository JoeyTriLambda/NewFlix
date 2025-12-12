package com.google.android.gms.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzdm implements com.google.android.gms.cast.internal.zzar {

    /* renamed from: a, reason: collision with root package name */
    public long f7001a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaPlayer f7002b;

    public zzdm(RemoteMediaPlayer remoteMediaPlayer) {
        this.f7002b = remoteMediaPlayer;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final long zza() {
        long j10 = this.f7001a + 1;
        this.f7001a = j10;
        return j10;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(String str, String str2, long j10, String str3) {
        throw new IllegalStateException("No GoogleApiClient available");
    }
}
