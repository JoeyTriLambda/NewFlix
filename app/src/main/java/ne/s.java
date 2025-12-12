package ne;

import io.reactivex.internal.operators.single.SingleToObservable;

/* compiled from: Single.java */
/* loaded from: classes2.dex */
public abstract class s<T> implements u<T> {
    public final T blockingGet() {
        we.f fVar = new we.f();
        subscribe(fVar);
        return (T) fVar.blockingGet();
    }

    public final <R> s<R> map(se.n<? super T, ? extends R> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ze.a(this, nVar));
    }

    @Override // ne.u
    public final void subscribe(t<? super T> tVar) {
        ue.a.requireNonNull(tVar, "observer is null");
        t<? super T> tVarOnSubscribe = ff.a.onSubscribe(this, tVar);
        ue.a.requireNonNull(tVarOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(tVarOnSubscribe);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(t<? super T> tVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final k<T> toObservable() {
        return this instanceof ve.a ? ((ve.a) this).fuseToObservable() : ff.a.onAssembly(new SingleToObservable(this));
    }
}
