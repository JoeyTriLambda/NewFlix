package androidx.leanback.widget;

import org.apache.commons.lang3.StringUtils;

/* compiled from: WindowAlignment.java */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final a f3198a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3199b;

    /* renamed from: c, reason: collision with root package name */
    public a f3200c;

    /* renamed from: d, reason: collision with root package name */
    public a f3201d;

    /* compiled from: WindowAlignment.java */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public int f3204c;

        /* renamed from: d, reason: collision with root package name */
        public int f3205d;

        /* renamed from: i, reason: collision with root package name */
        public int f3210i;

        /* renamed from: j, reason: collision with root package name */
        public int f3211j;

        /* renamed from: k, reason: collision with root package name */
        public int f3212k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f3213l;

        /* renamed from: e, reason: collision with root package name */
        public int f3206e = 2;

        /* renamed from: f, reason: collision with root package name */
        public int f3207f = 3;

        /* renamed from: g, reason: collision with root package name */
        public int f3208g = 0;

        /* renamed from: h, reason: collision with root package name */
        public float f3209h = 50.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f3203b = Integer.MIN_VALUE;

        /* renamed from: a, reason: collision with root package name */
        public int f3202a = Integer.MAX_VALUE;

        public a(String str) {
        }

        public final int a() {
            if (this.f3213l) {
                int i10 = this.f3208g;
                int i11 = i10 >= 0 ? this.f3210i - i10 : -i10;
                float f10 = this.f3209h;
                return f10 != -1.0f ? i11 - ((int) ((this.f3210i * f10) / 100.0f)) : i11;
            }
            int i12 = this.f3208g;
            if (i12 < 0) {
                i12 += this.f3210i;
            }
            float f11 = this.f3209h;
            return f11 != -1.0f ? i12 + ((int) ((this.f3210i * f11) / 100.0f)) : i12;
        }

        public final int getClientSize() {
            return (this.f3210i - this.f3211j) - this.f3212k;
        }

        public final int getMaxScroll() {
            return this.f3204c;
        }

        public final int getMinScroll() {
            return this.f3205d;
        }

        public final int getPaddingMax() {
            return this.f3212k;
        }

        public final int getPaddingMin() {
            return this.f3211j;
        }

        public final int getScroll(int i10) {
            int i11;
            int i12;
            int size = getSize();
            int iA = a();
            boolean zIsMinUnknown = isMinUnknown();
            boolean zIsMaxUnknown = isMaxUnknown();
            if (!zIsMinUnknown) {
                int i13 = this.f3211j;
                int i14 = iA - i13;
                if (this.f3213l ? (this.f3207f & 2) != 0 : (this.f3207f & 1) != 0) {
                    int i15 = this.f3203b;
                    if (i10 - i15 <= i14) {
                        int i16 = i15 - i13;
                        return (zIsMaxUnknown || i16 <= (i12 = this.f3204c)) ? i16 : i12;
                    }
                }
            }
            if (!zIsMaxUnknown) {
                int i17 = this.f3212k;
                int i18 = (size - iA) - i17;
                if (this.f3213l ? (this.f3207f & 1) != 0 : (this.f3207f & 2) != 0) {
                    int i19 = this.f3202a;
                    if (i19 - i10 <= i18) {
                        int i20 = i19 - (size - i17);
                        return (zIsMinUnknown || i20 >= (i11 = this.f3205d)) ? i20 : i11;
                    }
                }
            }
            return i10 - iA;
        }

        public final int getSize() {
            return this.f3210i;
        }

        public final int getWindowAlignment() {
            return this.f3207f;
        }

        public final int getWindowAlignmentOffset() {
            return this.f3208g;
        }

        public final float getWindowAlignmentOffsetPercent() {
            return this.f3209h;
        }

        public final void invalidateScrollMax() {
            this.f3202a = Integer.MAX_VALUE;
            this.f3204c = Integer.MAX_VALUE;
        }

        public final void invalidateScrollMin() {
            this.f3203b = Integer.MIN_VALUE;
            this.f3205d = Integer.MIN_VALUE;
        }

        public final boolean isMaxUnknown() {
            return this.f3202a == Integer.MAX_VALUE;
        }

        public final boolean isMinUnknown() {
            return this.f3203b == Integer.MIN_VALUE;
        }

        public final void setPadding(int i10, int i11) {
            this.f3211j = i10;
            this.f3212k = i11;
        }

        public final void setReversedFlow(boolean z10) {
            this.f3213l = z10;
        }

        public final void setSize(int i10) {
            this.f3210i = i10;
        }

        public final void setWindowAlignment(int i10) {
            this.f3207f = i10;
        }

        public final void setWindowAlignmentOffset(int i10) {
            this.f3208g = i10;
        }

        public final void setWindowAlignmentOffsetPercent(float f10) {
            if ((f10 < 0.0f || f10 > 100.0f) && f10 != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.f3209h = f10;
        }

        public String toString() {
            return " min:" + this.f3203b + StringUtils.SPACE + this.f3205d + " max:" + this.f3202a + StringUtils.SPACE + this.f3204c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            r5.f3205d = r5.f3203b - r5.f3211j;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            r5.f3204c = (r5.f3202a - r5.f3211j) - r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void updateMinMax(int r6, int r7, int r8, int r9) {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.c1.a.updateMinMax(int, int, int, int):void");
        }
    }

    public c1() {
        a aVar = new a("vertical");
        this.f3198a = aVar;
        a aVar2 = new a("horizontal");
        this.f3199b = aVar2;
        this.f3200c = aVar2;
        this.f3201d = aVar;
    }

    public final a mainAxis() {
        return this.f3200c;
    }

    public final void reset() {
        a aVarMainAxis = mainAxis();
        aVarMainAxis.f3203b = Integer.MIN_VALUE;
        aVarMainAxis.f3202a = Integer.MAX_VALUE;
    }

    public final a secondAxis() {
        return this.f3201d;
    }

    public final void setOrientation(int i10) {
        a aVar = this.f3199b;
        a aVar2 = this.f3198a;
        if (i10 == 0) {
            this.f3200c = aVar;
            this.f3201d = aVar2;
        } else {
            this.f3200c = aVar2;
            this.f3201d = aVar;
        }
    }

    public String toString() {
        return "horizontal=" + this.f3199b + "; vertical=" + this.f3198a;
    }
}
