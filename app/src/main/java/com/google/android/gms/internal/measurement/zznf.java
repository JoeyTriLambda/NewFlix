package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
abstract class zznf {
    public abstract int zza(int i10, byte[] bArr, int i11, int i12);

    public abstract int zza(String str, byte[] bArr, int i10, int i11);

    public abstract String zza(byte[] bArr, int i10, int i11) throws zzkb;

    public final boolean zzb(byte[] bArr, int i10, int i11) {
        return zza(0, bArr, i10, i11) == 0;
    }
}
