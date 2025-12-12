package b2;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Palette.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f4716f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<d> f4717a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b2.c> f4718b;

    /* renamed from: e, reason: collision with root package name */
    public final d f4721e;

    /* renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f4720d = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    public final b0.b f4719c = new b0.b();

    /* compiled from: Palette.java */
    public static class a implements c {
        @Override // b2.b.c
        public boolean isAllowed(int i10, float[] fArr) {
            float f10 = fArr[2];
            if (f10 >= 0.95f) {
                return false;
            }
            if (f10 <= 0.05f) {
                return false;
            }
            float f11 = fArr[0];
            return !((f11 > 10.0f ? 1 : (f11 == 10.0f ? 0 : -1)) >= 0 && (f11 > 37.0f ? 1 : (f11 == 37.0f ? 0 : -1)) <= 0 && (fArr[1] > 0.82f ? 1 : (fArr[1] == 0.82f ? 0 : -1)) <= 0);
        }
    }

    /* compiled from: Palette.java */
    /* renamed from: b2.b$b, reason: collision with other inner class name */
    public static final class C0053b {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f4722a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f4723b;

        /* renamed from: c, reason: collision with root package name */
        public int f4724c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4725d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4726e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f4727f;

        public C0053b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f4723b = arrayList;
            this.f4724c = 16;
            this.f4725d = 12544;
            this.f4726e = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f4727f = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(b.f4716f);
            this.f4722a = bitmap;
            arrayList.add(b2.c.f4737e);
            arrayList.add(b2.c.f4738f);
            arrayList.add(b2.c.f4739g);
            arrayList.add(b2.c.f4740h);
            arrayList.add(b2.c.f4741i);
            arrayList.add(b2.c.f4742j);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b2.b generate() {
            /*
                Method dump skipped, instructions count: 441
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.b.C0053b.generate():b2.b");
        }

        public C0053b maximumColorCount(int i10) {
            this.f4724c = i10;
            return this;
        }
    }

    /* compiled from: Palette.java */
    public interface c {
        boolean isAllowed(int i10, float[] fArr);
    }

    /* compiled from: Palette.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f4728a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4729b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4730c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4731d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4732e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4733f;

        /* renamed from: g, reason: collision with root package name */
        public int f4734g;

        /* renamed from: h, reason: collision with root package name */
        public int f4735h;

        /* renamed from: i, reason: collision with root package name */
        public float[] f4736i;

        public d(int i10, int i11) {
            this.f4728a = Color.red(i10);
            this.f4729b = Color.green(i10);
            this.f4730c = Color.blue(i10);
            this.f4731d = i10;
            this.f4732e = i11;
        }

        public final void a() {
            if (this.f4733f) {
                return;
            }
            int i10 = this.f4731d;
            int iCalculateMinimumAlpha = o0.a.calculateMinimumAlpha(-1, i10, 4.5f);
            int iCalculateMinimumAlpha2 = o0.a.calculateMinimumAlpha(-1, i10, 3.0f);
            if (iCalculateMinimumAlpha != -1 && iCalculateMinimumAlpha2 != -1) {
                this.f4735h = o0.a.setAlphaComponent(-1, iCalculateMinimumAlpha);
                this.f4734g = o0.a.setAlphaComponent(-1, iCalculateMinimumAlpha2);
                this.f4733f = true;
                return;
            }
            int iCalculateMinimumAlpha3 = o0.a.calculateMinimumAlpha(-16777216, i10, 4.5f);
            int iCalculateMinimumAlpha4 = o0.a.calculateMinimumAlpha(-16777216, i10, 3.0f);
            if (iCalculateMinimumAlpha3 == -1 || iCalculateMinimumAlpha4 == -1) {
                this.f4735h = iCalculateMinimumAlpha != -1 ? o0.a.setAlphaComponent(-1, iCalculateMinimumAlpha) : o0.a.setAlphaComponent(-16777216, iCalculateMinimumAlpha3);
                this.f4734g = iCalculateMinimumAlpha2 != -1 ? o0.a.setAlphaComponent(-1, iCalculateMinimumAlpha2) : o0.a.setAlphaComponent(-16777216, iCalculateMinimumAlpha4);
                this.f4733f = true;
            } else {
                this.f4735h = o0.a.setAlphaComponent(-16777216, iCalculateMinimumAlpha3);
                this.f4734g = o0.a.setAlphaComponent(-16777216, iCalculateMinimumAlpha4);
                this.f4733f = true;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4732e == dVar.f4732e && this.f4731d == dVar.f4731d;
        }

        public int getBodyTextColor() {
            a();
            return this.f4735h;
        }

        public float[] getHsl() {
            if (this.f4736i == null) {
                this.f4736i = new float[3];
            }
            o0.a.RGBToHSL(this.f4728a, this.f4729b, this.f4730c, this.f4736i);
            return this.f4736i;
        }

        public int getPopulation() {
            return this.f4732e;
        }

        public int getRgb() {
            return this.f4731d;
        }

        public int getTitleTextColor() {
            a();
            return this.f4734g;
        }

        public int hashCode() {
            return (this.f4731d * 31) + this.f4732e;
        }

        public String toString() {
            return d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.f4732e + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
        }
    }

    public b(ArrayList arrayList, ArrayList arrayList2) {
        this.f4717a = arrayList;
        this.f4718b = arrayList2;
        int size = arrayList.size();
        int population = Integer.MIN_VALUE;
        d dVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar2 = (d) arrayList.get(i10);
            if (dVar2.getPopulation() > population) {
                population = dVar2.getPopulation();
                dVar = dVar2;
            }
        }
        this.f4721e = dVar;
    }

    public static C0053b from(Bitmap bitmap) {
        return new C0053b(bitmap);
    }

    public int getColorForTarget(b2.c cVar, int i10) {
        d swatchForTarget = getSwatchForTarget(cVar);
        return swatchForTarget != null ? swatchForTarget.getRgb() : i10;
    }

    public int getDarkVibrantColor(int i10) {
        return getColorForTarget(b2.c.f4739g, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d getSwatchForTarget(b2.c cVar) {
        return (d) this.f4719c.get(cVar);
    }

    public List<d> getSwatches() {
        return Collections.unmodifiableList(this.f4717a);
    }
}
