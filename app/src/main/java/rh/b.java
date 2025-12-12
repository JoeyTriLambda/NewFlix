package rh;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import mf.a0;
import mf.q;
import mf.z;
import org.koin.core.error.DefinitionOverrideException;
import ph.c;
import zf.i;

/* compiled from: Module.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final Set<a> flatten(List<a> list, Set<a> set) {
        i.checkNotNullParameter(list, "modules");
        i.checkNotNullParameter(set, "newModules");
        while (!list.isEmpty()) {
            a aVar = (a) q.first((List) list);
            if (aVar == null) {
                throw new IllegalStateException("Flatten - No head element in list".toString());
            }
            list = list.subList(1, list.size());
            if (aVar.getIncludedModules().isEmpty()) {
                set = a0.plus(set, aVar);
            } else {
                list = q.plus((Collection) aVar.getIncludedModules(), (Iterable) list);
                set = a0.plus(set, aVar);
            }
        }
        return set;
    }

    public static /* synthetic */ Set flatten$default(List list, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            set = z.emptySet();
        }
        return flatten(list, set);
    }

    public static final void overrideError(c<?> cVar, String str) throws DefinitionOverrideException {
        i.checkNotNullParameter(cVar, "factory");
        i.checkNotNullParameter(str, "mapping");
        throw new DefinitionOverrideException("Already existing definition for " + cVar.getBeanDefinition() + " at " + str);
    }
}
