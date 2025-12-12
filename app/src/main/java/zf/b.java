package zf;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final <T> Iterator<T> iterator(T[] tArr) {
        i.checkNotNullParameter(tArr, "array");
        return new a(tArr);
    }
}
