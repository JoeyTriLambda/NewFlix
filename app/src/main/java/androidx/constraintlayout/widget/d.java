package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.e;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintSet.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1973d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f1974e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f1975f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, ConstraintAttribute> f1976a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1977b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a> f1978c = new HashMap<>();

    /* compiled from: ConstraintSet.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1979a;

        /* renamed from: b, reason: collision with root package name */
        public final C0020d f1980b = new C0020d();

        /* renamed from: c, reason: collision with root package name */
        public final c f1981c = new c();

        /* renamed from: d, reason: collision with root package name */
        public final b f1982d = new b();

        /* renamed from: e, reason: collision with root package name */
        public final e f1983e = new e();

        /* renamed from: f, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f1984f = new HashMap<>();

        /* compiled from: ConstraintSet.java */
        /* renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        public static class C0019a {

            /* renamed from: a, reason: collision with root package name */
            public int[] f1985a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            public int[] f1986b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            public int f1987c = 0;

            /* renamed from: d, reason: collision with root package name */
            public int[] f1988d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            public float[] f1989e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            public int f1990f = 0;

            /* renamed from: g, reason: collision with root package name */
            public int[] f1991g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            public String[] f1992h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            public int f1993i = 0;

            /* renamed from: j, reason: collision with root package name */
            public int[] f1994j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            public boolean[] f1995k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            public int f1996l = 0;

            public final void a(float f10, int i10) {
                int i11 = this.f1990f;
                int[] iArr = this.f1988d;
                if (i11 >= iArr.length) {
                    this.f1988d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1989e;
                    this.f1989e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1988d;
                int i12 = this.f1990f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f1989e;
                this.f1990f = i12 + 1;
                fArr2[i12] = f10;
            }

            public final void b(int i10, int i11) {
                int i12 = this.f1987c;
                int[] iArr = this.f1985a;
                if (i12 >= iArr.length) {
                    this.f1985a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1986b;
                    this.f1986b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1985a;
                int i13 = this.f1987c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f1986b;
                this.f1987c = i13 + 1;
                iArr4[i13] = i11;
            }

            public final void c(int i10, String str) {
                int i11 = this.f1993i;
                int[] iArr = this.f1991g;
                if (i11 >= iArr.length) {
                    this.f1991g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f1992h;
                    this.f1992h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1991g;
                int i12 = this.f1993i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f1992h;
                this.f1993i = i12 + 1;
                strArr2[i12] = str;
            }

            public final void d(int i10, boolean z10) {
                int i11 = this.f1996l;
                int[] iArr = this.f1994j;
                if (i11 >= iArr.length) {
                    this.f1994j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1995k;
                    this.f1995k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1994j;
                int i12 = this.f1996l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f1995k;
                this.f1996l = i12 + 1;
                zArr2[i12] = z10;
            }
        }

        public final void a(int i10, ConstraintLayout.a aVar) {
            this.f1979a = i10;
            int i11 = aVar.f1902e;
            b bVar = this.f1982d;
            bVar.f2012h = i11;
            bVar.f2014i = aVar.f1904f;
            bVar.f2016j = aVar.f1906g;
            bVar.f2018k = aVar.f1908h;
            bVar.f2020l = aVar.f1910i;
            bVar.f2022m = aVar.f1912j;
            bVar.f2024n = aVar.f1914k;
            bVar.f2026o = aVar.f1916l;
            bVar.f2028p = aVar.f1918m;
            bVar.f2029q = aVar.f1920n;
            bVar.f2030r = aVar.f1922o;
            bVar.f2031s = aVar.f1929s;
            bVar.f2032t = aVar.f1930t;
            bVar.f2033u = aVar.f1931u;
            bVar.f2034v = aVar.f1932v;
            bVar.f2035w = aVar.E;
            bVar.f2036x = aVar.F;
            bVar.f2037y = aVar.G;
            bVar.f2038z = aVar.f1924p;
            bVar.A = aVar.f1926q;
            bVar.B = aVar.f1928r;
            bVar.C = aVar.T;
            bVar.D = aVar.U;
            bVar.E = aVar.V;
            bVar.f2008f = aVar.f1898c;
            bVar.f2004d = aVar.f1894a;
            bVar.f2006e = aVar.f1896b;
            bVar.f2000b = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar.f2002c = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar.F = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar.G = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar.H = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar.I = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar.L = aVar.D;
            bVar.T = aVar.I;
            bVar.U = aVar.H;
            bVar.W = aVar.K;
            bVar.V = aVar.J;
            bVar.f2021l0 = aVar.W;
            bVar.f2023m0 = aVar.X;
            bVar.X = aVar.L;
            bVar.Y = aVar.M;
            bVar.Z = aVar.P;
            bVar.f1999a0 = aVar.Q;
            bVar.f2001b0 = aVar.N;
            bVar.f2003c0 = aVar.O;
            bVar.f2005d0 = aVar.R;
            bVar.f2007e0 = aVar.S;
            bVar.f2019k0 = aVar.Y;
            bVar.N = aVar.f1934x;
            bVar.P = aVar.f1936z;
            bVar.M = aVar.f1933w;
            bVar.O = aVar.f1935y;
            bVar.R = aVar.A;
            bVar.Q = aVar.B;
            bVar.S = aVar.C;
            bVar.f2027o0 = aVar.Z;
            bVar.J = aVar.getMarginEnd();
            bVar.K = aVar.getMarginStart();
        }

        public void applyTo(ConstraintLayout.a aVar) {
            b bVar = this.f1982d;
            aVar.f1902e = bVar.f2012h;
            aVar.f1904f = bVar.f2014i;
            aVar.f1906g = bVar.f2016j;
            aVar.f1908h = bVar.f2018k;
            aVar.f1910i = bVar.f2020l;
            aVar.f1912j = bVar.f2022m;
            aVar.f1914k = bVar.f2024n;
            aVar.f1916l = bVar.f2026o;
            aVar.f1918m = bVar.f2028p;
            aVar.f1920n = bVar.f2029q;
            aVar.f1922o = bVar.f2030r;
            aVar.f1929s = bVar.f2031s;
            aVar.f1930t = bVar.f2032t;
            aVar.f1931u = bVar.f2033u;
            aVar.f1932v = bVar.f2034v;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.G;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.I;
            aVar.A = bVar.R;
            aVar.B = bVar.Q;
            aVar.f1934x = bVar.N;
            aVar.f1936z = bVar.P;
            aVar.E = bVar.f2035w;
            aVar.F = bVar.f2036x;
            aVar.f1924p = bVar.f2038z;
            aVar.f1926q = bVar.A;
            aVar.f1928r = bVar.B;
            aVar.G = bVar.f2037y;
            aVar.T = bVar.C;
            aVar.U = bVar.D;
            aVar.I = bVar.T;
            aVar.H = bVar.U;
            aVar.K = bVar.W;
            aVar.J = bVar.V;
            aVar.W = bVar.f2021l0;
            aVar.X = bVar.f2023m0;
            aVar.L = bVar.X;
            aVar.M = bVar.Y;
            aVar.P = bVar.Z;
            aVar.Q = bVar.f1999a0;
            aVar.N = bVar.f2001b0;
            aVar.O = bVar.f2003c0;
            aVar.R = bVar.f2005d0;
            aVar.S = bVar.f2007e0;
            aVar.V = bVar.E;
            aVar.f1898c = bVar.f2008f;
            aVar.f1894a = bVar.f2004d;
            aVar.f1896b = bVar.f2006e;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar.f2000b;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar.f2002c;
            String str = bVar.f2019k0;
            if (str != null) {
                aVar.Y = str;
            }
            aVar.Z = bVar.f2027o0;
            aVar.setMarginStart(bVar.K);
            aVar.setMarginEnd(bVar.J);
            aVar.validate();
        }

        public final void b(int i10, e.a aVar) {
            a(i10, aVar);
            this.f1980b.f2051c = aVar.f2068r0;
            float f10 = aVar.f2071u0;
            e eVar = this.f1983e;
            eVar.f2054a = f10;
            eVar.f2055b = aVar.f2072v0;
            eVar.f2056c = aVar.f2073w0;
            eVar.f2057d = aVar.f2074x0;
            eVar.f2058e = aVar.f2075y0;
            eVar.f2059f = aVar.f2076z0;
            eVar.f2060g = aVar.A0;
            eVar.f2062i = aVar.B0;
            eVar.f2063j = aVar.C0;
            eVar.f2064k = aVar.D0;
            eVar.f2066m = aVar.f2070t0;
            eVar.f2065l = aVar.f2069s0;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a m3clone() {
            a aVar = new a();
            aVar.f1982d.copyFrom(this.f1982d);
            aVar.f1981c.copyFrom(this.f1981c);
            aVar.f1980b.copyFrom(this.f1980b);
            aVar.f1983e.copyFrom(this.f1983e);
            aVar.f1979a = this.f1979a;
            return aVar;
        }
    }

    /* compiled from: ConstraintSet.java */
    public static class b {

        /* renamed from: p0, reason: collision with root package name */
        public static final SparseIntArray f1997p0;

        /* renamed from: b, reason: collision with root package name */
        public int f2000b;

        /* renamed from: c, reason: collision with root package name */
        public int f2002c;

        /* renamed from: i0, reason: collision with root package name */
        public int[] f2015i0;

        /* renamed from: j0, reason: collision with root package name */
        public String f2017j0;

        /* renamed from: k0, reason: collision with root package name */
        public String f2019k0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1998a = false;

        /* renamed from: d, reason: collision with root package name */
        public int f2004d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f2006e = -1;

        /* renamed from: f, reason: collision with root package name */
        public float f2008f = -1.0f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2010g = true;

        /* renamed from: h, reason: collision with root package name */
        public int f2012h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f2014i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f2016j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f2018k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f2020l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f2022m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f2024n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f2026o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f2028p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f2029q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f2030r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f2031s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f2032t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f2033u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f2034v = -1;

        /* renamed from: w, reason: collision with root package name */
        public float f2035w = 0.5f;

        /* renamed from: x, reason: collision with root package name */
        public float f2036x = 0.5f;

        /* renamed from: y, reason: collision with root package name */
        public String f2037y = null;

        /* renamed from: z, reason: collision with root package name */
        public int f2038z = -1;
        public int A = 0;
        public float B = 0.0f;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1.0f;
        public float U = -1.0f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f1999a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f2001b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f2003c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public float f2005d0 = 1.0f;

        /* renamed from: e0, reason: collision with root package name */
        public float f2007e0 = 1.0f;

        /* renamed from: f0, reason: collision with root package name */
        public int f2009f0 = -1;

        /* renamed from: g0, reason: collision with root package name */
        public int f2011g0 = 0;

        /* renamed from: h0, reason: collision with root package name */
        public int f2013h0 = -1;

        /* renamed from: l0, reason: collision with root package name */
        public boolean f2021l0 = false;

        /* renamed from: m0, reason: collision with root package name */
        public boolean f2023m0 = false;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f2025n0 = true;

        /* renamed from: o0, reason: collision with root package name */
        public int f2027o0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1997p0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            sparseIntArray.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            sparseIntArray.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            sparseIntArray.append(R.styleable.Layout_guidelineUseRtl, 90);
            sparseIntArray.append(R.styleable.Layout_android_orientation, 26);
            sparseIntArray.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            sparseIntArray.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            sparseIntArray.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            sparseIntArray.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginTop, 16);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginRight, 14);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginStart, 15);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            sparseIntArray.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginLeft, 23);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginRight, 27);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginStart, 30);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginEnd, 8);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginTop, 33);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginBottom, 2);
            sparseIntArray.append(R.styleable.Layout_android_layout_width, 22);
            sparseIntArray.append(R.styleable.Layout_android_layout_height, 21);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth, 41);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight, 42);
            sparseIntArray.append(R.styleable.Layout_layout_constrainedWidth, 41);
            sparseIntArray.append(R.styleable.Layout_layout_constrainedHeight, 42);
            sparseIntArray.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircle, 61);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            sparseIntArray.append(R.styleable.Layout_chainUseRtl, 71);
            sparseIntArray.append(R.styleable.Layout_barrierDirection, 72);
            sparseIntArray.append(R.styleable.Layout_barrierMargin, 73);
            sparseIntArray.append(R.styleable.Layout_constraint_referenced_ids, 74);
            sparseIntArray.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                SparseIntArray sparseIntArray = f1997p0;
                int i11 = sparseIntArray.get(index);
                switch (i11) {
                    case 1:
                        this.f2028p = d.d(typedArrayObtainStyledAttributes, index, this.f2028p);
                        break;
                    case 2:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 3:
                        this.f2026o = d.d(typedArrayObtainStyledAttributes, index, this.f2026o);
                        break;
                    case 4:
                        this.f2024n = d.d(typedArrayObtainStyledAttributes, index, this.f2024n);
                        break;
                    case 5:
                        this.f2037y = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                        break;
                    case 7:
                        this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 8:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 9:
                        this.f2034v = d.d(typedArrayObtainStyledAttributes, index, this.f2034v);
                        break;
                    case 10:
                        this.f2033u = d.d(typedArrayObtainStyledAttributes, index, this.f2033u);
                        break;
                    case 11:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 12:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 13:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 14:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 15:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 16:
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 17:
                        this.f2004d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2004d);
                        break;
                    case 18:
                        this.f2006e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2006e);
                        break;
                    case 19:
                        this.f2008f = typedArrayObtainStyledAttributes.getFloat(index, this.f2008f);
                        break;
                    case 20:
                        this.f2035w = typedArrayObtainStyledAttributes.getFloat(index, this.f2035w);
                        break;
                    case 21:
                        this.f2002c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f2002c);
                        break;
                    case 22:
                        this.f2000b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f2000b);
                        break;
                    case 23:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case 24:
                        this.f2012h = d.d(typedArrayObtainStyledAttributes, index, this.f2012h);
                        break;
                    case 25:
                        this.f2014i = d.d(typedArrayObtainStyledAttributes, index, this.f2014i);
                        break;
                    case 26:
                        this.E = typedArrayObtainStyledAttributes.getInt(index, this.E);
                        break;
                    case 27:
                        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 28:
                        this.f2016j = d.d(typedArrayObtainStyledAttributes, index, this.f2016j);
                        break;
                    case 29:
                        this.f2018k = d.d(typedArrayObtainStyledAttributes, index, this.f2018k);
                        break;
                    case 30:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 31:
                        this.f2031s = d.d(typedArrayObtainStyledAttributes, index, this.f2031s);
                        break;
                    case 32:
                        this.f2032t = d.d(typedArrayObtainStyledAttributes, index, this.f2032t);
                        break;
                    case 33:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 34:
                        this.f2022m = d.d(typedArrayObtainStyledAttributes, index, this.f2022m);
                        break;
                    case 35:
                        this.f2020l = d.d(typedArrayObtainStyledAttributes, index, this.f2020l);
                        break;
                    case 36:
                        this.f2036x = typedArrayObtainStyledAttributes.getFloat(index, this.f2036x);
                        break;
                    case 37:
                        this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case 38:
                        this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                        break;
                    case 39:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 40:
                        this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 41:
                        d.e(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        d.e(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.f2038z = d.d(typedArrayObtainStyledAttributes, index, this.f2038z);
                                break;
                            case 62:
                                this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                break;
                            case 63:
                                this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f2005d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f2007e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f2009f0 = typedArrayObtainStyledAttributes.getInt(index, this.f2009f0);
                                        break;
                                    case 73:
                                        this.f2011g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2011g0);
                                        break;
                                    case 74:
                                        this.f2017j0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f2025n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f2025n0);
                                        break;
                                    case 76:
                                        this.f2027o0 = typedArrayObtainStyledAttributes.getInt(index, this.f2027o0);
                                        break;
                                    case 77:
                                        this.f2029q = d.d(typedArrayObtainStyledAttributes, index, this.f2029q);
                                        break;
                                    case 78:
                                        this.f2030r = d.d(typedArrayObtainStyledAttributes, index, this.f2030r);
                                        break;
                                    case 79:
                                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                        break;
                                    case 80:
                                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                        break;
                                    case 81:
                                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                                        break;
                                    case 82:
                                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                        break;
                                    case 83:
                                        this.f1999a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1999a0);
                                        break;
                                    case 84:
                                        this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                        break;
                                    case 85:
                                        this.f2003c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2003c0);
                                        break;
                                    case 86:
                                        this.f2001b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2001b0);
                                        break;
                                    case 87:
                                        this.f2021l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f2021l0);
                                        break;
                                    case 88:
                                        this.f2023m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f2023m0);
                                        break;
                                    case 89:
                                        this.f2019k0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f2010g = typedArrayObtainStyledAttributes.getBoolean(index, this.f2010g);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void copyFrom(b bVar) {
            this.f1998a = bVar.f1998a;
            this.f2000b = bVar.f2000b;
            this.f2002c = bVar.f2002c;
            this.f2004d = bVar.f2004d;
            this.f2006e = bVar.f2006e;
            this.f2008f = bVar.f2008f;
            this.f2010g = bVar.f2010g;
            this.f2012h = bVar.f2012h;
            this.f2014i = bVar.f2014i;
            this.f2016j = bVar.f2016j;
            this.f2018k = bVar.f2018k;
            this.f2020l = bVar.f2020l;
            this.f2022m = bVar.f2022m;
            this.f2024n = bVar.f2024n;
            this.f2026o = bVar.f2026o;
            this.f2028p = bVar.f2028p;
            this.f2029q = bVar.f2029q;
            this.f2030r = bVar.f2030r;
            this.f2031s = bVar.f2031s;
            this.f2032t = bVar.f2032t;
            this.f2033u = bVar.f2033u;
            this.f2034v = bVar.f2034v;
            this.f2035w = bVar.f2035w;
            this.f2036x = bVar.f2036x;
            this.f2037y = bVar.f2037y;
            this.f2038z = bVar.f2038z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f1999a0 = bVar.f1999a0;
            this.f2001b0 = bVar.f2001b0;
            this.f2003c0 = bVar.f2003c0;
            this.f2005d0 = bVar.f2005d0;
            this.f2007e0 = bVar.f2007e0;
            this.f2009f0 = bVar.f2009f0;
            this.f2011g0 = bVar.f2011g0;
            this.f2013h0 = bVar.f2013h0;
            this.f2019k0 = bVar.f2019k0;
            int[] iArr = bVar.f2015i0;
            if (iArr == null || bVar.f2017j0 != null) {
                this.f2015i0 = null;
            } else {
                this.f2015i0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f2017j0 = bVar.f2017j0;
            this.f2021l0 = bVar.f2021l0;
            this.f2023m0 = bVar.f2023m0;
            this.f2025n0 = bVar.f2025n0;
            this.f2027o0 = bVar.f2027o0;
        }
    }

    /* compiled from: ConstraintSet.java */
    public static class c {

        /* renamed from: j, reason: collision with root package name */
        public static final SparseIntArray f2039j;

        /* renamed from: a, reason: collision with root package name */
        public int f2040a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f2041b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f2042c = -1;

        /* renamed from: d, reason: collision with root package name */
        public float f2043d = Float.NaN;

        /* renamed from: e, reason: collision with root package name */
        public float f2044e = Float.NaN;

        /* renamed from: f, reason: collision with root package name */
        public float f2045f = Float.NaN;

        /* renamed from: g, reason: collision with root package name */
        public int f2046g = -1;

        /* renamed from: h, reason: collision with root package name */
        public String f2047h = null;

        /* renamed from: i, reason: collision with root package name */
        public int f2048i = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2039j = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            sparseIntArray.append(R.styleable.Motion_pathMotionArc, 2);
            sparseIntArray.append(R.styleable.Motion_transitionEasing, 3);
            sparseIntArray.append(R.styleable.Motion_drawPath, 4);
            sparseIntArray.append(R.styleable.Motion_animateRelativeTo, 5);
            sparseIntArray.append(R.styleable.Motion_animateCircleAngleTo, 6);
            sparseIntArray.append(R.styleable.Motion_motionStagger, 7);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionSteps, 8);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionPhase, 9);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f2039j.get(index)) {
                    case 1:
                        this.f2044e = typedArrayObtainStyledAttributes.getFloat(index, this.f2044e);
                        break;
                    case 2:
                        this.f2042c = typedArrayObtainStyledAttributes.getInt(index, this.f2042c);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            String str = e0.a.f11112b[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f2040a = d.d(typedArrayObtainStyledAttributes, index, this.f2040a);
                        break;
                    case 6:
                        this.f2041b = typedArrayObtainStyledAttributes.getInteger(index, this.f2041b);
                        break;
                    case 7:
                        this.f2043d = typedArrayObtainStyledAttributes.getFloat(index, this.f2043d);
                        break;
                    case 8:
                        this.f2046g = typedArrayObtainStyledAttributes.getInteger(index, this.f2046g);
                        break;
                    case 9:
                        this.f2045f = typedArrayObtainStyledAttributes.getFloat(index, this.f2045f);
                        break;
                    case 10:
                        int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            this.f2048i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else if (i11 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f2047h = string;
                            if (string.indexOf("/") > 0) {
                                this.f2048i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index, this.f2048i);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void copyFrom(c cVar) {
            cVar.getClass();
            this.f2040a = cVar.f2040a;
            this.f2042c = cVar.f2042c;
            this.f2044e = cVar.f2044e;
            this.f2043d = cVar.f2043d;
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0020d {

        /* renamed from: a, reason: collision with root package name */
        public int f2049a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f2050b = 0;

        /* renamed from: c, reason: collision with root package name */
        public float f2051c = 1.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f2052d = Float.NaN;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f2051c = typedArrayObtainStyledAttributes.getFloat(index, this.f2051c);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f2049a);
                    this.f2049a = i11;
                    this.f2049a = d.f1973d[i11];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f2050b = typedArrayObtainStyledAttributes.getInt(index, this.f2050b);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f2052d = typedArrayObtainStyledAttributes.getFloat(index, this.f2052d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void copyFrom(C0020d c0020d) {
            c0020d.getClass();
            this.f2049a = c0020d.f2049a;
            this.f2051c = c0020d.f2051c;
            this.f2052d = c0020d.f2052d;
            this.f2050b = c0020d.f2050b;
        }
    }

    /* compiled from: ConstraintSet.java */
    public static class e {

        /* renamed from: n, reason: collision with root package name */
        public static final SparseIntArray f2053n;

        /* renamed from: a, reason: collision with root package name */
        public float f2054a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f2055b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f2056c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f2057d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f2058e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f2059f = Float.NaN;

        /* renamed from: g, reason: collision with root package name */
        public float f2060g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f2061h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f2062i = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        public float f2063j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f2064k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public boolean f2065l = false;

        /* renamed from: m, reason: collision with root package name */
        public float f2066m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2053n = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            sparseIntArray.append(R.styleable.Transform_android_rotationX, 2);
            sparseIntArray.append(R.styleable.Transform_android_rotationY, 3);
            sparseIntArray.append(R.styleable.Transform_android_scaleX, 4);
            sparseIntArray.append(R.styleable.Transform_android_scaleY, 5);
            sparseIntArray.append(R.styleable.Transform_android_transformPivotX, 6);
            sparseIntArray.append(R.styleable.Transform_android_transformPivotY, 7);
            sparseIntArray.append(R.styleable.Transform_android_translationX, 8);
            sparseIntArray.append(R.styleable.Transform_android_translationY, 9);
            sparseIntArray.append(R.styleable.Transform_android_translationZ, 10);
            sparseIntArray.append(R.styleable.Transform_android_elevation, 11);
            sparseIntArray.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f2053n.get(index)) {
                    case 1:
                        this.f2054a = typedArrayObtainStyledAttributes.getFloat(index, this.f2054a);
                        break;
                    case 2:
                        this.f2055b = typedArrayObtainStyledAttributes.getFloat(index, this.f2055b);
                        break;
                    case 3:
                        this.f2056c = typedArrayObtainStyledAttributes.getFloat(index, this.f2056c);
                        break;
                    case 4:
                        this.f2057d = typedArrayObtainStyledAttributes.getFloat(index, this.f2057d);
                        break;
                    case 5:
                        this.f2058e = typedArrayObtainStyledAttributes.getFloat(index, this.f2058e);
                        break;
                    case 6:
                        this.f2059f = typedArrayObtainStyledAttributes.getDimension(index, this.f2059f);
                        break;
                    case 7:
                        this.f2060g = typedArrayObtainStyledAttributes.getDimension(index, this.f2060g);
                        break;
                    case 8:
                        this.f2062i = typedArrayObtainStyledAttributes.getDimension(index, this.f2062i);
                        break;
                    case 9:
                        this.f2063j = typedArrayObtainStyledAttributes.getDimension(index, this.f2063j);
                        break;
                    case 10:
                        this.f2064k = typedArrayObtainStyledAttributes.getDimension(index, this.f2064k);
                        break;
                    case 11:
                        this.f2065l = true;
                        this.f2066m = typedArrayObtainStyledAttributes.getDimension(index, this.f2066m);
                        break;
                    case 12:
                        this.f2061h = d.d(typedArrayObtainStyledAttributes, index, this.f2061h);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void copyFrom(e eVar) {
            eVar.getClass();
            this.f2054a = eVar.f2054a;
            this.f2055b = eVar.f2055b;
            this.f2056c = eVar.f2056c;
            this.f2057d = eVar.f2057d;
            this.f2058e = eVar.f2058e;
            this.f2059f = eVar.f2059f;
            this.f2060g = eVar.f2060g;
            this.f2061h = eVar.f2061h;
            this.f2062i = eVar.f2062i;
            this.f2063j = eVar.f2063j;
            this.f2064k = eVar.f2064k;
            this.f2065l = eVar.f2065l;
            this.f2066m = eVar.f2066m;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1974e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f1975f = sparseIntArray2;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(R.styleable.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(R.styleable.Constraint_android_orientation, 27);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(R.styleable.Constraint_android_layout_width, 23);
        sparseIntArray.append(R.styleable.Constraint_android_layout_height, 21);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(R.styleable.Constraint_android_visibility, 22);
        sparseIntArray.append(R.styleable.Constraint_android_alpha, 43);
        sparseIntArray.append(R.styleable.Constraint_android_elevation, 44);
        sparseIntArray.append(R.styleable.Constraint_android_rotationX, 45);
        sparseIntArray.append(R.styleable.Constraint_android_rotationY, 46);
        sparseIntArray.append(R.styleable.Constraint_android_rotation, 60);
        sparseIntArray.append(R.styleable.Constraint_android_scaleX, 47);
        sparseIntArray.append(R.styleable.Constraint_android_scaleY, 48);
        sparseIntArray.append(R.styleable.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(R.styleable.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(R.styleable.Constraint_android_translationX, 51);
        sparseIntArray.append(R.styleable.Constraint_android_translationY, 52);
        sparseIntArray.append(R.styleable.Constraint_android_translationZ, 53);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(R.styleable.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(R.styleable.Constraint_transitionEasing, 65);
        sparseIntArray.append(R.styleable.Constraint_drawPath, 66);
        sparseIntArray.append(R.styleable.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(R.styleable.Constraint_motionStagger, 79);
        sparseIntArray.append(R.styleable.Constraint_android_id, 38);
        sparseIntArray.append(R.styleable.Constraint_motionProgress, 68);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(R.styleable.Constraint_chainUseRtl, 71);
        sparseIntArray.append(R.styleable.Constraint_barrierDirection, 72);
        sparseIntArray.append(R.styleable.Constraint_barrierMargin, 73);
        sparseIntArray.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(R.styleable.Constraint_pathMotionArc, 76);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(R.styleable.Constraint_visibilityMode, 78);
        sparseIntArray.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(R.styleable.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(R.styleable.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        int i10 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray2.append(i10, 6);
        sparseIntArray2.append(i10, 7);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(R.styleable.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int[] b(androidx.constraintlayout.widget.a aVar, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < strArrSplit.length) {
            String strTrim = strArrSplit[i10].trim();
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) aVar.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i11] = iIntValue;
            i10++;
            i11++;
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public static a c(Context context, AttributeSet attributeSet, boolean z10) {
        String str;
        int[] iArr;
        String str2;
        a.C0019a c0019a;
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        int[] iArr2 = f1973d;
        SparseIntArray sparseIntArray = f1974e;
        C0020d c0020d = aVar.f1980b;
        e eVar = aVar.f1983e;
        c cVar = aVar.f1981c;
        b bVar = aVar.f1982d;
        String str3 = "unused attribute 0x";
        if (z10) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            a.C0019a c0019a2 = new a.C0019a();
            cVar.getClass();
            bVar.getClass();
            c0020d.getClass();
            eVar.getClass();
            String str4 = "Unknown attribute 0x";
            int i10 = 0;
            while (i10 < indexCount) {
                int i11 = indexCount;
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i12 = i10;
                switch (f1975f.get(index)) {
                    case 2:
                        iArr = iArr2;
                        c0019a2.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.I));
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        iArr = iArr2;
                        str2 = str4;
                        StringBuilder sb2 = new StringBuilder(str2);
                        c0019a = c0019a2;
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb2.toString());
                        continue;
                        indexCount = i11;
                        c0019a2 = c0019a;
                        str4 = str2;
                        i10 = i12 + 1;
                        iArr2 = iArr;
                    case 5:
                        iArr = iArr2;
                        c0019a2.c(5, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 6:
                        iArr = iArr2;
                        c0019a2.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.C));
                        break;
                    case 7:
                        iArr = iArr2;
                        c0019a2.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.D));
                        break;
                    case 8:
                        iArr = iArr2;
                        c0019a2.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.J));
                        break;
                    case 11:
                        iArr = iArr2;
                        c0019a2.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.P));
                        break;
                    case 12:
                        iArr = iArr2;
                        c0019a2.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.Q));
                        break;
                    case 13:
                        iArr = iArr2;
                        c0019a2.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.M));
                        break;
                    case 14:
                        iArr = iArr2;
                        c0019a2.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.O));
                        break;
                    case 15:
                        iArr = iArr2;
                        c0019a2.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.R));
                        break;
                    case 16:
                        iArr = iArr2;
                        c0019a2.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.N));
                        break;
                    case 17:
                        iArr = iArr2;
                        c0019a2.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.f2004d));
                        break;
                    case 18:
                        iArr = iArr2;
                        c0019a2.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.f2006e));
                        break;
                    case 19:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.f2008f), 19);
                        break;
                    case 20:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.f2035w), 20);
                        break;
                    case 21:
                        iArr = iArr2;
                        c0019a2.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, bVar.f2002c));
                        break;
                    case 22:
                        iArr = iArr2;
                        c0019a2.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, c0020d.f2049a)]);
                        break;
                    case 23:
                        iArr = iArr2;
                        c0019a2.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, bVar.f2000b));
                        break;
                    case 24:
                        iArr = iArr2;
                        c0019a2.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.F));
                        break;
                    case 27:
                        iArr = iArr2;
                        c0019a2.b(27, typedArrayObtainStyledAttributes.getInt(index, bVar.E));
                        break;
                    case 28:
                        iArr = iArr2;
                        c0019a2.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.G));
                        break;
                    case 31:
                        iArr = iArr2;
                        c0019a2.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.K));
                        break;
                    case 34:
                        iArr = iArr2;
                        c0019a2.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.H));
                        break;
                    case 37:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.f2036x), 37);
                        break;
                    case 38:
                        iArr = iArr2;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, aVar.f1979a);
                        aVar.f1979a = resourceId;
                        c0019a2.b(38, resourceId);
                        break;
                    case 39:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.U), 39);
                        break;
                    case 40:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.T), 40);
                        break;
                    case 41:
                        iArr = iArr2;
                        c0019a2.b(41, typedArrayObtainStyledAttributes.getInt(index, bVar.V));
                        break;
                    case 42:
                        iArr = iArr2;
                        c0019a2.b(42, typedArrayObtainStyledAttributes.getInt(index, bVar.W));
                        break;
                    case 43:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, c0020d.f2051c), 43);
                        break;
                    case 44:
                        iArr = iArr2;
                        c0019a2.d(44, true);
                        c0019a2.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f2066m), 44);
                        break;
                    case 45:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f2055b), 45);
                        break;
                    case 46:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f2056c), 46);
                        break;
                    case 47:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f2057d), 47);
                        break;
                    case 48:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f2058e), 48);
                        break;
                    case 49:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f2059f), 49);
                        break;
                    case 50:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f2060g), 50);
                        break;
                    case 51:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f2062i), 51);
                        break;
                    case 52:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f2063j), 52);
                        break;
                    case 53:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f2064k), 53);
                        break;
                    case 54:
                        iArr = iArr2;
                        c0019a2.b(54, typedArrayObtainStyledAttributes.getInt(index, bVar.X));
                        break;
                    case 55:
                        iArr = iArr2;
                        c0019a2.b(55, typedArrayObtainStyledAttributes.getInt(index, bVar.Y));
                        break;
                    case 56:
                        iArr = iArr2;
                        c0019a2.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.Z));
                        break;
                    case 57:
                        iArr = iArr2;
                        c0019a2.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.f1999a0));
                        break;
                    case 58:
                        iArr = iArr2;
                        c0019a2.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.f2001b0));
                        break;
                    case 59:
                        iArr = iArr2;
                        c0019a2.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.f2003c0));
                        break;
                    case 60:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f2054a), 60);
                        break;
                    case 62:
                        iArr = iArr2;
                        c0019a2.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.A));
                        break;
                    case 63:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.B), 63);
                        break;
                    case 64:
                        iArr = iArr2;
                        c0019a2.b(64, d(typedArrayObtainStyledAttributes, index, cVar.f2040a));
                        break;
                    case 65:
                        iArr = iArr2;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type != 3) {
                            c0019a2.c(65, e0.a.f11112b[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        } else {
                            c0019a2.c(65, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        }
                    case 66:
                        iArr = iArr2;
                        c0019a2.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, cVar.f2044e), 67);
                        break;
                    case 68:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, c0020d.f2052d), 68);
                        break;
                    case 69:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 69);
                        break;
                    case 70:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 70);
                        break;
                    case 71:
                        iArr = iArr2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        iArr = iArr2;
                        c0019a2.b(72, typedArrayObtainStyledAttributes.getInt(index, bVar.f2009f0));
                        break;
                    case 73:
                        iArr = iArr2;
                        c0019a2.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.f2011g0));
                        break;
                    case 74:
                        iArr = iArr2;
                        c0019a2.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        iArr = iArr2;
                        c0019a2.d(75, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f2025n0));
                        break;
                    case 76:
                        iArr = iArr2;
                        c0019a2.b(76, typedArrayObtainStyledAttributes.getInt(index, cVar.f2042c));
                        break;
                    case 77:
                        iArr = iArr2;
                        c0019a2.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        iArr = iArr2;
                        c0019a2.b(78, typedArrayObtainStyledAttributes.getInt(index, c0020d.f2050b));
                        break;
                    case 79:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, cVar.f2043d), 79);
                        break;
                    case 80:
                        iArr = iArr2;
                        c0019a2.d(80, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f2021l0));
                        break;
                    case 81:
                        iArr = iArr2;
                        c0019a2.d(81, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f2023m0));
                        break;
                    case 82:
                        iArr = iArr2;
                        c0019a2.b(82, typedArrayObtainStyledAttributes.getInteger(index, cVar.f2041b));
                        break;
                    case 83:
                        iArr = iArr2;
                        c0019a2.b(83, d(typedArrayObtainStyledAttributes, index, eVar.f2061h));
                        break;
                    case 84:
                        iArr = iArr2;
                        c0019a2.b(84, typedArrayObtainStyledAttributes.getInteger(index, cVar.f2046g));
                        break;
                    case 85:
                        iArr = iArr2;
                        c0019a2.a(typedArrayObtainStyledAttributes.getFloat(index, cVar.f2045f), 85);
                        break;
                    case 86:
                        iArr = iArr2;
                        int i13 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i13 != 1) {
                            if (i13 != 3) {
                                c0019a2.b(88, typedArrayObtainStyledAttributes.getInteger(index, cVar.f2048i));
                                break;
                            } else {
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                cVar.f2047h = string;
                                c0019a2.c(90, string);
                                if (cVar.f2047h.indexOf("/") <= 0) {
                                    c0019a2.b(88, -1);
                                    break;
                                } else {
                                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                    cVar.f2048i = resourceId2;
                                    c0019a2.b(89, resourceId2);
                                    c0019a2.b(88, -2);
                                    break;
                                }
                            }
                        } else {
                            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            cVar.f2048i = resourceId3;
                            c0019a2.b(89, resourceId3);
                            if (cVar.f2048i != -1) {
                                c0019a2.b(88, -2);
                                break;
                            }
                        }
                        break;
                    case 87:
                        iArr = iArr2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        iArr = iArr2;
                        c0019a2.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.L));
                        break;
                    case 94:
                        iArr = iArr2;
                        c0019a2.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.S));
                        break;
                    case 95:
                        iArr = iArr2;
                        e(c0019a2, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        iArr = iArr2;
                        e(c0019a2, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        iArr = iArr2;
                        c0019a2.b(97, typedArrayObtainStyledAttributes.getInt(index, bVar.f2027o0));
                        break;
                    case 98:
                        int i14 = MotionLayout.f1849c0;
                        iArr = iArr2;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type != 3) {
                            aVar.f1979a = typedArrayObtainStyledAttributes.getResourceId(index, aVar.f1979a);
                            break;
                        } else {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        }
                    case 99:
                        c0019a2.d(99, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f2010g));
                        iArr = iArr2;
                        break;
                }
                str2 = str4;
                c0019a = c0019a2;
                indexCount = i11;
                c0019a2 = c0019a;
                str4 = str2;
                i10 = i12 + 1;
                iArr2 = iArr;
            }
        } else {
            int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount();
            int i15 = 0;
            while (i15 < indexCount2) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i15);
                int i16 = indexCount2;
                if (index2 != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index2 && R.styleable.Constraint_android_layout_marginEnd != index2) {
                    cVar.getClass();
                    bVar.getClass();
                    c0020d.getClass();
                    eVar.getClass();
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        str = str3;
                        bVar.f2028p = d(typedArrayObtainStyledAttributes, index2, bVar.f2028p);
                        break;
                    case 2:
                        str = str3;
                        bVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.I);
                        break;
                    case 3:
                        str = str3;
                        bVar.f2026o = d(typedArrayObtainStyledAttributes, index2, bVar.f2026o);
                        break;
                    case 4:
                        str = str3;
                        bVar.f2024n = d(typedArrayObtainStyledAttributes, index2, bVar.f2024n);
                        break;
                    case 5:
                        str = str3;
                        bVar.f2037y = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        str = str3;
                        bVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.C);
                        break;
                    case 7:
                        str = str3;
                        bVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.D);
                        break;
                    case 8:
                        str = str3;
                        bVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.J);
                        break;
                    case 9:
                        str = str3;
                        bVar.f2034v = d(typedArrayObtainStyledAttributes, index2, bVar.f2034v);
                        break;
                    case 10:
                        str = str3;
                        bVar.f2033u = d(typedArrayObtainStyledAttributes, index2, bVar.f2033u);
                        break;
                    case 11:
                        str = str3;
                        bVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.P);
                        break;
                    case 12:
                        str = str3;
                        bVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.Q);
                        break;
                    case 13:
                        str = str3;
                        bVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.M);
                        break;
                    case 14:
                        str = str3;
                        bVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.O);
                        break;
                    case 15:
                        str = str3;
                        bVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.R);
                        break;
                    case 16:
                        str = str3;
                        bVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.N);
                        break;
                    case 17:
                        str = str3;
                        bVar.f2004d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.f2004d);
                        break;
                    case 18:
                        str = str3;
                        bVar.f2006e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.f2006e);
                        break;
                    case 19:
                        str = str3;
                        bVar.f2008f = typedArrayObtainStyledAttributes.getFloat(index2, bVar.f2008f);
                        break;
                    case 20:
                        str = str3;
                        bVar.f2035w = typedArrayObtainStyledAttributes.getFloat(index2, bVar.f2035w);
                        break;
                    case 21:
                        str = str3;
                        bVar.f2002c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, bVar.f2002c);
                        break;
                    case 22:
                        str = str3;
                        c0020d.f2049a = iArr2[typedArrayObtainStyledAttributes.getInt(index2, c0020d.f2049a)];
                        break;
                    case 23:
                        str = str3;
                        bVar.f2000b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, bVar.f2000b);
                        break;
                    case 24:
                        str = str3;
                        bVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.F);
                        break;
                    case 25:
                        str = str3;
                        bVar.f2012h = d(typedArrayObtainStyledAttributes, index2, bVar.f2012h);
                        break;
                    case 26:
                        str = str3;
                        bVar.f2014i = d(typedArrayObtainStyledAttributes, index2, bVar.f2014i);
                        break;
                    case 27:
                        str = str3;
                        bVar.E = typedArrayObtainStyledAttributes.getInt(index2, bVar.E);
                        break;
                    case 28:
                        str = str3;
                        bVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.G);
                        break;
                    case 29:
                        str = str3;
                        bVar.f2016j = d(typedArrayObtainStyledAttributes, index2, bVar.f2016j);
                        break;
                    case 30:
                        str = str3;
                        bVar.f2018k = d(typedArrayObtainStyledAttributes, index2, bVar.f2018k);
                        break;
                    case 31:
                        str = str3;
                        bVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.K);
                        break;
                    case 32:
                        str = str3;
                        bVar.f2031s = d(typedArrayObtainStyledAttributes, index2, bVar.f2031s);
                        break;
                    case 33:
                        str = str3;
                        bVar.f2032t = d(typedArrayObtainStyledAttributes, index2, bVar.f2032t);
                        break;
                    case 34:
                        str = str3;
                        bVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.H);
                        break;
                    case 35:
                        str = str3;
                        bVar.f2022m = d(typedArrayObtainStyledAttributes, index2, bVar.f2022m);
                        break;
                    case 36:
                        str = str3;
                        bVar.f2020l = d(typedArrayObtainStyledAttributes, index2, bVar.f2020l);
                        break;
                    case 37:
                        str = str3;
                        bVar.f2036x = typedArrayObtainStyledAttributes.getFloat(index2, bVar.f2036x);
                        break;
                    case 38:
                        str = str3;
                        aVar.f1979a = typedArrayObtainStyledAttributes.getResourceId(index2, aVar.f1979a);
                        break;
                    case 39:
                        str = str3;
                        bVar.U = typedArrayObtainStyledAttributes.getFloat(index2, bVar.U);
                        break;
                    case 40:
                        str = str3;
                        bVar.T = typedArrayObtainStyledAttributes.getFloat(index2, bVar.T);
                        break;
                    case 41:
                        str = str3;
                        bVar.V = typedArrayObtainStyledAttributes.getInt(index2, bVar.V);
                        break;
                    case 42:
                        str = str3;
                        bVar.W = typedArrayObtainStyledAttributes.getInt(index2, bVar.W);
                        break;
                    case 43:
                        str = str3;
                        c0020d.f2051c = typedArrayObtainStyledAttributes.getFloat(index2, c0020d.f2051c);
                        break;
                    case 44:
                        str = str3;
                        eVar.f2065l = true;
                        eVar.f2066m = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f2066m);
                        break;
                    case 45:
                        str = str3;
                        eVar.f2055b = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f2055b);
                        break;
                    case 46:
                        str = str3;
                        eVar.f2056c = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f2056c);
                        break;
                    case 47:
                        str = str3;
                        eVar.f2057d = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f2057d);
                        break;
                    case 48:
                        str = str3;
                        eVar.f2058e = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f2058e);
                        break;
                    case 49:
                        str = str3;
                        eVar.f2059f = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f2059f);
                        break;
                    case 50:
                        str = str3;
                        eVar.f2060g = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f2060g);
                        break;
                    case 51:
                        str = str3;
                        eVar.f2062i = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f2062i);
                        break;
                    case 52:
                        str = str3;
                        eVar.f2063j = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f2063j);
                        break;
                    case 53:
                        str = str3;
                        eVar.f2064k = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f2064k);
                        break;
                    case 54:
                        str = str3;
                        bVar.X = typedArrayObtainStyledAttributes.getInt(index2, bVar.X);
                        break;
                    case 55:
                        str = str3;
                        bVar.Y = typedArrayObtainStyledAttributes.getInt(index2, bVar.Y);
                        break;
                    case 56:
                        str = str3;
                        bVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.Z);
                        break;
                    case 57:
                        str = str3;
                        bVar.f1999a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.f1999a0);
                        break;
                    case 58:
                        str = str3;
                        bVar.f2001b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.f2001b0);
                        break;
                    case 59:
                        str = str3;
                        bVar.f2003c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.f2003c0);
                        break;
                    case 60:
                        str = str3;
                        eVar.f2054a = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f2054a);
                        break;
                    case 61:
                        str = str3;
                        bVar.f2038z = d(typedArrayObtainStyledAttributes, index2, bVar.f2038z);
                        break;
                    case 62:
                        str = str3;
                        bVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.A);
                        break;
                    case 63:
                        str = str3;
                        bVar.B = typedArrayObtainStyledAttributes.getFloat(index2, bVar.B);
                        break;
                    case 64:
                        str = str3;
                        cVar.f2040a = d(typedArrayObtainStyledAttributes, index2, cVar.f2040a);
                        break;
                    case 65:
                        str = str3;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type != 3) {
                            String str5 = e0.a.f11112b[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            cVar.getClass();
                            break;
                        } else {
                            typedArrayObtainStyledAttributes.getString(index2);
                            cVar.getClass();
                            break;
                        }
                    case 66:
                        str = str3;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        cVar.getClass();
                        break;
                    case 67:
                        str = str3;
                        cVar.f2044e = typedArrayObtainStyledAttributes.getFloat(index2, cVar.f2044e);
                        break;
                    case 68:
                        str = str3;
                        c0020d.f2052d = typedArrayObtainStyledAttributes.getFloat(index2, c0020d.f2052d);
                        break;
                    case 69:
                        str = str3;
                        bVar.f2005d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        str = str3;
                        bVar.f2007e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        str = str3;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        str = str3;
                        bVar.f2009f0 = typedArrayObtainStyledAttributes.getInt(index2, bVar.f2009f0);
                        break;
                    case 73:
                        str = str3;
                        bVar.f2011g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.f2011g0);
                        break;
                    case 74:
                        str = str3;
                        bVar.f2017j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        str = str3;
                        bVar.f2025n0 = typedArrayObtainStyledAttributes.getBoolean(index2, bVar.f2025n0);
                        break;
                    case 76:
                        str = str3;
                        cVar.f2042c = typedArrayObtainStyledAttributes.getInt(index2, cVar.f2042c);
                        break;
                    case 77:
                        str = str3;
                        bVar.f2019k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        str = str3;
                        c0020d.f2050b = typedArrayObtainStyledAttributes.getInt(index2, c0020d.f2050b);
                        break;
                    case 79:
                        str = str3;
                        cVar.f2043d = typedArrayObtainStyledAttributes.getFloat(index2, cVar.f2043d);
                        break;
                    case 80:
                        str = str3;
                        bVar.f2021l0 = typedArrayObtainStyledAttributes.getBoolean(index2, bVar.f2021l0);
                        break;
                    case 81:
                        str = str3;
                        bVar.f2023m0 = typedArrayObtainStyledAttributes.getBoolean(index2, bVar.f2023m0);
                        break;
                    case 82:
                        str = str3;
                        cVar.f2041b = typedArrayObtainStyledAttributes.getInteger(index2, cVar.f2041b);
                        break;
                    case 83:
                        str = str3;
                        eVar.f2061h = d(typedArrayObtainStyledAttributes, index2, eVar.f2061h);
                        break;
                    case 84:
                        str = str3;
                        cVar.f2046g = typedArrayObtainStyledAttributes.getInteger(index2, cVar.f2046g);
                        break;
                    case 85:
                        str = str3;
                        cVar.f2045f = typedArrayObtainStyledAttributes.getFloat(index2, cVar.f2045f);
                        break;
                    case 86:
                        str = str3;
                        int i17 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i17 != 1) {
                            if (i17 != 3) {
                                typedArrayObtainStyledAttributes.getInteger(index2, cVar.f2048i);
                                break;
                            } else {
                                String string2 = typedArrayObtainStyledAttributes.getString(index2);
                                cVar.f2047h = string2;
                                if (string2.indexOf("/") <= 0) {
                                    break;
                                } else {
                                    cVar.f2048i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                                    break;
                                }
                            }
                        } else {
                            cVar.f2048i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            break;
                        }
                    case 87:
                        StringBuilder sb3 = new StringBuilder(str3);
                        str = str3;
                        sb3.append(Integer.toHexString(index2));
                        sb3.append("   ");
                        sb3.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb3.toString());
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        str = str3;
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 91:
                        bVar.f2029q = d(typedArrayObtainStyledAttributes, index2, bVar.f2029q);
                        str = str3;
                        break;
                    case 92:
                        bVar.f2030r = d(typedArrayObtainStyledAttributes, index2, bVar.f2030r);
                        str = str3;
                        break;
                    case 93:
                        bVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.L);
                        str = str3;
                        break;
                    case 94:
                        bVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.S);
                        str = str3;
                        break;
                    case 95:
                        e(bVar, typedArrayObtainStyledAttributes, index2, 0);
                        str = str3;
                        break;
                    case 96:
                        e(bVar, typedArrayObtainStyledAttributes, index2, 1);
                        str = str3;
                        break;
                    case 97:
                        bVar.f2027o0 = typedArrayObtainStyledAttributes.getInt(index2, bVar.f2027o0);
                        str = str3;
                        break;
                }
                i15++;
                indexCount2 = i16;
                str3 = str;
            }
            if (bVar.f2017j0 != null) {
                bVar.f2015i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public static int d(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(java.lang.Object r8, android.content.res.TypedArray r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.e(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void f(ConstraintLayout.a aVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i10 = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i10 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 > 0.0f && f11 > 0.0f) {
                            if (i10 == 1) {
                                Math.abs(f11 / f10);
                            } else {
                                Math.abs(f10 / f11);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        aVar.G = str;
    }

    public final void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> map = this.f1978c;
        HashSet hashSet = new HashSet(map.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + i0.a.getName(childAt));
            } else {
                if (this.f1977b && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (map.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        a aVar = map.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            if (childAt instanceof androidx.constraintlayout.widget.a) {
                                b bVar = aVar.f1982d;
                                bVar.f2013h0 = 1;
                                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                                aVar2.setId(id2);
                                aVar2.setType(bVar.f2009f0);
                                aVar2.setMargin(bVar.f2011g0);
                                aVar2.setAllowsGoneWidget(bVar.f2025n0);
                                int[] iArr = bVar.f2015i0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f2017j0;
                                    if (str != null) {
                                        int[] iArrB = b(aVar2, str);
                                        bVar.f2015i0 = iArrB;
                                        aVar2.setReferencedIds(iArrB);
                                    }
                                }
                            }
                            ConstraintLayout.a aVar3 = (ConstraintLayout.a) childAt.getLayoutParams();
                            aVar3.validate();
                            aVar.applyTo(aVar3);
                            ConstraintAttribute.setAttributes(childAt, aVar.f1984f);
                            childAt.setLayoutParams(aVar3);
                            C0020d c0020d = aVar.f1980b;
                            if (c0020d.f2050b == 0) {
                                childAt.setVisibility(c0020d.f2049a);
                            }
                            childAt.setAlpha(c0020d.f2051c);
                            e eVar = aVar.f1983e;
                            childAt.setRotation(eVar.f2054a);
                            childAt.setRotationX(eVar.f2055b);
                            childAt.setRotationY(eVar.f2056c);
                            childAt.setScaleX(eVar.f2057d);
                            childAt.setScaleY(eVar.f2058e);
                            if (eVar.f2061h != -1) {
                                if (((View) childAt.getParent()).findViewById(eVar.f2061h) != null) {
                                    float bottom = (r7.getBottom() + r7.getTop()) / 2.0f;
                                    float right = (r7.getRight() + r7.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f2059f)) {
                                    childAt.setPivotX(eVar.f2059f);
                                }
                                if (!Float.isNaN(eVar.f2060g)) {
                                    childAt.setPivotY(eVar.f2060g);
                                }
                            }
                            childAt.setTranslationX(eVar.f2062i);
                            childAt.setTranslationY(eVar.f2063j);
                            childAt.setTranslationZ(eVar.f2064k);
                            if (eVar.f2065l) {
                                childAt.setElevation(eVar.f2066m);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = map.get(num);
            if (aVar4 != null) {
                b bVar2 = aVar4.f1982d;
                if (bVar2.f2013h0 == 1) {
                    androidx.constraintlayout.widget.a aVar5 = new androidx.constraintlayout.widget.a(constraintLayout.getContext());
                    aVar5.setId(num.intValue());
                    int[] iArr2 = bVar2.f2015i0;
                    if (iArr2 != null) {
                        aVar5.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.f2017j0;
                        if (str2 != null) {
                            int[] iArrB2 = b(aVar5, str2);
                            bVar2.f2015i0 = iArrB2;
                            aVar5.setReferencedIds(iArrB2);
                        }
                    }
                    aVar5.setType(bVar2.f2009f0);
                    aVar5.setMargin(bVar2.f2011g0);
                    ConstraintLayout.a aVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    aVar5.validateParams();
                    aVar4.applyTo(aVarGenerateDefaultLayoutParams);
                    constraintLayout.addView(aVar5, aVarGenerateDefaultLayoutParams);
                }
                if (bVar2.f1998a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.a aVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar4.applyTo(aVarGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, aVarGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof androidx.constraintlayout.widget.b) {
                ((androidx.constraintlayout.widget.b) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        a(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void clone(Context context, int i10) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void constrainCircle(int i10, int i11, int i12, float f10) {
        HashMap<Integer, a> map = this.f1978c;
        if (!map.containsKey(Integer.valueOf(i10))) {
            map.put(Integer.valueOf(i10), new a());
        }
        b bVar = map.get(Integer.valueOf(i10)).f1982d;
        bVar.f2038z = i11;
        bVar.A = i12;
        bVar.B = f10;
    }

    public void load(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarC = c(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarC.f1982d.f1998a = true;
                    }
                    this.f1978c.put(Integer.valueOf(aVarC.f1979a), aVarC);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> map = this.f1978c;
        map.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f1977b && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id2))) {
                map.put(Integer.valueOf(id2), new a());
            }
            a aVar2 = map.get(Integer.valueOf(id2));
            if (aVar2 != null) {
                aVar2.f1984f = ConstraintAttribute.extractAttributes(this.f1976a, childAt);
                aVar2.a(id2, aVar);
                int visibility = childAt.getVisibility();
                C0020d c0020d = aVar2.f1980b;
                c0020d.f2049a = visibility;
                c0020d.f2051c = childAt.getAlpha();
                float rotation = childAt.getRotation();
                e eVar = aVar2.f1983e;
                eVar.f2054a = rotation;
                eVar.f2055b = childAt.getRotationX();
                eVar.f2056c = childAt.getRotationY();
                eVar.f2057d = childAt.getScaleX();
                eVar.f2058e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    eVar.f2059f = pivotX;
                    eVar.f2060g = pivotY;
                }
                eVar.f2062i = childAt.getTranslationX();
                eVar.f2063j = childAt.getTranslationY();
                eVar.f2064k = childAt.getTranslationZ();
                if (eVar.f2065l) {
                    eVar.f2066m = childAt.getElevation();
                }
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.a aVar3 = (androidx.constraintlayout.widget.a) childAt;
                    boolean allowsGoneWidget = aVar3.getAllowsGoneWidget();
                    b bVar = aVar2.f1982d;
                    bVar.f2025n0 = allowsGoneWidget;
                    bVar.f2015i0 = aVar3.getReferencedIds();
                    bVar.f2009f0 = aVar3.getType();
                    bVar.f2011g0 = aVar3.getMargin();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x01ca, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void clone(androidx.constraintlayout.widget.e eVar) {
        int childCount = eVar.getChildCount();
        HashMap<Integer, a> map = this.f1978c;
        map.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = eVar.getChildAt(i10);
            e.a aVar = (e.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f1977b && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id2))) {
                map.put(Integer.valueOf(id2), new a());
            }
            a aVar2 = map.get(Integer.valueOf(id2));
            if (aVar2 != null) {
                if (childAt instanceof androidx.constraintlayout.widget.b) {
                    androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) childAt;
                    aVar2.b(id2, aVar);
                    if (bVar instanceof androidx.constraintlayout.widget.a) {
                        b bVar2 = aVar2.f1982d;
                        bVar2.f2013h0 = 1;
                        androidx.constraintlayout.widget.a aVar3 = (androidx.constraintlayout.widget.a) bVar;
                        bVar2.f2009f0 = aVar3.getType();
                        bVar2.f2015i0 = aVar3.getReferencedIds();
                        bVar2.f2011g0 = aVar3.getMargin();
                    }
                }
                aVar2.b(id2, aVar);
            }
        }
    }
}
