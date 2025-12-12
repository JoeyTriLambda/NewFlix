package q4;

import q4.n;

/* compiled from: AutoValue_SendRequest.java */
/* loaded from: classes.dex */
public final class c extends n {

    /* renamed from: a, reason: collision with root package name */
    public final o f17834a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17835b;

    /* renamed from: c, reason: collision with root package name */
    public final n4.c<?> f17836c;

    /* renamed from: d, reason: collision with root package name */
    public final n4.d<?, byte[]> f17837d;

    /* renamed from: e, reason: collision with root package name */
    public final n4.b f17838e;

    /* compiled from: AutoValue_SendRequest.java */
    public static final class a extends n.a {

        /* renamed from: a, reason: collision with root package name */
        public o f17839a;

        /* renamed from: b, reason: collision with root package name */
        public String f17840b;

        /* renamed from: c, reason: collision with root package name */
        public n4.c<?> f17841c;

        /* renamed from: d, reason: collision with root package name */
        public n4.d<?, byte[]> f17842d;

        /* renamed from: e, reason: collision with root package name */
        public n4.b f17843e;

        public n build() {
            String strB = this.f17839a == null ? " transportContext" : "";
            if (this.f17840b == null) {
                strB = strB.concat(" transportName");
            }
            if (this.f17841c == null) {
                strB = ac.c.B(strB, " event");
            }
            if (this.f17842d == null) {
                strB = ac.c.B(strB, " transformer");
            }
            if (this.f17843e == null) {
                strB = ac.c.B(strB, " encoding");
            }
            if (strB.isEmpty()) {
                return new c(this.f17839a, this.f17840b, this.f17841c, this.f17842d, this.f17843e);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // q4.n.a
        public n.a setTransportContext(o oVar) {
            if (oVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f17839a = oVar;
            return this;
        }

        public n.a setTransportName(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f17840b = str;
            return this;
        }
    }

    public c(o oVar, String str, n4.c cVar, n4.d dVar, n4.b bVar) {
        this.f17834a = oVar;
        this.f17835b = str;
        this.f17836c = cVar;
        this.f17837d = dVar;
        this.f17838e = bVar;
    }

    @Override // q4.n
    public final n4.c<?> a() {
        return this.f17836c;
    }

    @Override // q4.n
    public final n4.d<?, byte[]> b() {
        return this.f17837d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f17834a.equals(nVar.getTransportContext()) && this.f17835b.equals(nVar.getTransportName()) && this.f17836c.equals(nVar.a()) && this.f17837d.equals(nVar.b()) && this.f17838e.equals(nVar.getEncoding());
    }

    @Override // q4.n
    public n4.b getEncoding() {
        return this.f17838e;
    }

    @Override // q4.n
    public o getTransportContext() {
        return this.f17834a;
    }

    @Override // q4.n
    public String getTransportName() {
        return this.f17835b;
    }

    public int hashCode() {
        return ((((((((this.f17834a.hashCode() ^ 1000003) * 1000003) ^ this.f17835b.hashCode()) * 1000003) ^ this.f17836c.hashCode()) * 1000003) ^ this.f17837d.hashCode()) * 1000003) ^ this.f17838e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f17834a + ", transportName=" + this.f17835b + ", event=" + this.f17836c + ", transformer=" + this.f17837d + ", encoding=" + this.f17838e + "}";
    }
}
