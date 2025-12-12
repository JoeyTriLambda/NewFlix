package okhttp3.internal.http;

import ah.e;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import zf.i;

/* compiled from: RealResponseBody.kt */
/* loaded from: classes2.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final e source;

    public RealResponseBody(String str, long j10, e eVar) {
        i.checkNotNullParameter(eVar, "source");
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str == null) {
            return null;
        }
        return MediaType.Companion.parse(str);
    }

    @Override // okhttp3.ResponseBody
    public e source() {
        return this.source;
    }
}
