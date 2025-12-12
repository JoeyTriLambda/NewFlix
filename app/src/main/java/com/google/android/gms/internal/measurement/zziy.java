package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zziy implements zzlv {
    private final zziu zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zziy(zziu zziuVar) {
        zziu zziuVar2 = (zziu) zzjw.zza(zziuVar, "input");
        this.zza = zziuVar2;
        zziuVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzc() throws IOException {
        int i10 = this.zzd;
        if (i10 != 0) {
            this.zzb = i10;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i11 = this.zzb;
        if (i11 == 0 || i11 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i11 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final zzij zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zzt() throws IOException {
        int i10;
        if (this.zza.zzt() || (i10 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i10);
    }

    private final <T> void zzd(T t10, zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        int iZzj = this.zza.zzj();
        zziu zziuVar = this.zza;
        if (zziuVar.zza >= zziuVar.zzb) {
            throw new zzkb("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzb = zziuVar.zzb(iZzj);
        this.zza.zza++;
        zzlyVar.zza(t10, this, zzjgVar);
        this.zza.zzc(0);
        r5.zza--;
        this.zza.zzd(iZzb);
    }

    public static zziy zza(zziu zziuVar) {
        zziy zziyVar = zziuVar.zzc;
        return zziyVar != null ? zziyVar : new zziy(zziuVar);
    }

    private final <T> T zzb(zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        T tZza = zzlyVar.zza();
        zzd(tZza, zzlyVar, zzjgVar);
        zzlyVar.zzc(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zze(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            int i10 = this.zzb & 7;
            if (i10 == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjuVar.zzd(this.zza.zze());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i10 == 5) {
                do {
                    zzjuVar.zzd(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zze()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i11 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzf(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            int i10 = this.zzb & 7;
            if (i10 == 1) {
                do {
                    zzkrVar.zza(this.zza.zzk());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkrVar.zza(this.zza.zzk());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzk()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzk()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzg(List<Float> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjp) {
            zzjp zzjpVar = (zzjp) list;
            int i10 = this.zzb & 7;
            if (i10 == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjpVar.zza(this.zza.zzb());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i10 == 5) {
                do {
                    zzjpVar.zza(this.zza.zzb());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Float.valueOf(this.zza.zzb()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i11 == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzh(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzjuVar.zzd(this.zza.zzf());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjuVar.zzd(this.zza.zzf());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzi(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzkrVar.zza(this.zza.zzl());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkrVar.zza(this.zza.zzl());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzl()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzl()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzj(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            int i10 = this.zzb & 7;
            if (i10 == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjuVar.zzd(this.zza.zzg());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i10 == 5) {
                do {
                    zzjuVar.zzd(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i11 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzk(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            int i10 = this.zzb & 7;
            if (i10 == 1) {
                do {
                    zzkrVar.zza(this.zza.zzn());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkrVar.zza(this.zza.zzn());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzn()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzl(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzjuVar.zzd(this.zza.zzh());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjuVar.zzd(this.zza.zzh());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzm(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzkrVar.zza(this.zza.zzo());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkrVar.zza(this.zza.zzo());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzp(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzjuVar.zzd(this.zza.zzj());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjuVar.zzd(this.zza.zzj());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzq(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkr) {
            zzkr zzkrVar = (zzkr) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzkrVar.zza(this.zza.zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkrVar.zza(this.zza.zzp());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    private final Object zza(zzng zzngVar, Class<?> cls, zzjg zzjgVar) throws IOException {
        switch (zzjb.zza[zzngVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzlu.zza().zza((Class) cls), zzjgVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> void zzc(T t10, zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        int i10 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzlyVar.zza(t10, this, zzjgVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzkb.zzg();
            }
        } finally {
            this.zzc = i10;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final <T> void zzb(T t10, zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        zzb(2);
        zzd(t10, zzlyVar, zzjgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzb(List<zzij> list) throws IOException {
        int iZzi;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzd(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzju) {
            zzju zzjuVar = (zzju) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzjuVar.zzd(this.zza.zzd());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjuVar.zzd(this.zza.zzd());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlv
    public final <T> void zzb(List<T> list, zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        int iZzi;
        int i10 = this.zzb;
        if ((i10 & 7) == 2) {
            do {
                list.add(zzb(zzlyVar, zzjgVar));
                if (this.zza.zzt() || this.zzd != 0) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == i10);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zzc(List<Double> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjf) {
            zzjf zzjfVar = (zzjf) list;
            int i10 = this.zzb & 7;
            if (i10 == 1) {
                do {
                    zzjfVar.zza(this.zza.zza());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjfVar.zza(this.zza.zza());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 1) {
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Double.valueOf(this.zza.zza()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    private final void zzb(int i10) throws IOException {
        if ((this.zzb & 7) != i10) {
            throw zzkb.zza();
        }
    }

    private final <T> T zza(zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        T tZza = zzlyVar.zza();
        zzc(tZza, zzlyVar, zzjgVar);
        zzlyVar.zzc(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final <T> void zza(T t10, zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        zzb(3);
        zzc(t10, zzlyVar, zzjgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final void zza(List<Boolean> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzih) {
            zzih zzihVar = (zzih) list;
            int i10 = this.zzb & 7;
            if (i10 == 0) {
                do {
                    zzihVar.zza(this.zza.zzu());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i10 == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzihVar.zza(this.zza.zzu());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkb.zza();
        }
        int i11 = this.zzb & 7;
        if (i11 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i11 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkb.zza();
    }

    private static void zzd(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw zzkb.zzg();
        }
    }

    private static void zzc(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw zzkb.zzg();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlv
    @Deprecated
    public final <T> void zza(List<T> list, zzly<T> zzlyVar, zzjg zzjgVar) throws IOException {
        int iZzi;
        int i10 = this.zzb;
        if ((i10 & 7) == 3) {
            do {
                list.add(zza(zzlyVar, zzjgVar));
                if (this.zza.zzt() || this.zzd != 0) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == i10);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzkx<K, V> r9, com.google.android.gms.internal.measurement.zzjg r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.measurement.zziu r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.measurement.zziu r2 = r7.zza
            int r1 = r2.zzb(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.measurement.zziu r5 = r7.zza     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzt()     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.measurement.zzkb r4 = new com.google.android.gms.internal.measurement.zzkb     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.measurement.zzng r4 = r9.zzc     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzd     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.measurement.zzng r4 = r9.zza     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.measurement.zzke -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.measurement.zzkb r8 = new com.google.android.gms.internal.measurement.zzkb     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.measurement.zziu r8 = r7.zza
            r8.zzd(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zziu r9 = r7.zza
            r9.zzd(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziy.zza(java.util.Map, com.google.android.gms.internal.measurement.zzkx, com.google.android.gms.internal.measurement.zzjg):void");
    }

    private final void zza(List<String> list, boolean z10) throws IOException {
        int iZzi;
        int iZzi2;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzkm) && !z10) {
                zzkm zzkmVar = (zzkm) list;
                do {
                    zzkmVar.zza(zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            do {
                list.add(z10 ? zzr() : zzq());
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkb.zza();
    }

    private final void zza(int i10) throws IOException {
        if (this.zza.zzc() != i10) {
            throw zzkb.zzh();
        }
    }
}
