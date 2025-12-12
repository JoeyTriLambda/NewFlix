package ye;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObservableLatest.java */
/* loaded from: classes2.dex */
public final class b<T> implements Iterable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final ne.o<T> f22069b;

    /* compiled from: BlockingObservableLatest.java */
    public static final class a<T> extends ef.c<ne.j<T>> implements Iterator<T> {

        /* renamed from: m, reason: collision with root package name */
        public ne.j<T> f22070m;

        /* renamed from: n, reason: collision with root package name */
        public final Semaphore f22071n = new Semaphore(0);

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReference<ne.j<T>> f22072o = new AtomicReference<>();

        @Override // java.util.Iterator
        public boolean hasNext() throws InterruptedException {
            ne.j<T> jVar = this.f22070m;
            if (jVar != null && jVar.isOnError()) {
                throw ExceptionHelper.wrapOrThrow(this.f22070m.getError());
            }
            if (this.f22070m == null) {
                try {
                    cf.c.verifyNonBlocking();
                    this.f22071n.acquire();
                    ne.j<T> andSet = this.f22072o.getAndSet(null);
                    this.f22070m = andSet;
                    if (andSet.isOnError()) {
                        throw ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (InterruptedException e10) {
                    dispose();
                    this.f22070m = ne.j.createOnError(e10);
                    throw ExceptionHelper.wrapOrThrow(e10);
                }
            }
            return this.f22070m.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = this.f22070m.getValue();
            this.f22070m = null;
            return value;
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ff.a.onError(th2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // ne.q
        public void onNext(ne.j<T> jVar) {
            if (this.f22072o.getAndSet(jVar) == null) {
                this.f22071n.release();
            }
        }

        @Override // ne.q
        public void onComplete() {
        }
    }

    public b(ne.o<T> oVar) {
        this.f22069b = oVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        ne.k.wrap(this.f22069b).materialize().subscribe(aVar);
        return aVar;
    }
}
