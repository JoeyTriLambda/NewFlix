package c8;

import java.util.ArrayList;

/* compiled from: Lists.java */
/* loaded from: classes.dex */
public final class f {
    public static <E> ArrayList<E> newArrayListWithCapacity(int i10) {
        i.a(i10, "initialArraySize");
        return new ArrayList<>(i10);
    }
}
