package org.apache.commons.lang3;

/* loaded from: classes2.dex */
public class CharUtils {
    public static final char CR = '\r';
    public static final char LF = '\n';
    public static final char NUL = 0;
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        char c10 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c10 >= strArr.length) {
                return;
            }
            strArr[c10] = String.valueOf(c10);
            c10 = (char) (c10 + 1);
        }
    }

    public static int compare(char c10, char c11) {
        return c10 - c11;
    }

    public static boolean isAscii(char c10) {
        return c10 < 128;
    }

    public static boolean isAsciiAlpha(char c10) {
        return isAsciiAlphaUpper(c10) || isAsciiAlphaLower(c10);
    }

    public static boolean isAsciiAlphaLower(char c10) {
        return c10 >= 'a' && c10 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c10) {
        return isAsciiAlpha(c10) || isAsciiNumeric(c10);
    }

    public static boolean isAsciiControl(char c10) {
        return c10 < ' ' || c10 == 127;
    }

    public static boolean isAsciiNumeric(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public static boolean isAsciiPrintable(char c10) {
        return c10 >= ' ' && c10 < 127;
    }

    public static char toChar(Character ch2) {
        Validate.isTrue(ch2 != null, "The Character must not be null", new Object[0]);
        return ch2.charValue();
    }

    @Deprecated
    public static Character toCharacterObject(char c10) {
        return Character.valueOf(c10);
    }

    public static int toIntValue(char c10) {
        if (isAsciiNumeric(c10)) {
            return c10 - '0';
        }
        throw new IllegalArgumentException("The character " + c10 + " is not in the range '0' - '9'");
    }

    public static String toString(char c10) {
        return c10 < 128 ? CHAR_STRING_ARRAY[c10] : new String(new char[]{c10});
    }

    public static String unicodeEscaped(char c10) {
        StringBuilder sb2 = new StringBuilder("\\u");
        char[] cArr = HEX_DIGITS;
        sb2.append(cArr[(c10 >> '\f') & 15]);
        sb2.append(cArr[(c10 >> '\b') & 15]);
        sb2.append(cArr[(c10 >> 4) & 15]);
        sb2.append(cArr[c10 & 15]);
        return sb2.toString();
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static String unicodeEscaped(Character ch2) {
        if (ch2 == null) {
            return null;
        }
        return unicodeEscaped(ch2.charValue());
    }

    public static char toChar(Character ch2, char c10) {
        return ch2 == null ? c10 : ch2.charValue();
    }

    public static int toIntValue(char c10, int i10) {
        return !isAsciiNumeric(c10) ? i10 : c10 - '0';
    }

    public static String toString(Character ch2) {
        if (ch2 == null) {
            return null;
        }
        return toString(ch2.charValue());
    }

    public static char toChar(String str) {
        Validate.isTrue(StringUtils.isNotEmpty(str), "The String must not be empty", new Object[0]);
        return str.charAt(0);
    }

    public static int toIntValue(Character ch2) {
        Validate.isTrue(ch2 != null, "The character must not be null", new Object[0]);
        return toIntValue(ch2.charValue());
    }

    public static char toChar(String str, char c10) {
        return StringUtils.isEmpty(str) ? c10 : str.charAt(0);
    }

    public static int toIntValue(Character ch2, int i10) {
        return ch2 == null ? i10 : toIntValue(ch2.charValue(), i10);
    }
}
