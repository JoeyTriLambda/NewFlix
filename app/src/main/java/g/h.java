package g;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;

/* loaded from: classes2.dex */
public final class h extends Lambda implements yf.l {

    /* renamed from: b, reason: collision with root package name */
    public static final h f12495b = new h();

    public h() {
        super(1);
    }

    @Override // yf.l
    public final Object invoke(Object obj) {
        rh.a aVar = (rh.a) obj;
        zf.i.checkNotNullParameter(aVar, "$this$module");
        g gVar = new g();
        SingleInstanceFactory<?> singleInstanceFactoryY = ac.c.y(new BeanDefinition(uh.c.f20383e.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(p000if.b.class), null, gVar, Kind.Singleton, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY);
        }
        new Pair(aVar, singleInstanceFactoryY);
        return lf.h.f16056a;
    }
}
