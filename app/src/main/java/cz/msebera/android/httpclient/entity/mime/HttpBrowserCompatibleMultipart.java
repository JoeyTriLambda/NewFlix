package cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes2.dex */
class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpBrowserCompatibleMultipart(Charset charset, String str, List<FormBodyPart> list) {
        super(charset, str);
        this.parts = list;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        AbstractMultipartForm.writeField(header.getField("Content-Disposition"), this.charset, outputStream);
        if (formBodyPart.getBody().getFilename() != null) {
            AbstractMultipartForm.writeField(header.getField("Content-Type"), this.charset, outputStream);
        }
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }
}
