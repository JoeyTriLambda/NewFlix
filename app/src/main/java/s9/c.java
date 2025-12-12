package s9;

import zf.i;

/* compiled from: SettingsCache.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f19177a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f19178b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f19179c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f19180d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f19181e;

    public c(Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        this.f19177a = bool;
        this.f19178b = d10;
        this.f19179c = num;
        this.f19180d = num2;
        this.f19181e = l10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.areEqual(this.f19177a, cVar.f19177a) && i.areEqual(this.f19178b, cVar.f19178b) && i.areEqual(this.f19179c, cVar.f19179c) && i.areEqual(this.f19180d, cVar.f19180d) && i.areEqual(this.f19181e, cVar.f19181e);
    }

    public final Integer getCacheDuration() {
        return this.f19180d;
    }

    public final Long getCacheUpdatedTime() {
        return this.f19181e;
    }

    public final Boolean getSessionEnabled() {
        return this.f19177a;
    }

    public final Integer getSessionRestartTimeout() {
        return this.f19179c;
    }

    public final Double getSessionSamplingRate() {
        return this.f19178b;
    }

    public int hashCode() {
        Boolean bool = this.f19177a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d10 = this.f19178b;
        int iHashCode2 = (iHashCode + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num = this.f19179c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f19180d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.f19181e;
        return iHashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f19177a + ", sessionSamplingRate=" + this.f19178b + ", sessionRestartTimeout=" + this.f19179c + ", cacheDuration=" + this.f19180d + ", cacheUpdatedTime=" + this.f19181e + ')';
    }
}
