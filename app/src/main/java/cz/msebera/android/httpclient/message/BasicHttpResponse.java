package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.ReasonPhraseCatalog;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;

/* loaded from: classes2.dex */
public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    private int code;
    private HttpEntity entity;
    private Locale locale;
    private final ReasonPhraseCatalog reasonCatalog;
    private String reasonPhrase;
    private StatusLine statusline;
    private ProtocolVersion ver;

    public BasicHttpResponse(StatusLine statusLine, ReasonPhraseCatalog reasonPhraseCatalog, Locale locale) {
        this.statusline = (StatusLine) Args.notNull(statusLine, "Status line");
        this.ver = statusLine.getProtocolVersion();
        this.code = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
        this.reasonCatalog = reasonPhraseCatalog;
        this.locale = locale;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public Locale getLocale() {
        return this.locale;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.ver;
    }

    public String getReason(int i10) {
        ReasonPhraseCatalog reasonPhraseCatalog = this.reasonCatalog;
        if (reasonPhraseCatalog == null) {
            return null;
        }
        Locale locale = this.locale;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return reasonPhraseCatalog.getReason(i10, locale);
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public StatusLine getStatusLine() {
        if (this.statusline == null) {
            ProtocolVersion protocolVersion = this.ver;
            if (protocolVersion == null) {
                protocolVersion = HttpVersion.HTTP_1_1;
            }
            int i10 = this.code;
            String reason = this.reasonPhrase;
            if (reason == null) {
                reason = getReason(i10);
            }
            this.statusline = new BasicStatusLine(protocolVersion, i10, reason);
        }
        return this.statusline;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setLocale(Locale locale) {
        this.locale = (Locale) Args.notNull(locale, "Locale");
        this.statusline = null;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setReasonPhrase(String str) {
        this.statusline = null;
        if (TextUtils.isBlank(str)) {
            str = null;
        }
        this.reasonPhrase = str;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusCode(int i10) {
        Args.notNegative(i10, "Status code");
        this.statusline = null;
        this.code = i10;
        this.reasonPhrase = null;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(StatusLine statusLine) {
        this.statusline = (StatusLine) Args.notNull(statusLine, "Status line");
        this.ver = statusLine.getProtocolVersion();
        this.code = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getStatusLine());
        sb2.append(TokenParser.SP);
        sb2.append(this.headergroup);
        if (this.entity != null) {
            sb2.append(TokenParser.SP);
            sb2.append(this.entity);
        }
        return sb2.toString();
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion, int i10) {
        Args.notNegative(i10, "Status code");
        this.statusline = null;
        this.ver = protocolVersion;
        this.code = i10;
        this.reasonPhrase = null;
    }

    public BasicHttpResponse(StatusLine statusLine) {
        this.statusline = (StatusLine) Args.notNull(statusLine, "Status line");
        this.ver = statusLine.getProtocolVersion();
        this.code = statusLine.getStatusCode();
        this.reasonPhrase = statusLine.getReasonPhrase();
        this.reasonCatalog = null;
        this.locale = null;
    }

    @Override // cz.msebera.android.httpclient.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion, int i10, String str) {
        Args.notNegative(i10, "Status code");
        this.statusline = null;
        this.ver = protocolVersion;
        this.code = i10;
        this.reasonPhrase = str;
    }

    public BasicHttpResponse(ProtocolVersion protocolVersion, int i10, String str) {
        Args.notNegative(i10, "Status code");
        this.statusline = null;
        this.ver = protocolVersion;
        this.code = i10;
        this.reasonPhrase = str;
        this.reasonCatalog = null;
        this.locale = null;
    }
}
