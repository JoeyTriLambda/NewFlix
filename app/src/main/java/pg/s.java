package pg;

import java.util.List;
import kg.w1;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes2.dex */
public final class s {
    public static final boolean isMissing(w1 w1Var) {
        return w1Var.getImmediate() instanceof t;
    }

    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final w1 tryCreateDispatcher(q qVar, List<? extends q> list) {
        try {
            return qVar.createDispatcher(list);
        } catch (Throwable unused) {
            qVar.hintOnError();
            return null;
        }
    }
}
