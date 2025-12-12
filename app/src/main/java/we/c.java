package we;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import ne.q;

/* compiled from: BlockingBaseObserver.java */
/* loaded from: classes2.dex */
public abstract class c<T> extends CountDownLatch implements q<T>, qe.b {

    /* renamed from: b, reason: collision with root package name */
    public T f21129b;

    /* renamed from: m, reason: collision with root package name */
    public Throwable f21130m;

    /* renamed from: n, reason: collision with root package name */
    public qe.b f21131n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f21132o;

    public c() {
        super(1);
    }

    public final T blockingGet() throws InterruptedException {
        if (getCount() != 0) {
            try {
                cf.c.verifyNonBlocking();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e10);
            }
        }
        Throwable th2 = this.f21130m;
        if (th2 == null) {
            return this.f21129b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    @Override // qe.b
    public final void dispose() {
        this.f21132o = true;
        qe.b bVar = this.f21131n;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // ne.q
    public final void onComplete() {
        countDown();
    }

    @Override // ne.q
    public final void onSubscribe(qe.b bVar) {
        this.f21131n = bVar;
        if (this.f21132o) {
            bVar.dispose();
        }
    }
}
