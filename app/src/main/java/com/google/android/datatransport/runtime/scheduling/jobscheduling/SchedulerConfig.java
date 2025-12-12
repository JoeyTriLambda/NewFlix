package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.b;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

@AutoValue
/* loaded from: classes.dex */
public abstract class SchedulerConfig {

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public a5.a f5694a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f5695b = new HashMap();

        public a addConfig(Priority priority, b bVar) {
            this.f5695b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig build() {
            if (this.f5694a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f5695b.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            HashMap map = this.f5695b;
            this.f5695b = new HashMap();
            return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(this.f5694a, map);
        }

        public a setClock(a5.a aVar) {
            this.f5694a = aVar;
            return this;
        }
    }

    @AutoValue
    public static abstract class b {

        @AutoValue.Builder
        public static abstract class a {
            public abstract b build();

            public abstract a setDelta(long j10);

            public abstract a setFlags(Set<Flag> set);

            public abstract a setMaxAllowedDelay(long j10);
        }

        public static a builder() {
            return new b.a().setFlags(Collections.emptySet());
        }

        public abstract long a();

        public abstract Set<Flag> b();

        public abstract long c();
    }

    public static a builder() {
        return new a();
    }

    public static SchedulerConfig getDefault(a5.a aVar) {
        return builder().addConfig(Priority.DEFAULT, b.builder().setDelta(30000L).setMaxAllowedDelay(DateUtils.MILLIS_PER_DAY).build()).addConfig(Priority.HIGHEST, b.builder().setDelta(1000L).setMaxAllowedDelay(DateUtils.MILLIS_PER_DAY).build()).addConfig(Priority.VERY_LOW, b.builder().setDelta(DateUtils.MILLIS_PER_DAY).setMaxAllowedDelay(DateUtils.MILLIS_PER_DAY).setFlags(Collections.unmodifiableSet(new HashSet(Arrays.asList(Flag.DEVICE_IDLE)))).build()).setClock(aVar).build();
    }

    public abstract a5.a a();

    public abstract Map<Priority, b> b();

    public JobInfo.Builder configureJob(JobInfo.Builder builder, Priority priority, long j10, int i10) {
        builder.setMinimumLatency(getScheduleDelay(priority, j10, i10));
        Set<Flag> setB = b().get(priority).b();
        if (setB.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (setB.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (setB.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
        return builder;
    }

    public long getScheduleDelay(Priority priority, long j10, int i10) {
        long time = j10 - a().getTime();
        b bVar = b().get(priority);
        long jA = bVar.a();
        return Math.min(Math.max((long) (Math.pow(3.0d, i10 - 1) * jA * Math.max(1.0d, Math.log(10000.0d) / Math.log((jA > 1 ? jA : 2L) * r12))), time), bVar.c());
    }
}
