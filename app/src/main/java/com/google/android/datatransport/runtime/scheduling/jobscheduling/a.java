package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;

/* compiled from: AutoValue_SchedulerConfig.java */
/* loaded from: classes.dex */
public final class a extends SchedulerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final a5.a f5696a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Priority, SchedulerConfig.b> f5697b;

    public a(a5.a aVar, Map<Priority, SchedulerConfig.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f5696a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f5697b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public final a5.a a() {
        return this.f5696a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public final Map<Priority, SchedulerConfig.b> b() {
        return this.f5697b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f5696a.equals(schedulerConfig.a()) && this.f5697b.equals(schedulerConfig.b());
    }

    public int hashCode() {
        return ((this.f5696a.hashCode() ^ 1000003) * 1000003) ^ this.f5697b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f5696a + ", values=" + this.f5697b + "}";
    }
}
