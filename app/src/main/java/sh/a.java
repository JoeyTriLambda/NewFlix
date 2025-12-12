package sh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mf.q;
import zf.f;
import zf.i;

/* compiled from: ParametersHolder.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List<Object> f19292a;

    /* compiled from: ParametersHolder.kt */
    /* renamed from: sh.a$a, reason: collision with other inner class name */
    public static final class C0252a {
        public C0252a(f fVar) {
        }
    }

    static {
        new C0252a(null);
    }

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public <T> T getOrNull(gg.b<?> bVar) {
        T t10;
        i.checkNotNullParameter(bVar, "clazz");
        Iterator<T> it = this.f19292a.iterator();
        do {
            t10 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (bVar.isInstance(next) && next != null) {
                t10 = next;
            }
        } while (t10 == null);
        return t10;
    }

    public String toString() {
        return "DefinitionParameters" + q.toList(this.f19292a);
    }

    public a(List<Object> list) {
        i.checkNotNullParameter(list, "_values");
        this.f19292a = list;
    }

    public /* synthetic */ a(List list, int i10, f fVar) {
        this((i10 & 1) != 0 ? new ArrayList() : list);
    }
}
