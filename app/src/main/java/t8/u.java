package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
/* loaded from: classes.dex */
public final class u extends f0.e.d.c {

    /* renamed from: a, reason: collision with root package name */
    public final Double f19836a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19837b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19838c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19839d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19840e;

    /* renamed from: f, reason: collision with root package name */
    public final long f19841f;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Device.java */
    public static final class a extends f0.e.d.c.a {

        /* renamed from: a, reason: collision with root package name */
        public Double f19842a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f19843b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f19844c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f19845d;

        /* renamed from: e, reason: collision with root package name */
        public Long f19846e;

        /* renamed from: f, reason: collision with root package name */
        public Long f19847f;

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c build() {
            String strB = this.f19843b == null ? " batteryVelocity" : "";
            if (this.f19844c == null) {
                strB = strB.concat(" proximityOn");
            }
            if (this.f19845d == null) {
                strB = ac.c.B(strB, " orientation");
            }
            if (this.f19846e == null) {
                strB = ac.c.B(strB, " ramUsed");
            }
            if (this.f19847f == null) {
                strB = ac.c.B(strB, " diskUsed");
            }
            if (strB.isEmpty()) {
                return new u(this.f19842a, this.f19843b.intValue(), this.f19844c.booleanValue(), this.f19845d.intValue(), this.f19846e.longValue(), this.f19847f.longValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c.a setBatteryLevel(Double d10) {
            this.f19842a = d10;
            return this;
        }

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c.a setBatteryVelocity(int i10) {
            this.f19843b = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c.a setDiskUsed(long j10) {
            this.f19847f = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c.a setOrientation(int i10) {
            this.f19845d = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c.a setProximityOn(boolean z10) {
            this.f19844c = Boolean.valueOf(z10);
            return this;
        }

        @Override // t8.f0.e.d.c.a
        public f0.e.d.c.a setRamUsed(long j10) {
            this.f19846e = Long.valueOf(j10);
            return this;
        }
    }

    public u(Double d10, int i10, boolean z10, int i11, long j10, long j11) {
        this.f19836a = d10;
        this.f19837b = i10;
        this.f19838c = z10;
        this.f19839d = i11;
        this.f19840e = j10;
        this.f19841f = j11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.c)) {
            return false;
        }
        f0.e.d.c cVar = (f0.e.d.c) obj;
        Double d10 = this.f19836a;
        if (d10 != null ? d10.equals(cVar.getBatteryLevel()) : cVar.getBatteryLevel() == null) {
            if (this.f19837b == cVar.getBatteryVelocity() && this.f19838c == cVar.isProximityOn() && this.f19839d == cVar.getOrientation() && this.f19840e == cVar.getRamUsed() && this.f19841f == cVar.getDiskUsed()) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.e.d.c
    public Double getBatteryLevel() {
        return this.f19836a;
    }

    @Override // t8.f0.e.d.c
    public int getBatteryVelocity() {
        return this.f19837b;
    }

    @Override // t8.f0.e.d.c
    public long getDiskUsed() {
        return this.f19841f;
    }

    @Override // t8.f0.e.d.c
    public int getOrientation() {
        return this.f19839d;
    }

    @Override // t8.f0.e.d.c
    public long getRamUsed() {
        return this.f19840e;
    }

    public int hashCode() {
        Double d10 = this.f19836a;
        int iHashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f19837b) * 1000003) ^ (this.f19838c ? 1231 : 1237)) * 1000003) ^ this.f19839d) * 1000003;
        long j10 = this.f19840e;
        long j11 = this.f19841f;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    @Override // t8.f0.e.d.c
    public boolean isProximityOn() {
        return this.f19838c;
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f19836a + ", batteryVelocity=" + this.f19837b + ", proximityOn=" + this.f19838c + ", orientation=" + this.f19839d + ", ramUsed=" + this.f19840e + ", diskUsed=" + this.f19841f + "}";
    }
}
