package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzii extends zzik {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzij zzc;

    public zzii(zzij zzijVar) {
        this.zzc = zzijVar;
        this.zzb = zzijVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzip
    public final byte zza() {
        int i10 = this.zza;
        if (i10 >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i10 + 1;
        return this.zzc.zzb(i10);
    }
}
