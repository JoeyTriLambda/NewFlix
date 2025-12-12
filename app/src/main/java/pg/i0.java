package pg;

import kg.h2;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContext.kt */
/* loaded from: classes2.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f17705a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f17706b;

    /* renamed from: c, reason: collision with root package name */
    public final h2<Object>[] f17707c;

    /* renamed from: d, reason: collision with root package name */
    public int f17708d;

    public i0(CoroutineContext coroutineContext, int i10) {
        this.f17705a = coroutineContext;
        this.f17706b = new Object[i10];
        this.f17707c = new h2[i10];
    }

    public final void append(h2<?> h2Var, Object obj) {
        int i10 = this.f17708d;
        this.f17706b[i10] = obj;
        this.f17708d = i10 + 1;
        zf.i.checkNotNull(h2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        this.f17707c[i10] = h2Var;
    }

    public final void restore(CoroutineContext coroutineContext) {
        h2<Object>[] h2VarArr = this.f17707c;
        int length = h2VarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            h2<Object> h2Var = h2VarArr[length];
            zf.i.checkNotNull(h2Var);
            h2Var.restoreThreadContext(coroutineContext, this.f17706b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
