package org.jsoup.nodes;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* compiled from: Attributes.java */
/* loaded from: classes2.dex */
public final class b implements Iterable<org.jsoup.nodes.a>, Cloneable {

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f17165o = new String[0];

    /* renamed from: b, reason: collision with root package name */
    public int f17166b = 0;

    /* renamed from: m, reason: collision with root package name */
    public String[] f17167m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f17168n;

    /* compiled from: Attributes.java */
    public class a implements Iterator<org.jsoup.nodes.a> {

        /* renamed from: b, reason: collision with root package name */
        public int f17169b = 0;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17169b < b.this.f17166b;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.f17169b - 1;
            this.f17169b = i10;
            b bVar = b.this;
            dh.f.isFalse(i10 >= bVar.f17166b);
            int i11 = (bVar.f17166b - i10) - 1;
            if (i11 > 0) {
                String[] strArr = bVar.f17167m;
                int i12 = i10 + 1;
                System.arraycopy(strArr, i12, strArr, i10, i11);
                String[] strArr2 = bVar.f17168n;
                System.arraycopy(strArr2, i12, strArr2, i10, i11);
            }
            int i13 = bVar.f17166b - 1;
            bVar.f17166b = i13;
            bVar.f17167m[i13] = null;
            bVar.f17168n[i13] = null;
        }

        @Override // java.util.Iterator
        public org.jsoup.nodes.a next() {
            b bVar = b.this;
            String[] strArr = bVar.f17167m;
            int i10 = this.f17169b;
            org.jsoup.nodes.a aVar = new org.jsoup.nodes.a(strArr[i10], bVar.f17168n[i10], bVar);
            this.f17169b++;
            return aVar;
        }
    }

    public b() {
        String[] strArr = f17165o;
        this.f17167m = strArr;
        this.f17168n = strArr;
    }

    public final void a(int i10) {
        dh.f.isTrue(i10 >= this.f17166b);
        String[] strArr = this.f17167m;
        int length = strArr.length;
        if (length >= i10) {
            return;
        }
        int i11 = length >= 4 ? this.f17166b * 2 : 4;
        if (i10 <= i11) {
            i10 = i11;
        }
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i10));
        this.f17167m = strArr2;
        String[] strArr3 = this.f17168n;
        String[] strArr4 = new String[i10];
        System.arraycopy(strArr3, 0, strArr4, 0, Math.min(strArr3.length, i10));
        this.f17168n = strArr4;
    }

    public void addAll(b bVar) {
        if (bVar.size() == 0) {
            return;
        }
        a(this.f17166b + bVar.f17166b);
        Iterator<org.jsoup.nodes.a> it = bVar.iterator();
        while (it.hasNext()) {
            put(it.next());
        }
    }

    public List<org.jsoup.nodes.a> asList() {
        ArrayList arrayList = new ArrayList(this.f17166b);
        for (int i10 = 0; i10 < this.f17166b; i10++) {
            String str = this.f17168n[i10];
            arrayList.add(str == null ? new fh.a(this.f17167m[i10]) : new org.jsoup.nodes.a(this.f17167m[i10], str, this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final void b(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i10 = this.f17166b;
        for (int i11 = 0; i11 < i10; i11++) {
            String str = this.f17167m[i11];
            String str2 = this.f17168n[i11];
            appendable.append(TokenParser.SP).append(str);
            if (!org.jsoup.nodes.a.shouldCollapseAttribute(str, str2, outputSettings)) {
                appendable.append("=\"");
                if (str2 == null) {
                    str2 = "";
                }
                Entities.b(appendable, str2, outputSettings, true, false);
                appendable.append('\"');
            }
        }
    }

    public final int c(String str) {
        dh.f.notNull(str);
        for (int i10 = 0; i10 < this.f17166b; i10++) {
            if (str.equals(this.f17167m[i10])) {
                return i10;
            }
        }
        return -1;
    }

    public final int d(String str) {
        dh.f.notNull(str);
        for (int i10 = 0; i10 < this.f17166b; i10++) {
            if (str.equalsIgnoreCase(this.f17167m[i10])) {
                return i10;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f17166b == bVar.f17166b && Arrays.equals(this.f17167m, bVar.f17167m)) {
            return Arrays.equals(this.f17168n, bVar.f17168n);
        }
        return false;
    }

    public String get(String str) {
        String str2;
        int iC = c(str);
        return (iC == -1 || (str2 = this.f17168n[iC]) == null) ? "" : str2;
    }

    public String getIgnoreCase(String str) {
        String str2;
        int iD = d(str);
        return (iD == -1 || (str2 = this.f17168n[iD]) == null) ? "" : str2;
    }

    public boolean hasKey(String str) {
        return c(str) != -1;
    }

    public boolean hasKeyIgnoreCase(String str) {
        return d(str) != -1;
    }

    public int hashCode() {
        return (((this.f17166b * 31) + Arrays.hashCode(this.f17167m)) * 31) + Arrays.hashCode(this.f17168n);
    }

    public String html() {
        StringBuilder sb2 = new StringBuilder();
        try {
            b(sb2, new Document("").outputSettings());
            return sb2.toString();
        } catch (IOException e10) {
            throw new SerializationException(e10);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<org.jsoup.nodes.a> iterator() {
        return new a();
    }

    public void normalize() {
        for (int i10 = 0; i10 < this.f17166b; i10++) {
            String[] strArr = this.f17167m;
            strArr[i10] = eh.b.lowerCase(strArr[i10]);
        }
    }

    public b put(String str, String str2) {
        int iC = c(str);
        if (iC != -1) {
            this.f17168n[iC] = str2;
        } else {
            a(this.f17166b + 1);
            String[] strArr = this.f17167m;
            int i10 = this.f17166b;
            strArr[i10] = str;
            this.f17168n[i10] = str2;
            this.f17166b = i10 + 1;
        }
        return this;
    }

    public int size() {
        return this.f17166b;
    }

    public String toString() {
        return html();
    }

    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f17166b = this.f17166b;
            String[] strArr = this.f17167m;
            int i10 = this.f17166b;
            String[] strArr2 = new String[i10];
            System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i10));
            this.f17167m = strArr2;
            String[] strArr3 = this.f17168n;
            int i11 = this.f17166b;
            String[] strArr4 = new String[i11];
            System.arraycopy(strArr3, 0, strArr4, 0, Math.min(strArr3.length, i11));
            this.f17168n = strArr4;
            return bVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public b put(org.jsoup.nodes.a aVar) {
        dh.f.notNull(aVar);
        put(aVar.getKey(), aVar.getValue());
        aVar.f17164n = this;
        return this;
    }
}
