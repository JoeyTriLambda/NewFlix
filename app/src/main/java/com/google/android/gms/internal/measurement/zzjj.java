package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzjj<T extends zzjl<T>> {
    private static final zzjj zzb = new zzjj(true);
    final zzlz<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    private zzjj() {
        this.zza = zzlz.zza(16);
    }

    public static int zza(zzng zzngVar, int i10, Object obj) {
        int iZzf = zzja.zzf(i10);
        if (zzngVar == zzng.zzj) {
            zzjw.zza((zzlg) obj);
            iZzf <<= 1;
        }
        return iZzf + zza(zzngVar, obj);
    }

    public static <T extends zzjl<T>> zzjj<T> zzb() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzjj zzjjVar = new zzjj();
        for (int i10 = 0; i10 < this.zza.zza(); i10++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i10);
            zzjjVar.zzb((zzjl) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzjjVar.zzb((zzjl) entry.getKey(), entry.getValue());
        }
        zzjjVar.zzd = this.zzd;
        return zzjjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjj) {
            return this.zza.equals(((zzjj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzc() {
        return this.zzd ? new zzkh(this.zza.zzc().iterator()) : this.zza.zzc().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        return this.zzd ? new zzkh(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        for (int i10 = 0; i10 < this.zza.zza(); i10++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i10);
            if (entryZzb.getValue() instanceof zzjt) {
                ((zzjt) entryZzb.getValue()).zzcf();
            }
        }
        this.zza.zzd();
        this.zzc = true;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        for (int i10 = 0; i10 < this.zza.zza(); i10++) {
            if (!zzc(this.zza.zzb(i10))) {
                return false;
            }
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            if (!zzc((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z10 = value instanceof zzkg;
        if (key.zze()) {
            if (z10) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZza = zza((zzjj<T>) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.zza((zzlz<T, Object>) key, (T) objZza);
            return;
        }
        if (key.zzc() != zznq.MESSAGE) {
            if (z10) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.zza((zzlz<T, Object>) key, (T) zza(value));
            return;
        }
        Object objZza2 = zza((zzjj<T>) key);
        if (objZza2 == null) {
            this.zza.zza((zzlz<T, Object>) key, (T) zza(value));
            if (z10) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z10) {
            value = zzkg.zza();
        }
        this.zza.zza((zzlz<T, Object>) key, (T) (objZza2 instanceof zzll ? key.zza((zzll) objZza2, (zzll) value) : key.zza(((zzlg) objZza2).zzce(), (zzlg) value).zzah()));
    }

    private zzjj(zzlz<T, Object> zzlzVar) {
        this.zza = zzlzVar;
        zze();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.measurement.zzng r0 = r5.zzb()
            com.google.android.gms.internal.measurement.zzjw.zza(r6)
            int[] r1 = com.google.android.gms.internal.measurement.zzjm.zza
            com.google.android.gms.internal.measurement.zznq r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = 0
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzlg
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzkg
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzjv
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzij
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
        L34:
            r0 = 1
            goto L47
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.measurement.zzng r5 = r5.zzb()
            com.google.android.gms.internal.measurement.zznq r5 = r5.zzb()
            r3[r1] = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r6 = 2
            r3[r6] = r5
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjj.zzc(com.google.android.gms.internal.measurement.zzjl, java.lang.Object):void");
    }

    private static int zza(zzng zzngVar, Object obj) {
        switch (zzjm.zzb[zzngVar.ordinal()]) {
            case 1:
                return zzja.zza(((Double) obj).doubleValue());
            case 2:
                return zzja.zza(((Float) obj).floatValue());
            case 3:
                return zzja.zzb(((Long) obj).longValue());
            case 4:
                return zzja.zze(((Long) obj).longValue());
            case 5:
                return zzja.zzc(((Integer) obj).intValue());
            case 6:
                return zzja.zza(((Long) obj).longValue());
            case 7:
                return zzja.zzb(((Integer) obj).intValue());
            case 8:
                return zzja.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzja.zza((zzlg) obj);
            case 10:
                if (obj instanceof zzkg) {
                    return zzja.zza((zzkg) obj);
                }
                return zzja.zzb((zzlg) obj);
            case 11:
                if (obj instanceof zzij) {
                    return zzja.zza((zzij) obj);
                }
                return zzja.zza((String) obj);
            case 12:
                if (obj instanceof zzij) {
                    return zzja.zza((zzij) obj);
                }
                return zzja.zza((byte[]) obj);
            case 13:
                return zzja.zzg(((Integer) obj).intValue());
            case 14:
                return zzja.zzd(((Integer) obj).intValue());
            case 15:
                return zzja.zzc(((Long) obj).longValue());
            case 16:
                return zzja.zze(((Integer) obj).intValue());
            case 17:
                return zzja.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzjv) {
                    return zzja.zza(((zzjv) obj).zza());
                }
                return zzja.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private zzjj(boolean z10) {
        this(zzlz.zza(0));
        zze();
    }

    private static <T extends zzjl<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zznq.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                if (!zzb(it.next())) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private final void zzb(T t10, Object obj) {
        if (t10.zze()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    zzc(t10, obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzc(t10, obj);
        }
        if (obj instanceof zzkg) {
            this.zzd = true;
        }
        this.zza.zza((zzlz<T, Object>) t10, (T) obj);
    }

    public static int zza(zzjl<?> zzjlVar, Object obj) {
        zzng zzngVarZzb = zzjlVar.zzb();
        int iZza = zzjlVar.zza();
        if (zzjlVar.zze()) {
            List list = (List) obj;
            int iZza2 = 0;
            if (zzjlVar.zzd()) {
                if (list.isEmpty()) {
                    return 0;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    iZza2 += zza(zzngVarZzb, it.next());
                }
                return zzja.zzg(iZza2) + zzja.zzf(iZza) + iZza2;
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzngVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzngVarZzb, iZza, obj);
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzli) {
            return ((zzli) obj).i_();
        }
        if (obj instanceof zzkg) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final int zza() {
        int iZza = 0;
        for (int i10 = 0; i10 < this.zza.zza(); i10++) {
            iZza += zza((Map.Entry) this.zza.zzb(i10));
        }
        Iterator it = this.zza.zzb().iterator();
        while (it.hasNext()) {
            iZza += zza((Map.Entry) it.next());
        }
        return iZza;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zznq.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzkg) {
                return zzja.zza(entry.getKey().zza(), (zzkg) value);
            }
            return zzja.zza(entry.getKey().zza(), (zzlg) value);
        }
        return zza((zzjl<?>) key, value);
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzll) {
            return ((zzll) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t10) {
        Object obj = this.zza.get(t10);
        if (!(obj instanceof zzkg)) {
            return obj;
        }
        return zzkg.zza();
    }

    public final void zza(zzjj<T> zzjjVar) {
        for (int i10 = 0; i10 < zzjjVar.zza.zza(); i10++) {
            zzb((Map.Entry) zzjjVar.zza.zzb(i10));
        }
        Iterator it = zzjjVar.zza.zzb().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    public static void zza(zzja zzjaVar, zzng zzngVar, int i10, Object obj) throws IOException {
        if (zzngVar == zzng.zzj) {
            zzlg zzlgVar = (zzlg) obj;
            zzjw.zza(zzlgVar);
            zzjaVar.zzj(i10, 3);
            zzlgVar.zza(zzjaVar);
            zzjaVar.zzj(i10, 4);
        }
        zzjaVar.zzj(i10, zzngVar.zza());
        switch (zzjm.zzb[zzngVar.ordinal()]) {
            case 1:
                zzjaVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzjaVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzjaVar.zzh(((Long) obj).longValue());
                break;
            case 4:
                zzjaVar.zzh(((Long) obj).longValue());
                break;
            case 5:
                zzjaVar.zzi(((Integer) obj).intValue());
                break;
            case 6:
                zzjaVar.zzf(((Long) obj).longValue());
                break;
            case 7:
                zzjaVar.zzh(((Integer) obj).intValue());
                break;
            case 8:
                zzjaVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzlg) obj).zza(zzjaVar);
                break;
            case 10:
                zzjaVar.zzc((zzlg) obj);
                break;
            case 11:
                if (obj instanceof zzij) {
                    zzjaVar.zzb((zzij) obj);
                    break;
                } else {
                    zzjaVar.zzb((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof zzij) {
                    zzjaVar.zzb((zzij) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzjaVar.zzb(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzjaVar.zzk(((Integer) obj).intValue());
                break;
            case 14:
                zzjaVar.zzh(((Integer) obj).intValue());
                break;
            case 15:
                zzjaVar.zzf(((Long) obj).longValue());
                break;
            case 16:
                zzjaVar.zzj(((Integer) obj).intValue());
                break;
            case 17:
                zzjaVar.zzg(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzjv) {
                    zzjaVar.zzi(((zzjv) obj).zza());
                    break;
                } else {
                    zzjaVar.zzi(((Integer) obj).intValue());
                    break;
                }
        }
    }
}
