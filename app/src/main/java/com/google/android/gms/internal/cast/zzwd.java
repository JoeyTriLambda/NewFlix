package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzwd implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzwe zzb;

    public zzwd(zzwe zzweVar) {
        this.zzb = zzweVar;
        this.zza = zzweVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
