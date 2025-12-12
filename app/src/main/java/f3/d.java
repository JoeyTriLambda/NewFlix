package f3;

/* compiled from: Preference.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f11405a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f11406b;

    public d(String str, Long l10) {
        zf.i.checkNotNullParameter(str, "key");
        this.f11405a = str;
        this.f11406b = l10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return zf.i.areEqual(this.f11405a, dVar.f11405a) && zf.i.areEqual(this.f11406b, dVar.f11406b);
    }

    public final String getKey() {
        return this.f11405a;
    }

    public final Long getValue() {
        return this.f11406b;
    }

    public int hashCode() {
        int iHashCode = this.f11405a.hashCode() * 31;
        Long l10 = this.f11406b;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.f11405a + ", value=" + this.f11406b + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String str, boolean z10) {
        this(str, Long.valueOf(z10 ? 1L : 0L));
        zf.i.checkNotNullParameter(str, "key");
    }
}
