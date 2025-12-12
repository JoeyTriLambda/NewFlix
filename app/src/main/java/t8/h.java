package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session.java */
/* loaded from: classes.dex */
public final class h extends f0.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f19697a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19698b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19699c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19700d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f19701e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19702f;

    /* renamed from: g, reason: collision with root package name */
    public final f0.e.a f19703g;

    /* renamed from: h, reason: collision with root package name */
    public final f0.e.f f19704h;

    /* renamed from: i, reason: collision with root package name */
    public final f0.e.AbstractC0278e f19705i;

    /* renamed from: j, reason: collision with root package name */
    public final f0.e.c f19706j;

    /* renamed from: k, reason: collision with root package name */
    public final List<f0.e.d> f19707k;

    /* renamed from: l, reason: collision with root package name */
    public final int f19708l;

    /* compiled from: AutoValue_CrashlyticsReport_Session.java */
    public static final class a extends f0.e.b {

        /* renamed from: a, reason: collision with root package name */
        public String f19709a;

        /* renamed from: b, reason: collision with root package name */
        public String f19710b;

        /* renamed from: c, reason: collision with root package name */
        public String f19711c;

        /* renamed from: d, reason: collision with root package name */
        public Long f19712d;

        /* renamed from: e, reason: collision with root package name */
        public Long f19713e;

        /* renamed from: f, reason: collision with root package name */
        public Boolean f19714f;

        /* renamed from: g, reason: collision with root package name */
        public f0.e.a f19715g;

        /* renamed from: h, reason: collision with root package name */
        public f0.e.f f19716h;

        /* renamed from: i, reason: collision with root package name */
        public f0.e.AbstractC0278e f19717i;

        /* renamed from: j, reason: collision with root package name */
        public f0.e.c f19718j;

        /* renamed from: k, reason: collision with root package name */
        public List<f0.e.d> f19719k;

        /* renamed from: l, reason: collision with root package name */
        public Integer f19720l;

        public a() {
        }

        @Override // t8.f0.e.b
        public f0.e build() {
            String strB = this.f19709a == null ? " generator" : "";
            if (this.f19710b == null) {
                strB = strB.concat(" identifier");
            }
            if (this.f19712d == null) {
                strB = ac.c.B(strB, " startedAt");
            }
            if (this.f19714f == null) {
                strB = ac.c.B(strB, " crashed");
            }
            if (this.f19715g == null) {
                strB = ac.c.B(strB, " app");
            }
            if (this.f19720l == null) {
                strB = ac.c.B(strB, " generatorType");
            }
            if (strB.isEmpty()) {
                return new h(this.f19709a, this.f19710b, this.f19711c, this.f19712d.longValue(), this.f19713e, this.f19714f.booleanValue(), this.f19715g, this.f19716h, this.f19717i, this.f19718j, this.f19719k, this.f19720l.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.b
        public f0.e.b setApp(f0.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f19715g = aVar;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setAppQualitySessionId(String str) {
            this.f19711c = str;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setCrashed(boolean z10) {
            this.f19714f = Boolean.valueOf(z10);
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setDevice(f0.e.c cVar) {
            this.f19718j = cVar;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setEndedAt(Long l10) {
            this.f19713e = l10;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setEvents(List<f0.e.d> list) {
            this.f19719k = list;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setGenerator(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f19709a = str;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setGeneratorType(int i10) {
            this.f19720l = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setIdentifier(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f19710b = str;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setOs(f0.e.AbstractC0278e abstractC0278e) {
            this.f19717i = abstractC0278e;
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setStartedAt(long j10) {
            this.f19712d = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.b
        public f0.e.b setUser(f0.e.f fVar) {
            this.f19716h = fVar;
            return this;
        }

        public a(f0.e eVar) {
            this.f19709a = eVar.getGenerator();
            this.f19710b = eVar.getIdentifier();
            this.f19711c = eVar.getAppQualitySessionId();
            this.f19712d = Long.valueOf(eVar.getStartedAt());
            this.f19713e = eVar.getEndedAt();
            this.f19714f = Boolean.valueOf(eVar.isCrashed());
            this.f19715g = eVar.getApp();
            this.f19716h = eVar.getUser();
            this.f19717i = eVar.getOs();
            this.f19718j = eVar.getDevice();
            this.f19719k = eVar.getEvents();
            this.f19720l = Integer.valueOf(eVar.getGeneratorType());
        }
    }

    public h() {
        throw null;
    }

    public h(String str, String str2, String str3, long j10, Long l10, boolean z10, f0.e.a aVar, f0.e.f fVar, f0.e.AbstractC0278e abstractC0278e, f0.e.c cVar, List list, int i10) {
        this.f19697a = str;
        this.f19698b = str2;
        this.f19699c = str3;
        this.f19700d = j10;
        this.f19701e = l10;
        this.f19702f = z10;
        this.f19703g = aVar;
        this.f19704h = fVar;
        this.f19705i = abstractC0278e;
        this.f19706j = cVar;
        this.f19707k = list;
        this.f19708l = i10;
    }

    public boolean equals(Object obj) {
        String str;
        Long l10;
        f0.e.f fVar;
        f0.e.AbstractC0278e abstractC0278e;
        f0.e.c cVar;
        List<f0.e.d> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e)) {
            return false;
        }
        f0.e eVar = (f0.e) obj;
        return this.f19697a.equals(eVar.getGenerator()) && this.f19698b.equals(eVar.getIdentifier()) && ((str = this.f19699c) != null ? str.equals(eVar.getAppQualitySessionId()) : eVar.getAppQualitySessionId() == null) && this.f19700d == eVar.getStartedAt() && ((l10 = this.f19701e) != null ? l10.equals(eVar.getEndedAt()) : eVar.getEndedAt() == null) && this.f19702f == eVar.isCrashed() && this.f19703g.equals(eVar.getApp()) && ((fVar = this.f19704h) != null ? fVar.equals(eVar.getUser()) : eVar.getUser() == null) && ((abstractC0278e = this.f19705i) != null ? abstractC0278e.equals(eVar.getOs()) : eVar.getOs() == null) && ((cVar = this.f19706j) != null ? cVar.equals(eVar.getDevice()) : eVar.getDevice() == null) && ((list = this.f19707k) != null ? list.equals(eVar.getEvents()) : eVar.getEvents() == null) && this.f19708l == eVar.getGeneratorType();
    }

    @Override // t8.f0.e
    public f0.e.a getApp() {
        return this.f19703g;
    }

    @Override // t8.f0.e
    public String getAppQualitySessionId() {
        return this.f19699c;
    }

    @Override // t8.f0.e
    public f0.e.c getDevice() {
        return this.f19706j;
    }

    @Override // t8.f0.e
    public Long getEndedAt() {
        return this.f19701e;
    }

    @Override // t8.f0.e
    public List<f0.e.d> getEvents() {
        return this.f19707k;
    }

    @Override // t8.f0.e
    public String getGenerator() {
        return this.f19697a;
    }

    @Override // t8.f0.e
    public int getGeneratorType() {
        return this.f19708l;
    }

    @Override // t8.f0.e
    public String getIdentifier() {
        return this.f19698b;
    }

    @Override // t8.f0.e
    public f0.e.AbstractC0278e getOs() {
        return this.f19705i;
    }

    @Override // t8.f0.e
    public long getStartedAt() {
        return this.f19700d;
    }

    @Override // t8.f0.e
    public f0.e.f getUser() {
        return this.f19704h;
    }

    public int hashCode() {
        int iHashCode = (((this.f19697a.hashCode() ^ 1000003) * 1000003) ^ this.f19698b.hashCode()) * 1000003;
        String str = this.f19699c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j10 = this.f19700d;
        int i10 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003;
        Long l10 = this.f19701e;
        int iHashCode3 = (((((i10 ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f19702f ? 1231 : 1237)) * 1000003) ^ this.f19703g.hashCode()) * 1000003;
        f0.e.f fVar = this.f19704h;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        f0.e.AbstractC0278e abstractC0278e = this.f19705i;
        int iHashCode5 = (iHashCode4 ^ (abstractC0278e == null ? 0 : abstractC0278e.hashCode())) * 1000003;
        f0.e.c cVar = this.f19706j;
        int iHashCode6 = (iHashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List<f0.e.d> list = this.f19707k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f19708l;
    }

    @Override // t8.f0.e
    public boolean isCrashed() {
        return this.f19702f;
    }

    @Override // t8.f0.e
    public f0.e.b toBuilder() {
        return new a(this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Session{generator=");
        sb2.append(this.f19697a);
        sb2.append(", identifier=");
        sb2.append(this.f19698b);
        sb2.append(", appQualitySessionId=");
        sb2.append(this.f19699c);
        sb2.append(", startedAt=");
        sb2.append(this.f19700d);
        sb2.append(", endedAt=");
        sb2.append(this.f19701e);
        sb2.append(", crashed=");
        sb2.append(this.f19702f);
        sb2.append(", app=");
        sb2.append(this.f19703g);
        sb2.append(", user=");
        sb2.append(this.f19704h);
        sb2.append(", os=");
        sb2.append(this.f19705i);
        sb2.append(", device=");
        sb2.append(this.f19706j);
        sb2.append(", events=");
        sb2.append(this.f19707k);
        sb2.append(", generatorType=");
        return ac.c.m(sb2, this.f19708l, "}");
    }
}
