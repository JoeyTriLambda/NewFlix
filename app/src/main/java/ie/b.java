package ie;

/* loaded from: classes2.dex */
public final class b extends a {

    /* renamed from: f, reason: collision with root package name */
    public static final String f13372f = g.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public final int f13373c;

    /* renamed from: d, reason: collision with root package name */
    public long f13374d;

    /* renamed from: e, reason: collision with root package name */
    public final j f13375e;

    public b(byte[] bArr) {
        super(bArr);
        this.f13373c = 32768;
        this.f13375e = new j(bArr);
    }

    public long c() {
        return this.f13374d;
    }

    public boolean d() {
        String str = f13372f;
        try {
            if (b() != 8) {
                return false;
            }
            long jLongValue = this.f13375e.f(8).e(this.f13373c).longValue();
            this.f13374d = jLongValue;
            je.a.a(str, "Close Tunnel Message From Server: tunnel id=%d", Long.valueOf(jLongValue));
            return true;
        } catch (Exception e10) {
            je.a.b(str, "CloseTunnelMessage tunnel id:%d Validation Fail: %s trace: %s", Long.valueOf(this.f13374d), e10.getMessage(), e10.toString());
            return false;
        }
    }
}
