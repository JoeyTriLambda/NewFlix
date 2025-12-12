package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzmy extends zzmz {

    /* renamed from: c, reason: collision with root package name */
    public boolean f8524c;

    public zzmy(zznd zzndVar) {
        super(zzndVar);
        this.f8525b.f8561r++;
    }

    public final void zzak() {
        if (!this.f8524c) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.f8524c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.f8525b.f8562s++;
        this.f8524c = true;
    }

    public abstract boolean zzc();
}
