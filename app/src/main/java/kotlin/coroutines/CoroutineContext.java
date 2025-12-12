package kotlin.coroutines;

import qf.d;
import yf.p;
import zf.i;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            i.checkNotNullParameter(coroutineContext2, "context");
            return coroutineContext2 == EmptyCoroutineContext.f15239b ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, new p<CoroutineContext, a, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext.plus.1
                @Override // yf.p
                public final CoroutineContext invoke(CoroutineContext coroutineContext3, a aVar) {
                    CombinedContext combinedContext;
                    i.checkNotNullParameter(coroutineContext3, "acc");
                    i.checkNotNullParameter(aVar, "element");
                    CoroutineContext coroutineContextMinusKey = coroutineContext3.minusKey(aVar.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f15239b;
                    if (coroutineContextMinusKey == emptyCoroutineContext) {
                        return aVar;
                    }
                    int i10 = d.f18151l;
                    d.b bVar = d.b.f18152b;
                    d dVar = (d) coroutineContextMinusKey.get(bVar);
                    if (dVar == null) {
                        combinedContext = new CombinedContext(coroutineContextMinusKey, aVar);
                    } else {
                        CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar);
                        if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(aVar, dVar);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, aVar), dVar);
                    }
                    return combinedContext;
                }
            });
        }
    }

    /* compiled from: CoroutineContext.kt */
    public interface a extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        public static final class C0180a {
            public static <R> R fold(a aVar, R r10, p<? super R, ? super a, ? extends R> pVar) {
                i.checkNotNullParameter(pVar, "operation");
                return pVar.invoke(r10, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends a> E get(a aVar, b<E> bVar) {
                i.checkNotNullParameter(bVar, "key");
                if (!i.areEqual(aVar.getKey(), bVar)) {
                    return null;
                }
                i.checkNotNull(aVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return aVar;
            }

            public static CoroutineContext minusKey(a aVar, b<?> bVar) {
                i.checkNotNullParameter(bVar, "key");
                return i.areEqual(aVar.getKey(), bVar) ? EmptyCoroutineContext.f15239b : aVar;
            }

            public static CoroutineContext plus(a aVar, CoroutineContext coroutineContext) {
                i.checkNotNullParameter(coroutineContext, "context");
                return DefaultImpls.plus(aVar, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends a> E get(b<E> bVar);

        b<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    public interface b<E extends a> {
    }

    <R> R fold(R r10, p<? super R, ? super a, ? extends R> pVar);

    <E extends a> E get(b<E> bVar);

    CoroutineContext minusKey(b<?> bVar);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
