package com.google.android.material.carousel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: KeylineState.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f8935a;

    /* renamed from: b, reason: collision with root package name */
    public final List<C0084b> f8936b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8937c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8938d;

    /* compiled from: KeylineState.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final float f8939a;

        /* renamed from: b, reason: collision with root package name */
        public final float f8940b;

        /* renamed from: d, reason: collision with root package name */
        public C0084b f8942d;

        /* renamed from: e, reason: collision with root package name */
        public C0084b f8943e;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f8941c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public int f8944f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f8945g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f8946h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        public int f8947i = -1;

        public a(float f10, float f11) {
            this.f8939a = f10;
            this.f8940b = f11;
        }

        public final void a(float f10, float f11, float f12, boolean z10, boolean z11) {
            float f13;
            float fAbs;
            float f14 = f12 / 2.0f;
            float f15 = f10 - f14;
            float f16 = f14 + f10;
            float f17 = this.f8940b;
            if (f16 > f17) {
                fAbs = Math.abs(f16 - Math.max(f16 - f12, f17));
            } else {
                if (f15 >= 0.0f) {
                    f13 = 0.0f;
                    b(f10, f11, f12, z10, z11, f13, 0.0f, 0.0f);
                }
                fAbs = Math.abs(f15 - Math.min(f15 + f12, 0.0f));
            }
            f13 = fAbs;
            b(f10, f11, f12, z10, z11, f13, 0.0f, 0.0f);
        }

        public final void b(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14, float f15) {
            if (f12 <= 0.0f) {
                return;
            }
            ArrayList arrayList = this.f8941c;
            if (z11) {
                if (z10) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i10 = this.f8947i;
                if (i10 != -1 && i10 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f8947i = arrayList.size();
            }
            C0084b c0084b = new C0084b(Float.MIN_VALUE, f10, f11, f12, z11, f13, f14, f15);
            if (z10) {
                if (this.f8942d == null) {
                    this.f8942d = c0084b;
                    this.f8944f = arrayList.size();
                }
                if (this.f8945g != -1 && arrayList.size() - this.f8945g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f12 != this.f8942d.f8951d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f8943e = c0084b;
                this.f8945g = arrayList.size();
            } else {
                if (this.f8942d == null && f12 < this.f8946h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f8943e != null && f12 > this.f8946h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f8946h = f12;
            arrayList.add(c0084b);
        }

        public final void c(float f10, float f11, float f12, int i10, boolean z10) {
            if (i10 <= 0 || f12 <= 0.0f) {
                return;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                a((i11 * f12) + f10, f11, f12, z10, false);
            }
        }

        public final b d() {
            if (this.f8942d == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (true) {
                ArrayList arrayList2 = this.f8941c;
                int size = arrayList2.size();
                float f10 = this.f8939a;
                if (i10 >= size) {
                    return new b(f10, arrayList, this.f8944f, this.f8945g);
                }
                C0084b c0084b = (C0084b) arrayList2.get(i10);
                arrayList.add(new C0084b((i10 * f10) + (this.f8942d.f8949b - (this.f8944f * f10)), c0084b.f8949b, c0084b.f8950c, c0084b.f8951d, c0084b.f8952e, c0084b.f8953f, c0084b.f8954g, c0084b.f8955h));
                i10++;
            }
        }
    }

    /* compiled from: KeylineState.java */
    /* renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    public static final class C0084b {

        /* renamed from: a, reason: collision with root package name */
        public final float f8948a;

        /* renamed from: b, reason: collision with root package name */
        public final float f8949b;

        /* renamed from: c, reason: collision with root package name */
        public final float f8950c;

        /* renamed from: d, reason: collision with root package name */
        public final float f8951d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f8952e;

        /* renamed from: f, reason: collision with root package name */
        public final float f8953f;

        /* renamed from: g, reason: collision with root package name */
        public final float f8954g;

        /* renamed from: h, reason: collision with root package name */
        public final float f8955h;

        public C0084b(float f10, float f11, float f12, float f13, boolean z10, float f14, float f15, float f16) {
            this.f8948a = f10;
            this.f8949b = f11;
            this.f8950c = f12;
            this.f8951d = f13;
            this.f8952e = z10;
            this.f8953f = f14;
            this.f8954g = f15;
            this.f8955h = f16;
        }
    }

    public b(float f10, ArrayList arrayList, int i10, int i11) {
        this.f8935a = f10;
        this.f8936b = Collections.unmodifiableList(arrayList);
        this.f8937c = i10;
        this.f8938d = i11;
    }

    public final C0084b a() {
        return this.f8936b.get(this.f8937c);
    }

    public final C0084b b() {
        return this.f8936b.get(0);
    }

    public final C0084b c() {
        return this.f8936b.get(this.f8938d);
    }

    public final C0084b d() {
        return this.f8936b.get(r0.size() - 1);
    }
}
