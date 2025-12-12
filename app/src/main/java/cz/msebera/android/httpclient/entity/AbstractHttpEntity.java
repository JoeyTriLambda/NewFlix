package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return this.chunked;
    }

    public void setChunked(boolean z10) {
        this.chunked = z10;
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        if (this.contentType != null) {
            sb2.append("Content-Type: ");
            sb2.append(this.contentType.getValue());
            sb2.append(',');
        }
        if (this.contentEncoding != null) {
            sb2.append("Content-Encoding: ");
            sb2.append(this.contentEncoding.getValue());
            sb2.append(',');
        }
        long contentLength = getContentLength();
        if (contentLength >= 0) {
            sb2.append("Content-Length: ");
            sb2.append(contentLength);
            sb2.append(',');
        }
        sb2.append("Chunked: ");
        sb2.append(this.chunked);
        sb2.append(']');
        return sb2.toString();
    }

    public void setContentEncoding(String str) {
        setContentEncoding(str != null ? new BasicHeader("Content-Encoding", str) : null);
    }

    public void setContentType(String str) {
        setContentType(str != null ? new BasicHeader("Content-Type", str) : null);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
    }
}
