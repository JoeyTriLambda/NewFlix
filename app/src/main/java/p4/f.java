package p4;

/* compiled from: AutoValue_LogResponse.java */
/* loaded from: classes.dex */
public final class f extends j {

    /* renamed from: a, reason: collision with root package name */
    public final long f17597a;

    public f(long j10) {
        this.f17597a = j10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof j) && this.f17597a == ((j) obj).getNextRequestWaitMillis();
    }

    @Override // p4.j
    public long getNextRequestWaitMillis() {
        return this.f17597a;
    }

    public int hashCode() {
        long j10 = this.f17597a;
        return 1000003 ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f17597a + "}";
    }
}
