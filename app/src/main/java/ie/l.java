package ie;

/* loaded from: classes2.dex */
public final class l extends a {

    /* renamed from: c, reason: collision with root package name */
    public final int f13426c = 24576;

    /* renamed from: d, reason: collision with root package name */
    public final int f13427d = 24577;

    public static String a(byte b10) {
        return b10 != 1 ? b10 != 2 ? b10 != 3 ? "STATUS NOT VALID OPTION" : "REMOTE_CLOSE" : "ERR" : "OK";
    }

    public byte[] a(long j10, byte b10) {
        j jVarA = j.a();
        jVarA.a(this.f13426c, j10);
        jVarA.a(this.f13427d, b10);
        return j.a().a(6, jVarA).c();
    }
}
