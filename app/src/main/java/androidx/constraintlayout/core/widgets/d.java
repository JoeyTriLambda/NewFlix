package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public final class d extends g0.c {
    public int A0;

    /* renamed from: v0, reason: collision with root package name */
    public int f1808v0;

    /* renamed from: z0, reason: collision with root package name */
    public int f1812z0;

    /* renamed from: t0, reason: collision with root package name */
    public final h0.b f1806t0 = new h0.b(this);

    /* renamed from: u0, reason: collision with root package name */
    public final h0.e f1807u0 = new h0.e(this);

    /* renamed from: w0, reason: collision with root package name */
    public b.InterfaceC0158b f1809w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f1810x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public final androidx.constraintlayout.core.c f1811y0 = new androidx.constraintlayout.core.c();
    public int B0 = 0;
    public int C0 = 0;
    public c[] D0 = new c[4];
    public c[] E0 = new c[4];
    public int F0 = 257;
    public boolean G0 = false;
    public boolean H0 = false;
    public WeakReference<ConstraintAnchor> I0 = null;
    public WeakReference<ConstraintAnchor> J0 = null;
    public WeakReference<ConstraintAnchor> K0 = null;
    public WeakReference<ConstraintAnchor> L0 = null;
    public final HashSet<ConstraintWidget> M0 = new HashSet<>();
    public final b.a N0 = new b.a();

    public boolean addChildrenToSolver(androidx.constraintlayout.core.c cVar) {
        boolean zOptimizeFor = optimizeFor(64);
        addToSolver(cVar, zOptimizeFor);
        int size = this.f12503s0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f12503s0.get(i10);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget2 = this.f12503s0.get(i11);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).markWidgets();
                }
            }
        }
        HashSet<ConstraintWidget> hashSet = this.M0;
        hashSet.clear();
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget3 = this.f12503s0.get(i12);
            constraintWidget3.getClass();
            if ((constraintWidget3 instanceof h) || (constraintWidget3 instanceof f)) {
                if (constraintWidget3 instanceof h) {
                    hashSet.add(constraintWidget3);
                } else {
                    constraintWidget3.addToSolver(cVar, zOptimizeFor);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator<ConstraintWidget> it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar = (h) it.next();
                if (hVar.contains(hashSet)) {
                    hVar.addToSolver(cVar, zOptimizeFor);
                    hashSet.remove(hVar);
                    break;
                }
            }
            if (size2 == hashSet.size()) {
                Iterator<ConstraintWidget> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    it2.next().addToSolver(cVar, zOptimizeFor);
                }
                hashSet.clear();
            }
        }
        boolean z11 = androidx.constraintlayout.core.c.f1657p;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (z11) {
            HashSet<ConstraintWidget> hashSet2 = new HashSet<>();
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget4 = this.f12503s0.get(i13);
                constraintWidget4.getClass();
                if (!((constraintWidget4 instanceof h) || (constraintWidget4 instanceof f))) {
                    hashSet2.add(constraintWidget4);
                }
            }
            addChildrenToSolverByDependency(this, cVar, hashSet2, getHorizontalDimensionBehaviour() == dimensionBehaviour ? 0 : 1, false);
            Iterator<ConstraintWidget> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                g.a(this, cVar, next);
                next.addToSolver(cVar, zOptimizeFor);
            }
        } else {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget5 = this.f12503s0.get(i14);
                if (constraintWidget5 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.V;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    if (dimensionBehaviour2 == dimensionBehaviour) {
                        constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour4);
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour) {
                        constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour4);
                    }
                    constraintWidget5.addToSolver(cVar, zOptimizeFor);
                    if (dimensionBehaviour2 == dimensionBehaviour) {
                        constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour2);
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour) {
                        constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour3);
                    }
                } else {
                    g.a(this, cVar, constraintWidget5);
                    if (!((constraintWidget5 instanceof h) || (constraintWidget5 instanceof f))) {
                        constraintWidget5.addToSolver(cVar, zOptimizeFor);
                    }
                }
            }
        }
        if (this.B0 > 0) {
            b.applyChainConstraints(this, cVar, null, 0);
        }
        if (this.C0 > 0) {
            b.applyChainConstraints(this, cVar, null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.L0;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.L0.get().getFinalValue()) {
            this.L0 = new WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.J0;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.J0.get().getFinalValue()) {
            this.J0 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean directMeasure(boolean z10) {
        return this.f1807u0.directMeasure(z10);
    }

    public boolean directMeasureSetup(boolean z10) {
        return this.f1807u0.directMeasureSetup(z10);
    }

    public boolean directMeasureWithOrientation(boolean z10, int i10) {
        return this.f1807u0.directMeasureWithOrientation(z10, i10);
    }

    public final void g(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            int i11 = this.B0 + 1;
            c[] cVarArr = this.E0;
            if (i11 >= cVarArr.length) {
                this.E0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
            }
            this.E0[this.B0] = new c(constraintWidget, 0, isRtl());
            this.B0++;
            return;
        }
        if (i10 == 1) {
            int i12 = this.C0 + 1;
            c[] cVarArr2 = this.D0;
            if (i12 >= cVarArr2.length) {
                this.D0 = (c[]) Arrays.copyOf(cVarArr2, cVarArr2.length * 2);
            }
            this.D0[this.C0] = new c(constraintWidget, 1, isRtl());
            this.C0++;
        }
    }

    public b.InterfaceC0158b getMeasurer() {
        return this.f1809w0;
    }

    public int getOptimizationLevel() {
        return this.F0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder sb2) {
        sb2.append(this.f1718k + ":{\n");
        StringBuilder sb3 = new StringBuilder("  actualWidth:");
        sb3.append(this.X);
        sb2.append(sb3.toString());
        sb2.append(StringUtils.LF);
        sb2.append("  actualHeight:" + this.Y);
        sb2.append(StringUtils.LF);
        Iterator<ConstraintWidget> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().getSceneString(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public androidx.constraintlayout.core.c getSystem() {
        return this.f1811y0;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.f1807u0.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.f1807u0.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.H0;
    }

    public boolean isRtl() {
        return this.f1810x0;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.G0;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0242 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0326 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0187  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    @Override // g0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layout() {
        /*
            Method dump skipped, instructions count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.layout():void");
    }

    public long measure(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f1812z0 = i17;
        this.A0 = i18;
        return this.f1806t0.solverMeasure(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean optimizeFor(int i10) {
        return (this.F0 & i10) == i10;
    }

    @Override // g0.c, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.f1811y0.reset();
        this.f1812z0 = 0;
        this.A0 = 0;
        super.reset();
    }

    public void setMeasurer(b.InterfaceC0158b interfaceC0158b) {
        this.f1809w0 = interfaceC0158b;
        this.f1807u0.setMeasurer(interfaceC0158b);
    }

    public void setOptimizationLevel(int i10) {
        this.F0 = i10;
        androidx.constraintlayout.core.c.f1657p = optimizeFor(512);
    }

    public void setPass(int i10) {
        this.f1808v0 = i10;
    }

    public void setRtl(boolean z10) {
        this.f1810x0 = z10;
    }

    public boolean updateChildrenFromSolver(androidx.constraintlayout.core.c cVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zOptimizeFor = optimizeFor(64);
        updateFromSolver(cVar, zOptimizeFor);
        int size = this.f12503s0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f12503s0.get(i10);
            constraintWidget.updateFromSolver(cVar, zOptimizeFor);
            if (constraintWidget.hasDimensionOverride()) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean z10, boolean z11) {
        super.updateFromRuns(z10, z11);
        int size = this.f12503s0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f12503s0.get(i10).updateFromRuns(z10, z11);
        }
    }

    public void updateHierarchy() {
        this.f1806t0.updateHierarchy(this);
    }

    public static boolean measure(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b, b.a aVar, int i11) {
        int i12;
        int i13;
        if (interfaceC0158b == null) {
            return false;
        }
        if (constraintWidget.getVisibility() != 8 && !(constraintWidget instanceof f) && !(constraintWidget instanceof a)) {
            aVar.f12877a = constraintWidget.getHorizontalDimensionBehaviour();
            aVar.f12878b = constraintWidget.getVerticalDimensionBehaviour();
            aVar.f12879c = constraintWidget.getWidth();
            aVar.f12880d = constraintWidget.getHeight();
            aVar.f12885i = false;
            aVar.f12886j = i11;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f12877a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z10 = dimensionBehaviour == dimensionBehaviour2;
            boolean z11 = aVar.f12878b == dimensionBehaviour2;
            boolean z12 = z10 && constraintWidget.Z > 0.0f;
            boolean z13 = z11 && constraintWidget.Z > 0.0f;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
            if (z10 && constraintWidget.hasDanglingDimension(0) && constraintWidget.f1734s == 0 && !z12) {
                aVar.f12877a = dimensionBehaviour3;
                if (z11 && constraintWidget.f1735t == 0) {
                    aVar.f12877a = dimensionBehaviour4;
                }
                z10 = false;
            }
            if (z11 && constraintWidget.hasDanglingDimension(1) && constraintWidget.f1735t == 0 && !z13) {
                aVar.f12878b = dimensionBehaviour3;
                if (z10 && constraintWidget.f1734s == 0) {
                    aVar.f12878b = dimensionBehaviour4;
                }
                z11 = false;
            }
            if (constraintWidget.isResolvedHorizontally()) {
                aVar.f12877a = dimensionBehaviour4;
                z10 = false;
            }
            if (constraintWidget.isResolvedVertically()) {
                aVar.f12878b = dimensionBehaviour4;
                z11 = false;
            }
            int[] iArr = constraintWidget.f1736u;
            if (z12) {
                if (iArr[0] == 4) {
                    aVar.f12877a = dimensionBehaviour4;
                } else if (!z11) {
                    if (aVar.f12878b == dimensionBehaviour4) {
                        i13 = aVar.f12880d;
                    } else {
                        aVar.f12877a = dimensionBehaviour3;
                        ((ConstraintLayout.b) interfaceC0158b).measure(constraintWidget, aVar);
                        i13 = aVar.f12882f;
                    }
                    aVar.f12877a = dimensionBehaviour4;
                    aVar.f12879c = (int) (constraintWidget.getDimensionRatio() * i13);
                }
            }
            if (z13) {
                if (iArr[1] == 4) {
                    aVar.f12878b = dimensionBehaviour4;
                } else if (!z10) {
                    if (aVar.f12877a == dimensionBehaviour4) {
                        i12 = aVar.f12879c;
                    } else {
                        aVar.f12878b = dimensionBehaviour3;
                        ((ConstraintLayout.b) interfaceC0158b).measure(constraintWidget, aVar);
                        i12 = aVar.f12881e;
                    }
                    aVar.f12878b = dimensionBehaviour4;
                    if (constraintWidget.getDimensionRatioSide() == -1) {
                        aVar.f12880d = (int) (i12 / constraintWidget.getDimensionRatio());
                    } else {
                        aVar.f12880d = (int) (constraintWidget.getDimensionRatio() * i12);
                    }
                }
            }
            ((ConstraintLayout.b) interfaceC0158b).measure(constraintWidget, aVar);
            constraintWidget.setWidth(aVar.f12881e);
            constraintWidget.setHeight(aVar.f12882f);
            constraintWidget.setHasBaseline(aVar.f12884h);
            constraintWidget.setBaselineDistance(aVar.f12883g);
            aVar.f12886j = 0;
            return aVar.f12885i;
        }
        aVar.f12881e = 0;
        aVar.f12882f = 0;
        return false;
    }
}
