package l6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: SlidingPercentile.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: h, reason: collision with root package name */
    public static final a f15888h = new a();

    /* renamed from: i, reason: collision with root package name */
    public static final b f15889i = new b();

    /* renamed from: a, reason: collision with root package name */
    public final int f15890a;

    /* renamed from: e, reason: collision with root package name */
    public int f15894e;

    /* renamed from: f, reason: collision with root package name */
    public int f15895f;

    /* renamed from: g, reason: collision with root package name */
    public int f15896g;

    /* renamed from: c, reason: collision with root package name */
    public final c[] f15892c = new c[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f15891b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public int f15893d = -1;

    /* compiled from: SlidingPercentile.java */
    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.f15897a - cVar2.f15897a;
        }
    }

    /* compiled from: SlidingPercentile.java */
    public static class b implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            float f10 = cVar.f15899c;
            float f11 = cVar2.f15899c;
            if (f10 < f11) {
                return -1;
            }
            return f11 < f10 ? 1 : 0;
        }
    }

    /* compiled from: SlidingPercentile.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f15897a;

        /* renamed from: b, reason: collision with root package name */
        public int f15898b;

        /* renamed from: c, reason: collision with root package name */
        public float f15899c;
    }

    public o(int i10) {
        this.f15890a = i10;
    }

    public void addSample(int i10, float f10) {
        c cVar;
        int i11 = this.f15893d;
        ArrayList<c> arrayList = this.f15891b;
        if (i11 != 1) {
            Collections.sort(arrayList, f15888h);
            this.f15893d = 1;
        }
        int i12 = this.f15896g;
        c[] cVarArr = this.f15892c;
        if (i12 > 0) {
            int i13 = i12 - 1;
            this.f15896g = i13;
            cVar = cVarArr[i13];
        } else {
            cVar = new c();
        }
        int i14 = this.f15894e;
        this.f15894e = i14 + 1;
        cVar.f15897a = i14;
        cVar.f15898b = i10;
        cVar.f15899c = f10;
        arrayList.add(cVar);
        this.f15895f += i10;
        while (true) {
            int i15 = this.f15895f;
            int i16 = this.f15890a;
            if (i15 <= i16) {
                return;
            }
            int i17 = i15 - i16;
            c cVar2 = arrayList.get(0);
            int i18 = cVar2.f15898b;
            if (i18 <= i17) {
                this.f15895f -= i18;
                arrayList.remove(0);
                int i19 = this.f15896g;
                if (i19 < 5) {
                    this.f15896g = i19 + 1;
                    cVarArr[i19] = cVar2;
                }
            } else {
                cVar2.f15898b = i18 - i17;
                this.f15895f -= i17;
            }
        }
    }

    public float getPercentile(float f10) {
        int i10 = this.f15893d;
        ArrayList<c> arrayList = this.f15891b;
        if (i10 != 0) {
            Collections.sort(arrayList, f15889i);
            this.f15893d = 0;
        }
        float f11 = f10 * this.f15895f;
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            c cVar = arrayList.get(i12);
            i11 += cVar.f15898b;
            if (i11 >= f11) {
                return cVar.f15899c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return arrayList.get(arrayList.size() - 1).f15899c;
    }
}
