package com.google.android.material.carousel;

import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x6.g;

/* compiled from: KeylineStateList.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f8956a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f8957b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f8958c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f8959d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f8960e;

    /* renamed from: f, reason: collision with root package name */
    public final float f8961f;

    /* renamed from: g, reason: collision with root package name */
    public final float f8962g;

    public c(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f8956a = bVar;
        this.f8957b = Collections.unmodifiableList(arrayList);
        this.f8958c = Collections.unmodifiableList(arrayList2);
        float f10 = ((b) arrayList.get(arrayList.size() - 1)).b().f8948a - bVar.b().f8948a;
        this.f8961f = f10;
        float f11 = bVar.d().f8948a - ((b) arrayList2.get(arrayList2.size() - 1)).d().f8948a;
        this.f8962g = f11;
        this.f8959d = c(f10, arrayList, true);
        this.f8960e = c(f11, arrayList2, false);
    }

    public static float[] c(float f10, ArrayList arrayList, boolean z10) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i10 = 1;
        while (i10 < size) {
            int i11 = i10 - 1;
            b bVar = (b) arrayList.get(i11);
            b bVar2 = (b) arrayList.get(i10);
            fArr[i10] = i10 == size + (-1) ? 1.0f : fArr[i11] + ((z10 ? bVar2.b().f8948a - bVar.b().f8948a : bVar.d().f8948a - bVar2.d().f8948a) / f10);
            i10++;
        }
        return fArr;
    }

    public static b d(b bVar, int i10, int i11, float f10, int i12, int i13, float f11) {
        ArrayList arrayList = new ArrayList(bVar.f8936b);
        arrayList.add(i11, (b.C0084b) arrayList.remove(i10));
        b.a aVar = new b.a(bVar.f8935a, f11);
        float f12 = f10;
        int i14 = 0;
        while (i14 < arrayList.size()) {
            b.C0084b c0084b = (b.C0084b) arrayList.get(i14);
            float f13 = c0084b.f8951d;
            aVar.b((f13 / 2.0f) + f12, c0084b.f8950c, f13, i14 >= i12 && i14 <= i13, c0084b.f8952e, c0084b.f8953f, 0.0f, 0.0f);
            f12 += c0084b.f8951d;
            i14++;
        }
        return aVar.d();
    }

    public static b e(b bVar, float f10, float f11, boolean z10, float f12) {
        int i10;
        List<b.C0084b> list = bVar.f8936b;
        ArrayList arrayList = new ArrayList(list);
        float f13 = bVar.f8935a;
        b.a aVar = new b.a(f13, f11);
        Iterator<b.C0084b> it = list.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (it.next().f8952e) {
                i11++;
            }
        }
        float size = f10 / (list.size() - i11);
        float f14 = z10 ? f10 : 0.0f;
        int i12 = 0;
        while (i12 < arrayList.size()) {
            b.C0084b c0084b = (b.C0084b) arrayList.get(i12);
            if (c0084b.f8952e) {
                i10 = i12;
                aVar.b(c0084b.f8949b, c0084b.f8950c, c0084b.f8951d, false, true, c0084b.f8953f, 0.0f, 0.0f);
            } else {
                i10 = i12;
                boolean z11 = i10 >= bVar.f8937c && i10 <= bVar.f8938d;
                float f15 = c0084b.f8951d - size;
                float fA = g.a(f15, f13, f12);
                float f16 = (f15 / 2.0f) + f14;
                float f17 = f16 - c0084b.f8949b;
                aVar.b(f16, fA, f15, z11, false, c0084b.f8953f, z10 ? f17 : 0.0f, z10 ? 0.0f : f17);
                f14 += f15;
            }
            i12 = i10 + 1;
        }
        return aVar.d();
    }

    public final b a() {
        return this.f8958c.get(r0.size() - 1);
    }

    public final b b() {
        return this.f8957b.get(r0.size() - 1);
    }

    public b getShiftedState(float f10, float f11, float f12) {
        float fLerp;
        List<b> list;
        float[] fArr;
        float[] fArr2;
        float f13 = this.f8961f;
        float f14 = f11 + f13;
        float f15 = this.f8962g;
        float f16 = f12 - f15;
        float f17 = b().a().f8954g;
        float f18 = a().c().f8955h;
        if (f13 == f17) {
            f14 += f17;
        }
        if (f15 == f18) {
            f16 -= f18;
        }
        if (f10 < f14) {
            fLerp = p6.a.lerp(1.0f, 0.0f, f11, f14, f10);
            list = this.f8957b;
            fArr = this.f8959d;
        } else {
            if (f10 <= f16) {
                return this.f8956a;
            }
            fLerp = p6.a.lerp(0.0f, 1.0f, f16, f12, f10);
            list = this.f8958c;
            fArr = this.f8960e;
        }
        int size = list.size();
        float f19 = fArr[0];
        int i10 = 1;
        while (true) {
            if (i10 >= size) {
                fArr2 = new float[]{0.0f, 0.0f, 0.0f};
                break;
            }
            float f20 = fArr[i10];
            if (fLerp <= f20) {
                fArr2 = new float[]{p6.a.lerp(0.0f, 1.0f, f19, f20, fLerp), i10 - 1, i10};
                break;
            }
            i10++;
            f19 = f20;
        }
        b bVar = list.get((int) fArr2[1]);
        b bVar2 = list.get((int) fArr2[2]);
        float f21 = fArr2[0];
        if (bVar.f8935a != bVar2.f8935a) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<b.C0084b> list2 = bVar.f8936b;
        int size2 = list2.size();
        List<b.C0084b> list3 = bVar2.f8936b;
        if (size2 != list3.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list2.size(); i11++) {
            b.C0084b c0084b = list2.get(i11);
            b.C0084b c0084b2 = list3.get(i11);
            arrayList.add(new b.C0084b(p6.a.lerp(c0084b.f8948a, c0084b2.f8948a, f21), p6.a.lerp(c0084b.f8949b, c0084b2.f8949b, f21), p6.a.lerp(c0084b.f8950c, c0084b2.f8950c, f21), p6.a.lerp(c0084b.f8951d, c0084b2.f8951d, f21), false, 0.0f, 0.0f, 0.0f));
        }
        return new b(bVar.f8935a, arrayList, p6.a.lerp(bVar.f8937c, bVar2.f8937c, f21), p6.a.lerp(bVar.f8938d, bVar2.f8938d, f21));
    }
}
