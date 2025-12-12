package de;

import java.io.DataInputStream;
import java.io.IOException;
import mf.h;
import zf.i;

/* loaded from: classes2.dex */
public abstract class a {
    public static final byte[] a(int i10) {
        byte[] bArr = new byte[4];
        for (int i11 = 0; i11 < 4; i11++) {
            bArr[i11] = (byte) (i10 >> (i11 * 8));
        }
        return bArr;
    }

    public static final long b(DataInputStream dataInputStream) throws IOException {
        i.checkNotNullParameter(dataInputStream, "<this>");
        dataInputStream.readFully(new byte[8]);
        return (r1[0] & 255) | (r1[7] << 56) | ((r1[6] & 255) << 48) | ((r1[5] & 255) << 40) | ((r1[4] & 255) << 32) | ((r1[3] & 255) << 24) | ((r1[2] & 255) << 16) | ((r1[1] & 255) << 8);
    }

    public static final String c(DataInputStream dataInputStream) throws IOException {
        i.checkNotNullParameter(dataInputStream, "<this>");
        byte[] bArr = new byte[a(dataInputStream)];
        dataInputStream.readFully(bArr);
        return new String(bArr, ig.c.f13440b);
    }

    public static final byte[] a(String str) {
        i.checkNotNullParameter(str, "<this>");
        byte[] bArrPlus = h.plus(new byte[0], a(str.length()));
        byte[] bytes = str.getBytes(ig.c.f13440b);
        i.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return h.plus(bArrPlus, bytes);
    }

    public static final int a(DataInputStream dataInputStream) throws IOException {
        i.checkNotNullParameter(dataInputStream, "<this>");
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return (bArr[3] << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }
}
