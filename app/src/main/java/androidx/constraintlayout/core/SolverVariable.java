package androidx.constraintlayout.core;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1625b;

    /* renamed from: p, reason: collision with root package name */
    public float f1629p;

    /* renamed from: t, reason: collision with root package name */
    public Type f1633t;

    /* renamed from: m, reason: collision with root package name */
    public int f1626m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f1627n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f1628o = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1630q = false;

    /* renamed from: r, reason: collision with root package name */
    public final float[] f1631r = new float[9];

    /* renamed from: s, reason: collision with root package name */
    public final float[] f1632s = new float[9];

    /* renamed from: u, reason: collision with root package name */
    public b[] f1634u = new b[16];

    /* renamed from: v, reason: collision with root package name */
    public int f1635v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f1636w = 0;

    public enum Type {
        UNRESTRICTED,
        /* JADX INFO: Fake field, exist only in values array */
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f1633t = type;
    }

    public final void addToRow(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f1635v;
            if (i10 >= i11) {
                b[] bVarArr = this.f1634u;
                if (i11 >= bVarArr.length) {
                    this.f1634u = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1634u;
                int i12 = this.f1635v;
                bVarArr2[i12] = bVar;
                this.f1635v = i12 + 1;
                return;
            }
            if (this.f1634u[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void removeFromRow(b bVar) {
        int i10 = this.f1635v;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f1634u[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f1634u;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f1635v--;
                return;
            }
            i11++;
        }
    }

    public void reset() {
        this.f1633t = Type.UNKNOWN;
        this.f1628o = 0;
        this.f1626m = -1;
        this.f1627n = -1;
        this.f1629p = 0.0f;
        this.f1630q = false;
        int i10 = this.f1635v;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1634u[i11] = null;
        }
        this.f1635v = 0;
        this.f1636w = 0;
        this.f1625b = false;
        Arrays.fill(this.f1632s, 0.0f);
    }

    public void setFinalValue(c cVar, float f10) {
        this.f1629p = f10;
        this.f1630q = true;
        int i10 = this.f1635v;
        this.f1627n = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1634u[i11].updateFromFinalVariable(cVar, this, false);
        }
        this.f1635v = 0;
    }

    public void setType(Type type, String str) {
        this.f1633t = type;
    }

    public String toString() {
        return "" + this.f1626m;
    }

    public final void updateReferencesWithNewDefinition(c cVar, b bVar) {
        int i10 = this.f1635v;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1634u[i11].updateFromRow(cVar, bVar, false);
        }
        this.f1635v = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.f1626m - solverVariable.f1626m;
    }
}
