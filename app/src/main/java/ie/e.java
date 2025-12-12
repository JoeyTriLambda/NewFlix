package ie;

/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: c, reason: collision with root package name */
    public final int f13384c;

    /* renamed from: d, reason: collision with root package name */
    public final j f13385d;

    /* renamed from: e, reason: collision with root package name */
    public long f13386e;

    public e() {
        this.f13384c = 12288;
        super.a(3);
    }

    public byte[] c() {
        j jVarA = j.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f13386e = jCurrentTimeMillis;
        jVarA.a(this.f13384c, jCurrentTimeMillis);
        return j.a().a(3, jVarA).c();
    }

    public long d() {
        return this.f13386e;
    }

    public boolean e() {
        int i10 = this.f13384c;
        try {
            if (b() == 3) {
                j jVarF = this.f13385d.f(3);
                if (jVarF.a(i10)) {
                    this.f13386e = jVarF.e(i10).longValue();
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            je.a.b("e", "Ping Message Validation Fail: %s trace: %s", e10.getMessage(), e10.toString());
            return false;
        }
    }

    public e(byte[] bArr) {
        super(bArr);
        this.f13384c = 12288;
        this.f13385d = new j(bArr);
    }
}
