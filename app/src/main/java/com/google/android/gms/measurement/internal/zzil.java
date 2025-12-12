package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzil extends zzim {

    /* renamed from: b, reason: collision with root package name */
    public boolean f8188b;

    public zzil(zzho zzhoVar) {
        super(zzhoVar);
        this.f8189a.E++;
    }

    public final void zzac() {
        if (!this.f8188b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzad() {
        if (this.f8188b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzo()) {
            return;
        }
        this.f8189a.G.incrementAndGet();
        this.f8188b = true;
    }

    public final void zzae() {
        if (this.f8188b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.f8189a.G.incrementAndGet();
        this.f8188b = true;
    }

    public abstract boolean zzo();

    public void zzaa() {
    }
}
