package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: BufferedChannel.kt */
@d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk")
/* loaded from: classes2.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15336b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel<E> f15337m;

    /* renamed from: n, reason: collision with root package name */
    public int f15338n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, c<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> cVar) {
        super(cVar);
        this.f15337m = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f15336b = obj;
        this.f15338n |= Integer.MIN_VALUE;
        Object objL = this.f15337m.l(null, 0, 0L, this);
        return objL == rf.a.getCOROUTINE_SUSPENDED() ? objL : a.m71boximpl(objL);
    }
}
