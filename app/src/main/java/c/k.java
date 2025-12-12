package c;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kg.g0;
import kg.h0;
import kg.s0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import l3.w;
import xg.d0;

/* loaded from: classes.dex */
public final class k extends SuspendLambda implements yf.p {

    /* renamed from: b, reason: collision with root package name */
    public int f4969b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f4970m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ l3.l f4971n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(w wVar, l3.l lVar, qf.c cVar) {
        super(2, cVar);
        this.f4970m = wVar;
        this.f4971n = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qf.c create(Object obj, qf.c cVar) {
        return new k(this.f4970m, this.f4971n, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new k(this.f4970m, this.f4971n, (qf.c) obj2).invokeSuspend(lf.h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        yg.a aVar;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f4969b;
        w wVar = this.f4970m;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            if (((p000if.a) wVar.f15750u.f13438a.getValue()).f13433f.length() > 0) {
                String str = ((p000if.a) wVar.f15750u.f13438a.getValue()).f13433f;
                this.f4969b = 1;
                obj = w.a(wVar, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar = (yg.a) obj;
            } else {
                String str2 = this.f4971n.f15738a;
                this.f4969b = 2;
                obj = w.a(wVar, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar = (yg.a) obj;
            }
        } else if (i10 == 1) {
            lf.f.throwOnFailure(obj);
            aVar = (yg.a) obj;
        } else {
            if (i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
            aVar = (yg.a) obj;
        }
        d0 d0Var = wVar.f15752w;
        g0 g0Var = wVar.f15754y;
        if (g0Var == null) {
            zf.i.throwUninitializedPropertyAccessException("socketScope");
            g0Var = null;
        }
        d0Var.getClass();
        zf.i.checkNotNullParameter(aVar, "connection");
        zf.i.checkNotNullParameter(g0Var, "outScope");
        h0.cancel$default(d0Var.f21763d, null, 1, null);
        d0Var.f21763d = h0.CoroutineScope(s0.getDefault().plus(d0Var.f21762c));
        de.f fVar = d0Var.f21760a;
        fVar.getClass();
        zf.i.checkNotNullParameter(aVar, "connection");
        zf.i.checkNotNullParameter(g0Var, "outScope");
        Socket socket = aVar.f22538b;
        OutputStream outputStream = socket != null ? socket.getOutputStream() : null;
        zf.i.checkNotNull(outputStream);
        fVar.f11017a = new de.e(outputStream);
        Socket socket2 = aVar.f22538b;
        InputStream inputStream = socket2 != null ? socket2.getInputStream() : null;
        zf.i.checkNotNull(inputStream);
        fVar.f11018b = new de.c(inputStream, g0Var);
        g0 g0VarCoroutineScope = h0.CoroutineScope(s0.getDefault().plus(wVar.B));
        wVar.f15755z = g0VarCoroutineScope;
        if (g0VarCoroutineScope != null) {
            kg.h.launch$default(g0VarCoroutineScope, new kotlinx.coroutines.c("IncomingPing"), null, new x(wVar, null), 2, null);
        }
        wVar.add(l3.n.f15740a);
        return lf.h.f16056a;
    }
}
