package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import ac.c;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* loaded from: classes.dex */
public final class b extends SchedulerConfig.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f5698a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5699b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<SchedulerConfig.Flag> f5700c;

    /* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    public static final class a extends SchedulerConfig.b.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f5701a;

        /* renamed from: b, reason: collision with root package name */
        public Long f5702b;

        /* renamed from: c, reason: collision with root package name */
        public Set<SchedulerConfig.Flag> f5703c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b build() {
            String strB = this.f5701a == null ? " delta" : "";
            if (this.f5702b == null) {
                strB = strB.concat(" maxAllowedDelay");
            }
            if (this.f5703c == null) {
                strB = c.B(strB, " flags");
            }
            if (strB.isEmpty()) {
                return new b(this.f5701a.longValue(), this.f5702b.longValue(), this.f5703c);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a setDelta(long j10) {
            this.f5701a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a setFlags(Set<SchedulerConfig.Flag> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f5703c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a setMaxAllowedDelay(long j10) {
            this.f5702b = Long.valueOf(j10);
            return this;
        }
    }

    public b(long j10, long j11, Set set) {
        this.f5698a = j10;
        this.f5699b = j11;
        this.f5700c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public final long a() {
        return this.f5698a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public final Set<SchedulerConfig.Flag> b() {
        return this.f5700c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public final long c() {
        return this.f5699b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        return this.f5698a == bVar.a() && this.f5699b == bVar.c() && this.f5700c.equals(bVar.b());
    }

    public int hashCode() {
        long j10 = this.f5698a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f5699b;
        return this.f5700c.hashCode() ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f5698a + ", maxAllowedDelay=" + this.f5699b + ", flags=" + this.f5700c + "}";
    }
}
