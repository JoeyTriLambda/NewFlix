package qf;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import zf.i;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes2.dex */
public interface d extends CoroutineContext.a {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f18151l = 0;

    /* compiled from: ContinuationInterceptor.kt */
    public static final class a {
        public static <E extends CoroutineContext.a> E get(d dVar, CoroutineContext.b<E> bVar) {
            i.checkNotNullParameter(bVar, "key");
            if (!(bVar instanceof qf.b)) {
                int i10 = d.f18151l;
                if (b.f18152b != bVar) {
                    return null;
                }
                i.checkNotNull(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return dVar;
            }
            qf.b bVar2 = (qf.b) bVar;
            if (!bVar2.isSubKey$kotlin_stdlib(dVar.getKey())) {
                return null;
            }
            E e10 = (E) bVar2.tryCast$kotlin_stdlib(dVar);
            if (e10 instanceof CoroutineContext.a) {
                return e10;
            }
            return null;
        }

        public static CoroutineContext minusKey(d dVar, CoroutineContext.b<?> bVar) {
            i.checkNotNullParameter(bVar, "key");
            if (bVar instanceof qf.b) {
                qf.b bVar2 = (qf.b) bVar;
                return (!bVar2.isSubKey$kotlin_stdlib(dVar.getKey()) || bVar2.tryCast$kotlin_stdlib(dVar) == null) ? dVar : EmptyCoroutineContext.f15239b;
            }
            int i10 = d.f18151l;
            return b.f18152b == bVar ? EmptyCoroutineContext.f15239b : dVar;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    public static final class b implements CoroutineContext.b<d> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ b f18152b = new b();
    }

    <T> c<T> interceptContinuation(c<? super T> cVar);

    void releaseInterceptedContinuation(c<?> cVar);
}
