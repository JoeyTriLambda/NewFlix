package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfo<V> {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f7919g = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f7920a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfm<V> f7921b;

    /* renamed from: c, reason: collision with root package name */
    public final V f7922c;

    /* renamed from: d, reason: collision with root package name */
    public final V f7923d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f7924e;

    /* renamed from: f, reason: collision with root package name */
    public volatile V f7925f;

    public zzfo() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzfo(String str, Object obj, Object obj2, zzfm zzfmVar) {
        this.f7924e = new Object();
        this.f7925f = null;
        this.f7920a = str;
        this.f7922c = obj;
        this.f7923d = obj2;
        this.f7921b = zzfmVar;
    }

    public final V zza(V v10) {
        synchronized (this.f7924e) {
        }
        if (v10 != null) {
            return v10;
        }
        if (zzfp.f7926a == null) {
            return this.f7922c;
        }
        synchronized (f7919g) {
            if (zzad.zza()) {
                return this.f7925f == null ? this.f7922c : this.f7925f;
            }
            try {
                for (zzfo<?> zzfoVar : zzbh.f7725a) {
                    if (zzad.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v11 = null;
                    try {
                        zzfm<?> zzfmVar = zzfoVar.f7921b;
                        if (zzfmVar != null) {
                            v11 = (V) zzfmVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (f7919g) {
                        zzfoVar.f7925f = v11;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzfm<V> zzfmVar2 = this.f7921b;
            if (zzfmVar2 == null) {
                return this.f7922c;
            }
            try {
                return zzfmVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.f7922c;
            } catch (SecurityException unused4) {
                return this.f7922c;
            }
        }
    }

    public final String zza() {
        return this.f7920a;
    }
}
