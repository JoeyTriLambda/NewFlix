package cz.msebera.android.httpclient.impl.auth;

import ac.c;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;

    /* renamed from: a1, reason: collision with root package name */
    private String f10717a1;

    /* renamed from: a2, reason: collision with root package name */
    private String f10718a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    private Header createDigestHeader(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        String str;
        String str2;
        char c10;
        String str3;
        String str4;
        String str5;
        String str6;
        String string;
        String str7;
        String str8;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String str9 = "MD5";
        String parameter7 = getParameter("qop");
        if (parameter7 != null) {
            str = "algorithm";
            str2 = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            c10 = ((httpRequest instanceof HttpEntityEnclosingRequest) && hashSet.contains("auth-int")) ? (char) 1 : hashSet.contains("auth") ? (char) 2 : (char) 65535;
        } else {
            str = "algorithm";
            str2 = "qop";
            c10 = 0;
        }
        if (c10 == 65535) {
            throw new AuthenticationException(c.j("None of the qop methods is supported: ", parameter7));
        }
        String parameter8 = getParameter("charset");
        if (parameter8 == null) {
            parameter8 = "ISO-8859-1";
        }
        if (parameter6.equalsIgnoreCase("MD5-sess")) {
            str3 = "auth-int";
        } else {
            str3 = "auth-int";
            str9 = parameter6;
        }
        try {
            MessageDigest messageDigestCreateMessageDigest = createMessageDigest(str9);
            String name = credentials.getUserPrincipal().getName();
            String password = credentials.getPassword();
            if (parameter3.equals(this.lastNonce)) {
                str4 = parameter;
                this.nounceCount++;
            } else {
                str4 = parameter;
                this.nounceCount = 1L;
                this.cnonce = null;
                this.lastNonce = parameter3;
            }
            StringBuilder sb2 = new StringBuilder(256);
            Formatter formatter = new Formatter(sb2, Locale.US);
            char c11 = c10;
            formatter.format("%08x", Long.valueOf(this.nounceCount));
            formatter.close();
            String string2 = sb2.toString();
            if (this.cnonce == null) {
                this.cnonce = createCnonce();
            }
            this.f10717a1 = null;
            this.f10718a2 = null;
            if (parameter6.equalsIgnoreCase("MD5-sess")) {
                sb2.setLength(0);
                sb2.append(name);
                sb2.append(':');
                sb2.append(parameter2);
                sb2.append(':');
                sb2.append(password);
                String strEncode = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(sb2.toString(), parameter8)));
                sb2.setLength(0);
                sb2.append(strEncode);
                sb2.append(':');
                sb2.append(parameter3);
                sb2.append(':');
                sb2.append(this.cnonce);
                this.f10717a1 = sb2.toString();
            } else {
                sb2.setLength(0);
                sb2.append(name);
                sb2.append(':');
                sb2.append(parameter2);
                sb2.append(':');
                sb2.append(password);
                this.f10717a1 = sb2.toString();
            }
            String strEncode2 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(this.f10717a1, parameter8)));
            char c12 = c11;
            if (c12 == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(parameter5);
                sb3.append(':');
                str5 = str4;
                sb3.append(str5);
                this.f10718a2 = sb3.toString();
                str6 = "auth";
            } else {
                str5 = str4;
                if (c12 == 1) {
                    HttpEntity entity = httpRequest instanceof HttpEntityEnclosingRequest ? ((HttpEntityEnclosingRequest) httpRequest).getEntity() : null;
                    if (entity == null || entity.isRepeatable()) {
                        str6 = "auth";
                        HttpEntityDigester httpEntityDigester = new HttpEntityDigester(messageDigestCreateMessageDigest);
                        if (entity != null) {
                            try {
                                entity.writeTo(httpEntityDigester);
                            } catch (IOException e10) {
                                throw new AuthenticationException("I/O error reading entity content", e10);
                            }
                        }
                        httpEntityDigester.close();
                        this.f10718a2 = parameter5 + ':' + str5 + ':' + encode(httpEntityDigester.getDigest());
                    } else {
                        str6 = "auth";
                        if (!hashSet.contains(str6)) {
                            throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                        }
                        this.f10718a2 = parameter5 + ':' + str5;
                        c12 = 2;
                    }
                } else {
                    str6 = "auth";
                    this.f10718a2 = parameter5 + ':' + str5;
                }
            }
            String strEncode3 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getBytes(this.f10718a2, parameter8)));
            if (c12 == 0) {
                sb2.setLength(0);
                sb2.append(strEncode2);
                sb2.append(':');
                sb2.append(parameter3);
                sb2.append(':');
                sb2.append(strEncode3);
                string = sb2.toString();
            } else {
                sb2.setLength(0);
                sb2.append(strEncode2);
                sb2.append(':');
                sb2.append(parameter3);
                sb2.append(':');
                sb2.append(string2);
                sb2.append(':');
                sb2.append(this.cnonce);
                sb2.append(':');
                sb2.append(c12 == 1 ? str3 : str6);
                sb2.append(':');
                sb2.append(strEncode3);
                string = sb2.toString();
            }
            String strEncode4 = encode(messageDigestCreateMessageDigest.digest(EncodingUtils.getAsciiBytes(string)));
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
            if (isProxy()) {
                charArrayBuffer.append("Proxy-Authorization");
            } else {
                charArrayBuffer.append("Authorization");
            }
            charArrayBuffer.append(": Digest ");
            ArrayList arrayList = new ArrayList(20);
            arrayList.add(new BasicNameValuePair("username", name));
            arrayList.add(new BasicNameValuePair("realm", parameter2));
            arrayList.add(new BasicNameValuePair("nonce", parameter3));
            arrayList.add(new BasicNameValuePair("uri", str5));
            arrayList.add(new BasicNameValuePair("response", strEncode4));
            if (c12 != 0) {
                if (c12 == 1) {
                    str7 = str2;
                    str8 = str3;
                } else {
                    str8 = str6;
                    str7 = str2;
                }
                arrayList.add(new BasicNameValuePair(str7, str8));
                arrayList.add(new BasicNameValuePair("nc", string2));
                arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
            } else {
                str7 = str2;
            }
            String str10 = str;
            arrayList.add(new BasicNameValuePair(str10, parameter6));
            if (parameter4 != null) {
                arrayList.add(new BasicNameValuePair("opaque", parameter4));
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i10);
                if (i10 > 0) {
                    charArrayBuffer.append(", ");
                }
                String name2 = basicNameValuePair.getName();
                BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(charArrayBuffer, basicNameValuePair, !("nc".equals(name2) || str7.equals(name2) || str10.equals(name2)));
            }
            return new BufferedHeader(charArrayBuffer);
        } catch (UnsupportedDigestAlgorithmException unused) {
            throw new AuthenticationException("Unsuppported digest algorithm: ".concat(str9));
        }
    }

    private static MessageDigest createMessageDigest(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException(c.j("Unsupported algorithm in HTTP Digest authentication: ", str));
        }
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i10 = 0; i10 < length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i11] = cArr2[(b10 & 240) >> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    public String getA1() {
        return this.f10717a1;
    }

    public String getA2() {
        return this.f10718a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
        if (getParameters().isEmpty()) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public String toString() {
        return "DIGEST [complete=" + this.complete + ", nonce=" + this.lastNonce + ", nc=" + this.nounceCount + "]";
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        if (getParameter("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        }
        if (getParameter("nonce") == null) {
            throw new AuthenticationException("missing nonce in challenge");
        }
        getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
        getParameters().put("uri", httpRequest.getRequestLine().getUri());
        if (getParameter("charset") == null) {
            getParameters().put("charset", getCredentialsCharset(httpRequest));
        }
        return createDigestHeader(credentials, httpRequest);
    }

    @Deprecated
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestScheme() {
        this(Consts.ASCII);
    }
}
