package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public float A;
    public int B;
    public float C;
    public final int[] D;
    public float E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public final ConstraintAnchor K;
    public final ConstraintAnchor L;
    public final ConstraintAnchor M;
    public final ConstraintAnchor N;
    public final ConstraintAnchor O;
    public final ConstraintAnchor P;
    public final ConstraintAnchor Q;
    public final ConstraintAnchor R;
    public final ConstraintAnchor[] S;
    public final ArrayList<ConstraintAnchor> T;
    public final boolean[] U;
    public final DimensionBehaviour[] V;
    public ConstraintWidget W;
    public int X;
    public int Y;
    public float Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f1699a0;

    /* renamed from: b, reason: collision with root package name */
    public h0.c f1700b;

    /* renamed from: b0, reason: collision with root package name */
    public int f1701b0;

    /* renamed from: c, reason: collision with root package name */
    public h0.c f1702c;

    /* renamed from: c0, reason: collision with root package name */
    public int f1703c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1705d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f1707e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f1709f0;

    /* renamed from: g0, reason: collision with root package name */
    public float f1711g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f1713h0;

    /* renamed from: i0, reason: collision with root package name */
    public Object f1715i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f1717j0;

    /* renamed from: k, reason: collision with root package name */
    public String f1718k;

    /* renamed from: k0, reason: collision with root package name */
    public String f1719k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1720l;

    /* renamed from: l0, reason: collision with root package name */
    public int f1721l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1722m;

    /* renamed from: m0, reason: collision with root package name */
    public int f1723m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1724n;

    /* renamed from: n0, reason: collision with root package name */
    public final float[] f1725n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1726o;

    /* renamed from: o0, reason: collision with root package name */
    public final ConstraintWidget[] f1727o0;

    /* renamed from: p, reason: collision with root package name */
    public int f1728p;

    /* renamed from: p0, reason: collision with root package name */
    public final ConstraintWidget[] f1729p0;

    /* renamed from: q, reason: collision with root package name */
    public int f1730q;

    /* renamed from: q0, reason: collision with root package name */
    public int f1731q0;

    /* renamed from: r, reason: collision with root package name */
    public int f1732r;

    /* renamed from: r0, reason: collision with root package name */
    public int f1733r0;

    /* renamed from: s, reason: collision with root package name */
    public int f1734s;

    /* renamed from: t, reason: collision with root package name */
    public int f1735t;

    /* renamed from: u, reason: collision with root package name */
    public final int[] f1736u;

    /* renamed from: v, reason: collision with root package name */
    public int f1737v;

    /* renamed from: w, reason: collision with root package name */
    public int f1738w;

    /* renamed from: x, reason: collision with root package name */
    public float f1739x;

    /* renamed from: y, reason: collision with root package name */
    public int f1740y;

    /* renamed from: z, reason: collision with root package name */
    public int f1741z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1698a = false;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f1704d = null;

    /* renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.d f1706e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f1708f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    public boolean f1710g = true;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1712h = true;

    /* renamed from: i, reason: collision with root package name */
    public int f1714i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f1716j = -1;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        new f0.a(this);
        this.f1720l = false;
        this.f1722m = false;
        this.f1724n = false;
        this.f1726o = false;
        this.f1728p = -1;
        this.f1730q = -1;
        this.f1732r = 0;
        this.f1734s = 0;
        this.f1735t = 0;
        this.f1736u = new int[2];
        this.f1737v = 0;
        this.f1738w = 0;
        this.f1739x = 1.0f;
        this.f1740y = 0;
        this.f1741z = 0;
        this.A = 1.0f;
        this.B = -1;
        this.C = 1.0f;
        this.D = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.E = 0.0f;
        this.F = false;
        this.H = false;
        this.I = 0;
        this.J = 0;
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.K = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.L = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.M = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.N = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.O = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.P = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.Q = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.R = constraintAnchor8;
        this.S = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList<ConstraintAnchor> arrayList = new ArrayList<>();
        this.T = arrayList;
        this.U = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.V = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.W = null;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.f1699a0 = -1;
        this.f1701b0 = 0;
        this.f1703c0 = 0;
        this.f1705d0 = 0;
        this.f1711g0 = 0.5f;
        this.f1713h0 = 0.5f;
        this.f1717j0 = 0;
        this.f1719k0 = null;
        this.f1721l0 = 0;
        this.f1723m0 = 0;
        this.f1725n0 = new float[]{-1.0f, -1.0f};
        this.f1727o0 = new ConstraintWidget[]{null, null};
        this.f1729p0 = new ConstraintWidget[]{null, null};
        this.f1731q0 = -1;
        this.f1733r0 = -1;
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    public static void b(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, float f10) {
        sb2.append(str);
        sb2.append(" :  {\n");
        e(i10, 0, "      size", sb2);
        e(i11, 0, "      min", sb2);
        e(i12, Integer.MAX_VALUE, "      max", sb2);
        e(i13, 0, "      matchMin", sb2);
        e(i14, 0, "      matchDef", sb2);
        f(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    public static void c(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f1685f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f1685f);
        sb2.append("'");
        if (constraintAnchor.f1687h != Integer.MIN_VALUE || constraintAnchor.f1686g != 0) {
            sb2.append(",");
            sb2.append(constraintAnchor.f1686g);
            if (constraintAnchor.f1687h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(constraintAnchor.f1687h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    public static void e(int i10, int i11, String str, StringBuilder sb2) {
        if (i10 == i11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    public static void f(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0516 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:363:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(androidx.constraintlayout.core.c r36, boolean r37, boolean r38, boolean r39, boolean r40, androidx.constraintlayout.core.SolverVariable r41, androidx.constraintlayout.core.SolverVariable r42, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r43, boolean r44, androidx.constraintlayout.core.widgets.ConstraintAnchor r45, androidx.constraintlayout.core.widgets.ConstraintAnchor r46, int r47, int r48, int r49, int r50, float r51, boolean r52, boolean r53, boolean r54, boolean r55, boolean r56, int r57, int r58, int r59, int r60, float r61, boolean r62) {
        /*
            Method dump skipped, instructions count: 1357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.a(androidx.constraintlayout.core.c, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void addChildrenToSolverByDependency(d dVar, androidx.constraintlayout.core.c cVar, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, cVar, this);
            hashSet.remove(this);
            addToSolver(cVar, dVar.optimizeFor(64));
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> dependents = this.K.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().f1683d.addChildrenToSolverByDependency(dVar, cVar, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.M.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().f1683d.addChildrenToSolverByDependency(dVar, cVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.L.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().f1683d.addChildrenToSolverByDependency(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.N.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().f1683d.addChildrenToSolverByDependency(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.O.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().f1683d.addChildrenToSolverByDependency(dVar, cVar, hashSet, i10, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addToSolver(androidx.constraintlayout.core.c r63, boolean r64) {
        /*
            Method dump skipped, instructions count: 1615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.c, boolean):void");
    }

    public boolean allowedInBarrier() {
        return this.f1717j0 != 8;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i10);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i10, 0);
        this.E = f10;
    }

    public void createObjectVariables(androidx.constraintlayout.core.c cVar) {
        cVar.createObjectVariable(this.K);
        cVar.createObjectVariable(this.L);
        cVar.createObjectVariable(this.M);
        cVar.createObjectVariable(this.N);
        if (this.f1705d0 > 0) {
            cVar.createObjectVariable(this.O);
        }
    }

    public final boolean d(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.S;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i11];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1685f;
        return (constraintAnchor4 == null || constraintAnchor4.f1685f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i11 + 1]).f1685f) == null || constraintAnchor2.f1685f != constraintAnchor) ? false : true;
    }

    public void ensureWidgetRuns() {
        if (this.f1704d == null) {
            this.f1704d = new androidx.constraintlayout.core.widgets.analyzer.c(this);
        }
        if (this.f1706e == null) {
            this.f1706e = new androidx.constraintlayout.core.widgets.analyzer.d(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case NONE:
                return null;
            case LEFT:
                return this.K;
            case TOP:
                return this.L;
            case RIGHT:
                return this.M;
            case BOTTOM:
                return this.N;
            case BASELINE:
                return this.O;
            case CENTER:
                return this.R;
            case CENTER_X:
                return this.P;
            case CENTER_Y:
                return this.Q;
            default:
                throw new AssertionError(type.name());
        }
    }

    public int getBaselineDistance() {
        return this.f1705d0;
    }

    public float getBiasPercent(int i10) {
        if (i10 == 0) {
            return this.f1711g0;
        }
        if (i10 == 1) {
            return this.f1713h0;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.Y;
    }

    public Object getCompanionWidget() {
        return this.f1715i0;
    }

    public String getDebugName() {
        return this.f1719k0;
    }

    public DimensionBehaviour getDimensionBehaviour(int i10) {
        if (i10 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i10 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.Z;
    }

    public int getDimensionRatioSide() {
        return this.f1699a0;
    }

    public int getHeight() {
        if (this.f1717j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public float getHorizontalBiasPercent() {
        return this.f1711g0;
    }

    public int getHorizontalChainStyle() {
        return this.f1721l0;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.V[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.K;
        int i10 = constraintAnchor != null ? 0 + constraintAnchor.f1686g : 0;
        ConstraintAnchor constraintAnchor2 = this.M;
        return constraintAnchor2 != null ? i10 + constraintAnchor2.f1686g : i10;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.I;
    }

    public int getLastVerticalMeasureSpec() {
        return this.J;
    }

    public int getLength(int i10) {
        if (i10 == 0) {
            return getWidth();
        }
        if (i10 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.D[1];
    }

    public int getMaxWidth() {
        return this.D[0];
    }

    public int getMinHeight() {
        return this.f1709f0;
    }

    public int getMinWidth() {
        return this.f1707e0;
    }

    public ConstraintWidget getNextChainMember(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.N).f1685f) != null && constraintAnchor2.f1685f == constraintAnchor) {
                return constraintAnchor2.f1683d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.M;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1685f;
        if (constraintAnchor4 == null || constraintAnchor4.f1685f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f1683d;
    }

    public ConstraintWidget getParent() {
        return this.W;
    }

    public ConstraintWidget getPreviousChainMember(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.L).f1685f) != null && constraintAnchor2.f1685f == constraintAnchor) {
                return constraintAnchor2.f1683d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.K;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1685f;
        if (constraintAnchor4 == null || constraintAnchor4.f1685f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f1683d;
    }

    public int getRight() {
        return getX() + this.X;
    }

    public WidgetRun getRun(int i10) {
        if (i10 == 0) {
            return this.f1704d;
        }
        if (i10 == 1) {
            return this.f1706e;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb2) {
        sb2.append("  " + this.f1718k + ":{\n");
        StringBuilder sb3 = new StringBuilder("    actualWidth:");
        sb3.append(this.X);
        sb2.append(sb3.toString());
        sb2.append(StringUtils.LF);
        sb2.append("    actualHeight:" + this.Y);
        sb2.append(StringUtils.LF);
        sb2.append("    actualLeft:" + this.f1701b0);
        sb2.append(StringUtils.LF);
        sb2.append("    actualTop:" + this.f1703c0);
        sb2.append(StringUtils.LF);
        c(sb2, "left", this.K);
        c(sb2, "top", this.L);
        c(sb2, "right", this.M);
        c(sb2, "bottom", this.N);
        c(sb2, "baseline", this.O);
        c(sb2, "centerX", this.P);
        c(sb2, "centerY", this.Q);
        int i10 = this.X;
        int i11 = this.f1707e0;
        int[] iArr = this.D;
        int i12 = iArr[0];
        int i13 = this.f1737v;
        int i14 = this.f1734s;
        float f10 = this.f1739x;
        float[] fArr = this.f1725n0;
        float f11 = fArr[0];
        b(sb2, "    width", i10, i11, i12, i13, i14, f10);
        int i15 = this.Y;
        int i16 = this.f1709f0;
        int i17 = iArr[1];
        int i18 = this.f1740y;
        int i19 = this.f1735t;
        float f12 = this.A;
        float f13 = fArr[1];
        b(sb2, "    height", i15, i16, i17, i18, i19, f12);
        float f14 = this.Z;
        int i20 = this.f1699a0;
        if (f14 != 0.0f) {
            sb2.append("    dimensionRatio");
            sb2.append(" :  [");
            sb2.append(f14);
            sb2.append(",");
            sb2.append(i20);
            sb2.append("");
            sb2.append("],\n");
        }
        f(sb2, "    horizontalBias", this.f1711g0, 0.5f);
        f(sb2, "    verticalBias", this.f1713h0, 0.5f);
        e(this.f1721l0, 0, "    horizontalChainStyle", sb2);
        e(this.f1723m0, 0, "    verticalChainStyle", sb2);
        sb2.append("  }");
    }

    public float getVerticalBiasPercent() {
        return this.f1713h0;
    }

    public int getVerticalChainStyle() {
        return this.f1723m0;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.V[1];
    }

    public int getVerticalMargin() {
        int i10 = this.K != null ? 0 + this.L.f1686g : 0;
        return this.M != null ? i10 + this.N.f1686g : i10;
    }

    public int getVisibility() {
        return this.f1717j0;
    }

    public int getWidth() {
        if (this.f1717j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.W;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f1701b0 : ((d) constraintWidget).f1812z0 + this.f1701b0;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.W;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f1703c0 : ((d) constraintWidget).A0 + this.f1703c0;
    }

    public boolean hasBaseline() {
        return this.F;
    }

    public boolean hasDanglingDimension(int i10) {
        if (i10 == 0) {
            return (this.K.f1685f != null ? 1 : 0) + (this.M.f1685f != null ? 1 : 0) < 2;
        }
        return ((this.L.f1685f != null ? 1 : 0) + (this.N.f1685f != null ? 1 : 0)) + (this.O.f1685f != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        ArrayList<ConstraintAnchor> arrayList = this.T;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (arrayList.get(i10).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.f1714i == -1 && this.f1716j == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor5 = this.K;
            ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1685f;
            if (constraintAnchor6 != null && constraintAnchor6.hasFinalValue() && (constraintAnchor4 = (constraintAnchor3 = this.M).f1685f) != null && constraintAnchor4.hasFinalValue()) {
                return (constraintAnchor3.f1685f.getFinalValue() - constraintAnchor3.getMargin()) - (constraintAnchor5.getMargin() + constraintAnchor5.f1685f.getFinalValue()) >= i11;
            }
        } else {
            ConstraintAnchor constraintAnchor7 = this.L;
            ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1685f;
            if (constraintAnchor8 != null && constraintAnchor8.hasFinalValue() && (constraintAnchor2 = (constraintAnchor = this.N).f1685f) != null && constraintAnchor2.hasFinalValue()) {
                return (constraintAnchor.f1685f.getFinalValue() - constraintAnchor.getMargin()) - (constraintAnchor7.getMargin() + constraintAnchor7.f1685f.getFinalValue()) >= i11;
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i10, i11, true);
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.f1724n;
    }

    public boolean isInBarrier(int i10) {
        return this.U[i10];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.K;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1685f;
        if (constraintAnchor2 != null && constraintAnchor2.f1685f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.M;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1685f;
        return constraintAnchor4 != null && constraintAnchor4.f1685f == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.G;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.L;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1685f;
        if (constraintAnchor2 != null && constraintAnchor2.f1685f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.N;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1685f;
        return constraintAnchor4 != null && constraintAnchor4.f1685f == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.H;
    }

    public boolean isMeasureRequested() {
        return this.f1710g && this.f1717j0 != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.f1720l || (this.K.hasFinalValue() && this.M.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.f1722m || (this.L.hasFinalValue() && this.N.hasFinalValue());
    }

    public boolean isVerticalSolvingPassDone() {
        return this.f1726o;
    }

    public void markHorizontalSolvingPassDone() {
        this.f1724n = true;
    }

    public void markVerticalSolvingPassDone() {
        this.f1726o = true;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.K.reset();
        this.L.reset();
        this.M.reset();
        this.N.reset();
        this.O.reset();
        this.P.reset();
        this.Q.reset();
        this.R.reset();
        this.W = null;
        this.E = 0.0f;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.f1699a0 = -1;
        this.f1701b0 = 0;
        this.f1703c0 = 0;
        this.f1705d0 = 0;
        this.f1707e0 = 0;
        this.f1709f0 = 0;
        this.f1711g0 = 0.5f;
        this.f1713h0 = 0.5f;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f1715i0 = null;
        this.f1717j0 = 0;
        this.f1721l0 = 0;
        this.f1723m0 = 0;
        float[] fArr = this.f1725n0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1728p = -1;
        this.f1730q = -1;
        int[] iArr = this.D;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1734s = 0;
        this.f1735t = 0;
        this.f1739x = 1.0f;
        this.A = 1.0f;
        this.f1738w = Integer.MAX_VALUE;
        this.f1741z = Integer.MAX_VALUE;
        this.f1737v = 0;
        this.f1740y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f1708f;
        zArr[0] = true;
        zArr[1] = true;
        this.H = false;
        boolean[] zArr2 = this.U;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1710g = true;
        int[] iArr2 = this.f1736u;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f1714i = -1;
        this.f1716j = -1;
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof d) && ((d) getParent()).handlesInternalConstraints()) {
            return;
        }
        ArrayList<ConstraintAnchor> arrayList = this.T;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).reset();
        }
    }

    public void resetFinalResolution() {
        this.f1720l = false;
        this.f1722m = false;
        this.f1724n = false;
        this.f1726o = false;
        ArrayList<ConstraintAnchor> arrayList = this.T;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).resetFinalResolution();
        }
    }

    public void resetSolverVariables(d0.a aVar) {
        this.K.resetSolverVariable(aVar);
        this.L.resetSolverVariable(aVar);
        this.M.resetSolverVariable(aVar);
        this.N.resetSolverVariable(aVar);
        this.O.resetSolverVariable(aVar);
        this.R.resetSolverVariable(aVar);
        this.P.resetSolverVariable(aVar);
        this.Q.resetSolverVariable(aVar);
    }

    public void setBaselineDistance(int i10) {
        this.f1705d0 = i10;
        this.F = i10 > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.f1715i0 = obj;
    }

    public void setDebugName(String str) {
        this.f1719k0 = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0087 A[PHI: r0
  0x0087: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:39:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0087 -> B:41:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L91
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L91
        Lb:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L39
            int r6 = r1 + (-1)
            if (r2 >= r6) goto L39
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2b
            goto L36
        L2b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L35
            r3 = 1
            goto L36
        L35:
            r3 = -1
        L36:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L39:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L77
            int r1 = r1 - r4
            if (r2 >= r1) goto L77
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L87
            int r2 = r9.length()
            if (r2 <= 0) goto L87
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L87
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L87
            if (r5 != r4) goto L71
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L88
        L71:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
            goto L88
        L77:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L87
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L88
        L86:
        L87:
            r9 = 0
        L88:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L90
            r8.Z = r9
            r8.f1699a0 = r5
        L90:
            return
        L91:
            r8.Z = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setFinalBaseline(int i10) {
        if (this.F) {
            int i11 = i10 - this.f1705d0;
            int i12 = this.Y + i11;
            this.f1703c0 = i11;
            this.L.setFinalValue(i11);
            this.N.setFinalValue(i12);
            this.O.setFinalValue(i10);
            this.f1722m = true;
        }
    }

    public void setFinalHorizontal(int i10, int i11) {
        if (this.f1720l) {
            return;
        }
        this.K.setFinalValue(i10);
        this.M.setFinalValue(i11);
        this.f1701b0 = i10;
        this.X = i11 - i10;
        this.f1720l = true;
    }

    public void setFinalLeft(int i10) {
        this.K.setFinalValue(i10);
        this.f1701b0 = i10;
    }

    public void setFinalTop(int i10) {
        this.L.setFinalValue(i10);
        this.f1703c0 = i10;
    }

    public void setFinalVertical(int i10, int i11) {
        if (this.f1722m) {
            return;
        }
        this.L.setFinalValue(i10);
        this.N.setFinalValue(i11);
        this.f1703c0 = i10;
        this.Y = i11 - i10;
        if (this.F) {
            this.O.setFinalValue(i10 + this.f1705d0);
        }
        this.f1722m = true;
    }

    public void setFrame(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f1701b0 = i10;
        this.f1703c0 = i11;
        if (this.f1717j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.X)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.Y)) {
            i17 = i14;
        }
        this.X = i16;
        this.Y = i17;
        int i18 = this.f1709f0;
        if (i17 < i18) {
            this.Y = i18;
        }
        int i19 = this.f1707e0;
        if (i16 < i19) {
            this.X = i19;
        }
        int i20 = this.f1738w;
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (i20 > 0 && dimensionBehaviour == dimensionBehaviour3) {
            this.X = Math.min(this.X, i20);
        }
        int i21 = this.f1741z;
        if (i21 > 0 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
            this.Y = Math.min(this.Y, i21);
        }
        int i22 = this.X;
        if (i16 != i22) {
            this.f1714i = i22;
        }
        int i23 = this.Y;
        if (i17 != i23) {
            this.f1716j = i23;
        }
    }

    public void setHasBaseline(boolean z10) {
        this.F = z10;
    }

    public void setHeight(int i10) {
        this.Y = i10;
        int i11 = this.f1709f0;
        if (i10 < i11) {
            this.Y = i11;
        }
    }

    public void setHorizontalBiasPercent(float f10) {
        this.f1711g0 = f10;
    }

    public void setHorizontalChainStyle(int i10) {
        this.f1721l0 = i10;
    }

    public void setHorizontalDimension(int i10, int i11) {
        this.f1701b0 = i10;
        int i12 = i11 - i10;
        this.X = i12;
        int i13 = this.f1707e0;
        if (i12 < i13) {
            this.X = i13;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.V[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i10, int i11, int i12, float f10) {
        this.f1734s = i10;
        this.f1737v = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f1738w = i12;
        this.f1739x = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f1734s = 2;
    }

    public void setHorizontalWeight(float f10) {
        this.f1725n0[0] = f10;
    }

    public void setInBarrier(int i10, boolean z10) {
        this.U[i10] = z10;
    }

    public void setInPlaceholder(boolean z10) {
        this.G = z10;
    }

    public void setInVirtualLayout(boolean z10) {
        this.H = z10;
    }

    public void setLastMeasureSpec(int i10, int i11) {
        this.I = i10;
        this.J = i11;
        setMeasureRequested(false);
    }

    public void setMaxHeight(int i10) {
        this.D[1] = i10;
    }

    public void setMaxWidth(int i10) {
        this.D[0] = i10;
    }

    public void setMeasureRequested(boolean z10) {
        this.f1710g = z10;
    }

    public void setMinHeight(int i10) {
        if (i10 < 0) {
            this.f1709f0 = 0;
        } else {
            this.f1709f0 = i10;
        }
    }

    public void setMinWidth(int i10) {
        if (i10 < 0) {
            this.f1707e0 = 0;
        } else {
            this.f1707e0 = i10;
        }
    }

    public void setOrigin(int i10, int i11) {
        this.f1701b0 = i10;
        this.f1703c0 = i11;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.W = constraintWidget;
    }

    public void setVerticalBiasPercent(float f10) {
        this.f1713h0 = f10;
    }

    public void setVerticalChainStyle(int i10) {
        this.f1723m0 = i10;
    }

    public void setVerticalDimension(int i10, int i11) {
        this.f1703c0 = i10;
        int i12 = i11 - i10;
        this.Y = i12;
        int i13 = this.f1709f0;
        if (i12 < i13) {
            this.Y = i13;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.V[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i10, int i11, int i12, float f10) {
        this.f1735t = i10;
        this.f1740y = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f1741z = i12;
        this.A = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.f1735t = 2;
    }

    public void setVerticalWeight(float f10) {
        this.f1725n0[1] = f10;
    }

    public void setVisibility(int i10) {
        this.f1717j0 = i10;
    }

    public void setWidth(int i10) {
        this.X = i10;
        int i11 = this.f1707e0;
        if (i10 < i11) {
            this.X = i11;
        }
    }

    public void setWrapBehaviorInParent(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.f1732r = i10;
    }

    public void setX(int i10) {
        this.f1701b0 = i10;
    }

    public void setY(int i10) {
        this.f1703c0 = i10;
    }

    public void setupDimensionRatio(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.B == -1) {
            if (z12 && !z13) {
                this.B = 0;
            } else if (!z12 && z13) {
                this.B = 1;
                if (this.f1699a0 == -1) {
                    this.C = 1.0f / this.C;
                }
            }
        }
        int i10 = this.B;
        ConstraintAnchor constraintAnchor = this.M;
        ConstraintAnchor constraintAnchor2 = this.N;
        ConstraintAnchor constraintAnchor3 = this.K;
        ConstraintAnchor constraintAnchor4 = this.L;
        if (i10 == 0 && (!constraintAnchor4.isConnected() || !constraintAnchor2.isConnected())) {
            this.B = 1;
        } else if (this.B == 1 && (!constraintAnchor3.isConnected() || !constraintAnchor.isConnected())) {
            this.B = 0;
        }
        if (this.B == -1 && (!constraintAnchor4.isConnected() || !constraintAnchor2.isConnected() || !constraintAnchor3.isConnected() || !constraintAnchor.isConnected())) {
            if (constraintAnchor4.isConnected() && constraintAnchor2.isConnected()) {
                this.B = 0;
            } else if (constraintAnchor3.isConnected() && constraintAnchor.isConnected()) {
                this.C = 1.0f / this.C;
                this.B = 1;
            }
        }
        if (this.B == -1) {
            int i11 = this.f1737v;
            if (i11 > 0 && this.f1740y == 0) {
                this.B = 0;
            } else {
                if (i11 != 0 || this.f1740y <= 0) {
                    return;
                }
                this.C = 1.0f / this.C;
                this.B = 1;
            }
        }
    }

    public String toString() {
        StringBuilder sbR = ac.c.r("");
        sbR.append(this.f1719k0 != null ? ac.c.o(new StringBuilder("id: "), this.f1719k0, StringUtils.SPACE) : "");
        sbR.append("(");
        sbR.append(this.f1701b0);
        sbR.append(", ");
        sbR.append(this.f1703c0);
        sbR.append(") - (");
        sbR.append(this.X);
        sbR.append(" x ");
        return ac.c.m(sbR, this.Y, ")");
    }

    public void updateFromRuns(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean zIsResolved = z10 & this.f1704d.isResolved();
        boolean zIsResolved2 = z11 & this.f1706e.isResolved();
        androidx.constraintlayout.core.widgets.analyzer.c cVar = this.f1704d;
        int i12 = cVar.f1779h.f1757g;
        androidx.constraintlayout.core.widgets.analyzer.d dVar = this.f1706e;
        int i13 = dVar.f1779h.f1757g;
        int i14 = cVar.f1780i.f1757g;
        int i15 = dVar.f1780i.f1757g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (zIsResolved) {
            this.f1701b0 = i12;
        }
        if (zIsResolved2) {
            this.f1703c0 = i13;
        }
        if (this.f1717j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        if (zIsResolved) {
            if (dimensionBehaviourArr[0] == dimensionBehaviour && i17 < (i11 = this.X)) {
                i17 = i11;
            }
            this.X = i17;
            int i19 = this.f1707e0;
            if (i17 < i19) {
                this.X = i19;
            }
        }
        if (zIsResolved2) {
            if (dimensionBehaviourArr[1] == dimensionBehaviour && i18 < (i10 = this.Y)) {
                i18 = i10;
            }
            this.Y = i18;
            int i20 = this.f1709f0;
            if (i18 < i20) {
                this.Y = i20;
            }
        }
    }

    public void updateFromSolver(androidx.constraintlayout.core.c cVar, boolean z10) {
        androidx.constraintlayout.core.widgets.analyzer.d dVar;
        androidx.constraintlayout.core.widgets.analyzer.c cVar2;
        int objectVariableValue = cVar.getObjectVariableValue(this.K);
        int objectVariableValue2 = cVar.getObjectVariableValue(this.L);
        int objectVariableValue3 = cVar.getObjectVariableValue(this.M);
        int objectVariableValue4 = cVar.getObjectVariableValue(this.N);
        if (z10 && (cVar2 = this.f1704d) != null) {
            DependencyNode dependencyNode = cVar2.f1779h;
            if (dependencyNode.f1760j) {
                DependencyNode dependencyNode2 = cVar2.f1780i;
                if (dependencyNode2.f1760j) {
                    objectVariableValue = dependencyNode.f1757g;
                    objectVariableValue3 = dependencyNode2.f1757g;
                }
            }
        }
        if (z10 && (dVar = this.f1706e) != null) {
            DependencyNode dependencyNode3 = dVar.f1779h;
            if (dependencyNode3.f1760j) {
                DependencyNode dependencyNode4 = dVar.f1780i;
                if (dependencyNode4.f1760j) {
                    objectVariableValue2 = dependencyNode3.f1757g;
                    objectVariableValue4 = dependencyNode4.f1757g;
                }
            }
        }
        int i10 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i10 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        boolean z10;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.CENTER;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.CENTER_Y;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER_X;
        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor.Type type8 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
        if (type == type3) {
            if (type2 != type3) {
                if (type2 == type6 || type2 == type8) {
                    connect(type6, constraintWidget, type2, 0);
                    connect(type8, constraintWidget, type2, 0);
                    getAnchor(type3).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                } else {
                    if (type2 == type7 || type2 == type9) {
                        connect(type7, constraintWidget, type2, 0);
                        connect(type9, constraintWidget, type2, 0);
                        getAnchor(type3).connect(constraintWidget.getAnchor(type2), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor anchor = getAnchor(type6);
            ConstraintAnchor anchor2 = getAnchor(type8);
            ConstraintAnchor anchor3 = getAnchor(type7);
            ConstraintAnchor anchor4 = getAnchor(type9);
            boolean z11 = true;
            if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                connect(type6, constraintWidget, type6, 0);
                connect(type8, constraintWidget, type8, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                connect(type7, constraintWidget, type7, 0);
                connect(type9, constraintWidget, type9, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                getAnchor(type3).connect(constraintWidget.getAnchor(type3), 0);
                return;
            } else if (z10) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                return;
            } else {
                if (z11) {
                    getAnchor(type4).connect(constraintWidget.getAnchor(type4), 0);
                    return;
                }
                return;
            }
        }
        if (type == type5 && (type2 == type6 || type2 == type8)) {
            ConstraintAnchor anchor5 = getAnchor(type6);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(type8);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type5).connect(anchor6, 0);
            return;
        }
        if (type == type4 && (type2 == type7 || type2 == type9)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type7).connect(anchor8, 0);
            getAnchor(type9).connect(anchor8, 0);
            getAnchor(type4).connect(anchor8, 0);
            return;
        }
        if (type == type5 && type2 == type5) {
            getAnchor(type6).connect(constraintWidget.getAnchor(type6), 0);
            getAnchor(type8).connect(constraintWidget.getAnchor(type8), 0);
            getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type4 && type2 == type4) {
            getAnchor(type7).connect(constraintWidget.getAnchor(type7), 0);
            getAnchor(type9).connect(constraintWidget.getAnchor(type9), 0);
            getAnchor(type4).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.BASELINE;
            if (type == type10) {
                ConstraintAnchor anchor11 = getAnchor(type7);
                ConstraintAnchor anchor12 = getAnchor(type9);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else if (type == type7 || type == type9) {
                ConstraintAnchor anchor13 = getAnchor(type10);
                if (anchor13 != null) {
                    anchor13.reset();
                }
                ConstraintAnchor anchor14 = getAnchor(type3);
                if (anchor14.getTarget() != anchor10) {
                    anchor14.reset();
                }
                ConstraintAnchor opposite = getAnchor(type).getOpposite();
                ConstraintAnchor anchor15 = getAnchor(type4);
                if (anchor15.isConnected()) {
                    opposite.reset();
                    anchor15.reset();
                }
            } else if (type == type6 || type == type8) {
                ConstraintAnchor anchor16 = getAnchor(type3);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type5);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i10);
        }
    }
}
