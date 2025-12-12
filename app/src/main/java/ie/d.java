package ie;

/* loaded from: classes2.dex */
public final class d extends a {

    /* renamed from: j, reason: collision with root package name */
    public static final String f13376j = g.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public final int f13377c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13378d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13379e;

    /* renamed from: f, reason: collision with root package name */
    public long f13380f;

    /* renamed from: g, reason: collision with root package name */
    public String f13381g;

    /* renamed from: h, reason: collision with root package name */
    public int f13382h;

    /* renamed from: i, reason: collision with root package name */
    public final j f13383i;

    public d(byte[] bArr) {
        super(bArr);
        this.f13377c = 20480;
        this.f13378d = 20481;
        this.f13379e = 20482;
        this.f13383i = new j(bArr);
    }

    public String c() {
        return this.f13381g;
    }

    public int d() {
        return this.f13382h;
    }

    public long e() {
        return this.f13380f;
    }

    public boolean f() {
        String str = f13376j;
        try {
            if (b() != 5) {
                return false;
            }
            j jVarF = this.f13383i.f(5);
            this.f13380f = jVarF.e(this.f13377c).longValue();
            this.f13381g = jVarF.g(this.f13378d);
            this.f13382h = jVarF.d(this.f13379e).intValue();
            je.a.a(str, "Open Tunnel Message From Server: tunnel id=%d host=%s:%d", Long.valueOf(this.f13380f), this.f13381g, Integer.valueOf(this.f13382h));
            return true;
        } catch (Exception e10) {
            je.a.b(str, "OpenTunnelMessage tunnel id:%d Validation Fail: %s trace: %s", Long.valueOf(this.f13380f), e10.getMessage(), e10.toString());
            return false;
        }
    }
}
