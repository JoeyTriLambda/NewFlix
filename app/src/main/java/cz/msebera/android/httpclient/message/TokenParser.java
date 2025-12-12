package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.BitSet;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class TokenParser {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final char HT = '\t';
    public static final TokenParser INSTANCE = new TokenParser();
    public static final char LF = '\n';
    public static final char SP = ' ';

    public static BitSet INIT_BITSET(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i10 : iArr) {
            bitSet.set(i10);
        }
        return bitSet;
    }

    public static boolean isWhitespace(char c10) {
        return c10 == ' ' || c10 == '\t' || c10 == '\r' || c10 == '\n';
    }

    public void copyContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb2) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(cCharAt)) || isWhitespace(cCharAt)) {
                break;
            }
            pos++;
            sb2.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    public void copyQuotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, StringBuilder sb2) {
        if (parserCursor.atEnd()) {
            return;
        }
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        if (charArrayBuffer.charAt(pos) != '\"') {
            return;
        }
        int i10 = pos + 1;
        int i11 = pos2 + 1;
        boolean z10 = false;
        while (true) {
            if (i11 >= upperBound) {
                break;
            }
            char cCharAt = charArrayBuffer.charAt(i11);
            if (z10) {
                if (cCharAt != '\"' && cCharAt != '\\') {
                    sb2.append(ESCAPE);
                }
                sb2.append(cCharAt);
                z10 = false;
            } else if (cCharAt == '\"') {
                i10++;
                break;
            } else if (cCharAt == '\\') {
                z10 = true;
            } else if (cCharAt != '\r' && cCharAt != '\n') {
                sb2.append(cCharAt);
            }
            i11++;
            i10++;
        }
        parserCursor.updatePos(i10);
    }

    public void copyUnquotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb2) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(cCharAt)) || isWhitespace(cCharAt) || cCharAt == '\"') {
                break;
            }
            pos++;
            sb2.append(cCharAt);
        }
        parserCursor.updatePos(pos);
    }

    public String parseToken(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb2 = new StringBuilder();
        loop0: while (true) {
            boolean z10 = false;
            while (!parserCursor.atEnd()) {
                char cCharAt = charArrayBuffer.charAt(parserCursor.getPos());
                if (bitSet != null && bitSet.get(cCharAt)) {
                    break loop0;
                }
                if (isWhitespace(cCharAt)) {
                    skipWhiteSpace(charArrayBuffer, parserCursor);
                    z10 = true;
                } else {
                    if (z10 && sb2.length() > 0) {
                        sb2.append(SP);
                    }
                    copyContent(charArrayBuffer, parserCursor, bitSet, sb2);
                }
            }
            break loop0;
        }
        return sb2.toString();
    }

    public String parseValue(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb2 = new StringBuilder();
        loop0: while (true) {
            boolean z10 = false;
            while (!parserCursor.atEnd()) {
                char cCharAt = charArrayBuffer.charAt(parserCursor.getPos());
                if (bitSet != null && bitSet.get(cCharAt)) {
                    break loop0;
                }
                if (isWhitespace(cCharAt)) {
                    skipWhiteSpace(charArrayBuffer, parserCursor);
                    z10 = true;
                } else if (cCharAt == '\"') {
                    if (z10 && sb2.length() > 0) {
                        sb2.append(SP);
                    }
                    copyQuotedContent(charArrayBuffer, parserCursor, sb2);
                } else {
                    if (z10 && sb2.length() > 0) {
                        sb2.append(SP);
                    }
                    copyUnquotedContent(charArrayBuffer, parserCursor, bitSet, sb2);
                }
            }
            break loop0;
        }
        return sb2.toString();
    }

    public void skipWhiteSpace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound && isWhitespace(charArrayBuffer.charAt(pos2)); pos2++) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }
}
