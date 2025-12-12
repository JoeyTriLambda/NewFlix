package s8;

/* compiled from: AutoValue_RolloutAssignment.java */
/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: b, reason: collision with root package name */
    public final String f19126b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19127c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19128d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19129e;

    /* renamed from: f, reason: collision with root package name */
    public final long f19130f;

    public b(String str, String str2, String str3, String str4, long j10) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f19126b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f19127c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f19128d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f19129e = str4;
        this.f19130f = j10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f19126b.equals(kVar.getRolloutId()) && this.f19127c.equals(kVar.getParameterKey()) && this.f19128d.equals(kVar.getParameterValue()) && this.f19129e.equals(kVar.getVariantId()) && this.f19130f == kVar.getTemplateVersion();
    }

    @Override // s8.k
    public String getParameterKey() {
        return this.f19127c;
    }

    @Override // s8.k
    public String getParameterValue() {
        return this.f19128d;
    }

    @Override // s8.k
    public String getRolloutId() {
        return this.f19126b;
    }

    @Override // s8.k
    public long getTemplateVersion() {
        return this.f19130f;
    }

    @Override // s8.k
    public String getVariantId() {
        return this.f19129e;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f19126b.hashCode() ^ 1000003) * 1000003) ^ this.f19127c.hashCode()) * 1000003) ^ this.f19128d.hashCode()) * 1000003) ^ this.f19129e.hashCode()) * 1000003;
        long j10 = this.f19130f;
        return iHashCode ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f19126b + ", parameterKey=" + this.f19127c + ", parameterValue=" + this.f19128d + ", variantId=" + this.f19129e + ", templateVersion=" + this.f19130f + "}";
    }
}
