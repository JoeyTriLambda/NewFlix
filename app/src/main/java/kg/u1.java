package kg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public final class u1<T> extends l0<T> {

    /* renamed from: o, reason: collision with root package name */
    public final qf.c<lf.h> f15160o;

    public u1(CoroutineContext coroutineContext, yf.p<? super g0, ? super qf.c<? super T>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f15160o = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, this, this);
    }

    @Override // kg.r1
    public void onStart() {
        qg.a.startCoroutineCancellable(this.f15160o, this);
    }
}
