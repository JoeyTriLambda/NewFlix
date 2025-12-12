package ne;

/* compiled from: Completable.java */
/* loaded from: classes2.dex */
public abstract class a implements c {
    @Override // ne.c
    public final void subscribe(b bVar) {
        ue.a.requireNonNull(bVar, "observer is null");
        try {
            b bVarOnSubscribe = ff.a.onSubscribe(this, bVar);
            ue.a.requireNonNull(bVarOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(bVarOnSubscribe);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            ff.a.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void subscribeActual(b bVar);
}
