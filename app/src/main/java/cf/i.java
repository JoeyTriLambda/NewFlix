package cf;

/* compiled from: Pow2.java */
/* loaded from: classes2.dex */
public final class i {
    public static int roundToPowerOfTwo(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }
}
