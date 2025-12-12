package we;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;

/* compiled from: FutureObserver.java */
/* loaded from: classes2.dex */
public final class h<T> extends CountDownLatch implements q<T>, Future<T>, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public T f21141b;

    /* renamed from: m, reason: collision with root package name */
    public Throwable f21142m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReference<qe.b> f21143n;

    public h() {
        super(1);
        this.f21143n = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        qe.b bVar;
        boolean z11;
        DisposableHelper disposableHelper;
        do {
            AtomicReference<qe.b> atomicReference = this.f21143n;
            bVar = atomicReference.get();
            z11 = false;
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.f13533b)) {
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(bVar, disposableHelper)) {
                    z11 = true;
                    break;
                }
                if (atomicReference.get() != bVar) {
                    break;
                }
            }
        } while (!z11);
        if (bVar != null) {
            bVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            cf.c.verifyNonBlocking();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th2 = this.f21142m;
        if (th2 == null) {
            return this.f21141b;
        }
        throw new ExecutionException(th2);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f21143n.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // ne.q
    public void onComplete() {
        boolean z10;
        if (this.f21141b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            AtomicReference<qe.b> atomicReference = this.f21143n;
            qe.b bVar = atomicReference.get();
            if (bVar == this || bVar == DisposableHelper.f13533b) {
                return;
            }
            while (true) {
                if (atomicReference.compareAndSet(bVar, this)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != bVar) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        countDown();
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        boolean z10;
        if (this.f21142m != null) {
            ff.a.onError(th2);
            return;
        }
        this.f21142m = th2;
        do {
            AtomicReference<qe.b> atomicReference = this.f21143n;
            qe.b bVar = atomicReference.get();
            if (bVar == this || bVar == DisposableHelper.f13533b) {
                ff.a.onError(th2);
                return;
            }
            while (true) {
                if (atomicReference.compareAndSet(bVar, this)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != bVar) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        countDown();
    }

    @Override // ne.q
    public void onNext(T t10) {
        if (this.f21141b == null) {
            this.f21141b = t10;
        } else {
            this.f21143n.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        DisposableHelper.setOnce(this.f21143n, bVar);
    }

    @Override // java.util.concurrent.Future
    public T get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            cf.c.verifyNonBlocking();
            if (!await(j10, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j10, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f21142m;
            if (th2 == null) {
                return this.f21141b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    @Override // qe.b
    public void dispose() {
    }
}
