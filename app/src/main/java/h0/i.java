package h0;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: RunGroup.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final WidgetRun f12898a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<WidgetRun> f12899b = new ArrayList<>();

    public i(WidgetRun widgetRun, int i10) {
        this.f12898a = null;
        this.f12898a = widgetRun;
    }

    public static long a(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f1754d;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j10;
        }
        ArrayList arrayList = dependencyNode.f1761k;
        int size = arrayList.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f1754d != widgetRun) {
                    jMin = Math.min(jMin, a(dependencyNode2, dependencyNode2.f1756f + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f1780i) {
            return jMin;
        }
        long wrapDimension = widgetRun.getWrapDimension();
        long j11 = j10 - wrapDimension;
        return Math.min(Math.min(jMin, a(widgetRun.f1779h, j11)), j11 - r9.f1756f);
    }

    public static long b(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f1754d;
        if (widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.b) {
            return j10;
        }
        ArrayList arrayList = dependencyNode.f1761k;
        int size = arrayList.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) arrayList.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f1754d != widgetRun) {
                    jMax = Math.max(jMax, b(dependencyNode2, dependencyNode2.f1756f + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f1779h) {
            return jMax;
        }
        long wrapDimension = widgetRun.getWrapDimension();
        long j11 = j10 + wrapDimension;
        return Math.max(Math.max(jMax, b(widgetRun.f1780i, j11)), j11 - r9.f1756f);
    }

    public void add(WidgetRun widgetRun) {
        this.f12899b.add(widgetRun);
    }

    public long computeWrapSize(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        long wrapDimension;
        int i11;
        WidgetRun widgetRun = this.f12898a;
        if (widgetRun instanceof c) {
            if (((c) widgetRun).f1777f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.c)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i10 == 0 ? dVar.f1704d : dVar.f1706e).f1779h;
        DependencyNode dependencyNode2 = (i10 == 0 ? dVar.f1704d : dVar.f1706e).f1780i;
        boolean zContains = widgetRun.f1779h.f1762l.contains(dependencyNode);
        DependencyNode dependencyNode3 = widgetRun.f1780i;
        boolean zContains2 = dependencyNode3.f1762l.contains(dependencyNode2);
        long wrapDimension2 = widgetRun.getWrapDimension();
        DependencyNode dependencyNode4 = widgetRun.f1779h;
        if (zContains && zContains2) {
            long jB = b(dependencyNode4, 0L);
            long jA = a(dependencyNode3, 0L);
            long j10 = jB - wrapDimension2;
            int i12 = dependencyNode3.f1756f;
            if (j10 >= (-i12)) {
                j10 += i12;
            }
            long j11 = dependencyNode4.f1756f;
            long j12 = ((-jA) - wrapDimension2) - j11;
            if (j12 >= j11) {
                j12 -= j11;
            }
            float biasPercent = widgetRun.f1773b.getBiasPercent(i10);
            float f10 = biasPercent > 0.0f ? (long) ((j10 / (1.0f - biasPercent)) + (j12 / biasPercent)) : 0L;
            wrapDimension = dependencyNode4.f1756f + ((long) ((f10 * biasPercent) + 0.5f)) + wrapDimension2 + ((long) o1.a.a(1.0f, biasPercent, f10, 0.5f));
            i11 = dependencyNode3.f1756f;
        } else {
            if (zContains) {
                return Math.max(b(dependencyNode4, dependencyNode4.f1756f), dependencyNode4.f1756f + wrapDimension2);
            }
            if (zContains2) {
                return Math.max(-a(dependencyNode3, dependencyNode3.f1756f), (-dependencyNode3.f1756f) + wrapDimension2);
            }
            wrapDimension = dependencyNode4.f1756f + widgetRun.getWrapDimension();
            i11 = dependencyNode3.f1756f;
        }
        return wrapDimension - i11;
    }
}
