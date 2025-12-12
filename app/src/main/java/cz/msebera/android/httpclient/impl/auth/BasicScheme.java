package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class BasicScheme extends RFC2617Scheme {
    private static final long serialVersionUID = -1931571557597830536L;
    private boolean complete;

    public BasicScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "basic";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        return this.complete;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public String toString() {
        return "BASIC [complete=" + this.complete + "]";
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(credentials.getUserPrincipal().getName());
        sb2.append(":");
        sb2.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] bArrEncode = Base64.encode(EncodingUtils.getBytes(sb2.toString(), getCredentialsCharset(httpRequest)), 2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (isProxy()) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(bArrEncode, 0, bArrEncode.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Deprecated
    public BasicScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public BasicScheme() {
        this(Consts.ASCII);
    }

    @Deprecated
    public static Header authenticate(Credentials credentials, String str, boolean z10) {
        Args.notNull(credentials, "Credentials");
        Args.notNull(str, "charset");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(credentials.getUserPrincipal().getName());
        sb2.append(":");
        sb2.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] bArrEncode = Base64.encode(EncodingUtils.getBytes(sb2.toString(), str), 2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (z10) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(bArrEncode, 0, bArrEncode.length);
        return new BufferedHeader(charArrayBuffer);
    }
}
