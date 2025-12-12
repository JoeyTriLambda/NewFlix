package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* compiled from: BasicMeasure.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f12874a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final a f12875b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final androidx.constraintlayout.core.widgets.d f12876c;

    /* compiled from: BasicMeasure.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f12877a;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f12878b;

        /* renamed from: c, reason: collision with root package name */
        public int f12879c;

        /* renamed from: d, reason: collision with root package name */
        public int f12880d;

        /* renamed from: e, reason: collision with root package name */
        public int f12881e;

        /* renamed from: f, reason: collision with root package name */
        public int f12882f;

        /* renamed from: g, reason: collision with root package name */
        public int f12883g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f12884h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f12885i;

        /* renamed from: j, reason: collision with root package name */
        public int f12886j;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: h0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0158b {
    }

    public b(androidx.constraintlayout.core.widgets.d dVar) {
        this.f12876c = dVar;
    }

    public final boolean a(int i10, ConstraintWidget constraintWidget, InterfaceC0158b interfaceC0158b) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        a aVar = this.f12875b;
        aVar.f12877a = horizontalDimensionBehaviour;
        aVar.f12878b = constraintWidget.getVerticalDimensionBehaviour();
        aVar.f12879c = constraintWidget.getWidth();
        aVar.f12880d = constraintWidget.getHeight();
        aVar.f12885i = false;
        aVar.f12886j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f12877a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f12878b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.Z > 0.0f;
        boolean z13 = z11 && constraintWidget.Z > 0.0f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int[] iArr = constraintWidget.f1736u;
        if (z12 && iArr[0] == 4) {
            aVar.f12877a = dimensionBehaviour3;
        }
        if (z13 && iArr[1] == 4) {
            aVar.f12878b = dimensionBehaviour3;
        }
        ((ConstraintLayout.b) interfaceC0158b).measure(constraintWidget, aVar);
        constraintWidget.setWidth(aVar.f12881e);
        constraintWidget.setHeight(aVar.f12882f);
        constraintWidget.setHasBaseline(aVar.f12884h);
        constraintWidget.setBaselineDistance(aVar.f12883g);
        aVar.f12886j = 0;
        return aVar.f12885i;
    }

    public final void b(androidx.constraintlayout.core.widgets.d dVar, int i10, int i11, int i12) {
        int minWidth = dVar.getMinWidth();
        int minHeight = dVar.getMinHeight();
        dVar.setMinWidth(0);
        dVar.setMinHeight(0);
        dVar.setWidth(i11);
        dVar.setHeight(i12);
        dVar.setMinWidth(minWidth);
        dVar.setMinHeight(minHeight);
        androidx.constraintlayout.core.widgets.d dVar2 = this.f12876c;
        dVar2.setPass(i10);
        dVar2.layout();
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01a9 A[PHI: r9
  0x01a9: PHI (r9v23 boolean) = (r9v22 boolean), (r9v22 boolean), (r9v22 boolean), (r9v26 boolean) binds: [B:115:0x0172, B:117:0x0178, B:119:0x017c, B:135:0x019e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x01b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long solverMeasure(androidx.constraintlayout.core.widgets.d r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.b.solverMeasure(androidx.constraintlayout.core.widgets.d, int, int, int, int, int, int, int, int, int):long");
    }

    public void updateHierarchy(androidx.constraintlayout.core.widgets.d dVar) {
        ArrayList<ConstraintWidget> arrayList = this.f12874a;
        arrayList.clear();
        int size = dVar.f12503s0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f12503s0.get(i10);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                arrayList.add(constraintWidget);
            }
        }
        dVar.invalidateGraph();
    }
}
