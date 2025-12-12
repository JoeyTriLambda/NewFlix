package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzfu extends zzfm implements Set {
    private transient zzfq zza;

    public static int zzh(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (iHighestOneBit * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzfu zzj(Collection collection) {
        Object[] array = collection.toArray();
        return zzm(array.length, array);
    }

    public static zzfu zzk() {
        return zzgd.zza;
    }

    private static zzfu zzm(int i10, Object... objArr) {
        if (i10 == 0) {
            return zzgd.zza;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzgf(obj);
        }
        int iZzh = zzh(i10);
        Object[] objArr2 = new Object[iZzh];
        int i11 = iZzh - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object obj2 = objArr[i14];
            zzfw.zza(obj2, i14);
            int iHashCode = obj2.hashCode();
            int iZza = zzfj.zza(iHashCode);
            while (true) {
                int i15 = iZza & i11;
                Object obj3 = objArr2[i15];
                if (obj3 == null) {
                    objArr[i13] = obj2;
                    objArr2[i15] = obj2;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzgf(obj4);
        }
        if (zzh(i13) < iZzh / 2) {
            return zzm(i13, objArr);
        }
        int length = objArr.length;
        if (i13 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new zzgd(objArr, i12, objArr2, i11, i13);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfu) && zzl() && ((zzfu) obj).zzl() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzge.zza(this);
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public zzfq zzd() {
        zzfq zzfqVar = this.zza;
        if (zzfqVar != null) {
            return zzfqVar;
        }
        zzfq zzfqVarZzi = zzi();
        this.zza = zzfqVarZzi;
        return zzfqVarZzi;
    }

    @Override // com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zze */
    public abstract zzgg iterator();

    public zzfq zzi() {
        Object[] array = toArray();
        int i10 = zzfq.zzd;
        return zzfq.zzi(array, array.length);
    }

    public boolean zzl() {
        return false;
    }
}
