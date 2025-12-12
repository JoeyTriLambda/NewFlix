package wh;

import java.util.Collection;
import mf.q;
import nh.c;
import org.koin.core.definition.BeanDefinition;
import zf.i;

/* compiled from: DefinitionBinding.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final c<?> binds(c<?> cVar, gg.b<?>[] bVarArr) {
        i.checkNotNullParameter(cVar, "<this>");
        i.checkNotNullParameter(bVarArr, "classes");
        BeanDefinition<?> beanDefinition = cVar.getFactory().getBeanDefinition();
        beanDefinition.setSecondaryTypes(q.plus((Collection) beanDefinition.getSecondaryTypes(), (Object[]) bVarArr));
        for (gg.b<?> bVar : bVarArr) {
            cVar.getModule().saveMapping(nh.a.indexKey(bVar, cVar.getFactory().getBeanDefinition().getQualifier(), cVar.getFactory().getBeanDefinition().getScopeQualifier()), cVar.getFactory());
        }
        return cVar;
    }
}
