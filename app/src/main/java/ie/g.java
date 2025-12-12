package ie;

/* loaded from: classes2.dex */
public final class g extends a {

    /* renamed from: c, reason: collision with root package name */
    public final int f13389c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13390d;

    /* renamed from: e, reason: collision with root package name */
    public final byte f13391e;

    /* renamed from: f, reason: collision with root package name */
    public final j f13392f;

    public g() {
        this.f13389c = 8192;
        this.f13390d = 8193;
        this.f13391e = (byte) 1;
    }

    public boolean c() {
        int i10 = this.f13390d;
        j jVar = this.f13392f;
        try {
            if (b() != 2 || jVar.f(2).b(this.f13389c).byteValue() != this.f13391e) {
                return false;
            }
            if (jVar.a(i10)) {
                je.a.a("g", "Message From Server: " + jVar.g(i10), new Object[0]);
            }
            return true;
        } catch (Exception e10) {
            je.a.b("g", "RegReplyMessage Validation Fail: %s trace: %s", e10.getMessage(), e10.toString());
            return false;
        }
    }

    public g(byte[] bArr, int i10) {
        super(bArr);
        this.f13389c = 8192;
        this.f13390d = 8193;
        this.f13391e = (byte) 1;
        this.f13392f = new j(bArr);
    }
}
