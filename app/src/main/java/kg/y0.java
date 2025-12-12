package kg;

import java.lang.reflect.InvocationTargetException;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public abstract class y0 extends kotlinx.coroutines.b {

    /* renamed from: m, reason: collision with root package name */
    public long f15170m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15171n;

    /* renamed from: o, reason: collision with root package name */
    public mf.f<p0<?>> f15172o;

    public static /* synthetic */ void decrementUseCount$default(y0 y0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        y0Var.decrementUseCount(z10);
    }

    public static /* synthetic */ void incrementUseCount$default(y0 y0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        y0Var.incrementUseCount(z10);
    }

    public final void decrementUseCount(boolean z10) {
        long j10 = this.f15170m - (z10 ? 4294967296L : 1L);
        this.f15170m = j10;
        if (j10 <= 0 && this.f15171n) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(p0<?> p0Var) {
        mf.f<p0<?>> fVar = this.f15172o;
        if (fVar == null) {
            fVar = new mf.f<>();
            this.f15172o = fVar;
        }
        fVar.addLast(p0Var);
    }

    public long getNextTime() {
        mf.f<p0<?>> fVar = this.f15172o;
        return (fVar == null || fVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void incrementUseCount(boolean z10) {
        this.f15170m = (z10 ? 4294967296L : 1L) + this.f15170m;
        if (z10) {
            return;
        }
        this.f15171n = true;
    }

    public final boolean isUnconfinedLoopActive() {
        return this.f15170m >= 4294967296L;
    }

    public final boolean isUnconfinedQueueEmpty() {
        mf.f<p0<?>> fVar = this.f15172o;
        if (fVar != null) {
            return fVar.isEmpty();
        }
        return true;
    }

    @Override // kotlinx.coroutines.b
    public final kotlinx.coroutines.b limitedParallelism(int i10) {
        pg.m.checkParallelism(i10);
        return this;
    }

    public long processNextEvent() {
        return !processUnconfinedEvent() ? Long.MAX_VALUE : 0L;
    }

    public final boolean processUnconfinedEvent() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p0<?> p0VarRemoveFirstOrNull;
        mf.f<p0<?>> fVar = this.f15172o;
        if (fVar == null || (p0VarRemoveFirstOrNull = fVar.removeFirstOrNull()) == null) {
            return false;
        }
        p0VarRemoveFirstOrNull.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }
}
