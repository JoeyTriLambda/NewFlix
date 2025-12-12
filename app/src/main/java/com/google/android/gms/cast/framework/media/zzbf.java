package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbf implements com.google.android.gms.cast.internal.zzar {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.cast.zzr f6739a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f6740b = new AtomicLong((CastUtils.zza() & WebSocketProtocol.PAYLOAD_SHORT_MAX) * 10000);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6741c;

    public zzbf(RemoteMediaClient remoteMediaClient) {
        this.f6741c = remoteMediaClient;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final long zza() {
        return this.f6740b.getAndIncrement();
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(String str, String str2, final long j10, String str3) {
        com.google.android.gms.cast.zzr zzrVar = this.f6739a;
        if (zzrVar == null) {
            throw new IllegalStateException("Device is not connected");
        }
        zzrVar.zzh(str, str2).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.cast.framework.media.zzbe
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f6737a.f6741c.f6530c.zzP(j10, exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 13);
            }
        });
    }

    public final void zzc(com.google.android.gms.cast.zzr zzrVar) {
        this.f6739a = zzrVar;
    }
}
