package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.ContentTooLongException;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final cz.msebera.android.httpclient.Header contentType;
    private final AbstractMultipartForm multipart;

    public MultipartFormEntity(AbstractMultipartForm abstractMultipartForm, ContentType contentType, long j10) {
        this.multipart = abstractMultipartForm;
        this.contentType = new BasicHeader("Content-Type", contentType.toString());
        this.contentLength = j10;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        long j10 = this.contentLength;
        if (j10 < 0) {
            throw new ContentTooLongException("Content length is unknown");
        }
        if (j10 > 25600) {
            throw new ContentTooLongException("Content length is too long: " + this.contentLength);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public cz.msebera.android.httpclient.Header getContentEncoding() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public cz.msebera.android.httpclient.Header getContentType() {
        return this.contentType;
    }

    public AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return !isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return this.contentLength != -1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return !isRepeatable();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.multipart.writeTo(outputStream);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() {
    }
}
