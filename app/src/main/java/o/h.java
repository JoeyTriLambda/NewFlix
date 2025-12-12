package o;

import java.net.DatagramSocket;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import yf.p;
import yg.c;

/* loaded from: classes2.dex */
public final class h extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f16854b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c cVar, qf.c cVar2) {
        super(2, cVar2);
        this.f16854b = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new h(this.f16854b, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new h(this.f16854b, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        c cVar = this.f16854b;
        DatagramSocket datagramSocket = cVar.f22541a;
        if (datagramSocket != null) {
            if (!datagramSocket.isClosed()) {
                datagramSocket.close();
            }
            cVar.f22541a = null;
        }
        return lf.h.f16056a;
    }
}
