package com.google.android.gms.common.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public abstract class zzc {

    /* renamed from: a, reason: collision with root package name */
    public Object f7407a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7408b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f7409c;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.f7409c = baseGmsClient;
        this.f7407a = obj;
    }

    public abstract void zza(Object obj);

    public abstract void zzc();

    public final void zze() {
        Object obj;
        synchronized (this) {
            obj = this.f7407a;
            if (this.f7408b) {
                Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                zza(obj);
            } catch (RuntimeException e10) {
                throw e10;
            }
        }
        synchronized (this) {
            this.f7408b = true;
        }
        zzg();
    }

    public final void zzf() {
        synchronized (this) {
            this.f7407a = null;
        }
    }

    public final void zzg() {
        zzf();
        synchronized (this.f7409c.zzt) {
            this.f7409c.zzt.remove(this);
        }
    }
}
