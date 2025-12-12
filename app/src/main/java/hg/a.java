package hg;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import zf.i;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes2.dex */
public final class a<T> implements d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<d<T>> f13072a;

    public a(d<? extends T> dVar) {
        i.checkNotNullParameter(dVar, "sequence");
        this.f13072a = new AtomicReference<>(dVar);
    }

    @Override // hg.d
    public Iterator<T> iterator() {
        d<T> andSet = this.f13072a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
