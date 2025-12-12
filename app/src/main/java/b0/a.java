package b0;

import java.util.Map;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public final class a extends j<Object, Object> {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f4646d;

    public a(b bVar) {
        this.f4646d = bVar;
    }

    @Override // b0.j
    public void colClear() {
        this.f4646d.clear();
    }

    @Override // b0.j
    public Object colGetEntry(int i10, int i11) {
        return this.f4646d.f4694m[(i10 << 1) + i11];
    }

    @Override // b0.j
    public Map<Object, Object> colGetMap() {
        return this.f4646d;
    }

    @Override // b0.j
    public int colGetSize() {
        return this.f4646d.f4695n;
    }

    @Override // b0.j
    public int colIndexOfKey(Object obj) {
        return this.f4646d.indexOfKey(obj);
    }

    @Override // b0.j
    public int colIndexOfValue(Object obj) {
        return this.f4646d.e(obj);
    }

    @Override // b0.j
    public void colPut(Object obj, Object obj2) {
        this.f4646d.put(obj, obj2);
    }

    @Override // b0.j
    public void colRemoveAt(int i10) {
        this.f4646d.removeAt(i10);
    }

    @Override // b0.j
    public Object colSetValue(int i10, Object obj) {
        return this.f4646d.setValueAt(i10, obj);
    }
}
