package kotlin.time;

import java.util.concurrent.TimeUnit;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes2.dex */
public enum DurationUnit {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    /* JADX INFO: Fake field, exist only in values array */
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);


    /* renamed from: b, reason: collision with root package name */
    public final TimeUnit f15285b;

    DurationUnit(TimeUnit timeUnit) {
        this.f15285b = timeUnit;
    }

    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.f15285b;
    }
}
