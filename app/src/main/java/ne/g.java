package ne;

/* compiled from: Maybe.java */
/* loaded from: classes2.dex */
public abstract class g<T> implements i<T> {
    public final T blockingGet() {
        we.f fVar = new we.f();
        subscribe(fVar);
        return (T) fVar.blockingGet();
    }

    @Override // ne.i
    public final void subscribe(h<? super T> hVar) {
        ue.a.requireNonNull(hVar, "observer is null");
        h<? super T> hVarOnSubscribe = ff.a.onSubscribe(this, hVar);
        ue.a.requireNonNull(hVarOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(hVarOnSubscribe);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(h<? super T> hVar);
}
