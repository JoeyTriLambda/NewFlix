package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public final class a extends g0.b {

    /* renamed from: u0, reason: collision with root package name */
    public int f1747u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f1748v0 = true;

    /* renamed from: w0, reason: collision with root package name */
    public int f1749w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f1750x0 = false;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(androidx.constraintlayout.core.c cVar, boolean z10) {
        boolean z11;
        int i10;
        int i11;
        ConstraintAnchor[] constraintAnchorArr = this.S;
        ConstraintAnchor constraintAnchor = this.K;
        constraintAnchorArr[0] = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = this.L;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.M;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.N;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.f1688i = cVar.createObjectVariable(constraintAnchor5);
        }
        int i12 = this.f1747u0;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr[i12];
        if (!this.f1750x0) {
            allSolved();
        }
        if (this.f1750x0) {
            this.f1750x0 = false;
            int i13 = this.f1747u0;
            if (i13 == 0 || i13 == 1) {
                cVar.addEquality(constraintAnchor.f1688i, this.f1701b0);
                cVar.addEquality(constraintAnchor3.f1688i, this.f1701b0);
                return;
            } else {
                if (i13 == 2 || i13 == 3) {
                    cVar.addEquality(constraintAnchor2.f1688i, this.f1703c0);
                    cVar.addEquality(constraintAnchor4.f1688i, this.f1703c0);
                    return;
                }
                return;
            }
        }
        for (int i14 = 0; i14 < this.f12502t0; i14++) {
            ConstraintWidget constraintWidget = this.f12501s0[i14];
            if (this.f1748v0 || constraintWidget.allowedInBarrier()) {
                int i15 = this.f1747u0;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (((i15 == 0 || i15 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget.K.f1685f != null && constraintWidget.M.f1685f != null) || (((i11 = this.f1747u0) == 2 || i11 == 3) && constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget.L.f1685f != null && constraintWidget.N.f1685f != null)) {
                    z11 = true;
                    break;
                }
            }
        }
        z11 = false;
        boolean z12 = constraintAnchor.hasCenteredDependents() || constraintAnchor3.hasCenteredDependents();
        boolean z13 = constraintAnchor2.hasCenteredDependents() || constraintAnchor4.hasCenteredDependents();
        int i16 = !(!z11 && (((i10 = this.f1747u0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13))))) ? 4 : 5;
        for (int i17 = 0; i17 < this.f12502t0; i17++) {
            ConstraintWidget constraintWidget2 = this.f12501s0[i17];
            if (this.f1748v0 || constraintWidget2.allowedInBarrier()) {
                SolverVariable solverVariableCreateObjectVariable = cVar.createObjectVariable(constraintWidget2.S[this.f1747u0]);
                int i18 = this.f1747u0;
                ConstraintAnchor constraintAnchor7 = constraintWidget2.S[i18];
                constraintAnchor7.f1688i = solverVariableCreateObjectVariable;
                ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1685f;
                int i19 = (constraintAnchor8 == null || constraintAnchor8.f1683d != this) ? 0 : constraintAnchor7.f1686g + 0;
                if (i18 == 0 || i18 == 2) {
                    cVar.addLowerBarrier(constraintAnchor6.f1688i, solverVariableCreateObjectVariable, this.f1749w0 - i19, z11);
                } else {
                    cVar.addGreaterBarrier(constraintAnchor6.f1688i, solverVariableCreateObjectVariable, this.f1749w0 + i19, z11);
                }
                cVar.addEquality(constraintAnchor6.f1688i, solverVariableCreateObjectVariable, this.f1749w0 + i19, i16);
            }
        }
        int i20 = this.f1747u0;
        if (i20 == 0) {
            cVar.addEquality(constraintAnchor3.f1688i, constraintAnchor.f1688i, 0, 8);
            cVar.addEquality(constraintAnchor.f1688i, this.W.M.f1688i, 0, 4);
            cVar.addEquality(constraintAnchor.f1688i, this.W.K.f1688i, 0, 0);
            return;
        }
        if (i20 == 1) {
            cVar.addEquality(constraintAnchor.f1688i, constraintAnchor3.f1688i, 0, 8);
            cVar.addEquality(constraintAnchor.f1688i, this.W.K.f1688i, 0, 4);
            cVar.addEquality(constraintAnchor.f1688i, this.W.M.f1688i, 0, 0);
        } else if (i20 == 2) {
            cVar.addEquality(constraintAnchor4.f1688i, constraintAnchor2.f1688i, 0, 8);
            cVar.addEquality(constraintAnchor2.f1688i, this.W.N.f1688i, 0, 4);
            cVar.addEquality(constraintAnchor2.f1688i, this.W.L.f1688i, 0, 0);
        } else if (i20 == 3) {
            cVar.addEquality(constraintAnchor2.f1688i, constraintAnchor4.f1688i, 0, 8);
            cVar.addEquality(constraintAnchor2.f1688i, this.W.L.f1688i, 0, 4);
            cVar.addEquality(constraintAnchor2.f1688i, this.W.N.f1688i, 0, 0);
        }
    }

    public boolean allSolved() {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (true) {
            i10 = this.f12502t0;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.f12501s0[i13];
            if ((this.f1748v0 || constraintWidget.allowedInBarrier()) && ((((i11 = this.f1747u0) == 0 || i11 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i12 = this.f1747u0) == 2 || i12 == 3) && !constraintWidget.isResolvedVertically()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i14 = 0; i14 < this.f12502t0; i14++) {
            ConstraintWidget constraintWidget2 = this.f12501s0[i14];
            if (this.f1748v0 || constraintWidget2.allowedInBarrier()) {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                if (!z11) {
                    int i15 = this.f1747u0;
                    if (i15 == 0) {
                        iMax = constraintWidget2.getAnchor(type4).getFinalValue();
                    } else if (i15 == 1) {
                        iMax = constraintWidget2.getAnchor(type3).getFinalValue();
                    } else if (i15 == 2) {
                        iMax = constraintWidget2.getAnchor(type2).getFinalValue();
                    } else if (i15 == 3) {
                        iMax = constraintWidget2.getAnchor(type).getFinalValue();
                    }
                    z11 = true;
                }
                int i16 = this.f1747u0;
                if (i16 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(type4).getFinalValue());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(type3).getFinalValue());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(type2).getFinalValue());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(type).getFinalValue());
                }
            }
        }
        int i17 = iMax + this.f1749w0;
        int i18 = this.f1747u0;
        if (i18 == 0 || i18 == 1) {
            setFinalHorizontal(i17, i17);
        } else {
            setFinalVertical(i17, i17);
        }
        this.f1750x0 = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean getAllowsGoneWidget() {
        return this.f1748v0;
    }

    public int getBarrierType() {
        return this.f1747u0;
    }

    public int getMargin() {
        return this.f1749w0;
    }

    public int getOrientation() {
        int i10 = this.f1747u0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.f1750x0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.f1750x0;
    }

    public void markWidgets() {
        for (int i10 = 0; i10 < this.f12502t0; i10++) {
            ConstraintWidget constraintWidget = this.f12501s0[i10];
            if (this.f1748v0 || constraintWidget.allowedInBarrier()) {
                int i11 = this.f1747u0;
                if (i11 == 0 || i11 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1748v0 = z10;
    }

    public void setBarrierType(int i10) {
        this.f1747u0 = i10;
    }

    public void setMargin(int i10) {
        this.f1749w0 = i10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String string = "[Barrier] " + getDebugName() + " {";
        for (int i10 = 0; i10 < this.f12502t0; i10++) {
            ConstraintWidget constraintWidget = this.f12501s0[i10];
            if (i10 > 0) {
                string = ac.c.B(string, ", ");
            }
            StringBuilder sbR = ac.c.r(string);
            sbR.append(constraintWidget.getDebugName());
            string = sbR.toString();
        }
        return ac.c.B(string, "}");
    }
}
