package com.fasterxml.jackson.core.sym;

/* loaded from: classes.dex */
public final class Name3 extends Name {

    /* renamed from: q1, reason: collision with root package name */
    private final int f5592q1;

    /* renamed from: q2, reason: collision with root package name */
    private final int f5593q2;

    /* renamed from: q3, reason: collision with root package name */
    private final int f5594q3;

    public Name3(String str, int i10, int i11, int i12, int i13) {
        super(str, i10);
        this.f5592q1 = i11;
        this.f5593q2 = i12;
        this.f5594q3 = i13;
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
        return this.f5592q1 == i10 && this.f5593q2 == i11 && this.f5594q3 == i12;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i10) {
        return i10 == 3 && iArr[0] == this.f5592q1 && iArr[1] == this.f5593q2 && iArr[2] == this.f5594q3;
    }
}
