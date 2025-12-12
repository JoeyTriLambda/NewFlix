package c8;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AbstractMultimap.java */
/* loaded from: classes.dex */
public abstract class c<K, V> implements g<K, V> {
    @Override // c8.g
    public abstract Map<K, Collection<V>> asMap();

    public boolean containsValue(Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return asMap().equals(((g) obj).asMap());
        }
        return false;
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
