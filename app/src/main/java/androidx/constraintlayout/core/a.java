package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public final class a implements b.a {

    /* renamed from: b, reason: collision with root package name */
    public final b f1643b;

    /* renamed from: c, reason: collision with root package name */
    public final d0.a f1644c;

    /* renamed from: a, reason: collision with root package name */
    public int f1642a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1645d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1646e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f1647f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f1648g = new float[8];

    /* renamed from: h, reason: collision with root package name */
    public int f1649h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1650i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1651j = false;

    public a(b bVar, d0.a aVar) {
        this.f1643b = bVar;
        this.f1644c = aVar;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void add(SolverVariable solverVariable, float f10, boolean z10) {
        if (f10 <= -0.001f || f10 >= 0.001f) {
            int i10 = this.f1649h;
            b bVar = this.f1643b;
            if (i10 == -1) {
                this.f1649h = 0;
                this.f1648g[0] = f10;
                this.f1646e[0] = solverVariable.f1626m;
                this.f1647f[0] = -1;
                solverVariable.f1636w++;
                solverVariable.addToRow(bVar);
                this.f1642a++;
                if (this.f1651j) {
                    return;
                }
                int i11 = this.f1650i + 1;
                this.f1650i = i11;
                int[] iArr = this.f1646e;
                if (i11 >= iArr.length) {
                    this.f1651j = true;
                    this.f1650i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f1642a; i13++) {
                int i14 = this.f1646e[i10];
                int i15 = solverVariable.f1626m;
                if (i14 == i15) {
                    float[] fArr = this.f1648g;
                    float f11 = fArr[i10] + f10;
                    if (f11 > -0.001f && f11 < 0.001f) {
                        f11 = 0.0f;
                    }
                    fArr[i10] = f11;
                    if (f11 == 0.0f) {
                        if (i10 == this.f1649h) {
                            this.f1649h = this.f1647f[i10];
                        } else {
                            int[] iArr2 = this.f1647f;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z10) {
                            solverVariable.removeFromRow(bVar);
                        }
                        if (this.f1651j) {
                            this.f1650i = i10;
                        }
                        solverVariable.f1636w--;
                        this.f1642a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f1647f[i10];
            }
            int length = this.f1650i;
            int i16 = length + 1;
            if (this.f1651j) {
                int[] iArr3 = this.f1646e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i16;
            }
            int[] iArr4 = this.f1646e;
            if (length >= iArr4.length && this.f1642a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.f1646e;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        length = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.f1646e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i18 = this.f1645d * 2;
                this.f1645d = i18;
                this.f1651j = false;
                this.f1650i = length - 1;
                this.f1648g = Arrays.copyOf(this.f1648g, i18);
                this.f1646e = Arrays.copyOf(this.f1646e, this.f1645d);
                this.f1647f = Arrays.copyOf(this.f1647f, this.f1645d);
            }
            this.f1646e[length] = solverVariable.f1626m;
            this.f1648g[length] = f10;
            if (i12 != -1) {
                int[] iArr7 = this.f1647f;
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                this.f1647f[length] = this.f1649h;
                this.f1649h = length;
            }
            solverVariable.f1636w++;
            solverVariable.addToRow(bVar);
            this.f1642a++;
            if (!this.f1651j) {
                this.f1650i++;
            }
            int i19 = this.f1650i;
            int[] iArr8 = this.f1646e;
            if (i19 >= iArr8.length) {
                this.f1651j = true;
                this.f1650i = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i10 = this.f1649h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1642a; i11++) {
            SolverVariable solverVariable = this.f1644c.f10747c[this.f1646e[i10]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.f1643b);
            }
            i10 = this.f1647f[i10];
        }
        this.f1649h = -1;
        this.f1650i = -1;
        this.f1651j = false;
        this.f1642a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean contains(SolverVariable solverVariable) {
        int i10 = this.f1649h;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f1642a; i11++) {
            if (this.f1646e[i10] == solverVariable.f1626m) {
                return true;
            }
            i10 = this.f1647f[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void divideByAmount(float f10) {
        int i10 = this.f1649h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1642a; i11++) {
            float[] fArr = this.f1648g;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f1647f[i10];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float get(SolverVariable solverVariable) {
        int i10 = this.f1649h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1642a; i11++) {
            if (this.f1646e[i10] == solverVariable.f1626m) {
                return this.f1648g[i10];
            }
            i10 = this.f1647f[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int getCurrentSize() {
        return this.f1642a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable getVariable(int i10) {
        int i11 = this.f1649h;
        for (int i12 = 0; i11 != -1 && i12 < this.f1642a; i12++) {
            if (i12 == i10) {
                return this.f1644c.f10747c[this.f1646e[i11]];
            }
            i11 = this.f1647f[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float getVariableValue(int i10) {
        int i11 = this.f1649h;
        for (int i12 = 0; i11 != -1 && i12 < this.f1642a; i12++) {
            if (i12 == i10) {
                return this.f1648g[i11];
            }
            i11 = this.f1647f[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void invert() {
        int i10 = this.f1649h;
        for (int i11 = 0; i10 != -1 && i11 < this.f1642a; i11++) {
            float[] fArr = this.f1648g;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f1647f[i10];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void put(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i10 = this.f1649h;
        b bVar = this.f1643b;
        if (i10 == -1) {
            this.f1649h = 0;
            this.f1648g[0] = f10;
            this.f1646e[0] = solverVariable.f1626m;
            this.f1647f[0] = -1;
            solverVariable.f1636w++;
            solverVariable.addToRow(bVar);
            this.f1642a++;
            if (this.f1651j) {
                return;
            }
            int i11 = this.f1650i + 1;
            this.f1650i = i11;
            int[] iArr = this.f1646e;
            if (i11 >= iArr.length) {
                this.f1651j = true;
                this.f1650i = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f1642a; i13++) {
            int i14 = this.f1646e[i10];
            int i15 = solverVariable.f1626m;
            if (i14 == i15) {
                this.f1648g[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f1647f[i10];
        }
        int length = this.f1650i;
        int i16 = length + 1;
        if (this.f1651j) {
            int[] iArr2 = this.f1646e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.f1646e;
        if (length >= iArr3.length && this.f1642a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f1646e;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.f1646e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.f1645d * 2;
            this.f1645d = i18;
            this.f1651j = false;
            this.f1650i = length - 1;
            this.f1648g = Arrays.copyOf(this.f1648g, i18);
            this.f1646e = Arrays.copyOf(this.f1646e, this.f1645d);
            this.f1647f = Arrays.copyOf(this.f1647f, this.f1645d);
        }
        this.f1646e[length] = solverVariable.f1626m;
        this.f1648g[length] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f1647f;
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            this.f1647f[length] = this.f1649h;
            this.f1649h = length;
        }
        solverVariable.f1636w++;
        solverVariable.addToRow(bVar);
        int i19 = this.f1642a + 1;
        this.f1642a = i19;
        if (!this.f1651j) {
            this.f1650i++;
        }
        int[] iArr7 = this.f1646e;
        if (i19 >= iArr7.length) {
            this.f1651j = true;
        }
        if (this.f1650i >= iArr7.length) {
            this.f1651j = true;
            this.f1650i = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float remove(SolverVariable solverVariable, boolean z10) {
        int i10 = this.f1649h;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f1642a) {
            if (this.f1646e[i10] == solverVariable.f1626m) {
                if (i10 == this.f1649h) {
                    this.f1649h = this.f1647f[i10];
                } else {
                    int[] iArr = this.f1647f;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.removeFromRow(this.f1643b);
                }
                solverVariable.f1636w--;
                this.f1642a--;
                this.f1646e[i10] = -1;
                if (this.f1651j) {
                    this.f1650i = i10;
                }
                return this.f1648g[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f1647f[i10];
        }
        return 0.0f;
    }

    public String toString() {
        int i10 = this.f1649h;
        String string = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f1642a; i11++) {
            StringBuilder sbR = ac.c.r(ac.c.B(string, " -> "));
            sbR.append(this.f1648g[i10]);
            sbR.append(" : ");
            StringBuilder sbR2 = ac.c.r(sbR.toString());
            sbR2.append(this.f1644c.f10747c[this.f1646e[i10]]);
            string = sbR2.toString();
            i10 = this.f1647f[i10];
        }
        return string;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float use(b bVar, boolean z10) {
        float f10 = get(bVar.f1652a);
        remove(bVar.f1652a, z10);
        b.a aVar = bVar.f1655d;
        int currentSize = aVar.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable variable = aVar.getVariable(i10);
            add(variable, aVar.get(variable) * f10, z10);
        }
        return f10;
    }
}
