package uh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.scope.Scope;
import zf.i;

/* compiled from: InstanceRegistry.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final kh.a f20379a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, ph.c<?>> f20380b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, SingleInstanceFactory<?>> f20381c;

    public a(kh.a aVar) {
        i.checkNotNullParameter(aVar, "_koin");
        this.f20379a = aVar;
        this.f20380b = yh.b.f22543a.safeHashMap();
        this.f20381c = new HashMap<>();
    }

    public static /* synthetic */ void saveMapping$default(a aVar, boolean z10, String str, ph.c cVar, boolean z11, int i10, Object obj) throws DefinitionOverrideException {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        aVar.saveMapping(z10, str, cVar, z11);
    }

    public final void close$koin_core() {
        Map<String, ph.c<?>> map = this.f20380b;
        for (Map.Entry<String, ph.c<?>> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue().dropAll();
        }
        map.clear();
    }

    public final void createAllEagerInstances$koin_core() {
        HashMap<Integer, SingleInstanceFactory<?>> map = this.f20381c;
        Collection<SingleInstanceFactory<?>> collectionValues = map.values();
        i.checkNotNullExpressionValue(collectionValues, "eagerInstances.values");
        if (!collectionValues.isEmpty()) {
            kh.a aVar = this.f20379a;
            ph.b bVar = new ph.b(aVar.getLogger(), aVar.getScopeRegistry().getRootScope(), null, 4, null);
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ((SingleInstanceFactory) it.next()).get(bVar);
            }
        }
        map.clear();
    }

    public final void dropScopeInstances$koin_core(Scope scope) {
        i.checkNotNullParameter(scope, "scope");
        Collection<ph.c<?>> collectionValues = this.f20380b.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof ScopedInstanceFactory) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ScopedInstanceFactory) it.next()).drop(scope);
        }
    }

    public final void loadModules$koin_core(Set<rh.a> set, boolean z10) throws DefinitionOverrideException {
        i.checkNotNullParameter(set, "modules");
        for (rh.a aVar : set) {
            for (Map.Entry<String, ph.c<?>> entry : aVar.getMappings().entrySet()) {
                saveMapping$default(this, z10, entry.getKey(), entry.getValue(), false, 8, null);
            }
            for (SingleInstanceFactory<?> singleInstanceFactory : aVar.getEagerInstances()) {
                this.f20381c.put(Integer.valueOf(singleInstanceFactory.hashCode()), singleInstanceFactory);
            }
        }
    }

    public final ph.c<?> resolveDefinition$koin_core(gg.b<?> bVar, th.a aVar, th.a aVar2) {
        i.checkNotNullParameter(bVar, "clazz");
        i.checkNotNullParameter(aVar2, "scopeQualifier");
        return this.f20380b.get(nh.a.indexKey(bVar, aVar, aVar2));
    }

    public final <T> T resolveInstance$koin_core(th.a aVar, gg.b<?> bVar, th.a aVar2, ph.b bVar2) {
        i.checkNotNullParameter(bVar, "clazz");
        i.checkNotNullParameter(aVar2, "scopeQualifier");
        i.checkNotNullParameter(bVar2, "instanceContext");
        ph.c<?> cVarResolveDefinition$koin_core = resolveDefinition$koin_core(bVar, aVar, aVar2);
        Object obj = cVarResolveDefinition$koin_core != null ? cVarResolveDefinition$koin_core.get(bVar2) : null;
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    public final void saveMapping(boolean z10, String str, ph.c<?> cVar, boolean z11) throws DefinitionOverrideException {
        i.checkNotNullParameter(str, "mapping");
        i.checkNotNullParameter(cVar, "factory");
        Map<String, ph.c<?>> map = this.f20380b;
        boolean zContainsKey = map.containsKey(str);
        kh.a aVar = this.f20379a;
        if (zContainsKey) {
            if (!z10) {
                rh.b.overrideError(cVar, str);
            } else if (z11) {
                qh.b logger = aVar.getLogger();
                StringBuilder sbV = ac.c.v("(+) override index '", str, "' -> '");
                sbV.append(cVar.getBeanDefinition());
                sbV.append('\'');
                String string = sbV.toString();
                Level level = Level.WARNING;
                if (logger.isAt(level)) {
                    logger.display(level, string);
                }
            }
        }
        qh.b logger2 = aVar.getLogger();
        StringBuilder sbV2 = ac.c.v("(+) index '", str, "' -> '");
        sbV2.append(cVar.getBeanDefinition());
        sbV2.append('\'');
        String string2 = sbV2.toString();
        Level level2 = Level.DEBUG;
        if (logger2.isAt(level2)) {
            logger2.display(level2, string2);
        }
        map.put(str, cVar);
    }

    public final int size() {
        return this.f20380b.size();
    }
}
