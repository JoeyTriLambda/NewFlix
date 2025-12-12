package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.c;
import java.util.ArrayList;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements c.a {

    /* renamed from: d, reason: collision with root package name */
    public a f1655d;

    /* renamed from: a, reason: collision with root package name */
    public SolverVariable f1652a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f1653b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<SolverVariable> f1654c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f1656e = false;

    /* compiled from: ArrayRow.java */
    public interface a {
        void add(SolverVariable solverVariable, float f10, boolean z10);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void divideByAmount(float f10);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i10);

        float getVariableValue(int i10);

        void invert();

        void put(SolverVariable solverVariable, float f10);

        float remove(SolverVariable solverVariable, boolean z10);

        float use(b bVar, boolean z10);
    }

    public b() {
    }

    public final SolverVariable a(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.f1655d.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < currentSize; i10++) {
            float variableValue = this.f1655d.getVariableValue(i10);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.f1655d.getVariable(i10);
                if ((zArr == null || !zArr[variable.f1626m]) && variable != solverVariable && (((type = variable.f1633t) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f10)) {
                    f10 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public b addError(c cVar, int i10) {
        this.f1655d.put(cVar.createErrorVariable(i10, "ep"), 1.0f);
        this.f1655d.put(cVar.createErrorVariable(i10, "em"), -1.0f);
        return this;
    }

    public final void b(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1652a;
        if (solverVariable2 != null) {
            this.f1655d.put(solverVariable2, -1.0f);
            this.f1652a.f1627n = -1;
            this.f1652a = null;
        }
        float fRemove = this.f1655d.remove(solverVariable, true) * (-1.0f);
        this.f1652a = solverVariable;
        if (fRemove == 1.0f) {
            return;
        }
        this.f1653b /= fRemove;
        this.f1655d.divideByAmount(fRemove);
    }

    @Override // androidx.constraintlayout.core.c.a
    public void clear() {
        this.f1655d.clear();
        this.f1652a = null;
        this.f1653b = 0.0f;
    }

    public b createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f1655d.put(solverVariable, -1.0f);
        this.f1655d.put(solverVariable2, 1.0f);
        this.f1655d.put(solverVariable3, f10);
        this.f1655d.put(solverVariable4, -f10);
        return this;
    }

    public b createRowEqualMatchDimensions(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f1653b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f1655d.put(solverVariable, 1.0f);
            this.f1655d.put(solverVariable2, -1.0f);
            this.f1655d.put(solverVariable4, 1.0f);
            this.f1655d.put(solverVariable3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f1655d.put(solverVariable, 1.0f);
            this.f1655d.put(solverVariable2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f1655d.put(solverVariable3, 1.0f);
            this.f1655d.put(solverVariable4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f1655d.put(solverVariable, 1.0f);
            this.f1655d.put(solverVariable2, -1.0f);
            this.f1655d.put(solverVariable4, f13);
            this.f1655d.put(solverVariable3, -f13);
        }
        return this;
    }

    public b createRowEquals(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.f1653b = i10 * (-1);
            this.f1655d.put(solverVariable, 1.0f);
        } else {
            this.f1653b = i10;
            this.f1655d.put(solverVariable, -1.0f);
        }
        return this;
    }

    public b createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f1653b = i10;
        }
        if (z10) {
            this.f1655d.put(solverVariable, 1.0f);
            this.f1655d.put(solverVariable2, -1.0f);
            this.f1655d.put(solverVariable3, -1.0f);
        } else {
            this.f1655d.put(solverVariable, -1.0f);
            this.f1655d.put(solverVariable2, 1.0f);
            this.f1655d.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public b createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f1653b = i10;
        }
        if (z10) {
            this.f1655d.put(solverVariable, 1.0f);
            this.f1655d.put(solverVariable2, -1.0f);
            this.f1655d.put(solverVariable3, 1.0f);
        } else {
            this.f1655d.put(solverVariable, -1.0f);
            this.f1655d.put(solverVariable2, 1.0f);
            this.f1655d.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public b createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f1655d.put(solverVariable3, 0.5f);
        this.f1655d.put(solverVariable4, 0.5f);
        this.f1655d.put(solverVariable, -0.5f);
        this.f1655d.put(solverVariable2, -0.5f);
        this.f1653b = -f10;
        return this;
    }

    public SolverVariable getKey() {
        return this.f1652a;
    }

    @Override // androidx.constraintlayout.core.c.a
    public SolverVariable getPivotCandidate(c cVar, boolean[] zArr) {
        return a(zArr, null);
    }

    @Override // androidx.constraintlayout.core.c.a
    public void initFromRow(c.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f1652a = null;
            this.f1655d.clear();
            for (int i10 = 0; i10 < bVar.f1655d.getCurrentSize(); i10++) {
                this.f1655d.add(bVar.f1655d.getVariable(i10), bVar.f1655d.getVariableValue(i10), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.c.a
    public boolean isEmpty() {
        return this.f1652a == null && this.f1653b == 0.0f && this.f1655d.getCurrentSize() == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return a(null, solverVariable);
    }

    public void reset() {
        this.f1652a = null;
        this.f1655d.clear();
        this.f1653b = 0.0f;
        this.f1656e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r8 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r8.f1652a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r8.f1652a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = ac.c.B(r0, r1)
            float r1 = r8.f1653b
            r2 = 0
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L34
            java.lang.StringBuilder r0 = ac.c.r(r0)
            float r1 = r8.f1653b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L35
        L34:
            r1 = 0
        L35:
            androidx.constraintlayout.core.b$a r4 = r8.f1655d
            int r4 = r4.getCurrentSize()
        L3b:
            if (r2 >= r4) goto L9b
            androidx.constraintlayout.core.b$a r5 = r8.f1655d
            androidx.constraintlayout.core.SolverVariable r5 = r5.getVariable(r2)
            if (r5 != 0) goto L46
            goto L98
        L46:
            androidx.constraintlayout.core.b$a r6 = r8.f1655d
            float r6 = r6.getVariableValue(r2)
            int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r7 != 0) goto L51
            goto L98
        L51:
            java.lang.String r5 = r5.toString()
            if (r1 != 0) goto L62
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 >= 0) goto L75
            java.lang.String r1 = "- "
            java.lang.String r0 = ac.c.B(r0, r1)
            goto L71
        L62:
            if (r7 <= 0) goto L6b
            java.lang.String r1 = " + "
            java.lang.String r0 = ac.c.B(r0, r1)
            goto L75
        L6b:
            java.lang.String r1 = " - "
            java.lang.String r0 = ac.c.B(r0, r1)
        L71:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r6 = r6 * r1
        L75:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 != 0) goto L80
            java.lang.String r0 = ac.c.B(r0, r5)
            goto L97
        L80:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = r1.toString()
        L97:
            r1 = 1
        L98:
            int r2 = r2 + 1
            goto L3b
        L9b:
            if (r1 != 0) goto La3
            java.lang.String r1 = "0.0"
            java.lang.String r0 = ac.c.B(r0, r1)
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.b.toString():java.lang.String");
    }

    public void updateFromFinalVariable(c cVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f1630q) {
            return;
        }
        float f10 = this.f1655d.get(solverVariable);
        this.f1653b = (solverVariable.f1629p * f10) + this.f1653b;
        this.f1655d.remove(solverVariable, z10);
        if (z10) {
            solverVariable.removeFromRow(this);
        }
        if (this.f1655d.getCurrentSize() == 0) {
            this.f1656e = true;
            cVar.f1659a = true;
        }
    }

    public void updateFromRow(c cVar, b bVar, boolean z10) {
        float fUse = this.f1655d.use(bVar, z10);
        this.f1653b = (bVar.f1653b * fUse) + this.f1653b;
        if (z10) {
            bVar.f1652a.removeFromRow(this);
        }
        if (this.f1652a == null || this.f1655d.getCurrentSize() != 0) {
            return;
        }
        this.f1656e = true;
        cVar.f1659a = true;
    }

    public void updateFromSystem(c cVar) {
        ArrayList<SolverVariable> arrayList;
        if (cVar.f1664f.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int currentSize = this.f1655d.getCurrentSize();
            int i10 = 0;
            while (true) {
                arrayList = this.f1654c;
                if (i10 >= currentSize) {
                    break;
                }
                SolverVariable variable = this.f1655d.getVariable(i10);
                if (variable.f1627n != -1 || variable.f1630q) {
                    arrayList.add(variable);
                }
                i10++;
            }
            int size = arrayList.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    SolverVariable solverVariable = arrayList.get(i11);
                    if (solverVariable.f1630q) {
                        updateFromFinalVariable(cVar, solverVariable, true);
                    } else {
                        updateFromRow(cVar, cVar.f1664f[solverVariable.f1627n], true);
                    }
                }
                arrayList.clear();
            } else {
                z10 = true;
            }
        }
        if (this.f1652a == null || this.f1655d.getCurrentSize() != 0) {
            return;
        }
        this.f1656e = true;
        cVar.f1659a = true;
    }

    @Override // androidx.constraintlayout.core.c.a
    public void addError(SolverVariable solverVariable) {
        int i10 = solverVariable.f1628o;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f1655d.put(solverVariable, f10);
    }

    public b createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f1653b = i10;
        }
        if (!z10) {
            this.f1655d.put(solverVariable, -1.0f);
            this.f1655d.put(solverVariable2, 1.0f);
        } else {
            this.f1655d.put(solverVariable, 1.0f);
            this.f1655d.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public b(d0.a aVar) {
        this.f1655d = new androidx.constraintlayout.core.a(this, aVar);
    }
}
