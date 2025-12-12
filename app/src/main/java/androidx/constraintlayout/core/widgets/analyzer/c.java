package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: HorizontalWidgetRun.java */
/* loaded from: classes.dex */
public final class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f1786k = new int[2];

    public c(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f1779h.f1755e = DependencyNode.Type.LEFT;
        this.f1780i.f1755e = DependencyNode.Type.RIGHT;
        this.f1777f = 0;
    }

    public static void d(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void a() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.f1773b;
        boolean z10 = constraintWidget.f1698a;
        a aVar = this.f1776e;
        if (z10) {
            aVar.resolve(constraintWidget.getWidth());
        }
        boolean z11 = aVar.f1760j;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        DependencyNode dependencyNode = this.f1780i;
        DependencyNode dependencyNode2 = this.f1779h;
        if (!z11) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.f1773b.getHorizontalDimensionBehaviour();
            this.f1775d = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != dimensionBehaviour) {
                if (horizontalDimensionBehaviour == dimensionBehaviour2 && (parent2 = this.f1773b.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour3 || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour2)) {
                    int width = (parent2.getWidth() - this.f1773b.K.getMargin()) - this.f1773b.M.getMargin();
                    addTarget(dependencyNode2, parent2.f1704d.f1779h, this.f1773b.K.getMargin());
                    addTarget(dependencyNode, parent2.f1704d.f1780i, -this.f1773b.M.getMargin());
                    aVar.resolve(width);
                    return;
                }
                if (this.f1775d == dimensionBehaviour3) {
                    aVar.resolve(this.f1773b.getWidth());
                }
            }
        } else if (this.f1775d == dimensionBehaviour2 && (parent = this.f1773b.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3 || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour2)) {
            addTarget(dependencyNode2, parent.f1704d.f1779h, this.f1773b.K.getMargin());
            addTarget(dependencyNode, parent.f1704d.f1780i, -this.f1773b.M.getMargin());
            return;
        }
        if (aVar.f1760j) {
            ConstraintWidget constraintWidget2 = this.f1773b;
            if (constraintWidget2.f1698a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.S;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f1685f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f1685f != null) {
                    if (constraintWidget2.isInHorizontalChain()) {
                        dependencyNode2.f1756f = this.f1773b.S[0].getMargin();
                        dependencyNode.f1756f = -this.f1773b.S[1].getMargin();
                        return;
                    }
                    DependencyNode target = getTarget(this.f1773b.S[0]);
                    if (target != null) {
                        addTarget(dependencyNode2, target, this.f1773b.S[0].getMargin());
                    }
                    DependencyNode target2 = getTarget(this.f1773b.S[1]);
                    if (target2 != null) {
                        addTarget(dependencyNode, target2, -this.f1773b.S[1].getMargin());
                    }
                    dependencyNode2.f1752b = true;
                    dependencyNode.f1752b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(dependencyNode2, target3, this.f1773b.S[0].getMargin());
                        addTarget(dependencyNode, dependencyNode2, aVar.f1757g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f1685f != null) {
                    DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(dependencyNode, target4, -this.f1773b.S[1].getMargin());
                        addTarget(dependencyNode2, dependencyNode, -aVar.f1757g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof g0.a) || constraintWidget2.getParent() == null || this.f1773b.getAnchor(ConstraintAnchor.Type.CENTER).f1685f != null) {
                    return;
                }
                addTarget(dependencyNode2, this.f1773b.getParent().f1704d.f1779h, this.f1773b.getX());
                addTarget(dependencyNode, dependencyNode2, aVar.f1757g);
                return;
            }
        }
        if (this.f1775d == dimensionBehaviour) {
            ConstraintWidget constraintWidget3 = this.f1773b;
            int i10 = constraintWidget3.f1734s;
            ArrayList arrayList = aVar.f1761k;
            ArrayList arrayList2 = aVar.f1762l;
            if (i10 == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    a aVar2 = parent3.f1706e.f1776e;
                    arrayList2.add(aVar2);
                    aVar2.f1761k.add(aVar);
                    aVar.f1752b = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            } else if (i10 == 3) {
                if (constraintWidget3.f1735t == 3) {
                    dependencyNode2.f1751a = this;
                    dependencyNode.f1751a = this;
                    d dVar = constraintWidget3.f1706e;
                    dVar.f1779h.f1751a = this;
                    dVar.f1780i.f1751a = this;
                    aVar.f1751a = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        arrayList2.add(this.f1773b.f1706e.f1776e);
                        this.f1773b.f1706e.f1776e.f1761k.add(aVar);
                        d dVar2 = this.f1773b.f1706e;
                        dVar2.f1776e.f1751a = this;
                        arrayList2.add(dVar2.f1779h);
                        arrayList2.add(this.f1773b.f1706e.f1780i);
                        this.f1773b.f1706e.f1779h.f1761k.add(aVar);
                        this.f1773b.f1706e.f1780i.f1761k.add(aVar);
                    } else if (this.f1773b.isInHorizontalChain()) {
                        this.f1773b.f1706e.f1776e.f1762l.add(aVar);
                        arrayList.add(this.f1773b.f1706e.f1776e);
                    } else {
                        this.f1773b.f1706e.f1776e.f1762l.add(aVar);
                    }
                } else {
                    a aVar3 = constraintWidget3.f1706e.f1776e;
                    arrayList2.add(aVar3);
                    aVar3.f1761k.add(aVar);
                    this.f1773b.f1706e.f1779h.f1761k.add(aVar);
                    this.f1773b.f1706e.f1780i.f1761k.add(aVar);
                    aVar.f1752b = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                    dependencyNode2.f1762l.add(aVar);
                    dependencyNode.f1762l.add(aVar);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f1773b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f1685f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f1685f != null) {
            if (constraintWidget4.isInHorizontalChain()) {
                dependencyNode2.f1756f = this.f1773b.S[0].getMargin();
                dependencyNode.f1756f = -this.f1773b.S[1].getMargin();
                return;
            }
            DependencyNode target5 = getTarget(this.f1773b.S[0]);
            DependencyNode target6 = getTarget(this.f1773b.S[1]);
            if (target5 != null) {
                target5.addDependency(this);
            }
            if (target6 != null) {
                target6.addDependency(this);
            }
            this.f1781j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode target7 = getTarget(constraintAnchor4);
            if (target7 != null) {
                addTarget(dependencyNode2, target7, this.f1773b.S[0].getMargin());
                addTarget(dependencyNode, dependencyNode2, 1, aVar);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f1685f != null) {
            DependencyNode target8 = getTarget(constraintAnchor6);
            if (target8 != null) {
                addTarget(dependencyNode, target8, -this.f1773b.S[1].getMargin());
                addTarget(dependencyNode2, dependencyNode, -1, aVar);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof g0.a) || constraintWidget4.getParent() == null) {
            return;
        }
        addTarget(dependencyNode2, this.f1773b.getParent().f1704d.f1779h, this.f1773b.getX());
        addTarget(dependencyNode, dependencyNode2, 1, aVar);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.f1779h;
        if (dependencyNode.f1760j) {
            this.f1773b.setX(dependencyNode.f1757g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void b() {
        this.f1774c = null;
        this.f1779h.clear();
        this.f1780i.clear();
        this.f1776e.clear();
        this.f1778g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean c() {
        return this.f1775d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f1773b.f1734s == 0;
    }

    public final void e() {
        this.f1778g = false;
        DependencyNode dependencyNode = this.f1779h;
        dependencyNode.clear();
        dependencyNode.f1760j = false;
        DependencyNode dependencyNode2 = this.f1780i;
        dependencyNode2.clear();
        dependencyNode2.f1760j = false;
        this.f1776e.f1760j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f1773b.getDebugName();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x02a6  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(h0.d r24) {
        /*
            Method dump skipped, instructions count: 957
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.c.update(h0.d):void");
    }
}
