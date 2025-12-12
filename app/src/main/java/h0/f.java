package h0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import h0.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Direct.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a f12897a = new b.a();

    public static boolean a(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        androidx.constraintlayout.core.widgets.d dVar = constraintWidget.getParent() != null ? (androidx.constraintlayout.core.widgets.d) constraintWidget.getParent() : null;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dVar != null) {
            dVar.getHorizontalDimensionBehaviour();
        }
        if (dVar != null) {
            dVar.getVerticalDimensionBehaviour();
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z10 = horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.isResolvedHorizontally() || horizontalDimensionBehaviour == dimensionBehaviour3 || (horizontalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.f1734s == 0 && constraintWidget.Z == 0.0f && constraintWidget.hasDanglingDimension(0)) || (horizontalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.f1734s == 1 && constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth()));
        boolean z11 = verticalDimensionBehaviour == dimensionBehaviour || constraintWidget.isResolvedVertically() || verticalDimensionBehaviour == dimensionBehaviour3 || (verticalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.f1735t == 0 && constraintWidget.Z == 0.0f && constraintWidget.hasDanglingDimension(1)) || (verticalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.f1735t == 1 && constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight()));
        if (constraintWidget.Z <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    public static void b(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b, boolean z10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isHorizontalSolvingPassDone()) {
            return;
        }
        int i11 = 0;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.isMeasureRequested()) {
            int i12 = i10 + 1;
            if (a(constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.measure(i12, constraintWidget, interfaceC0158b, new b.a(), 0);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        HashSet<ConstraintAnchor> dependents = anchor.getDependents();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dependents != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f1683d;
                int i13 = i10 + 1;
                boolean zA = a(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && zA) {
                    androidx.constraintlayout.core.widgets.d.measure(i13, constraintWidget2, interfaceC0158b, new b.a(), i11);
                }
                ConstraintAnchor constraintAnchor5 = constraintWidget2.K;
                ConstraintAnchor constraintAnchor6 = constraintWidget2.M;
                boolean z11 = (next == constraintAnchor5 && (constraintAnchor4 = constraintAnchor6.f1685f) != null && constraintAnchor4.hasFinalValue()) || (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor5.f1685f) != null && constraintAnchor3.hasFinalValue());
                if (constraintWidget2.getHorizontalDimensionBehaviour() != dimensionBehaviour || zA) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        if (next == constraintAnchor5 && constraintAnchor6.f1685f == null) {
                            int margin = constraintAnchor5.getMargin() + finalValue;
                            constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                            b(i13, constraintWidget2, interfaceC0158b, z10);
                        } else if (next == constraintAnchor6 && constraintAnchor5.f1685f == null) {
                            int margin2 = finalValue - constraintAnchor6.getMargin();
                            constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                            b(i13, constraintWidget2, interfaceC0158b, z10);
                        } else if (z11 && !constraintWidget2.isInHorizontalChain()) {
                            c(i13, constraintWidget2, interfaceC0158b, z10);
                        }
                    }
                } else if (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.f1738w >= 0 && constraintWidget2.f1737v >= 0 && ((constraintWidget2.getVisibility() == 8 || (constraintWidget2.f1734s == 0 && constraintWidget2.getDimensionRatio() == 0.0f)) && !constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout() && z11 && !constraintWidget2.isInHorizontalChain())) {
                    d(i13, constraintWidget, interfaceC0158b, constraintWidget2, z10);
                }
                i11 = 0;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f1683d;
                int i14 = i10 + 1;
                boolean zA2 = a(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && zA2) {
                    androidx.constraintlayout.core.widgets.d.measure(i14, constraintWidget3, interfaceC0158b, new b.a(), 0);
                }
                ConstraintAnchor constraintAnchor7 = constraintWidget3.K;
                ConstraintAnchor constraintAnchor8 = constraintWidget3.M;
                boolean z12 = (next2 == constraintAnchor7 && (constraintAnchor2 = constraintAnchor8.f1685f) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintAnchor8 && (constraintAnchor = constraintAnchor7.f1685f) != null && constraintAnchor.hasFinalValue());
                if (constraintWidget3.getHorizontalDimensionBehaviour() != dimensionBehaviour || zA2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        if (next2 == constraintAnchor7 && constraintAnchor8.f1685f == null) {
                            int margin3 = constraintAnchor7.getMargin() + finalValue2;
                            constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                            b(i14, constraintWidget3, interfaceC0158b, z10);
                        } else if (next2 == constraintAnchor8 && constraintAnchor7.f1685f == null) {
                            int margin4 = finalValue2 - constraintAnchor8.getMargin();
                            constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                            b(i14, constraintWidget3, interfaceC0158b, z10);
                        } else if (z12 && !constraintWidget3.isInHorizontalChain()) {
                            c(i14, constraintWidget3, interfaceC0158b, z10);
                        }
                    }
                } else if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget3.f1738w >= 0 && constraintWidget3.f1737v >= 0) {
                    if (constraintWidget3.getVisibility() != 8) {
                        if (constraintWidget3.f1734s == 0) {
                            if (constraintWidget3.getDimensionRatio() == 0.0f) {
                            }
                        }
                    }
                    if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z12 && !constraintWidget3.isInHorizontalChain()) {
                        d(i14, constraintWidget, interfaceC0158b, constraintWidget3, z10);
                    }
                }
            }
        }
        constraintWidget.markHorizontalSolvingPassDone();
    }

    public static void c(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b, boolean z10) {
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget.K;
        int finalValue = constraintAnchor.f1685f.getFinalValue();
        ConstraintAnchor constraintAnchor2 = constraintWidget.M;
        int finalValue2 = constraintAnchor2.f1685f.getFinalValue();
        int margin = constraintAnchor.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintAnchor2.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i11 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i11 = (finalValue - finalValue2) - width;
        }
        int i12 = ((int) (i11 > 0 ? (horizontalBiasPercent * i11) + 0.5f : horizontalBiasPercent * i11)) + finalValue;
        int i13 = i12 + width;
        if (finalValue > finalValue2) {
            i13 = i12 - width;
        }
        constraintWidget.setFinalHorizontal(i12, i13);
        b(i10 + 1, constraintWidget, interfaceC0158b, z10);
    }

    public static void d(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b, ConstraintWidget constraintWidget2, boolean z10) {
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget2.K;
        int margin = constraintAnchor.getMargin() + constraintAnchor.f1685f.getFinalValue();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.M;
        int finalValue = constraintAnchor2.f1685f.getFinalValue() - constraintAnchor2.getMargin();
        if (finalValue >= margin) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i11 = constraintWidget2.f1734s;
                if (i11 == 2) {
                    width = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.getWidth() : constraintWidget.getParent().getWidth()));
                } else if (i11 == 0) {
                    width = finalValue - margin;
                }
                width = Math.max(constraintWidget2.f1737v, width);
                int i12 = constraintWidget2.f1738w;
                if (i12 > 0) {
                    width = Math.min(i12, width);
                }
            }
            int i13 = margin + ((int) ((horizontalBiasPercent * ((finalValue - margin) - width)) + 0.5f));
            constraintWidget2.setFinalHorizontal(i13, width + i13);
            b(i10 + 1, constraintWidget2, interfaceC0158b, z10);
        }
    }

    public static void e(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b) {
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget.L;
        int finalValue = constraintAnchor.f1685f.getFinalValue();
        ConstraintAnchor constraintAnchor2 = constraintWidget.N;
        int finalValue2 = constraintAnchor2.f1685f.getFinalValue();
        int margin = constraintAnchor.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintAnchor2.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i11 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i11 = (finalValue - finalValue2) - height;
        }
        int i12 = (int) (i11 > 0 ? (verticalBiasPercent * i11) + 0.5f : verticalBiasPercent * i11);
        int i13 = finalValue + i12;
        int i14 = i13 + height;
        if (finalValue > finalValue2) {
            i13 = finalValue - i12;
            i14 = i13 - height;
        }
        constraintWidget.setFinalVertical(i13, i14);
        g(i10 + 1, constraintWidget, interfaceC0158b);
    }

    public static void f(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b, ConstraintWidget constraintWidget2) {
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        ConstraintAnchor constraintAnchor = constraintWidget2.L;
        int margin = constraintAnchor.getMargin() + constraintAnchor.f1685f.getFinalValue();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.N;
        int finalValue = constraintAnchor2.f1685f.getFinalValue() - constraintAnchor2.getMargin();
        if (finalValue >= margin) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i11 = constraintWidget2.f1735t;
                if (i11 == 2) {
                    height = (int) (verticalBiasPercent * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.getHeight() : constraintWidget.getParent().getHeight()));
                } else if (i11 == 0) {
                    height = finalValue - margin;
                }
                height = Math.max(constraintWidget2.f1740y, height);
                int i12 = constraintWidget2.f1741z;
                if (i12 > 0) {
                    height = Math.min(i12, height);
                }
            }
            int i13 = margin + ((int) ((verticalBiasPercent * ((finalValue - margin) - height)) + 0.5f));
            constraintWidget2.setFinalVertical(i13, height + i13);
            g(i10 + 1, constraintWidget2, interfaceC0158b);
        }
    }

    public static void g(int i10, ConstraintWidget constraintWidget, b.InterfaceC0158b interfaceC0158b) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isVerticalSolvingPassDone()) {
            return;
        }
        int i11 = 0;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.isMeasureRequested()) {
            int i12 = i10 + 1;
            if (a(constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.measure(i12, constraintWidget, interfaceC0158b, new b.a(), 0);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        HashSet<ConstraintAnchor> dependents = anchor.getDependents();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dependents != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f1683d;
                int i13 = i10 + 1;
                boolean zA = a(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && zA) {
                    androidx.constraintlayout.core.widgets.d.measure(i13, constraintWidget2, interfaceC0158b, new b.a(), i11);
                }
                ConstraintAnchor constraintAnchor5 = constraintWidget2.L;
                ConstraintAnchor constraintAnchor6 = constraintWidget2.N;
                boolean z10 = (next == constraintAnchor5 && (constraintAnchor4 = constraintAnchor6.f1685f) != null && constraintAnchor4.hasFinalValue()) || (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor5.f1685f) != null && constraintAnchor3.hasFinalValue());
                if (constraintWidget2.getVerticalDimensionBehaviour() != dimensionBehaviour || zA) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        if (next == constraintAnchor5 && constraintAnchor6.f1685f == null) {
                            int margin = constraintAnchor5.getMargin() + finalValue;
                            constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                            g(i13, constraintWidget2, interfaceC0158b);
                        } else if (next == constraintAnchor6 && constraintAnchor5.f1685f == null) {
                            int margin2 = finalValue - constraintAnchor6.getMargin();
                            constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                            g(i13, constraintWidget2, interfaceC0158b);
                        } else if (z10 && !constraintWidget2.isInVerticalChain()) {
                            e(i13, constraintWidget2, interfaceC0158b);
                        }
                    }
                } else if (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.f1741z >= 0 && constraintWidget2.f1740y >= 0 && ((constraintWidget2.getVisibility() == 8 || (constraintWidget2.f1735t == 0 && constraintWidget2.getDimensionRatio() == 0.0f)) && !constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout() && z10 && !constraintWidget2.isInVerticalChain())) {
                    f(i13, constraintWidget, interfaceC0158b, constraintWidget2);
                }
                i11 = 0;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f1683d;
                int i14 = i10 + 1;
                boolean zA2 = a(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && zA2) {
                    androidx.constraintlayout.core.widgets.d.measure(i14, constraintWidget3, interfaceC0158b, new b.a(), 0);
                }
                ConstraintAnchor constraintAnchor7 = constraintWidget3.L;
                ConstraintAnchor constraintAnchor8 = constraintWidget3.N;
                boolean z11 = (next2 == constraintAnchor7 && (constraintAnchor2 = constraintAnchor8.f1685f) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintAnchor8 && (constraintAnchor = constraintAnchor7.f1685f) != null && constraintAnchor.hasFinalValue());
                if (constraintWidget3.getVerticalDimensionBehaviour() != dimensionBehaviour || zA2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        if (next2 == constraintAnchor7 && constraintAnchor8.f1685f == null) {
                            int margin3 = constraintAnchor7.getMargin() + finalValue2;
                            constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                            g(i14, constraintWidget3, interfaceC0158b);
                        } else if (next2 == constraintAnchor8 && constraintAnchor7.f1685f == null) {
                            int margin4 = finalValue2 - constraintAnchor8.getMargin();
                            constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                            g(i14, constraintWidget3, interfaceC0158b);
                        } else if (z11 && !constraintWidget3.isInVerticalChain()) {
                            e(i14, constraintWidget3, interfaceC0158b);
                        }
                    }
                } else if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget3.f1741z >= 0 && constraintWidget3.f1740y >= 0) {
                    if (constraintWidget3.getVisibility() != 8) {
                        if (constraintWidget3.f1735t == 0) {
                            if (constraintWidget3.getDimensionRatio() == 0.0f) {
                            }
                        }
                    }
                    if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z11 && !constraintWidget3.isInVerticalChain()) {
                        f(i14, constraintWidget, interfaceC0158b, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor anchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
            int finalValue3 = anchor3.getFinalValue();
            Iterator<ConstraintAnchor> it3 = anchor3.getDependents().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.f1683d;
                int i15 = i10 + 1;
                boolean zA3 = a(constraintWidget4);
                if (constraintWidget4.isMeasureRequested() && zA3) {
                    androidx.constraintlayout.core.widgets.d.measure(i15, constraintWidget4, interfaceC0158b, new b.a(), 0);
                }
                if (constraintWidget4.getVerticalDimensionBehaviour() != dimensionBehaviour || zA3) {
                    if (!constraintWidget4.isMeasureRequested() && next3 == constraintWidget4.O) {
                        constraintWidget4.setFinalBaseline(next3.getMargin() + finalValue3);
                        g(i15, constraintWidget4, interfaceC0158b);
                    }
                }
            }
        }
        constraintWidget.markVerticalSolvingPassDone();
    }

    public static void solvingPass(androidx.constraintlayout.core.widgets.d dVar, b.InterfaceC0158b interfaceC0158b) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = dVar.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = dVar.getVerticalDimensionBehaviour();
        dVar.resetFinalResolution();
        ArrayList<ConstraintWidget> children = dVar.getChildren();
        int size = children.size();
        for (int i10 = 0; i10 < size; i10++) {
            children.get(i10).resetFinalResolution();
        }
        boolean zIsRtl = dVar.isRtl();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour == dimensionBehaviour) {
            dVar.setFinalHorizontal(0, dVar.getWidth());
        } else {
            dVar.setFinalLeft(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = children.get(i11);
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                if (fVar.getOrientation() == 1) {
                    if (fVar.getRelativeBegin() != -1) {
                        fVar.setFinalValue(fVar.getRelativeBegin());
                    } else if (fVar.getRelativeEnd() != -1 && dVar.isResolvedHorizontally()) {
                        fVar.setFinalValue(dVar.getWidth() - fVar.getRelativeEnd());
                    } else if (dVar.isResolvedHorizontally()) {
                        fVar.setFinalValue((int) ((fVar.getRelativePercent() * dVar.getWidth()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget).getOrientation() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = children.get(i12);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar2 = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                    if (fVar2.getOrientation() == 1) {
                        b(0, fVar2, interfaceC0158b, zIsRtl);
                    }
                }
            }
        }
        b(0, dVar, interfaceC0158b, zIsRtl);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget3 = children.get(i13);
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget3;
                    if (aVar.getOrientation() == 0 && aVar.allSolved()) {
                        b(1, aVar, interfaceC0158b, zIsRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == dimensionBehaviour) {
            dVar.setFinalVertical(0, dVar.getHeight());
        } else {
            dVar.setFinalTop(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = children.get(i14);
            if (constraintWidget4 instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar3 = (androidx.constraintlayout.core.widgets.f) constraintWidget4;
                if (fVar3.getOrientation() == 0) {
                    if (fVar3.getRelativeBegin() != -1) {
                        fVar3.setFinalValue(fVar3.getRelativeBegin());
                    } else if (fVar3.getRelativeEnd() != -1 && dVar.isResolvedVertically()) {
                        fVar3.setFinalValue(dVar.getHeight() - fVar3.getRelativeEnd());
                    } else if (dVar.isResolvedVertically()) {
                        fVar3.setFinalValue((int) ((fVar3.getRelativePercent() * dVar.getHeight()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget4).getOrientation() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = children.get(i15);
                if (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar4 = (androidx.constraintlayout.core.widgets.f) constraintWidget5;
                    if (fVar4.getOrientation() == 0) {
                        g(1, fVar4, interfaceC0158b);
                    }
                }
            }
        }
        g(0, dVar, interfaceC0158b);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = children.get(i16);
                if (constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) constraintWidget6;
                    if (aVar2.getOrientation() == 1 && aVar2.allSolved()) {
                        g(1, aVar2, interfaceC0158b);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            ConstraintWidget constraintWidget7 = children.get(i17);
            if (constraintWidget7.isMeasureRequested() && a(constraintWidget7)) {
                androidx.constraintlayout.core.widgets.d.measure(0, constraintWidget7, interfaceC0158b, f12897a, 0);
                if (!(constraintWidget7 instanceof androidx.constraintlayout.core.widgets.f)) {
                    b(0, constraintWidget7, interfaceC0158b, zIsRtl);
                    g(0, constraintWidget7, interfaceC0158b);
                } else if (((androidx.constraintlayout.core.widgets.f) constraintWidget7).getOrientation() == 0) {
                    g(0, constraintWidget7, interfaceC0158b);
                } else {
                    b(0, constraintWidget7, interfaceC0158b, zIsRtl);
                }
            }
        }
    }
}
