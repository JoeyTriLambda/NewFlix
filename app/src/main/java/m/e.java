package m;

import java.io.OutputStream;
import java.net.Socket;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import qf.c;
import rf.a;

/* loaded from: classes2.dex */
public final class e extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wg.e f16066b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f16067m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ byte[] f16068n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(wg.e eVar, long j10, byte[] bArr, c cVar) {
        super(2, cVar);
        this.f16066b = eVar;
        this.f16067m = j10;
        this.f16068n = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new e(this.f16066b, this.f16067m, this.f16068n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((g0) obj, (c) obj2)).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        wg.g gVar;
        Socket socket;
        wg.e eVar = this.f16066b;
        a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(obj);
        try {
            yg.a aVar = eVar.f21162k;
            gVar = null;
            if (aVar == null) {
                zf.i.throwUninitializedPropertyAccessException("connection");
                aVar = null;
            }
            socket = aVar.f22538b;
        } catch (Throwable th2) {
            ((rb.p) eVar.f21152d).a(eVar.f21149a, th2);
        }
        if ((socket != null ? socket.getOutputStream() : null) == null) {
            throw new o.a(String.valueOf(eVar.f21149a));
        }
        yg.a aVar2 = eVar.f21162k;
        if (aVar2 == null) {
            zf.i.throwUninitializedPropertyAccessException("connection");
            aVar2 = null;
        }
        Socket socket2 = aVar2.f22538b;
        OutputStream outputStream = socket2 != null ? socket2.getOutputStream() : null;
        zf.i.checkNotNull(outputStream);
        long j10 = this.f16067m;
        byte[] bArr = this.f16068n;
        ng.g gVar2 = k.c.f14701a;
        k.c.a("TcpProxySession", "TcpProxySession: send: [" + eVar.f21149a + "] [" + j10 + "] start bytesToWrite=" + bArr.length);
        outputStream.write(bArr);
        outputStream.flush();
        if (eVar.c()) {
            wg.g gVar3 = eVar.f21158g;
            if (gVar3 == null) {
                zf.i.throwUninitializedPropertyAccessException("tcpWindowHandler");
            } else {
                gVar = gVar3;
            }
            gVar.a(bArr.length);
        }
        k.c.a("TcpProxySession", "TcpProxySession: send: [" + eVar.f21149a + "] [" + j10 + "] end bytesWriten=" + bArr.length);
        return lf.h.f16056a;
    }
}
