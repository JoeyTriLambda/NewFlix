package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzwe extends AbstractList implements RandomAccess, zzuf {
    private final zzuf zza;

    public zzwe(zzuf zzufVar) {
        this.zza = zzufVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzue) this.zza).get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzwd(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        return new zzwc(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.cast.zzuf
    public final Object zze(int i10) {
        return this.zza.zze(i10);
    }

    @Override // com.google.android.gms.internal.cast.zzuf
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.cast.zzuf
    public final zzuf zzd() {
        return this;
    }
}
