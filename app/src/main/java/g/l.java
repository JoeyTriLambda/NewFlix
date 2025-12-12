package g;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;

/* loaded from: classes2.dex */
public final class l extends Lambda implements yf.l {

    /* renamed from: b, reason: collision with root package name */
    public static final l f12497b = new l();

    public l() {
        super(1);
    }

    @Override // yf.l
    public final Object invoke(Object obj) {
        rh.a aVar = (rh.a) obj;
        zf.i.checkNotNullParameter(aVar, "$this$module");
        k kVar = new k();
        SingleInstanceFactory<?> singleInstanceFactoryY = ac.c.y(new BeanDefinition(uh.c.f20383e.getRootScopeQualifier(), zf.k.getOrCreateKotlinClass(vg.a.class), null, kVar, Kind.Singleton, mf.k.emptyList()), aVar);
        if (aVar.get_createdAtStart()) {
            aVar.prepareForCreationAtStart(singleInstanceFactoryY);
        }
        new Pair(aVar, singleInstanceFactoryY);
        return lf.h.f16056a;
    }
}
