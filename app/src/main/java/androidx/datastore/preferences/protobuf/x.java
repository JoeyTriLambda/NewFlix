package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: LazyField.java */
/* loaded from: classes.dex */
public final class x extends y {

    /* compiled from: LazyField.java */
    public static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: b, reason: collision with root package name */
        public final Map.Entry<K, x> f2551b;

        public a() {
            throw null;
        }

        public a(Map.Entry entry) {
            this.f2551b = entry;
        }

        public x getField() {
            return this.f2551b.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2551b.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            x value = this.f2551b.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof k0) {
                return this.f2551b.getValue().setValue((k0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: LazyField.java */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Object>> f2552b;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.f2552b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2552b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f2552b.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f2552b.next();
            return next.getValue() instanceof x ? new a(next) : next;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public k0 getValue() {
        return getValue(null);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
