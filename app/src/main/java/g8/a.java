package g8;

/* compiled from: AutoValue_StartupTime.java */
/* loaded from: classes.dex */
public final class a extends j {

    /* renamed from: a, reason: collision with root package name */
    public final long f12775a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12776b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12777c;

    public a(long j10, long j11, long j12) {
        this.f12775a = j10;
        this.f12776b = j11;
        this.f12777c = j12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f12775a == jVar.getEpochMillis() && this.f12776b == jVar.getElapsedRealtime() && this.f12777c == jVar.getUptimeMillis();
    }

    @Override // g8.j
    public long getElapsedRealtime() {
        return this.f12776b;
    }

    @Override // g8.j
    public long getEpochMillis() {
        return this.f12775a;
    }

    @Override // g8.j
    public long getUptimeMillis() {
        return this.f12777c;
    }

    public int hashCode() {
        long j10 = this.f12775a;
        long j11 = this.f12776b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f12777c;
        return ((int) ((j12 >>> 32) ^ j12)) ^ i10;
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f12775a + ", elapsedRealtime=" + this.f12776b + ", uptimeMillis=" + this.f12777c + "}";
    }
}
