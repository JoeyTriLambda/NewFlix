package okhttp3.internal.http;

import cz.msebera.android.httpclient.message.TokenParser;
import ig.l;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;
import zf.f;
import zf.i;

/* compiled from: StatusLine.kt */
/* loaded from: classes2.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* compiled from: StatusLine.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final StatusLine get(Response response) {
            i.checkNotNullParameter(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws NumberFormatException, IOException {
            Protocol protocol;
            int i10;
            String strSubstring;
            i.checkNotNullParameter(str, "statusLine");
            if (l.startsWith$default(str, "HTTP/1.", false, 2, null)) {
                i10 = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException(i.stringPlus("Unexpected status line: ", str));
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException(i.stringPlus("Unexpected status line: ", str));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!l.startsWith$default(str, "ICY ", false, 2, null)) {
                    throw new ProtocolException(i.stringPlus("Unexpected status line: ", str));
                }
                protocol = Protocol.HTTP_1_0;
                i10 = 4;
            }
            int i11 = i10 + 3;
            if (str.length() < i11) {
                throw new ProtocolException(i.stringPlus("Unexpected status line: ", str));
            }
            try {
                String strSubstring2 = str.substring(i10, i11);
                i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i12 = Integer.parseInt(strSubstring2);
                if (str.length() <= i11) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i11) != ' ') {
                        throw new ProtocolException(i.stringPlus("Unexpected status line: ", str));
                    }
                    strSubstring = str.substring(i10 + 4);
                    i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new StatusLine(protocol, i12, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(i.stringPlus("Unexpected status line: ", str));
            }
        }
    }

    public StatusLine(Protocol protocol, int i10, String str) {
        i.checkNotNullParameter(protocol, "protocol");
        i.checkNotNullParameter(str, "message");
        this.protocol = protocol;
        this.code = i10;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(TokenParser.SP);
        sb2.append(this.code);
        sb2.append(TokenParser.SP);
        sb2.append(this.message);
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
