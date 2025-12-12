package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzmj implements Iterator {
    private int zza;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzlz zzd;

    private final Iterator zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i10 = this.zza + 1;
        this.zza = i10;
        return i10 < this.zzd.zzb.size() ? (Map.Entry) this.zzd.zzb.get(this.zza) : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzg();
        if (this.zza >= this.zzd.zzb.size()) {
            zza().remove();
            return;
        }
        zzlz zzlzVar = this.zzd;
        int i10 = this.zza;
        this.zza = i10 - 1;
        zzlzVar.zzc(i10);
    }

    private zzmj(zzlz zzlzVar) {
        this.zzd = zzlzVar;
        this.zza = -1;
    }
}
