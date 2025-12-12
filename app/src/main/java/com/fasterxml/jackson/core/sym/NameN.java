package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class NameN extends Name {

    /* renamed from: q, reason: collision with root package name */
    private final int[] f5595q;

    /* renamed from: q1, reason: collision with root package name */
    private final int f5596q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f5597q2;

    /* renamed from: q3, reason: collision with root package name */
    private final int f5598q3;

    /* renamed from: q4, reason: collision with root package name */
    private final int f5599q4;
    private final int qlen;

    public NameN(String str, int i10, int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        super(str, i10);
        this.f5596q1 = i11;
        this.f5597q2 = i12;
        this.f5598q3 = i13;
        this.f5599q4 = i14;
        this.f5595q = iArr;
        this.qlen = i15;
    }

    private final boolean _equals2(int[] iArr) {
        int i10 = this.qlen - 4;
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11 + 4] != this.f5595q[i11]) {
                return false;
            }
        }
        return true;
    }

    public static NameN construct(String str, int i10, int[] iArr, int i11) {
        if (i11 >= 4) {
            return new NameN(str, i10, iArr[0], iArr[1], iArr[2], iArr[3], i11 + (-4) > 0 ? Arrays.copyOfRange(iArr, 4, i11) : null, i11);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i10) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i10, int i11) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i10, int i11, int i12) {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i10) {
        if (i10 != this.qlen || iArr[0] != this.f5596q1 || iArr[1] != this.f5597q2 || iArr[2] != this.f5598q3 || iArr[3] != this.f5599q4) {
            return false;
        }
        switch (i10) {
            case 5:
                if (iArr[4] == this.f5595q[0]) {
                }
                break;
            case 6:
                if (iArr[5] != this.f5595q[1]) {
                }
                if (iArr[4] == this.f5595q[0]) {
                }
                break;
            case 7:
                if (iArr[6] != this.f5595q[2]) {
                }
                if (iArr[5] != this.f5595q[1]) {
                }
                if (iArr[4] == this.f5595q[0]) {
                }
                break;
            case 8:
                if (iArr[7] != this.f5595q[3]) {
                }
                if (iArr[6] != this.f5595q[2]) {
                }
                if (iArr[5] != this.f5595q[1]) {
                }
                if (iArr[4] == this.f5595q[0]) {
                }
                break;
        }
        return false;
    }
}
