package ie;

/* loaded from: classes2.dex */
public final class c extends a {
    public c(byte[] bArr) {
        super(bArr);
        new j(bArr);
    }

    public boolean c() {
        try {
            return b() == 10;
        } catch (Exception e10) {
            je.a.b("c", "Disconnect Message Validation Fail: %s trace: %s", e10.getMessage(), e10.toString());
            return false;
        }
    }
}
