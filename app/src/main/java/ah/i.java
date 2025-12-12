package ah;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.kt */
/* loaded from: classes2.dex */
public final class i extends z {

    /* renamed from: a, reason: collision with root package name */
    public z f692a;

    public i(z zVar) {
        zf.i.checkNotNullParameter(zVar, "delegate");
        this.f692a = zVar;
    }

    @Override // ah.z
    public z clearDeadline() {
        return this.f692a.clearDeadline();
    }

    @Override // ah.z
    public z clearTimeout() {
        return this.f692a.clearTimeout();
    }

    @Override // ah.z
    public long deadlineNanoTime() {
        return this.f692a.deadlineNanoTime();
    }

    public final z delegate() {
        return this.f692a;
    }

    @Override // ah.z
    public boolean hasDeadline() {
        return this.f692a.hasDeadline();
    }

    public final i setDelegate(z zVar) {
        zf.i.checkNotNullParameter(zVar, "delegate");
        this.f692a = zVar;
        return this;
    }

    @Override // ah.z
    public void throwIfReached() throws IOException {
        this.f692a.throwIfReached();
    }

    @Override // ah.z
    public z timeout(long j10, TimeUnit timeUnit) {
        zf.i.checkNotNullParameter(timeUnit, "unit");
        return this.f692a.timeout(j10, timeUnit);
    }

    @Override // ah.z
    public long timeoutNanos() {
        return this.f692a.timeoutNanos();
    }

    @Override // ah.z
    public z deadlineNanoTime(long j10) {
        return this.f692a.deadlineNanoTime(j10);
    }
}
