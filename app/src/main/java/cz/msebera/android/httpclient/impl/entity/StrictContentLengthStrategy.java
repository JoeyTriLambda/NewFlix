package cz.msebera.android.httpclient.impl.entity;

import ac.c;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
    private final int implicitLen;

    public StrictContentLengthStrategy(int i10) {
        this.implicitLen = i10;
    }

    @Override // cz.msebera.android.httpclient.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws NumberFormatException, HttpException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (!HTTP.CHUNK_CODING.equalsIgnoreCase(value)) {
                if (HTTP.IDENTITY_CODING.equalsIgnoreCase(value)) {
                    return -1L;
                }
                throw new ProtocolException(c.j("Unsupported transfer encoding: ", value));
            }
            if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                return -2L;
            }
            throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage.getProtocolVersion());
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
        if (firstHeader2 == null) {
            return this.implicitLen;
        }
        String value2 = firstHeader2.getValue();
        try {
            long j10 = Long.parseLong(value2);
            if (j10 >= 0) {
                return j10;
            }
            throw new ProtocolException("Negative content length: " + value2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException(c.j("Invalid content length: ", value2));
        }
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }
}
