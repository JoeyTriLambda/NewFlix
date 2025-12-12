package org.apache.commons.lang3.text;

import ac.c;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

@Deprecated
/* loaded from: classes2.dex */
public class ExtendedMessageFormat extends MessageFormat {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DUMMY_PATTERN = "";
    private static final char END_FE = '}';
    private static final int HASH_SEED = 31;
    private static final char QUOTE = '\'';
    private static final char START_FE = '{';
    private static final char START_FMT = ',';
    private static final long serialVersionUID = -2362048321261811743L;
    private final Map<String, ? extends FormatFactory> registry;
    private String toPattern;

    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    private StringBuilder appendQuotedString(String str, ParsePosition parsePosition, StringBuilder sb2) {
        if (sb2 != null) {
            sb2.append(QUOTE);
        }
        next(parsePosition);
        int index = parsePosition.getIndex();
        char[] charArray = str.toCharArray();
        for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
            if (charArray[parsePosition.getIndex()] == '\'') {
                next(parsePosition);
                if (sb2 == null) {
                    return null;
                }
                sb2.append(charArray, index, parsePosition.getIndex() - index);
                return sb2;
            }
            next(parsePosition);
        }
        throw new IllegalArgumentException(c.f("Unterminated quoted string at position ", index));
    }

    private boolean containsElements(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Format getFormat(String str) {
        String strTrim;
        if (this.registry != null) {
            int iIndexOf = str.indexOf(44);
            if (iIndexOf > 0) {
                String strTrim2 = str.substring(0, iIndexOf).trim();
                strTrim = str.substring(iIndexOf + 1).trim();
                str = strTrim2;
            } else {
                strTrim = null;
            }
            FormatFactory formatFactory = this.registry.get(str);
            if (formatFactory != null) {
                return formatFactory.getFormat(str, strTrim, getLocale());
            }
        }
        return null;
    }

    private void getQuotedString(String str, ParsePosition parsePosition) {
        appendQuotedString(str, parsePosition, null);
    }

    private String insertFormats(String str, ArrayList<String> arrayList) {
        String str2;
        if (!containsElements(arrayList)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() * 2);
        int i10 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        int i11 = -1;
        while (parsePosition.getIndex() < str.length()) {
            char cCharAt = str.charAt(parsePosition.getIndex());
            if (cCharAt == '\'') {
                appendQuotedString(str, parsePosition, sb2);
            } else if (cCharAt != '{') {
                if (cCharAt == '}') {
                    i10--;
                }
                sb2.append(cCharAt);
                next(parsePosition);
            } else {
                i10++;
                sb2.append(START_FE);
                sb2.append(readArgumentIndex(str, next(parsePosition)));
                if (i10 == 1 && (str2 = arrayList.get((i11 = i11 + 1))) != null) {
                    sb2.append(START_FMT);
                    sb2.append(str2);
                }
            }
        }
        return sb2.toString();
    }

    private ParsePosition next(ParsePosition parsePosition) {
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        return parsePosition;
    }

    private String parseFormatDescription(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        int index2 = parsePosition.getIndex();
        int i10 = 1;
        while (parsePosition.getIndex() < str.length()) {
            char cCharAt = str.charAt(parsePosition.getIndex());
            if (cCharAt == '\'') {
                getQuotedString(str, parsePosition);
            } else if (cCharAt == '{') {
                i10++;
            } else if (cCharAt == '}' && i10 - 1 == 0) {
                return str.substring(index2, parsePosition.getIndex());
            }
            next(parsePosition);
        }
        throw new IllegalArgumentException(c.f("Unterminated format element at position ", index));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c A[PHI: r2
  0x003c: PHI (r2v6 char) = (r2v5 char), (r2v10 char), (r2v10 char) binds: [B:7:0x0029, B:9:0x0036, B:10:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int readArgumentIndex(java.lang.String r7, java.text.ParsePosition r8) {
        /*
            r6 = this;
            int r0 = r8.getIndex()
            r6.seekNonWs(r7, r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
        Ld:
            if (r2 != 0) goto L5d
            int r3 = r8.getIndex()
            int r4 = r7.length()
            if (r3 >= r4) goto L5d
            int r2 = r8.getIndex()
            char r2 = r7.charAt(r2)
            boolean r3 = java.lang.Character.isWhitespace(r2)
            r4 = 125(0x7d, float:1.75E-43)
            r5 = 44
            if (r3 == 0) goto L3c
            r6.seekNonWs(r7, r8)
            int r2 = r8.getIndex()
            char r2 = r7.charAt(r2)
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L3c
            r2 = 1
            goto L59
        L3c:
            if (r2 == r5) goto L40
            if (r2 != r4) goto L4f
        L40:
            int r3 = r1.length()
            if (r3 <= 0) goto L4f
            java.lang.String r3 = r1.toString()     // Catch: java.lang.NumberFormatException -> L4f
            int r7 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L4f
            return r7
        L4f:
            boolean r3 = java.lang.Character.isDigit(r2)
            r3 = r3 ^ 1
            r1.append(r2)
            r2 = r3
        L59:
            r6.next(r8)
            goto Ld
        L5d:
            if (r2 == 0) goto L7c
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid format argument index at position "
            java.lang.String r3 = ": "
            java.lang.StringBuilder r2 = ac.c.s(r2, r0, r3)
            int r8 = r8.getIndex()
            java.lang.String r7 = r7.substring(r0, r8)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.<init>(r7)
            throw r1
        L7c:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Unterminated format element at position "
            java.lang.String r8 = ac.c.f(r8, r0)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.text.ExtendedMessageFormat.readArgumentIndex(java.lang.String, java.text.ParsePosition):int");
    }

    private void seekNonWs(String str, ParsePosition parsePosition) {
        char[] charArray = str.toCharArray();
        do {
            int iIsMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + iIsMatch);
            if (iIsMatch <= 0) {
                return;
            }
        } while (parsePosition.getIndex() < str.length());
    }

    @Override // java.text.MessageFormat
    public final void applyPattern(String str) {
        String formatDescription;
        Format format;
        if (this.registry == null) {
            super.applyPattern(str);
            this.toPattern = super.toPattern();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuilder sb2 = new StringBuilder(str.length());
        int i10 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        char[] charArray = str.toCharArray();
        int i11 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char c10 = charArray[parsePosition.getIndex()];
            if (c10 != '\'') {
                if (c10 == '{') {
                    i11++;
                    seekNonWs(str, parsePosition);
                    int index = parsePosition.getIndex();
                    int argumentIndex = readArgumentIndex(str, next(parsePosition));
                    sb2.append(START_FE);
                    sb2.append(argumentIndex);
                    seekNonWs(str, parsePosition);
                    if (charArray[parsePosition.getIndex()] == ',') {
                        formatDescription = parseFormatDescription(str, next(parsePosition));
                        format = getFormat(formatDescription);
                        if (format == null) {
                            sb2.append(START_FMT);
                            sb2.append(formatDescription);
                        }
                    } else {
                        formatDescription = null;
                        format = null;
                    }
                    arrayList.add(format);
                    arrayList2.add(format != null ? formatDescription : null);
                    Validate.isTrue(arrayList.size() == i11);
                    Validate.isTrue(arrayList2.size() == i11);
                    if (charArray[parsePosition.getIndex()] != '}') {
                        throw new IllegalArgumentException(c.f("Unreadable format element at position ", index));
                    }
                }
                sb2.append(charArray[parsePosition.getIndex()]);
                next(parsePosition);
            } else {
                appendQuotedString(str, parsePosition, sb2);
            }
        }
        super.applyPattern(sb2.toString());
        this.toPattern = insertFormats(super.toPattern(), arrayList2);
        if (containsElements(arrayList)) {
            Format[] formats = getFormats();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Format format2 = (Format) it.next();
                if (format2 != null) {
                    formats[i10] = format2;
                }
                i10++;
            }
            super.setFormats(formats);
        }
    }

    @Override // java.text.MessageFormat
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !super.equals(obj) || ObjectUtils.notEqual(getClass(), obj.getClass())) {
            return false;
        }
        if (ObjectUtils.notEqual(this.toPattern, ((ExtendedMessageFormat) obj).toPattern)) {
            return false;
        }
        return !ObjectUtils.notEqual(this.registry, r5.registry);
    }

    @Override // java.text.MessageFormat
    public int hashCode() {
        return Objects.hashCode(this.toPattern) + ((Objects.hashCode(this.registry) + (super.hashCode() * 31)) * 31);
    }

    @Override // java.text.MessageFormat
    public void setFormat(int i10, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatByArgumentIndex(int i10, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public String toPattern() {
        return this.toPattern;
    }

    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, null);
    }

    public ExtendedMessageFormat(String str, Map<String, ? extends FormatFactory> map) {
        this(str, Locale.getDefault(), map);
    }

    public ExtendedMessageFormat(String str, Locale locale, Map<String, ? extends FormatFactory> map) {
        super("");
        setLocale(locale);
        this.registry = map;
        applyPattern(str);
    }
}
