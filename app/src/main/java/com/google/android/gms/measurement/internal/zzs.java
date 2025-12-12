package com.google.android.gms.measurement.internal;

import b0.b;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzs extends zzmy {

    /* renamed from: d, reason: collision with root package name */
    public String f8611d;

    /* renamed from: e, reason: collision with root package name */
    public HashSet f8612e;

    /* renamed from: f, reason: collision with root package name */
    public b f8613f;

    /* renamed from: g, reason: collision with root package name */
    public Long f8614g;

    /* renamed from: h, reason: collision with root package name */
    public Long f8615h;

    public zzs(zznd zzndVar) {
        super(zzndVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzu a(Integer num) {
        if (this.f8613f.containsKey(num)) {
            return (zzu) this.f8613f.get(num);
        }
        zzu zzuVar = new zzu(this, this.f8611d);
        this.f8613f.put(num, zzuVar);
        return zzuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final boolean zzc() {
        return false;
    }
}
