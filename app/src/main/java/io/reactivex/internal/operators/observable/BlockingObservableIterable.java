package io.reactivex.internal.operators.observable;

import cf.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final o<? extends T> f13704b;

    /* renamed from: m, reason: collision with root package name */
    public final int f13705m;

    public static final class BlockingObservableIterator<T> extends AtomicReference<b> implements q<T>, Iterator<T>, b {
        private static final long serialVersionUID = 6695226475494099826L;

        /* renamed from: b, reason: collision with root package name */
        public final af.a<T> f13706b;

        /* renamed from: m, reason: collision with root package name */
        public final ReentrantLock f13707m;

        /* renamed from: n, reason: collision with root package name */
        public final Condition f13708n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f13709o;

        /* renamed from: p, reason: collision with root package name */
        public volatile Throwable f13710p;

        public BlockingObservableIterator(int i10) {
            this.f13706b = new af.a<>(i10);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f13707m = reentrantLock;
            this.f13708n = reentrantLock.newCondition();
        }

        public final void a() {
            ReentrantLock reentrantLock = this.f13707m;
            reentrantLock.lock();
            try {
                this.f13708n.signalAll();
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
            a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z10 = this.f13709o;
                boolean zIsEmpty = this.f13706b.isEmpty();
                if (z10) {
                    Throwable th2 = this.f13710p;
                    if (th2 != null) {
                        throw ExceptionHelper.wrapOrThrow(th2);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                try {
                    c.verifyNonBlocking();
                    this.f13707m.lock();
                    while (!this.f13709o && this.f13706b.isEmpty() && !isDisposed()) {
                        try {
                            this.f13708n.await();
                        } finally {
                        }
                    }
                    this.f13707m.unlock();
                } catch (InterruptedException e10) {
                    DisposableHelper.dispose(this);
                    a();
                    throw ExceptionHelper.wrapOrThrow(e10);
                }
            }
            Throwable th3 = this.f13710p;
            if (th3 == null) {
                return false;
            }
            throw ExceptionHelper.wrapOrThrow(th3);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.f13706b.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13709o = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13710p = th2;
            this.f13709o = true;
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13706b.offer(t10);
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(o<? extends T> oVar, int i10) {
        this.f13704b = oVar;
        this.f13705m = i10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f13705m);
        this.f13704b.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
