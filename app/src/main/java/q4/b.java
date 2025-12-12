package q4;

import java.util.Map;
import q4.i;

/* compiled from: AutoValue_EventInternal.java */
/* loaded from: classes.dex */
public final class b extends i {

    /* renamed from: a, reason: collision with root package name */
    public final String f17822a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f17823b;

    /* renamed from: c, reason: collision with root package name */
    public final h f17824c;

    /* renamed from: d, reason: collision with root package name */
    public final long f17825d;

    /* renamed from: e, reason: collision with root package name */
    public final long f17826e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f17827f;

    /* compiled from: AutoValue_EventInternal.java */
    public static final class a extends i.a {

        /* renamed from: a, reason: collision with root package name */
        public String f17828a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f17829b;

        /* renamed from: c, reason: collision with root package name */
        public h f17830c;

        /* renamed from: d, reason: collision with root package name */
        public Long f17831d;

        /* renamed from: e, reason: collision with root package name */
        public Long f17832e;

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f17833f;

        @Override // q4.i.a
        public i build() {
            String strB = this.f17828a == null ? " transportName" : "";
            if (this.f17830c == null) {
                strB = strB.concat(" encodedPayload");
            }
            if (this.f17831d == null) {
                strB = ac.c.B(strB, " eventMillis");
            }
            if (this.f17832e == null) {
                strB = ac.c.B(strB, " uptimeMillis");
            }
            if (this.f17833f == null) {
                strB = ac.c.B(strB, " autoMetadata");
            }
            if (strB.isEmpty()) {
                return new b(this.f17828a, this.f17829b, this.f17830c, this.f17831d.longValue(), this.f17832e.longValue(), this.f17833f);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // q4.i.a
        public Map<String, String> getAutoMetadata() {
            Map<String, String> map = this.f17833f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // q4.i.a
        public i.a setAutoMetadata(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f17833f = map;
            return this;
        }

        @Override // q4.i.a
        public i.a setCode(Integer num) {
            this.f17829b = num;
            return this;
        }

        @Override // q4.i.a
        public i.a setEncodedPayload(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f17830c = hVar;
            return this;
        }

        @Override // q4.i.a
        public i.a setEventMillis(long j10) {
            this.f17831d = Long.valueOf(j10);
            return this;
        }

        @Override // q4.i.a
        public i.a setTransportName(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f17828a = str;
            return this;
        }

        @Override // q4.i.a
        public i.a setUptimeMillis(long j10) {
            this.f17832e = Long.valueOf(j10);
            return this;
        }
    }

    public b(String str, Integer num, h hVar, long j10, long j11, Map map) {
        this.f17822a = str;
        this.f17823b = num;
        this.f17824c = hVar;
        this.f17825d = j10;
        this.f17826e = j11;
        this.f17827f = map;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f17822a.equals(iVar.getTransportName()) && ((num = this.f17823b) != null ? num.equals(iVar.getCode()) : iVar.getCode() == null) && this.f17824c.equals(iVar.getEncodedPayload()) && this.f17825d == iVar.getEventMillis() && this.f17826e == iVar.getUptimeMillis() && this.f17827f.equals(iVar.getAutoMetadata());
    }

    @Override // q4.i
    public Map<String, String> getAutoMetadata() {
        return this.f17827f;
    }

    @Override // q4.i
    public Integer getCode() {
        return this.f17823b;
    }

    @Override // q4.i
    public h getEncodedPayload() {
        return this.f17824c;
    }

    @Override // q4.i
    public long getEventMillis() {
        return this.f17825d;
    }

    @Override // q4.i
    public String getTransportName() {
        return this.f17822a;
    }

    @Override // q4.i
    public long getUptimeMillis() {
        return this.f17826e;
    }

    public int hashCode() {
        int iHashCode = (this.f17822a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f17823b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f17824c.hashCode()) * 1000003;
        long j10 = this.f17825d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f17826e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f17827f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f17822a + ", code=" + this.f17823b + ", encodedPayload=" + this.f17824c + ", eventMillis=" + this.f17825d + ", uptimeMillis=" + this.f17826e + ", autoMetadata=" + this.f17827f + "}";
    }
}
