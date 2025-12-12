package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes.dex */
final class zzz implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f8714b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Callable f8715m;

    public zzz(zzw zzwVar, Callable callable) {
        this.f8714b = zzwVar;
        this.f8715m = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw zzwVar = this.f8714b;
        try {
            zzwVar.zzb(this.f8715m.call());
        } catch (Exception e10) {
            zzwVar.zza(e10);
        } catch (Throwable th2) {
            zzwVar.zza(new RuntimeException(th2));
        }
    }
}
