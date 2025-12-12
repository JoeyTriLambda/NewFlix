package jg;

import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.DurationUnit;
import okhttp3.internal.http2.Http2Connection;
import org.apache.commons.lang3.ClassUtils;
import zf.f;
import zf.i;

/* compiled from: Duration.kt */
/* loaded from: classes2.dex */
public final class a implements Comparable<a> {

    /* renamed from: m, reason: collision with root package name */
    public static final long f14694m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f14695n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f14696o = 0;

    /* renamed from: b, reason: collision with root package name */
    public final long f14697b;

    /* compiled from: Duration.kt */
    /* renamed from: jg.a$a, reason: collision with other inner class name */
    public static final class C0173a {
        public C0173a(f fVar) {
        }
    }

    static {
        new C0173a(null);
        m35constructorimpl(0L);
        f14694m = m35constructorimpl((4611686018427387903L << 1) + 1);
        f14695n = m35constructorimpl(((-4611686018427387903L) << 1) + 1);
    }

    public /* synthetic */ a(long j10) {
        this.f14697b = j10;
    }

    public static final void a(StringBuilder sb2, int i10, int i11, int i12, String str) {
        sb2.append(i10);
        if (i11 != 0) {
            sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String strPadStart = StringsKt__StringsKt.padStart(String.valueOf(i11), i12, '0');
            int i13 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i14 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i13 = length;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (i15 < 3) {
                sb2.append((CharSequence) strPadStart, 0, i15);
                i.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            } else {
                sb2.append((CharSequence) strPadStart, 0, ((i15 + 2) / 3) * 3);
                i.checkNotNullExpressionValue(sb2, "this.append(value, startIndex, endIndex)");
            }
        }
        sb2.append(str);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ a m33boximpl(long j10) {
        return new a(j10);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m35constructorimpl(long j10) {
        if (b.getDurationAssertionsEnabled()) {
            if ((((int) j10) & 1) == 0) {
                long j11 = j10 >> 1;
                if (!new fg.f(-4611686018426999999L, 4611686018426999999L).contains(j11)) {
                    throw new AssertionError(j11 + " ns is out of nanoseconds range");
                }
            } else {
                long j12 = j10 >> 1;
                if (!new fg.f(-4611686018427387903L, 4611686018427387903L).contains(j12)) {
                    throw new AssertionError(j12 + " ms is out of milliseconds range");
                }
                if (new fg.f(-4611686018426L, 4611686018426L).contains(j12)) {
                    throw new AssertionError(j12 + " ms is denormalized");
                }
            }
        }
        return j10;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m36equalsimpl(long j10, Object obj) {
        return (obj instanceof a) && j10 == ((a) obj).m56unboximpl();
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m37getAbsoluteValueUwyO8pc(long j10) {
        return m50isNegativeimpl(j10) ? m54unaryMinusUwyO8pc(j10) : j10;
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m38getHoursComponentimpl(long j10) {
        if (m49isInfiniteimpl(j10)) {
            return 0;
        }
        return (int) (m40getInWholeHoursimpl(j10) % 24);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m39getInWholeDaysimpl(long j10) {
        return m52toLongimpl(j10, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m40getInWholeHoursimpl(long j10) {
        return m52toLongimpl(j10, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m41getInWholeMillisecondsimpl(long j10) {
        return (((((int) j10) & 1) == 1) && m48isFiniteimpl(j10)) ? j10 >> 1 : m52toLongimpl(j10, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m42getInWholeMinutesimpl(long j10) {
        return m52toLongimpl(j10, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m43getInWholeSecondsimpl(long j10) {
        return m52toLongimpl(j10, DurationUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m44getMinutesComponentimpl(long j10) {
        if (m49isInfiniteimpl(j10)) {
            return 0;
        }
        return (int) (m42getInWholeMinutesimpl(j10) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m45getNanosecondsComponentimpl(long j10) {
        if (m49isInfiniteimpl(j10)) {
            return 0;
        }
        boolean z10 = (((int) j10) & 1) == 1;
        long j11 = j10 >> 1;
        return (int) (z10 ? c.access$millisToNanos(j11 % 1000) : j11 % Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m46getSecondsComponentimpl(long j10) {
        if (m49isInfiniteimpl(j10)) {
            return 0;
        }
        return (int) (m43getInWholeSecondsimpl(j10) % 60);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m47hashCodeimpl(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m48isFiniteimpl(long j10) {
        return !m49isInfiniteimpl(j10);
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m49isInfiniteimpl(long j10) {
        return j10 == f14694m || j10 == f14695n;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m50isNegativeimpl(long j10) {
        return j10 < 0;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m51isPositiveimpl(long j10) {
        return j10 > 0;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m52toLongimpl(long j10, DurationUnit durationUnit) {
        i.checkNotNullParameter(durationUnit, "unit");
        if (j10 == f14694m) {
            return Long.MAX_VALUE;
        }
        if (j10 == f14695n) {
            return Long.MIN_VALUE;
        }
        return d.convertDurationUnit(j10 >> 1, (((int) j10) & 1) == 0 ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS, durationUnit);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m53toStringimpl(long j10) {
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f14694m) {
            return "Infinity";
        }
        if (j10 == f14695n) {
            return "-Infinity";
        }
        boolean zM50isNegativeimpl = m50isNegativeimpl(j10);
        StringBuilder sb2 = new StringBuilder();
        if (zM50isNegativeimpl) {
            sb2.append('-');
        }
        long jM37getAbsoluteValueUwyO8pc = m37getAbsoluteValueUwyO8pc(j10);
        long jM39getInWholeDaysimpl = m39getInWholeDaysimpl(jM37getAbsoluteValueUwyO8pc);
        int iM38getHoursComponentimpl = m38getHoursComponentimpl(jM37getAbsoluteValueUwyO8pc);
        int iM44getMinutesComponentimpl = m44getMinutesComponentimpl(jM37getAbsoluteValueUwyO8pc);
        int iM46getSecondsComponentimpl = m46getSecondsComponentimpl(jM37getAbsoluteValueUwyO8pc);
        int iM45getNanosecondsComponentimpl = m45getNanosecondsComponentimpl(jM37getAbsoluteValueUwyO8pc);
        int i10 = 0;
        boolean z10 = jM39getInWholeDaysimpl != 0;
        boolean z11 = iM38getHoursComponentimpl != 0;
        boolean z12 = iM44getMinutesComponentimpl != 0;
        boolean z13 = (iM46getSecondsComponentimpl == 0 && iM45getNanosecondsComponentimpl == 0) ? false : true;
        if (z10) {
            sb2.append(jM39getInWholeDaysimpl);
            sb2.append('d');
            i10 = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(TokenParser.SP);
            }
            sb2.append(iM38getHoursComponentimpl);
            sb2.append('h');
            i10 = i11;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i12 = i10 + 1;
            if (i10 > 0) {
                sb2.append(TokenParser.SP);
            }
            sb2.append(iM44getMinutesComponentimpl);
            sb2.append('m');
            i10 = i12;
        }
        if (z13) {
            int i13 = i10 + 1;
            if (i10 > 0) {
                sb2.append(TokenParser.SP);
            }
            if (iM46getSecondsComponentimpl != 0 || z10 || z11 || z12) {
                a(sb2, iM46getSecondsComponentimpl, iM45getNanosecondsComponentimpl, 9, "s");
            } else if (iM45getNanosecondsComponentimpl >= 1000000) {
                a(sb2, iM45getNanosecondsComponentimpl / 1000000, iM45getNanosecondsComponentimpl % 1000000, 6, "ms");
            } else if (iM45getNanosecondsComponentimpl >= 1000) {
                a(sb2, iM45getNanosecondsComponentimpl / 1000, iM45getNanosecondsComponentimpl % 1000, 3, "us");
            } else {
                sb2.append(iM45getNanosecondsComponentimpl);
                sb2.append("ns");
            }
            i10 = i13;
        }
        if (zM50isNegativeimpl && i10 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m54unaryMinusUwyO8pc(long j10) {
        return m35constructorimpl(((-(j10 >> 1)) << 1) + (((int) j10) & 1));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return m55compareToLRDsOJo(aVar.m56unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m55compareToLRDsOJo(long j10) {
        return m34compareToLRDsOJo(this.f14697b, j10);
    }

    public boolean equals(Object obj) {
        return m36equalsimpl(this.f14697b, obj);
    }

    public int hashCode() {
        return m47hashCodeimpl(this.f14697b);
    }

    public String toString() {
        return m53toStringimpl(this.f14697b);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m56unboximpl() {
        return this.f14697b;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m34compareToLRDsOJo(long j10, long j11) {
        long j12 = j10 ^ j11;
        if (j12 < 0 || (((int) j12) & 1) == 0) {
            return i.compare(j10, j11);
        }
        int i10 = (((int) j10) & 1) - (((int) j11) & 1);
        return m50isNegativeimpl(j10) ? -i10 : i10;
    }
}
