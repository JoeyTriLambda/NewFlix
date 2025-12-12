package h0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChainRun.java */
/* loaded from: classes.dex */
public final class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<WidgetRun> f12887k;

    /* renamed from: l, reason: collision with root package name */
    public int f12888l;

    public c(ConstraintWidget constraintWidget, int i10) {
        ConstraintWidget constraintWidget2;
        super(constraintWidget);
        this.f12887k = new ArrayList<>();
        this.f1777f = i10;
        ConstraintWidget constraintWidget3 = this.f1773b;
        ConstraintWidget previousChainMember = constraintWidget3.getPreviousChainMember(i10);
        while (true) {
            ConstraintWidget constraintWidget4 = previousChainMember;
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            if (constraintWidget3 == null) {
                break;
            } else {
                previousChainMember = constraintWidget3.getPreviousChainMember(this.f1777f);
            }
        }
        this.f1773b = constraintWidget2;
        WidgetRun run = constraintWidget2.getRun(this.f1777f);
        ArrayList<WidgetRun> arrayList = this.f12887k;
        arrayList.add(run);
        ConstraintWidget nextChainMember = constraintWidget2.getNextChainMember(this.f1777f);
        while (nextChainMember != null) {
            arrayList.add(nextChainMember.getRun(this.f1777f));
            nextChainMember = nextChainMember.getNextChainMember(this.f1777f);
        }
        Iterator<WidgetRun> it = arrayList.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i11 = this.f1777f;
            if (i11 == 0) {
                next.f1773b.f1700b = this;
            } else if (i11 == 1) {
                next.f1773b.f1702c = this;
            }
        }
        if ((this.f1777f == 0 && ((androidx.constraintlayout.core.widgets.d) this.f1773b.getParent()).isRtl()) && arrayList.size() > 1) {
            this.f1773b = arrayList.get(arrayList.size() - 1).f1773b;
        }
        this.f12888l = this.f1777f == 0 ? this.f1773b.getHorizontalChainStyle() : this.f1773b.getVerticalChainStyle();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void a() {
        ArrayList<WidgetRun> arrayList = this.f12887k;
        Iterator<WidgetRun> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = arrayList.get(0).f1773b;
        ConstraintWidget constraintWidget2 = arrayList.get(size - 1).f1773b;
        int i10 = this.f1777f;
        DependencyNode dependencyNode = this.f1780i;
        DependencyNode dependencyNode2 = this.f1779h;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.K;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.M;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget constraintWidgetD = d();
            if (constraintWidgetD != null) {
                margin = constraintWidgetD.K.getMargin();
            }
            if (target != null) {
                addTarget(dependencyNode2, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget constraintWidgetE = e();
            if (constraintWidgetE != null) {
                margin2 = constraintWidgetE.M.getMargin();
            }
            if (target2 != null) {
                addTarget(dependencyNode, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.L;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.N;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget constraintWidgetD2 = d();
            if (constraintWidgetD2 != null) {
                margin3 = constraintWidgetD2.L.getMargin();
            }
            if (target3 != null) {
                addTarget(dependencyNode2, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget constraintWidgetE2 = e();
            if (constraintWidgetE2 != null) {
                margin4 = constraintWidgetE2.N.getMargin();
            }
            if (target4 != null) {
                addTarget(dependencyNode, target4, -margin4);
            }
        }
        dependencyNode2.f1751a = this;
        dependencyNode.f1751a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int i10 = 0;
        while (true) {
            ArrayList<WidgetRun> arrayList = this.f12887k;
            if (i10 >= arrayList.size()) {
                return;
            }
            arrayList.get(i10).applyToWidget();
            i10++;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void b() {
        this.f1774c = null;
        Iterator<WidgetRun> it = this.f12887k.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean c() {
        ArrayList<WidgetRun> arrayList = this.f12887k;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!arrayList.get(i10).c()) {
                return false;
            }
        }
        return true;
    }

    public final ConstraintWidget d() {
        int i10 = 0;
        while (true) {
            ArrayList<WidgetRun> arrayList = this.f12887k;
            if (i10 >= arrayList.size()) {
                return null;
            }
            WidgetRun widgetRun = arrayList.get(i10);
            if (widgetRun.f1773b.getVisibility() != 8) {
                return widgetRun.f1773b;
            }
            i10++;
        }
    }

    public final ConstraintWidget e() {
        ArrayList<WidgetRun> arrayList = this.f12887k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = arrayList.get(size);
            if (widgetRun.f1773b.getVisibility() != 8) {
                return widgetRun.f1773b;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        ArrayList<WidgetRun> arrayList = this.f12887k;
        int size = arrayList.size();
        long wrapDimension = 0;
        for (int i10 = 0; i10 < size; i10++) {
            wrapDimension = r5.f1780i.f1756f + arrayList.get(i10).getWrapDimension() + wrapDimension + r5.f1779h.f1756f;
        }
        return wrapDimension;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f1777f == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.f12887k.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            sb2.append("<");
            sb2.append(next);
            sb2.append("> ");
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ed  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(h0.d r28) {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.c.update(h0.d):void");
    }
}
