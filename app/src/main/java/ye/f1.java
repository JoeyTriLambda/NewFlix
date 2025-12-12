package ye;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import ye.e1;

/* compiled from: ObservableReduceWithSingle.java */
/* loaded from: classes2.dex */
public final class f1<T, R> extends ne.s<R> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22145a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable<R> f22146b;

    /* renamed from: c, reason: collision with root package name */
    public final se.c<R, ? super T, R> f22147c;

    public f1(ne.o<T> oVar, Callable<R> callable, se.c<R, ? super T, R> cVar) {
        this.f22145a = oVar;
        this.f22146b = callable;
        this.f22147c = cVar;
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super R> tVar) {
        try {
            this.f22145a.subscribe(new e1.a(tVar, this.f22147c, ue.a.requireNonNull(this.f22146b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, tVar);
        }
    }
}
