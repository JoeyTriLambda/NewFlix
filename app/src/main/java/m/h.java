package m;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Map;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import o.m;
import qf.c;
import rf.a;
import yg.b;

/* loaded from: classes2.dex */
public final class h extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public wg.e f16070b;

    /* renamed from: m, reason: collision with root package name */
    public int f16071m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ wg.e f16072n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(wg.e eVar, c cVar) {
        super(2, cVar);
        this.f16072n = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new h(this.f16072n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new h(this.f16072n, (c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objCoroutineScope;
        wg.e eVar;
        String str;
        String str2;
        InetAddress inetAddress;
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.f16071m;
        wg.e eVar2 = this.f16072n;
        try {
            if (i10 == 0) {
                f.throwOnFailure(obj);
                if (eVar2.c()) {
                    int i11 = eVar2.f21149a;
                    Map map = eVar2.f21157f;
                    Long lValueOf = (map == null || (str2 = (String) map.get("wnd")) == null) ? null : Long.valueOf(Long.parseLong(str2));
                    zf.i.checkNotNull(lValueOf);
                    long jLongValue = lValueOf.longValue();
                    Map map2 = eVar2.f21157f;
                    eVar2.f21158g = new wg.g(i11, jLongValue, (map2 == null || (str = (String) map2.get("wndi")) == null) ? 200 : Integer.parseInt(str), new g(eVar2));
                }
                b bVar = eVar2.f21153e;
                String strValueOf = String.valueOf(eVar2.f21149a);
                String str3 = eVar2.f21150b;
                int i12 = eVar2.f21151c;
                this.f16070b = eVar2;
                this.f16071m = 1;
                bVar.getClass();
                objCoroutineScope = h0.coroutineScope(new m(bVar, strValueOf, str3, i12, null), this);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eVar = eVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eVar = this.f16070b;
                f.throwOnFailure(obj);
                objCoroutineScope = obj;
            }
            yg.a aVar = (yg.a) objCoroutineScope;
            eVar.getClass();
            zf.i.checkNotNullParameter(aVar, "<set-?>");
            eVar.f21162k = aVar;
            wg.c cVar = eVar2.f21152d;
            int i13 = eVar2.f21149a;
            yg.a aVar2 = eVar2.f21162k;
            if (aVar2 == null) {
                zf.i.throwUninitializedPropertyAccessException("connection");
                aVar2 = null;
            }
            Socket socket = aVar2.f22538b;
            byte[] address = (socket == null || (inetAddress = socket.getInetAddress()) == null) ? null : inetAddress.getAddress();
            if (address == null) {
                address = new byte[0];
            }
            byte[] bArr = address;
            yg.a aVar3 = eVar2.f21162k;
            if (aVar3 == null) {
                zf.i.throwUninitializedPropertyAccessException("connection");
                aVar3 = null;
            }
            Socket socket2 = aVar3.f22538b;
            Integer numValueOf = socket2 != null ? Integer.valueOf(socket2.getPort()) : null;
            int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
            rb.p pVar = (rb.p) cVar;
            pVar.getClass();
            zf.i.checkNotNullParameter(bArr, "remoteIp");
            ng.g gVar = k.c.f14701a;
            k.c.a("ProxyBloc", "onConnectionSuccess: [" + i13 + "]: active sessions = " + pVar.f18918z.size());
            kg.h.launch$default(pVar.f18916x, null, null, new e.e(pVar, i13, bArr, iIntValue, null), 3, null);
            eVar2.f21163l = kg.h.launch$default(eVar2.f21161j, null, null, new d(eVar2, null), 3, null);
        } catch (Throwable th2) {
            rb.p pVar2 = (rb.p) eVar2.f21152d;
            pVar2.getClass();
            zf.i.checkNotNullParameter(th2, "ex");
            ng.g gVar2 = k.c.f14701a;
            StringBuilder sb2 = new StringBuilder("onConnectionError: [");
            int i14 = eVar2.f21149a;
            sb2.append(i14);
            sb2.append("]: ");
            sb2.append(th2);
            k.c.a("ProxyBloc", sb2.toString());
            kg.h.launch$default(pVar2.f18916x, null, null, new e.d(pVar2, i14, th2, null), 3, null);
        }
        return lf.h.f16056a;
    }
}
