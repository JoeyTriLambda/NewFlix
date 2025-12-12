package wg;

import java.util.Timer;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f21165a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21166b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21167c;

    /* renamed from: d, reason: collision with root package name */
    public final m.g f21168d;

    /* renamed from: e, reason: collision with root package name */
    public long f21169e;

    /* renamed from: f, reason: collision with root package name */
    public long f21170f;

    /* renamed from: g, reason: collision with root package name */
    public long f21171g;

    /* renamed from: h, reason: collision with root package name */
    public long f21172h;

    /* renamed from: i, reason: collision with root package name */
    public long f21173i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21174j;

    /* renamed from: k, reason: collision with root package name */
    public Timer f21175k;

    public g(int i10, long j10, int i11, m.g gVar) {
        zf.i.checkNotNullParameter(gVar, "sendAck");
        this.f21165a = i10;
        this.f21166b = j10;
        this.f21167c = i11;
        this.f21168d = gVar;
    }

    public final void a(long j10) {
        this.f21172h += j10;
        ng.g gVar = k.c.f14701a;
        k.c.a("TcpWindowHandler", "onDataReceived: [" + this.f21165a + "] total=" + this.f21172h + ", new=" + j10);
        if (!this.f21174j) {
            a();
        }
        if (this.f21175k == null) {
            long j11 = this.f21166b;
            Timer timer = pf.a.timer("ackTimer", false);
            timer.schedule(new f(this), 0L, j11);
            this.f21175k = timer;
        }
    }

    public final void b(long j10) {
        this.f21170f += j10;
        ng.g gVar = k.c.f14701a;
        k.c.a("TcpWindowHandler", "TcpWindowHandler: onDataSent: [" + this.f21165a + "] total=" + this.f21170f + ", new=" + j10);
    }

    public final void a() {
        if (this.f21174j) {
            return;
        }
        this.f21174j = true;
        ng.g gVar = k.c.f14701a;
        StringBuilder sb2 = new StringBuilder("TcpWindowHandler: checkSendAck: [");
        int i10 = this.f21165a;
        sb2.append(i10);
        sb2.append("] lastAck=");
        sb2.append(this.f21171g);
        sb2.append(", ackBytes=");
        sb2.append(this.f21172h);
        sb2.append(", lastSent=");
        sb2.append(System.currentTimeMillis() - this.f21173i);
        sb2.append(", delta=");
        sb2.append(this.f21172h - this.f21171g);
        sb2.append(", halfWindow=");
        long j10 = this.f21166b / 2;
        sb2.append(j10);
        k.c.a("TcpWindowHandler", sb2.toString());
        if ((System.currentTimeMillis() - this.f21173i > this.f21167c || this.f21172h - this.f21171g > j10) && this.f21171g != this.f21172h) {
            StringBuilder sbS = ac.c.s("TcpWindowHandler: sendAck: [", i10, "] lastAck=");
            sbS.append(this.f21171g);
            sbS.append(", ackBytes=");
            sbS.append(this.f21172h);
            sbS.append(", lastSent=");
            sbS.append(System.currentTimeMillis() - this.f21173i);
            sbS.append(", delta=");
            sbS.append(this.f21172h - this.f21171g);
            sbS.append(", halfWindow=");
            sbS.append(j10);
            k.c.a("TcpWindowHandler", sbS.toString());
            this.f21171g = this.f21172h;
            this.f21173i = System.currentTimeMillis();
            Timer timer = this.f21175k;
            if (timer != null) {
                timer.cancel();
            }
            this.f21175k = null;
            this.f21168d.invoke(Long.valueOf(this.f21171g));
        }
        this.f21174j = false;
    }
}
