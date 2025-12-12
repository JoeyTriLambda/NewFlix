package lf;

import kotlin.Result;
import zf.i;

/* compiled from: Result.kt */
/* loaded from: classes2.dex */
public final class f {
    public static final Object createFailure(Throwable th2) {
        i.checkNotNullParameter(th2, "exception");
        return new Result.Failure(th2);
    }

    public static final void throwOnFailure(Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).f15191b;
        }
    }
}
