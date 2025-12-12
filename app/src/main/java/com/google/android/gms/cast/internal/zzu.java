package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzu implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f6877b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f6878m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f6879n;

    public zzu(zzw zzwVar, String str, String str2) {
        this.f6877b = zzwVar;
        this.f6878m = str;
        this.f6879n = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cast.MessageReceivedCallback messageReceivedCallback;
        synchronized (this.f6877b.f6888d) {
            messageReceivedCallback = (Cast.MessageReceivedCallback) this.f6877b.f6888d.get(this.f6878m);
        }
        if (messageReceivedCallback != null) {
            messageReceivedCallback.onMessageReceived(this.f6877b.f6886b, this.f6878m, this.f6879n);
        } else {
            zzw.f6882x.d("Discarded message for unknown namespace '%s'", this.f6878m);
        }
    }
}
