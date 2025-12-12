package g0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: WidgetContainer.java */
/* loaded from: classes.dex */
public class c extends ConstraintWidget {

    /* renamed from: s0, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f12503s0 = new ArrayList<>();

    public void add(ConstraintWidget constraintWidget) {
        this.f12503s0.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((c) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.f12503s0;
    }

    public void layout() {
        ArrayList<ConstraintWidget> arrayList = this.f12503s0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f12503s0.get(i10);
            if (constraintWidget instanceof c) {
                ((c) constraintWidget).layout();
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.f12503s0.remove(constraintWidget);
        constraintWidget.reset();
    }

    public void removeAllChildren() {
        this.f12503s0.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.f12503s0.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void resetSolverVariables(d0.a aVar) {
        super.resetSolverVariables(aVar);
        int size = this.f12503s0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f12503s0.get(i10).resetSolverVariables(aVar);
        }
    }
}
