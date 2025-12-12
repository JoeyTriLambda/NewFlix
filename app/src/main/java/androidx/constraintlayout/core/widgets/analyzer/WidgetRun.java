package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import h0.i;

/* loaded from: classes.dex */
public abstract class WidgetRun implements h0.d {

    /* renamed from: a, reason: collision with root package name */
    public int f1772a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f1773b;

    /* renamed from: c, reason: collision with root package name */
    public i f1774c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f1775d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1776e = new a(this);

    /* renamed from: f, reason: collision with root package name */
    public int f1777f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1778g = false;

    /* renamed from: h, reason: collision with root package name */
    public final DependencyNode f1779h = new DependencyNode(this);

    /* renamed from: i, reason: collision with root package name */
    public final DependencyNode f1780i = new DependencyNode(this);

    /* renamed from: j, reason: collision with root package name */
    public RunType f1781j = RunType.NONE;

    public enum RunType {
        NONE,
        /* JADX INFO: Fake field, exist only in values array */
        START,
        /* JADX INFO: Fake field, exist only in values array */
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f1773b = constraintWidget;
    }

    public abstract void a();

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.f1762l.add(dependencyNode2);
        dependencyNode.f1756f = i10;
        dependencyNode2.f1761k.add(dependencyNode);
    }

    public abstract void applyToWidget();

    public abstract void b();

    public abstract boolean c();

    public final int getLimitedDimension(int i10, int i11) {
        int iMax;
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f1773b;
            int i12 = constraintWidget.f1738w;
            iMax = Math.max(constraintWidget.f1737v, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f1773b;
            int i13 = constraintWidget2.f1741z;
            iMax = Math.max(constraintWidget2.f1740y, i10);
            if (i13 > 0) {
                iMax = Math.min(i13, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        }
        return iMax;
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1685f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1683d;
        int iOrdinal = constraintAnchor2.f1684e.ordinal();
        if (iOrdinal == 1) {
            return constraintWidget.f1704d.f1779h;
        }
        if (iOrdinal == 2) {
            return constraintWidget.f1706e.f1779h;
        }
        if (iOrdinal == 3) {
            return constraintWidget.f1704d.f1780i;
        }
        if (iOrdinal == 4) {
            return constraintWidget.f1706e.f1780i;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return constraintWidget.f1706e.f1787k;
    }

    public long getWrapDimension() {
        if (this.f1776e.f1760j) {
            return r0.f1757g;
        }
        return 0L;
    }

    public boolean isResolved() {
        return this.f1778g;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateRunCenter(h0.d r12, androidx.constraintlayout.core.widgets.ConstraintAnchor r13, androidx.constraintlayout.core.widgets.ConstraintAnchor r14, int r15) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.updateRunCenter(h0.d, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int):void");
    }

    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, a aVar) {
        dependencyNode.f1762l.add(dependencyNode2);
        dependencyNode.f1762l.add(this.f1776e);
        dependencyNode.f1758h = i10;
        dependencyNode.f1759i = aVar;
        dependencyNode2.f1761k.add(dependencyNode);
        aVar.f1761k.add(dependencyNode);
    }

    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i10) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1685f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1683d;
        WidgetRun widgetRun = i10 == 0 ? constraintWidget.f1704d : constraintWidget.f1706e;
        int iOrdinal = constraintAnchor2.f1684e.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            return widgetRun.f1779h;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return widgetRun.f1780i;
        }
        return null;
    }

    @Override // h0.d
    public void update(h0.d dVar) {
    }

    public void updateRunEnd(h0.d dVar) {
    }

    public void updateRunStart(h0.d dVar) {
    }
}
