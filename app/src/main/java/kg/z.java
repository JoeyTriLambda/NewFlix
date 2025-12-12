package kg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
/* loaded from: classes2.dex */
public class z {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15174b = AtomicIntegerFieldUpdater.newUpdater(z.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f15175a;

    public z(Throwable th2, boolean z10) {
        this.f15175a = th2;
        this._handled = z10 ? 1 : 0;
    }

    public final boolean getHandled() {
        return f15174b.get(this) != 0;
    }

    public final boolean makeHandled() {
        return f15174b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return i0.getClassSimpleName(this) + '[' + this.f15175a + ']';
    }

    public /* synthetic */ z(Throwable th2, boolean z10, int i10, zf.f fVar) {
        this(th2, (i10 & 2) != 0 ? false : z10);
    }
}
