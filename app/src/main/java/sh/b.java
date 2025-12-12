package sh;

import zf.i;

/* compiled from: ParametersHolder.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final a emptyParametersHolder() {
        return new a(null, 1, null);
    }

    public static final a parametersOf(Object... objArr) {
        i.checkNotNullParameter(objArr, "parameters");
        return new a(mf.i.toMutableList(objArr));
    }
}
