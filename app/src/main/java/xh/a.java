package xh;

import gg.b;
import java.util.Map;
import zf.i;

/* compiled from: KClassExt.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<b<?>, String> f21803a = yh.b.f22543a.safeHashMap();

    public static final String getFullName(b<?> bVar) {
        i.checkNotNullParameter(bVar, "<this>");
        String str = f21803a.get(bVar);
        return str == null ? saveCache(bVar) : str;
    }

    public static final String saveCache(b<?> bVar) {
        i.checkNotNullParameter(bVar, "<this>");
        String className = yh.b.f22543a.getClassName(bVar);
        f21803a.put(bVar, className);
        return className;
    }
}
