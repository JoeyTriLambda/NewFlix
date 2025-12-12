package okhttp3;

import ag.a;
import com.unity3d.ads.metadata.MediationMetaData;
import ig.l;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.text.StringsKt__StringsKt;
import lf.g;
import mf.k;
import mf.o;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import tf.c;
import zf.b;
import zf.f;
import zf.i;
import zf.m;

/* compiled from: Headers.kt */
/* loaded from: classes2.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /* compiled from: Headers.kt */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            i.checkNotNullParameter(str, "line");
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ':', 0, false, 6, (Object) null);
            if (!(iIndexOf$default != -1)) {
                throw new IllegalArgumentException(i.stringPlus("Unexpected header: ", str).toString());
            }
            String strSubstring = str.substring(0, iIndexOf$default);
            i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = StringsKt__StringsKt.trim(strSubstring).toString();
            String strSubstring2 = str.substring(iIndexOf$default + 1);
            i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        public final Builder addAll(Headers headers) {
            i.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                addLenient$okhttp(headers.name(i10), headers.value(i10));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            i.checkNotNullParameter(str, "line");
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ':', 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = str.substring(0, iIndexOf$default);
                i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iIndexOf$default + 1);
                i.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
            } else if (str.charAt(0) == ':') {
                String strSubstring3 = str.substring(1);
                i.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", strSubstring3);
            } else {
                addLenient$okhttp("", str);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final String get(String str) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            int size = this.namesAndValues.size() - 2;
            int progressionLastElement = c.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > size) {
                return null;
            }
            while (true) {
                int i10 = size - 2;
                if (l.equals(str, this.namesAndValues.get(size), true)) {
                    return this.namesAndValues.get(size + 1);
                }
                if (size == progressionLastElement) {
                    return null;
                }
                size = i10;
            }
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            int i10 = 0;
            while (i10 < getNamesAndValues$okhttp().size()) {
                if (l.equals(str, getNamesAndValues$okhttp().get(i10), true)) {
                    getNamesAndValues$okhttp().remove(i10);
                    getNamesAndValues$okhttp().remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public final Builder set(String str, Date date) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            Companion companion = Headers.Companion;
            companion.checkName(str);
            companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "value");
            getNamesAndValues$okhttp().add(str);
            getNamesAndValues$okhttp().add(StringsKt__StringsKt.trim(str2).toString());
            return this;
        }

        public final Builder add(String str, Date date) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }
    }

    /* compiled from: Headers.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                char cCharAt = str.charAt(i10);
                if (!('!' <= cCharAt && cCharAt < 127)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str).toString());
                }
                i10 = i11;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void checkValue(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                int r0 = r8.length()
                r1 = 0
                r2 = 0
            L6:
                if (r2 >= r0) goto L5d
                int r3 = r2 + 1
                char r4 = r8.charAt(r2)
                r5 = 9
                r6 = 1
                if (r4 == r5) goto L23
                r5 = 32
                if (r5 > r4) goto L1d
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 >= r5) goto L1d
                r5 = 1
                goto L1e
            L1d:
                r5 = 0
            L1e:
                if (r5 == 0) goto L21
                goto L23
            L21:
                r5 = 0
                goto L24
            L23:
                r5 = 1
            L24:
                if (r5 != 0) goto L5b
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                r0[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0[r6] = r1
                r1 = 2
                r0[r1] = r9
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r0 = okhttp3.internal.Util.format(r1, r0)
                boolean r9 = okhttp3.internal.Util.isSensitiveHeader(r9)
                if (r9 == 0) goto L47
                java.lang.String r8 = ""
                goto L4d
            L47:
                java.lang.String r9 = ": "
                java.lang.String r8 = zf.i.stringPlus(r9, r8)
            L4d:
                java.lang.String r8 = zf.i.stringPlus(r0, r8)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L5b:
                r2 = r3
                goto L6
            L5d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.checkValue(java.lang.String, java.lang.String):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            int length = strArr.length - 2;
            int progressionLastElement = c.getProgressionLastElement(length, 0, -2);
            if (progressionLastElement > length) {
                return null;
            }
            while (true) {
                int i10 = length - 2;
                if (l.equals(str, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == progressionLastElement) {
                    return null;
                }
                length = i10;
            }
        }

        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m139deprecated_of(String... strArr) {
            i.checkNotNullParameter(strArr, "namesAndValues");
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            i.checkNotNullParameter(strArr, "namesAndValues");
            int i10 = 0;
            if (!(strArr.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                String str = strArr2[i11];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                strArr2[i11] = StringsKt__StringsKt.trim(str).toString();
                i11 = i12;
            }
            int progressionLastElement = c.getProgressionLastElement(0, strArr2.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    int i13 = i10 + 2;
                    String str2 = strArr2[i10];
                    String str3 = strArr2[i10 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i10 == progressionLastElement) {
                        break;
                    }
                    i10 = i13;
                }
            }
            return new Headers(strArr2, null);
        }

        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m138deprecated_of(Map<String, String> map) {
            i.checkNotNullParameter(map, "headers");
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            i.checkNotNullParameter(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String string = StringsKt__StringsKt.trim(key).toString();
                String string2 = StringsKt__StringsKt.trim(value).toString();
                checkName(string);
                checkValue(string2, string);
                strArr[i10] = string;
                strArr[i10 + 1] = string2;
                i10 += 2;
            }
            return new Headers(strArr, null);
        }
    }

    public /* synthetic */ Headers(String[] strArr, f fVar) {
        this(strArr);
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m137deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        String str2 = get(str);
        if (str2 == null) {
            return null;
        }
        return DatesKt.toHttpDateOrNull(str2);
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        Date date = getDate(str);
        if (date == null) {
            return null;
        }
        return date.toInstant();
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = g.to(name(i10), value(i10));
        }
        return b.iterator(pairArr);
    }

    public final String name(int i10) {
        return this.namesAndValues[i10 * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(l.getCASE_INSENSITIVE_ORDER(m.f22730a));
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        i.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        o.addAll(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(l.getCASE_INSENSITIVE_ORDER(m.f22730a));
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String strName = name(i10);
            Locale locale = Locale.US;
            i.checkNotNullExpressionValue(locale, "US");
            String lowerCase = strName.toLowerCase(locale);
            i.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i10));
            i10 = i11;
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String strName = name(i10);
            String strValue = value(i10);
            sb2.append(strName);
            sb2.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb2.append(strValue);
            sb2.append(StringUtils.LF);
            i10 = i11;
        }
        String string = sb2.toString();
        i.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    public final List<String> values(String str) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        int size = size();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (l.equals(str, name(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
            i10 = i11;
        }
        if (arrayList == null) {
            return k.emptyList();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        i.checkNotNullExpressionValue(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}
