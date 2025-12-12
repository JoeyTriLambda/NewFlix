package wg;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import kg.e0;
import kg.g0;
import kg.h0;
import kg.s0;
import m.p;
import m.q;
import xg.o;

/* loaded from: classes2.dex */
public final class i extends a {

    /* renamed from: f, reason: collision with root package name */
    public yg.c f21178f;

    /* renamed from: g, reason: collision with root package name */
    public final g0 f21179g;

    /* renamed from: h, reason: collision with root package name */
    public final g0 f21180h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(int i10, String str, int i11, c cVar, yg.b bVar) {
        super(i10, str, i11, cVar, bVar);
        zf.i.checkNotNullParameter(str, "host");
        zf.i.checkNotNullParameter(cVar, "listener");
        zf.i.checkNotNullParameter(bVar, "socketRepository");
        int i12 = e0.f15105h;
        h hVar = new h(e0.b.f15106b, i10, cVar);
        this.f21179g = h0.CoroutineScope(s0.getDefault().plus(hVar));
        this.f21180h = h0.CoroutineScope(s0.getDefault().plus(hVar));
        h0.CoroutineScope(s0.getIO().limitedParallelism(1).plus(hVar));
    }

    @Override // wg.a
    public final void a(o oVar) {
        zf.i.checkNotNullParameter(oVar, "packet");
    }

    @Override // wg.a
    public final void b() {
        h0.cancel$default(this.f21180h, null, 1, null);
        kg.h.launch$default(this.f21179g, null, null, new q(this, null), 3, null);
    }

    @Override // wg.a
    public final void a() {
        kg.h.launch$default(this.f21179g, new kotlinx.coroutines.c(ac.c.l(new StringBuilder("connection["), this.f21149a, ']')), null, new p(this, null), 2, null);
    }

    @Override // wg.a
    public final void a(byte[] bArr, long j10) throws IOException {
        zf.i.checkNotNullParameter(bArr, "packet");
        ng.g gVar = k.c.f14701a;
        k.c.a("UdpProxySession", "[" + this.f21149a + "] -> [" + bArr.length + " bytes]");
        yg.c cVar = this.f21178f;
        if (cVar == null) {
            zf.i.throwUninitializedPropertyAccessException("connection");
            cVar = null;
        }
        cVar.getClass();
        zf.i.checkNotNullParameter(bArr, JsonStorageKeyNames.DATA_KEY);
        int length = bArr.length;
        DatagramSocket datagramSocket = cVar.f22541a;
        zf.i.checkNotNull(datagramSocket);
        DatagramPacket datagramPacket = new DatagramPacket(bArr, length, datagramSocket.getRemoteSocketAddress());
        DatagramSocket datagramSocket2 = cVar.f22541a;
        if (datagramSocket2 != null) {
            datagramSocket2.send(datagramPacket);
        }
    }
}
