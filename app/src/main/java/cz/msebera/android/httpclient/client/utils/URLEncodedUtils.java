package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* loaded from: classes2.dex */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final BitSet PATHSAFE;
    private static final char PATH_SEPARATOR = '/';
    private static final BitSet PATH_SEPARATORS;
    private static final BitSet PATH_SPECIAL;
    private static final BitSet PUNCT;
    private static final char QP_SEP_A = '&';
    private static final char QP_SEP_S = ';';
    private static final int RADIX = 16;
    private static final BitSet RESERVED;
    private static final BitSet UNRESERVED;
    private static final BitSet URIC;
    private static final BitSet URLENCODER;
    private static final BitSet USERINFO;

    static {
        BitSet bitSet = new BitSet(256);
        PATH_SEPARATORS = bitSet;
        bitSet.set(47);
        UNRESERVED = new BitSet(256);
        PUNCT = new BitSet(256);
        USERINFO = new BitSet(256);
        PATHSAFE = new BitSet(256);
        URIC = new BitSet(256);
        RESERVED = new BitSet(256);
        URLENCODER = new BitSet(256);
        PATH_SPECIAL = new BitSet(256);
        for (int i10 = 97; i10 <= 122; i10++) {
            UNRESERVED.set(i10);
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            UNRESERVED.set(i11);
        }
        for (int i12 = 48; i12 <= 57; i12++) {
            UNRESERVED.set(i12);
        }
        BitSet bitSet2 = UNRESERVED;
        bitSet2.set(95);
        bitSet2.set(45);
        bitSet2.set(46);
        bitSet2.set(42);
        URLENCODER.or(bitSet2);
        bitSet2.set(33);
        bitSet2.set(126);
        bitSet2.set(39);
        bitSet2.set(40);
        bitSet2.set(41);
        BitSet bitSet3 = PUNCT;
        bitSet3.set(44);
        bitSet3.set(59);
        bitSet3.set(58);
        bitSet3.set(36);
        bitSet3.set(38);
        bitSet3.set(43);
        bitSet3.set(61);
        BitSet bitSet4 = USERINFO;
        bitSet4.or(bitSet2);
        bitSet4.or(bitSet3);
        BitSet bitSet5 = PATHSAFE;
        bitSet5.or(bitSet2);
        bitSet5.set(59);
        bitSet5.set(58);
        bitSet5.set(64);
        bitSet5.set(38);
        bitSet5.set(61);
        bitSet5.set(43);
        bitSet5.set(36);
        bitSet5.set(44);
        BitSet bitSet6 = PATH_SPECIAL;
        bitSet6.or(bitSet5);
        bitSet6.set(47);
        BitSet bitSet7 = RESERVED;
        bitSet7.set(59);
        bitSet7.set(47);
        bitSet7.set(63);
        bitSet7.set(58);
        bitSet7.set(64);
        bitSet7.set(38);
        bitSet7.set(61);
        bitSet7.set(43);
        bitSet7.set(36);
        bitSet7.set(44);
        bitSet7.set(91);
        bitSet7.set(93);
        BitSet bitSet8 = URIC;
        bitSet8.or(bitSet7);
        bitSet8.or(bitSet2);
    }

    private static List<NameValuePair> createEmptyList() {
        return new ArrayList(0);
    }

    private static String decodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlDecode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, true);
    }

    public static String encPath(String str, Charset charset) {
        return urlEncode(str, charset, PATH_SPECIAL, false);
    }

    public static String encUric(String str, Charset charset) {
        return urlEncode(str, charset, URIC, false);
    }

    public static String encUserInfo(String str, Charset charset) {
        return urlEncode(str, charset, USERINFO, false);
    }

    private static String encodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        return urlEncode(str, str2 != null ? Charset.forName(str2) : Consts.UTF_8, URLENCODER, true);
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        return format(list, QP_SEP_A, str);
    }

    public static String formatSegments(Iterable<String> iterable, Charset charset) {
        Args.notNull(iterable, "Segments");
        StringBuilder sb2 = new StringBuilder();
        for (String str : iterable) {
            sb2.append('/');
            sb2.append(urlEncode(str, charset, PATHSAFE, false));
        }
        return sb2.toString();
    }

    public static boolean isEncoded(HttpEntity httpEntity) throws ParseException {
        Args.notNull(httpEntity, "HTTP entity");
        Header contentType = httpEntity.getContentType();
        if (contentType != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return elements[0].getName().equalsIgnoreCase(CONTENT_TYPE);
            }
        }
        return false;
    }

    @Deprecated
    public static List<NameValuePair> parse(URI uri, String str) {
        return parse(uri, str != null ? Charset.forName(str) : null);
    }

    public static List<String> parsePathSegments(CharSequence charSequence, Charset charset) {
        Args.notNull(charSequence, "Char sequence");
        List<String> listSplitPathSegments = splitPathSegments(charSequence);
        for (int i10 = 0; i10 < listSplitPathSegments.size(); i10++) {
            listSplitPathSegments.set(i10, urlDecode(listSplitPathSegments.get(i10), charset != null ? charset : Consts.UTF_8, false));
        }
        return listSplitPathSegments;
    }

    public static List<String> splitPathSegments(CharSequence charSequence) {
        return splitSegments(charSequence, PATH_SEPARATORS);
    }

    public static List<String> splitSegments(CharSequence charSequence, BitSet bitSet) {
        ParserCursor parserCursor = new ParserCursor(0, charSequence.length());
        if (parserCursor.atEnd()) {
            return Collections.emptyList();
        }
        if (bitSet.get(charSequence.charAt(parserCursor.getPos()))) {
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        while (!parserCursor.atEnd()) {
            char cCharAt = charSequence.charAt(parserCursor.getPos());
            if (bitSet.get(cCharAt)) {
                arrayList.add(sb2.toString());
                sb2.setLength(0);
            } else {
                sb2.append(cCharAt);
            }
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        arrayList.add(sb2.toString());
        return arrayList;
    }

    private static String urlDecode(String str, Charset charset, boolean z10) {
        if (str == null) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(str.length());
        CharBuffer charBufferWrap = CharBuffer.wrap(str);
        while (charBufferWrap.hasRemaining()) {
            char c10 = charBufferWrap.get();
            if (c10 == '%' && charBufferWrap.remaining() >= 2) {
                char c11 = charBufferWrap.get();
                char c12 = charBufferWrap.get();
                int iDigit = Character.digit(c11, 16);
                int iDigit2 = Character.digit(c12, 16);
                if (iDigit == -1 || iDigit2 == -1) {
                    byteBufferAllocate.put((byte) 37);
                    byteBufferAllocate.put((byte) c11);
                    byteBufferAllocate.put((byte) c12);
                } else {
                    byteBufferAllocate.put((byte) ((iDigit << 4) + iDigit2));
                }
            } else if (z10 && c10 == '+') {
                byteBufferAllocate.put((byte) 32);
            } else {
                byteBufferAllocate.put((byte) c10);
            }
        }
        byteBufferAllocate.flip();
        return charset.decode(byteBufferAllocate).toString();
    }

    private static String urlEncode(String str, Charset charset, BitSet bitSet, boolean z10) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        ByteBuffer byteBufferEncode = charset.encode(str);
        while (byteBufferEncode.hasRemaining()) {
            int i10 = byteBufferEncode.get() & 255;
            if (bitSet.get(i10)) {
                sb2.append((char) i10);
            } else if (z10 && i10 == 32) {
                sb2.append('+');
            } else {
                sb2.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((i10 >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(i10 & 15, 16));
                sb2.append(upperCase);
                sb2.append(upperCase2);
            }
        }
        return sb2.toString();
    }

    private static String decodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlDecode(str, charset, true);
    }

    private static String encodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Consts.UTF_8;
        }
        return urlEncode(str, charset, URLENCODER, true);
    }

    public static String format(List<? extends NameValuePair> list, char c10, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String strEncodeFormFields = encodeFormFields(nameValuePair.getName(), str);
            String strEncodeFormFields2 = encodeFormFields(nameValuePair.getValue(), str);
            if (sb2.length() > 0) {
                sb2.append(c10);
            }
            sb2.append(strEncodeFormFields);
            if (strEncodeFormFields2 != null) {
                sb2.append(NAME_VALUE_SEPARATOR);
                sb2.append(strEncodeFormFields2);
            }
        }
        return sb2.toString();
    }

    public static List<NameValuePair> parse(URI uri, Charset charset) {
        Args.notNull(uri, "URI");
        String rawQuery = uri.getRawQuery();
        return (rawQuery == null || rawQuery.isEmpty()) ? createEmptyList() : parse(rawQuery, charset);
    }

    public static List<String> parsePathSegments(CharSequence charSequence) {
        return parsePathSegments(charSequence, Consts.UTF_8);
    }

    public static String formatSegments(String... strArr) {
        return formatSegments(Arrays.asList(strArr), Consts.UTF_8);
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity) throws UnsupportedOperationException, ParseException, IOException, UnsupportedCharsetException {
        Args.notNull(httpEntity, "HTTP entity");
        ContentType contentType = ContentType.get(httpEntity);
        if (contentType != null && contentType.getMimeType().equalsIgnoreCase(CONTENT_TYPE)) {
            long contentLength = httpEntity.getContentLength();
            Args.check(contentLength <= 2147483647L, "HTTP entity is too large");
            Charset charset = contentType.getCharset() != null ? contentType.getCharset() : HTTP.DEF_CONTENT_CHARSET;
            InputStream content = httpEntity.getContent();
            if (content == null) {
                return createEmptyList();
            }
            try {
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength > 0 ? (int) contentLength : 1024);
                InputStreamReader inputStreamReader = new InputStreamReader(content, charset);
                char[] cArr = new char[1024];
                while (true) {
                    int i10 = inputStreamReader.read(cArr);
                    if (i10 == -1) {
                        break;
                    }
                    charArrayBuffer.append(cArr, 0, i10);
                }
                content.close();
                if (charArrayBuffer.isEmpty()) {
                    return createEmptyList();
                }
                return parse(charArrayBuffer, charset, QP_SEP_A);
            } catch (Throwable th2) {
                content.close();
                throw th2;
            }
        }
        return createEmptyList();
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        return format(iterable, QP_SEP_A, charset);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, char c10, Charset charset) {
        Args.notNull(iterable, "Parameters");
        StringBuilder sb2 = new StringBuilder();
        for (NameValuePair nameValuePair : iterable) {
            String strEncodeFormFields = encodeFormFields(nameValuePair.getName(), charset);
            String strEncodeFormFields2 = encodeFormFields(nameValuePair.getValue(), charset);
            if (sb2.length() > 0) {
                sb2.append(c10);
            }
            sb2.append(strEncodeFormFields);
            if (strEncodeFormFields2 != null) {
                sb2.append(NAME_VALUE_SEPARATOR);
                sb2.append(strEncodeFormFields2);
            }
        }
        return sb2.toString();
    }

    @Deprecated
    public static void parse(List<NameValuePair> list, Scanner scanner, String str) {
        parse(list, scanner, "[&;]", str);
    }

    @Deprecated
    public static void parse(List<NameValuePair> list, Scanner scanner, String str, String str2) {
        String strDecodeFormFields;
        String strDecodeFormFields2;
        scanner.useDelimiter(str);
        while (scanner.hasNext()) {
            String next = scanner.next();
            int iIndexOf = next.indexOf(NAME_VALUE_SEPARATOR);
            if (iIndexOf != -1) {
                strDecodeFormFields = decodeFormFields(next.substring(0, iIndexOf).trim(), str2);
                strDecodeFormFields2 = decodeFormFields(next.substring(iIndexOf + 1).trim(), str2);
            } else {
                strDecodeFormFields = decodeFormFields(next.trim(), str2);
                strDecodeFormFields2 = null;
            }
            list.add(new BasicNameValuePair(strDecodeFormFields, strDecodeFormFields2));
        }
    }

    public static List<NameValuePair> parse(String str, Charset charset) {
        if (str == null) {
            return createEmptyList();
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return parse(charArrayBuffer, charset, QP_SEP_A, QP_SEP_S);
    }

    public static List<NameValuePair> parse(String str, Charset charset, char... cArr) {
        if (str == null) {
            return createEmptyList();
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return parse(charArrayBuffer, charset, cArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cz.msebera.android.httpclient.NameValuePair> parse(cz.msebera.android.httpclient.util.CharArrayBuffer r7, java.nio.charset.Charset r8, char... r9) {
        /*
            java.lang.String r0 = "Char array buffer"
            cz.msebera.android.httpclient.util.Args.notNull(r7, r0)
            cz.msebera.android.httpclient.message.TokenParser r0 = cz.msebera.android.httpclient.message.TokenParser.INSTANCE
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            int r2 = r9.length
            r3 = 0
            r4 = 0
        Lf:
            if (r4 >= r2) goto L19
            char r5 = r9[r4]
            r1.set(r5)
            int r4 = r4 + 1
            goto Lf
        L19:
            cz.msebera.android.httpclient.message.ParserCursor r9 = new cz.msebera.android.httpclient.message.ParserCursor
            int r2 = r7.length()
            r9.<init>(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L27:
            boolean r3 = r9.atEnd()
            if (r3 != 0) goto L7e
            r3 = 61
            r1.set(r3)
            java.lang.String r4 = r0.parseToken(r7, r9, r1)
            boolean r5 = r9.atEnd()
            if (r5 != 0) goto L66
            int r5 = r9.getPos()
            char r5 = r7.charAt(r5)
            int r6 = r9.getPos()
            int r6 = r6 + 1
            r9.updatePos(r6)
            if (r5 != r3) goto L66
            r1.clear(r3)
            java.lang.String r3 = r0.parseToken(r7, r9, r1)
            boolean r5 = r9.atEnd()
            if (r5 != 0) goto L67
            int r5 = r9.getPos()
            int r5 = r5 + 1
            r9.updatePos(r5)
            goto L67
        L66:
            r3 = 0
        L67:
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L27
            cz.msebera.android.httpclient.message.BasicNameValuePair r5 = new cz.msebera.android.httpclient.message.BasicNameValuePair
            java.lang.String r4 = decodeFormFields(r4, r8)
            java.lang.String r3 = decodeFormFields(r3, r8)
            r5.<init>(r4, r3)
            r2.add(r5)
            goto L27
        L7e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.client.utils.URLEncodedUtils.parse(cz.msebera.android.httpclient.util.CharArrayBuffer, java.nio.charset.Charset, char[]):java.util.List");
    }
}
