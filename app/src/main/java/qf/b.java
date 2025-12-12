package qf;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.a;
import yf.l;
import zf.i;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public abstract class b<B extends CoroutineContext.a, E extends B> implements CoroutineContext.b<E> {

    /* renamed from: b, reason: collision with root package name */
    public final l<CoroutineContext.a, E> f18149b;

    /* renamed from: m, reason: collision with root package name */
    public final CoroutineContext.b<?> f18150m;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$b<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, yf.l<? super kotlin.coroutines.CoroutineContext$a, ? extends E extends B>, yf.l<kotlin.coroutines.CoroutineContext$a, E extends B>] */
    public b(CoroutineContext.b<B> bVar, l<? super CoroutineContext.a, ? extends E> lVar) {
        i.checkNotNullParameter(bVar, "baseKey");
        i.checkNotNullParameter(lVar, "safeCast");
        this.f18149b = lVar;
        this.f18150m = bVar instanceof b ? (CoroutineContext.b<B>) ((b) bVar).f18150m : bVar;
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.b<?> bVar) {
        i.checkNotNullParameter(bVar, "key");
        return bVar == this || this.f18150m == bVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$a;)TE; */
    public final CoroutineContext.a tryCast$kotlin_stdlib(CoroutineContext.a aVar) {
        i.checkNotNullParameter(aVar, "element");
        return (CoroutineContext.a) this.f18149b.invoke(aVar);
    }
}
