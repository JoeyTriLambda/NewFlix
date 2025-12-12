package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
abstract class zzbk extends BasePendingResult {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.cast.internal.zzas f6745a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6746b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6747c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbk(RemoteMediaClient remoteMediaClient, boolean z10) {
        super((GoogleApiClient) null);
        this.f6747c = remoteMediaClient;
        this.f6746b = z10;
    }

    public final com.google.android.gms.cast.internal.zzas a() {
        if (this.f6745a == null) {
            this.f6745a = new zzbi(this);
        }
        return this.f6745a;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbj(status);
    }

    public abstract void zza() throws com.google.android.gms.cast.internal.zzao;

    public final void zzc() {
        if (!this.f6746b) {
            Iterator it = this.f6747c.f6535h.iterator();
            while (it.hasNext()) {
                ((RemoteMediaClient.Listener) it.next()).onSendingRemoteMediaRequest();
            }
            Iterator it2 = this.f6747c.f6536i.iterator();
            while (it2.hasNext()) {
                ((RemoteMediaClient.Callback) it2.next()).onSendingRemoteMediaRequest();
            }
        }
        try {
            synchronized (this.f6747c.f6528a) {
                zza();
            }
        } catch (com.google.android.gms.cast.internal.zzao unused) {
            setResult(new zzbj(new Status(2100)));
        }
    }
}
