package ie;

/* loaded from: classes2.dex */
public final class f extends a {

    /* renamed from: c, reason: collision with root package name */
    public final int f13387c;

    /* renamed from: d, reason: collision with root package name */
    public final j f13388d;

    public f() {
        this.f13387c = 12288;
    }

    public byte[] a(long j10) {
        j jVarA = j.a();
        jVarA.a(this.f13387c, j10);
        return j.a().a(4, jVarA).c();
    }

    public boolean b(long j10) {
        try {
            if (b() == 4) {
                j jVarF = this.f13388d.f(4);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jVarF.e(this.f13387c).longValue() == j10) {
                    je.a.a("f", "PingPong takes: %d miiliseconds", Long.valueOf(jCurrentTimeMillis - j10));
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            je.a.b("f", "PongMessage Validation Fail: %s trace: %s", e10.getMessage(), e10.toString());
            return false;
        }
    }

    public f(byte[] bArr) {
        super(bArr);
        this.f13387c = 12288;
        this.f13388d = new j(bArr);
    }
}
