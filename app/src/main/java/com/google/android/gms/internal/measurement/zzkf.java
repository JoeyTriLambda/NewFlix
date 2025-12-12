package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzkf<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzkg> zza;

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzkg.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzlg) {
            return this.zza.getValue().zza((zzlg) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzkg zza() {
        return this.zza.getValue();
    }

    private zzkf(Map.Entry<K, zzkg> entry) {
        this.zza = entry;
    }
}
