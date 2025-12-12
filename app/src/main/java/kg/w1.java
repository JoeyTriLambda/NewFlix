package kg;

/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes2.dex */
public abstract class w1 extends kotlinx.coroutines.b {
    public abstract w1 getImmediate();

    @Override // kotlinx.coroutines.b
    public kotlinx.coroutines.b limitedParallelism(int i10) {
        pg.m.checkParallelism(i10);
        return this;
    }

    @Override // kotlinx.coroutines.b
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        return i0.getClassSimpleName(this) + '@' + i0.getHexAddress(this);
    }

    public final String toStringInternalImpl() {
        w1 immediate;
        w1 main = s0.getMain();
        if (this == main) {
            return "Dispatchers.Main";
        }
        try {
            immediate = main.getImmediate();
        } catch (UnsupportedOperationException unused) {
            immediate = null;
        }
        if (this == immediate) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
