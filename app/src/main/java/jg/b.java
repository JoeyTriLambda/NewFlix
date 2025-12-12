package jg;

/* compiled from: DurationJvm.kt */
/* loaded from: classes2.dex */
public final class b {
    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal();
        }
    }

    public static final boolean getDurationAssertionsEnabled() {
        return false;
    }
}
