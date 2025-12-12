package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: PriorityGoalRow.java */
/* loaded from: classes.dex */
public final class d extends androidx.constraintlayout.core.b {

    /* renamed from: f, reason: collision with root package name */
    public SolverVariable[] f1674f;

    /* renamed from: g, reason: collision with root package name */
    public SolverVariable[] f1675g;

    /* renamed from: h, reason: collision with root package name */
    public int f1676h;

    /* renamed from: i, reason: collision with root package name */
    public final b f1677i;

    /* compiled from: PriorityGoalRow.java */
    public class a implements Comparator<SolverVariable> {
        @Override // java.util.Comparator
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f1626m - solverVariable2.f1626m;
        }
    }

    /* compiled from: PriorityGoalRow.java */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public SolverVariable f1678a;

        public b(d dVar) {
        }

        public boolean addToGoal(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (!this.f1678a.f1625b) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = solverVariable.f1632s[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f1678a.f1632s[i10] = f12;
                    } else {
                        this.f1678a.f1632s[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f1678a.f1632s;
                float f13 = (solverVariable.f1632s[i11] * f10) + fArr[i11];
                fArr[i11] = f13;
                if (Math.abs(f13) < 1.0E-4f) {
                    this.f1678a.f1632s[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                d.this.d(this.f1678a);
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.f1678a = solverVariable;
        }

        public final boolean isNegative() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f1678a.f1632s[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.f1632s[i10];
                float f11 = this.f1678a.f1632s[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.f1678a.f1632s, 0.0f);
        }

        public String toString() {
            String string = "[ ";
            if (this.f1678a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    StringBuilder sbR = ac.c.r(string);
                    sbR.append(this.f1678a.f1632s[i10]);
                    sbR.append(StringUtils.SPACE);
                    string = sbR.toString();
                }
            }
            StringBuilder sbU = ac.c.u(string, "] ");
            sbU.append(this.f1678a);
            return sbU.toString();
        }
    }

    public d(d0.a aVar) {
        super(aVar);
        this.f1674f = new SolverVariable[128];
        this.f1675g = new SolverVariable[128];
        this.f1676h = 0;
        this.f1677i = new b(this);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public void addError(SolverVariable solverVariable) {
        b bVar = this.f1677i;
        bVar.init(solverVariable);
        bVar.reset();
        solverVariable.f1632s[solverVariable.f1628o] = 1.0f;
        c(solverVariable);
    }

    public final void c(SolverVariable solverVariable) {
        int i10;
        int i11 = this.f1676h + 1;
        SolverVariable[] solverVariableArr = this.f1674f;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f1674f = solverVariableArr2;
            this.f1675g = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f1674f;
        int i12 = this.f1676h;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.f1676h = i13;
        if (i13 > 1 && solverVariableArr3[i13 - 1].f1626m > solverVariable.f1626m) {
            int i14 = 0;
            while (true) {
                i10 = this.f1676h;
                if (i14 >= i10) {
                    break;
                }
                this.f1675g[i14] = this.f1674f[i14];
                i14++;
            }
            Arrays.sort(this.f1675g, 0, i10, new a());
            for (int i15 = 0; i15 < this.f1676h; i15++) {
                this.f1674f[i15] = this.f1675g[i15];
            }
        }
        solverVariable.f1625b = true;
        solverVariable.addToRow(this);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public void clear() {
        this.f1676h = 0;
        this.f1653b = 0.0f;
    }

    public final void d(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.f1676h) {
            if (this.f1674f[i10] == solverVariable) {
                while (true) {
                    int i11 = this.f1676h;
                    if (i10 >= i11 - 1) {
                        this.f1676h = i11 - 1;
                        solverVariable.f1625b = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.f1674f;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.constraintlayout.core.SolverVariable getPivotCandidate(androidx.constraintlayout.core.c r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = -1
        L3:
            int r2 = r4.f1676h
            if (r0 >= r2) goto L2e
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.f1674f
            r2 = r2[r0]
            int r3 = r2.f1626m
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2b
        L12:
            androidx.constraintlayout.core.d$b r3 = r4.f1677i
            r3.init(r2)
            if (r1 != r5) goto L20
            boolean r2 = r3.isNegative()
            if (r2 == 0) goto L2b
            goto L2a
        L20:
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.f1674f
            r2 = r2[r1]
            boolean r2 = r3.isSmallerThan(r2)
            if (r2 == 0) goto L2b
        L2a:
            r1 = r0
        L2b:
            int r0 = r0 + 1
            goto L3
        L2e:
            if (r1 != r5) goto L32
            r5 = 0
            return r5
        L32:
            androidx.constraintlayout.core.SolverVariable[] r5 = r4.f1674f
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.d.getPivotCandidate(androidx.constraintlayout.core.c, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.c.a
    public boolean isEmpty() {
        return this.f1676h == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f1653b + ") : ";
        for (int i10 = 0; i10 < this.f1676h; i10++) {
            SolverVariable solverVariable = this.f1674f[i10];
            b bVar = this.f1677i;
            bVar.init(solverVariable);
            str = str + bVar + StringUtils.SPACE;
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.b
    public void updateFromRow(c cVar, androidx.constraintlayout.core.b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f1652a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.f1655d;
        int currentSize = aVar.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable variable = aVar.getVariable(i10);
            float variableValue = aVar.getVariableValue(i10);
            b bVar2 = this.f1677i;
            bVar2.init(variable);
            if (bVar2.addToGoal(solverVariable, variableValue)) {
                c(variable);
            }
            this.f1653b = (bVar.f1653b * variableValue) + this.f1653b;
        }
        d(solverVariable);
    }
}
