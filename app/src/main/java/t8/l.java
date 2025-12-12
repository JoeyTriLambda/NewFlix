package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
/* loaded from: classes.dex */
public final class l extends f0.e.d {

    /* renamed from: a, reason: collision with root package name */
    public final long f19752a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19753b;

    /* renamed from: c, reason: collision with root package name */
    public final f0.e.d.a f19754c;

    /* renamed from: d, reason: collision with root package name */
    public final f0.e.d.c f19755d;

    /* renamed from: e, reason: collision with root package name */
    public final f0.e.d.AbstractC0276d f19756e;

    /* renamed from: f, reason: collision with root package name */
    public final f0.e.d.f f19757f;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
    public static final class a extends f0.e.d.b {

        /* renamed from: a, reason: collision with root package name */
        public Long f19758a;

        /* renamed from: b, reason: collision with root package name */
        public String f19759b;

        /* renamed from: c, reason: collision with root package name */
        public f0.e.d.a f19760c;

        /* renamed from: d, reason: collision with root package name */
        public f0.e.d.c f19761d;

        /* renamed from: e, reason: collision with root package name */
        public f0.e.d.AbstractC0276d f19762e;

        /* renamed from: f, reason: collision with root package name */
        public f0.e.d.f f19763f;

        public a() {
        }

        @Override // t8.f0.e.d.b
        public f0.e.d build() {
            String strB = this.f19758a == null ? " timestamp" : "";
            if (this.f19759b == null) {
                strB = strB.concat(" type");
            }
            if (this.f19760c == null) {
                strB = ac.c.B(strB, " app");
            }
            if (this.f19761d == null) {
                strB = ac.c.B(strB, " device");
            }
            if (strB.isEmpty()) {
                return new l(this.f19758a.longValue(), this.f19759b, this.f19760c, this.f19761d, this.f19762e, this.f19763f);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.b
        public f0.e.d.b setApp(f0.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f19760c = aVar;
            return this;
        }

        @Override // t8.f0.e.d.b
        public f0.e.d.b setDevice(f0.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f19761d = cVar;
            return this;
        }

        @Override // t8.f0.e.d.b
        public f0.e.d.b setLog(f0.e.d.AbstractC0276d abstractC0276d) {
            this.f19762e = abstractC0276d;
            return this;
        }

        @Override // t8.f0.e.d.b
        public f0.e.d.b setRollouts(f0.e.d.f fVar) {
            this.f19763f = fVar;
            return this;
        }

        @Override // t8.f0.e.d.b
        public f0.e.d.b setTimestamp(long j10) {
            this.f19758a = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.b
        public f0.e.d.b setType(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f19759b = str;
            return this;
        }

        public a(f0.e.d dVar) {
            this.f19758a = Long.valueOf(dVar.getTimestamp());
            this.f19759b = dVar.getType();
            this.f19760c = dVar.getApp();
            this.f19761d = dVar.getDevice();
            this.f19762e = dVar.getLog();
            this.f19763f = dVar.getRollouts();
        }
    }

    public l(long j10, String str, f0.e.d.a aVar, f0.e.d.c cVar, f0.e.d.AbstractC0276d abstractC0276d, f0.e.d.f fVar) {
        this.f19752a = j10;
        this.f19753b = str;
        this.f19754c = aVar;
        this.f19755d = cVar;
        this.f19756e = abstractC0276d;
        this.f19757f = fVar;
    }

    public boolean equals(Object obj) {
        f0.e.d.AbstractC0276d abstractC0276d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d)) {
            return false;
        }
        f0.e.d dVar = (f0.e.d) obj;
        if (this.f19752a == dVar.getTimestamp() && this.f19753b.equals(dVar.getType()) && this.f19754c.equals(dVar.getApp()) && this.f19755d.equals(dVar.getDevice()) && ((abstractC0276d = this.f19756e) != null ? abstractC0276d.equals(dVar.getLog()) : dVar.getLog() == null)) {
            f0.e.d.f fVar = this.f19757f;
            if (fVar == null) {
                if (dVar.getRollouts() == null) {
                    return true;
                }
            } else if (fVar.equals(dVar.getRollouts())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.e.d
    public f0.e.d.a getApp() {
        return this.f19754c;
    }

    @Override // t8.f0.e.d
    public f0.e.d.c getDevice() {
        return this.f19755d;
    }

    @Override // t8.f0.e.d
    public f0.e.d.AbstractC0276d getLog() {
        return this.f19756e;
    }

    @Override // t8.f0.e.d
    public f0.e.d.f getRollouts() {
        return this.f19757f;
    }

    @Override // t8.f0.e.d
    public long getTimestamp() {
        return this.f19752a;
    }

    @Override // t8.f0.e.d
    public String getType() {
        return this.f19753b;
    }

    public int hashCode() {
        long j10 = this.f19752a;
        int iHashCode = (((((((((int) ((j10 >>> 32) ^ j10)) ^ 1000003) * 1000003) ^ this.f19753b.hashCode()) * 1000003) ^ this.f19754c.hashCode()) * 1000003) ^ this.f19755d.hashCode()) * 1000003;
        f0.e.d.AbstractC0276d abstractC0276d = this.f19756e;
        int iHashCode2 = (iHashCode ^ (abstractC0276d == null ? 0 : abstractC0276d.hashCode())) * 1000003;
        f0.e.d.f fVar = this.f19757f;
        return iHashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    @Override // t8.f0.e.d
    public f0.e.d.b toBuilder() {
        return new a(this);
    }

    public String toString() {
        return "Event{timestamp=" + this.f19752a + ", type=" + this.f19753b + ", app=" + this.f19754c + ", device=" + this.f19755d + ", log=" + this.f19756e + ", rollouts=" + this.f19757f + "}";
    }
}
