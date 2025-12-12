package l8;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: CycleDetector.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: CycleDetector.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final l8.b<?> f15967a;

        /* renamed from: b, reason: collision with root package name */
        public final HashSet f15968b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final HashSet f15969c = new HashSet();

        public a(l8.b<?> bVar) {
            this.f15967a = bVar;
        }
    }

    /* compiled from: CycleDetector.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final r<?> f15970a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f15971b;

        public b() {
            throw null;
        }

        public b(r rVar, boolean z10) {
            this.f15970a = rVar;
            this.f15971b = z10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return bVar.f15970a.equals(this.f15970a) && bVar.f15971b == this.f15971b;
        }

        public int hashCode() {
            return ((this.f15970a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f15971b).hashCode();
        }
    }

    public static void a(ArrayList arrayList) {
        Set<a> set;
        HashMap map = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i10 = 0;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (a aVar : (Set) it2.next()) {
                        for (l lVar : aVar.f15967a.getDependencies()) {
                            if (lVar.isDirectInjection() && (set = (Set) map.get(new b(lVar.getInterface(), lVar.isSet()))) != null) {
                                for (a aVar2 : set) {
                                    aVar.f15968b.add(aVar2);
                                    aVar2.f15969c.add(aVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    a aVar3 = (a) it4.next();
                    if (aVar3.f15969c.isEmpty()) {
                        hashSet2.add(aVar3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    a aVar4 = (a) hashSet2.iterator().next();
                    hashSet2.remove(aVar4);
                    i10++;
                    Iterator it5 = aVar4.f15968b.iterator();
                    while (it5.hasNext()) {
                        a aVar5 = (a) it5.next();
                        aVar5.f15969c.remove(aVar4);
                        if (aVar5.f15969c.isEmpty()) {
                            hashSet2.add(aVar5);
                        }
                    }
                }
                if (i10 == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it6 = hashSet.iterator();
                while (it6.hasNext()) {
                    a aVar6 = (a) it6.next();
                    if (!aVar6.f15969c.isEmpty() && !aVar6.f15968b.isEmpty()) {
                        arrayList2.add(aVar6.f15967a);
                    }
                }
                throw new DependencyCycleException(arrayList2);
            }
            l8.b bVar = (l8.b) it.next();
            a aVar7 = new a(bVar);
            for (r rVar : bVar.getProvidedInterfaces()) {
                boolean z10 = !bVar.isValue();
                b bVar2 = new b(rVar, z10);
                if (!map.containsKey(bVar2)) {
                    map.put(bVar2, new HashSet());
                }
                Set set2 = (Set) map.get(bVar2);
                if (!set2.isEmpty() && !z10) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", rVar));
                }
                set2.add(aVar7);
            }
        }
    }
}
