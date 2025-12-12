package rh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mf.k;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import ph.c;
import zf.f;
import zf.i;

/* compiled from: Module.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f18975a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18976b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet<SingleInstanceFactory<?>> f18977c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, c<?>> f18978d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet<th.a> f18979e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f18980f;

    public a() {
        this(false, 1, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && i.areEqual(this.f18976b, ((a) obj).f18976b);
    }

    public final HashSet<SingleInstanceFactory<?>> getEagerInstances() {
        return this.f18977c;
    }

    public final List<a> getIncludedModules() {
        return this.f18980f;
    }

    public final HashMap<String, c<?>> getMappings() {
        return this.f18978d;
    }

    public final HashSet<th.a> getScopes() {
        return this.f18979e;
    }

    public final boolean get_createdAtStart() {
        return this.f18975a;
    }

    public int hashCode() {
        return this.f18976b.hashCode();
    }

    public final void indexPrimaryType(c<?> cVar) {
        i.checkNotNullParameter(cVar, "instanceFactory");
        BeanDefinition<?> beanDefinition = cVar.getBeanDefinition();
        saveMapping(nh.a.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), cVar);
    }

    public final List<a> plus(a aVar) {
        i.checkNotNullParameter(aVar, "module");
        return k.listOf((Object[]) new a[]{this, aVar});
    }

    public final void prepareForCreationAtStart(SingleInstanceFactory<?> singleInstanceFactory) {
        i.checkNotNullParameter(singleInstanceFactory, "instanceFactory");
        this.f18977c.add(singleInstanceFactory);
    }

    public final void saveMapping(String str, c<?> cVar) {
        i.checkNotNullParameter(str, "mapping");
        i.checkNotNullParameter(cVar, "factory");
        this.f18978d.put(str, cVar);
    }

    public a(boolean z10) {
        this.f18975a = z10;
        this.f18976b = yh.b.f22543a.generateId();
        this.f18977c = new HashSet<>();
        this.f18978d = new HashMap<>();
        this.f18979e = new HashSet<>();
        this.f18980f = new ArrayList();
    }

    public /* synthetic */ a(boolean z10, int i10, f fVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
