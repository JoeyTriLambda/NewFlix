package y4;

/* compiled from: AutoValue_PersistedEvent.java */
/* loaded from: classes.dex */
public final class b extends j {

    /* renamed from: a, reason: collision with root package name */
    public final long f21866a;

    /* renamed from: b, reason: collision with root package name */
    public final q4.o f21867b;

    /* renamed from: c, reason: collision with root package name */
    public final q4.i f21868c;

    public b(long j10, q4.o oVar, q4.i iVar) {
        this.f21866a = j10;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f21867b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f21868c = iVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f21866a == jVar.getId() && this.f21867b.equals(jVar.getTransportContext()) && this.f21868c.equals(jVar.getEvent());
    }

    @Override // y4.j
    public q4.i getEvent() {
        return this.f21868c;
    }

    @Override // y4.j
    public long getId() {
        return this.f21866a;
    }

    @Override // y4.j
    public q4.o getTransportContext() {
        return this.f21867b;
    }

    public int hashCode() {
        long j10 = this.f21866a;
        return this.f21868c.hashCode() ^ ((((((int) ((j10 >>> 32) ^ j10)) ^ 1000003) * 1000003) ^ this.f21867b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f21866a + ", transportContext=" + this.f21867b + ", event=" + this.f21868c + "}";
    }
}
