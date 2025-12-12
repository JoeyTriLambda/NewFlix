package g9;

import java.util.List;

/* compiled from: AutoValue_HeartBeatResult.java */
/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: a, reason: collision with root package name */
    public final String f12805a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f12806b;

    public a(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f12805a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f12806b = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f12805a.equals(iVar.getUserAgent()) && this.f12806b.equals(iVar.getUsedDates());
    }

    @Override // g9.i
    public List<String> getUsedDates() {
        return this.f12806b;
    }

    @Override // g9.i
    public String getUserAgent() {
        return this.f12805a;
    }

    public int hashCode() {
        return ((this.f12805a.hashCode() ^ 1000003) * 1000003) ^ this.f12806b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f12805a + ", usedDates=" + this.f12806b + "}";
    }
}
