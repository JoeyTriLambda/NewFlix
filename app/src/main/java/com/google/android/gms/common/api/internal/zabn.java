package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabn implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7180b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zabq f7181m;

    public zabn(zabq zabqVar, int i10) {
        this.f7181m = zabqVar;
        this.f7180b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7181m.g(this.f7180b);
    }
}
