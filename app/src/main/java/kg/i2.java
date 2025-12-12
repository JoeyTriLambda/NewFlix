package kg;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    public static final i2 f15113a = new i2();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<y0> f15114b = pg.f0.commonThreadLocal(new pg.b0("ThreadLocalEventLoop"));

    public final y0 currentOrNull$kotlinx_coroutines_core() {
        return f15114b.get();
    }

    public final y0 getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal<y0> threadLocal = f15114b;
        y0 y0Var = threadLocal.get();
        if (y0Var != null) {
            return y0Var;
        }
        y0 y0VarCreateEventLoop = z0.createEventLoop();
        threadLocal.set(y0VarCreateEventLoop);
        return y0VarCreateEventLoop;
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        f15114b.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(y0 y0Var) {
        f15114b.set(y0Var);
    }
}
