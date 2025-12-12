package org.apache.commons.lang3.math;

import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public final class Fraction extends Number implements Comparable<Fraction> {
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private final int numerator;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    private transient int hashCode = 0;
    private transient String toString = null;
    private transient String toProperString = null;

    private Fraction(int i10, int i11) {
        this.numerator = i10;
        this.denominator = i11;
    }

    private static int addAndCheck(int i10, int i11) {
        long j10 = i10 + i11;
        if (j10 < -2147483648L || j10 > 2147483647L) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j10;
    }

    private Fraction addSub(Fraction fraction, boolean z10) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        if (this.numerator == 0) {
            return z10 ? fraction : fraction.negate();
        }
        if (fraction.numerator == 0) {
            return this;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
        if (iGreatestCommonDivisor == 1) {
            int iMulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
            int iMulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
            return new Fraction(z10 ? addAndCheck(iMulAndCheck, iMulAndCheck2) : subAndCheck(iMulAndCheck, iMulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / iGreatestCommonDivisor));
        BigInteger bigIntegerMultiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / iGreatestCommonDivisor));
        BigInteger bigIntegerAdd = z10 ? bigIntegerMultiply.add(bigIntegerMultiply2) : bigIntegerMultiply.subtract(bigIntegerMultiply2);
        int iIntValue = bigIntegerAdd.mod(BigInteger.valueOf(iGreatestCommonDivisor)).intValue();
        int iGreatestCommonDivisor2 = iIntValue == 0 ? iGreatestCommonDivisor : greatestCommonDivisor(iIntValue, iGreatestCommonDivisor);
        BigInteger bigIntegerDivide = bigIntegerAdd.divide(BigInteger.valueOf(iGreatestCommonDivisor2));
        if (bigIntegerDivide.bitLength() <= 31) {
            return new Fraction(bigIntegerDivide.intValue(), mulPosAndCheck(this.denominator / iGreatestCommonDivisor, fraction.denominator / iGreatestCommonDivisor2));
        }
        throw new ArithmeticException("overflow: numerator too large after multiply");
    }

    public static Fraction getFraction(int i10, int i11) {
        if (i11 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i11 < 0) {
            if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            i10 = -i10;
            i11 = -i11;
        }
        return new Fraction(i10, i11);
    }

    public static Fraction getReducedFraction(int i10, int i11) {
        if (i11 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i10 == 0) {
            return ZERO;
        }
        if (i11 == Integer.MIN_VALUE && (i10 & 1) == 0) {
            i10 /= 2;
            i11 /= 2;
        }
        if (i11 < 0) {
            if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            i10 = -i10;
            i11 = -i11;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(i10, i11);
        return new Fraction(i10 / iGreatestCommonDivisor, i11 / iGreatestCommonDivisor);
    }

    private static int greatestCommonDivisor(int i10, int i11) {
        int i12;
        if (i10 == 0 || i11 == 0) {
            if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: gcd is 2^31");
            }
            return Math.abs(i11) + Math.abs(i10);
        }
        if (Math.abs(i10) == 1 || Math.abs(i11) == 1) {
            return 1;
        }
        if (i10 > 0) {
            i10 = -i10;
        }
        if (i11 > 0) {
            i11 = -i11;
        }
        int i13 = 0;
        while (true) {
            i12 = i10 & 1;
            if (i12 != 0 || (i11 & 1) != 0 || i13 >= 31) {
                break;
            }
            i10 /= 2;
            i11 /= 2;
            i13++;
        }
        if (i13 == 31) {
            throw new ArithmeticException("overflow: gcd is 2^31");
        }
        int i14 = i12 == 1 ? i11 : -(i10 / 2);
        while (true) {
            if ((i14 & 1) == 0) {
                i14 /= 2;
            } else {
                if (i14 > 0) {
                    i10 = -i14;
                } else {
                    i11 = i14;
                }
                i14 = (i11 - i10) / 2;
                if (i14 == 0) {
                    return (-i10) * (1 << i13);
                }
            }
        }
    }

    private static int mulAndCheck(int i10, int i11) {
        long j10 = i10 * i11;
        if (j10 < -2147483648L || j10 > 2147483647L) {
            throw new ArithmeticException("overflow: mul");
        }
        return (int) j10;
    }

    private static int mulPosAndCheck(int i10, int i11) {
        long j10 = i10 * i11;
        if (j10 <= 2147483647L) {
            return (int) j10;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i10, int i11) {
        long j10 = i10 - i11;
        if (j10 < -2147483648L || j10 > 2147483647L) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j10;
    }

    public Fraction abs() {
        return this.numerator >= 0 ? this : negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        }
        throw new ArithmeticException("The fraction to divide by must not be zero");
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.numerator / this.denominator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.denominator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getDenominator() + ((getNumerator() + 629) * 37);
        }
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i10 = this.numerator;
        if (i10 == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        }
        if (i10 != Integer.MIN_VALUE) {
            return i10 < 0 ? new Fraction(-this.denominator, -i10) : new Fraction(this.denominator, i10);
        }
        throw new ArithmeticException("overflow: can't negate numerator");
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator / this.denominator;
    }

    public Fraction multiplyBy(Fraction fraction) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        int i10 = this.numerator;
        if (i10 == 0 || fraction.numerator == 0) {
            return ZERO;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(i10, fraction.denominator);
        int iGreatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / iGreatestCommonDivisor, fraction.numerator / iGreatestCommonDivisor2), mulPosAndCheck(this.denominator / iGreatestCommonDivisor2, fraction.denominator / iGreatestCommonDivisor));
    }

    public Fraction negate() {
        int i10 = this.numerator;
        if (i10 != Integer.MIN_VALUE) {
            return new Fraction(-i10, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i10) {
        if (i10 == 1) {
            return this;
        }
        if (i10 == 0) {
            return ONE;
        }
        if (i10 < 0) {
            return i10 == Integer.MIN_VALUE ? invert().pow(2).pow(-(i10 / 2)) : invert().pow(-i10);
        }
        Fraction fractionMultiplyBy = multiplyBy(this);
        return i10 % 2 == 0 ? fractionMultiplyBy.pow(i10 / 2) : fractionMultiplyBy.pow(i10 / 2).multiplyBy(this);
    }

    public Fraction reduce() {
        int i10 = this.numerator;
        if (i10 == 0) {
            Fraction fraction = ZERO;
            return equals(fraction) ? this : fraction;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(Math.abs(i10), this.denominator);
        return iGreatestCommonDivisor == 1 ? this : getFraction(this.numerator / iGreatestCommonDivisor, this.denominator / iGreatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i10 = this.numerator;
            if (i10 == 0) {
                this.toProperString = "0";
            } else {
                int i11 = this.denominator;
                if (i10 == i11) {
                    this.toProperString = "1";
                } else if (i10 == i11 * (-1)) {
                    this.toProperString = "-1";
                } else {
                    if (i10 > 0) {
                        i10 = -i10;
                    }
                    if (i10 < (-i11)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            this.toProperString = getProperWhole() + StringUtils.SPACE + properNumerator + "/" + getDenominator();
                        }
                    } else {
                        this.toProperString = getNumerator() + "/" + getDenominator();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = getNumerator() + "/" + getDenominator();
        }
        return this.toString;
    }

    @Override // java.lang.Comparable
    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        int i10 = this.numerator;
        int i11 = fraction.numerator;
        if (i10 == i11 && this.denominator == fraction.denominator) {
            return 0;
        }
        long j10 = i10 * fraction.denominator;
        long j11 = i11 * this.denominator;
        if (j10 == j11) {
            return 0;
        }
        return j10 < j11 ? -1 : 1;
    }

    public static Fraction getFraction(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i12 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        }
        if (i11 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        }
        long j10 = i10 < 0 ? (i10 * i12) - i11 : (i10 * i12) + i11;
        if (j10 >= -2147483648L && j10 <= 2147483647L) {
            return new Fraction((int) j10, i12);
        }
        throw new ArithmeticException("Numerator too large to represent as an Integer.");
    }

    public static Fraction getFraction(double d10) {
        int i10;
        int i11 = d10 < 0.0d ? -1 : 1;
        double dAbs = Math.abs(d10);
        if (dAbs > 2.147483647E9d || Double.isNaN(dAbs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i12 = (int) dAbs;
        double d11 = dAbs - i12;
        int i13 = (int) d11;
        double d12 = d11 - i13;
        double d13 = d11;
        double d14 = Double.MAX_VALUE;
        int i14 = 1;
        int i15 = 1;
        int i16 = 1;
        double d15 = 1.0d;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = (int) (d15 / d12);
            double d16 = d15 - (i19 * d12);
            int i20 = (i13 * i14) + i17;
            int i21 = (i13 * i18) + i15;
            double d17 = d12;
            double d18 = d13;
            double dAbs2 = Math.abs(d18 - (i20 / i21));
            i10 = i16 + 1;
            if (d14 <= dAbs2 || i21 > 10000 || i21 <= 0 || i10 >= 25) {
                break;
            }
            d14 = dAbs2;
            d13 = d18;
            i15 = i18;
            i16 = i10;
            d12 = d16;
            i18 = i21;
            i13 = i19;
            i17 = i14;
            i14 = i20;
            d15 = d17;
        }
        if (i10 != 25) {
            return getReducedFraction(((i12 * i18) + i14) * i11, i18);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) throws NumberFormatException {
        Validate.isTrue(str != null, "The string must not be null", new Object[0]);
        if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        }
        int iIndexOf = str.indexOf(32);
        if (iIndexOf > 0) {
            int i10 = Integer.parseInt(str.substring(0, iIndexOf));
            String strSubstring = str.substring(iIndexOf + 1);
            int iIndexOf2 = strSubstring.indexOf(47);
            if (iIndexOf2 >= 0) {
                return getFraction(i10, Integer.parseInt(strSubstring.substring(0, iIndexOf2)), Integer.parseInt(strSubstring.substring(iIndexOf2 + 1)));
            }
            throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
        }
        int iIndexOf3 = str.indexOf(47);
        if (iIndexOf3 < 0) {
            return getFraction(Integer.parseInt(str), 1);
        }
        return getFraction(Integer.parseInt(str.substring(0, iIndexOf3)), Integer.parseInt(str.substring(iIndexOf3 + 1)));
    }
}
