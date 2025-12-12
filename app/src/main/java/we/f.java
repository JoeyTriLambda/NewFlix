package we;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import ne.t;

/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes2.dex */
public final class f<T> extends CountDownLatch implements t<T>, ne.b, ne.h<T> {

    /* renamed from: b, reason: collision with root package name */
    public T f21133b;

    /* renamed from: m, reason: collision with root package name */
    public Throwable f21134m;

    /* renamed from: n, reason: collision with root package name */
    public qe.b f21135n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f21136o;

    public f() {
        super(1);
    }

    public T blockingGet() throws InterruptedException {
        if (getCount() != 0) {
            try {
                cf.c.verifyNonBlocking();
                await();
            } catch (InterruptedException e10) {
                this.f21136o = true;
                qe.b bVar = this.f21135n;
                if (bVar != null) {
                    bVar.dispose();
                }
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        Throwable th2 = this.f21134m;
        if (th2 == null) {
            return this.f21133b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    @Override // ne.b
    public void onComplete() {
        countDown();
    }

    @Override // ne.t
    public void onError(Throwable th2) {
        this.f21134m = th2;
        countDown();
    }

    @Override // ne.t
    public void onSubscribe(qe.b bVar) {
        this.f21135n = bVar;
        if (this.f21136o) {
            bVar.dispose();
        }
    }

    @Override // ne.t
    public void onSuccess(T t10) {
        this.f21133b = t10;
        countDown();
    }
}
