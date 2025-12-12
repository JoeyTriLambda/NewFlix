package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzsl extends zzsn {
    final /* synthetic */ zzsu zza;
    private int zzb = 0;
    private final int zzc;

    public zzsl(zzsu zzsuVar) {
        this.zza = zzsuVar;
        this.zzc = zzsuVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzsp
    public final byte zza() {
        int i10 = this.zzb;
        if (i10 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i10 + 1;
        return this.zza.zzb(i10);
    }
}
