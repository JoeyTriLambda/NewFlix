package l8;

import java.util.Set;

/* compiled from: ComponentContainer.java */
/* loaded from: classes.dex */
public final /* synthetic */ class c {
    public static Object a(d dVar, Class cls) {
        return dVar.get(r.unqualified(cls));
    }

    public static Object b(d dVar, r rVar) {
        h9.b provider = dVar.getProvider(rVar);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public static h9.a c(d dVar, Class cls) {
        return dVar.getDeferred(r.unqualified(cls));
    }

    public static h9.b d(d dVar, Class cls) {
        return dVar.getProvider(r.unqualified(cls));
    }

    public static Set e(d dVar, Class cls) {
        return dVar.setOf(r.unqualified(cls));
    }

    public static Set f(d dVar, r rVar) {
        return (Set) dVar.setOfProvider(rVar).get();
    }
}
