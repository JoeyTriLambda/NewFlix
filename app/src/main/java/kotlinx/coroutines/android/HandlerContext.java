package kotlinx.coroutines.android;

import ac.c;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kg.l;
import kg.n1;
import kg.s0;
import kg.u0;
import kg.y1;
import kotlin.coroutines.CoroutineContext;
import lf.h;
import lg.d;
import zf.f;
import zf.i;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class HandlerContext extends d {
    private volatile HandlerContext _immediate;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f15302m;

    /* renamed from: n, reason: collision with root package name */
    public final String f15303n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f15304o;

    /* renamed from: p, reason: collision with root package name */
    public final HandlerContext f15305p;

    /* compiled from: Runnable.kt */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f15306b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ HandlerContext f15307m;

        public a(l lVar, HandlerContext handlerContext) {
            this.f15306b = lVar;
            this.f15307m = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15306b.resumeUndispatched(this.f15307m, h.f16056a);
        }
    }

    public HandlerContext(Handler handler, String str, boolean z10) {
        super(null);
        this.f15302m = handler;
        this.f15303n = str;
        this.f15304o = z10;
        this._immediate = z10 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f15305p = handlerContext;
    }

    public final void a(CoroutineContext coroutineContext, Runnable runnable) {
        n1.cancel(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        s0.getIO().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f15302m.post(runnable)) {
            return;
        }
        a(coroutineContext, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f15302m == this.f15302m;
    }

    public int hashCode() {
        return System.identityHashCode(this.f15302m);
    }

    @Override // lg.d, kotlinx.coroutines.e
    public u0 invokeOnTimeout(long j10, final Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f15302m.postDelayed(runnable, fg.h.coerceAtMost(j10, 4611686018427387903L))) {
            return new u0() { // from class: lg.c
                @Override // kg.u0
                public final void dispose() {
                    this.f16057b.f15302m.removeCallbacks(runnable);
                }
            };
        }
        a(coroutineContext, runnable);
        return y1.f15173b;
    }

    @Override // kotlinx.coroutines.b
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.f15304o && i.areEqual(Looper.myLooper(), this.f15302m.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.e
    public void scheduleResumeAfterDelay(long j10, l<? super h> lVar) {
        final a aVar = new a(lVar, this);
        if (this.f15302m.postDelayed(aVar, fg.h.coerceAtMost(j10, 4611686018427387903L))) {
            lVar.invokeOnCancellation(new yf.l<Throwable, h>() { // from class: kotlinx.coroutines.android.HandlerContext.scheduleResumeAfterDelay.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                    invoke2(th2);
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    HandlerContext.this.f15302m.removeCallbacks(aVar);
                }
            });
        } else {
            a(lVar.getContext(), aVar);
        }
    }

    @Override // kg.w1, kotlinx.coroutines.b
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        String string = this.f15303n;
        if (string == null) {
            string = this.f15302m.toString();
        }
        return this.f15304o ? c.B(string, ".immediate") : string;
    }

    @Override // kg.w1
    public HandlerContext getImmediate() {
        return this.f15305p;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i10, f fVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
