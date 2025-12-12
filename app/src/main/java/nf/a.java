package nf;

import java.util.Map;
import java.util.Map.Entry;
import zf.i;

/* compiled from: MapBuilder.kt */
/* loaded from: classes2.dex */
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends mf.d<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((a<E, K, V>) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry<?, ?>) obj);
        }
        return false;
    }

    public abstract /* bridge */ boolean remove(Map.Entry<?, ?> entry);

    public final boolean contains(E e10) {
        i.checkNotNullParameter(e10, "element");
        return containsEntry(e10);
    }
}
