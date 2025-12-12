package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzfn extends zzfk {
    public zzfn() {
        super(4);
    }

    public final zzfn zzb(Object obj) {
        obj.getClass();
        int i10 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i10) {
            this.zza = Arrays.copyOf(objArr, zzfl.zza(length, i10));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i11 = this.zzb;
        this.zzb = i11 + 1;
        objArr2[i11] = obj;
        return this;
    }

    public final zzfq zzc() {
        this.zzc = true;
        return zzfq.zzi(this.zza, this.zzb);
    }
}
