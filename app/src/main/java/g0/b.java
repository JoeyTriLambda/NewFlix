package g0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import h0.g;
import h0.j;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: HelperWidget.java */
/* loaded from: classes.dex */
public class b extends ConstraintWidget implements a {

    /* renamed from: s0, reason: collision with root package name */
    public ConstraintWidget[] f12501s0 = new ConstraintWidget[4];

    /* renamed from: t0, reason: collision with root package name */
    public int f12502t0 = 0;

    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i10 = this.f12502t0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.f12501s0;
        if (i10 > constraintWidgetArr.length) {
            this.f12501s0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.f12501s0;
        int i11 = this.f12502t0;
        constraintWidgetArr2[i11] = constraintWidget;
        this.f12502t0 = i11 + 1;
    }

    public void addDependents(ArrayList<j> arrayList, int i10, j jVar) {
        for (int i11 = 0; i11 < this.f12502t0; i11++) {
            jVar.add(this.f12501s0[i11]);
        }
        for (int i12 = 0; i12 < this.f12502t0; i12++) {
            g.findDependents(this.f12501s0[i12], i10, arrayList, jVar);
        }
    }

    public int findGroupInDependents(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.f12502t0; i13++) {
            ConstraintWidget constraintWidget = this.f12501s0[i13];
            if (i10 == 0 && (i12 = constraintWidget.f1731q0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = constraintWidget.f1733r0) != -1) {
                return i11;
            }
        }
        return -1;
    }

    public void removeAllIds() {
        this.f12502t0 = 0;
        Arrays.fill(this.f12501s0, (Object) null);
    }

    public void updateConstraints(d dVar) {
    }
}
