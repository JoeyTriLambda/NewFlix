package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public final class f extends ConstraintWidget {

    /* renamed from: s0, reason: collision with root package name */
    public float f1835s0 = -1.0f;

    /* renamed from: t0, reason: collision with root package name */
    public int f1836t0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    public int f1837u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    public ConstraintAnchor f1838v0 = this.L;

    /* renamed from: w0, reason: collision with root package name */
    public int f1839w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f1840x0;

    public f() {
        this.T.clear();
        this.T.add(this.f1838v0);
        int length = this.S.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.S[i10] = this.f1838v0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(androidx.constraintlayout.core.c cVar, boolean z10) {
        d dVar = (d) getParent();
        if (dVar == null) {
            return;
        }
        ConstraintAnchor anchor = dVar.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = dVar.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.W;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z11 = constraintWidget != null && constraintWidget.V[0] == dimensionBehaviour;
        if (this.f1839w0 == 0) {
            anchor = dVar.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = dVar.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.W;
            z11 = constraintWidget2 != null && constraintWidget2.V[1] == dimensionBehaviour;
        }
        if (this.f1840x0 && this.f1838v0.hasFinalValue()) {
            SolverVariable solverVariableCreateObjectVariable = cVar.createObjectVariable(this.f1838v0);
            cVar.addEquality(solverVariableCreateObjectVariable, this.f1838v0.getFinalValue());
            if (this.f1836t0 != -1) {
                if (z11) {
                    cVar.addGreaterThan(cVar.createObjectVariable(anchor2), solverVariableCreateObjectVariable, 0, 5);
                }
            } else if (this.f1837u0 != -1 && z11) {
                SolverVariable solverVariableCreateObjectVariable2 = cVar.createObjectVariable(anchor2);
                cVar.addGreaterThan(solverVariableCreateObjectVariable, cVar.createObjectVariable(anchor), 0, 5);
                cVar.addGreaterThan(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, 0, 5);
            }
            this.f1840x0 = false;
            return;
        }
        if (this.f1836t0 != -1) {
            SolverVariable solverVariableCreateObjectVariable3 = cVar.createObjectVariable(this.f1838v0);
            cVar.addEquality(solverVariableCreateObjectVariable3, cVar.createObjectVariable(anchor), this.f1836t0, 8);
            if (z11) {
                cVar.addGreaterThan(cVar.createObjectVariable(anchor2), solverVariableCreateObjectVariable3, 0, 5);
                return;
            }
            return;
        }
        if (this.f1837u0 == -1) {
            if (this.f1835s0 != -1.0f) {
                cVar.addConstraint(androidx.constraintlayout.core.c.createRowDimensionPercent(cVar, cVar.createObjectVariable(this.f1838v0), cVar.createObjectVariable(anchor2), this.f1835s0));
                return;
            }
            return;
        }
        SolverVariable solverVariableCreateObjectVariable4 = cVar.createObjectVariable(this.f1838v0);
        SolverVariable solverVariableCreateObjectVariable5 = cVar.createObjectVariable(anchor2);
        cVar.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable5, -this.f1837u0, 8);
        if (z11) {
            cVar.addGreaterThan(solverVariableCreateObjectVariable4, cVar.createObjectVariable(anchor), 0, 5);
            cVar.addGreaterThan(solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable4, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public ConstraintAnchor getAnchor() {
        return this.f1838v0;
    }

    public int getOrientation() {
        return this.f1839w0;
    }

    public int getRelativeBegin() {
        return this.f1836t0;
    }

    public int getRelativeEnd() {
        return this.f1837u0;
    }

    public float getRelativePercent() {
        return this.f1835s0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.f1840x0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.f1840x0;
    }

    public void setFinalValue(int i10) {
        this.f1838v0.setFinalValue(i10);
        this.f1840x0 = true;
    }

    public void setGuideBegin(int i10) {
        if (i10 > -1) {
            this.f1835s0 = -1.0f;
            this.f1836t0 = i10;
            this.f1837u0 = -1;
        }
    }

    public void setGuideEnd(int i10) {
        if (i10 > -1) {
            this.f1835s0 = -1.0f;
            this.f1836t0 = -1;
            this.f1837u0 = i10;
        }
    }

    public void setGuidePercent(float f10) {
        if (f10 > -1.0f) {
            this.f1835s0 = f10;
            this.f1836t0 = -1;
            this.f1837u0 = -1;
        }
    }

    public void setOrientation(int i10) {
        if (this.f1839w0 == i10) {
            return;
        }
        this.f1839w0 = i10;
        ArrayList<ConstraintAnchor> arrayList = this.T;
        arrayList.clear();
        if (this.f1839w0 == 1) {
            this.f1838v0 = this.K;
        } else {
            this.f1838v0 = this.L;
        }
        arrayList.add(this.f1838v0);
        ConstraintAnchor[] constraintAnchorArr = this.S;
        int length = constraintAnchorArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            constraintAnchorArr[i11] = this.f1838v0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromSolver(androidx.constraintlayout.core.c cVar, boolean z10) {
        if (getParent() == null) {
            return;
        }
        int objectVariableValue = cVar.getObjectVariableValue(this.f1838v0);
        if (this.f1839w0 == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        int iOrdinal = type.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return null;
                    }
                }
            }
            if (this.f1839w0 == 0) {
                return this.f1838v0;
            }
            return null;
        }
        if (this.f1839w0 == 1) {
            return this.f1838v0;
        }
        return null;
    }
}
