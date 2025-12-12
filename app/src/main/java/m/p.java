package m;

import java.net.DatagramSocket;
import java.net.InetAddress;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;
import yg.b;

/* loaded from: classes2.dex */
public final class p extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public wg.i f16082b;

    /* renamed from: m, reason: collision with root package name */
    public int f16083m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ wg.i f16084n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(wg.i iVar, c cVar) {
        super(2, cVar);
        this.f16084n = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new p(this.f16084n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new p(this.f16084n, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objCoroutineScope;
        wg.i iVar;
        InetAddress inetAddress;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16083m;
        wg.i iVar2 = this.f16084n;
        try {
            if (i10 == 0) {
                f.throwOnFailure(obj);
                b bVar = iVar2.f21153e;
                String strValueOf = String.valueOf(iVar2.f21149a);
                String str = iVar2.f21150b;
                int i11 = iVar2.f21151c;
                this.f16082b = iVar2;
                this.f16083m = 1;
                bVar.getClass();
                objCoroutineScope = h0.coroutineScope(new o.e(bVar, strValueOf, str, i11, null), this);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iVar = iVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                iVar = this.f16082b;
                f.throwOnFailure(obj);
                objCoroutineScope = obj;
            }
            yg.c cVar = (yg.c) objCoroutineScope;
            iVar.getClass();
            zf.i.checkNotNullParameter(cVar, "<set-?>");
            iVar.f21178f = cVar;
            wg.c cVar2 = iVar2.f21152d;
            int i12 = iVar2.f21149a;
            yg.c cVar3 = iVar2.f21178f;
            if (cVar3 == null) {
                zf.i.throwUninitializedPropertyAccessException("connection");
                cVar3 = null;
            }
            DatagramSocket datagramSocket = cVar3.f22541a;
            byte[] address = (datagramSocket == null || (inetAddress = datagramSocket.getInetAddress()) == null) ? null : inetAddress.getAddress();
            if (address == null) {
                address = new byte[0];
            }
            byte[] bArr = address;
            yg.c cVar4 = iVar2.f21178f;
            if (cVar4 == null) {
                zf.i.throwUninitializedPropertyAccessException("connection");
                cVar4 = null;
            }
            DatagramSocket datagramSocket2 = cVar4.f22541a;
            Integer numValueOf = datagramSocket2 != null ? Integer.valueOf(datagramSocket2.getPort()) : null;
            int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
            rb.p pVar = (rb.p) cVar2;
            pVar.getClass();
            zf.i.checkNotNullParameter(bArr, "remoteIp");
            ng.g gVar = k.c.f14701a;
            k.c.a("ProxyBloc", "onConnectionSuccess: [" + i12 + "]: active sessions = " + pVar.f18918z.size());
            kg.h.launch$default(pVar.f18916x, null, null, new e.e(pVar, i12, bArr, iIntValue, null), 3, null);
            kg.h.launch$default(iVar2.f21180h, null, null, new n(iVar2, null), 3, null);
        } catch (Throwable th2) {
            rb.p pVar2 = (rb.p) iVar2.f21152d;
            pVar2.getClass();
            zf.i.checkNotNullParameter(th2, "ex");
            ng.g gVar2 = k.c.f14701a;
            StringBuilder sb2 = new StringBuilder("onConnectionError: [");
            int i13 = iVar2.f21149a;
            sb2.append(i13);
            sb2.append("]: ");
            sb2.append(th2);
            k.c.a("ProxyBloc", sb2.toString());
            kg.h.launch$default(pVar2.f18916x, null, null, new e.d(pVar2, i13, th2, null), 3, null);
        }
        return lf.h.f16056a;
    }
}
