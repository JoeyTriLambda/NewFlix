package cz.msebera.android.httpclient.message;

import com.fasterxml.jackson.core.JsonPointer;
import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import org.apache.commons.lang3.ClassUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class BasicLineFormatter implements LineFormatter {

    @Deprecated
    public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
    public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();

    public static String formatHeader(Header header, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = INSTANCE;
        }
        return lineFormatter.formatHeader(null, header).toString();
    }

    public static String formatProtocolVersion(ProtocolVersion protocolVersion, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = INSTANCE;
        }
        return lineFormatter.appendProtocolVersion(null, protocolVersion).toString();
    }

    public static String formatRequestLine(RequestLine requestLine, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = INSTANCE;
        }
        return lineFormatter.formatRequestLine(null, requestLine).toString();
    }

    public static String formatStatusLine(StatusLine statusLine, LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = INSTANCE;
        }
        return lineFormatter.formatStatusLine(null, statusLine).toString();
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion) {
        Args.notNull(protocolVersion, "Protocol version");
        int iEstimateProtocolVersionLen = estimateProtocolVersionLen(protocolVersion);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(iEstimateProtocolVersionLen);
        } else {
            charArrayBuffer.ensureCapacity(iEstimateProtocolVersionLen);
        }
        charArrayBuffer.append(protocolVersion.getProtocol());
        charArrayBuffer.append(JsonPointer.SEPARATOR);
        charArrayBuffer.append(Integer.toString(protocolVersion.getMajor()));
        charArrayBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        charArrayBuffer.append(Integer.toString(protocolVersion.getMinor()));
        return charArrayBuffer;
    }

    public void doFormatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        String name = header.getName();
        String value = header.getValue();
        int length = name.length() + 2;
        if (value != null) {
            length += value.length();
        }
        charArrayBuffer.ensureCapacity(length);
        charArrayBuffer.append(name);
        charArrayBuffer.append(": ");
        if (value != null) {
            charArrayBuffer.ensureCapacity(value.length() + charArrayBuffer.length());
            for (int i10 = 0; i10 < value.length(); i10++) {
                char cCharAt = value.charAt(i10);
                if (cCharAt == '\r' || cCharAt == '\n' || cCharAt == '\f' || cCharAt == 11) {
                    cCharAt = TokenParser.SP;
                }
                charArrayBuffer.append(cCharAt);
            }
        }
    }

    public void doFormatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        String method = requestLine.getMethod();
        String uri = requestLine.getUri();
        charArrayBuffer.ensureCapacity(estimateProtocolVersionLen(requestLine.getProtocolVersion()) + uri.length() + method.length() + 1 + 1);
        charArrayBuffer.append(method);
        charArrayBuffer.append(TokenParser.SP);
        charArrayBuffer.append(uri);
        charArrayBuffer.append(TokenParser.SP);
        appendProtocolVersion(charArrayBuffer, requestLine.getProtocolVersion());
    }

    public void doFormatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        int iEstimateProtocolVersionLen = estimateProtocolVersionLen(statusLine.getProtocolVersion()) + 1 + 3 + 1;
        String reasonPhrase = statusLine.getReasonPhrase();
        if (reasonPhrase != null) {
            iEstimateProtocolVersionLen += reasonPhrase.length();
        }
        charArrayBuffer.ensureCapacity(iEstimateProtocolVersionLen);
        appendProtocolVersion(charArrayBuffer, statusLine.getProtocolVersion());
        charArrayBuffer.append(TokenParser.SP);
        charArrayBuffer.append(Integer.toString(statusLine.getStatusCode()));
        charArrayBuffer.append(TokenParser.SP);
        if (reasonPhrase != null) {
            charArrayBuffer.append(reasonPhrase);
        }
    }

    public int estimateProtocolVersionLen(ProtocolVersion protocolVersion) {
        return protocolVersion.getProtocol().length() + 4;
    }

    public CharArrayBuffer initBuffer(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            return new CharArrayBuffer(64);
        }
        charArrayBuffer.clear();
        return charArrayBuffer;
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header) {
        Args.notNull(header, "Header");
        if (header instanceof FormattedHeader) {
            return ((FormattedHeader) header).getBuffer();
        }
        CharArrayBuffer charArrayBufferInitBuffer = initBuffer(charArrayBuffer);
        doFormatHeader(charArrayBufferInitBuffer, header);
        return charArrayBufferInitBuffer;
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine) {
        Args.notNull(requestLine, "Request line");
        CharArrayBuffer charArrayBufferInitBuffer = initBuffer(charArrayBuffer);
        doFormatRequestLine(charArrayBufferInitBuffer, requestLine);
        return charArrayBufferInitBuffer;
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine) {
        Args.notNull(statusLine, "Status line");
        CharArrayBuffer charArrayBufferInitBuffer = initBuffer(charArrayBuffer);
        doFormatStatusLine(charArrayBufferInitBuffer, statusLine);
        return charArrayBufferInitBuffer;
    }
}
