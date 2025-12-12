package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
class zzlz<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private List<zzmk> zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzml zze;
    private Map<K, V> zzf;
    private volatile zzmd zzg;

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzlz<K, V>) comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzml(this);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlz)) {
            return super.equals(obj);
        }
        zzlz zzlzVar = (zzlz) obj;
        int size = size();
        if (size != zzlzVar.size()) {
            return false;
        }
        int iZza = zza();
        if (iZza != zzlzVar.zza()) {
            return entrySet().equals(zzlzVar.entrySet());
        }
        for (int i10 = 0; i10 < iZza; i10++) {
            if (!zzb(i10).equals(zzlzVar.zzb(i10))) {
                return false;
            }
        }
        if (iZza != size) {
            return this.zzc.equals(zzlzVar.zzc);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza((zzlz<K, V>) comparable);
        return iZza >= 0 ? (V) this.zzb.get(iZza).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZza = zza();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iZza; i10++) {
            iHashCode += this.zzb.get(i10).hashCode();
        }
        return this.zzc.size() > 0 ? iHashCode + this.zzc.hashCode() : iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzlz<K, V>) obj, (Comparable) obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int iZza = zza((zzlz<K, V>) comparable);
        if (iZza >= 0) {
            return zzc(iZza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzc.size() + this.zzb.size();
    }

    public final boolean zze() {
        return this.zzd;
    }

    private zzlz(int i10) {
        this.zza = i10;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzc(int i10) {
        zzg();
        V v10 = (V) this.zzb.remove(i10).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zzb.add(new zzmk(this, it.next()));
            it.remove();
        }
        return v10;
    }

    public final Iterable<Map.Entry<K, V>> zzb() {
        return this.zzc.isEmpty() ? zzmf.zza() : this.zzc.entrySet();
    }

    public void zzd() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    private final int zza(K k10) {
        int size = this.zzb.size() - 1;
        if (size >= 0) {
            int iCompareTo = k10.compareTo((Comparable) this.zzb.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int iCompareTo2 = k10.compareTo((Comparable) this.zzb.get(i11).getKey());
            if (iCompareTo2 < 0) {
                size = i11 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i11;
                }
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    public final Map.Entry<K, V> zzb(int i10) {
        return this.zzb.get(i10);
    }

    public final int zza() {
        return this.zzb.size();
    }

    public static <FieldDescriptorType extends zzjl<FieldDescriptorType>> zzlz<FieldDescriptorType, Object> zza(int i10) {
        return new zzmc(i10);
    }

    public final Set<Map.Entry<K, V>> zzc() {
        if (this.zzg == null) {
            this.zzg = new zzmd(this);
        }
        return this.zzg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V zza(K k10, V v10) {
        zzg();
        int iZza = zza((zzlz<K, V>) k10);
        if (iZza >= 0) {
            return (V) this.zzb.get(iZza).setValue(v10);
        }
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i10 = -(iZza + 1);
        if (i10 >= this.zza) {
            return zzf().put(k10, v10);
        }
        int size = this.zzb.size();
        int i11 = this.zza;
        if (size == i11) {
            zzmk zzmkVarRemove = this.zzb.remove(i11 - 1);
            zzf().put((Comparable) zzmkVarRemove.getKey(), zzmkVarRemove.getValue());
        }
        this.zzb.add(i10, new zzmk(this, k10, v10));
        return null;
    }
}
