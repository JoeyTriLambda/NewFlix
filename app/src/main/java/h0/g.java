package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Grouping.java */
/* loaded from: classes.dex */
public final class g {
    public static j findDependents(ConstraintWidget constraintWidget, int i10, ArrayList<j> arrayList, j jVar) {
        int iFindGroupInDependents;
        int i11 = i10 == 0 ? constraintWidget.f1731q0 : constraintWidget.f1733r0;
        if (i11 != -1 && (jVar == null || i11 != jVar.f12902b)) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                j jVar2 = arrayList.get(i12);
                if (jVar2.getId() == i11) {
                    if (jVar != null) {
                        jVar.moveTo(i10, jVar2);
                        arrayList.remove(jVar);
                    }
                    jVar = jVar2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return jVar;
        }
        if (jVar == null) {
            if ((constraintWidget instanceof g0.b) && (iFindGroupInDependents = ((g0.b) constraintWidget).findGroupInDependents(i10)) != -1) {
                int i13 = 0;
                while (true) {
                    if (i13 >= arrayList.size()) {
                        break;
                    }
                    j jVar3 = arrayList.get(i13);
                    if (jVar3.getId() == iFindGroupInDependents) {
                        jVar = jVar3;
                        break;
                    }
                    i13++;
                }
            }
            if (jVar == null) {
                jVar = new j(i10);
            }
            arrayList.add(jVar);
        }
        if (jVar.add(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                fVar.getAnchor().findDependents(fVar.getOrientation() == 0 ? 1 : 0, arrayList, jVar);
            }
            if (i10 == 0) {
                constraintWidget.f1731q0 = jVar.getId();
                constraintWidget.K.findDependents(i10, arrayList, jVar);
                constraintWidget.M.findDependents(i10, arrayList, jVar);
            } else {
                constraintWidget.f1733r0 = jVar.getId();
                constraintWidget.L.findDependents(i10, arrayList, jVar);
                constraintWidget.O.findDependents(i10, arrayList, jVar);
                constraintWidget.N.findDependents(i10, arrayList, jVar);
            }
            constraintWidget.R.findDependents(i10, arrayList, jVar);
        }
        return jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x036b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean simpleSolvingPass(androidx.constraintlayout.core.widgets.d r16, h0.b.InterfaceC0158b r17) {
        /*
            Method dump skipped, instructions count: 954
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.g.simpleSolvingPass(androidx.constraintlayout.core.widgets.d, h0.b$b):boolean");
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        return (dimensionBehaviour3 == dimensionBehaviour5 || dimensionBehaviour3 == dimensionBehaviour7 || (dimensionBehaviour3 == dimensionBehaviour6 && dimensionBehaviour != dimensionBehaviour7)) || (dimensionBehaviour4 == dimensionBehaviour5 || dimensionBehaviour4 == dimensionBehaviour7 || (dimensionBehaviour4 == dimensionBehaviour6 && dimensionBehaviour2 != dimensionBehaviour7));
    }
}
