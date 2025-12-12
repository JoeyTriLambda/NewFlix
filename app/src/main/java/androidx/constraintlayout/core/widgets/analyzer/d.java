package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: VerticalWidgetRun.java */
/* loaded from: classes.dex */
public final class d extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public final DependencyNode f1787k;

    /* renamed from: l, reason: collision with root package name */
    public h0.a f1788l;

    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f1787k = dependencyNode;
        this.f1788l = null;
        this.f1779h.f1755e = DependencyNode.Type.TOP;
        this.f1780i.f1755e = DependencyNode.Type.BOTTOM;
        dependencyNode.f1755e = DependencyNode.Type.BASELINE;
        this.f1777f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void a() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.f1773b;
        boolean z10 = constraintWidget.f1698a;
        a aVar = this.f1776e;
        if (z10) {
            aVar.resolve(constraintWidget.getHeight());
        }
        boolean z11 = aVar.f1760j;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        DependencyNode dependencyNode = this.f1780i;
        DependencyNode dependencyNode2 = this.f1779h;
        if (!z11) {
            this.f1775d = this.f1773b.getVerticalDimensionBehaviour();
            if (this.f1773b.hasBaseline()) {
                this.f1788l = new h0.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f1775d;
            if (dimensionBehaviour4 != dimensionBehaviour3) {
                if (dimensionBehaviour4 == dimensionBehaviour && (parent2 = this.f1773b.getParent()) != null && parent2.getVerticalDimensionBehaviour() == dimensionBehaviour2) {
                    int height = (parent2.getHeight() - this.f1773b.L.getMargin()) - this.f1773b.N.getMargin();
                    addTarget(dependencyNode2, parent2.f1706e.f1779h, this.f1773b.L.getMargin());
                    addTarget(dependencyNode, parent2.f1706e.f1780i, -this.f1773b.N.getMargin());
                    aVar.resolve(height);
                    return;
                }
                if (this.f1775d == dimensionBehaviour2) {
                    aVar.resolve(this.f1773b.getHeight());
                }
            }
        } else if (this.f1775d == dimensionBehaviour && (parent = this.f1773b.getParent()) != null && parent.getVerticalDimensionBehaviour() == dimensionBehaviour2) {
            addTarget(dependencyNode2, parent.f1706e.f1779h, this.f1773b.L.getMargin());
            addTarget(dependencyNode, parent.f1706e.f1780i, -this.f1773b.N.getMargin());
            return;
        }
        boolean z12 = aVar.f1760j;
        DependencyNode dependencyNode3 = this.f1787k;
        if (z12) {
            ConstraintWidget constraintWidget2 = this.f1773b;
            if (constraintWidget2.f1698a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.S;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f1685f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f1685f != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        dependencyNode2.f1756f = this.f1773b.S[2].getMargin();
                        dependencyNode.f1756f = -this.f1773b.S[3].getMargin();
                    } else {
                        DependencyNode target = getTarget(this.f1773b.S[2]);
                        if (target != null) {
                            addTarget(dependencyNode2, target, this.f1773b.S[2].getMargin());
                        }
                        DependencyNode target2 = getTarget(this.f1773b.S[3]);
                        if (target2 != null) {
                            addTarget(dependencyNode, target2, -this.f1773b.S[3].getMargin());
                        }
                        dependencyNode2.f1752b = true;
                        dependencyNode.f1752b = true;
                    }
                    if (this.f1773b.hasBaseline()) {
                        addTarget(dependencyNode3, dependencyNode2, this.f1773b.getBaselineDistance());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(dependencyNode2, target3, this.f1773b.S[2].getMargin());
                        addTarget(dependencyNode, dependencyNode2, aVar.f1757g);
                        if (this.f1773b.hasBaseline()) {
                            addTarget(dependencyNode3, dependencyNode2, this.f1773b.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f1685f != null) {
                    DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(dependencyNode, target4, -this.f1773b.S[3].getMargin());
                        addTarget(dependencyNode2, dependencyNode, -aVar.f1757g);
                    }
                    if (this.f1773b.hasBaseline()) {
                        addTarget(dependencyNode3, dependencyNode2, this.f1773b.getBaselineDistance());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f1685f != null) {
                    DependencyNode target5 = getTarget(constraintAnchor4);
                    if (target5 != null) {
                        addTarget(dependencyNode3, target5, 0);
                        addTarget(dependencyNode2, dependencyNode3, -this.f1773b.getBaselineDistance());
                        addTarget(dependencyNode, dependencyNode2, aVar.f1757g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof g0.a) || constraintWidget2.getParent() == null || this.f1773b.getAnchor(ConstraintAnchor.Type.CENTER).f1685f != null) {
                    return;
                }
                addTarget(dependencyNode2, this.f1773b.getParent().f1706e.f1779h, this.f1773b.getY());
                addTarget(dependencyNode, dependencyNode2, aVar.f1757g);
                if (this.f1773b.hasBaseline()) {
                    addTarget(dependencyNode3, dependencyNode2, this.f1773b.getBaselineDistance());
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = aVar.f1762l;
        if (z12 || this.f1775d != dimensionBehaviour3) {
            aVar.addDependency(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f1773b;
            int i10 = constraintWidget3.f1735t;
            ArrayList arrayList2 = aVar.f1761k;
            if (i10 == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    a aVar2 = parent3.f1706e.f1776e;
                    arrayList.add(aVar2);
                    aVar2.f1761k.add(aVar);
                    aVar.f1752b = true;
                    arrayList2.add(dependencyNode2);
                    arrayList2.add(dependencyNode);
                }
            } else if (i10 == 3 && !constraintWidget3.isInVerticalChain()) {
                ConstraintWidget constraintWidget4 = this.f1773b;
                if (constraintWidget4.f1734s != 3) {
                    a aVar3 = constraintWidget4.f1704d.f1776e;
                    arrayList.add(aVar3);
                    aVar3.f1761k.add(aVar);
                    aVar.f1752b = true;
                    arrayList2.add(dependencyNode2);
                    arrayList2.add(dependencyNode);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f1773b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.S;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1685f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f1685f != null) {
            if (constraintWidget5.isInVerticalChain()) {
                dependencyNode2.f1756f = this.f1773b.S[2].getMargin();
                dependencyNode.f1756f = -this.f1773b.S[3].getMargin();
            } else {
                DependencyNode target6 = getTarget(this.f1773b.S[2]);
                DependencyNode target7 = getTarget(this.f1773b.S[3]);
                if (target6 != null) {
                    target6.addDependency(this);
                }
                if (target7 != null) {
                    target7.addDependency(this);
                }
                this.f1781j = WidgetRun.RunType.CENTER;
            }
            if (this.f1773b.hasBaseline()) {
                addTarget(dependencyNode3, dependencyNode2, 1, this.f1788l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = getTarget(constraintAnchor5);
            if (target8 != null) {
                addTarget(dependencyNode2, target8, this.f1773b.S[2].getMargin());
                addTarget(dependencyNode, dependencyNode2, 1, aVar);
                if (this.f1773b.hasBaseline()) {
                    addTarget(dependencyNode3, dependencyNode2, 1, this.f1788l);
                }
                if (this.f1775d == dimensionBehaviour3 && this.f1773b.getDimensionRatio() > 0.0f) {
                    c cVar = this.f1773b.f1704d;
                    if (cVar.f1775d == dimensionBehaviour3) {
                        cVar.f1776e.f1761k.add(aVar);
                        arrayList.add(this.f1773b.f1704d.f1776e);
                        aVar.f1751a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f1685f != null) {
                DependencyNode target9 = getTarget(constraintAnchor7);
                if (target9 != null) {
                    addTarget(dependencyNode, target9, -this.f1773b.S[3].getMargin());
                    addTarget(dependencyNode2, dependencyNode, -1, aVar);
                    if (this.f1773b.hasBaseline()) {
                        addTarget(dependencyNode3, dependencyNode2, 1, this.f1788l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f1685f != null) {
                    DependencyNode target10 = getTarget(constraintAnchor8);
                    if (target10 != null) {
                        addTarget(dependencyNode3, target10, 0);
                        addTarget(dependencyNode2, dependencyNode3, -1, this.f1788l);
                        addTarget(dependencyNode, dependencyNode2, 1, aVar);
                    }
                } else if (!(constraintWidget5 instanceof g0.a) && constraintWidget5.getParent() != null) {
                    addTarget(dependencyNode2, this.f1773b.getParent().f1706e.f1779h, this.f1773b.getY());
                    addTarget(dependencyNode, dependencyNode2, 1, aVar);
                    if (this.f1773b.hasBaseline()) {
                        addTarget(dependencyNode3, dependencyNode2, 1, this.f1788l);
                    }
                    if (this.f1775d == dimensionBehaviour3 && this.f1773b.getDimensionRatio() > 0.0f) {
                        c cVar2 = this.f1773b.f1704d;
                        if (cVar2.f1775d == dimensionBehaviour3) {
                            cVar2.f1776e.f1761k.add(aVar);
                            arrayList.add(this.f1773b.f1704d.f1776e);
                            aVar.f1751a = this;
                        }
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            aVar.f1753c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.f1779h;
        if (dependencyNode.f1760j) {
            this.f1773b.setY(dependencyNode.f1757g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void b() {
        this.f1774c = null;
        this.f1779h.clear();
        this.f1780i.clear();
        this.f1787k.clear();
        this.f1776e.clear();
        this.f1778g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean c() {
        return this.f1775d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f1773b.f1735t == 0;
    }

    public final void d() {
        this.f1778g = false;
        DependencyNode dependencyNode = this.f1779h;
        dependencyNode.clear();
        dependencyNode.f1760j = false;
        DependencyNode dependencyNode2 = this.f1780i;
        dependencyNode2.clear();
        dependencyNode2.f1760j = false;
        DependencyNode dependencyNode3 = this.f1787k;
        dependencyNode3.clear();
        dependencyNode3.f1760j = false;
        this.f1776e.f1760j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f1773b.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    public void update(h0.d dVar) {
        float f10;
        float dimensionRatio;
        int dimensionRatio2;
        int iOrdinal = this.f1781j.ordinal();
        if (iOrdinal == 1) {
            updateRunStart(dVar);
        } else if (iOrdinal == 2) {
            updateRunEnd(dVar);
        } else if (iOrdinal == 3) {
            ConstraintWidget constraintWidget = this.f1773b;
            updateRunCenter(dVar, constraintWidget.L, constraintWidget.N, 1);
            return;
        }
        a aVar = this.f1776e;
        boolean z10 = aVar.f1753c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (z10 && !aVar.f1760j && this.f1775d == dimensionBehaviour) {
            ConstraintWidget constraintWidget2 = this.f1773b;
            int i10 = constraintWidget2.f1735t;
            if (i10 == 2) {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.f1706e.f1776e.f1760j) {
                        aVar.resolve((int) ((r0.f1757g * this.f1773b.A) + 0.5f));
                    }
                }
            } else if (i10 == 3 && constraintWidget2.f1704d.f1776e.f1760j) {
                int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                if (dimensionRatioSide != -1) {
                    if (dimensionRatioSide == 0) {
                        dimensionRatio2 = (int) ((this.f1773b.getDimensionRatio() * r0.f1704d.f1776e.f1757g) + 0.5f);
                    } else if (dimensionRatioSide != 1) {
                        dimensionRatio2 = 0;
                    } else {
                        ConstraintWidget constraintWidget3 = this.f1773b;
                        f10 = constraintWidget3.f1704d.f1776e.f1757g;
                        dimensionRatio = constraintWidget3.getDimensionRatio();
                    }
                    aVar.resolve(dimensionRatio2);
                } else {
                    ConstraintWidget constraintWidget4 = this.f1773b;
                    f10 = constraintWidget4.f1704d.f1776e.f1757g;
                    dimensionRatio = constraintWidget4.getDimensionRatio();
                }
                dimensionRatio2 = (int) ((f10 / dimensionRatio) + 0.5f);
                aVar.resolve(dimensionRatio2);
            }
        }
        DependencyNode dependencyNode = this.f1779h;
        if (dependencyNode.f1753c) {
            DependencyNode dependencyNode2 = this.f1780i;
            if (dependencyNode2.f1753c) {
                if (dependencyNode.f1760j && dependencyNode2.f1760j && aVar.f1760j) {
                    return;
                }
                boolean z11 = aVar.f1760j;
                ArrayList arrayList = dependencyNode.f1762l;
                ArrayList arrayList2 = dependencyNode2.f1762l;
                if (!z11 && this.f1775d == dimensionBehaviour) {
                    ConstraintWidget constraintWidget5 = this.f1773b;
                    if (constraintWidget5.f1734s == 0 && !constraintWidget5.isInVerticalChain()) {
                        DependencyNode dependencyNode3 = (DependencyNode) arrayList.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) arrayList2.get(0);
                        int i11 = dependencyNode3.f1757g + dependencyNode.f1756f;
                        int i12 = dependencyNode4.f1757g + dependencyNode2.f1756f;
                        dependencyNode.resolve(i11);
                        dependencyNode2.resolve(i12);
                        aVar.resolve(i12 - i11);
                        return;
                    }
                }
                if (!aVar.f1760j && this.f1775d == dimensionBehaviour && this.f1772a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    DependencyNode dependencyNode5 = (DependencyNode) arrayList.get(0);
                    int i13 = (((DependencyNode) arrayList2.get(0)).f1757g + dependencyNode2.f1756f) - (dependencyNode5.f1757g + dependencyNode.f1756f);
                    int i14 = aVar.f1785m;
                    if (i13 < i14) {
                        aVar.resolve(i13);
                    } else {
                        aVar.resolve(i14);
                    }
                }
                if (aVar.f1760j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) arrayList.get(0);
                    DependencyNode dependencyNode7 = (DependencyNode) arrayList2.get(0);
                    int i15 = dependencyNode6.f1757g + dependencyNode.f1756f;
                    int i16 = dependencyNode7.f1757g + dependencyNode2.f1756f;
                    float verticalBiasPercent = this.f1773b.getVerticalBiasPercent();
                    if (dependencyNode6 == dependencyNode7) {
                        i15 = dependencyNode6.f1757g;
                        i16 = dependencyNode7.f1757g;
                        verticalBiasPercent = 0.5f;
                    }
                    dependencyNode.resolve((int) ((((i16 - i15) - aVar.f1757g) * verticalBiasPercent) + i15 + 0.5f));
                    dependencyNode2.resolve(dependencyNode.f1757g + aVar.f1757g);
                }
            }
        }
    }
}
