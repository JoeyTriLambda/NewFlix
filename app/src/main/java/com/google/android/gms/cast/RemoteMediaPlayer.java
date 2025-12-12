package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SuppressLint({"MissingRemoteException"})
@Deprecated
/* loaded from: classes.dex */
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f6307c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Object f6308a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.cast.internal.zzaq f6309b;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface MediaChannelResult extends Result {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface OnMetadataUpdatedListener {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface OnPreloadStatusUpdatedListener {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface OnQueueStatusUpdatedListener {
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Deprecated
    public interface OnStatusUpdatedListener {
    }

    static {
        String str = com.google.android.gms.cast.internal.zzaq.f6824w;
    }

    public RemoteMediaPlayer() {
        com.google.android.gms.cast.internal.zzaq zzaqVar = new com.google.android.gms.cast.internal.zzaq(null);
        this.f6308a = new Object();
        this.f6309b = zzaqVar;
        zzaqVar.zzQ(new zzcy(this));
        zzaqVar.zzh(new zzdm(this));
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.f6309b.zzO(str2);
    }
}
