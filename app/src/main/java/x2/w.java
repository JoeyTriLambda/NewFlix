package x2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StartStopToken.kt */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21484a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f21485b = new LinkedHashMap();

    public final boolean contains(f3.m mVar) {
        boolean zContainsKey;
        zf.i.checkNotNullParameter(mVar, "id");
        synchronized (this.f21484a) {
            zContainsKey = this.f21485b.containsKey(mVar);
        }
        return zContainsKey;
    }

    public final v remove(f3.m mVar) {
        v vVar;
        zf.i.checkNotNullParameter(mVar, "id");
        synchronized (this.f21484a) {
            vVar = (v) this.f21485b.remove(mVar);
        }
        return vVar;
    }

    public final v tokenFor(f3.m mVar) {
        v vVar;
        zf.i.checkNotNullParameter(mVar, "id");
        synchronized (this.f21484a) {
            LinkedHashMap linkedHashMap = this.f21485b;
            Object vVar2 = linkedHashMap.get(mVar);
            if (vVar2 == null) {
                vVar2 = new v(mVar);
                linkedHashMap.put(mVar, vVar2);
            }
            vVar = (v) vVar2;
        }
        return vVar;
    }

    public final List<v> remove(String str) {
        List<v> list;
        zf.i.checkNotNullParameter(str, "workSpecId");
        synchronized (this.f21484a) {
            LinkedHashMap linkedHashMap = this.f21485b;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (zf.i.areEqual(((f3.m) entry.getKey()).getWorkSpecId(), str)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = linkedHashMap2.keySet().iterator();
            while (it.hasNext()) {
                this.f21485b.remove((f3.m) it.next());
            }
            list = mf.q.toList(linkedHashMap2.values());
        }
        return list;
    }

    public final v tokenFor(f3.t tVar) {
        zf.i.checkNotNullParameter(tVar, "spec");
        return tokenFor(f3.w.generationalId(tVar));
    }
}
