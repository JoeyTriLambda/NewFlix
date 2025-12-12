package o;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import yf.p;
import yg.c;

/* loaded from: classes2.dex */
public final class d extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f16837b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f16838m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f16839n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, String str, int i10, qf.c cVar2) {
        super(2, cVar2);
        this.f16837b = cVar;
        this.f16838m = str;
        this.f16839n = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new d(this.f16837b, this.f16838m, this.f16839n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((d) create((g0) obj, (qf.c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        lf.f.throwOnFailure(obj);
        int i10 = this.f16839n;
        c cVar = this.f16837b;
        cVar.getClass();
        String str = this.f16838m;
        zf.i.checkNotNullParameter(str, "host");
        if (cVar.f22541a == null) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                cVar.f22541a = datagramSocket;
                zf.i.checkNotNull(datagramSocket);
                datagramSocket.connect(new InetSocketAddress(str, i10));
            } catch (Throwable th2) {
                cVar.f22541a = null;
                throw th2;
            }
        }
        return lf.h.f16056a;
    }
}
