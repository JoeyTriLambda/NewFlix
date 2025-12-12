package ah;

/* compiled from: -JvmPlatform.kt */
/* loaded from: classes2.dex */
public final class c0 {
    public static final byte[] asUtf8ToByteArray(String str) {
        zf.i.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(ig.c.f13440b);
        zf.i.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String toUtf8String(byte[] bArr) {
        zf.i.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, ig.c.f13440b);
    }
}
