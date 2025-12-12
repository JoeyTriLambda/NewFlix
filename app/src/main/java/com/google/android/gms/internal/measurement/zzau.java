package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzau implements Iterator<zzaq> {
    private int zza = 0;
    private final /* synthetic */ zzas zzb;

    public zzau(zzas zzasVar) {
        this.zzb = zzasVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb.zza.length();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        if (this.zza >= this.zzb.zza.length()) {
            throw new NoSuchElementException();
        }
        String str = this.zzb.zza;
        int i10 = this.zza;
        this.zza = i10 + 1;
        return new zzas(String.valueOf(str.charAt(i10)));
    }
}
