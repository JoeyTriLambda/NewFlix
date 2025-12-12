package okhttp3.logging;

import ah.c;
import fg.h;
import java.io.EOFException;
import zf.i;

/* compiled from: utf8.kt */
/* loaded from: classes2.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(c cVar) {
        i.checkNotNullParameter(cVar, "<this>");
        try {
            c cVar2 = new c();
            cVar.copyTo(cVar2, 0L, h.coerceAtMost(cVar.size(), 64L));
            int i10 = 0;
            while (i10 < 16) {
                i10++;
                if (cVar2.exhausted()) {
                    return true;
                }
                int utf8CodePoint = cVar2.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
