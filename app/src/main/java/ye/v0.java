package ye;

/* compiled from: ObservableLift.java */
/* loaded from: classes2.dex */
public final class v0<R, T> extends a<T, R> {
    public v0(ne.o<T> oVar, ne.n<? extends R, ? super T> nVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super R> qVar) {
        try {
            throw null;
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            ff.a.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
