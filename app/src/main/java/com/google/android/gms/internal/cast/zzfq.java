package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzfq extends zzfm implements List, RandomAccess {
    private static final zzgh zza = new zzfo(zzfx.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzfq zzi(Object[] objArr, int i10) {
        return i10 == 0 ? zzfx.zza : new zzfx(objArr, i10);
    }

    public static zzfq zzj(Collection collection) {
        if (!(collection instanceof zzfm)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzfw.zzb(array, length);
            return zzi(array, length);
        }
        zzfq zzfqVarZzd = ((zzfm) collection).zzd();
        if (!zzfqVarZzd.zzf()) {
            return zzfqVarZzd;
        }
        Object[] array2 = zzfqVarZzd.toArray();
        return zzi(array2, array2.length);
    }

    public static zzfq zzk(Object obj, Object obj2) {
        Object[] objArr = {MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING};
        zzfw.zzb(objArr, 2);
        return zzi(objArr, 2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i10 = 0; i10 < size; i10++) {
                        if (zzeu.zza(get(i10), list.get(i10))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !zzeu.zza(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i10 = 0; i10 < size; i10++) {
            iHashCode = (iHashCode * 31) + get(i10).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.cast.zzfm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    public int zza(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = get(i11);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    /* renamed from: zze */
    public final zzgg iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzfq subList(int i10, int i11) {
        zzez.zzd(i10, i11, size());
        int i12 = i11 - i10;
        return i12 == size() ? this : i12 == 0 ? zzfx.zza : new zzfp(this, i10, i12);
    }

    @Override // java.util.List
    /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final zzgh listIterator(int i10) {
        zzez.zzb(i10, size(), "index");
        return isEmpty() ? zza : new zzfo(this, i10);
    }

    @Override // com.google.android.gms.internal.cast.zzfm
    @Deprecated
    public final zzfq zzd() {
        return this;
    }
}
