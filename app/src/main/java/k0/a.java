package k0;

import b0.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import w0.f;

/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final f f14712a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    public final k<T, ArrayList<T>> f14713b = new k<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f14714c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet<T> f14715d = new HashSet<>();

    public final void a(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t10)) {
            return;
        }
        if (hashSet.contains(t10)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t10);
        ArrayList<T> arrayList2 = this.f14713b.get(t10);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                a(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(t10);
        arrayList.add(t10);
    }

    public void addEdge(T t10, T t11) {
        k<T, ArrayList<T>> kVar = this.f14713b;
        if (!kVar.containsKey(t10) || !kVar.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = kVar.get(t10);
        if (arrayList == null) {
            arrayList = (ArrayList) this.f14712a.acquire();
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            kVar.put(t10, arrayList);
        }
        arrayList.add(t11);
    }

    public void addNode(T t10) {
        k<T, ArrayList<T>> kVar = this.f14713b;
        if (kVar.containsKey(t10)) {
            return;
        }
        kVar.put(t10, null);
    }

    public void clear() {
        k<T, ArrayList<T>> kVar = this.f14713b;
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListValueAt = kVar.valueAt(i10);
            if (arrayListValueAt != null) {
                arrayListValueAt.clear();
                this.f14712a.release(arrayListValueAt);
            }
        }
        kVar.clear();
    }

    public boolean contains(T t10) {
        return this.f14713b.containsKey(t10);
    }

    public List getIncomingEdges(T t10) {
        return this.f14713b.get(t10);
    }

    public List<T> getOutgoingEdges(T t10) {
        k<T, ArrayList<T>> kVar = this.f14713b;
        int size = kVar.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListValueAt = kVar.valueAt(i10);
            if (arrayListValueAt != null && arrayListValueAt.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.keyAt(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<T> getSortedList() {
        ArrayList<T> arrayList = this.f14714c;
        arrayList.clear();
        HashSet<T> hashSet = this.f14715d;
        hashSet.clear();
        k<T, ArrayList<T>> kVar = this.f14713b;
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(kVar.keyAt(i10), arrayList, hashSet);
        }
        return arrayList;
    }

    public boolean hasOutgoingEdges(T t10) {
        k<T, ArrayList<T>> kVar = this.f14713b;
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListValueAt = kVar.valueAt(i10);
            if (arrayListValueAt != null && arrayListValueAt.contains(t10)) {
                return true;
            }
        }
        return false;
    }
}
