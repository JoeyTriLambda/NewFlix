package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import h0.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class ConstraintAnchor {

    /* renamed from: b, reason: collision with root package name */
    public int f1681b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1682c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f1683d;

    /* renamed from: e, reason: collision with root package name */
    public final Type f1684e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f1685f;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable f1688i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f1680a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f1686g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f1687h = Integer.MIN_VALUE;

    public enum Type {
        /* JADX INFO: Fake field, exist only in values array */
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1683d = constraintWidget;
        this.f1684e = type;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z10) {
        if (constraintAnchor == null) {
            reset();
            return true;
        }
        if (!z10 && !isValidConnection(constraintAnchor)) {
            return false;
        }
        this.f1685f = constraintAnchor;
        if (constraintAnchor.f1680a == null) {
            constraintAnchor.f1680a = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.f1685f.f1680a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f1686g = i10;
        this.f1687h = i11;
        return true;
    }

    public void findDependents(int i10, ArrayList<j> arrayList, j jVar) {
        HashSet<ConstraintAnchor> hashSet = this.f1680a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                h0.g.findDependents(it.next().f1683d, i10, arrayList, jVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> getDependents() {
        return this.f1680a;
    }

    public int getFinalValue() {
        if (this.f1682c) {
            return this.f1681b;
        }
        return 0;
    }

    public int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.f1683d.getVisibility() == 8) {
            return 0;
        }
        return (this.f1687h == Integer.MIN_VALUE || (constraintAnchor = this.f1685f) == null || constraintAnchor.f1683d.getVisibility() != 8) ? this.f1686g : this.f1687h;
    }

    public final ConstraintAnchor getOpposite() {
        Type type = this.f1684e;
        int iOrdinal = type.ordinal();
        ConstraintWidget constraintWidget = this.f1683d;
        switch (iOrdinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return constraintWidget.M;
            case 2:
                return constraintWidget.N;
            case 3:
                return constraintWidget.K;
            case 4:
                return constraintWidget.L;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ConstraintWidget getOwner() {
        return this.f1683d;
    }

    public SolverVariable getSolverVariable() {
        return this.f1688i;
    }

    public ConstraintAnchor getTarget() {
        return this.f1685f;
    }

    public Type getType() {
        return this.f1684e;
    }

    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> hashSet = this.f1680a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().getOpposite().isConnected()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> hashSet = this.f1680a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean hasFinalValue() {
        return this.f1682c;
    }

    public boolean isConnected() {
        return this.f1685f != null;
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        Type type2 = Type.BASELINE;
        Type type3 = this.f1684e;
        if (type == type3) {
            return type3 != type2 || (constraintAnchor.getOwner().hasBaseline() && getOwner().hasBaseline());
        }
        int iOrdinal = type3.ordinal();
        Type type4 = Type.CENTER_Y;
        Type type5 = Type.RIGHT;
        Type type6 = Type.CENTER_X;
        Type type7 = Type.LEFT;
        switch (iOrdinal) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z10 = type == type7 || type == type5;
                if (constraintAnchor.getOwner() instanceof f) {
                    return z10 || type == type6;
                }
                return z10;
            case 2:
            case 4:
                boolean z11 = type == Type.TOP || type == Type.BOTTOM;
                if (constraintAnchor.getOwner() instanceof f) {
                    return z11 || type == type4;
                }
                return z11;
            case 5:
                return (type == type7 || type == type5) ? false : true;
            case 6:
                return (type == type2 || type == type6 || type == type4) ? false : true;
            default:
                throw new AssertionError(type3.name());
        }
    }

    public void reset() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f1685f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f1680a) != null) {
            hashSet.remove(this);
            if (this.f1685f.f1680a.size() == 0) {
                this.f1685f.f1680a = null;
            }
        }
        this.f1680a = null;
        this.f1685f = null;
        this.f1686g = 0;
        this.f1687h = Integer.MIN_VALUE;
        this.f1682c = false;
        this.f1681b = 0;
    }

    public void resetFinalResolution() {
        this.f1682c = false;
        this.f1681b = 0;
    }

    public void resetSolverVariable(d0.a aVar) {
        SolverVariable solverVariable = this.f1688i;
        if (solverVariable == null) {
            this.f1688i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.reset();
        }
    }

    public void setFinalValue(int i10) {
        this.f1681b = i10;
        this.f1682c = true;
    }

    public void setGoneMargin(int i10) {
        if (isConnected()) {
            this.f1687h = i10;
        }
    }

    public String toString() {
        return this.f1683d.getDebugName() + ":" + this.f1684e.toString();
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i10) {
        return connect(constraintAnchor, i10, Integer.MIN_VALUE, false);
    }
}
