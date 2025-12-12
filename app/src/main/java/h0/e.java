package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DependencyGraph.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.constraintlayout.core.widgets.d f12889a;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.constraintlayout.core.widgets.d f12892d;

    /* renamed from: f, reason: collision with root package name */
    public b.InterfaceC0158b f12894f;

    /* renamed from: g, reason: collision with root package name */
    public final b.a f12895g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<i> f12896h;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12890b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12891c = true;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<WidgetRun> f12893e = new ArrayList<>();

    public e(androidx.constraintlayout.core.widgets.d dVar) {
        new ArrayList();
        this.f12894f = null;
        this.f12895g = new b.a();
        this.f12896h = new ArrayList<>();
        this.f12889a = dVar;
        this.f12892d = dVar;
    }

    public final void a(DependencyNode dependencyNode, int i10, int i11, ArrayList arrayList, i iVar) {
        WidgetRun widgetRun = dependencyNode.f1754d;
        if (widgetRun.f1774c == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f12889a;
            if (widgetRun == dVar.f1704d || widgetRun == dVar.f1706e) {
                return;
            }
            if (iVar == null) {
                iVar = new i(widgetRun, i11);
                arrayList.add(iVar);
            }
            widgetRun.f1774c = iVar;
            iVar.add(widgetRun);
            DependencyNode dependencyNode2 = widgetRun.f1779h;
            Iterator it = dependencyNode2.f1761k.iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                if (dVar2 instanceof DependencyNode) {
                    a((DependencyNode) dVar2, i10, 0, arrayList, iVar);
                }
            }
            DependencyNode dependencyNode3 = widgetRun.f1780i;
            Iterator it2 = dependencyNode3.f1761k.iterator();
            while (it2.hasNext()) {
                d dVar3 = (d) it2.next();
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, 1, arrayList, iVar);
                }
            }
            if (i10 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                Iterator it3 = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f1787k.f1761k.iterator();
                while (it3.hasNext()) {
                    d dVar4 = (d) it3.next();
                    if (dVar4 instanceof DependencyNode) {
                        a((DependencyNode) dVar4, i10, 2, arrayList, iVar);
                    }
                }
            }
            Iterator it4 = dependencyNode2.f1762l.iterator();
            while (it4.hasNext()) {
                a((DependencyNode) it4.next(), i10, 0, arrayList, iVar);
            }
            Iterator it5 = dependencyNode3.f1762l.iterator();
            while (it5.hasNext()) {
                a((DependencyNode) it5.next(), i10, 1, arrayList, iVar);
            }
            if (i10 == 1 && (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                Iterator it6 = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f1787k.f1762l.iterator();
                while (it6.hasNext()) {
                    a((DependencyNode) it6.next(), i10, 2, arrayList, iVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0263 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0266 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(androidx.constraintlayout.core.widgets.d r17) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.e.b(androidx.constraintlayout.core.widgets.d):void");
    }

    public void buildGraph() {
        buildGraph(this.f12893e);
        ArrayList<i> arrayList = this.f12896h;
        arrayList.clear();
        androidx.constraintlayout.core.widgets.d dVar = this.f12889a;
        d(dVar.f1704d, 0, arrayList);
        d(dVar.f1706e, 1, arrayList);
        this.f12890b = false;
    }

    public final int c(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        ArrayList<i> arrayList = this.f12896h;
        int size = arrayList.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jMax = Math.max(jMax, arrayList.get(i11).computeWrapSize(dVar, i10));
        }
        return (int) jMax;
    }

    public final void d(WidgetRun widgetRun, int i10, ArrayList<i> arrayList) {
        DependencyNode dependencyNode;
        Iterator it = widgetRun.f1779h.f1761k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            dependencyNode = widgetRun.f1780i;
            if (!zHasNext) {
                break;
            }
            d dVar = (d) it.next();
            if (dVar instanceof DependencyNode) {
                a((DependencyNode) dVar, i10, 0, arrayList, null);
            } else if (dVar instanceof WidgetRun) {
                a(((WidgetRun) dVar).f1779h, i10, 0, arrayList, null);
            }
        }
        Iterator it2 = dependencyNode.f1761k.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2 instanceof DependencyNode) {
                a((DependencyNode) dVar2, i10, 1, arrayList, null);
            } else if (dVar2 instanceof WidgetRun) {
                a(((WidgetRun) dVar2).f1780i, i10, 1, arrayList, null);
            }
        }
        if (i10 == 1) {
            Iterator it3 = ((androidx.constraintlayout.core.widgets.analyzer.d) widgetRun).f1787k.f1761k.iterator();
            while (it3.hasNext()) {
                d dVar3 = (d) it3.next();
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, 2, arrayList, null);
                }
            }
        }
    }

    public boolean directMeasure(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        boolean z14 = this.f12890b;
        androidx.constraintlayout.core.widgets.d dVar = this.f12889a;
        if (z14 || this.f12891c) {
            Iterator<ConstraintWidget> it = dVar.f12503s0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.f1698a = false;
                next.f1704d.e();
                next.f1706e.d();
            }
            dVar.ensureWidgetRuns();
            dVar.f1698a = false;
            dVar.f1704d.e();
            dVar.f1706e.d();
            this.f12891c = false;
        }
        b(this.f12892d);
        dVar.setX(0);
        dVar.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar.getDimensionBehaviour(1);
        if (this.f12890b) {
            buildGraph();
        }
        int x10 = dVar.getX();
        int y10 = dVar.getY();
        dVar.f1704d.f1779h.resolve(x10);
        dVar.f1706e.f1779h.resolve(y10);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        ArrayList<WidgetRun> arrayList = this.f12893e;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z13) {
                Iterator<WidgetRun> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().c()) {
                        z13 = false;
                        break;
                    }
                }
            }
            if (z13 && dimensionBehaviour == dimensionBehaviour3) {
                dVar.setHorizontalDimensionBehaviour(dimensionBehaviour4);
                dVar.setWidth(c(dVar, 0));
                dVar.f1704d.f1776e.resolve(dVar.getWidth());
            }
            if (z13 && dimensionBehaviour2 == dimensionBehaviour3) {
                dVar.setVerticalDimensionBehaviour(dimensionBehaviour4);
                dVar.setHeight(c(dVar, 1));
                dVar.f1706e.f1776e.resolve(dVar.getHeight());
            }
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dVar.V;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (dimensionBehaviour5 == dimensionBehaviour4 || dimensionBehaviour5 == dimensionBehaviour6) {
            int width = dVar.getWidth() + x10;
            dVar.f1704d.f1780i.resolve(width);
            dVar.f1704d.f1776e.resolve(width - x10);
            measureWidgets();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[1];
            if (dimensionBehaviour7 == dimensionBehaviour4 || dimensionBehaviour7 == dimensionBehaviour6) {
                int height = dVar.getHeight() + y10;
                dVar.f1706e.f1780i.resolve(height);
                dVar.f1706e.f1776e.resolve(height - y10);
            }
            measureWidgets();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f1773b != dVar || next2.f1778g) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            WidgetRun next3 = it4.next();
            if (z11 || next3.f1773b != dVar) {
                if (!next3.f1779h.f1760j || ((!next3.f1780i.f1760j && !(next3 instanceof h)) || (!next3.f1776e.f1760j && !(next3 instanceof c) && !(next3 instanceof h)))) {
                    z12 = false;
                    break;
                }
            }
        }
        dVar.setHorizontalDimensionBehaviour(dimensionBehaviour);
        dVar.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z12;
    }

    public boolean directMeasureSetup(boolean z10) {
        boolean z11 = this.f12890b;
        androidx.constraintlayout.core.widgets.d dVar = this.f12889a;
        if (z11) {
            Iterator<ConstraintWidget> it = dVar.f12503s0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.f1698a = false;
                androidx.constraintlayout.core.widgets.analyzer.c cVar = next.f1704d;
                cVar.f1776e.f1760j = false;
                cVar.f1778g = false;
                cVar.e();
                androidx.constraintlayout.core.widgets.analyzer.d dVar2 = next.f1706e;
                dVar2.f1776e.f1760j = false;
                dVar2.f1778g = false;
                dVar2.d();
            }
            dVar.ensureWidgetRuns();
            dVar.f1698a = false;
            androidx.constraintlayout.core.widgets.analyzer.c cVar2 = dVar.f1704d;
            cVar2.f1776e.f1760j = false;
            cVar2.f1778g = false;
            cVar2.e();
            androidx.constraintlayout.core.widgets.analyzer.d dVar3 = dVar.f1706e;
            dVar3.f1776e.f1760j = false;
            dVar3.f1778g = false;
            dVar3.d();
            buildGraph();
        }
        b(this.f12892d);
        dVar.setX(0);
        dVar.setY(0);
        dVar.f1704d.f1779h.resolve(0);
        dVar.f1706e.f1779h.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z10, int i10) {
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z12 = true;
        boolean z13 = z10 & true;
        androidx.constraintlayout.core.widgets.d dVar = this.f12889a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dVar.getDimensionBehaviour(1);
        int x10 = dVar.getX();
        int y10 = dVar.getY();
        ArrayList<WidgetRun> arrayList = this.f12893e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (z13 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.f1777f == i10 && !next.c()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && dimensionBehaviour2 == dimensionBehaviour) {
                    dVar.setHorizontalDimensionBehaviour(dimensionBehaviour4);
                    dVar.setWidth(c(dVar, 0));
                    dVar.f1704d.f1776e.resolve(dVar.getWidth());
                }
            } else if (z13 && dimensionBehaviour3 == dimensionBehaviour) {
                dVar.setVerticalDimensionBehaviour(dimensionBehaviour4);
                dVar.setHeight(c(dVar, 1));
                dVar.f1706e.f1776e.resolve(dVar.getHeight());
            }
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (i10 == 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dVar.V[0];
            if (dimensionBehaviour6 == dimensionBehaviour4 || dimensionBehaviour6 == dimensionBehaviour5) {
                int width = dVar.getWidth() + x10;
                dVar.f1704d.f1780i.resolve(width);
                dVar.f1704d.f1776e.resolve(width - x10);
                z11 = true;
            }
            z11 = false;
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dVar.V[1];
            if (dimensionBehaviour7 == dimensionBehaviour4 || dimensionBehaviour7 == dimensionBehaviour5) {
                int height = dVar.getHeight() + y10;
                dVar.f1706e.f1780i.resolve(height);
                dVar.f1706e.f1776e.resolve(height - y10);
                z11 = true;
            }
            z11 = false;
        }
        measureWidgets();
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.f1777f == i10 && (next2.f1773b != dVar || next2.f1778g)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next3 = it3.next();
            if (next3.f1777f == i10 && (z11 || next3.f1773b != dVar)) {
                if (!next3.f1779h.f1760j || !next3.f1780i.f1760j || (!(next3 instanceof c) && !next3.f1776e.f1760j)) {
                    z12 = false;
                    break;
                }
            }
        }
        dVar.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        dVar.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z12;
    }

    public final void e(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        b.a aVar = this.f12895g;
        aVar.f12877a = dimensionBehaviour;
        aVar.f12878b = dimensionBehaviour2;
        aVar.f12879c = i10;
        aVar.f12880d = i11;
        ((ConstraintLayout.b) this.f12894f).measure(constraintWidget, aVar);
        constraintWidget.setWidth(aVar.f12881e);
        constraintWidget.setHeight(aVar.f12882f);
        constraintWidget.setHasBaseline(aVar.f12884h);
        constraintWidget.setBaselineDistance(aVar.f12883g);
    }

    public void invalidateGraph() {
        this.f12890b = true;
    }

    public void invalidateMeasures() {
        this.f12891c = true;
    }

    public void measureWidgets() {
        a aVar;
        Iterator<ConstraintWidget> it = this.f12889a.f12503s0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f1698a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.V;
                boolean z10 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i10 = next.f1734s;
                int i11 = next.f1735t;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z11 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == dimensionBehaviour4 && i10 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == dimensionBehaviour4 && i11 == 1)) {
                    z10 = true;
                }
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = next.f1704d.f1776e;
                boolean z12 = aVar2.f1760j;
                androidx.constraintlayout.core.widgets.analyzer.a aVar3 = next.f1706e.f1776e;
                boolean z13 = aVar3.f1760j;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (z12 && z13) {
                    e(next, dimensionBehaviour5, aVar2.f1757g, dimensionBehaviour5, aVar3.f1757g);
                    next.f1698a = true;
                } else if (z12 && z10) {
                    e(next, dimensionBehaviour5, aVar2.f1757g, dimensionBehaviour3, aVar3.f1757g);
                    if (dimensionBehaviour2 == dimensionBehaviour4) {
                        next.f1706e.f1776e.f1785m = next.getHeight();
                    } else {
                        next.f1706e.f1776e.resolve(next.getHeight());
                        next.f1698a = true;
                    }
                } else if (z13 && z11) {
                    e(next, dimensionBehaviour3, aVar2.f1757g, dimensionBehaviour5, aVar3.f1757g);
                    if (dimensionBehaviour == dimensionBehaviour4) {
                        next.f1704d.f1776e.f1785m = next.getWidth();
                    } else {
                        next.f1704d.f1776e.resolve(next.getWidth());
                        next.f1698a = true;
                    }
                }
                if (next.f1698a && (aVar = next.f1706e.f1788l) != null) {
                    aVar.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(b.InterfaceC0158b interfaceC0158b) {
        this.f12894f = interfaceC0158b;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        androidx.constraintlayout.core.widgets.d dVar = this.f12892d;
        dVar.f1704d.b();
        dVar.f1706e.b();
        arrayList.add(dVar.f1704d);
        arrayList.add(dVar.f1706e);
        Iterator<ConstraintWidget> it = dVar.f12503s0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof androidx.constraintlayout.core.widgets.f) {
                arrayList.add(new h(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.f1700b == null) {
                        next.f1700b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1700b);
                } else {
                    arrayList.add(next.f1704d);
                }
                if (next.isInVerticalChain()) {
                    if (next.f1702c == null) {
                        next.f1702c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1702c);
                } else {
                    arrayList.add(next.f1706e);
                }
                if (next instanceof g0.b) {
                    arrayList.add(new androidx.constraintlayout.core.widgets.analyzer.b(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f1773b != dVar) {
                next2.a();
            }
        }
    }
}
