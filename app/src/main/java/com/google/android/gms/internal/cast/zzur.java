package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzur extends LinkedHashMap {
    private static final zzur zza;
    private boolean zzb;

    static {
        zzur zzurVar = new zzur();
        zza = zzurVar;
        zzurVar.zzb = false;
    }

    private zzur() {
        this.zzb = true;
    }

    private static int zze(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof zztr) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = zzty.zzd;
        int length = bArr.length;
        int iZzb = zzty.zzb(length, bArr, 0, length);
        if (iZzb == 0) {
            return 1;
        }
        return iZzb;
    }

    private final void zzf() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzf();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iZze = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iZze += zze(entry.getValue()) ^ zze(entry.getKey());
        }
        return iZze;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        zzf();
        byte[] bArr = zzty.zzd;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        zzf();
        for (Object obj : map.keySet()) {
            byte[] bArr = zzty.zzd;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzf();
        return super.remove(obj);
    }

    public final zzur zza() {
        return isEmpty() ? new zzur() : new zzur(this);
    }

    public final void zzb() {
        this.zzb = false;
    }

    public final void zzc(zzur zzurVar) {
        zzf();
        if (zzurVar.isEmpty()) {
            return;
        }
        putAll(zzurVar);
    }

    public final boolean zzd() {
        return this.zzb;
    }

    private zzur(Map map) {
        super(map);
        this.zzb = true;
    }
}
