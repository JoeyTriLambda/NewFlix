package kotlin;

import lf.e;
import zf.f;
import zf.i;

/* compiled from: LazyJVM.kt */
/* loaded from: classes2.dex */
public class a {
    public static final <T> e<T> lazy(yf.a<? extends T> aVar) {
        i.checkNotNullParameter(aVar, "initializer");
        f fVar = null;
        return new SynchronizedLazyImpl(aVar, fVar, 2, fVar);
    }

    public static final <T> e<T> lazy(LazyThreadSafetyMode lazyThreadSafetyMode, yf.a<? extends T> aVar) {
        i.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        i.checkNotNullParameter(aVar, "initializer");
        int iOrdinal = lazyThreadSafetyMode.ordinal();
        int i10 = 2;
        if (iOrdinal == 0) {
            f fVar = null;
            return new SynchronizedLazyImpl(aVar, fVar, i10, fVar);
        }
        if (iOrdinal == 1) {
            return new SafePublicationLazyImpl(aVar);
        }
        if (iOrdinal == 2) {
            return new UnsafeLazyImpl(aVar);
        }
        throw new NoWhenBranchMatchedException();
    }
}
