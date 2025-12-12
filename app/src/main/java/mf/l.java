package mf;

import java.util.Collection;

/* compiled from: Iterables.kt */
/* loaded from: classes2.dex */
public class l extends k {
    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i10) {
        zf.i.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }
}
