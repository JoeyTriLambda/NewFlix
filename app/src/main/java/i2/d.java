package i2;

import android.annotation.SuppressLint;
import com.unity3d.ads.metadata.MediationMetaData;
import ig.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt__StringsKt;
import zf.f;
import zf.i;

/* compiled from: TableInfo.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final b f13108e = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f13109a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, a> f13110b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<c> f13111c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<e> f13112d;

    /* compiled from: TableInfo.kt */
    public static final class a {

        /* renamed from: h, reason: collision with root package name */
        public static final C0162a f13113h = new C0162a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f13114a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13115b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f13116c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13117d;

        /* renamed from: e, reason: collision with root package name */
        public final String f13118e;

        /* renamed from: f, reason: collision with root package name */
        public final int f13119f;

        /* renamed from: g, reason: collision with root package name */
        public final int f13120g;

        /* compiled from: TableInfo.kt */
        /* renamed from: i2.d$a$a, reason: collision with other inner class name */
        public static final class C0162a {
            public C0162a(f fVar) {
            }

            @SuppressLint({"SyntheticAccessor"})
            public final boolean defaultValueEquals(String str, String str2) {
                boolean z10;
                i.checkNotNullParameter(str, "current");
                if (i.areEqual(str, str2)) {
                    return true;
                }
                if (!(str.length() == 0)) {
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i10 < str.length()) {
                            char cCharAt = str.charAt(i10);
                            int i13 = i12 + 1;
                            if (i12 == 0 && cCharAt != '(') {
                                break;
                            }
                            if (cCharAt != '(') {
                                if (cCharAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                                    break;
                                }
                            } else {
                                i11++;
                            }
                            i10++;
                            i12 = i13;
                        } else {
                            z10 = i11 == 0;
                        }
                    }
                }
                if (!z10) {
                    return false;
                }
                String strSubstring = str.substring(1, str.length() - 1);
                i.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return i.areEqual(StringsKt__StringsKt.trim(strSubstring).toString(), str2);
            }
        }

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(str2, "type");
            this.f13114a = str;
            this.f13115b = str2;
            this.f13116c = z10;
            this.f13117d = i10;
            this.f13118e = str3;
            this.f13119f = i11;
            int i12 = 5;
            if (str2 != null) {
                Locale locale = Locale.US;
                i.checkNotNullExpressionValue(locale, "US");
                String upperCase = str2.toUpperCase(locale);
                i.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                if (StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "INT", false, 2, (Object) null)) {
                    i12 = 3;
                } else if (StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "CHAR", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "CLOB", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "TEXT", false, 2, (Object) null)) {
                    i12 = 2;
                } else if (!StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "BLOB", false, 2, (Object) null)) {
                    i12 = (StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "REAL", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "FLOA", false, 2, (Object) null) || StringsKt__StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "DOUB", false, 2, (Object) null)) ? 4 : 1;
                }
            }
            this.f13120g = i12;
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0066, code lost:
        
            r1 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean equals(java.lang.Object r8) {
            /*
                r7 = this;
                r0 = 1
                if (r7 != r8) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof i2.d.a
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r8
                i2.d$a r1 = (i2.d.a) r1
                int r1 = r1.f13117d
                int r3 = r7.f13117d
                if (r3 == r1) goto L14
                return r2
            L14:
                i2.d$a r8 = (i2.d.a) r8
                java.lang.String r1 = r8.f13114a
                java.lang.String r3 = r7.f13114a
                boolean r1 = zf.i.areEqual(r3, r1)
                if (r1 != 0) goto L21
                return r2
            L21:
                boolean r1 = r7.f13116c
                boolean r3 = r8.f13116c
                if (r1 == r3) goto L28
                return r2
            L28:
                r1 = 2
                i2.d$a$a r3 = i2.d.a.f13113h
                java.lang.String r4 = r7.f13118e
                int r5 = r7.f13119f
                if (r5 != r0) goto L40
                int r6 = r8.f13119f
                if (r6 != r1) goto L40
                if (r4 == 0) goto L40
                java.lang.String r6 = r8.f13118e
                boolean r6 = r3.defaultValueEquals(r4, r6)
                if (r6 != 0) goto L40
                return r2
            L40:
                if (r5 != r1) goto L51
                int r1 = r8.f13119f
                if (r1 != r0) goto L51
                java.lang.String r1 = r8.f13118e
                if (r1 == 0) goto L51
                boolean r1 = r3.defaultValueEquals(r1, r4)
                if (r1 != 0) goto L51
                return r2
            L51:
                if (r5 == 0) goto L6c
                int r1 = r8.f13119f
                if (r5 != r1) goto L6c
                if (r4 == 0) goto L62
                java.lang.String r1 = r8.f13118e
                boolean r1 = r3.defaultValueEquals(r4, r1)
                if (r1 != 0) goto L68
                goto L66
            L62:
                java.lang.String r1 = r8.f13118e
                if (r1 == 0) goto L68
            L66:
                r1 = 1
                goto L69
            L68:
                r1 = 0
            L69:
                if (r1 == 0) goto L6c
                return r2
            L6c:
                int r1 = r7.f13120g
                int r8 = r8.f13120g
                if (r1 != r8) goto L73
                goto L74
            L73:
                r0 = 0
            L74:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: i2.d.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return (((((this.f13114a.hashCode() * 31) + this.f13120g) * 31) + (this.f13116c ? 1231 : 1237)) * 31) + this.f13117d;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Column{name='");
            sb2.append(this.f13114a);
            sb2.append("', type='");
            sb2.append(this.f13115b);
            sb2.append("', affinity='");
            sb2.append(this.f13120g);
            sb2.append("', notNull=");
            sb2.append(this.f13116c);
            sb2.append(", primaryKeyPosition=");
            sb2.append(this.f13117d);
            sb2.append(", defaultValue='");
            String str = this.f13118e;
            if (str == null) {
                str = "undefined";
            }
            return ac.c.o(sb2, str, "'}");
        }
    }

    /* compiled from: TableInfo.kt */
    public static final class b {
        public b(f fVar) {
        }

        public final d read(k2.e eVar, String str) {
            i.checkNotNullParameter(eVar, "database");
            i.checkNotNullParameter(str, "tableName");
            return i2.e.readTableInfo(eVar, str);
        }
    }

    /* compiled from: TableInfo.kt */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f13121a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13122b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13123c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f13124d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f13125e;

        public c(String str, String str2, String str3, List<String> list, List<String> list2) {
            i.checkNotNullParameter(str, "referenceTable");
            i.checkNotNullParameter(str2, "onDelete");
            i.checkNotNullParameter(str3, "onUpdate");
            i.checkNotNullParameter(list, "columnNames");
            i.checkNotNullParameter(list2, "referenceColumnNames");
            this.f13121a = str;
            this.f13122b = str2;
            this.f13123c = str3;
            this.f13124d = list;
            this.f13125e = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (i.areEqual(this.f13121a, cVar.f13121a) && i.areEqual(this.f13122b, cVar.f13122b) && i.areEqual(this.f13123c, cVar.f13123c) && i.areEqual(this.f13124d, cVar.f13124d)) {
                return i.areEqual(this.f13125e, cVar.f13125e);
            }
            return false;
        }

        public int hashCode() {
            return this.f13125e.hashCode() + ((this.f13124d.hashCode() + ac.c.b(this.f13123c, ac.c.b(this.f13122b, this.f13121a.hashCode() * 31, 31), 31)) * 31);
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f13121a + "', onDelete='" + this.f13122b + " +', onUpdate='" + this.f13123c + "', columnNames=" + this.f13124d + ", referenceColumnNames=" + this.f13125e + '}';
        }
    }

    /* compiled from: TableInfo.kt */
    /* renamed from: i2.d$d, reason: collision with other inner class name */
    public static final class C0163d implements Comparable<C0163d> {

        /* renamed from: b, reason: collision with root package name */
        public final int f13126b;

        /* renamed from: m, reason: collision with root package name */
        public final int f13127m;

        /* renamed from: n, reason: collision with root package name */
        public final String f13128n;

        /* renamed from: o, reason: collision with root package name */
        public final String f13129o;

        public C0163d(int i10, int i11, String str, String str2) {
            i.checkNotNullParameter(str, "from");
            i.checkNotNullParameter(str2, "to");
            this.f13126b = i10;
            this.f13127m = i11;
            this.f13128n = str;
            this.f13129o = str2;
        }

        public final String getFrom() {
            return this.f13128n;
        }

        public final int getId() {
            return this.f13126b;
        }

        public final String getTo() {
            return this.f13129o;
        }

        @Override // java.lang.Comparable
        public int compareTo(C0163d c0163d) {
            i.checkNotNullParameter(c0163d, "other");
            int i10 = this.f13126b - c0163d.f13126b;
            return i10 == 0 ? this.f13127m - c0163d.f13127m : i10;
        }
    }

    /* compiled from: TableInfo.kt */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f13130a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f13131b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f13132c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f13133d;

        /* compiled from: TableInfo.kt */
        public static final class a {
            public a(f fVar) {
            }
        }

        static {
            new a(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public e(String str, boolean z10, List<String> list, List<String> list2) {
            i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
            i.checkNotNullParameter(list, "columns");
            i.checkNotNullParameter(list2, "orders");
            this.f13130a = str;
            this.f13131b = z10;
            this.f13132c = list;
            this.f13133d = list2;
            List<String> arrayList = list2;
            if (arrayList.isEmpty()) {
                int size = list.size();
                arrayList = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList.add("ASC");
                }
            }
            this.f13133d = (List) arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f13131b != eVar.f13131b || !i.areEqual(this.f13132c, eVar.f13132c) || !i.areEqual(this.f13133d, eVar.f13133d)) {
                return false;
            }
            String str = this.f13130a;
            return l.startsWith$default(str, "index_", false, 2, null) ? l.startsWith$default(eVar.f13130a, "index_", false, 2, null) : i.areEqual(str, eVar.f13130a);
        }

        public int hashCode() {
            String str = this.f13130a;
            return this.f13133d.hashCode() + ((this.f13132c.hashCode() + ((((l.startsWith$default(str, "index_", false, 2, null) ? -1184239155 : str.hashCode()) * 31) + (this.f13131b ? 1 : 0)) * 31)) * 31);
        }

        public String toString() {
            return "Index{name='" + this.f13130a + "', unique=" + this.f13131b + ", columns=" + this.f13132c + ", orders=" + this.f13133d + "'}";
        }
    }

    public d(String str, Map<String, a> map, Set<c> set, Set<e> set2) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(map, "columns");
        i.checkNotNullParameter(set, "foreignKeys");
        this.f13109a = str;
        this.f13110b = map;
        this.f13111c = set;
        this.f13112d = set2;
    }

    public static final d read(k2.e eVar, String str) {
        return f13108e.read(eVar, str);
    }

    public boolean equals(Object obj) {
        Set<e> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!i.areEqual(this.f13109a, dVar.f13109a) || !i.areEqual(this.f13110b, dVar.f13110b) || !i.areEqual(this.f13111c, dVar.f13111c)) {
            return false;
        }
        Set<e> set2 = this.f13112d;
        if (set2 == null || (set = dVar.f13112d) == null) {
            return true;
        }
        return i.areEqual(set2, set);
    }

    public int hashCode() {
        return this.f13111c.hashCode() + ((this.f13110b.hashCode() + (this.f13109a.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "TableInfo{name='" + this.f13109a + "', columns=" + this.f13110b + ", foreignKeys=" + this.f13111c + ", indices=" + this.f13112d + '}';
    }
}
