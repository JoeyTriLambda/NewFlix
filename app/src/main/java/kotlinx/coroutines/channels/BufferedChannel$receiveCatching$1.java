package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qf.c;
import sf.d;

/* compiled from: BufferedChannel.kt */
@d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl")
/* loaded from: classes2.dex */
public final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f15333b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel<E> f15334m;

    /* renamed from: n, reason: collision with root package name */
    public int f15335n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, c<? super BufferedChannel$receiveCatching$1> cVar) {
        super(cVar);
        this.f15334m = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f15333b = obj;
        this.f15335n |= Integer.MIN_VALUE;
        Object objK = BufferedChannel.k(this.f15334m, this);
        return objK == rf.a.getCOROUTINE_SUSPENDED() ? objK : a.m71boximpl(objK);
    }
}
