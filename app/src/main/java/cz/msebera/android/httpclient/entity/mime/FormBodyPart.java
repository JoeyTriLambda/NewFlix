package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;

/* loaded from: classes2.dex */
public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody, Header header) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = header == null ? new Header() : header;
    }

    public void addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
    }

    @Deprecated
    public void generateContentDisp(ContentBody contentBody) {
        StringBuilder sb2 = new StringBuilder("form-data; name=\"");
        sb2.append(getName());
        sb2.append("\"");
        if (contentBody.getFilename() != null) {
            sb2.append("; filename=\"");
            sb2.append(contentBody.getFilename());
            sb2.append("\"");
        }
        addField("Content-Disposition", sb2.toString());
    }

    @Deprecated
    public void generateContentType(ContentBody contentBody) {
        ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
        if (contentType != null) {
            addField("Content-Type", contentType.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            sb2.append(HTTP.CHARSET_PARAM);
            sb2.append(contentBody.getCharset());
        }
        addField("Content-Type", sb2.toString());
    }

    @Deprecated
    public void generateTransferEncoding(ContentBody contentBody) {
        addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String getName() {
        return this.name;
    }

    @Deprecated
    public FormBodyPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = new Header();
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }
}
