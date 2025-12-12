package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;
import zf.i;

/* compiled from: Credentials.kt */
/* loaded from: classes2.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        i.checkNotNullParameter(str, "username");
        i.checkNotNullParameter(str2, "password");
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            i.checkNotNullExpressionValue(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        i.checkNotNullParameter(str, "username");
        i.checkNotNullParameter(str2, "password");
        i.checkNotNullParameter(charset, "charset");
        return i.stringPlus("Basic ", ByteString.f17101o.encodeString(str + ':' + str2, charset).base64());
    }
}
