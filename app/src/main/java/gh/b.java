package gh;

/* compiled from: ParseError.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f12841a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12842b;

    public b(int i10, String str) {
        this.f12841a = i10;
        this.f12842b = str;
    }

    public String toString() {
        return this.f12841a + ": " + this.f12842b;
    }

    public b(int i10, String str, Object... objArr) {
        this.f12842b = String.format(str, objArr);
        this.f12841a = i10;
    }
}
