package ng;

import kg.g0;
import kg.k1;
import kotlinx.coroutines.flow.FlowKt__CollectKt;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt;
import yf.p;
import yf.q;
import yf.r;

/* loaded from: classes2.dex */
public final class c {
    /* renamed from: catch, reason: not valid java name */
    public static final <T> a<T> m88catch(a<? extends T> aVar, q<? super b<? super T>, ? super Throwable, ? super qf.c<? super lf.h>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.m84catch(aVar, qVar);
    }

    public static final <T> Object catchImpl(a<? extends T> aVar, b<? super T> bVar, qf.c<? super Throwable> cVar) {
        return FlowKt__ErrorsKt.catchImpl(aVar, bVar, cVar);
    }

    public static final Object collect(a<?> aVar, qf.c<? super lf.h> cVar) {
        return FlowKt__CollectKt.collect(aVar, cVar);
    }

    public static final <T1, T2, T3, R> a<R> combine(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, r<? super T1, ? super T2, ? super T3, ? super qf.c<? super R>, ? extends Object> rVar) {
        return FlowKt__ZipKt.combine(aVar, aVar2, aVar3, rVar);
    }

    public static final <T> a<T> distinctUntilChanged(a<? extends T> aVar) {
        return FlowKt__DistinctKt.distinctUntilChanged(aVar);
    }

    public static final <T> a<T> drop(a<? extends T> aVar, int i10) {
        return FlowKt__LimitKt.drop(aVar, i10);
    }

    public static final <T> a<T> dropWhile(a<? extends T> aVar, p<? super T, ? super qf.c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.dropWhile(aVar, pVar);
    }

    public static final <T> Object emitAll(b<? super T> bVar, a<? extends T> aVar, qf.c<? super lf.h> cVar) {
        return FlowKt__CollectKt.emitAll(bVar, aVar, cVar);
    }

    public static final void ensureActive(b<?> bVar) {
        e.ensureActive(bVar);
    }

    public static final <T> a<T> filterNotNull(a<? extends T> aVar) {
        return FlowKt__TransformKt.filterNotNull(aVar);
    }

    public static final <T> Object first(a<? extends T> aVar, qf.c<? super T> cVar) {
        return FlowKt__ReduceKt.first(aVar, cVar);
    }

    public static final <T> a<T> flow(p<? super b<? super T>, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        return d.flow(pVar);
    }

    public static final <T> k1 launchIn(a<? extends T> aVar, g0 g0Var) {
        return FlowKt__CollectKt.launchIn(aVar, g0Var);
    }

    public static final <T> a<T> onEach(a<? extends T> aVar, p<? super T, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        return FlowKt__TransformKt.onEach(aVar, pVar);
    }

    public static final <T1, T2, R> a<R> zip(a<? extends T1> aVar, a<? extends T2> aVar2, q<? super T1, ? super T2, ? super qf.c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.zip(aVar, aVar2, qVar);
    }
}
