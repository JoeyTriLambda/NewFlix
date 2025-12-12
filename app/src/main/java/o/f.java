package o;

import java.net.Socket;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import qf.c;
import yf.p;

/* loaded from: classes2.dex */
public final class f extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yg.a f16848b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(yg.a aVar, c cVar) {
        super(2, cVar);
        this.f16848b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new f(this.f16848b, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new f(this.f16848b, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        yg.a aVar = this.f16848b;
        Socket socket = aVar.f22538b;
        if (socket != null) {
            if (!socket.isClosed()) {
                socket.close();
            }
            aVar.f22538b = null;
        }
        return lf.h.f16056a;
    }
}
