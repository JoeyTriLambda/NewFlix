package pg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* loaded from: classes2.dex */
public abstract class b<T> extends u {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17689a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f17688a;

    public abstract void complete(T t10, Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pg.u
    public final Object perform(Object obj) {
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17689a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        b0 b0Var = a.f17688a;
        if (obj2 == b0Var) {
            Object objPrepare = prepare(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == b0Var) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, objPrepare)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != b0Var) {
                        z10 = false;
                        break;
                    }
                }
                obj2 = z10 ? objPrepare : atomicReferenceFieldUpdater.get(this);
            }
        }
        complete(obj, obj2);
        return obj2;
    }

    public abstract Object prepare(T t10);
}
