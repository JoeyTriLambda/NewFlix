package pg;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes2.dex */
public final class m {
    public static final void checkParallelism(int i10) {
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(ac.c.f("Expected positive parallelism level, but got ", i10).toString());
        }
    }
}
