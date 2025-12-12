package org.threeten.bp.format;

import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.ClassUtils;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes2.dex */
public final class DecimalStyle {
    private final char decimalSeparator;
    private final char negativeSign;
    private final char positiveSign;
    private final char zeroDigit;
    public static final DecimalStyle STANDARD = new DecimalStyle('0', '+', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR);
    private static final ConcurrentMap<Locale, DecimalStyle> CACHE = new ConcurrentHashMap(16, 0.75f, 2);

    private DecimalStyle(char c10, char c11, char c12, char c13) {
        this.zeroDigit = c10;
        this.positiveSign = c11;
        this.negativeSign = c12;
        this.decimalSeparator = c13;
    }

    private static DecimalStyle create(Locale locale) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        char zeroDigit = decimalFormatSymbols.getZeroDigit();
        char minusSign = decimalFormatSymbols.getMinusSign();
        char decimalSeparator = decimalFormatSymbols.getDecimalSeparator();
        return (zeroDigit == '0' && minusSign == '-' && decimalSeparator == '.') ? STANDARD : new DecimalStyle(zeroDigit, '+', minusSign, decimalSeparator);
    }

    public static Set<Locale> getAvailableLocales() {
        return new HashSet(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));
    }

    public static DecimalStyle of(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        ConcurrentMap<Locale, DecimalStyle> concurrentMap = CACHE;
        DecimalStyle decimalStyle = concurrentMap.get(locale);
        if (decimalStyle != null) {
            return decimalStyle;
        }
        concurrentMap.putIfAbsent(locale, create(locale));
        return concurrentMap.get(locale);
    }

    public static DecimalStyle ofDefaultLocale() {
        return of(Locale.getDefault());
    }

    public String convertNumberToI18N(String str) {
        char c10 = this.zeroDigit;
        if (c10 == '0') {
            return str;
        }
        int i10 = c10 - '0';
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            charArray[i11] = (char) (charArray[i11] + i10);
        }
        return new String(charArray);
    }

    public int convertToDigit(char c10) {
        int i10 = c10 - this.zeroDigit;
        if (i10 < 0 || i10 > 9) {
            return -1;
        }
        return i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        return this.zeroDigit == decimalStyle.zeroDigit && this.positiveSign == decimalStyle.positiveSign && this.negativeSign == decimalStyle.negativeSign && this.decimalSeparator == decimalStyle.decimalSeparator;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public char getNegativeSign() {
        return this.negativeSign;
    }

    public char getPositiveSign() {
        return this.positiveSign;
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public int hashCode() {
        return this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator;
    }

    public String toString() {
        return "DecimalStyle[" + this.zeroDigit + this.positiveSign + this.negativeSign + this.decimalSeparator + "]";
    }

    public DecimalStyle withDecimalSeparator(char c10) {
        return c10 == this.decimalSeparator ? this : new DecimalStyle(this.zeroDigit, this.positiveSign, this.negativeSign, c10);
    }

    public DecimalStyle withNegativeSign(char c10) {
        return c10 == this.negativeSign ? this : new DecimalStyle(this.zeroDigit, this.positiveSign, c10, this.decimalSeparator);
    }

    public DecimalStyle withPositiveSign(char c10) {
        return c10 == this.positiveSign ? this : new DecimalStyle(this.zeroDigit, c10, this.negativeSign, this.decimalSeparator);
    }

    public DecimalStyle withZeroDigit(char c10) {
        return c10 == this.zeroDigit ? this : new DecimalStyle(c10, this.positiveSign, this.negativeSign, this.decimalSeparator);
    }
}
