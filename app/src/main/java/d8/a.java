package d8;

import b8.e;

/* compiled from: Ints.java */
/* loaded from: classes.dex */
public final class a {
    public static int constrainToRange(int i10, int i11, int i12) {
        e.checkArgument(i11 <= i12, "min (%s) must be less than or equal to max (%s)", i11, i12);
        return Math.min(Math.max(i10, i11), i12);
    }

    public static int saturatedCast(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }
}
