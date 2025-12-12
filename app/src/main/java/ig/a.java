package ig;

/* compiled from: CharJVM.kt */
/* loaded from: classes2.dex */
public class a {
    public static final int checkRadix(int i10) {
        if (new fg.c(2, 36).contains(i10)) {
            return i10;
        }
        StringBuilder sbS = ac.c.s("radix ", i10, " was not in valid range ");
        sbS.append(new fg.c(2, 36));
        throw new IllegalArgumentException(sbS.toString());
    }

    public static final int digitOf(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }

    public static final boolean isWhitespace(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }
}
