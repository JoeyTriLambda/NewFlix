package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f1841a = new boolean[3];

    public static void a(d dVar, androidx.constraintlayout.core.c cVar, ConstraintWidget constraintWidget) {
        constraintWidget.f1728p = -1;
        constraintWidget.f1730q = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.V[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.V;
        if (dimensionBehaviour != dimensionBehaviour2 && dimensionBehaviourArr[0] == dimensionBehaviour3) {
            ConstraintAnchor constraintAnchor = constraintWidget.K;
            int i10 = constraintAnchor.f1686g;
            int width = dVar.getWidth();
            ConstraintAnchor constraintAnchor2 = constraintWidget.M;
            int i11 = width - constraintAnchor2.f1686g;
            constraintAnchor.f1688i = cVar.createObjectVariable(constraintAnchor);
            constraintAnchor2.f1688i = cVar.createObjectVariable(constraintAnchor2);
            cVar.addEquality(constraintAnchor.f1688i, i10);
            cVar.addEquality(constraintAnchor2.f1688i, i11);
            constraintWidget.f1728p = 2;
            constraintWidget.setHorizontalDimension(i10, i11);
        }
        if (dVar.V[1] == dimensionBehaviour2 || dimensionBehaviourArr[1] != dimensionBehaviour3) {
            return;
        }
        ConstraintAnchor constraintAnchor3 = constraintWidget.L;
        int i12 = constraintAnchor3.f1686g;
        int height = dVar.getHeight();
        ConstraintAnchor constraintAnchor4 = constraintWidget.N;
        int i13 = height - constraintAnchor4.f1686g;
        constraintAnchor3.f1688i = cVar.createObjectVariable(constraintAnchor3);
        constraintAnchor4.f1688i = cVar.createObjectVariable(constraintAnchor4);
        cVar.addEquality(constraintAnchor3.f1688i, i12);
        cVar.addEquality(constraintAnchor4.f1688i, i13);
        if (constraintWidget.f1705d0 > 0 || constraintWidget.getVisibility() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.O;
            constraintAnchor5.f1688i = cVar.createObjectVariable(constraintAnchor5);
            cVar.addEquality(constraintAnchor5.f1688i, constraintWidget.f1705d0 + i12);
        }
        constraintWidget.f1730q = 2;
        constraintWidget.setVerticalDimension(i12, i13);
    }

    public static final boolean enabled(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
