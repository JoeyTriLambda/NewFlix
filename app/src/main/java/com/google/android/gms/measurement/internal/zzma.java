package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzma implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzlx f8471b;

    public zzma(zzlx zzlxVar) {
        this.f8471b = zzlxVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzla zzlaVar = this.f8471b.f8464c;
        zzlaVar.f8386d = null;
        zzlaVar.zzal();
    }
}
