package ig;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f13453a;

    /* renamed from: b, reason: collision with root package name */
    public final fg.c f13454b;

    public e(String str, fg.c cVar) {
        zf.i.checkNotNullParameter(str, "value");
        zf.i.checkNotNullParameter(cVar, "range");
        this.f13453a = str;
        this.f13454b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return zf.i.areEqual(this.f13453a, eVar.f13453a) && zf.i.areEqual(this.f13454b, eVar.f13454b);
    }

    public int hashCode() {
        return this.f13454b.hashCode() + (this.f13453a.hashCode() * 31);
    }

    public String toString() {
        return "MatchGroup(value=" + this.f13453a + ", range=" + this.f13454b + ')';
    }
}
