package g;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import l3.w;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;
import uh.c;

/* loaded from: classes2.dex */
public final class e extends Lambda implements yf.l {

    /* renamed from: b, reason: collision with root package name */
    public static final e f12494b = new e();

    public e() {
        super(1);
    }

    @Override // yf.l
    public final Object invoke(Object obj) {
        rh.a aVar = (rh.a) obj;
        zf.i.checkNotNullParameter(aVar, "$this$module");
        a aVar2 = new a();
        c.a aVar3 = uh.c.f20383e;
        th.c rootScopeQualifier = aVar3.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory<?> singleInstanceFactoryY = ac.c.y(new BeanDefinition(rootScopeQualifier, zf.k.getOrCreateKotlinClass(qb.h.class), null, aVar2, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY);
        }
        new Pair(aVar, singleInstanceFactoryY);
        b bVar = new b();
        SingleInstanceFactory<?> singleInstanceFactoryY2 = ac.c.y(new BeanDefinition(aVar3.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(w.class), null, bVar, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY2);
        }
        new Pair(aVar, singleInstanceFactoryY2);
        c cVar = new c();
        SingleInstanceFactory<?> singleInstanceFactoryY3 = ac.c.y(new BeanDefinition(aVar3.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(sb.p.class), null, cVar, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY3);
        }
        new Pair(aVar, singleInstanceFactoryY3);
        d dVar = new d();
        SingleInstanceFactory<?> singleInstanceFactoryY4 = ac.c.y(new BeanDefinition(aVar3.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(rb.p.class), null, dVar, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY4);
        }
        new Pair(aVar, singleInstanceFactoryY4);
        return lf.h.f16056a;
    }
}
