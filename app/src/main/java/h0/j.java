package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: WidgetGroup.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: f, reason: collision with root package name */
    public static int f12900f;

    /* renamed from: b, reason: collision with root package name */
    public final int f12902b;

    /* renamed from: c, reason: collision with root package name */
    public int f12903c;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f12901a = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<a> f12904d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f12905e = -1;

    /* compiled from: WidgetGroup.java */
    public class a {
        public a(j jVar, ConstraintWidget constraintWidget, androidx.constraintlayout.core.c cVar, int i10) {
            new WeakReference(constraintWidget);
            cVar.getObjectVariableValue(constraintWidget.K);
            cVar.getObjectVariableValue(constraintWidget.L);
            cVar.getObjectVariableValue(constraintWidget.M);
            cVar.getObjectVariableValue(constraintWidget.N);
            cVar.getObjectVariableValue(constraintWidget.O);
        }
    }

    public j(int i10) {
        this.f12902b = -1;
        int i11 = f12900f;
        f12900f = i11 + 1;
        this.f12902b = i11;
        this.f12903c = i10;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintWidget> arrayList = this.f12901a;
        if (arrayList.contains(constraintWidget)) {
            return false;
        }
        arrayList.add(constraintWidget);
        return true;
    }

    public void cleanup(ArrayList<j> arrayList) {
        int size = this.f12901a.size();
        if (this.f12905e != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                j jVar = arrayList.get(i10);
                if (this.f12905e == jVar.f12902b) {
                    moveTo(this.f12903c, jVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int getId() {
        return this.f12902b;
    }

    public int getOrientation() {
        return this.f12903c;
    }

    public int measureWrap(androidx.constraintlayout.core.c cVar, int i10) {
        int objectVariableValue;
        int objectVariableValue2;
        ArrayList<ConstraintWidget> arrayList = this.f12901a;
        if (arrayList.size() == 0) {
            return 0;
        }
        androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).getParent();
        cVar.reset();
        dVar.addToSolver(cVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).addToSolver(cVar, false);
        }
        if (i10 == 0 && dVar.B0 > 0) {
            androidx.constraintlayout.core.widgets.b.applyChainConstraints(dVar, cVar, arrayList, 0);
        }
        if (i10 == 1 && dVar.C0 > 0) {
            androidx.constraintlayout.core.widgets.b.applyChainConstraints(dVar, cVar, arrayList, 1);
        }
        try {
            cVar.minimize();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f12904d = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f12904d.add(new a(this, arrayList.get(i12), cVar, i10));
        }
        if (i10 == 0) {
            objectVariableValue = cVar.getObjectVariableValue(dVar.K);
            objectVariableValue2 = cVar.getObjectVariableValue(dVar.M);
            cVar.reset();
        } else {
            objectVariableValue = cVar.getObjectVariableValue(dVar.L);
            objectVariableValue2 = cVar.getObjectVariableValue(dVar.N);
            cVar.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public void moveTo(int i10, j jVar) {
        Iterator<ConstraintWidget> it = this.f12901a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            jVar.add(next);
            if (i10 == 0) {
                next.f1731q0 = jVar.getId();
            } else {
                next.f1733r0 = jVar.getId();
            }
        }
        this.f12905e = jVar.f12902b;
    }

    public void setOrientation(int i10) {
        this.f12903c = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f12903c;
        sb2.append(i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown");
        sb2.append(" [");
        String strM = ac.c.m(sb2, this.f12902b, "] <");
        Iterator<ConstraintWidget> it = this.f12901a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            StringBuilder sbU = ac.c.u(strM, StringUtils.SPACE);
            sbU.append(next.getDebugName());
            strM = sbU.toString();
        }
        return ac.c.B(strM, " >");
    }

    public void setAuthoritative(boolean z10) {
    }
}
