package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.b;
import java.util.HashSet;

/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public class h extends g0.b {

    /* renamed from: u0, reason: collision with root package name */
    public int f1842u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public int f1843v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public int f1844w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    public int f1845x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public int f1846y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public int f1847z0 = 0;
    public boolean A0 = false;
    public int B0 = 0;
    public int C0 = 0;
    public final b.a D0 = new b.a();
    public b.InterfaceC0158b E0 = null;

    public void applyRtl(boolean z10) {
        int i10 = this.f1844w0;
        if (i10 > 0 || this.f1845x0 > 0) {
            if (z10) {
                this.f1846y0 = this.f1845x0;
                this.f1847z0 = i10;
            } else {
                this.f1846y0 = i10;
                this.f1847z0 = this.f1845x0;
            }
        }
    }

    public void captureWidgets() {
        for (int i10 = 0; i10 < this.f12502t0; i10++) {
            ConstraintWidget constraintWidget = this.f12501s0[i10];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public boolean contains(HashSet<ConstraintWidget> hashSet) {
        for (int i10 = 0; i10 < this.f12502t0; i10++) {
            if (hashSet.contains(this.f12501s0[i10])) {
                return true;
            }
        }
        return false;
    }

    public int getMeasuredHeight() {
        return this.C0;
    }

    public int getMeasuredWidth() {
        return this.B0;
    }

    public int getPaddingBottom() {
        return this.f1843v0;
    }

    public int getPaddingLeft() {
        return this.f1846y0;
    }

    public int getPaddingRight() {
        return this.f1847z0;
    }

    public int getPaddingTop() {
        return this.f1842u0;
    }

    public void measure(int i10, int i11, int i12, int i13) {
    }

    public boolean measureChildren() {
        ConstraintWidget constraintWidget = this.W;
        b.InterfaceC0158b measurer = constraintWidget != null ? ((d) constraintWidget).getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f12502t0) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.f12501s0[i10];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (!(dimensionBehaviour == dimensionBehaviour3 && constraintWidget2.f1734s != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget2.f1735t != 1)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = dimensionBehaviour4;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = dimensionBehaviour4;
                    }
                    b.a aVar = this.D0;
                    aVar.f12877a = dimensionBehaviour;
                    aVar.f12878b = dimensionBehaviour2;
                    aVar.f12879c = constraintWidget2.getWidth();
                    aVar.f12880d = constraintWidget2.getHeight();
                    ((ConstraintLayout.b) measurer).measure(constraintWidget2, aVar);
                    constraintWidget2.setWidth(aVar.f12881e);
                    constraintWidget2.setHeight(aVar.f12882f);
                    constraintWidget2.setBaselineDistance(aVar.f12883g);
                }
            }
            i10++;
        }
    }

    public boolean needSolverPass() {
        return this.A0;
    }

    public void needsCallbackFromSolver(boolean z10) {
        this.A0 = z10;
    }

    public void setMeasure(int i10, int i11) {
        this.B0 = i10;
        this.C0 = i11;
    }

    public void setPadding(int i10) {
        this.f1842u0 = i10;
        this.f1843v0 = i10;
        this.f1844w0 = i10;
        this.f1845x0 = i10;
    }

    public void setPaddingBottom(int i10) {
        this.f1843v0 = i10;
    }

    public void setPaddingEnd(int i10) {
        this.f1845x0 = i10;
    }

    public void setPaddingLeft(int i10) {
        this.f1846y0 = i10;
    }

    public void setPaddingRight(int i10) {
        this.f1847z0 = i10;
    }

    public void setPaddingStart(int i10) {
        this.f1844w0 = i10;
        this.f1846y0 = i10;
        this.f1847z0 = i10;
    }

    public void setPaddingTop(int i10) {
        this.f1842u0 = i10;
    }

    @Override // g0.b, g0.a
    public void updateConstraints(d dVar) {
        captureWidgets();
    }

    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        while (this.E0 == null && getParent() != null) {
            this.E0 = ((d) getParent()).getMeasurer();
        }
        b.a aVar = this.D0;
        aVar.f12877a = dimensionBehaviour;
        aVar.f12878b = dimensionBehaviour2;
        aVar.f12879c = i10;
        aVar.f12880d = i11;
        ((ConstraintLayout.b) this.E0).measure(constraintWidget, aVar);
        constraintWidget.setWidth(aVar.f12881e);
        constraintWidget.setHeight(aVar.f12882f);
        constraintWidget.setHasBaseline(aVar.f12884h);
        constraintWidget.setBaselineDistance(aVar.f12883g);
    }
}
