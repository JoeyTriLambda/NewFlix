package com.google.android.gms.internal.cast;

import ac.c;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzsu implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzsu zzb = new zzsr(zzty.zzd);
    private static final zzst zzd;
    private int zzc = 0;

    static {
        int i10 = zzsj.zza;
        zzd = new zzst(null);
        zza = new zzsm();
    }

    public static int zzj(int i10, int i11, int i12) {
        if (((i12 - i11) | i11) >= 0) {
            return i11;
        }
        throw new IndexOutOfBoundsException(c.g("End index: ", i11, " >= ", i12));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZze = this.zzc;
        if (iZze == 0) {
            int iZzd = zzd();
            iZze = zze(iZzd, 0, iZzd);
            if (iZze == 0) {
                iZze = 1;
            }
            this.zzc = iZze;
        }
        return iZze;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzsl(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzvx.zza(this) : zzvx.zza(zzf(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i10);

    public abstract byte zzb(int i10);

    public abstract int zzd();

    public abstract int zze(int i10, int i11, int i12);

    public abstract zzsu zzf(int i10, int i11);

    public abstract String zzg(Charset charset);

    public abstract void zzh(zzsk zzskVar) throws IOException;

    public abstract boolean zzi();

    public final int zzk() {
        return this.zzc;
    }

    public final String zzl(Charset charset) {
        return zzd() == 0 ? "" : zzg(charset);
    }
}
