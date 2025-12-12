package cz.msebera.android.httpclient.entity;

import ac.c;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f10716b;

    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.f10716b = bArr;
        this.off = 0;
        this.len = bArr.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.f10716b, this.off, this.len);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return this.len;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.f10716b, this.off, this.len);
        outputStream.flush();
    }

    public ByteArrayEntity(byte[] bArr, int i10, int i11, ContentType contentType) {
        int i12;
        Args.notNull(bArr, "Source byte array");
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) >= 0 && i12 <= bArr.length) {
            this.content = bArr;
            this.f10716b = bArr;
            this.off = i10;
            this.len = i11;
            if (contentType != null) {
                setContentType(contentType.toString());
                return;
            }
            return;
        }
        StringBuilder sbT = c.t("off: ", i10, " len: ", i11, " b.length: ");
        sbT.append(bArr.length);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public ByteArrayEntity(byte[] bArr) {
        this(bArr, null);
    }

    public ByteArrayEntity(byte[] bArr, int i10, int i11) {
        this(bArr, i10, i11, null);
    }
}
