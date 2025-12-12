package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class AuthSchemeBase implements ContextAwareAuthScheme {
    protected ChallengeState challengeState;

    @Deprecated
    public AuthSchemeBase(ChallengeState challengeState) {
        this.challengeState = challengeState;
    }

    @Override // cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return authenticate(credentials, httpRequest);
    }

    public ChallengeState getChallengeState() {
        return this.challengeState;
    }

    public boolean isProxy() {
        ChallengeState challengeState = this.challengeState;
        return challengeState != null && challengeState == ChallengeState.PROXY;
    }

    public abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i10, int i11) throws MalformedChallengeException;

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        CharArrayBuffer charArrayBuffer;
        int valuePos;
        Args.notNull(header, "Header");
        String name = header.getName();
        if (name.equalsIgnoreCase("WWW-Authenticate")) {
            this.challengeState = ChallengeState.TARGET;
        } else {
            if (!name.equalsIgnoreCase("Proxy-Authenticate")) {
                throw new MalformedChallengeException("Unexpected header name: ".concat(name));
            }
            this.challengeState = ChallengeState.PROXY;
        }
        if (header instanceof FormattedHeader) {
            FormattedHeader formattedHeader = (FormattedHeader) header;
            charArrayBuffer = formattedHeader.getBuffer();
            valuePos = formattedHeader.getValuePos();
        } else {
            String value = header.getValue();
            if (value == null) {
                throw new MalformedChallengeException("Header value is null");
            }
            charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            valuePos = 0;
        }
        while (valuePos < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(valuePos))) {
            valuePos++;
        }
        int i10 = valuePos;
        while (i10 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i10))) {
            i10++;
        }
        String strSubstring = charArrayBuffer.substring(valuePos, i10);
        if (!strSubstring.equalsIgnoreCase(getSchemeName())) {
            throw new MalformedChallengeException("Invalid scheme identifier: ".concat(strSubstring));
        }
        parseChallenge(charArrayBuffer, i10, charArrayBuffer.length());
    }

    public String toString() {
        String schemeName = getSchemeName();
        return schemeName != null ? schemeName.toUpperCase(Locale.ROOT) : super.toString();
    }

    public AuthSchemeBase() {
    }
}
