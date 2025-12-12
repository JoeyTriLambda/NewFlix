package nh;

import zf.i;

/* compiled from: BeanDefinition.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final String indexKey(gg.b<?> bVar, th.a aVar, th.a aVar2) {
        String value;
        i.checkNotNullParameter(bVar, "clazz");
        i.checkNotNullParameter(aVar2, "scopeQualifier");
        if (aVar == null || (value = aVar.getValue()) == null) {
            value = "";
        }
        return xh.a.getFullName(bVar) + ':' + value + ':' + aVar2;
    }
}
