package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
/* loaded from: classes.dex */
public final class k extends f0.e.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f19734a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19735b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19736c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19737d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19738e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19739f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19740g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19741h;

    /* renamed from: i, reason: collision with root package name */
    public final String f19742i;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
    public static final class a extends f0.e.c.a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f19743a;

        /* renamed from: b, reason: collision with root package name */
        public String f19744b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f19745c;

        /* renamed from: d, reason: collision with root package name */
        public Long f19746d;

        /* renamed from: e, reason: collision with root package name */
        public Long f19747e;

        /* renamed from: f, reason: collision with root package name */
        public Boolean f19748f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f19749g;

        /* renamed from: h, reason: collision with root package name */
        public String f19750h;

        /* renamed from: i, reason: collision with root package name */
        public String f19751i;

        @Override // t8.f0.e.c.a
        public f0.e.c build() {
            String strB = this.f19743a == null ? " arch" : "";
            if (this.f19744b == null) {
                strB = strB.concat(" model");
            }
            if (this.f19745c == null) {
                strB = ac.c.B(strB, " cores");
            }
            if (this.f19746d == null) {
                strB = ac.c.B(strB, " ram");
            }
            if (this.f19747e == null) {
                strB = ac.c.B(strB, " diskSpace");
            }
            if (this.f19748f == null) {
                strB = ac.c.B(strB, " simulator");
            }
            if (this.f19749g == null) {
                strB = ac.c.B(strB, " state");
            }
            if (this.f19750h == null) {
                strB = ac.c.B(strB, " manufacturer");
            }
            if (this.f19751i == null) {
                strB = ac.c.B(strB, " modelClass");
            }
            if (strB.isEmpty()) {
                return new k(this.f19743a.intValue(), this.f19744b, this.f19745c.intValue(), this.f19746d.longValue(), this.f19747e.longValue(), this.f19748f.booleanValue(), this.f19749g.intValue(), this.f19750h, this.f19751i);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setArch(int i10) {
            this.f19743a = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setCores(int i10) {
            this.f19745c = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setDiskSpace(long j10) {
            this.f19747e = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setManufacturer(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f19750h = str;
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setModel(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f19744b = str;
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setModelClass(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f19751i = str;
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setRam(long j10) {
            this.f19746d = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setSimulator(boolean z10) {
            this.f19748f = Boolean.valueOf(z10);
            return this;
        }

        @Override // t8.f0.e.c.a
        public f0.e.c.a setState(int i10) {
            this.f19749g = Integer.valueOf(i10);
            return this;
        }
    }

    public k(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f19734a = i10;
        this.f19735b = str;
        this.f19736c = i11;
        this.f19737d = j10;
        this.f19738e = j11;
        this.f19739f = z10;
        this.f19740g = i12;
        this.f19741h = str2;
        this.f19742i = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.c)) {
            return false;
        }
        f0.e.c cVar = (f0.e.c) obj;
        return this.f19734a == cVar.getArch() && this.f19735b.equals(cVar.getModel()) && this.f19736c == cVar.getCores() && this.f19737d == cVar.getRam() && this.f19738e == cVar.getDiskSpace() && this.f19739f == cVar.isSimulator() && this.f19740g == cVar.getState() && this.f19741h.equals(cVar.getManufacturer()) && this.f19742i.equals(cVar.getModelClass());
    }

    @Override // t8.f0.e.c
    public int getArch() {
        return this.f19734a;
    }

    @Override // t8.f0.e.c
    public int getCores() {
        return this.f19736c;
    }

    @Override // t8.f0.e.c
    public long getDiskSpace() {
        return this.f19738e;
    }

    @Override // t8.f0.e.c
    public String getManufacturer() {
        return this.f19741h;
    }

    @Override // t8.f0.e.c
    public String getModel() {
        return this.f19735b;
    }

    @Override // t8.f0.e.c
    public String getModelClass() {
        return this.f19742i;
    }

    @Override // t8.f0.e.c
    public long getRam() {
        return this.f19737d;
    }

    @Override // t8.f0.e.c
    public int getState() {
        return this.f19740g;
    }

    public int hashCode() {
        int iHashCode = (((((this.f19734a ^ 1000003) * 1000003) ^ this.f19735b.hashCode()) * 1000003) ^ this.f19736c) * 1000003;
        long j10 = this.f19737d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f19738e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f19739f ? 1231 : 1237)) * 1000003) ^ this.f19740g) * 1000003) ^ this.f19741h.hashCode()) * 1000003) ^ this.f19742i.hashCode();
    }

    @Override // t8.f0.e.c
    public boolean isSimulator() {
        return this.f19739f;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Device{arch=");
        sb2.append(this.f19734a);
        sb2.append(", model=");
        sb2.append(this.f19735b);
        sb2.append(", cores=");
        sb2.append(this.f19736c);
        sb2.append(", ram=");
        sb2.append(this.f19737d);
        sb2.append(", diskSpace=");
        sb2.append(this.f19738e);
        sb2.append(", simulator=");
        sb2.append(this.f19739f);
        sb2.append(", state=");
        sb2.append(this.f19740g);
        sb2.append(", manufacturer=");
        sb2.append(this.f19741h);
        sb2.append(", modelClass=");
        return ac.c.o(sb2, this.f19742i, "}");
    }
}
