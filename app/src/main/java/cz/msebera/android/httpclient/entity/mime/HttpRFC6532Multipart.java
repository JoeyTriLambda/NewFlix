package cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class HttpRFC6532Multipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpRFC6532Multipart(Charset charset, String str, List<FormBodyPart> list) {
        super(charset, str);
        this.parts = list;
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Iterator<MinimalField> it = formBodyPart.getHeader().iterator();
        while (it.hasNext()) {
            AbstractMultipartForm.writeField(it.next(), MIME.UTF8_CHARSET, outputStream);
        }
    }

    @Override // cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }
}
