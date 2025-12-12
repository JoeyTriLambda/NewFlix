package g6;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/* compiled from: TtmlNode.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12741a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12742b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12743c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12744d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12745e;

    /* renamed from: f, reason: collision with root package name */
    public final e f12746f;

    /* renamed from: g, reason: collision with root package name */
    public final String f12747g;

    /* renamed from: h, reason: collision with root package name */
    public final String[] f12748h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap<String, Integer> f12749i;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap<String, Integer> f12750j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f12751k;

    public b(String str, String str2, long j10, long j11, e eVar, String[] strArr, String str3) {
        this.f12741a = str;
        this.f12742b = str2;
        this.f12746f = eVar;
        this.f12748h = strArr;
        this.f12743c = str2 != null;
        this.f12744d = j10;
        this.f12745e = j11;
        this.f12747g = (String) l6.a.checkNotNull(str3);
        this.f12749i = new HashMap<>();
        this.f12750j = new HashMap<>();
    }

    public static SpannableStringBuilder b(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            treeMap.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) treeMap.get(str);
    }

    public static b buildNode(String str, long j10, long j11, e eVar, String[] strArr, String str2) {
        return new b(str, null, j10, j11, eVar, strArr, str2);
    }

    public static b buildTextNode(String str) {
        return new b(null, str.replaceAll("\r\n", StringUtils.LF).replaceAll(" *\n *", StringUtils.LF).replaceAll(StringUtils.LF, StringUtils.SPACE).replaceAll("[ \t\\x0B\f\r]+", StringUtils.SPACE), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public final void a(TreeSet<Long> treeSet, boolean z10) {
        boolean zEquals = "p".equals(this.f12741a);
        if (z10 || zEquals) {
            long j10 = this.f12744d;
            if (j10 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.f12745e;
            if (j11 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.f12751k == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f12751k.size(); i10++) {
            ((b) this.f12751k.get(i10)).a(treeSet, z10 || zEquals);
        }
    }

    public void addChild(b bVar) {
        if (this.f12751k == null) {
            this.f12751k = new ArrayList();
        }
        this.f12751k.add(bVar);
    }

    public final void c(Map map, TreeMap treeMap) {
        e eVarResolveStyle;
        for (Map.Entry<String, Integer> entry : this.f12750j.entrySet()) {
            String key = entry.getKey();
            HashMap<String, Integer> map2 = this.f12749i;
            int iIntValue = map2.containsKey(key) ? map2.get(key).intValue() : 0;
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) treeMap.get(key);
            int iIntValue2 = entry.getValue().intValue();
            if (iIntValue != iIntValue2 && (eVarResolveStyle = d.resolveStyle(this.f12746f, this.f12748h, map)) != null) {
                d.applyStylesToSpan(spannableStringBuilder, iIntValue, iIntValue2, eVarResolveStyle);
            }
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                getChild(i10).c(map, treeMap);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(long j10, boolean z10, String str, TreeMap treeMap) {
        HashMap<String, Integer> map = this.f12749i;
        map.clear();
        HashMap<String, Integer> map2 = this.f12750j;
        map2.clear();
        String str2 = this.f12747g;
        String str3 = "".equals(str2) ? str : str2;
        if (this.f12743c && z10) {
            b(str3, treeMap).append((CharSequence) this.f12742b);
            return;
        }
        String str4 = this.f12741a;
        if ("br".equals(str4) && z10) {
            b(str3, treeMap).append('\n');
            return;
        }
        if (!"metadata".equals(str4) && isActive(j10)) {
            boolean zEquals = "p".equals(str4);
            for (Map.Entry entry : treeMap.entrySet()) {
                map.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
            }
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                getChild(i10).d(j10, z10 || zEquals, str3, treeMap);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderB = b(str3, treeMap);
                int length = spannableStringBuilderB.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderB.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderB.charAt(length) != '\n') {
                    spannableStringBuilderB.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                map2.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
            }
        }
    }

    public b getChild(int i10) {
        ArrayList arrayList = this.f12751k;
        if (arrayList != null) {
            return (b) arrayList.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getChildCount() {
        ArrayList arrayList = this.f12751k;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public List<b6.a> getCues(long j10, Map<String, e> map, Map<String, c> map2) {
        int i10;
        int i11;
        TreeMap treeMap = new TreeMap();
        d(j10, false, this.f12747g, treeMap);
        c(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar = map2.get(entry.getKey());
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) entry.getValue();
            int length = spannableStringBuilder.length();
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                if (spannableStringBuilder.charAt(i13) == ' ') {
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (i15 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i15) == ' ') {
                        i15++;
                    }
                    int i16 = i15 - i14;
                    if (i16 > 0) {
                        spannableStringBuilder.delete(i13, i13 + i16);
                        length -= i16;
                    }
                }
            }
            if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
                length--;
            }
            int i17 = 0;
            while (true) {
                i10 = length - 1;
                if (i17 >= i10) {
                    break;
                }
                if (spannableStringBuilder.charAt(i17) == '\n') {
                    int i18 = i17 + 1;
                    if (spannableStringBuilder.charAt(i18) == ' ') {
                        spannableStringBuilder.delete(i18, i17 + 2);
                        length = i10;
                    }
                }
                i17++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i10) == ' ') {
                spannableStringBuilder.delete(i10, length);
                length = i10;
            }
            while (true) {
                i11 = length - 1;
                if (i12 >= i11) {
                    break;
                }
                if (spannableStringBuilder.charAt(i12) == ' ') {
                    int i19 = i12 + 1;
                    if (spannableStringBuilder.charAt(i19) == '\n') {
                        spannableStringBuilder.delete(i12, i19);
                        length = i11;
                    }
                }
                i12++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i11) == '\n') {
                spannableStringBuilder.delete(i11, length);
            }
            arrayList.add(new b6.a(spannableStringBuilder, null, cVar.f12754c, cVar.f12755d, cVar.f12756e, cVar.f12753b, Integer.MIN_VALUE, cVar.f12757f));
        }
        return arrayList;
    }

    public long[] getEventTimesUs() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i10 = 0;
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i10] = it.next().longValue();
            i10++;
        }
        return jArr;
    }

    public boolean isActive(long j10) {
        long j11 = this.f12745e;
        long j12 = this.f12744d;
        return (j12 == -9223372036854775807L && j11 == -9223372036854775807L) || (j12 <= j10 && j11 == -9223372036854775807L) || ((j12 == -9223372036854775807L && j10 < j11) || (j12 <= j10 && j10 < j11));
    }
}
