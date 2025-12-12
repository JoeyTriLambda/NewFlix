package t8;

import t8.g0;

/* compiled from: AutoValue_StaticSessionData.java */
/* loaded from: classes.dex */
public final class b0 extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public final g0.a f19639a;

    /* renamed from: b, reason: collision with root package name */
    public final g0.c f19640b;

    /* renamed from: c, reason: collision with root package name */
    public final g0.b f19641c;

    public b0(g0.a aVar, g0.c cVar, g0.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f19639a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f19640b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f19641c = bVar;
    }

    @Override // t8.g0
    public g0.a appData() {
        return this.f19639a;
    }

    @Override // t8.g0
    public g0.b deviceData() {
        return this.f19641c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f19639a.equals(g0Var.appData()) && this.f19640b.equals(g0Var.osData()) && this.f19641c.equals(g0Var.deviceData());
    }

    public int hashCode() {
        return ((((this.f19639a.hashCode() ^ 1000003) * 1000003) ^ this.f19640b.hashCode()) * 1000003) ^ this.f19641c.hashCode();
    }

    @Override // t8.g0
    public g0.c osData() {
        return this.f19640b;
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f19639a + ", osData=" + this.f19640b + ", deviceData=" + this.f19641c + "}";
    }
}
