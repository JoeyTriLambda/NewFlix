package wg;

import java.util.Map;
import kg.e0;
import kg.g0;
import kg.h0;
import kg.k1;
import kg.s0;
import xg.o;

/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: f, reason: collision with root package name */
    public final Map f21157f;

    /* renamed from: g, reason: collision with root package name */
    public g f21158g;

    /* renamed from: h, reason: collision with root package name */
    public final g0 f21159h;

    /* renamed from: i, reason: collision with root package name */
    public final g0 f21160i;

    /* renamed from: j, reason: collision with root package name */
    public final g0 f21161j;

    /* renamed from: k, reason: collision with root package name */
    public yg.a f21162k;

    /* renamed from: l, reason: collision with root package name */
    public k1 f21163l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i10, String str, int i11, c cVar, yg.b bVar, Map map) {
        super(i10, str, i11, cVar, bVar);
        zf.i.checkNotNullParameter(str, "host");
        zf.i.checkNotNullParameter(cVar, "listener");
        zf.i.checkNotNullParameter(bVar, "socketRepository");
        this.f21157f = map;
        int i12 = e0.f15105h;
        new d(e0.b.f15106b, i10, cVar);
        this.f21159h = h0.CoroutineScope(s0.getIO().limitedParallelism(1));
        this.f21160i = h0.CoroutineScope(s0.getIO().limitedParallelism(1));
        this.f21161j = h0.CoroutineScope(s0.getIO().limitedParallelism(1));
    }

    @Override // wg.a
    public final void a() {
        kg.h.launch$default(this.f21160i, new kotlinx.coroutines.c(ac.c.l(new StringBuilder("connection["), this.f21149a, ']')), null, new m.h(this, null), 2, null);
    }

    @Override // wg.a
    public final void b() {
        ng.g gVar = k.c.f14701a;
        k.c.a("TcpProxySession", "TcpProxySession: stop: [" + this.f21149a + ']');
        kg.h.launch$default(this.f21160i, null, null, new m.i(this, null), 3, null);
        h0.cancel$default(this.f21160i, null, 1, null);
        h0.cancel$default(this.f21159h, null, 1, null);
    }

    public final boolean c() {
        String str;
        Map map = this.f21157f;
        return ((map == null || (str = (String) map.get("wnd")) == null) ? null : Long.valueOf(Long.parseLong(str))) != null;
    }

    @Override // wg.a
    public final void a(byte[] bArr, long j10) {
        zf.i.checkNotNullParameter(bArr, "packet");
        kg.h.launch$default(this.f21159h, null, null, new m.e(this, j10, bArr, null), 3, null);
    }

    @Override // wg.a
    public final void a(o oVar) {
        zf.i.checkNotNullParameter(oVar, "packet");
        if (c()) {
            g gVar = this.f21158g;
            if (gVar == null) {
                zf.i.throwUninitializedPropertyAccessException("tcpWindowHandler");
                gVar = null;
            }
            gVar.getClass();
            zf.i.checkNotNullParameter(oVar, "ack");
            ng.g gVar2 = k.c.f14701a;
            k.c.a("TcpWindowHandler", "TcpWindowHandler: onAck: [" + gVar.f21165a + "] last=" + gVar.f21169e + ", new=" + oVar.f21785b);
            gVar.f21169e = oVar.f21785b;
        }
    }
}
