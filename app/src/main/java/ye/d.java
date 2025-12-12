package ye;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BlockingObservableNext.java */
/* loaded from: classes2.dex */
public final class d<T> implements Iterable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final ne.o<T> f22099b;

    /* compiled from: BlockingObservableNext.java */
    public static final class a<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public final b<T> f22100b;

        /* renamed from: m, reason: collision with root package name */
        public final ne.o<T> f22101m;

        /* renamed from: n, reason: collision with root package name */
        public T f22102n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22103o = true;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22104p = true;

        /* renamed from: q, reason: collision with root package name */
        public Throwable f22105q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f22106r;

        public a(ne.o<T> oVar, b<T> bVar) {
            this.f22101m = oVar;
            this.f22100b = bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z10;
            Throwable th2 = this.f22105q;
            if (th2 != null) {
                throw ExceptionHelper.wrapOrThrow(th2);
            }
            if (!this.f22103o) {
                return false;
            }
            if (this.f22104p) {
                boolean z11 = this.f22106r;
                b<T> bVar = this.f22100b;
                if (!z11) {
                    this.f22106r = true;
                    bVar.f22108n.set(1);
                    new y0(this.f22101m).subscribe(bVar);
                }
                try {
                    ne.j<T> jVarTakeNext = bVar.takeNext();
                    if (jVarTakeNext.isOnNext()) {
                        this.f22104p = false;
                        this.f22102n = jVarTakeNext.getValue();
                        z10 = true;
                    } else {
                        this.f22103o = false;
                        if (!jVarTakeNext.isOnComplete()) {
                            Throwable error = jVarTakeNext.getError();
                            this.f22105q = error;
                            throw ExceptionHelper.wrapOrThrow(error);
                        }
                        z10 = false;
                    }
                    if (!z10) {
                        return false;
                    }
                } catch (InterruptedException e10) {
                    bVar.dispose();
                    this.f22105q = e10;
                    throw ExceptionHelper.wrapOrThrow(e10);
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th2 = this.f22105q;
            if (th2 != null) {
                throw ExceptionHelper.wrapOrThrow(th2);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f22104p = true;
            return this.f22102n;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* compiled from: BlockingObservableNext.java */
    public static final class b<T> extends ef.c<ne.j<T>> {

        /* renamed from: m, reason: collision with root package name */
        public final ArrayBlockingQueue f22107m = new ArrayBlockingQueue(1);

        /* renamed from: n, reason: collision with root package name */
        public final AtomicInteger f22108n = new AtomicInteger();

        @Override // ne.q
        public void onError(Throwable th2) {
            ff.a.onError(th2);
        }

        public ne.j<T> takeNext() throws InterruptedException {
            this.f22108n.set(1);
            cf.c.verifyNonBlocking();
            return (ne.j) this.f22107m.take();
        }

        @Override // ne.q
        public void onNext(ne.j<T> jVar) {
            if (this.f22108n.getAndSet(0) != 1 && jVar.isOnNext()) {
                return;
            }
            while (true) {
                ArrayBlockingQueue arrayBlockingQueue = this.f22107m;
                if (arrayBlockingQueue.offer(jVar)) {
                    return;
                }
                ne.j<T> jVar2 = (ne.j) arrayBlockingQueue.poll();
                if (jVar2 != null && !jVar2.isOnNext()) {
                    jVar = jVar2;
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
        }
    }

    public d(ne.o<T> oVar) {
        this.f22099b = oVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f22099b, new b());
    }
}
