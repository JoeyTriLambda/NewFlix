package uh;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.koin.core.scope.Scope;
import zf.f;
import zf.i;

/* compiled from: ScopeRegistry.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20383e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final th.c f20384f = th.b._q("_root_");

    /* renamed from: a, reason: collision with root package name */
    public final kh.a f20385a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet<th.a> f20386b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Scope> f20387c;

    /* renamed from: d, reason: collision with root package name */
    public final Scope f20388d;

    /* compiled from: ScopeRegistry.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final th.c getRootScopeQualifier() {
            return c.f20384f;
        }
    }

    public c(kh.a aVar) {
        i.checkNotNullParameter(aVar, "_koin");
        this.f20385a = aVar;
        HashSet<th.a> hashSet = new HashSet<>();
        this.f20386b = hashSet;
        Map<String, Scope> mapSafeHashMap = yh.b.f22543a.safeHashMap();
        this.f20387c = mapSafeHashMap;
        Scope scope = new Scope(f20384f, "_root_", true, aVar);
        this.f20388d = scope;
        hashSet.add(scope.getScopeQualifier());
        mapSafeHashMap.put(scope.getId(), scope);
    }

    public final void close$koin_core() {
        Map<String, Scope> map = this.f20387c;
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            ((Scope) it.next()).close();
        }
        map.clear();
        this.f20386b.clear();
    }

    public final void deleteScope$koin_core(Scope scope) {
        i.checkNotNullParameter(scope, "scope");
        this.f20385a.getInstanceRegistry().dropScopeInstances$koin_core(scope);
        this.f20387c.remove(scope.getId());
    }

    public final Scope getRootScope() {
        return this.f20388d;
    }

    public final void loadScopes(Set<rh.a> set) {
        i.checkNotNullParameter(set, "modules");
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            this.f20386b.addAll(((rh.a) it.next()).getScopes());
        }
    }
}
