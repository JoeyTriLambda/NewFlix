package com.google.android.gms.cast.internal;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzr implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f6871b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f6872m;

    public zzr(zzw zzwVar, int i10) {
        this.f6871b = zzwVar;
        this.f6872m = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6871b.f6887c.onApplicationDisconnected(this.f6872m);
    }
}
