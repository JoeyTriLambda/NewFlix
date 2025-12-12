package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* compiled from: DimensionDependency.java */
/* loaded from: classes.dex */
public class a extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f1785m;

    public a(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof c) {
            this.f1755e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f1755e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public void resolve(int i10) {
        if (this.f1760j) {
            return;
        }
        this.f1760j = true;
        this.f1757g = i10;
        Iterator it = this.f1761k.iterator();
        while (it.hasNext()) {
            h0.d dVar = (h0.d) it.next();
            dVar.update(dVar);
        }
    }
}
