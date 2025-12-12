package kg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public final class v1 extends e2 {

    /* renamed from: o, reason: collision with root package name */
    public final qf.c<lf.h> f15162o;

    public v1(CoroutineContext coroutineContext, yf.p<? super g0, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f15162o = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, this, this);
    }

    @Override // kg.r1
    public void onStart() {
        qg.a.startCoroutineCancellable(this.f15162o, this);
    }
}
