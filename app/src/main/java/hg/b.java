package hg;

import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;
import zf.i;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class b<T> implements d<T>, c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final d<T> f13073a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13074b;

    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<T>, ag.a {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<T> f13075b;

        /* renamed from: m, reason: collision with root package name */
        public int f13076m;

        public a(b<T> bVar) {
            this.f13075b = bVar.f13073a.iterator();
            this.f13076m = bVar.f13074b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator<T> it;
            while (true) {
                int i10 = this.f13076m;
                it = this.f13075b;
                if (i10 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f13076m--;
            }
            return it.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            Iterator<T> it;
            while (true) {
                int i10 = this.f13076m;
                it = this.f13075b;
                if (i10 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f13076m--;
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d<? extends T> dVar, int i10) {
        i.checkNotNullParameter(dVar, "sequence");
        this.f13073a = dVar;
        this.f13074b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
    }

    @Override // hg.c
    public d<T> drop(int i10) {
        int i11 = this.f13074b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f13073a, i11);
    }

    @Override // hg.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
