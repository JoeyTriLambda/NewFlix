package pg;

import java.util.Iterator;
import java.util.List;
import kg.w1;
import kotlin.KotlinNothingValueException;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final w1 f17730a;

    static {
        Object obj;
        w1 w1VarTryCreateDispatcher;
        c0.systemProp("kotlinx.coroutines.fast.service.loader", true);
        List list = hg.f.toList(hg.e.asSequence(o1.a.q()));
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((q) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((q) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        q qVar = (q) obj;
        if (qVar == null || (w1VarTryCreateDispatcher = s.tryCreateDispatcher(qVar, list)) == null) {
            s.throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        }
        f17730a = w1VarTryCreateDispatcher;
    }
}
