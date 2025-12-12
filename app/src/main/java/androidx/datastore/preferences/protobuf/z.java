package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: LazyStringArrayList.java */
/* loaded from: classes.dex */
public final class z extends c<String> implements a0, RandomAccess {

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2555m;

    static {
        new z().makeImmutable();
    }

    public z() {
        this(10);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        this.f2555m.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public Object getRaw(int i10) {
        return this.f2555m.get(i10);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f2555m);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public a0 getUnmodifiableView() {
        return isModifiable() ? new i1(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.c, androidx.datastore.preferences.protobuf.w.h
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f2555m.size();
    }

    public z(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, String str) {
        ensureIsMutable();
        this.f2555m.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof a0) {
            collection = ((a0) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f2555m.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i10) {
        ArrayList arrayList = this.f2555m;
        Object obj = arrayList.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                arrayList.set(i10, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = w.toStringUtf8(bArr);
        if (w.isValidUtf8(bArr)) {
            arrayList.set(i10, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // androidx.datastore.preferences.protobuf.w.h
    /* renamed from: mutableCopyWithCapacity */
    public z mutableCopyWithCapacity2(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f2555m);
        return new z((ArrayList<Object>) arrayList);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public String set(int i10, String str) {
        ensureIsMutable();
        Object obj = this.f2555m.set(i10, str);
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).toStringUtf8() : w.toStringUtf8((byte[]) obj);
    }

    public z(ArrayList<Object> arrayList) {
        this.f2555m = arrayList;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i10) {
        ensureIsMutable();
        Object objRemove = this.f2555m.remove(i10);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (objRemove instanceof ByteString) {
            return ((ByteString) objRemove).toStringUtf8();
        }
        return w.toStringUtf8((byte[]) objRemove);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    public void add(ByteString byteString) {
        ensureIsMutable();
        this.f2555m.add(byteString);
        ((AbstractList) this).modCount++;
    }
}
