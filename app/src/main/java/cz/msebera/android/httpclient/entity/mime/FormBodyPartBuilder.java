package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class FormBodyPartBuilder {
    private ContentBody body;
    private final Header header;
    private String name;

    public FormBodyPartBuilder(String str, ContentBody contentBody) {
        this();
        this.name = str;
        this.body = contentBody;
    }

    public static FormBodyPartBuilder create(String str, ContentBody contentBody) {
        return new FormBodyPartBuilder(str, contentBody);
    }

    private static String encodeForHeader(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"' || cCharAt == '\\' || cCharAt == '\r') {
                sb2.append("\\");
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public FormBodyPartBuilder addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
        return this;
    }

    public FormBodyPart build() {
        Asserts.notBlank(this.name, "Name");
        Asserts.notNull(this.body, "Content body");
        Header header = new Header();
        Iterator<MinimalField> it = this.header.getFields().iterator();
        while (it.hasNext()) {
            header.addField(it.next());
        }
        if (header.getField("Content-Disposition") == null) {
            StringBuilder sb2 = new StringBuilder("form-data; name=\"");
            sb2.append(encodeForHeader(this.name));
            sb2.append("\"");
            if (this.body.getFilename() != null) {
                sb2.append("; filename=\"");
                sb2.append(encodeForHeader(this.body.getFilename()));
                sb2.append("\"");
            }
            header.addField(new MinimalField("Content-Disposition", sb2.toString()));
        }
        if (header.getField("Content-Type") == null) {
            ContentBody contentBody = this.body;
            ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
            if (contentType != null) {
                header.addField(new MinimalField("Content-Type", contentType.toString()));
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.body.getMimeType());
                if (this.body.getCharset() != null) {
                    sb3.append(HTTP.CHARSET_PARAM);
                    sb3.append(this.body.getCharset());
                }
                header.addField(new MinimalField("Content-Type", sb3.toString()));
            }
        }
        if (header.getField(MIME.CONTENT_TRANSFER_ENC) == null) {
            header.addField(new MinimalField(MIME.CONTENT_TRANSFER_ENC, this.body.getTransferEncoding()));
        }
        return new FormBodyPart(this.name, this.body, header);
    }

    public FormBodyPartBuilder removeFields(String str) {
        Args.notNull(str, "Field name");
        this.header.removeFields(str);
        return this;
    }

    public FormBodyPartBuilder setBody(ContentBody contentBody) {
        this.body = contentBody;
        return this;
    }

    public FormBodyPartBuilder setField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.setField(new MinimalField(str, str2));
        return this;
    }

    public FormBodyPartBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public static FormBodyPartBuilder create() {
        return new FormBodyPartBuilder();
    }

    public FormBodyPartBuilder() {
        this.header = new Header();
    }
}
