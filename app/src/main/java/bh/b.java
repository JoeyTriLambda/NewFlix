package bh;

import okio.ByteString;
import zf.i;

/* compiled from: -ByteString.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f4932a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Removed duplicated region for block: B:241:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0091 A[EDGE_INSN: B:244:0x0091->B:66:0x0091 BREAK  A[LOOP:1: B:31:0x004c->B:59:0x0080, LOOP_LABEL: LOOP:0: B:3:0x0008->B:276:0x0008], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int access$codePointIndexToCharIndex(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bh.b.access$codePointIndexToCharIndex(byte[], int):int");
    }

    public static final int access$decodeHexDigit(char c10) {
        boolean z10 = false;
        if ('0' <= c10 && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 <= 'f')) {
            c11 = 'A';
            if ('A' <= c10 && c10 <= 'F') {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException(i.stringPlus("Unexpected hex digit: ", Character.valueOf(c10)));
            }
        }
        return (c10 - c11) + 10;
    }

    public static final void commonWrite(ByteString byteString, ah.c cVar, int i10, int i11) {
        i.checkNotNullParameter(byteString, "<this>");
        i.checkNotNullParameter(cVar, "buffer");
        cVar.write(byteString.getData$okio(), i10, i11);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return f4932a;
    }
}
