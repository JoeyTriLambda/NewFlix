package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Flow.java */
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: c1, reason: collision with root package name */
    public ConstraintWidget[] f1815c1;
    public int F0 = -1;
    public int G0 = -1;
    public int H0 = -1;
    public int I0 = -1;
    public int J0 = -1;
    public int K0 = -1;
    public float L0 = 0.5f;
    public float M0 = 0.5f;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public float P0 = 0.5f;
    public float Q0 = 0.5f;
    public int R0 = 0;
    public int S0 = 0;
    public int T0 = 2;
    public int U0 = 2;
    public int V0 = 0;
    public int W0 = -1;
    public int X0 = 0;
    public final ArrayList<a> Y0 = new ArrayList<>();
    public ConstraintWidget[] Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    public ConstraintWidget[] f1813a1 = null;

    /* renamed from: b1, reason: collision with root package name */
    public int[] f1814b1 = null;

    /* renamed from: d1, reason: collision with root package name */
    public int f1816d1 = 0;

    /* compiled from: Flow.java */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1817a;

        /* renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f1820d;

        /* renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f1821e;

        /* renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f1822f;

        /* renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f1823g;

        /* renamed from: h, reason: collision with root package name */
        public int f1824h;

        /* renamed from: i, reason: collision with root package name */
        public int f1825i;

        /* renamed from: j, reason: collision with root package name */
        public int f1826j;

        /* renamed from: k, reason: collision with root package name */
        public int f1827k;

        /* renamed from: q, reason: collision with root package name */
        public int f1833q;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget f1818b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f1819c = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f1828l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f1829m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f1830n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f1831o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f1832p = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f1824h = 0;
            this.f1825i = 0;
            this.f1826j = 0;
            this.f1827k = 0;
            this.f1833q = 0;
            this.f1817a = i10;
            this.f1820d = constraintAnchor;
            this.f1821e = constraintAnchor2;
            this.f1822f = constraintAnchor3;
            this.f1823g = constraintAnchor4;
            this.f1824h = e.this.getPaddingLeft();
            this.f1825i = e.this.getPaddingTop();
            this.f1826j = e.this.getPaddingRight();
            this.f1827k = e.this.getPaddingBottom();
            this.f1833q = i11;
        }

        public void add(ConstraintWidget constraintWidget) {
            int i10 = this.f1817a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            e eVar = e.this;
            if (i10 == 0) {
                int iH = eVar.h(constraintWidget, this.f1833q);
                if (constraintWidget.getHorizontalDimensionBehaviour() == dimensionBehaviour) {
                    this.f1832p++;
                    iH = 0;
                }
                this.f1828l = iH + (constraintWidget.getVisibility() != 8 ? eVar.R0 : 0) + this.f1828l;
                int iG = eVar.g(constraintWidget, this.f1833q);
                if (this.f1818b == null || this.f1819c < iG) {
                    this.f1818b = constraintWidget;
                    this.f1819c = iG;
                    this.f1829m = iG;
                }
            } else {
                int iH2 = eVar.h(constraintWidget, this.f1833q);
                int iG2 = eVar.g(constraintWidget, this.f1833q);
                if (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                    this.f1832p++;
                    iG2 = 0;
                }
                this.f1829m = iG2 + (constraintWidget.getVisibility() != 8 ? eVar.S0 : 0) + this.f1829m;
                if (this.f1818b == null || this.f1819c < iH2) {
                    this.f1818b = constraintWidget;
                    this.f1819c = iH2;
                    this.f1828l = iH2;
                }
            }
            this.f1831o++;
        }

        public void clear() {
            this.f1819c = 0;
            this.f1818b = null;
            this.f1828l = 0;
            this.f1829m = 0;
            this.f1830n = 0;
            this.f1831o = 0;
            this.f1832p = 0;
        }

        public void createConstraints(boolean z10, int i10, boolean z11) {
            e eVar;
            int i11;
            int i12;
            ConstraintWidget constraintWidget;
            ConstraintAnchor constraintAnchor;
            ConstraintAnchor constraintAnchor2;
            int i13;
            int i14;
            int i15 = this.f1831o;
            int i16 = 0;
            while (true) {
                eVar = e.this;
                if (i16 >= i15) {
                    break;
                }
                int i17 = this.f1830n;
                if (i17 + i16 >= eVar.f1816d1) {
                    break;
                }
                ConstraintWidget constraintWidget2 = eVar.f1815c1[i17 + i16];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
                i16++;
            }
            if (i15 == 0 || this.f1818b == null) {
                return;
            }
            boolean z12 = z11 && i10 == 0;
            int i18 = -1;
            int i19 = -1;
            for (int i20 = 0; i20 < i15; i20++) {
                int i21 = z10 ? (i15 - 1) - i20 : i20;
                int i22 = this.f1830n;
                if (i22 + i21 >= eVar.f1816d1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = eVar.f1815c1[i22 + i21];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i18 == -1) {
                        i18 = i20;
                    }
                    i19 = i20;
                }
            }
            if (this.f1817a != 0) {
                ConstraintWidget constraintWidget4 = this.f1818b;
                constraintWidget4.setHorizontalChainStyle(eVar.F0);
                int i23 = this.f1824h;
                if (i10 > 0) {
                    i23 += eVar.R0;
                }
                ConstraintAnchor constraintAnchor3 = constraintWidget4.M;
                ConstraintAnchor constraintAnchor4 = constraintWidget4.K;
                if (z10) {
                    constraintAnchor3.connect(this.f1822f, i23);
                    if (z11) {
                        constraintAnchor4.connect(this.f1820d, this.f1826j);
                    }
                    if (i10 > 0) {
                        this.f1822f.f1683d.K.connect(constraintAnchor3, 0);
                    }
                } else {
                    constraintAnchor4.connect(this.f1820d, i23);
                    if (z11) {
                        constraintAnchor3.connect(this.f1822f, this.f1826j);
                    }
                    if (i10 > 0) {
                        this.f1820d.f1683d.M.connect(constraintAnchor4, 0);
                    }
                }
                ConstraintWidget constraintWidget5 = null;
                int i24 = 0;
                while (i24 < i15) {
                    int i25 = this.f1830n;
                    if (i25 + i24 >= eVar.f1816d1) {
                        return;
                    }
                    ConstraintWidget constraintWidget6 = eVar.f1815c1[i25 + i24];
                    if (constraintWidget6 == null) {
                        constraintWidget6 = constraintWidget5;
                    } else {
                        ConstraintAnchor constraintAnchor5 = constraintWidget6.L;
                        if (i24 == 0) {
                            constraintWidget6.connect(constraintAnchor5, this.f1821e, this.f1825i);
                            int i26 = eVar.G0;
                            float f10 = eVar.M0;
                            if (this.f1830n == 0) {
                                int i27 = eVar.I0;
                                i11 = i26;
                                if (i27 != -1) {
                                    f10 = eVar.O0;
                                    i12 = i27;
                                }
                                constraintWidget6.setVerticalChainStyle(i12);
                                constraintWidget6.setVerticalBiasPercent(f10);
                            } else {
                                i11 = i26;
                            }
                            if (!z11 || (i12 = eVar.K0) == -1) {
                                i12 = i11;
                            } else {
                                f10 = eVar.Q0;
                            }
                            constraintWidget6.setVerticalChainStyle(i12);
                            constraintWidget6.setVerticalBiasPercent(f10);
                        }
                        if (i24 == i15 - 1) {
                            constraintWidget6.connect(constraintWidget6.N, this.f1823g, this.f1827k);
                        }
                        if (constraintWidget5 != null) {
                            int i28 = eVar.S0;
                            ConstraintAnchor constraintAnchor6 = constraintWidget5.N;
                            constraintAnchor5.connect(constraintAnchor6, i28);
                            if (i24 == i18) {
                                constraintAnchor5.setGoneMargin(this.f1825i);
                            }
                            constraintAnchor6.connect(constraintAnchor5, 0);
                            if (i24 == i19 + 1) {
                                constraintAnchor6.setGoneMargin(this.f1827k);
                            }
                        }
                        if (constraintWidget6 != constraintWidget4) {
                            ConstraintAnchor constraintAnchor7 = constraintWidget6.M;
                            ConstraintAnchor constraintAnchor8 = constraintWidget6.K;
                            if (z10) {
                                int i29 = eVar.T0;
                                if (i29 == 0) {
                                    constraintAnchor7.connect(constraintAnchor3, 0);
                                } else if (i29 == 1) {
                                    constraintAnchor8.connect(constraintAnchor4, 0);
                                } else if (i29 == 2) {
                                    constraintAnchor8.connect(constraintAnchor4, 0);
                                    constraintAnchor7.connect(constraintAnchor3, 0);
                                }
                            } else {
                                int i30 = eVar.T0;
                                if (i30 == 0) {
                                    constraintAnchor8.connect(constraintAnchor4, 0);
                                } else if (i30 == 1) {
                                    constraintAnchor7.connect(constraintAnchor3, 0);
                                } else if (i30 == 2) {
                                    if (z12) {
                                        constraintAnchor8.connect(this.f1820d, this.f1824h);
                                        constraintAnchor7.connect(this.f1822f, this.f1826j);
                                    } else {
                                        constraintAnchor8.connect(constraintAnchor4, 0);
                                        constraintAnchor7.connect(constraintAnchor3, 0);
                                    }
                                }
                            }
                        }
                        i24++;
                        constraintWidget5 = constraintWidget6;
                    }
                    i24++;
                    constraintWidget5 = constraintWidget6;
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f1818b;
            constraintWidget7.setVerticalChainStyle(eVar.G0);
            int i31 = this.f1825i;
            if (i10 > 0) {
                i31 += eVar.S0;
            }
            ConstraintAnchor constraintAnchor9 = this.f1821e;
            ConstraintAnchor constraintAnchor10 = constraintWidget7.L;
            constraintAnchor10.connect(constraintAnchor9, i31);
            ConstraintAnchor constraintAnchor11 = constraintWidget7.N;
            if (z11) {
                constraintAnchor11.connect(this.f1823g, this.f1827k);
            }
            if (i10 > 0) {
                this.f1821e.f1683d.N.connect(constraintAnchor10, 0);
            }
            if (eVar.U0 != 3 || constraintWidget7.hasBaseline()) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i32 = 0; i32 < i15; i32++) {
                    int i33 = z10 ? (i15 - 1) - i32 : i32;
                    int i34 = this.f1830n;
                    if (i34 + i33 >= eVar.f1816d1) {
                        break;
                    }
                    constraintWidget = eVar.f1815c1[i34 + i33];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            ConstraintWidget constraintWidget8 = null;
            int i35 = 0;
            while (i35 < i15) {
                int i36 = z10 ? (i15 - 1) - i35 : i35;
                int i37 = this.f1830n;
                if (i37 + i36 >= eVar.f1816d1) {
                    return;
                }
                ConstraintWidget constraintWidget9 = eVar.f1815c1[i37 + i36];
                if (constraintWidget9 == null) {
                    constraintWidget9 = constraintWidget8;
                    constraintAnchor2 = constraintAnchor11;
                } else {
                    ConstraintAnchor constraintAnchor12 = constraintWidget9.K;
                    if (i35 == 0) {
                        constraintAnchor = constraintAnchor11;
                        constraintWidget9.connect(constraintAnchor12, this.f1820d, this.f1824h);
                    } else {
                        constraintAnchor = constraintAnchor11;
                    }
                    if (i36 == 0) {
                        int i38 = eVar.F0;
                        float f11 = z10 ? 1.0f - eVar.L0 : eVar.L0;
                        if (this.f1830n == 0) {
                            int i39 = eVar.H0;
                            i13 = i38;
                            if (i39 != -1) {
                                f11 = z10 ? 1.0f - eVar.N0 : eVar.N0;
                                i14 = i39;
                            }
                            constraintWidget9.setHorizontalChainStyle(i14);
                            constraintWidget9.setHorizontalBiasPercent(f11);
                        } else {
                            i13 = i38;
                        }
                        if (!z11 || (i14 = eVar.J0) == -1) {
                            i14 = i13;
                        } else {
                            f11 = z10 ? 1.0f - eVar.P0 : eVar.P0;
                        }
                        constraintWidget9.setHorizontalChainStyle(i14);
                        constraintWidget9.setHorizontalBiasPercent(f11);
                    }
                    if (i35 == i15 - 1) {
                        constraintWidget9.connect(constraintWidget9.M, this.f1822f, this.f1826j);
                    }
                    if (constraintWidget8 != null) {
                        int i40 = eVar.R0;
                        ConstraintAnchor constraintAnchor13 = constraintWidget8.M;
                        constraintAnchor12.connect(constraintAnchor13, i40);
                        if (i35 == i18) {
                            constraintAnchor12.setGoneMargin(this.f1824h);
                        }
                        constraintAnchor13.connect(constraintAnchor12, 0);
                        if (i35 == i19 + 1) {
                            constraintAnchor13.setGoneMargin(this.f1826j);
                        }
                    }
                    if (constraintWidget9 != constraintWidget7) {
                        if (eVar.U0 == 3 && constraintWidget.hasBaseline() && constraintWidget9 != constraintWidget && constraintWidget9.hasBaseline()) {
                            constraintWidget9.O.connect(constraintWidget.O, 0);
                        } else {
                            int i41 = eVar.U0;
                            ConstraintAnchor constraintAnchor14 = constraintWidget9.L;
                            if (i41 != 0) {
                                ConstraintAnchor constraintAnchor15 = constraintWidget9.N;
                                if (i41 == 1) {
                                    constraintAnchor2 = constraintAnchor;
                                    constraintAnchor15.connect(constraintAnchor2, 0);
                                } else if (z12) {
                                    constraintAnchor14.connect(this.f1821e, this.f1825i);
                                    constraintAnchor15.connect(this.f1823g, this.f1827k);
                                } else {
                                    constraintAnchor14.connect(constraintAnchor10, 0);
                                    constraintAnchor2 = constraintAnchor;
                                    constraintAnchor15.connect(constraintAnchor2, 0);
                                }
                            } else {
                                constraintAnchor2 = constraintAnchor;
                                constraintAnchor14.connect(constraintAnchor10, 0);
                            }
                            i35++;
                            constraintWidget8 = constraintWidget9;
                            constraintAnchor11 = constraintAnchor2;
                        }
                        constraintAnchor2 = constraintAnchor;
                        i35++;
                        constraintWidget8 = constraintWidget9;
                        constraintAnchor11 = constraintAnchor2;
                    } else {
                        constraintAnchor2 = constraintAnchor;
                    }
                }
                i35++;
                constraintWidget8 = constraintWidget9;
                constraintAnchor11 = constraintAnchor2;
            }
        }

        public int getHeight() {
            return this.f1817a == 1 ? this.f1829m - e.this.S0 : this.f1829m;
        }

        public int getWidth() {
            return this.f1817a == 0 ? this.f1828l - e.this.R0 : this.f1828l;
        }

        public void measureMatchConstraints(int i10) {
            e eVar;
            int i11 = this.f1832p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f1831o;
            int i13 = i10 / i11;
            int i14 = 0;
            while (true) {
                eVar = e.this;
                if (i14 >= i12) {
                    break;
                }
                int i15 = this.f1830n;
                if (i15 + i14 >= eVar.f1816d1) {
                    break;
                }
                ConstraintWidget constraintWidget = eVar.f1815c1[i15 + i14];
                int i16 = this.f1817a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (i16 == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget.f1734s == 0) {
                        e.this.measure(constraintWidget, dimensionBehaviour, i13, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget.f1735t == 0) {
                    e.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), dimensionBehaviour, i13);
                }
                i14++;
            }
            this.f1828l = 0;
            this.f1829m = 0;
            this.f1818b = null;
            this.f1819c = 0;
            int i17 = this.f1831o;
            for (int i18 = 0; i18 < i17; i18++) {
                int i19 = this.f1830n + i18;
                if (i19 >= eVar.f1816d1) {
                    return;
                }
                ConstraintWidget constraintWidget2 = eVar.f1815c1[i19];
                if (this.f1817a == 0) {
                    int width = constraintWidget2.getWidth();
                    int i20 = eVar.R0;
                    if (constraintWidget2.getVisibility() == 8) {
                        i20 = 0;
                    }
                    this.f1828l = width + i20 + this.f1828l;
                    int iG = eVar.g(constraintWidget2, this.f1833q);
                    if (this.f1818b == null || this.f1819c < iG) {
                        this.f1818b = constraintWidget2;
                        this.f1819c = iG;
                        this.f1829m = iG;
                    }
                } else {
                    int iH = eVar.h(constraintWidget2, this.f1833q);
                    int iG2 = eVar.g(constraintWidget2, this.f1833q);
                    int i21 = eVar.S0;
                    if (constraintWidget2.getVisibility() == 8) {
                        i21 = 0;
                    }
                    this.f1829m = iG2 + i21 + this.f1829m;
                    if (this.f1818b == null || this.f1819c < iH) {
                        this.f1818b = constraintWidget2;
                        this.f1819c = iH;
                        this.f1828l = iH;
                    }
                }
            }
        }

        public void setStartIndex(int i10) {
            this.f1830n = i10;
        }

        public void setup(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f1817a = i10;
            this.f1820d = constraintAnchor;
            this.f1821e = constraintAnchor2;
            this.f1822f = constraintAnchor3;
            this.f1823g = constraintAnchor4;
            this.f1824h = i11;
            this.f1825i = i12;
            this.f1826j = i13;
            this.f1827k = i14;
            this.f1833q = i15;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(androidx.constraintlayout.core.c cVar, boolean z10) {
        ConstraintWidget constraintWidget;
        float f10;
        int i10;
        super.addToSolver(cVar, z10);
        boolean z11 = getParent() != null && ((d) getParent()).isRtl();
        int i11 = this.V0;
        ArrayList<a> arrayList = this.Y0;
        if (i11 != 0) {
            if (i11 == 1) {
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    arrayList.get(i12).createConstraints(z11, i12, i12 == size + (-1));
                    i12++;
                }
            } else if (i11 != 2) {
                if (i11 == 3) {
                    int size2 = arrayList.size();
                    int i13 = 0;
                    while (i13 < size2) {
                        arrayList.get(i13).createConstraints(z11, i13, i13 == size2 + (-1));
                        i13++;
                    }
                }
            } else if (this.f1814b1 != null && this.f1813a1 != null && this.Z0 != null) {
                for (int i14 = 0; i14 < this.f1816d1; i14++) {
                    this.f1815c1[i14].resetAnchors();
                }
                int[] iArr = this.f1814b1;
                int i15 = iArr[0];
                int i16 = iArr[1];
                float f11 = this.L0;
                ConstraintWidget constraintWidget2 = null;
                int i17 = 0;
                while (i17 < i15) {
                    if (z11) {
                        i10 = (i15 - i17) - 1;
                        f10 = 1.0f - this.L0;
                    } else {
                        f10 = f11;
                        i10 = i17;
                    }
                    ConstraintWidget constraintWidget3 = this.f1813a1[i10];
                    if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                        ConstraintAnchor constraintAnchor = constraintWidget3.K;
                        if (i17 == 0) {
                            constraintWidget3.connect(constraintAnchor, this.K, getPaddingLeft());
                            constraintWidget3.setHorizontalChainStyle(this.F0);
                            constraintWidget3.setHorizontalBiasPercent(f10);
                        }
                        if (i17 == i15 - 1) {
                            constraintWidget3.connect(constraintWidget3.M, this.M, getPaddingRight());
                        }
                        if (i17 > 0 && constraintWidget2 != null) {
                            int i18 = this.R0;
                            ConstraintAnchor constraintAnchor2 = constraintWidget2.M;
                            constraintWidget3.connect(constraintAnchor, constraintAnchor2, i18);
                            constraintWidget2.connect(constraintAnchor2, constraintAnchor, 0);
                        }
                        constraintWidget2 = constraintWidget3;
                    }
                    i17++;
                    f11 = f10;
                }
                for (int i19 = 0; i19 < i16; i19++) {
                    ConstraintWidget constraintWidget4 = this.Z0[i19];
                    if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                        ConstraintAnchor constraintAnchor3 = constraintWidget4.L;
                        if (i19 == 0) {
                            constraintWidget4.connect(constraintAnchor3, this.L, getPaddingTop());
                            constraintWidget4.setVerticalChainStyle(this.G0);
                            constraintWidget4.setVerticalBiasPercent(this.M0);
                        }
                        if (i19 == i16 - 1) {
                            constraintWidget4.connect(constraintWidget4.N, this.N, getPaddingBottom());
                        }
                        if (i19 > 0 && constraintWidget2 != null) {
                            int i20 = this.S0;
                            ConstraintAnchor constraintAnchor4 = constraintWidget2.N;
                            constraintWidget4.connect(constraintAnchor3, constraintAnchor4, i20);
                            constraintWidget2.connect(constraintAnchor4, constraintAnchor3, 0);
                        }
                        constraintWidget2 = constraintWidget4;
                    }
                }
                for (int i21 = 0; i21 < i15; i21++) {
                    for (int i22 = 0; i22 < i16; i22++) {
                        int i23 = (i22 * i15) + i21;
                        if (this.X0 == 1) {
                            i23 = (i21 * i16) + i22;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.f1815c1;
                        if (i23 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i23]) != null && constraintWidget.getVisibility() != 8) {
                            ConstraintWidget constraintWidget5 = this.f1813a1[i21];
                            ConstraintWidget constraintWidget6 = this.Z0[i22];
                            if (constraintWidget != constraintWidget5) {
                                constraintWidget.connect(constraintWidget.K, constraintWidget5.K, 0);
                                constraintWidget.connect(constraintWidget.M, constraintWidget5.M, 0);
                            }
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.connect(constraintWidget.L, constraintWidget6.L, 0);
                                constraintWidget.connect(constraintWidget.N, constraintWidget6.N, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            arrayList.get(0).createConstraints(z11, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    public final int g(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f1735t;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.A * i10);
                if (i12 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                }
                return i12;
            }
            if (i11 == 1) {
                return constraintWidget.getHeight();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget.getWidth() * constraintWidget.Z) + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    public final int h(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f1734s;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.f1739x * i10);
                if (i12 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i12, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i12;
            }
            if (i11 == 1) {
                return constraintWidget.getWidth();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget.getHeight() * constraintWidget.Z) + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:252:0x044e -> B:258:0x045e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:253:0x0450 -> B:258:0x045e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:255:0x0456 -> B:258:0x045e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:256:0x0458 -> B:258:0x045e). Please report as a decompilation issue!!! */
    @Override // androidx.constraintlayout.core.widgets.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void measure(int r38, int r39, int r40, int r41) {
        /*
            Method dump skipped, instructions count: 1900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.measure(int, int, int, int):void");
    }

    public void setFirstHorizontalBias(float f10) {
        this.N0 = f10;
    }

    public void setFirstHorizontalStyle(int i10) {
        this.H0 = i10;
    }

    public void setFirstVerticalBias(float f10) {
        this.O0 = f10;
    }

    public void setFirstVerticalStyle(int i10) {
        this.I0 = i10;
    }

    public void setHorizontalAlign(int i10) {
        this.T0 = i10;
    }

    public void setHorizontalBias(float f10) {
        this.L0 = f10;
    }

    public void setHorizontalGap(int i10) {
        this.R0 = i10;
    }

    public void setHorizontalStyle(int i10) {
        this.F0 = i10;
    }

    public void setLastHorizontalBias(float f10) {
        this.P0 = f10;
    }

    public void setLastHorizontalStyle(int i10) {
        this.J0 = i10;
    }

    public void setLastVerticalBias(float f10) {
        this.Q0 = f10;
    }

    public void setLastVerticalStyle(int i10) {
        this.K0 = i10;
    }

    public void setMaxElementsWrap(int i10) {
        this.W0 = i10;
    }

    public void setOrientation(int i10) {
        this.X0 = i10;
    }

    public void setVerticalAlign(int i10) {
        this.U0 = i10;
    }

    public void setVerticalBias(float f10) {
        this.M0 = f10;
    }

    public void setVerticalGap(int i10) {
        this.S0 = i10;
    }

    public void setVerticalStyle(int i10) {
        this.G0 = i10;
    }

    public void setWrapMode(int i10) {
        this.V0 = i10;
    }
}
