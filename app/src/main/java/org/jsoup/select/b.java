package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: CombiningEvaluator.java */
/* loaded from: classes2.dex */
public abstract class b extends c {

    /* renamed from: b, reason: collision with root package name */
    public int f17333b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f17332a = new ArrayList<>();

    /* compiled from: CombiningEvaluator.java */
    public static final class a extends b {
        public a(List list) {
            this.f17332a.addAll(list);
            this.f17333b = this.f17332a.size();
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            for (int i10 = 0; i10 < this.f17333b; i10++) {
                if (!this.f17332a.get(i10).matches(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return dh.e.join(this.f17332a, StringUtils.SPACE);
        }

        public a(c... cVarArr) {
            this(Arrays.asList(cVarArr));
        }
    }

    /* compiled from: CombiningEvaluator.java */
    /* renamed from: org.jsoup.select.b$b, reason: collision with other inner class name */
    public static final class C0215b extends b {
        public C0215b(c... cVarArr) {
            List listAsList = Arrays.asList(cVarArr);
            if (this.f17333b > 1) {
                this.f17332a.add(new a(listAsList));
            } else {
                this.f17332a.addAll(listAsList);
            }
            this.f17333b = this.f17332a.size();
        }

        public void add(c cVar) {
            ArrayList<c> arrayList = this.f17332a;
            arrayList.add(cVar);
            this.f17333b = arrayList.size();
        }

        @Override // org.jsoup.select.c
        public boolean matches(Element element, Element element2) {
            for (int i10 = 0; i10 < this.f17333b; i10++) {
                if (this.f17332a.get(i10).matches(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return dh.e.join(this.f17332a, ", ");
        }

        public C0215b() {
        }
    }
}
