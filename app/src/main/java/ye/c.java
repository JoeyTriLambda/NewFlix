package ye;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingObservableMostRecent.java */
/* loaded from: classes2.dex */
public final class c<T> implements Iterable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final ne.o<T> f22087b;

    /* renamed from: m, reason: collision with root package name */
    public final T f22088m;

    /* compiled from: BlockingObservableMostRecent.java */
    public static final class a<T> extends ef.b<T> {

        /* renamed from: m, reason: collision with root package name */
        public volatile Object f22089m;

        /* compiled from: BlockingObservableMostRecent.java */
        /* renamed from: ye.c$a$a, reason: collision with other inner class name */
        public final class C0323a implements Iterator<T> {

            /* renamed from: b, reason: collision with root package name */
            public Object f22090b;

            public C0323a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f22090b = a.this.f22089m;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f22090b == null) {
                        this.f22090b = a.this.f22089m;
                    }
                    if (NotificationLite.isComplete(this.f22090b)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.f22090b)) {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.f22090b));
                    }
                    return (T) NotificationLite.getValue(this.f22090b);
                } finally {
                    this.f22090b = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public a(T t10) {
            this.f22089m = NotificationLite.next(t10);
        }

        public a<T>.C0323a getIterable() {
            return new C0323a();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22089m = NotificationLite.complete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22089m = NotificationLite.error(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22089m = NotificationLite.next(t10);
        }
    }

    public c(ne.o<T> oVar, T t10) {
        this.f22087b = oVar;
        this.f22088m = t10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f22088m);
        this.f22087b.subscribe(aVar);
        return aVar.getIterable();
    }
}
