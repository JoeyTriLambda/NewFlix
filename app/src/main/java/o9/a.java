package o9;

/* compiled from: AutoValue_LibraryVersion.java */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    public final String f17050a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17051b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f17050a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f17051b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f17050a.equals(eVar.getLibraryName()) && this.f17051b.equals(eVar.getVersion());
    }

    @Override // o9.e
    public String getLibraryName() {
        return this.f17050a;
    }

    @Override // o9.e
    public String getVersion() {
        return this.f17051b;
    }

    public int hashCode() {
        return ((this.f17050a.hashCode() ^ 1000003) * 1000003) ^ this.f17051b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LibraryVersion{libraryName=");
        sb2.append(this.f17050a);
        sb2.append(", version=");
        return ac.c.o(sb2, this.f17051b, "}");
    }
}
