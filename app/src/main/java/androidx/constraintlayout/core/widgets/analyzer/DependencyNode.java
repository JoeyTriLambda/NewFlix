package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DependencyNode implements h0.d {

    /* renamed from: d, reason: collision with root package name */
    public final WidgetRun f1754d;

    /* renamed from: f, reason: collision with root package name */
    public int f1756f;

    /* renamed from: g, reason: collision with root package name */
    public int f1757g;

    /* renamed from: a, reason: collision with root package name */
    public WidgetRun f1751a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1752b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1753c = false;

    /* renamed from: e, reason: collision with root package name */
    public Type f1755e = Type.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public int f1758h = 1;

    /* renamed from: i, reason: collision with root package name */
    public a f1759i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1760j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1761k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1762l = new ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f1754d = widgetRun;
    }

    public void addDependency(h0.d dVar) {
        this.f1761k.add(dVar);
        if (this.f1760j) {
            dVar.update(dVar);
        }
    }

    public void clear() {
        this.f1762l.clear();
        this.f1761k.clear();
        this.f1760j = false;
        this.f1757g = 0;
        this.f1753c = false;
        this.f1752b = false;
    }

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

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1754d.f1773b.getDebugName());
        sb2.append(":");
        sb2.append(this.f1755e);
        sb2.append("(");
        sb2.append(this.f1760j ? Integer.valueOf(this.f1757g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f1762l.size());
        sb2.append(":d=");
        sb2.append(this.f1761k.size());
        sb2.append(">");
        return sb2.toString();
    }

    @Override // h0.d
    public void update(h0.d dVar) {
        ArrayList arrayList = this.f1762l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).f1760j) {
                return;
            }
        }
        this.f1753c = true;
        WidgetRun widgetRun = this.f1751a;
        if (widgetRun != null) {
            widgetRun.update(this);
        }
        if (this.f1752b) {
            this.f1754d.update(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        DependencyNode dependencyNode = null;
        int i10 = 0;
        while (it2.hasNext()) {
            DependencyNode dependencyNode2 = (DependencyNode) it2.next();
            if (!(dependencyNode2 instanceof a)) {
                i10++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i10 == 1 && dependencyNode.f1760j) {
            a aVar = this.f1759i;
            if (aVar != null) {
                if (!aVar.f1760j) {
                    return;
                } else {
                    this.f1756f = this.f1758h * aVar.f1757g;
                }
            }
            resolve(dependencyNode.f1757g + this.f1756f);
        }
        WidgetRun widgetRun2 = this.f1751a;
        if (widgetRun2 != null) {
            widgetRun2.update(this);
        }
    }
}
