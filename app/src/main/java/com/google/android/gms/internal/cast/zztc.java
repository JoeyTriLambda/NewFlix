package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zztc extends zzsk {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zztc.class.getName());
    private static final boolean zzd = zzwj.zzx();
    zztd zza;

    private zztc() {
    }

    public /* synthetic */ zztc(zztb zztbVar) {
    }

    @Deprecated
    public static int zzt(int i10, zzux zzuxVar, zzvi zzviVar) {
        int iZzq = ((zzsh) zzuxVar).zzq(zzviVar);
        int iZzx = zzx(i10 << 3);
        return iZzx + iZzx + iZzq;
    }

    public static int zzu(int i10) {
        if (i10 >= 0) {
            return zzx(i10);
        }
        return 10;
    }

    public static int zzv(zzux zzuxVar, zzvi zzviVar) {
        int iZzq = ((zzsh) zzuxVar).zzq(zzviVar);
        return zzx(iZzq) + iZzq;
    }

    public static int zzw(String str) {
        int length;
        try {
            length = zzwn.zzc(str);
        } catch (zzwm unused) {
            length = str.getBytes(zzty.zzb).length;
        }
        return zzx(length) + length;
    }

    public static int zzx(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzy(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            j10 >>>= 14;
            i10 += 2;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static zztc zzz(byte[] bArr, int i10, int i11) {
        return new zzsz(bArr, 0, i11);
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzB(String str, zzwm zzwmVar) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzwmVar);
        byte[] bytes = str.getBytes(zzty.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzta(e10);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10) throws IOException;

    public abstract void zzd(int i10, boolean z10) throws IOException;

    public abstract void zze(int i10, zzsu zzsuVar) throws IOException;

    public abstract void zzf(int i10, int i11) throws IOException;

    public abstract void zzg(int i10) throws IOException;

    public abstract void zzh(int i10, long j10) throws IOException;

    public abstract void zzi(long j10) throws IOException;

    public abstract void zzj(int i10, int i11) throws IOException;

    public abstract void zzk(int i10) throws IOException;

    public abstract void zzl(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void zzm(int i10, String str) throws IOException;

    public abstract void zzo(int i10, int i11) throws IOException;

    public abstract void zzp(int i10, int i11) throws IOException;

    public abstract void zzq(int i10) throws IOException;

    public abstract void zzr(int i10, long j10) throws IOException;

    public abstract void zzs(long j10) throws IOException;
}
