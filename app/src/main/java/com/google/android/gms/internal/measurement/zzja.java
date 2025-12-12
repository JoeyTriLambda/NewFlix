package com.google.android.gms.internal.measurement;

import ac.c;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public abstract class zzja extends zzig {
    private static final Logger zzb = Logger.getLogger(zzja.class.getName());
    private static final boolean zzc = zzmz.zzc();
    zzjc zza;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    public static class zzb extends zzja {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        public zzb(byte[] bArr, int i10, int i11) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i11 | 0 | (bArr.length - i11)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i11)));
            }
            this.zzb = bArr;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = i11;
        }

        private final void zzc(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.zzb, this.zze, i11);
                this.zze += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i11)), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final int zza() {
            return this.zzd - this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzb(int i10, boolean z10) throws IOException {
            zzj(i10, 0);
            zza(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzd(int i10, zzij zzijVar) throws IOException {
            zzj(1, 3);
            zzk(2, i10);
            zzc(3, zzijVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzf(int i10, long j10) throws IOException {
            zzj(i10, 1);
            zzf(j10);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzg(int i10, int i11) throws IOException {
            zzj(i10, 5);
            zzh(i11);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzh(int i10) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i11 = this.zze;
                int i12 = i11 + 1;
                bArr[i11] = (byte) i10;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i10 >> 8);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (i10 >> 16);
                this.zze = i14 + 1;
                bArr[i14] = (byte) (i10 >>> 24);
            } catch (IndexOutOfBoundsException e10) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzi(int i10) throws IOException {
            if (i10 >= 0) {
                zzk(i10);
            } else {
                zzh(i10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzj(int i10, int i11) throws IOException {
            zzk((i10 << 3) | i11);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzk(int i10, int i11) throws IOException {
            zzj(i10, 0);
            zzk(i11);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zza(byte b10) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i10 = this.zze;
                this.zze = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzb(byte[] bArr, int i10, int i11) throws IOException {
            zzk(i11);
            zzc(bArr, 0, i11);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzf(long j10) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i10 = this.zze;
                int i11 = i10 + 1;
                bArr[i10] = (byte) j10;
                int i12 = i11 + 1;
                bArr[i11] = (byte) (j10 >> 8);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (j10 >> 16);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (j10 >> 24);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (j10 >> 32);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (j10 >> 40);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (j10 >> 48);
                this.zze = i17 + 1;
                bArr[i17] = (byte) (j10 >> 56);
            } catch (IndexOutOfBoundsException e10) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzk(int i10) throws IOException {
            while ((i10 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i11 = this.zze;
                    this.zze = i11 + 1;
                    bArr[i11] = (byte) (i10 | 128);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e10);
                }
            }
            byte[] bArr2 = this.zzb;
            int i12 = this.zze;
            this.zze = i12 + 1;
            bArr2[i12] = (byte) i10;
        }

        @Override // com.google.android.gms.internal.measurement.zzig
        public final void zza(byte[] bArr, int i10, int i11) throws IOException {
            zzc(bArr, i10, i11);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzb(zzij zzijVar) throws IOException {
            zzk(zzijVar.zzb());
            zzijVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzc(int i10, zzij zzijVar) throws IOException {
            zzj(i10, 2);
            zzb(zzijVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzb(int i10, zzlg zzlgVar) throws IOException {
            zzj(1, 3);
            zzk(2, i10);
            zzj(3, 2);
            zzc(zzlgVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzc(int i10, zzlg zzlgVar, zzly zzlyVar) throws IOException {
            zzj(i10, 2);
            zzk(((zzhz) zzlgVar).zza(zzlyVar));
            zzlyVar.zza((zzly) zzlgVar, (zznt) this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzh(int i10, int i11) throws IOException {
            zzj(i10, 0);
            zzi(i11);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzh(int i10, long j10) throws IOException {
            zzj(i10, 0);
            zzh(j10);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzc(zzlg zzlgVar) throws IOException {
            zzk(zzlgVar.zzbw());
            zzlgVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzh(long j10) throws IOException {
            if (zzja.zzc && zza() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i10 = this.zze;
                    this.zze = i10 + 1;
                    zzmz.zza(bArr, i10, (byte) (((int) j10) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i11 = this.zze;
                this.zze = i11 + 1;
                zzmz.zza(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.zzb;
                    int i12 = this.zze;
                    this.zze = i12 + 1;
                    bArr3[i12] = (byte) (((int) j10) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e10);
                }
            }
            byte[] bArr4 = this.zzb;
            int i13 = this.zze;
            this.zze = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzb(int i10, String str) throws IOException {
            zzj(i10, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzja
        public final void zzb(String str) throws IOException {
            int i10 = this.zze;
            try {
                int iZzg = zzja.zzg(str.length() * 3);
                int iZzg2 = zzja.zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i11 = i10 + iZzg2;
                    this.zze = i11;
                    int iZza = zznd.zza(str, this.zzb, i11, zza());
                    this.zze = i10;
                    zzk((iZza - i10) - iZzg2);
                    this.zze = iZza;
                    return;
                }
                zzk(zznd.zza(str));
                this.zze = zznd.zza(str, this.zzb, this.zze, zza());
            } catch (zznh e10) {
                this.zze = i10;
                zza(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new zza(e11);
            }
        }
    }

    public static int zza(double d10) {
        return 8;
    }

    public static int zzb(int i10) {
        return 4;
    }

    public static int zzc(long j10) {
        return 8;
    }

    public static int zzd(int i10) {
        return 4;
    }

    public static int zze(int i10, int i11) {
        return zzg(zzl(i11)) + zzg(i10 << 3);
    }

    public static int zzf(int i10) {
        return zzg(i10 << 3);
    }

    public static int zzg(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    private static long zzi(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private static int zzl(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b10) throws IOException;

    public abstract void zzb(int i10, zzlg zzlgVar) throws IOException;

    public abstract void zzb(int i10, String str) throws IOException;

    public abstract void zzb(int i10, boolean z10) throws IOException;

    public abstract void zzb(zzij zzijVar) throws IOException;

    public abstract void zzb(String str) throws IOException;

    public abstract void zzb(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void zzc(int i10, zzij zzijVar) throws IOException;

    public abstract void zzc(int i10, zzlg zzlgVar, zzly zzlyVar) throws IOException;

    public abstract void zzc(zzlg zzlgVar) throws IOException;

    public abstract void zzd(int i10, zzij zzijVar) throws IOException;

    public abstract void zzf(int i10, long j10) throws IOException;

    public abstract void zzf(long j10) throws IOException;

    public abstract void zzg(int i10, int i11) throws IOException;

    public abstract void zzh(int i10) throws IOException;

    public abstract void zzh(int i10, int i11) throws IOException;

    public abstract void zzh(int i10, long j10) throws IOException;

    public abstract void zzh(long j10) throws IOException;

    public abstract void zzi(int i10) throws IOException;

    public final void zzj(int i10) throws IOException {
        zzk(zzl(i10));
    }

    public abstract void zzj(int i10, int i11) throws IOException;

    public abstract void zzk(int i10) throws IOException;

    public abstract void zzk(int i10, int i11) throws IOException;

    private zzja() {
    }

    public static int zza(float f10) {
        return 4;
    }

    public static int zzb(int i10, int i11) {
        return zzg(i10 << 3) + 4;
    }

    public static int zzd(int i10, int i11) {
        return zzg(i10 << 3) + 4;
    }

    public static int zzf(int i10, int i11) {
        return zzg(i11) + zzg(i10 << 3);
    }

    public final void zzg(int i10, long j10) throws IOException {
        zzh(i10, zzi(j10));
    }

    public final void zzi(int i10, int i11) throws IOException {
        zzk(i10, zzl(i11));
    }

    public static int zza(long j10) {
        return 8;
    }

    public static int zzb(int i10, long j10) {
        return zze(j10) + zzg(i10 << 3);
    }

    public static int zzc(int i10, int i11) {
        return zze(i11) + zzg(i10 << 3);
    }

    public static int zzd(int i10, long j10) {
        return zze(zzi(j10)) + zzg(i10 << 3);
    }

    public static int zze(int i10) {
        return zzg(zzl(i10));
    }

    public final void zzg(long j10) throws IOException {
        zzh(zzi(j10));
    }

    public static int zza(boolean z10) {
        return 1;
    }

    public static int zze(int i10, long j10) {
        return zze(j10) + zzg(i10 << 3);
    }

    public static int zza(int i10, boolean z10) {
        return zzg(i10 << 3) + 1;
    }

    public static int zzb(long j10) {
        return zze(j10);
    }

    public static int zzc(int i10) {
        return zze(i10);
    }

    public static int zzd(long j10) {
        return zze(zzi(j10));
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    public static class zza extends IOException {
        public zza(String str, Throwable th2) {
            super(c.j("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th2);
        }

        public zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zza(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzb(int i10, zzkk zzkkVar) {
        int iZzg = zzg(i10 << 3);
        int iZzb = zzkkVar.zzb();
        return zzg(iZzb) + iZzb + iZzg;
    }

    public static int zzc(int i10, long j10) {
        return zzg(i10 << 3) + 8;
    }

    public static int zze(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public static int zza(int i10, zzij zzijVar) {
        int iZzg = zzg(i10 << 3);
        int iZzb = zzijVar.zzb();
        return zzg(iZzb) + iZzb + iZzg;
    }

    public static int zzb(int i10, zzlg zzlgVar, zzly zzlyVar) {
        return zza(zzlgVar, zzlyVar) + zzg(i10 << 3);
    }

    public static int zza(zzij zzijVar) {
        int iZzb = zzijVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zzb(zzlg zzlgVar) {
        int iZzbw = zzlgVar.zzbw();
        return zzg(iZzbw) + iZzbw;
    }

    public static int zza(int i10, double d10) {
        return zzg(i10 << 3) + 8;
    }

    public static int zzb(int i10, zzij zzijVar) {
        return zza(3, zzijVar) + zzf(2, i10) + (zzg(8) << 1);
    }

    public static int zza(int i10, int i11) {
        return zze(i11) + zzg(i10 << 3);
    }

    public static int zza(int i10) {
        return zze(i10);
    }

    public static zzja zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zza(int i10, long j10) {
        return zzg(i10 << 3) + 8;
    }

    public static int zza(int i10, float f10) {
        return zzg(i10 << 3) + 4;
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    @Deprecated
    public static int zza(int i10, zzlg zzlgVar, zzly zzlyVar) {
        return ((zzhz) zzlgVar).zza(zzlyVar) + (zzg(i10 << 3) << 1);
    }

    public final void zzb(boolean z10) throws IOException {
        zza(z10 ? (byte) 1 : (byte) 0);
    }

    @Deprecated
    public static int zza(zzlg zzlgVar) {
        return zzlgVar.zzbw();
    }

    public final void zzb(int i10, double d10) throws IOException {
        zzf(i10, Double.doubleToRawLongBits(d10));
    }

    public static int zza(int i10, zzkk zzkkVar) {
        return zzb(3, zzkkVar) + zzf(2, i10) + (zzg(8) << 1);
    }

    public final void zzb(double d10) throws IOException {
        zzf(Double.doubleToRawLongBits(d10));
    }

    public final void zzb(int i10, float f10) throws IOException {
        zzg(i10, Float.floatToRawIntBits(f10));
    }

    public final void zzb(float f10) throws IOException {
        zzh(Float.floatToRawIntBits(f10));
    }

    public static int zza(zzkk zzkkVar) {
        int iZzb = zzkkVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zza(int i10, zzlg zzlgVar) {
        return zzb(zzlgVar) + zzg(24) + zzf(2, i10) + (zzg(8) << 1);
    }

    public static int zza(zzlg zzlgVar, zzly zzlyVar) {
        int iZza = ((zzhz) zzlgVar).zza(zzlyVar);
        return zzg(iZza) + iZza;
    }

    public static int zza(int i10, String str) {
        return zza(str) + zzg(i10 << 3);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zznd.zza(str);
        } catch (zznh unused) {
            length = str.getBytes(zzjw.zza).length;
        }
        return zzg(length) + length;
    }

    public final void zza(String str, zznh zznhVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznhVar);
        byte[] bytes = str.getBytes(zzjw.zza);
        try {
            zzk(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zza(e10);
        }
    }
}
