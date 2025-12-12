package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f1657p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f1658q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public final d f1661c;

    /* renamed from: f, reason: collision with root package name */
    public b[] f1664f;

    /* renamed from: l, reason: collision with root package name */
    public final d0.a f1670l;

    /* renamed from: o, reason: collision with root package name */
    public b f1673o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1659a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f1660b = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1662d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f1663e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1665g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f1666h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f1667i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f1668j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1669k = 32;

    /* renamed from: m, reason: collision with root package name */
    public SolverVariable[] f1671m = new SolverVariable[f1658q];

    /* renamed from: n, reason: collision with root package name */
    public int f1672n = 0;

    /* compiled from: LinearSystem.java */
    public interface a {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getPivotCandidate(c cVar, boolean[] zArr);

        void initFromRow(a aVar);

        boolean isEmpty();
    }

    public c() {
        this.f1664f = null;
        this.f1664f = new b[32];
        for (int i10 = 0; i10 < this.f1668j; i10++) {
            b bVar = this.f1664f[i10];
            if (bVar != null) {
                this.f1670l.f10745a.release(bVar);
            }
            this.f1664f[i10] = null;
        }
        d0.a aVar = new d0.a();
        this.f1670l = aVar;
        this.f1661c = new d(aVar);
        this.f1673o = new b(aVar);
    }

    public static b createRowDimensionPercent(c cVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        b bVarCreateRow = cVar.createRow();
        bVarCreateRow.f1655d.put(solverVariable, -1.0f);
        bVarCreateRow.f1655d.put(solverVariable2, f10);
        return bVarCreateRow;
    }

    public static d0.b getMetrics() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.f1670l.f10746b.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.setType(type, str);
        } else {
            solverVariable.reset();
            solverVariable.setType(type, str);
        }
        int i10 = this.f1672n;
        int i11 = f1658q;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f1658q = i12;
            this.f1671m = (SolverVariable[]) Arrays.copyOf(this.f1671m, i12);
        }
        SolverVariable[] solverVariableArr = this.f1671m;
        int i13 = this.f1672n;
        this.f1672n = i13 + 1;
        solverVariableArr[i13] = solverVariable;
        return solverVariable;
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        b bVarCreateRow = createRow();
        double d10 = f10;
        double d11 = i10;
        bVarCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (Math.sin(d10) * d11));
        addConstraint(bVarCreateRow);
        b bVarCreateRow2 = createRow();
        bVarCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (Math.cos(d10) * d11));
        addConstraint(bVarCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        b bVarCreateRow = createRow();
        if (solverVariable2 == solverVariable3) {
            bVarCreateRow.f1655d.put(solverVariable, 1.0f);
            bVarCreateRow.f1655d.put(solverVariable4, 1.0f);
            bVarCreateRow.f1655d.put(solverVariable2, -2.0f);
        } else if (f10 == 0.5f) {
            bVarCreateRow.f1655d.put(solverVariable, 1.0f);
            bVarCreateRow.f1655d.put(solverVariable2, -1.0f);
            bVarCreateRow.f1655d.put(solverVariable3, -1.0f);
            bVarCreateRow.f1655d.put(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                bVarCreateRow.f1653b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            bVarCreateRow.f1655d.put(solverVariable, -1.0f);
            bVarCreateRow.f1655d.put(solverVariable2, 1.0f);
            bVarCreateRow.f1653b = i10;
        } else if (f10 >= 1.0f) {
            bVarCreateRow.f1655d.put(solverVariable4, -1.0f);
            bVarCreateRow.f1655d.put(solverVariable3, 1.0f);
            bVarCreateRow.f1653b = -i11;
        } else {
            float f11 = 1.0f - f10;
            bVarCreateRow.f1655d.put(solverVariable, f11 * 1.0f);
            bVarCreateRow.f1655d.put(solverVariable2, f11 * (-1.0f));
            bVarCreateRow.f1655d.put(solverVariable3, (-1.0f) * f10);
            bVarCreateRow.f1655d.put(solverVariable4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                bVarCreateRow.f1653b = (i11 * f10) + ((-i10) * f11);
            }
        }
        if (i12 != 8) {
            bVarCreateRow.addError(this, i12);
        }
        addConstraint(bVarCreateRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addConstraint(androidx.constraintlayout.core.b r17) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.c.addConstraint(androidx.constraintlayout.core.b):void");
    }

    public b addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (i11 == 8 && solverVariable2.f1630q && solverVariable.f1627n == -1) {
            solverVariable.setFinalValue(this, solverVariable2.f1629p + i10);
            return null;
        }
        b bVarCreateRow = createRow();
        bVarCreateRow.createRowEquals(solverVariable, solverVariable2, i10);
        if (i11 != 8) {
            bVarCreateRow.addError(this, i11);
        }
        addConstraint(bVarCreateRow);
        return bVarCreateRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        b bVarCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.f1628o = 0;
        bVarCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        addConstraint(bVarCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        b bVarCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.f1628o = 0;
        bVarCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        if (i11 != 8) {
            bVarCreateRow.f1655d.put(createErrorVariable(i11, null), (int) (bVarCreateRow.f1655d.get(solverVariableCreateSlackVariable) * (-1.0f)));
        }
        addConstraint(bVarCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        b bVarCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.f1628o = 0;
        bVarCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        addConstraint(bVarCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        b bVarCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.f1628o = 0;
        bVarCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        if (i11 != 8) {
            bVarCreateRow.f1655d.put(createErrorVariable(i11, null), (int) (bVarCreateRow.f1655d.get(solverVariableCreateSlackVariable) * (-1.0f)));
        }
        addConstraint(bVarCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        b bVarCreateRow = createRow();
        bVarCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            bVarCreateRow.addError(this, i10);
        }
        addConstraint(bVarCreateRow);
    }

    public final void b(b bVar) {
        int i10;
        if (bVar.f1656e) {
            bVar.f1652a.setFinalValue(this, bVar.f1653b);
        } else {
            b[] bVarArr = this.f1664f;
            int i11 = this.f1668j;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f1652a;
            solverVariable.f1627n = i11;
            this.f1668j = i11 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, bVar);
        }
        if (this.f1659a) {
            int i12 = 0;
            while (i12 < this.f1668j) {
                if (this.f1664f[i12] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f1664f[i12];
                if (bVar2 != null && bVar2.f1656e) {
                    bVar2.f1652a.setFinalValue(this, bVar2.f1653b);
                    this.f1670l.f10745a.release(bVar2);
                    this.f1664f[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f1668j;
                        if (i13 >= i10) {
                            break;
                        }
                        b[] bVarArr2 = this.f1664f;
                        int i15 = i13 - 1;
                        b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f1652a;
                        if (solverVariable2.f1627n == i13) {
                            solverVariable2.f1627n = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f1664f[i14] = null;
                    }
                    this.f1668j = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f1659a = false;
        }
    }

    public final void c() {
        for (int i10 = 0; i10 < this.f1668j; i10++) {
            b bVar = this.f1664f[i10];
            bVar.f1652a.f1629p = bVar.f1653b;
        }
    }

    public SolverVariable createErrorVariable(int i10, String str) {
        if (this.f1667i + 1 >= this.f1663e) {
            d();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        int i11 = this.f1660b + 1;
        this.f1660b = i11;
        this.f1667i++;
        solverVariableA.f1626m = i11;
        solverVariableA.f1628o = i10;
        this.f1670l.f10747c[i11] = solverVariableA;
        this.f1661c.addError(solverVariableA);
        return solverVariableA;
    }

    public SolverVariable createExtraVariable() {
        if (this.f1667i + 1 >= this.f1663e) {
            d();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f1660b + 1;
        this.f1660b = i10;
        this.f1667i++;
        solverVariableA.f1626m = i10;
        this.f1670l.f10747c[i10] = solverVariableA;
        return solverVariableA;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f1667i + 1 >= this.f1663e) {
            d();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            d0.a aVar = this.f1670l;
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(aVar);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i10 = solverVariable.f1626m;
            if (i10 == -1 || i10 > this.f1660b || aVar.f10747c[i10] == null) {
                if (i10 != -1) {
                    solverVariable.reset();
                }
                int i11 = this.f1660b + 1;
                this.f1660b = i11;
                this.f1667i++;
                solverVariable.f1626m = i11;
                solverVariable.f1633t = SolverVariable.Type.UNRESTRICTED;
                aVar.f10747c[i11] = solverVariable;
            }
        }
        return solverVariable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b createRow() {
        d0.a aVar = this.f1670l;
        b bVar = (b) aVar.f10745a.acquire();
        if (bVar == null) {
            return new b(aVar);
        }
        bVar.reset();
        return bVar;
    }

    public SolverVariable createSlackVariable() {
        if (this.f1667i + 1 >= this.f1663e) {
            d();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f1660b + 1;
        this.f1660b = i10;
        this.f1667i++;
        solverVariableA.f1626m = i10;
        this.f1670l.f10747c[i10] = solverVariableA;
        return solverVariableA;
    }

    public final void d() {
        int i10 = this.f1662d * 2;
        this.f1662d = i10;
        this.f1664f = (b[]) Arrays.copyOf(this.f1664f, i10);
        d0.a aVar = this.f1670l;
        aVar.f10747c = (SolverVariable[]) Arrays.copyOf(aVar.f10747c, this.f1662d);
        int i11 = this.f1662d;
        this.f1666h = new boolean[i11];
        this.f1663e = i11;
        this.f1669k = i11;
    }

    public final void e(d dVar) throws Exception {
        SolverVariable.Type type;
        float f10;
        int i10;
        boolean z10;
        int i11 = 0;
        while (true) {
            int i12 = this.f1668j;
            type = SolverVariable.Type.UNRESTRICTED;
            f10 = 0.0f;
            i10 = 1;
            if (i11 >= i12) {
                z10 = false;
                break;
            }
            b bVar = this.f1664f[i11];
            if (bVar.f1652a.f1633t != type && bVar.f1653b < 0.0f) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            boolean z11 = false;
            int i13 = 0;
            while (!z11) {
                i13 += i10;
                float f11 = Float.MAX_VALUE;
                int i14 = 0;
                int i15 = -1;
                int i16 = -1;
                int i17 = 0;
                while (i14 < this.f1668j) {
                    b bVar2 = this.f1664f[i14];
                    if (bVar2.f1652a.f1633t != type && !bVar2.f1656e && bVar2.f1653b < f10) {
                        int currentSize = bVar2.f1655d.getCurrentSize();
                        int i18 = 0;
                        while (i18 < currentSize) {
                            SolverVariable variable = bVar2.f1655d.getVariable(i18);
                            float f12 = bVar2.f1655d.get(variable);
                            if (f12 > f10) {
                                for (int i19 = 0; i19 < 9; i19++) {
                                    float f13 = variable.f1631r[i19] / f12;
                                    if ((f13 < f11 && i19 == i17) || i19 > i17) {
                                        i16 = variable.f1626m;
                                        i17 = i19;
                                        f11 = f13;
                                        i15 = i14;
                                    }
                                }
                            }
                            i18++;
                            f10 = 0.0f;
                        }
                    }
                    i14++;
                    f10 = 0.0f;
                }
                if (i15 != -1) {
                    b bVar3 = this.f1664f[i15];
                    bVar3.f1652a.f1627n = -1;
                    bVar3.b(this.f1670l.f10747c[i16]);
                    SolverVariable solverVariable = bVar3.f1652a;
                    solverVariable.f1627n = i15;
                    solverVariable.updateReferencesWithNewDefinition(this, bVar3);
                } else {
                    z11 = true;
                }
                if (i13 > this.f1667i / 2) {
                    z11 = true;
                }
                f10 = 0.0f;
                i10 = 1;
            }
        }
        f(dVar);
        c();
    }

    public final void f(b bVar) {
        for (int i10 = 0; i10 < this.f1667i; i10++) {
            this.f1666h[i10] = false;
        }
        boolean z10 = false;
        int i11 = 0;
        while (!z10) {
            i11++;
            if (i11 >= this.f1667i * 2) {
                return;
            }
            if (bVar.getKey() != null) {
                this.f1666h[bVar.getKey().f1626m] = true;
            }
            SolverVariable pivotCandidate = bVar.getPivotCandidate(this, this.f1666h);
            if (pivotCandidate != null) {
                boolean[] zArr = this.f1666h;
                int i12 = pivotCandidate.f1626m;
                if (zArr[i12]) {
                    return;
                } else {
                    zArr[i12] = true;
                }
            }
            if (pivotCandidate != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f1668j; i14++) {
                    b bVar2 = this.f1664f[i14];
                    if (bVar2.f1652a.f1633t != SolverVariable.Type.UNRESTRICTED && !bVar2.f1656e && bVar2.f1655d.contains(pivotCandidate)) {
                        float f11 = bVar2.f1655d.get(pivotCandidate);
                        if (f11 < 0.0f) {
                            float f12 = (-bVar2.f1653b) / f11;
                            if (f12 < f10) {
                                i13 = i14;
                                f10 = f12;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    b bVar3 = this.f1664f[i13];
                    bVar3.f1652a.f1627n = -1;
                    bVar3.b(pivotCandidate);
                    SolverVariable solverVariable = bVar3.f1652a;
                    solverVariable.f1627n = i13;
                    solverVariable.updateReferencesWithNewDefinition(this, bVar3);
                }
            } else {
                z10 = true;
            }
        }
    }

    public d0.a getCache() {
        return this.f1670l;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.f1629p + 0.5f);
        }
        return 0;
    }

    public void minimize() throws Exception {
        d dVar = this.f1661c;
        if (dVar.isEmpty()) {
            c();
            return;
        }
        if (!this.f1665g) {
            e(dVar);
            return;
        }
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f1668j) {
                z10 = true;
                break;
            } else if (!this.f1664f[i10].f1656e) {
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            c();
        } else {
            e(dVar);
        }
    }

    public void reset() {
        d0.a aVar;
        int i10 = 0;
        while (true) {
            aVar = this.f1670l;
            SolverVariable[] solverVariableArr = aVar.f10747c;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i10++;
        }
        aVar.f10746b.releaseAll(this.f1671m, this.f1672n);
        this.f1672n = 0;
        Arrays.fill(aVar.f10747c, (Object) null);
        this.f1660b = 0;
        this.f1661c.clear();
        this.f1667i = 1;
        for (int i11 = 0; i11 < this.f1668j; i11++) {
            b bVar = this.f1664f[i11];
        }
        for (int i12 = 0; i12 < this.f1668j; i12++) {
            b bVar2 = this.f1664f[i12];
            if (bVar2 != null) {
                aVar.f10745a.release(bVar2);
            }
            this.f1664f[i12] = null;
        }
        this.f1668j = 0;
        this.f1673o = new b(aVar);
    }

    public void addEquality(SolverVariable solverVariable, int i10) {
        int i11 = solverVariable.f1627n;
        if (i11 == -1) {
            solverVariable.setFinalValue(this, i10);
            for (int i12 = 0; i12 < this.f1660b + 1; i12++) {
                SolverVariable solverVariable2 = this.f1670l.f10747c[i12];
            }
            return;
        }
        if (i11 != -1) {
            b bVar = this.f1664f[i11];
            if (bVar.f1656e) {
                bVar.f1653b = i10;
                return;
            }
            if (bVar.f1655d.getCurrentSize() == 0) {
                bVar.f1656e = true;
                bVar.f1653b = i10;
                return;
            } else {
                b bVarCreateRow = createRow();
                bVarCreateRow.createRowEquals(solverVariable, i10);
                addConstraint(bVarCreateRow);
                return;
            }
        }
        b bVarCreateRow2 = createRow();
        bVarCreateRow2.f1652a = solverVariable;
        float f10 = i10;
        solverVariable.f1629p = f10;
        bVarCreateRow2.f1653b = f10;
        bVarCreateRow2.f1656e = true;
        addConstraint(bVarCreateRow2);
    }
}
