package v4;

/* compiled from: Retries.java */
/* loaded from: classes.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult retry(int i10, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) throws Throwable {
        TResult tresult;
        if (i10 < 1) {
            return (TResult) ((c1.c) aVar).apply(tinput);
        }
        do {
            tresult = (TResult) ((c1.c) aVar).apply(tinput);
            tinput = (TInput) ((pd.a) cVar).f(tinput, tresult);
            if (tinput == null) {
                break;
            }
            i10--;
        } while (i10 >= 1);
        return tresult;
    }
}
