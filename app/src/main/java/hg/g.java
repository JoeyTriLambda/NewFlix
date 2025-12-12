package hg;

import java.util.Iterator;
import yf.l;
import zf.i;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class g<T, R> implements d<R> {

    /* renamed from: a, reason: collision with root package name */
    public final d<T> f13079a;

    /* renamed from: b, reason: collision with root package name */
    public final l<T, R> f13080b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<R>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<T> f13081b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ g<T, R> f13082m;

        public a(g<T, R> gVar) {
            this.f13082m = gVar;
            this.f13081b = gVar.f13079a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13081b.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f13082m.f13080b.invoke(this.f13081b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(d<? extends T> dVar, l<? super T, ? extends R> lVar) {
        i.checkNotNullParameter(dVar, "sequence");
        i.checkNotNullParameter(lVar, "transformer");
        this.f13079a = dVar;
        this.f13080b = lVar;
    }

    @Override // hg.d
    public Iterator<R> iterator() {
        return new a(this);
    }
}
