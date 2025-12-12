package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzmb implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzlz zzc;

    private final Iterator zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.zza;
        return (i10 > 0 && i10 <= this.zzc.zzb.size()) || zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        List list = this.zzc.zzb;
        int i10 = this.zza - 1;
        this.zza = i10;
        return (Map.Entry) list.get(i10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private zzmb(zzlz zzlzVar) {
        this.zzc = zzlzVar;
        this.zza = zzlzVar.zzb.size();
    }
}
