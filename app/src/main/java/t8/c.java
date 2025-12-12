package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo.java */
/* loaded from: classes.dex */
public final class c extends f0.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f19642a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19643b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19644c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19645d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19646e;

    /* renamed from: f, reason: collision with root package name */
    public final long f19647f;

    /* renamed from: g, reason: collision with root package name */
    public final long f19648g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19649h;

    /* renamed from: i, reason: collision with root package name */
    public final List<f0.a.AbstractC0261a> f19650i;

    /* compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo.java */
    public static final class a extends f0.a.b {

        /* renamed from: a, reason: collision with root package name */
        public Integer f19651a;

        /* renamed from: b, reason: collision with root package name */
        public String f19652b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f19653c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f19654d;

        /* renamed from: e, reason: collision with root package name */
        public Long f19655e;

        /* renamed from: f, reason: collision with root package name */
        public Long f19656f;

        /* renamed from: g, reason: collision with root package name */
        public Long f19657g;

        /* renamed from: h, reason: collision with root package name */
        public String f19658h;

        /* renamed from: i, reason: collision with root package name */
        public List<f0.a.AbstractC0261a> f19659i;

        @Override // t8.f0.a.b
        public f0.a build() {
            String strB = this.f19651a == null ? " pid" : "";
            if (this.f19652b == null) {
                strB = strB.concat(" processName");
            }
            if (this.f19653c == null) {
                strB = ac.c.B(strB, " reasonCode");
            }
            if (this.f19654d == null) {
                strB = ac.c.B(strB, " importance");
            }
            if (this.f19655e == null) {
                strB = ac.c.B(strB, " pss");
            }
            if (this.f19656f == null) {
                strB = ac.c.B(strB, " rss");
            }
            if (this.f19657g == null) {
                strB = ac.c.B(strB, " timestamp");
            }
            if (strB.isEmpty()) {
                return new c(this.f19651a.intValue(), this.f19652b, this.f19653c.intValue(), this.f19654d.intValue(), this.f19655e.longValue(), this.f19656f.longValue(), this.f19657g.longValue(), this.f19658h, this.f19659i);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.a.b
        public f0.a.b setBuildIdMappingForArch(List<f0.a.AbstractC0261a> list) {
            this.f19659i = list;
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setImportance(int i10) {
            this.f19654d = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setPid(int i10) {
            this.f19651a = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setProcessName(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f19652b = str;
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setPss(long j10) {
            this.f19655e = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setReasonCode(int i10) {
            this.f19653c = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setRss(long j10) {
            this.f19656f = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setTimestamp(long j10) {
            this.f19657g = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.a.b
        public f0.a.b setTraceFile(String str) {
            this.f19658h = str;
            return this;
        }
    }

    public c() {
        throw null;
    }

    public c(int i10, String str, int i11, int i12, long j10, long j11, long j12, String str2, List list) {
        this.f19642a = i10;
        this.f19643b = str;
        this.f19644c = i11;
        this.f19645d = i12;
        this.f19646e = j10;
        this.f19647f = j11;
        this.f19648g = j12;
        this.f19649h = str2;
        this.f19650i = list;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.a)) {
            return false;
        }
        f0.a aVar = (f0.a) obj;
        if (this.f19642a == aVar.getPid() && this.f19643b.equals(aVar.getProcessName()) && this.f19644c == aVar.getReasonCode() && this.f19645d == aVar.getImportance() && this.f19646e == aVar.getPss() && this.f19647f == aVar.getRss() && this.f19648g == aVar.getTimestamp() && ((str = this.f19649h) != null ? str.equals(aVar.getTraceFile()) : aVar.getTraceFile() == null)) {
            List<f0.a.AbstractC0261a> list = this.f19650i;
            if (list == null) {
                if (aVar.getBuildIdMappingForArch() == null) {
                    return true;
                }
            } else if (list.equals(aVar.getBuildIdMappingForArch())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.a
    public List<f0.a.AbstractC0261a> getBuildIdMappingForArch() {
        return this.f19650i;
    }

    @Override // t8.f0.a
    public int getImportance() {
        return this.f19645d;
    }

    @Override // t8.f0.a
    public int getPid() {
        return this.f19642a;
    }

    @Override // t8.f0.a
    public String getProcessName() {
        return this.f19643b;
    }

    @Override // t8.f0.a
    public long getPss() {
        return this.f19646e;
    }

    @Override // t8.f0.a
    public int getReasonCode() {
        return this.f19644c;
    }

    @Override // t8.f0.a
    public long getRss() {
        return this.f19647f;
    }

    @Override // t8.f0.a
    public long getTimestamp() {
        return this.f19648g;
    }

    @Override // t8.f0.a
    public String getTraceFile() {
        return this.f19649h;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f19642a ^ 1000003) * 1000003) ^ this.f19643b.hashCode()) * 1000003) ^ this.f19644c) * 1000003) ^ this.f19645d) * 1000003;
        long j10 = this.f19646e;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f19647f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f19648g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str = this.f19649h;
        int iHashCode2 = (i12 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<f0.a.AbstractC0261a> list = this.f19650i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f19642a + ", processName=" + this.f19643b + ", reasonCode=" + this.f19644c + ", importance=" + this.f19645d + ", pss=" + this.f19646e + ", rss=" + this.f19647f + ", timestamp=" + this.f19648g + ", traceFile=" + this.f19649h + ", buildIdMappingForArch=" + this.f19650i + "}";
    }
}
