package o9;

import android.content.Context;
import l8.l;

/* compiled from: LibraryVersionComponent.java */
/* loaded from: classes.dex */
public final class g {

    /* compiled from: LibraryVersionComponent.java */
    public interface a<T> {
    }

    public static l8.b<?> create(String str, String str2) {
        return l8.b.intoSet(new o9.a(str, str2), e.class);
    }

    public static l8.b<?> fromContext(String str, a<Context> aVar) {
        return l8.b.intoSetBuilder(e.class).add(l.required((Class<?>) Context.class)).factory(new f(str, 0, aVar)).build();
    }
}
