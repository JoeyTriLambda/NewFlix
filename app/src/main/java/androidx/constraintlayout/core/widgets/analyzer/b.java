package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: HelperReferences.java */
/* loaded from: classes.dex */
public final class b extends WidgetRun {
    public b(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void a() {
        ConstraintWidget constraintWidget = this.f1773b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            DependencyNode dependencyNode = this.f1779h;
            dependencyNode.f1752b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int barrierType = aVar.getBarrierType();
            boolean allowsGoneWidget = aVar.getAllowsGoneWidget();
            ArrayList arrayList = dependencyNode.f1762l;
            int i10 = 0;
            if (barrierType == 0) {
                dependencyNode.f1755e = DependencyNode.Type.LEFT;
                while (i10 < aVar.f12502t0) {
                    ConstraintWidget constraintWidget2 = aVar.f12501s0[i10];
                    if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget2.f1704d.f1779h;
                        dependencyNode2.f1761k.add(dependencyNode);
                        arrayList.add(dependencyNode2);
                    }
                    i10++;
                }
                d(this.f1773b.f1704d.f1779h);
                d(this.f1773b.f1704d.f1780i);
                return;
            }
            if (barrierType == 1) {
                dependencyNode.f1755e = DependencyNode.Type.RIGHT;
                while (i10 < aVar.f12502t0) {
                    ConstraintWidget constraintWidget3 = aVar.f12501s0[i10];
                    if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget3.f1704d.f1780i;
                        dependencyNode3.f1761k.add(dependencyNode);
                        arrayList.add(dependencyNode3);
                    }
                    i10++;
                }
                d(this.f1773b.f1704d.f1779h);
                d(this.f1773b.f1704d.f1780i);
                return;
            }
            if (barrierType == 2) {
                dependencyNode.f1755e = DependencyNode.Type.TOP;
                while (i10 < aVar.f12502t0) {
                    ConstraintWidget constraintWidget4 = aVar.f12501s0[i10];
                    if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.f1706e.f1779h;
                        dependencyNode4.f1761k.add(dependencyNode);
                        arrayList.add(dependencyNode4);
                    }
                    i10++;
                }
                d(this.f1773b.f1706e.f1779h);
                d(this.f1773b.f1706e.f1780i);
                return;
            }
            if (barrierType != 3) {
                return;
            }
            dependencyNode.f1755e = DependencyNode.Type.BOTTOM;
            while (i10 < aVar.f12502t0) {
                ConstraintWidget constraintWidget5 = aVar.f12501s0[i10];
                if (allowsGoneWidget || constraintWidget5.getVisibility() != 8) {
                    DependencyNode dependencyNode5 = constraintWidget5.f1706e.f1780i;
                    dependencyNode5.f1761k.add(dependencyNode);
                    arrayList.add(dependencyNode5);
                }
                i10++;
            }
            d(this.f1773b.f1706e.f1779h);
            d(this.f1773b.f1706e.f1780i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        ConstraintWidget constraintWidget = this.f1773b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int barrierType = ((androidx.constraintlayout.core.widgets.a) constraintWidget).getBarrierType();
            DependencyNode dependencyNode = this.f1779h;
            if (barrierType == 0 || barrierType == 1) {
                this.f1773b.setX(dependencyNode.f1757g);
            } else {
                this.f1773b.setY(dependencyNode.f1757g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void b() {
        this.f1774c = null;
        this.f1779h.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean c() {
        return false;
    }

    public final void d(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.f1779h;
        dependencyNode2.f1761k.add(dependencyNode);
        dependencyNode.f1762l.add(dependencyNode2);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    public void update(h0.d dVar) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.f1773b;
        int barrierType = aVar.getBarrierType();
        DependencyNode dependencyNode = this.f1779h;
        Iterator it = dependencyNode.f1762l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = ((DependencyNode) it.next()).f1757g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (barrierType == 0 || barrierType == 2) {
            dependencyNode.resolve(aVar.getMargin() + i11);
        } else {
            dependencyNode.resolve(aVar.getMargin() + i10);
        }
    }
}
