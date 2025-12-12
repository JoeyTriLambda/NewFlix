package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* compiled from: GuidelineReference.java */
/* loaded from: classes.dex */
public final class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f1704d.b();
        constraintWidget.f1706e.b();
        this.f1777f = ((androidx.constraintlayout.core.widgets.f) constraintWidget).getOrientation();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void a() {
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) this.f1773b;
        int relativeBegin = fVar.getRelativeBegin();
        int relativeEnd = fVar.getRelativeEnd();
        fVar.getRelativePercent();
        int orientation = fVar.getOrientation();
        DependencyNode dependencyNode = this.f1779h;
        if (orientation == 1) {
            if (relativeBegin != -1) {
                dependencyNode.f1762l.add(this.f1773b.W.f1704d.f1779h);
                this.f1773b.W.f1704d.f1779h.f1761k.add(dependencyNode);
                dependencyNode.f1756f = relativeBegin;
            } else if (relativeEnd != -1) {
                dependencyNode.f1762l.add(this.f1773b.W.f1704d.f1780i);
                this.f1773b.W.f1704d.f1780i.f1761k.add(dependencyNode);
                dependencyNode.f1756f = -relativeEnd;
            } else {
                dependencyNode.f1752b = true;
                dependencyNode.f1762l.add(this.f1773b.W.f1704d.f1780i);
                this.f1773b.W.f1704d.f1780i.f1761k.add(dependencyNode);
            }
            d(this.f1773b.f1704d.f1779h);
            d(this.f1773b.f1704d.f1780i);
            return;
        }
        if (relativeBegin != -1) {
            dependencyNode.f1762l.add(this.f1773b.W.f1706e.f1779h);
            this.f1773b.W.f1706e.f1779h.f1761k.add(dependencyNode);
            dependencyNode.f1756f = relativeBegin;
        } else if (relativeEnd != -1) {
            dependencyNode.f1762l.add(this.f1773b.W.f1706e.f1780i);
            this.f1773b.W.f1706e.f1780i.f1761k.add(dependencyNode);
            dependencyNode.f1756f = -relativeEnd;
        } else {
            dependencyNode.f1752b = true;
            dependencyNode.f1762l.add(this.f1773b.W.f1706e.f1780i);
            this.f1773b.W.f1706e.f1780i.f1761k.add(dependencyNode);
        }
        d(this.f1773b.f1706e.f1779h);
        d(this.f1773b.f1706e.f1780i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int orientation = ((androidx.constraintlayout.core.widgets.f) this.f1773b).getOrientation();
        DependencyNode dependencyNode = this.f1779h;
        if (orientation == 1) {
            this.f1773b.setX(dependencyNode.f1757g);
        } else {
            this.f1773b.setY(dependencyNode.f1757g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void b() {
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
    public void update(d dVar) {
        DependencyNode dependencyNode = this.f1779h;
        if (dependencyNode.f1753c && !dependencyNode.f1760j) {
            DependencyNode dependencyNode2 = (DependencyNode) dependencyNode.f1762l.get(0);
            dependencyNode.resolve((int) ((((androidx.constraintlayout.core.widgets.f) this.f1773b).getRelativePercent() * dependencyNode2.f1757g) + 0.5f));
        }
    }
}
