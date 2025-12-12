package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzfx extends zzfq {
    static final zzfq zza = new zzfx(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzfx(Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zzez.zza(i10, this.zzc, "index");
        Object obj = this.zzb[i10];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzfq, com.google.android.gms.internal.cast.zzfm
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public final Object[] zzg() {
        return this.zzb;
    }
}
