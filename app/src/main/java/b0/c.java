package b0;

import java.util.Map;

/* compiled from: ArraySet.java */
/* loaded from: classes.dex */
public final class c extends j<Object, Object> {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f4648d;

    public c(d dVar) {
        this.f4648d = dVar;
    }

    @Override // b0.j
    public void colClear() {
        this.f4648d.clear();
    }

    @Override // b0.j
    public Object colGetEntry(int i10, int i11) {
        return this.f4648d.f4656m[i10];
    }

    @Override // b0.j
    public Map<Object, Object> colGetMap() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // b0.j
    public int colGetSize() {
        return this.f4648d.f4657n;
    }

    @Override // b0.j
    public int colIndexOfKey(Object obj) {
        return this.f4648d.indexOf(obj);
    }

    @Override // b0.j
    public int colIndexOfValue(Object obj) {
        return this.f4648d.indexOf(obj);
    }

    @Override // b0.j
    public void colPut(Object obj, Object obj2) {
        this.f4648d.add(obj);
    }

    @Override // b0.j
    public void colRemoveAt(int i10) {
        this.f4648d.removeAt(i10);
    }

    @Override // b0.j
    public Object colSetValue(int i10, Object obj) {
        throw new UnsupportedOperationException("not a map");
    }
}
