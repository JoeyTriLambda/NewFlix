package g;

import de.f;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;
import uh.c;
import xg.d0;

/* loaded from: classes2.dex */
public final class r extends Lambda implements yf.l {

    /* renamed from: b, reason: collision with root package name */
    public static final r f12499b = new r();

    public r() {
        super(1);
    }

    @Override // yf.l
    public final Object invoke(Object obj) {
        rh.a aVar = (rh.a) obj;
        zf.i.checkNotNullParameter(aVar, "$this$module");
        o oVar = new o();
        c.a aVar2 = uh.c.f20383e;
        th.c rootScopeQualifier = aVar2.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        SingleInstanceFactory<?> singleInstanceFactoryY = ac.c.y(new BeanDefinition(rootScopeQualifier, zf.k.getOrCreateKotlinClass(f.class), null, oVar, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY);
        }
        new Pair(aVar, singleInstanceFactoryY);
        p pVar = new p();
        SingleInstanceFactory<?> singleInstanceFactoryY2 = ac.c.y(new BeanDefinition(aVar2.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(d0.class), null, pVar, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY2);
        }
        new Pair(aVar, singleInstanceFactoryY2);
        q qVar = new q();
        SingleInstanceFactory<?> singleInstanceFactoryY3 = ac.c.y(new BeanDefinition(aVar2.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(wg.b.class), null, qVar, kind, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY3);
        }
        new Pair(aVar, singleInstanceFactoryY3);
        return lf.h.f16056a;
    }
}
