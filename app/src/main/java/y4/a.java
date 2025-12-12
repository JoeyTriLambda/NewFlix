package y4;

/* compiled from: AutoValue_EventStoreConfig.java */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    public final long f21861b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21862c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21863d;

    /* renamed from: e, reason: collision with root package name */
    public final long f21864e;

    /* renamed from: f, reason: collision with root package name */
    public final int f21865f;

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f21861b = j10;
        this.f21862c = i10;
        this.f21863d = i11;
        this.f21864e = j11;
        this.f21865f = i12;
    }

    @Override // y4.e
    public final int a() {
        return this.f21863d;
    }

    @Override // y4.e
    public final long b() {
        return this.f21864e;
    }

    @Override // y4.e
    public final int c() {
        return this.f21862c;
    }

    @Override // y4.e
    public final int d() {
        return this.f21865f;
    }

    @Override // y4.e
    public final long e() {
        return this.f21861b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f21861b == eVar.e() && this.f21862c == eVar.c() && this.f21863d == eVar.a() && this.f21864e == eVar.b() && this.f21865f == eVar.d();
    }

    public int hashCode() {
        long j10 = this.f21861b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f21862c) * 1000003) ^ this.f21863d) * 1000003;
        long j11 = this.f21864e;
        return this.f21865f ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb2.append(this.f21861b);
        sb2.append(", loadBatchSize=");
        sb2.append(this.f21862c);
        sb2.append(", criticalSectionEnterTimeoutMs=");
        sb2.append(this.f21863d);
        sb2.append(", eventCleanUpAge=");
        sb2.append(this.f21864e);
        sb2.append(", maxBlobByteSizePerRow=");
        return ac.c.m(sb2, this.f21865f, "}");
    }
}
