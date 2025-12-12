package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzg extends zzd {

    /* renamed from: b, reason: collision with root package name */
    public boolean f7948b;

    public zzg(zzho zzhoVar) {
        super(zzhoVar);
        this.f8189a.E++;
    }

    public final void zzu() {
        if (!this.f7948b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.f7948b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzz()) {
            return;
        }
        this.f8189a.G.incrementAndGet();
        this.f7948b = true;
    }

    public final void zzw() {
        if (this.f7948b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzx();
        this.f8189a.G.incrementAndGet();
        this.f7948b = true;
    }

    public abstract boolean zzz();

    public void zzx() {
    }
}
